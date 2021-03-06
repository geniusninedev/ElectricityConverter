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
import com.nineinfosys.electricityconverter.Engin.ConductivityConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConductivityConverterListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strSiemenspermeter = null;
    private String strPicosiemenspermeter = null;
    private String strMhopermeter = null;
    private String strMhopercentimeter = null;
    private  String strAbmhopermeter = null;
    private String strAbmhopercentimeter = null;
    private String strStatmhopermeter = null;

    private String strStatmhopercentimeter = null;

    DecimalFormat formatter = null;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;

    ConductivityConverter.ConversionResults item;
    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1976d2")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#004ba0"));
        }
        MobileAds.initialize(ConductivityConverterListActivity.this, getString(R.string.ads_app_id));
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
            case "Siemens/meter - S/m" :
                textconversionFrom.setText("Siemens/meter");
                textViewConversionShortform.setText("S/m");
                break;
            case "Picosiemens/meter - pS/m" :
                textconversionFrom.setText("Picosiemens/meter");
                textViewConversionShortform.setText("pS/m");
                break;

            case "Mho/meter - mho/m" :
                textconversionFrom.setText("Mho/meter");
                textViewConversionShortform.setText("mho/m");
                break;
            case "Mho/centimeter - mho/cm":
                textconversionFrom.setText("Mho/centimeter");
                textViewConversionShortform.setText("mho/cm");
                break;
            case "Abmho/meter - abmho/m":
                textconversionFrom.setText("Abmho/meter");
                textViewConversionShortform.setText("abmho/m");
                break;


            case "Abmho/centimeter - abmho/cm":
                textconversionFrom.setText("Abmho/centimeter");
                textViewConversionShortform.setText("abmho/cm");
                break;

            case "Statmho/meter - stmho/m":
                textconversionFrom.setText("Statmho/meter");
                textViewConversionShortform.setText("stmho/m");
                break;
            case "Statmho/centimeter - st/cm":
                textconversionFrom.setText("Statmho/centimeter");
                textViewConversionShortform.setText("st/cm");
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
        ConductivityConverter c = new ConductivityConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<ConductivityConverter.ConversionResults> results = c.calculateElectricConductivityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            item = results.get(i);

            strSiemenspermeter = String.valueOf(formatter.format(item.getSiemenspermeter()));
            strPicosiemenspermeter =String.valueOf(formatter.format(item.getPicosiemenspermeter()));
            strMhopermeter =String.valueOf(formatter.format(item.getMhopermeter()));
            strMhopercentimeter =String.valueOf(formatter.format(item.getMhopercentimeter()));
            strAbmhopermeter = String.valueOf(formatter.format(item.getAbmhopermeter()));
            strAbmhopercentimeter =String.valueOf(formatter.format(item.getAbmhopercentimeter()));
            strStatmhopermeter = String.valueOf(formatter.format(item.getStatmhopermeter()));
            strStatmhopercentimeter =String.valueOf(formatter.format(item.getStatmhopercentimeter()));

            list.add(new ItemList("S/m","Siemens/meter",strSiemenspermeter,"S/m"));
            list.add(new ItemList("pS/m","Picosiemens/meter",strPicosiemenspermeter,"pS/m"));
            list.add(new ItemList("mho/m","Mho/meter",strMhopermeter,"mho/m"));
            list.add(new ItemList("mho/cm","Mho/centimeter",strMhopercentimeter,"mho/cm"));
            list.add(new ItemList("abmho/m","Abmho/meter",strAbmhopermeter,"abmho/m"));
            list.add(new ItemList("abmho/cm","Abmho/centimeter",strAbmhopercentimeter,"abmho/cm"));
            list.add(new ItemList("stmho/m","Statmho/meter",strStatmhopermeter,"stmho/m"));
            list.add(new ItemList("st/cm","Statmho/centimeter",strStatmhopercentimeter,"st/cm"));


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

