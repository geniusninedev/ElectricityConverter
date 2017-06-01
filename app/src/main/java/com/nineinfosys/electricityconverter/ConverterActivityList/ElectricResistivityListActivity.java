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
import com.nineinfosys.electricityconverter.Engin.ElectricResistivityConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.ItemList;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectricResistivityListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strOhmmeter = null;
    private String strOhmcentimeter = null;
    private String strOhminch = null;
    private String strMicrohmcentimeter = null;
    private String strMicrohminch = null;
    private String strAbohmcentimeter = null;

    private String strStatohmcentimeter = null;
    private  String strCircularmilohmperfoot = null;
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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d32f2f")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#9a0007"));
        }

        MobileAds.initialize(ElectricResistivityListActivity.this, getString(R.string.ads_app_id));
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
            case "Ohm meter - Ωm" :
                textconversionFrom.setText("Ohm meter");
                textViewConversionShortform.setText("Ωm");
                break;
            case "Ohm centimeter - Ωcm":
                textconversionFrom.setText("Ohm centimeter");
                textViewConversionShortform.setText("Ωcm");
                break;
            case "Ohm inch - Ωin":
                textconversionFrom.setText("Ohm inch");
                textViewConversionShortform.setText("Ωin");
                break;
            case  "Microhm centimeter - µΩcm":
                textconversionFrom.setText("Microhm centimeter");
                textViewConversionShortform.setText("µΩcm");
                break;
            case "Microhm inch -  µΩin" :
                textconversionFrom.setText("Microhm inch");
                textViewConversionShortform.setText("µΩin");
                break;


            case "Abohm centimeter - abΩcm":
                textconversionFrom.setText("Abohm centimeter");
                textViewConversionShortform.setText("abΩcm");
                break;

            case "Statohm centimeter - stΩcm":
                textconversionFrom.setText("Statohm centimeter");
                textViewConversionShortform.setText("stΩcm");
                break;
            case "Circular mil ohm/foot - circular mil Ω/ft":
                textconversionFrom.setText("Circular mil ohm/foot");
                textViewConversionShortform.setText(" circular mil Ω/ft");
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
        ElectricResistivityConverter c = new ElectricResistivityConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<ElectricResistivityConverter.ConversionResults> results = c.calculateElectricResistivityConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            ElectricResistivityConverter.ConversionResults item = results.get(i);

            strOhmmeter = String.valueOf(formatter.format(item.getOhmmeter()));
            strOhmcentimeter =String.valueOf(formatter.format(item.getOhmcentimeter()));
            strOhminch =String.valueOf(formatter.format(item.getOhminch()));
            strMicrohmcentimeter =String.valueOf(formatter.format(item.getMicrohmcentimeter()));
            strMicrohminch = String.valueOf(formatter.format(item.getMicrohminch()));
            strAbohmcentimeter =String.valueOf(formatter.format(item.getAbohmcentimeter()));

            strStatohmcentimeter =String.valueOf(formatter.format(item.getStatohmcentimeter()));
            strCircularmilohmperfoot =String.valueOf(formatter.format(item.getCircularmilohmperfoot()));


            list.add(new ItemList("Ωm","Ohm meter",strOhmmeter,"Ωm"));
            list.add(new ItemList("Ωcm","Ohm centimeter",strOhmcentimeter,"Ωcm"));
            list.add(new ItemList("Ωin","Ohm inch",strOhminch,"Ωin"));
            list.add(new ItemList("µΩcm","Microhm centimeter",strMicrohmcentimeter,"µΩcm"));
            list.add(new ItemList("µΩin","Microhm inch",strMicrohminch,"µΩin"));
            list.add(new ItemList("abΩcm","Abohm centimeter",strAbohmcentimeter,"abΩcm"));
            list.add(new ItemList("stΩcm","Statohm centimeter",strStatohmcentimeter,"stΩcm"));
            list.add(new ItemList("circular mil Ω/ft","Circular mil ohm/foot",strCircularmilohmperfoot,"circular mil Ω/ft"));



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

