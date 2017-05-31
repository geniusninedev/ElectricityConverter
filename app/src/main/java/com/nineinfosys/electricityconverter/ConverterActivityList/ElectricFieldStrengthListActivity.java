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


import com.nineinfosys.electricityconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.electricityconverter.Engin.ElectricFieldStrengthConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectricFieldStrengthListActivity extends AppCompatActivity implements TextWatcher {

  private   List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strVoltpermeter = null;
    private String strKilovoltpermeter = null;
    private String strVoltpercentimeter = null;
    private String strkilovoltpercentimeter = null;
    private  String strMillivoltpermeter = null;
    private String strMicrovoltpermeter = null;
    private String strKilovoltperinch = null;

    private String strVoltperinch = null;
    private String strVoltpermil = null;
    private String strAbvoltpercentimeter = null;
    private  String strStatvoltpercentimeter = null;
    private String strStatvoltperinch = null;
    private String strNewtonpercoulomb = null;

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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#59db59")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#0aa828"));
        }


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
            case "Volt/meter - V/m" :
                textconversionFrom.setText("Volt/meter");
                textViewConversionShortform.setText("V/m");
                break;
            case "Kilovolt/meter - kV/m":
                textconversionFrom.setText("Kilovolt/meter");
                textViewConversionShortform.setText("kV/m");
                break;
            case "Kilovolt/centimeter - kV/cm":
                textconversionFrom.setText("Kilovolt/centimeter");
                textViewConversionShortform.setText("kV/cm");
                break;
            case "Volt/centimeter - V/cm":
                textconversionFrom.setText("Volt/centimeter");
                textViewConversionShortform.setText("A/mil²");
                break;


            case "Millivolt/meter - mV/m":
                textconversionFrom.setText("Millivolt/meter");
                textViewConversionShortform.setText("mV/m");
                break;

            case  "Microvolt/meter - µ/m":
                textconversionFrom.setText("Microvolt/meter");
                textViewConversionShortform.setText("µ/m");
                break;
            case "Kilovolt/inch - kV/in":
                textconversionFrom.setText("Kilovolt/inch");
                textViewConversionShortform.setText("kV/in");
                break;
            case "Volt/inch - V/in":
                textconversionFrom.setText("Volt/inch");
                textViewConversionShortform.setText("V/in");
                break;
            case "Volt/mil - V/mil":
                textconversionFrom.setText("Volt/mil");
                textViewConversionShortform.setText("V/mil");
                break;
            case "Abvolt/centimeter - abV/cm":
                textconversionFrom.setText("Abvolt/centimeter");
                textViewConversionShortform.setText("abV/cm");
                break;


            case "Statvolt/centimeter - stV/cm":
                textconversionFrom.setText("Statvolt/centimeter");
                textViewConversionShortform.setText("stV/cm");
                break;

            case  "Statvolt/inch - stV/in":
                textconversionFrom.setText("Statvolt/inch");
                textViewConversionShortform.setText("stV/in");
                break;

            case  "Newton/coulomb - N/C":
                textconversionFrom.setText("Newton/coulomb");
                textViewConversionShortform.setText("N/C");
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
        ElectricFieldStrengthConverter c = new ElectricFieldStrengthConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<ElectricFieldStrengthConverter.ConversionResults> results = c.calculateLElectricFieldStrengthConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ElectricFieldStrengthConverter.ConversionResults item = results.get(i);

            strVoltpermeter = String.valueOf(formatter.format(item.getVoltpermeter()));
            strKilovoltpermeter =String.valueOf(formatter.format(item.getKilovoltpermeter()));
            strkilovoltpercentimeter =String.valueOf(formatter.format(item.getKilovoltpercentimeter()));
            strVoltpercentimeter =String.valueOf(formatter.format(item.getVoltpercentimeter()));
            strMillivoltpermeter = String.valueOf(formatter.format(item.getMillivoltpermeter()));
            strMicrovoltpermeter =String.valueOf(formatter.format(item.getMicrovoltpermeter()));
            strKilovoltperinch = String.valueOf(formatter.format(item.getKilovoltperinch()));
            strVoltperinch =String.valueOf(formatter.format(item.getVoltperinch()));
            strVoltpermil =String.valueOf(formatter.format(item.getVoltpermil()));
            strAbvoltpercentimeter =String.valueOf(formatter.format(item.getAbvoltpercentimeter()));
            strStatvoltpercentimeter = String.valueOf(formatter.format(item.getStatvoltpercentimeter()));
            strStatvoltperinch =String.valueOf(formatter.format(item.getStatvoltperinch()));
            strNewtonpercoulomb =String.valueOf(formatter.format(item.getNewtonpercoulomb()));



            list.add(new ItemList("V/m","Volt/meter",strVoltpermeter,"V/m"));
            list.add(new ItemList("kV/m","Kilovolt/meter",strKilovoltpermeter,"kV/m"));
            list.add(new ItemList("kV/cm","Kilovolt/centimeter",strkilovoltpercentimeter,"kV/cm"));
            list.add(new ItemList("V/cm","Volt/centimeter",strVoltpercentimeter,"V/cm"));
            list.add(new ItemList("mV/m","Millivolt/meter",strMillivoltpermeter,"mV/m"));
            list.add(new ItemList("µ/m","Microvolt/meter",strMicrovoltpermeter,"µ/m"));
            list.add(new ItemList("kV/in","Kilovolt/inch",strKilovoltperinch,"kV/in"));
            list.add(new ItemList("V/in","Volt/inch",strVoltperinch,"V/in"));
            list.add(new ItemList("V/mil","Volt/mil",strVoltpermil,"V/mil"));
            list.add(new ItemList("abV/cm","Abvolt/centimeter",strAbvoltpercentimeter,"abV/cm"));
            list.add(new ItemList("stV/cm","Statvolt/centimeter",strStatvoltpercentimeter,"stV/cm"));
            list.add(new ItemList("stV/in","Statvolt/inch",strStatvoltperinch,"stV/in"));
            list.add(new ItemList("N/C","Newton/coulomb",strNewtonpercoulomb,"N/C"));


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

