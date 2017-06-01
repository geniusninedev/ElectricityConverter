package com.nineinfosys.electricityconverter.ConverterActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.electricityconverter.ConverterActivityList.ElectricResistanceListActivity;
import com.nineinfosys.electricityconverter.Engin.ElectricResistanceConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectricResistanceConverterActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    Button buttonConvert;
    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listLinearChargeFirsttempTo, listLinearChargeFirstfrom,listLinearChargeTo,listLinearChargefrom;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 4;
    private int allunit = 10;
    DecimalFormat formatter = null;
    private static final int REQUEST_CODE = 100;

    ElectricResistanceConverter.ConversionResults item;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#757575")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Electric Resistance");

        formatsetting();

        MobileAds.initialize(ElectricResistanceConverterActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverter);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initalization of tools and variables
        spinnerConvertFrom = (Spinner) findViewById(R.id.spinnerConvertFrom);
        spinnerConvertTo = (Spinner) findViewById(R.id.spinnerConvertTo);
        textViewBasicUnit = (TextView) findViewById(R.id.textViewBasicUnit);
        textViewConvert=(TextView) findViewById(R.id.buttonUnitConverter);
        textViewAllUnit = (TextView) findViewById(R.id.textViewAllUnit);
        editTextValue = (EditText) findViewById(R.id.edittextFrom);
        editTextValueTo = (EditText) findViewById(R.id.edittextTo);
        buttonCopy = (FloatingActionButton) findViewById(R.id.button_copy);
        buttonList = (FloatingActionButton) findViewById(R.id.button_list_fullreport);
        buttonShare = (FloatingActionButton) findViewById(R.id.button_list_share);
        buttonMail = (FloatingActionButton) findViewById(R.id.button_list_mail);
        switchChangeType = (SwitchCompat) findViewById(R.id.switchButton);

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGray)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#707070"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listLinearChargeFirstfrom = new ArrayList<String>();
        listLinearChargeFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listLinearChargeFirstfrom.add("Ohm - Ω");
        listLinearChargeFirstfrom.add("Megohm - megohm");
        listLinearChargeFirstfrom.add( "Microhm - microhm");
        listLinearChargeFirstfrom.add("Volt/ampere - V/A");

        //for first time running spinner
        listLinearChargeFirsttempTo.add("Ohm - Ω");
        listLinearChargeFirsttempTo.add("Megohm - megohm");
        listLinearChargeFirsttempTo.add( "Microhm - microhm");
        listLinearChargeFirsttempTo.add("Volt/ampere - V/A");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ElectricResistanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ElectricResistanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirsttempTo);


        // Drop down layout style - list view with radio button
        Adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        AdapterTempTo.setDropDownViewResource(android.R.layout.simple_list_item_checked);

        // attaching data adapter to spinner
        spinnerConvertFrom.setAdapter(Adapter);
        spinnerConvertTo.setAdapter(AdapterTempTo);

        //switch converttype
        switchChangeType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                listLinearChargefrom = new ArrayList<String>();
                listLinearChargeTo = new ArrayList<String>();
                String stringSwitchSate = String.valueOf(isChecked);
                String strBasic = "Basic";
                String strAdvance = "All";
                switch (stringSwitchSate) {

                    case "false":
                        Snackbar.make(buttonView, "You switched to " + strBasic + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        //for first time running spinner
                        listLinearChargefrom.add("Ohm - Ω");
                        listLinearChargefrom.add("Megohm - megohm");
                        listLinearChargefrom.add( "Microhm - microhm");
                        listLinearChargefrom.add("Volt/ampere - V/A");
                        //for first time running spinner
                        listLinearChargeTo.add("Ohm - Ω");
                        listLinearChargeTo.add("Megohm - megohm");
                        listLinearChargeTo.add( "Microhm - microhm");
                        listLinearChargeTo.add("Volt/ampere - V/A");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        //for first  running spinner
                        listLinearChargefrom.add("Ohm - Ω");
                        listLinearChargefrom.add("Megohm - megohm");
                        listLinearChargefrom.add( "Microhm - microhm");
                        listLinearChargefrom.add("Volt/ampere - V/A");
                        listLinearChargefrom.add("Reciprocal siemens - 1/S");
                        listLinearChargefrom.add("Abohm - abΩ");
                        listLinearChargefrom.add("EMU of resistance - EMU");
                        listLinearChargefrom.add("Statohm - stΩ");
                        listLinearChargefrom.add("ESU of resistance - ESU");
                        listLinearChargefrom.add("Quantized Hall resistance - Ω");





                        //for second running spinner
                        listLinearChargeTo.add("Ohm - Ω");
                        listLinearChargeTo.add("Megohm - megohm");
                        listLinearChargeTo.add( "Microhm - microhm");
                        listLinearChargeTo.add("Volt/ampere - V/A");
                        listLinearChargeTo.add("Reciprocal siemens - 1/S");
                        listLinearChargeTo.add("Abohm - abΩ");
                        listLinearChargeTo.add("EMU of resistance - EMU");
                        listLinearChargeTo.add("Statohm - stΩ");
                        listLinearChargeTo.add("ESU of resistance - ESU");
                        listLinearChargeTo.add("Quantized Hall resistance - Ω");







                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ElectricResistanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ElectricResistanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeTo);


                // Drop down layout style - list view with radio button
                Adapter2.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                AdapterTempTo2.setDropDownViewResource(android.R.layout.simple_list_item_checked);

                // attaching data adapter to spinner
                spinnerConvertFrom.setAdapter(Adapter2);
                spinnerConvertTo.setAdapter(AdapterTempTo2);

            }
        });

        editTextValue.addTextChangedListener(this);
        buttonList.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        buttonMail.setOnClickListener(this);
        buttonCopy.setOnClickListener(this);
        textViewConvert.setOnClickListener(this);


        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerConvertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences = this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF, "Thousands separator");
        String DecimalplaceString = sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF, "2");
        Settings settings = new Settings(FormattedString, DecimalplaceString);
        formatter = settings.setting();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonUnitConverter:
                //switch spinner value
                int spinner1Index = spinnerConvertFrom.getSelectedItemPosition();
                spinnerConvertFrom.setSelection(spinnerConvertTo.getSelectedItemPosition());
                spinnerConvertTo.setSelection(spinner1Index );
                break;

            case R.id.button_list_fullreport:
                doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                Intent i = new Intent(this,ElectricResistanceListActivity.class);
                i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
                i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
                startActivity(i);
                break;

            case R.id.button_copy:
                String text = editTextValueTo.getText().toString().trim();
                android.content.ClipboardManager clipboardMgr = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", text);
                clipboardMgr.setPrimaryClip(clip);
                Snackbar.make(v, "Conversion Value Copied", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                break;

            case R.id.button_list_share:
                String textTo = editTextValueTo.getText().toString().trim();
                String textFrom = editTextValueTo.getText().toString().trim();
                String shareMessage = textFrom + " " + stringSpinnerFrom + ": " + textTo + " " + stringSpinnerTo;

                try {
                    Intent share = new Intent();
                    share.setAction("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT", shareMessage);
                    startActivity(Intent.createChooser(share, ""));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.button_list_mail:
                String textmailTo = editTextValueTo.getText().toString().trim();
                String textmailFrom = editTextValueTo.getText().toString().trim();
                String message = textmailTo + " " + stringSpinnerFrom + " :  " + textmailFrom + "  " + stringSpinnerTo;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{});
                email.putExtra(Intent.EXTRA_SUBJECT, "Conversion Details");
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Select Email Client"));
                break;

        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try {

            doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
            stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
            stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();
            calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);

            //   Toast.makeText(this, "string12" + stringSpinnerFrom + "\n string13" + stringSpinnerTo + "string14" + doubleEdittextvalue, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }


    }

    public void calcualteValue(String strSpinnerFromvalue1, String strSpinnerTovalue2, double doubleEdittextvalue1) {



        try {

            ElectricResistanceConverter c = new ElectricResistanceConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<ElectricResistanceConverter.ConversionResults> results = c.calculateResistanceConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

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



                switch (strSpinnerFromvalue1) {
                    case "Ohm - Ω" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Megohm - megohm":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Microhm - microhm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Volt/ampere - V/A":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Reciprocal siemens - 1/S":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Abohm - abΩ":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "EMU of resistance - EMU":
                        conversion(strSpinnerTovalue2);
                        break;
                    case"Statohm - stΩ":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "ESU of resistance - ESU":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Quantized Hall resistance - Ω" :
                        conversion(strSpinnerTovalue2);
                        break;


                }
            }


        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    private void conversion(String strSpinnerTovalue2) {

        switch (strSpinnerTovalue2) {


            case "Ohm - Ω":
                editTextValueTo.setText(strOhm);
                break;
            case "Megohm - megohm":
                editTextValueTo.setText(strMegohm);
                break;

            case "Microhm - microhm":
                editTextValueTo.setText(strMicrohm);
                break;
            case "Volt/ampere - V/A":
                editTextValueTo.setText(strVoltperampere);
                break;
            case "Reciprocal siemens - 1/S":
                editTextValueTo.setText(strReciprocalsiemens);
                break;
            case "Abohm - abΩ" :
                editTextValueTo.setText(strAbohm);
                break;
            case "EMU of resistance - EMU":
                editTextValueTo.setText(strEMUofresistance);
                break;
            case "Statohm - stΩ":
                editTextValueTo.setText(strStatohm);
                break;
            case "ESU of resistance - ESU" :
                editTextValueTo.setText(strESUofresistance);
                break;
            case "Quantized Hall resistance - Ω" :
                editTextValueTo.setText(strQuantizedHallresistance);
                break;

        }


    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            this.finish();
        }

        return super.onOptionsItemSelected(item);
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