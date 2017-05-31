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

import com.nineinfosys.electricityconverter.ConverterActivityList.ElectricFieldStrengthListActivity;
import com.nineinfosys.electricityconverter.Engin.ElectricFieldStrengthConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectricFieldStrengthActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

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
    private int allunit = 13;
    DecimalFormat formatter = null;

    ElectricFieldStrengthConverter.ConversionResults item;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#59db59")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Electric Field Strength");

        formatsetting();
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

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreen)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreen)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreen)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreen)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreen)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorLightgreen)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#0aa828"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listLinearChargeFirstfrom = new ArrayList<String>();
        listLinearChargeFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listLinearChargeFirstfrom.add("Volt/meter - V/m");
        listLinearChargeFirstfrom.add("Kilovolt/meter - kV/m");
        listLinearChargeFirstfrom.add("Kilovolt/centimeter - kV/cm");
        listLinearChargeFirstfrom.add("Volt/centimeter - V/cm");
        listLinearChargeFirstfrom.add("Millivolt/meter - mV/m");
        //for first time running spinner
        listLinearChargeFirsttempTo.add("Volt/meter - V/m");
        listLinearChargeFirsttempTo.add("Kilovolt/meter - kV/m");
        listLinearChargeFirsttempTo.add("Kilovolt/centimeter - kV/cm");
        listLinearChargeFirsttempTo.add("Volt/centimeter - V/cm");
        listLinearChargeFirsttempTo.add("Millivolt/meter - mV/m");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ElectricFieldStrengthActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ElectricFieldStrengthActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirsttempTo);


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
                        listLinearChargefrom.add("Volt/meter - V/m");
                        listLinearChargefrom.add("Kilovolt/meter - kV/m");
                        listLinearChargefrom.add("Kilovolt/centimeter - kV/cm");
                        listLinearChargefrom.add("Volt/centimeter - V/cm");
                        listLinearChargefrom.add("Millivolt/meter - mV/m");

                        //for first time running spinner
                        listLinearChargeTo.add("Volt/meter - V/m");
                        listLinearChargeTo.add("Kilovolt/meter - kV/m");
                        listLinearChargeTo.add("Kilovolt/centimeter - kV/cm");
                        listLinearChargeTo.add("Volt/centimeter - V/cm");
                        listLinearChargeTo.add("Millivolt/meter - mV/m");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        //for first  running spinner
                        listLinearChargefrom.add("Volt/meter - V/m");
                        listLinearChargefrom.add("Kilovolt/meter - kV/m");
                        listLinearChargefrom.add("Kilovolt/centimeter - kV/cm");
                        listLinearChargefrom.add("Volt/centimeter - V/cm");
                        listLinearChargefrom.add("Millivolt/meter - mV/m");
                        listLinearChargefrom.add("Microvolt/meter - µ/m");

                        listLinearChargefrom.add("Kilovolt/inch - kV/in");
                        listLinearChargefrom.add("Volt/inch - V/in");
                        listLinearChargefrom.add("Volt/mil - V/mil");
                        listLinearChargefrom.add("Abvolt/centimeter - abV/cm");
                        listLinearChargefrom.add("Statvolt/centimeter - stV/cm");
                        listLinearChargefrom.add("Statvolt/inch - stV/in");
                        listLinearChargefrom.add("Newton/coulomb - N/C");





                        //for second running spinner
                        listLinearChargeTo.add("Volt/meter - V/m");
                        listLinearChargeTo.add("Kilovolt/meter - kV/m");
                        listLinearChargeTo.add("Kilovolt/centimeter - kV/cm");
                        listLinearChargeTo.add("Volt/centimeter - V/cm");
                        listLinearChargeTo.add("Millivolt/meter - mV/m");
                        listLinearChargeTo.add("Microvolt/meter - µ/m");

                        listLinearChargeTo.add("Kilovolt/inch - kV/in");
                        listLinearChargeTo.add("Volt/inch - V/in");
                        listLinearChargeTo.add("Volt/mil - V/mil");
                        listLinearChargeTo.add("Abvolt/centimeter - abV/cm");
                        listLinearChargeTo.add("Statvolt/centimeter - stV/cm");
                        listLinearChargeTo.add("Statvolt/inch - stV/in");
                        listLinearChargeTo.add("Newton/coulomb - N/C");





                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ElectricFieldStrengthActivity.this, android.R.layout.simple_spinner_item, listLinearChargefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ElectricFieldStrengthActivity.this, android.R.layout.simple_spinner_item, listLinearChargeTo);


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
                Intent i = new Intent(this,ElectricFieldStrengthListActivity.class);
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

            ElectricFieldStrengthConverter c = new ElectricFieldStrengthConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<ElectricFieldStrengthConverter.ConversionResults> results = c.calculateLElectricFieldStrengthConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

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



                switch (strSpinnerFromvalue1) {
                    case "Volt/meter - V/m" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilovolt/meter - kV/m":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Kilovolt/centimeter - kV/cm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Volt/centimeter - V/cm" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millivolt/meter - mV/m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microvolt/meter - µ/m":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilovolt/inch - kV/in" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Volt/inch - V/in":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Volt/mil - V/mil":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Abvolt/centimeter - abV/cm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Statvolt/centimeter - stV/cm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Statvolt/inch - stV/in":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Newton/coulomb - N/C":
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

            case "Volt/meter - V/m" :
                editTextValueTo.setText(strVoltpermeter);
                break;
            case "Kilovolt/meter - kV/m":
                editTextValueTo.setText(strKilovoltpermeter);
                break;

            case "Kilovolt/centimeter - kV/cm":
                editTextValueTo.setText(strkilovoltpercentimeter);
                break;
            case "Volt/centimeter - V/cm" :
                editTextValueTo.setText(strVoltpercentimeter);
                break;
            case "Millivolt/meter - mV/m":
                editTextValueTo.setText(strMillivoltpermeter);
                break;
            case "Microvolt/meter - µ/m":
                editTextValueTo.setText(strMicrovoltpermeter);
                break;
            case "Kilovolt/inch - kV/in" :
                editTextValueTo.setText(strKilovoltperinch);
                break;
            case "Volt/inch - V/in":
                editTextValueTo.setText(strVoltperinch);
                break;

            case "Volt/mil - V/mil":
                editTextValueTo.setText(strVoltpermil);
                break;
            case "Abvolt/centimeter - abV/cm":
                editTextValueTo.setText(strAbvoltpercentimeter);
                break;
            case "Statvolt/centimeter - stV/cm":
                editTextValueTo.setText(strStatvoltpercentimeter);
                break;
            case "Statvolt/inch - stV/in":
                editTextValueTo.setText(strStatvoltperinch);
                break;
            case "Newton/coulomb - N/C":
                editTextValueTo.setText(strNewtonpercoulomb);
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