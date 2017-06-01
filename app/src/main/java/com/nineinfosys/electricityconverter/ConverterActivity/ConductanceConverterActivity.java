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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.electricityconverter.ConverterActivityList.ConductanceConverterListActivity;
import com.nineinfosys.electricityconverter.Engin.ConductanceConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConductanceConverterActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    private static final int REQUEST_CODE = 100;
    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listLinearChargeFirsttempTo, listLinearChargeFirstfrom,listLinearChargeTo,listLinearChargefrom;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 5;
    private int allunit = 12;
    DecimalFormat formatter = null;

    ConductanceConverter.ConversionResults item;
    private String strSiemens = null;
    private String strMegasiemens = null;
    private String strKilosiemens = null;
    private String strMilisiemens = null;
    private  String strMicrosiemens = null;
    private String strAmperepervolt = null;
    private String strMho = null;

    private String strGemmho = null;
    private String strMicromho = null;
    private String strAbmho = null;
    private  String strStatmho = null;
    private String strQuantizedHallConductance = null;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e58f0c")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Electric Conductance");

        formatsetting();

        MobileAds.initialize(ConductanceConverterActivity.this, getString(R.string.ads_app_id));
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

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.coloryellowish)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.coloryellowish)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.coloryellowish)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.coloryellowish)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.coloryellowish)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.coloryellowish)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#FFB1700C"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listLinearChargeFirstfrom = new ArrayList<String>();
        listLinearChargeFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listLinearChargeFirstfrom.add("Siemens - S");
        listLinearChargeFirstfrom.add("Megasiemens - MS");
        listLinearChargeFirstfrom.add("Kilosiemens - kS");
        listLinearChargeFirstfrom.add("Milisiemens - mS");
        listLinearChargeFirstfrom.add("Microsiemens - µS");
        //for first time running spinner
        listLinearChargeFirsttempTo.add("Siemens - S");
        listLinearChargeFirsttempTo.add("Megasiemens - MS");
        listLinearChargeFirsttempTo.add("Kilosiemens - kS");
        listLinearChargeFirsttempTo.add("Milisiemens - mS");
        listLinearChargeFirsttempTo.add("Microsiemens - µS");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ConductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ConductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirsttempTo);


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
                        listLinearChargefrom.add("Siemens - S");
                        listLinearChargefrom.add("Megasiemens - MS");
                        listLinearChargefrom.add("Kilosiemens - kS");
                        listLinearChargefrom.add("Milisiemens - mS");
                        listLinearChargefrom.add("Microsiemens - µS");

                        //for first time running spinner
                        listLinearChargeTo.add("Siemens - S");
                        listLinearChargeTo.add("Megasiemens - MS");
                        listLinearChargeTo.add("Kilosiemens - kS");
                        listLinearChargeTo.add("Milisiemens - mS");
                        listLinearChargeTo.add("Microsiemens - µS");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        //for first  running spinner
                        listLinearChargefrom.add("Siemens - S");
                        listLinearChargefrom.add("Megasiemens - MS");
                        listLinearChargefrom.add("Kilosiemens - kS");
                        listLinearChargefrom.add("Milisiemens - mS");
                        listLinearChargefrom.add("Microsiemens - µS");
                        listLinearChargefrom.add("Ampere/volt - A/V");
                        listLinearChargefrom.add("Mho - mho");
                        listLinearChargefrom.add("Gemmho - gemmho");
                        listLinearChargefrom.add("Micromho - µmho");
                        listLinearChargefrom.add("Abmho - abmho");
                        listLinearChargefrom.add("Statmho - stmho");
                        listLinearChargefrom.add("Quantized Hall Conductance - mho");




                        //for second running spinner
                        listLinearChargeTo.add("Siemens - S");
                        listLinearChargeTo.add("Megasiemens - MS");
                        listLinearChargeTo.add("Kilosiemens - kS");
                        listLinearChargeTo.add("Milisiemens - mS");
                        listLinearChargeTo.add("Microsiemens - µS");
                        listLinearChargeTo.add("Ampere/volt - A/V");
                        listLinearChargeTo.add("Mho - mho");
                        listLinearChargeTo.add("Gemmho - gemmho");
                        listLinearChargeTo.add("Micromho - µmho");
                        listLinearChargeTo.add("Abmho - abmho");
                        listLinearChargeTo.add("Statmho - stmho");
                        listLinearChargeTo.add("Quantized Hall Conductance - mho");
                        break;



                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ConductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ConductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeTo);


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
                Intent i = new Intent(this,ConductanceConverterListActivity.class);
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

            ConductanceConverter c = new ConductanceConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<ConductanceConverter.ConversionResults> results = c.calculateConductanceConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strSiemens = String.valueOf(formatter.format(item.getSiemens()));
                strMegasiemens =String.valueOf(formatter.format(item.getMegasiemens()));
                strKilosiemens =String.valueOf(formatter.format(item.getKilosiemens()));
                strMilisiemens =String.valueOf(formatter.format(item.getMilisiemens()));
                strMicrosiemens = String.valueOf(formatter.format(item.getMicrosiemens()));
                strAmperepervolt =String.valueOf(formatter.format(item.getAmperepervolt()));
                strMho = String.valueOf(formatter.format(item.getMho()));
                strGemmho =String.valueOf(formatter.format(item.getGemmho()));
                strMicromho =String.valueOf(formatter.format(item.getMicromho()));
                strAbmho =String.valueOf(formatter.format(item.getAbmho()));
                strStatmho = String.valueOf(formatter.format(item.getStatmho()));
                strQuantizedHallConductance =String.valueOf(formatter.format(item.getQuantizedhallconductance()));



                switch (strSpinnerFromvalue1) {
                    case "Siemens - S":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Megasiemens - MS":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Kilosiemens - kS":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Milisiemens - mS" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microsiemens - µS":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ampere/volt - A/V" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Mho - mho":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gemmho - gemmho" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Micromho - µmho":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Abmho - abmho":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Statmho - stmho":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Quantized Hall Conductance - mho":
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


            case "Siemens - S":
                editTextValueTo.setText(strSiemens);
                break;
            case "Megasiemens - MS":
                editTextValueTo.setText(strMegasiemens);
                break;

            case "Kilosiemens - kS":
                editTextValueTo.setText(strKilosiemens);
                break;
            case "Milisiemens - mS" :
                editTextValueTo.setText(strMilisiemens);
                break;
            case "Microsiemens - µS":
                editTextValueTo.setText(strMicrosiemens);
                break;
            case "Ampere/volt - A/V" :
                editTextValueTo.setText(strAmperepervolt);
                break;
            case "Mho - mho":
                editTextValueTo.setText(strMho);
                break;
            case "Gemmho - gemmho" :
                editTextValueTo.setText(strGemmho);
                break;
            case "Micromho - µmho":
                editTextValueTo.setText(strMicromho);
                break;

            case "Abmho - abmho":
                editTextValueTo.setText(strAbmho);
                break;
            case "Statmho - stmho":
                editTextValueTo.setText(strStatmho);
                break;
            case "Quantized Hall Conductance - mho":
                editTextValueTo.setText(strQuantizedHallConductance);
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