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
import com.nineinfosys.electricityconverter.Engin.CurrentConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CurrentConverterListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strAmpere = null;
    private String strKiloampere = null;
    private String strMilliampere = null;
    private String strBiot = null;
    private  String strAbampere = null;
    private String strEMUofcurrent = null;
    private String strStatampere = null;

    private String strESUofcurrent = null;
    private String strCGSemunit = null;
    private String strCGSesunit = null;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;

    DecimalFormat formatter = null;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1e88e5")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#005cb2"));
        }

        MobileAds.initialize(CurrentConverterListActivity.this, getString(R.string.ads_app_id));
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
            case "Ampere - A":
                textconversionFrom.setText("Ampere");
                textViewConversionShortform.setText("A");
                break;
            case "Kiloampere - kA":
                textconversionFrom.setText("Kiloampere");
                textViewConversionShortform.setText("kA");
                break;
            case "Milliampere - mA":
                textconversionFrom.setText("Milliampere");
                textViewConversionShortform.setText("mA");
                break;
            case "Biot - Bi":
                textconversionFrom.setText("Biot");
                textViewConversionShortform.setText("Bi");
                break;


            case "Abampere - abA":
                textconversionFrom.setText("Abampere");
                textViewConversionShortform.setText("abA");
                break;

            case "EMU of current - emuA":
                textconversionFrom.setText("EMU of current");
                textViewConversionShortform.setText("emuA");
                break;
            case "Statampere - stA":
                textconversionFrom.setText("Statampere");
                textViewConversionShortform.setText("stA");
                break;
            case "ESU of current - esuA":
                textconversionFrom.setText("ESU of current");
                textViewConversionShortform.setText("esuA");
                break;
            case "CGS e.m.unit - e.m.unit":
                textconversionFrom.setText("CGS e.m.unit");
                textViewConversionShortform.setText("e.m.unit");
                break;
            case "CGS e.s.unit - e.s.unit":
                textconversionFrom.setText("CGS e.s.unit");
                textViewConversionShortform.setText("e.s.unit");
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
        CurrentConverter c = new CurrentConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<CurrentConverter.ConversionResults> results = c.calculateCurrentConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            CurrentConverter.ConversionResults item = results.get(i);

            strAmpere = String.valueOf(formatter.format(item.getAmpere()));
            strKiloampere =String.valueOf(formatter.format(item.getKiloampere()));
            strMilliampere =String.valueOf(formatter.format(item.getMiliampere()));
            strBiot =String.valueOf(formatter.format(item.getBiot()));
            strAbampere = String.valueOf(formatter.format(item.getAbampere()));
            strEMUofcurrent =String.valueOf(formatter.format(item.getEMUofcurrent()));
            strStatampere = String.valueOf(formatter.format(item.getStatampere()));
            strESUofcurrent =String.valueOf(formatter.format(item.getESUofcurrent()));
            strCGSemunit =String.valueOf(formatter.format(item.getCGSemunit()));
            strCGSesunit =String.valueOf(formatter.format(item.getCGSesunit()));




            list.add(new ItemList("A","Ampere",strAmpere,"A"));
            list.add(new ItemList("kA","Kiloampere",strKiloampere,"kA"));
            list.add(new ItemList("mA","Milliampere",strMilliampere,"mA"));
            list.add(new ItemList("Bi","Biot",strBiot,"Bi"));
            list.add(new ItemList("abA","Abampere",strAbampere,"abA"));
            list.add(new ItemList("emuA","EMU of current",strEMUofcurrent,"emuA"));
            list.add(new ItemList("stA","Statampere",strStatampere,"stA"));

            list.add(new ItemList("esuA","ESU of current",strESUofcurrent,"esuA"));
            list.add(new ItemList("e.m.unit","CGS e.m.unit",strCGSemunit,"e.m.unit"));
            list.add(new ItemList("e.s.unit","CGS e.s.unit",strCGSesunit,"e.s.unit"));


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

