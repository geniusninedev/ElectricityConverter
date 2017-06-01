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
import com.nineinfosys.electricityconverter.Engin.ChargeConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChargeConverterListActivity extends AppCompatActivity implements TextWatcher {

    private List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strCoulomb = null;
    private String strMegacoulomb = null;
    private String strKilocoulomb = null;
    private String strMillicoulomb = null;
    private  String strMicrocoulomb = null;
    private String strNanocoulomb = null;
    private String strPicocoulomb = null;
    private String strAbcoulomb = null;
    private String strEMUofcharge = null;
    private String strStatcoulomb = null;
    private String strESUofcharge = null;
    private String strFranklin = null;
    private  String strAmperehour = null;
    private String strAmperesecond = null;
    private String strAmpereminute = null;
    private  String strFaraday = null;
    private String strElementarycharge = null;


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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2eaf46")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007e17"));
        }

        MobileAds.initialize(ChargeConverterListActivity.this, getString(R.string.ads_app_id));
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
            case "Coulomb - C":
                textconversionFrom.setText("Coulomb");
                textViewConversionShortform.setText("C");
                break;
            case "Megacoulomb - MC":
                textconversionFrom.setText("Megacoulomb");
                textViewConversionShortform.setText("MC");
                break;
            case "Kilocoulomb - kC":
                textconversionFrom.setText("Kilocoulomb");
                textViewConversionShortform.setText("kC");
                break;
            case "Millicoulomb - mC":
                textconversionFrom.setText("Millicoulomb");
                textViewConversionShortform.setText("mC");
                break;


            case "Microcoulomb - µC":
                textconversionFrom.setText("Microcoulomb");
                textViewConversionShortform.setText("µC");
                break;

            case "Nanocoulomb - nC":
                textconversionFrom.setText("Nanocoulomb");
                textViewConversionShortform.setText("nC");
                break;
            case "Picocoulomb - pC":
                textconversionFrom.setText("Picocoulomb");
                textViewConversionShortform.setText("pC");
                break;
            case "Abcoulomb - abC":
                textconversionFrom.setText("Abcoulomb");
                textViewConversionShortform.setText("abC");
                break;
            case"EMU of charge - e":
                textconversionFrom.setText("EMU of charge");
                textViewConversionShortform.setText("e");
                break;
            case "Statcoulomb - stC":
                textconversionFrom.setText("Statcoulomb");
                textViewConversionShortform.setText("stC");
                break;


            case "ESU of charge - e":
                textconversionFrom.setText("ESU of charge");
                textViewConversionShortform.setText("e");
                break;

            case  "Franklin - Fr":
                textconversionFrom.setText("Franklin");
                textViewConversionShortform.setText("Fr");
                break;


            case "Ampere-hour - A*h":
                textconversionFrom.setText("Ampere-hour");
                textViewConversionShortform.setText("A*h");
                break;
            case "Ampere-minute - A*min":
                textconversionFrom.setText("Ampere-minute");
                textViewConversionShortform.setText("A*min");
                break;


            case "Ampere-second - A*s":
                textconversionFrom.setText("Ampere-second");
                textViewConversionShortform.setText("A*s");
                break;

            case "Faraday - F":
                textconversionFrom.setText("Faraday");
                textViewConversionShortform.setText("F");
                break;
            case "Elementary charge - e":
                textconversionFrom.setText("Elementary charge");
                textViewConversionShortform.setText("e");
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
        ChargeConverter c = new ChargeConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<ChargeConverter.ConversionResults> results = c.calculatechargeConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ChargeConverter.ConversionResults item = results.get(i);

            strCoulomb = String.valueOf(formatter.format(item.getC()));
            strMegacoulomb =String.valueOf(formatter.format(item.getMC()));
            strKilocoulomb =String.valueOf(formatter.format(item.getkC()));
            strMillicoulomb =String.valueOf(formatter.format(item.getmC()));
            strMicrocoulomb = String.valueOf(formatter.format(item.getMicroC()));
            strNanocoulomb =String.valueOf(formatter.format(item.getnC()));
            strPicocoulomb = String.valueOf(formatter.format(item.getpC()));
            strAbcoulomb =String.valueOf(formatter.format(item.getAbC()));
            strEMUofcharge =String.valueOf(formatter.format(item.getEmu()));
            strStatcoulomb =String.valueOf(formatter.format(item.getStc()));
            strESUofcharge = String.valueOf(formatter.format(item.getEsu()));
            strFranklin =String.valueOf(formatter.format(item.getFr()));

            strAmperehour = String.valueOf(formatter.format(item.getAh()));
            strAmpereminute =String.valueOf(formatter.format(item.getAmin()));
            strAmperesecond = String.valueOf(formatter.format(item.getAs()));
            strFaraday =String.valueOf(formatter.format(item.getFaraday()));
            strElementarycharge =String.valueOf(formatter.format(item.getE()));




            list.add(new ItemList("C","Coulomb",strCoulomb,"C"));
            list.add(new ItemList("MC","Megacoulomb",strMegacoulomb,"MC"));
            list.add(new ItemList("kC","Kilocoulomb",strKilocoulomb,"kC"));
            list.add(new ItemList("mC","Millicoulomb",strMillicoulomb,"mC"));
            list.add(new ItemList("µC","Microcoulomb",strMicrocoulomb,"µC"));
            list.add(new ItemList("nC","Nanocoulomb",strNanocoulomb,"nC"));
            list.add(new ItemList("pC","Picocoulomb",strPicocoulomb,"pC"));

            list.add(new ItemList("abC","Abcoulomb",strAbcoulomb,"abC"));
            list.add(new ItemList("e","EMU of charge",strEMUofcharge,"e"));
            list.add(new ItemList("stC","Statcoulomb",strStatcoulomb,"stC"));
            list.add(new ItemList("e","ESU of charge",strESUofcharge,"e"));
            list.add(new ItemList("Fr","Franklin",strFranklin,"Fr"));
            list.add(new ItemList("A*h","Ampere-hour",strAmperehour,"A*h"));
            list.add(new ItemList("A*min","Ampere-minute",strAmpereminute,"A*min"));
            list.add(new ItemList("A*s","Ampere-second",strAmperesecond,"A*s"));
            list.add(new ItemList("F","Faraday",strFaraday,"F"));
            list.add(new ItemList("e","Elementary charge",strElementarycharge,"e"));


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

