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
import com.nineinfosys.electricityconverter.Engin.SurfaceChargeDensityConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionSurfaceChargeListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strCoulombpersquaremeter = null;
    private String strCoulombpersquarecentimeter = null;
    private String strCoulombpersquareinch = null;
    private  String strAbcoulombpersquaremeter = null;
    private String strAbcoulombpersquarecentimeter = null;
    private String strAbcoulombpersquareinch = null;
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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }

        MobileAds.initialize(ConversionSurfaceChargeListActivity.this, getString(R.string.ads_app_id));
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
            case "Coulomb/square meter - C/m²":
                textconversionFrom.setText("Coulomb/square meter");
                textViewConversionShortform.setText("C/m²");
                break;
            case "Coulomb/square centimeter - C/cm²":
                textconversionFrom.setText("Coulomb/square centimeter");
                textViewConversionShortform.setText("C/cm²");
                break;
            case "Coulomb/square inch - C/in²":
                textconversionFrom.setText("Coulomb/square inch");
                textViewConversionShortform.setText("C/in²");
                break;
            case "Abcoulomb/square meter - abC/m²":
                textconversionFrom.setText("Abcoulomb/square meter");
                textViewConversionShortform.setText("abC/m²");
                break;
            case  "Abcoulomb/square centimeter - abC/cm²":
                textconversionFrom.setText("Abcoulomb/square centimeter");
                textViewConversionShortform.setText("abC/cm²");
                break;

            case  "Abcoulomb/square inch - abC/in²":
                textconversionFrom.setText("Abcoulomb/square inch");
                textViewConversionShortform.setText("abC/in²");
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
        SurfaceChargeDensityConverter c = new SurfaceChargeDensityConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<SurfaceChargeDensityConverter.ConversionResults> results = c.calculateSurfaceChargeDensityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            SurfaceChargeDensityConverter.ConversionResults item = results.get(i);

            strCoulombpersquaremeter = String.valueOf(formatter.format(item.getCoulombsquaremeter()));
            strCoulombpersquarecentimeter =String.valueOf(formatter.format(item.getCoulombpersquarecentimeter()));
            strCoulombpersquareinch =String.valueOf(formatter.format(item.getCoulombpersquareinch()));
            strAbcoulombpersquaremeter =String.valueOf(formatter.format(item.getAbcoulombpersquaremeter()));
            strAbcoulombpersquarecentimeter = String.valueOf(formatter.format(item.getAbcoulombpersquarecentimeter()));
            strAbcoulombpersquareinch =String.valueOf(formatter.format(item.getAbcoulombpersquareinch()));



            list.add(new ItemList("C/m²","Coulomb/square meter",strCoulombpersquaremeter,"C/m²"));
            list.add(new ItemList("C/cm²","Coulomb/square centimeter",strCoulombpersquarecentimeter,"C/cm²"));
            list.add(new ItemList("C/in²","Coulomb/square inch",strCoulombpersquareinch,"C/in²"));
            list.add(new ItemList("abC/m²","Abcoulomb/square meter",strAbcoulombpersquaremeter,"abC/m²"));
            list.add(new ItemList("abC/cm²","Abcoulomb/square centimeter",strAbcoulombpersquarecentimeter,"abC/cm²"));
            list.add(new ItemList("abC/in²","Abcoulomb/square inch ",strAbcoulombpersquareinch,"abC/in²"));



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
