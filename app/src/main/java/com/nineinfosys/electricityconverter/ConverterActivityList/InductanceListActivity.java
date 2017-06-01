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
import com.nineinfosys.electricityconverter.Engin.InductanceConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class InductanceListActivity extends AppCompatActivity implements TextWatcher {

    private List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strHenry = null;
    private String strExahenry = null;
    private String strterahenry = null;
    private String strPetahenry = null;
    private  String strGigahenry = null;
    private String strMegahenry = null;
    private String strKilohenry = null;

    private String strHectohenry = null;
    private String strDekahenry = null;
    private String strDecihenry = null;
    private  String strCentihenry = null;
    private String strMilihenry = null;

    private String strMicrohenry = null;
    private String strNanohenry = null;
    private  String strPicohenry = null;
    private String strFemtohenry = null;
    private String strAttohenery = null;
    private String strWeberperampere = null;
    private String strAbhenery = null;
    private String strEMUofinductance = null;
    private String strStathenry = null;
    private String strESUofinductance = null;

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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d32f2f")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#9a0007"));
        }

        MobileAds.initialize(InductanceListActivity.this, getString(R.string.ads_app_id));
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
            case "Henry - H":
                textconversionFrom.setText("Henry");
                textViewConversionShortform.setText("H");
                break;
            case "Exahenry - EH":
                textconversionFrom.setText("Exahenry");
                textViewConversionShortform.setText("EH");
                break;
            case "Terahenry - TH":
                textconversionFrom.setText("Terahenry");
                textViewConversionShortform.setText("TH");
                break;
            case "Petahenry - PH":
                textconversionFrom.setText("Petahenry");
                textViewConversionShortform.setText("PH");
                break;


            case "Gigahenry - GH":
                textconversionFrom.setText("Gigahenry");
                textViewConversionShortform.setText("GH");
                break;

            case "Megahenry - MH":
                textconversionFrom.setText("Megahenry");
                textViewConversionShortform.setText("MH");
                break;
            case "Kilohenry - kH":
                textconversionFrom.setText("Kilohenry");
                textViewConversionShortform.setText("kH");
                break;
            case "Hectohenry - hH":
                textconversionFrom.setText("Hectohenry");
                textViewConversionShortform.setText("hH");
                break;
            case "Dekahenry - daH":
                textconversionFrom.setText("Dekahenry");
                textViewConversionShortform.setText("daH");
                break;
            case "Decihenry - dH":
                textconversionFrom.setText("Decihenry");
                textViewConversionShortform.setText("dH");
                break;


            case "Centihenry - cH":
                textconversionFrom.setText("Centihenry");
                textViewConversionShortform.setText("cH");
                break;

            case  "Milihenry - mH":
                textconversionFrom.setText("Microhenry");
                textViewConversionShortform.setText("mH");
                break;


            case "Microhenry - µH":
                textconversionFrom.setText("Microfarad");
                textViewConversionShortform.setText("µF");
                break;
            case "Nanohenry - nH":
                textconversionFrom.setText("Nanohenry");
                textViewConversionShortform.setText("nH");
                break;


            case "Picohenry - pH":
                textconversionFrom.setText("Picohenry");
                textViewConversionShortform.setText("pH");
                break;

            case "Femtohenry - fH" :
                textconversionFrom.setText("Femtohenry");
                textViewConversionShortform.setText("fH");
                break;
            case "Attohenery - aH":
                textconversionFrom.setText("Attohenery");
                textViewConversionShortform.setText("aH");
                break;

            case "Weber/ampere - Wb/A" :
                textconversionFrom.setText("Weber/ampere");
                textViewConversionShortform.setText("Wb/A");
                break;

            case"Abhenery - abH" :
                textconversionFrom.setText("Abhenery");
                textViewConversionShortform.setText("abH");
                break;
            case "EMU of inductance - EMU":
                textconversionFrom.setText("EMU of inductance");
                textViewConversionShortform.setText("EMU");
                break;
            case "Stathenry - stH" :
                textconversionFrom.setText("Stathenry");
                textViewConversionShortform.setText("stH");
                break;

            case "ESU of inductance - ESU":
                textconversionFrom.setText("ESU of inductance");
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
        InductanceConverter c = new InductanceConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<InductanceConverter.ConversionResults> results = c.calculateInductanceConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            InductanceConverter.ConversionResults item = results.get(i);

            strHenry = String.valueOf(formatter.format(item.getHenry()));
            strExahenry =String.valueOf(formatter.format(item.getExahenry()));
            strterahenry =String.valueOf(formatter.format(item.getPetahenry()));
            strPetahenry =String.valueOf(formatter.format(item.getTerahenry()));
            strGigahenry = String.valueOf(formatter.format(item.getGigahenry()));
            strMegahenry =String.valueOf(formatter.format(item.getMegahenry()));
            strKilohenry = String.valueOf(formatter.format(item.getKilohenry()));
            strHectohenry =String.valueOf(formatter.format(item.getHectohenry()));
            strDekahenry =String.valueOf(formatter.format(item.getDekahenry()));
            strDecihenry =String.valueOf(formatter.format(item.getDecihenry()));
            strCentihenry = String.valueOf(formatter.format(item.getCentihenry()));
            strMilihenry =String.valueOf(formatter.format(item.getMilihenry()));
            strMicrohenry = String.valueOf(formatter.format(item.getMicrohenry()));
            strNanohenry =String.valueOf(formatter.format(item.getNanohenry()));
            strPicohenry =String.valueOf(formatter.format(item.getPicohenry()));
            strFemtohenry =String.valueOf(formatter.format(item.getFemtohenry()));
            strAttohenery = String.valueOf(formatter.format(item.getAttohenery()));
            strWeberperampere = String.valueOf(formatter.format(item.getWeberperampere()));
            strAbhenery =String.valueOf(formatter.format(item.getAbhenery()));
            strEMUofinductance =String.valueOf(formatter.format(item.getEMUofinductance()));
            strStathenry =String.valueOf(formatter.format(item.getStathenry()));
            strESUofinductance = String.valueOf(formatter.format(item.getESUofinductance()));




            list.add(new ItemList("H","Henry",strHenry,"F"));
            list.add(new ItemList("EH","Exahenry",strExahenry,"EH"));
            list.add(new ItemList("TH","Terahenry",strterahenry,"TH"));
            list.add(new ItemList("PH","Petahenry",strPetahenry,"PH"));
            list.add(new ItemList("GH","Gigahenry",strGigahenry,"GH"));
            list.add(new ItemList("MH","Megahenry",strMegahenry,"MH"));
            list.add(new ItemList("kH","Kilohenry",strKilohenry,"kH"));

            list.add(new ItemList("hH","Hectohenry",strHectohenry,"hH"));
            list.add(new ItemList("daH","Dekahenry",strDekahenry,"daH"));
            list.add(new ItemList("dH","Decihenry",strDecihenry,"dH"));
            list.add(new ItemList("cH","Centihenry",strCentihenry,"cH"));
            list.add(new ItemList("mH","Milihenry",strMilihenry,"mH"));
            list.add(new ItemList("µF","Microhenry",strMicrohenry,"µF"));
            list.add(new ItemList("nH","Nanohenry",strNanohenry,"nH"));
            list.add(new ItemList("pH","Picohenry",strPicohenry,"pH"));
            list.add(new ItemList("fH","Femtohenry",strFemtohenry,"fH"));
            list.add(new ItemList("aH","Attohenery",strAttohenery,"aH"));

            list.add(new ItemList("Wb/A","Weber/ampere",strWeberperampere,"Wb/A"));
            list.add(new ItemList("abH","Abhenery",strAbhenery,"abH"));
            list.add(new ItemList("EMU","EMU of inductance",strEMUofinductance,"EMU"));
            list.add(new ItemList("stH","Stathenry",strStathenry,"stF"));
            list.add(new ItemList("ESU","ESU of inductance",strESUofinductance,"ESU"));



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

