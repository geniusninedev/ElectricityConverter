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
import com.nineinfosys.electricityconverter.Engin.ElectrostaticCapacitanceConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CapacitanceConverterListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strFarad = null;
    private String strExafarad = null;
    private String strPetafarad = null;
    private String strTerafarad = null;
    private  String strGigafarad = null;
    private String strMegafarad = null;
    private String strKilofarad = null;

    private String strHectofarad = null;
    private String strDekafarad = null;
    private String strDecifarad = null;
    private  String strCentifarad = null;
    private String strMillifarad = null;

    private String strMicrofarad = null;
    private String strNanofarad = null;
    private  String strPicofarad = null;
    private String strFemtofarad = null;
    private String strAttofarad = null;
    private String strCoulombpervolt = null;
    private String strAbfarad = null;
    private String strEMUofcapacitance = null;
    private String strStatfarad = null;
    private String strESUofcapacitance = null;


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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#a05445")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#6e291d"));
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
            case "Farad - F":
                textconversionFrom.setText("Farad");
                textViewConversionShortform.setText("F");
                break;
            case "Exafarad - EF":
                textconversionFrom.setText("Exafarad");
                textViewConversionShortform.setText("EF");
                break;
            case "Petafarad - PF":
                textconversionFrom.setText("Petafarad");
                textViewConversionShortform.setText("PF");
                break;
            case "Terafarad - TF":
                textconversionFrom.setText("Terafarad");
                textViewConversionShortform.setText("TF");
                break;


            case "Gigafarad - GF":
                textconversionFrom.setText("Gigafarad");
                textViewConversionShortform.setText("GF");
                break;

            case "Megafarad - MF":
                textconversionFrom.setText("Megafarad");
                textViewConversionShortform.setText("MF");
                break;
            case "Kilofarad - kF":
                textconversionFrom.setText("Kilofarad");
                textViewConversionShortform.setText("kF");
                break;
            case "Hectofarad - hF":
                textconversionFrom.setText("Hectofarad");
                textViewConversionShortform.setText("hF");
                break;
            case "Dekafarad - dF":
                textconversionFrom.setText("Dekafarad");
                textViewConversionShortform.setText("dF");
                break;
            case "Decifarad - dF":
                textconversionFrom.setText("Decifarad");
                textViewConversionShortform.setText("dF");
                break;


            case "Centifarad - cF":
                textconversionFrom.setText("Centifarad");
                textViewConversionShortform.setText("cF");
                break;

            case  "Millifarad - mF":
                textconversionFrom.setText("Millifarad");
                textViewConversionShortform.setText("mF");
                break;


            case "Microfarad - µF":
                textconversionFrom.setText("Microfarad");
                textViewConversionShortform.setText("µF");
                break;
            case "Nanofarad - nF":
                textconversionFrom.setText("Nanofarad");
                textViewConversionShortform.setText("nF");
                break;


            case "Picofarad - pF":
                textconversionFrom.setText("Picofarad");
                textViewConversionShortform.setText("pF");
                break;

            case "Femtofarad - fF" :
                textconversionFrom.setText("Femtofarad");
                textViewConversionShortform.setText("fF");
                break;
            case "Attofarad - aF":
                textconversionFrom.setText("Attofarad");
                textViewConversionShortform.setText("aF");
                break;

            case "Coulomb/volt - C/v" :
                textconversionFrom.setText("Coulomb/volt");
                textViewConversionShortform.setText("C/v");
                break;

            case "Abfarad - abF" :
                textconversionFrom.setText("Abfarad");
                textViewConversionShortform.setText("abF");
                break;
            case "EMU of capacitance - EMU":
                textconversionFrom.setText("EMU of capacitance");
                textViewConversionShortform.setText("EMU");
                break;
            case "Statfarad - stF" :
                textconversionFrom.setText("Statfarad");
                textViewConversionShortform.setText("stF");
                break;

            case "ESU of capacitance - ESU" :
                textconversionFrom.setText("ESU of capacitance ");
                textViewConversionShortform.setText("ESU");
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
        ElectrostaticCapacitanceConverter c = new ElectrostaticCapacitanceConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<ElectrostaticCapacitanceConverter.ConversionResults> results = c.calculatecapacitanceConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ElectrostaticCapacitanceConverter.ConversionResults item = results.get(i);

            strFarad = String.valueOf(formatter.format(item.getFarad()));
            strExafarad =String.valueOf(formatter.format(item.getExafarad()));
            strPetafarad =String.valueOf(formatter.format(item.getPetafarad()));
            strTerafarad =String.valueOf(formatter.format(item.getTerafarad()));
            strGigafarad = String.valueOf(formatter.format(item.getGigafarad()));
            strMegafarad =String.valueOf(formatter.format(item.getMegafarad()));
            strKilofarad = String.valueOf(formatter.format(item.getKilofarad()));
            strHectofarad =String.valueOf(formatter.format(item.getHectofarad()));
            strDekafarad =String.valueOf(formatter.format(item.getDekafarad()));
            strDecifarad =String.valueOf(formatter.format(item.getDecifarad()));
            strCentifarad = String.valueOf(formatter.format(item.getCentifarad()));
            strMillifarad =String.valueOf(formatter.format(item.getMillifarad()));
            strMicrofarad = String.valueOf(formatter.format(item.getMicrofarad()));
            strNanofarad =String.valueOf(formatter.format(item.getNanofarad()));
            strPicofarad =String.valueOf(formatter.format(item.getPicofarad()));
            strFemtofarad =String.valueOf(formatter.format(item.getFemtofarad()));
            strAttofarad = String.valueOf(formatter.format(item.getAttofarad()));
            strCoulombpervolt = String.valueOf(formatter.format(item.getCoulomb()));
            strAbfarad =String.valueOf(formatter.format(item.getAbfarad()));
            strEMUofcapacitance =String.valueOf(formatter.format(item.getEMU()));
            strStatfarad =String.valueOf(formatter.format(item.getStatfarad()));
            strESUofcapacitance = String.valueOf(formatter.format(item.getESU()));

            list.add(new ItemList("F","Farad",strFarad,"F"));
            list.add(new ItemList("EF","Exafarad",strExafarad,"EF"));
            list.add(new ItemList("PF","Petafarad",strPetafarad,"PF"));
            list.add(new ItemList("TF","Terafarad",strTerafarad,"TF"));
            list.add(new ItemList("GF","Gigafarad",strGigafarad,"GF"));
            list.add(new ItemList("MF","Megafarad",strMegafarad,"MF"));
            list.add(new ItemList("kF","Kilofarad",strKilofarad,"kF"));

            list.add(new ItemList("hF","Hectofarad",strHectofarad,"hF"));
            list.add(new ItemList("dF","Dekafarad",strDekafarad,"dF"));
            list.add(new ItemList("dF","Decifarad",strDecifarad,"dF"));
            list.add(new ItemList("cF","Centifarad",strCentifarad,"cF"));
            list.add(new ItemList("mF","Millifarad",strMillifarad,"mF"));
            list.add(new ItemList("µF","Microfarad",strMicrofarad,"µF"));
            list.add(new ItemList("nF","Nanofarad",strNanofarad,"nF"));
            list.add(new ItemList("pF","Picofarad",strPicofarad,"pF"));
            list.add(new ItemList("fF","Femtofarad",strFemtofarad,"fF"));
            list.add(new ItemList("aF","Attofarad",strAttofarad,"aF"));

            list.add(new ItemList("C/v","Coulomb/volt",strCoulombpervolt,"C/v"));
            list.add(new ItemList("abF","Abfarad",strAbfarad,"abF"));
            list.add(new ItemList("EMU","Statfarad",strEMUofcapacitance,"EMU"));
            list.add(new ItemList("stF","Attofarad",strStatfarad,"stF"));
            list.add(new ItemList("ESU","ESU of capacitance",strESUofcapacitance,"ESU"));



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
