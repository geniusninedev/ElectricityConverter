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
import com.nineinfosys.electricityconverter.Engin.ElectricResistanceConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectricResistanceListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strOhm = null;
    private String strMegohm = null;
    private String strMicrohm = null;
    private  String strVoltperampere = null;
    private String strReciprocalsiemens = null;
    private String strAbohm = null;

    private String strEMUofresistance = null;
    private  String strStatohm = null;
    private String strESUofresistance = null;
    private String strQuantizedHallresistance = null;

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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#757575")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#707070"));
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
            case "Ohm - Ω" :
                textconversionFrom.setText("Ohm");
                textViewConversionShortform.setText("Ω");
                break;
            case  "Megohm - megohm":
                textconversionFrom.setText("Megohm");
                textViewConversionShortform.setText("megohm");
                break;
            case "Microhm - microhm":
                textconversionFrom.setText("Microhm");
                textViewConversionShortform.setText("Microhm");
                break;
            case  "Volt/ampere - V/A":
                textconversionFrom.setText("Volt/ampere");
                textViewConversionShortform.setText(" V/A");
                break;
            case "Reciprocal siemens - 1/S":
                textconversionFrom.setText("Reciprocal siemens");
                textViewConversionShortform.setText("1/S");
                break;


            case "Abohm - abΩ":
                textconversionFrom.setText("Abohm");
                textViewConversionShortform.setText("abΩ");
                break;

            case "EMU of resistance - EMU":
                textconversionFrom.setText("EMU of resistance");
                textViewConversionShortform.setText("EMU");
                break;
            case "Statohm - stΩ":
                textconversionFrom.setText("Statohm");
                textViewConversionShortform.setText("stΩ");
                break;
            case "ESU of resistance - ESU" :
                textconversionFrom.setText("ESU of resistance");
                textViewConversionShortform.setText("ESU");
                break;
            case "Quantized Hall resistance - Ω":
                textconversionFrom.setText("Quantized Hall resistance");
                textViewConversionShortform.setText("Ω");
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
        ElectricResistanceConverter c = new ElectricResistanceConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<ElectricResistanceConverter.ConversionResults> results = c.calculateResistanceConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ElectricResistanceConverter.ConversionResults item = results.get(i);

            strOhm = String.valueOf(formatter.format(item.getOhm()));
            strMegohm =String.valueOf(formatter.format(item.getMegohm()));
            strMicrohm =String.valueOf(formatter.format(item.getMicrohm()));
            strVoltperampere =String.valueOf(formatter.format(item.getVoltperampere()));
            strReciprocalsiemens = String.valueOf(formatter.format(item.getReciprocalsiemens()));
            strAbohm =String.valueOf(formatter.format(item.getAbohm()));

            strEMUofresistance =String.valueOf(formatter.format(item.getEMUofresistance()));
            strStatohm =String.valueOf(formatter.format(item.getStatohm()));
            strESUofresistance = String.valueOf(formatter.format(item.getESUofresistance()));
            strQuantizedHallresistance =String.valueOf(formatter.format(item.getQuantizedHallresistance()));




            list.add(new ItemList("Ω","Ohm",strOhm,"Ω"));
            list.add(new ItemList("megohm","Megohm",strMegohm,"megohm"));
            list.add(new ItemList("microhm","Microhm",strMicrohm,"microhm"));
            list.add(new ItemList("V/A","Volt/ampere",strVoltperampere,"V/A"));
            list.add(new ItemList("1/S","Reciprocal siemens",strReciprocalsiemens,"1/S"));
            list.add(new ItemList("abΩ","Abohm",strAbohm,"abΩ"));
            list.add(new ItemList("EMU","EMU of resistance",strEMUofresistance,"EMU"));
            list.add(new ItemList("stΩ","Statohm",strStatohm,"stΩ"));
            list.add(new ItemList("ESU","ESU of resistance",strESUofresistance,"ESU"));
            list.add(new ItemList("Ω","Quantized Hall resistance",strQuantizedHallresistance,"Ω"));



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
