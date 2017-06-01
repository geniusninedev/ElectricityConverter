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
import com.nineinfosys.electricityconverter.Engin.LinearCurrentDensityConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LinearCurrentDensityListActivity extends AppCompatActivity implements TextWatcher {

   private List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strAmperepermeter = null;
    private String strAmperepercentimeter = null;
    private String strAmpereperinch = null;
    private  String strAbamperepermeter = null;
    private String strAbamperepercentimeter = null;
    private String strAbampereperinch = null;

    private String strOersted = null;
    private String strGilbertpercentimeter = null;

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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5a84b7")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#265887"));
        }

        MobileAds.initialize(LinearCurrentDensityListActivity.this, getString(R.string.ads_app_id));
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
            case "Ampere/meter - A/m":
                textconversionFrom.setText("Ampere/meter");
                textViewConversionShortform.setText("A/m");
                break;
            case "Ampere/centimeter - A/cm":
                textconversionFrom.setText("Ampere/centimeter");
                textViewConversionShortform.setText("A/cm");
                break;
            case "Ampere/inch - A/in":
                textconversionFrom.setText("Ampere/inch");
                textViewConversionShortform.setText("A/in");
                break;
            case "Abampere/meter - abA/m":
                textconversionFrom.setText("Abampere/meter");
                textViewConversionShortform.setText("abA/m");
                break;
            case  "Abampere/centimeter - abA/cm":
                textconversionFrom.setText("Abampere/centimeter");
                textViewConversionShortform.setText("abA/cm");
                break;

            case  "Abampere/inch - abA/in":
                textconversionFrom.setText("Abampere/inch");
                textViewConversionShortform.setText("abA/in");
                break;
            case  "Oersted - Oe":
                textconversionFrom.setText("Oersted");
                textViewConversionShortform.setText("Oe");
                break;

            case  "Gilbert/centimeter - Gi/cm":
                textconversionFrom.setText("Gilbert/centimeter");
                textViewConversionShortform.setText("Gi/cm");
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
        LinearCurrentDensityConverter c = new LinearCurrentDensityConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<LinearCurrentDensityConverter.ConversionResults> results = c.calculateLinearCurrentDensityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            LinearCurrentDensityConverter.ConversionResults item = results.get(i);

            strAmperepermeter = String.valueOf(formatter.format(item.getAmperepermeter()));
            strAmperepercentimeter =String.valueOf(formatter.format(item.getAmperepercentimeter()));
            strAmpereperinch =String.valueOf(formatter.format(item.getAmpereperinch()));
            strAbamperepermeter =String.valueOf(formatter.format(item.getAbamperepermeter()));
            strAbamperepercentimeter = String.valueOf(formatter.format(item.getAbamperepercentimeter()));
            strAbampereperinch =String.valueOf(formatter.format(item.getAbampereperinch()));
            strOersted = String.valueOf(formatter.format(item.getOersted()));
            strGilbertpercentimeter =String.valueOf(formatter.format(item.getGilbertpercentimeter()));



            list.add(new ItemList("A/m","Ampere/meter",strAmperepermeter,"A/m"));
            list.add(new ItemList("A/cm","Ampere/centimeter",strAmperepercentimeter,"A/cm"));
            list.add(new ItemList("A/in","Ampere/inch",strAmpereperinch,"A/in"));
            list.add(new ItemList("abA/m","Abampere/meter",strAbamperepermeter,"abA/m"));
            list.add(new ItemList("abA/cm","Abampere/centimeter",strAbamperepercentimeter,"abA/cm"));
            list.add(new ItemList("abA/in","Abampere/inch",strAbampereperinch,"abA/in"));

            list.add(new ItemList("Oe","Oersted",strOersted,"Oe"));
            list.add(new ItemList("Gi/cm","Gilbert/centimeter",strGilbertpercentimeter,"Gi/cm"));


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

