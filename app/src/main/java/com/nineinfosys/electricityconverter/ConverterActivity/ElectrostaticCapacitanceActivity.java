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

import com.nineinfosys.electricityconverter.ConverterActivityList.CapacitanceConverterListActivity;
import com.nineinfosys.electricityconverter.Engin.ElectrostaticCapacitanceConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectrostaticCapacitanceActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listLinearChargeFirsttempTo, listLinearChargeFirstfrom,listLinearChargeTo,listLinearChargefrom;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 8;
    private int allunit = 22;
    private static final int REQUEST_CODE = 100;
    DecimalFormat formatter = null;

    ElectrostaticCapacitanceConverter.ConversionResults item;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#a05445")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Electrostatic Capacitance");

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

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBrown)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBrown)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBrown)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBrown)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBrown)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorBrown)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#6e291d"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listLinearChargeFirstfrom = new ArrayList<String>();
        listLinearChargeFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listLinearChargeFirstfrom.add("Farad - F");
        listLinearChargeFirstfrom.add("Exafarad - EF");
        listLinearChargeFirstfrom.add("Petafarad - PF");
        listLinearChargeFirstfrom.add("Terafarad - TF");
        listLinearChargeFirstfrom.add("Gigafarad - GF");
        listLinearChargeFirstfrom.add("Megafarad - MF");
        listLinearChargeFirstfrom.add("Kilofarad - kF");
        listLinearChargeFirstfrom.add("Hectofarad - hF");
        //for first time running spinner
        listLinearChargeFirsttempTo.add("Farad - F");
        listLinearChargeFirsttempTo.add("Exafarad - EF");
        listLinearChargeFirsttempTo.add("Petafarad - PF");
        listLinearChargeFirsttempTo.add("Terafarad - TF");
        listLinearChargeFirsttempTo.add("Gigafarad - GF");
        listLinearChargeFirsttempTo.add("Megafarad - MF");
        listLinearChargeFirsttempTo.add("Kilofarad - kF");
        listLinearChargeFirsttempTo.add("Hectofarad - hF");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ElectrostaticCapacitanceActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ElectrostaticCapacitanceActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirsttempTo);


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
                        listLinearChargefrom.add("Farad - F");
                        listLinearChargefrom.add("Exafarad - EF");
                        listLinearChargefrom.add("Petafarad - PF");
                        listLinearChargefrom.add("Terafarad - TF");
                        listLinearChargefrom.add("Gigafarad - GF");
                        listLinearChargefrom.add("Megafarad - MF");
                        listLinearChargefrom.add("Kilofarad - kF");
                        listLinearChargefrom.add("Hectofarad - hF");
                        //for first time running spinner
                        listLinearChargeTo.add("Farad - F");
                        listLinearChargeTo.add("Exafarad - EF");
                        listLinearChargeTo.add("Petafarad - PF");
                        listLinearChargeTo.add("Terafarad - TF");
                        listLinearChargeTo.add("Gigafarad - GF");
                        listLinearChargeTo.add("Megafarad - MF");
                        listLinearChargeTo.add("Kilofarad - kF");
                        listLinearChargeTo.add("Hectofarad - hF");

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        listLinearChargefrom.add("Farad - F");
                        listLinearChargefrom.add("Exafarad - EF");
                        listLinearChargefrom.add("Petafarad - PF");
                        listLinearChargefrom.add("Terafarad - TF");
                        listLinearChargefrom.add("Gigafarad - GF");
                        listLinearChargefrom.add("Megafarad - MF");
                        listLinearChargefrom.add("Kilofarad - kF");
                        listLinearChargefrom.add("Hectofarad - hF");
                        listLinearChargefrom.add("Dekafarad - dF");
                        listLinearChargefrom.add("Decifarad - dF");
                        listLinearChargefrom.add("Centifarad - cF");
                        listLinearChargefrom.add("Millifarad - mF");
                        listLinearChargefrom.add("Microfarad - µF");
                        listLinearChargefrom.add("Nanofarad - nF");
                        listLinearChargefrom.add("Femtofarad - fF");
                        listLinearChargefrom.add("Attofarad - aF");
                        listLinearChargefrom.add("Coulomb/volt - C/v" );
                        listLinearChargefrom.add("Abfarad - abF");
                        listLinearChargefrom.add("EMU of capacitance - EMU");
                        listLinearChargefrom.add("Statfarad - stF");
                        listLinearChargefrom.add("ESU of capacitance - ESU");


                        //for second running spinner
                        listLinearChargeTo.add("Farad - F");
                        listLinearChargeTo.add("Exafarad - EF");
                        listLinearChargeTo.add("Petafarad - PF");
                        listLinearChargeTo.add("Terafarad - TF");
                        listLinearChargeTo.add("Gigafarad - GF");
                        listLinearChargeTo.add("Megafarad - MF");
                        listLinearChargeTo.add("Kilofarad - kF");
                        listLinearChargeTo.add("Hectofarad - hF");
                        listLinearChargeTo.add("Dekafarad - dF");
                        listLinearChargeTo.add("Decifarad - dF");
                        listLinearChargeTo.add("Centifarad - cF");
                        listLinearChargeTo.add("Millifarad - mF");

                        listLinearChargeTo.add("Microfarad - µF");
                        listLinearChargeTo.add("Nanofarad - nF");
                        listLinearChargeTo.add("Femtofarad - fF");
                        listLinearChargeTo.add("Attofarad - aF");

                        listLinearChargeTo.add("Coulomb/volt - C/v" );
                        listLinearChargeTo.add("Abfarad - abF");
                        listLinearChargeTo.add("EMU of capacitance - EMU");
                        listLinearChargeTo.add("Statfarad - stF");
                        listLinearChargeTo.add("ESU of capacitance - ESU");
                        break;



                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ElectrostaticCapacitanceActivity.this, android.R.layout.simple_spinner_item, listLinearChargefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ElectrostaticCapacitanceActivity.this, android.R.layout.simple_spinner_item, listLinearChargeTo);


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
                Intent i = new Intent(this,CapacitanceConverterListActivity.class);
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

            ElectrostaticCapacitanceConverter c = new ElectrostaticCapacitanceConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<ElectrostaticCapacitanceConverter.ConversionResults> results = c.calculatecapacitanceConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

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



                switch (strSpinnerFromvalue1) {
                    case "Farad - F":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Exafarad - EF":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Petafarad - PF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Terafarad - TF" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gigafarad - GF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Megafarad - MF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilofarad - kF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Hectofarad - hF" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Dekafarad - dF":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Decifarad - dF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Centifarad - cF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millifarad - mF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microfarad - µF" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Nanofarad - nF":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Picofarad - pF":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Femtofarad - fF":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Attofarad - aF" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Coulomb/volt - C/v" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Abfarad - abF":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "EMU of capacitance - EMU":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Statfarad - stF" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "ESU of capacitance - ESU":
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

            case "Farad - F":
                editTextValueTo.setText(strFarad);
                break;
            case "Exafarad - EF":
                editTextValueTo.setText(strExafarad);
                break;

            case "Petafarad - PF":
                editTextValueTo.setText(strPetafarad);
                break;
            case "Terafarad - TF" :
                editTextValueTo.setText(strTerafarad);
                break;
            case "Gigafarad - GF":
                editTextValueTo.setText(strGigafarad);
                break;
            case "Megafarad - MF":
                editTextValueTo.setText(strMegafarad);
                break;
            case "Kilofarad - kF":
                editTextValueTo.setText(strKilofarad);
                break;
            case "Hectofarad - hF" :
                editTextValueTo.setText(strHectofarad);
                break;
            case "Dekafarad - dF":
                editTextValueTo.setText(strDekafarad);
                break;

            case "Decifarad - dF":
                editTextValueTo.setText(strDecifarad);
                break;
            case "Centifarad - cF":
                editTextValueTo.setText(strCentifarad);
                break;
            case "Millifarad - mF":
                editTextValueTo.setText(strMillifarad);
                break;
            case "Microfarad - µF" :
                editTextValueTo.setText(strMicrofarad);
                break;
            case "Nanofarad - nF":
                editTextValueTo.setText(strNanofarad);
                break;

            case "Picofarad - pF":
                editTextValueTo.setText(strPicofarad);
                break;
            case "Femtofarad - fF":
                editTextValueTo.setText(strFemtofarad);
                break;

            case "Attofarad - aF" :
                editTextValueTo.setText(strAttofarad);
                break;
            case "Coulomb/volt - C/v" :
                editTextValueTo.setText(strCoulombpervolt);
                break;
            case "Abfarad - abF":
                editTextValueTo.setText(strAbfarad);
                break;

            case "EMU of capacitance - EMU":
                editTextValueTo.setText(strEMUofcapacitance);
                break;
            case "Statfarad - stF" :
                editTextValueTo.setText(strStatfarad);
                break;
            case "ESU of capacitance - ESU":
                editTextValueTo.setText(strESUofcapacitance);
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