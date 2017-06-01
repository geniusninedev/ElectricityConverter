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
import com.nineinfosys.electricityconverter.Engin.SurfaceCurrentDensityConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SurfaceCurrentDensityListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strAmperepersquaremeter = null;
    private String strAmperepersquarecentimeter = null;
    private String strAmperepersquareinch = null;
    private  String strAmperepersquaremil = null;
    private String strAmperecicularmil = null;
    private String strAbamperepersquarecentimeter = null;

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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff6d00")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#c43c00"));
        }

        MobileAds.initialize(SurfaceCurrentDensityListActivity.this, getString(R.string.ads_app_id));
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
            case "Ampere/square meter - A/m²":
                textconversionFrom.setText("Ampere/square meter");
                textViewConversionShortform.setText("A/m²");
                break;
            case "Ampere/square centimeter - A/cm²":
                textconversionFrom.setText("Ampere/square centimeter");
                textViewConversionShortform.setText("A/cm²");
                break;
            case "Ampere/square inch - A/in²":
                textconversionFrom.setText("Ampere/square inch");
                textViewConversionShortform.setText("A/in²");
                break;
            case "Ampere/square mil - A/mil²":
                textconversionFrom.setText("Ampere/square mil");
                textViewConversionShortform.setText("A/mil²");
                break;


            case "Ampere/cicular mil - A/mil":
                textconversionFrom.setText("Ampere/cicular mil");
                textViewConversionShortform.setText("A/mil");
                break;

            case  "Abampere/square centimeter - abA/cm²":
                textconversionFrom.setText("Abampere/square centimeter");
                textViewConversionShortform.setText("abA/cm²");
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
        SurfaceCurrentDensityConverter c = new SurfaceCurrentDensityConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<SurfaceCurrentDensityConverter.ConversionResults> results = c.calculateSurfaceCurrentDensityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            SurfaceCurrentDensityConverter.ConversionResults item = results.get(i);

            strAmperepersquaremeter = String.valueOf(formatter.format(item.getAmperesquaremeter()));
            strAmperepersquarecentimeter =String.valueOf(formatter.format(item.getAmperepersquarecentimeter()));
            strAmperepersquareinch =String.valueOf(formatter.format(item.getAmperepersquareinch()));
            strAmperepersquaremil =String.valueOf(formatter.format(item.getAmperepersquaremil()));
            strAmperecicularmil = String.valueOf(formatter.format(item.getAmperepercicularmil()));
            strAbamperepersquarecentimeter =String.valueOf(formatter.format(item.getAmperepersquarecentimeter()));

            list.add(new ItemList("A/m²","Ampere/square meter",strAmperepersquaremeter,"A/m²"));
            list.add(new ItemList("A/cm²","Ampere/square centimeter",strAmperepersquarecentimeter,"A/cm²"));
            list.add(new ItemList("A/in²","Ampere/square inch",strAmperepersquareinch,"A/in²"));
            list.add(new ItemList("A/mil²","Ampere/square mil",strAmperepersquaremil,"A/mil²"));
            list.add(new ItemList("A/mil","Ampere/cicular mil",strAmperecicularmil,"abA/cm"));
            list.add(new ItemList("abA/cm²","Abampere/square centimeter",strAbamperepersquarecentimeter,"abA/cm²"));



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
