package com.nineinfosys.electricityconverter.ConverterActivityList;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.electricityconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.electricityconverter.Engin.VolumeChargeDensityConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionVolumeChargeDensityListActivity extends AppCompatActivity implements TextWatcher {

   private List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strCoulombpercubicmeter = null;
    private String strCoulombpercubiccentimeter = null;
    private String strCoulombpercubicinch = null;
    private  String strAbcoulombpercubicmeter = null;
    private String strAbcoulombpercubiccentimeter = null;
    private String strAbcoulombpercubicinch = null;
    DecimalFormat formatter = null;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e65f21")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#a02a00"));
        }

        MobileAds.initialize(ConversionVolumeChargeDensityListActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverterList);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //format of decimal pint
        formatsetting();


        edittextConversionListvalue=(EditText)findViewById(R.id.edittextConversionListvalue) ;
        textconversionFrom=(TextView) findViewById(R.id.textViewConversionFrom) ;
        textViewConversionShortform=(TextView) findViewById(R.id.textViewConversionShortform) ;

        //get the value from temperture activity
        stringSpinnerFrom = getIntent().getExtras().getString("stringSpinnerFrom");
        doubleEdittextvalue= getIntent().getExtras().getDouble("doubleEdittextvalue");
        edittextConversionListvalue.setText(String.valueOf(doubleEdittextvalue));

        NamesAndShortform(stringSpinnerFrom);

        //   Toast.makeText(this,"string1 "+stringSpinnerFrom,Toast.LENGTH_LONG).show();
        rowListItem = getAllunitValue(stringSpinnerFrom,doubleEdittextvalue);

        //Initializing Views
        rView = (RecyclerView) findViewById(R.id.recyclerViewConverterList);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(this, 1));


        //Initializing our superheroes list
        rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem);
        rView.setAdapter(rcAdapter);

        edittextConversionListvalue.addTextChangedListener(this);



    }

    private void NamesAndShortform(String stringSpinnerFrom) {
        switch (stringSpinnerFrom) {
            case "Coulomb/cubic meter - C/m³":
                textconversionFrom.setText("Coulomb/cubic meter");
                textViewConversionShortform.setText("C/m³");
                break;
            case "Coulomb/cubic centimeter - C/cm³":
                textconversionFrom.setText("Coulomb/cubic centimeter");
                textViewConversionShortform.setText("C/cm³");
                break;
            case "Coulomb/cubic inch - C/in³":
                textconversionFrom.setText("Coulomb/cubic inch");
                textViewConversionShortform.setText("C/in³");
                break;
            case "Abcoulomb/cubic meter - abC/m³":
                textconversionFrom.setText("Abcoulomb/cubic meter");
                textViewConversionShortform.setText("abC/m³");
                break;
            case  "Abcoulomb/cubic centimeter - abC/cm³":
                textconversionFrom.setText("Abcoulomb/cubic centimeter");
                textViewConversionShortform.setText("abC/cm³");
                break;

            case  "Abcoulomb/cubic inch - abC/in³":
                textconversionFrom.setText("Abcoulomb/cubic inch");
                textViewConversionShortform.setText("abC/in³");
                break;


        }
    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences =this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String  FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF,"Thousands separator");
        String DecimalplaceString= sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF,"2");
        Settings settings=new Settings(FormattedString,DecimalplaceString);
        formatter= settings.setting();
    }

    private List<ItemList> getAllunitValue(String strSpinnerFrom,double doubleEdittextvalue1) {
        VolumeChargeDensityConverter c = new VolumeChargeDensityConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<VolumeChargeDensityConverter.ConversionResults> results = c.calculateVolumeChargeDensityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            VolumeChargeDensityConverter.ConversionResults item = results.get(i);

            strCoulombpercubicmeter = String.valueOf(formatter.format(item.getCoulombcubicmeter()));
            strCoulombpercubiccentimeter =String.valueOf(formatter.format(item.getCoulombpercubiccentimeter()));
            strCoulombpercubicinch =String.valueOf(formatter.format(item.getCoulombpercubicinch()));
            strAbcoulombpercubicmeter =String.valueOf(formatter.format(item.getAbcoulombpercubicmeter()));
            strAbcoulombpercubiccentimeter = String.valueOf(formatter.format(item.getAbcoulombpercubiccentimeter()));
            strAbcoulombpercubicinch =String.valueOf(formatter.format(item.getAbcoulombpercubicinch()));



            list.add(new ItemList("C/m³","Coulomb/cubic meter",strCoulombpercubicmeter,"C/m³"));
            list.add(new ItemList("C/cm³","Coulomb/cubic centimeter",strCoulombpercubiccentimeter,"C/cm³"));
            list.add(new ItemList("C/in³","Coulomb/cubic inch",strCoulombpercubicinch,"C/in³"));
            list.add(new ItemList("abC/m³","Abcoulomb/cubic meter",strAbcoulombpercubicmeter,"abC/m³"));
            list.add(new ItemList("abC/cm³","Abcoulomb/cubic centimeter",strAbcoulombpercubiccentimeter,"abC/cm³"));
            list.add(new ItemList("abC/in³","Abcoulomb/cubic inch ",strAbcoulombpercubicinch,"abC/in³"));



        }
        return list;

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        rowListItem.clear();
        try {

            double value = Double.parseDouble(edittextConversionListvalue.getText().toString().trim());

            rowListItem1 = getAllunitValue(stringSpinnerFrom,value);


            rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem1);
            rView.setAdapter(rcAdapter);

        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                this.finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
