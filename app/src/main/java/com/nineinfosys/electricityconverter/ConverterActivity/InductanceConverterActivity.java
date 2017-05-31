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


import com.nineinfosys.electricityconverter.ConverterActivityList.InductanceListActivity;
import com.nineinfosys.electricityconverter.Engin.InductanceConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class InductanceConverterActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

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
    private int basicunit = 8;
    private int allunit = 22;
    DecimalFormat formatter = null;

    InductanceConverter.ConversionResults item;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d32f2f")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Inductance");

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

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRed)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#9a0007"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listLinearChargeFirstfrom = new ArrayList<String>();
        listLinearChargeFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listLinearChargeFirstfrom.add("Henry - H");
        listLinearChargeFirstfrom.add("Exahenry - EH");
        listLinearChargeFirstfrom.add("Terahenry - TH");
        listLinearChargeFirstfrom.add("Petahenry - PH");
        listLinearChargeFirstfrom.add("Gigahenry - GH");
        listLinearChargeFirstfrom.add("Megahenry - MH");
        listLinearChargeFirstfrom.add("Kilohenry - kH");
        listLinearChargeFirstfrom.add("Hectohenry - hH");
        //for first time running spinner
        listLinearChargeFirsttempTo.add("Henry - H");
        listLinearChargeFirsttempTo.add("Exahenry - EH");
        listLinearChargeFirsttempTo.add("Terahenry - TH");
        listLinearChargeFirsttempTo.add("Petahenry - PH");
        listLinearChargeFirsttempTo.add("Gigahenry - GH");
        listLinearChargeFirsttempTo.add("Megahenry - MH");
        listLinearChargeFirsttempTo.add("Kilohenry - kH");
        listLinearChargeFirsttempTo.add("Hectohenry - hH");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(InductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(InductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirsttempTo);


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
                        listLinearChargefrom.add("Henry - H");
                        listLinearChargefrom.add("Exahenry - EH");
                        listLinearChargefrom.add("Terahenry - TH");
                        listLinearChargefrom.add("Petahenry - PH");
                        listLinearChargefrom.add("Gigahenry - GH");
                        listLinearChargefrom.add("Megahenry - MH");
                        listLinearChargefrom.add("Kilohenry - kH");
                        listLinearChargefrom.add("Hectohenry - hH");
                        //for first time running spinner
                        listLinearChargeTo.add("Henry - H");
                        listLinearChargeTo.add("Exahenry - EH");
                        listLinearChargeTo.add("Terahenry - TH");
                        listLinearChargeTo.add("Petahenry - PH");
                        listLinearChargeTo.add("Gigahenry - GH");
                        listLinearChargeTo.add("Megahenry - MH");
                        listLinearChargeTo.add("Kilohenry - kH");
                        listLinearChargeTo.add("Hectohenry - hH");

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        //for first  running spinner
                        listLinearChargefrom.add("Henry - H");
                        listLinearChargefrom.add("Exahenry - EH");
                        listLinearChargefrom.add("Terahenry - TH");
                        listLinearChargefrom.add("Petahenry - PH");
                        listLinearChargefrom.add("Gigahenry - GH");
                        listLinearChargefrom.add("Megahenry - MH");
                        listLinearChargefrom.add("Kilohenry - kH");
                        listLinearChargefrom.add("Hectohenry - hH");
                        listLinearChargefrom.add("Dekahenry - daH");
                        listLinearChargefrom.add("Decihenry - dH");
                        listLinearChargefrom.add("Centihenry - cH");
                        listLinearChargefrom.add("Milihenry - mH");
                        listLinearChargefrom.add("Microhenry - µH");
                        listLinearChargefrom.add("Nanohenry - nH");
                        listLinearChargefrom.add("Picohenry - pH");
                        listLinearChargefrom.add("Femtohenry - fH");
                        listLinearChargefrom.add("Attohenery - aH" );
                        listLinearChargefrom.add("Weber/ampere - Wb/A");
                        listLinearChargefrom.add("Abhenery - abH");
                        listLinearChargefrom.add("EMU of inductance - EMU");
                        listLinearChargefrom.add("Stathenry - stH");
                        listLinearChargefrom.add("ESU of inductance - ESU");





                        //for second running spinner
                        listLinearChargeTo.add("Henry - H");
                        listLinearChargeTo.add("Exahenry - EH");
                        listLinearChargeTo.add("Terahenry - TH");
                        listLinearChargeTo.add("Petahenry - PH");
                        listLinearChargeTo.add("Gigahenry - GH");
                        listLinearChargeTo.add("Megahenry - MH");
                        listLinearChargeTo.add("Kilohenry - kH");
                        listLinearChargeTo.add("Hectohenry - hH");
                        listLinearChargeTo.add("Dekahenry - daH");
                        listLinearChargeTo.add("Decihenry - dH");
                        listLinearChargeTo.add("Centihenry - cH");
                        listLinearChargeTo.add("Milihenry - mH");

                        listLinearChargeTo.add("Microhenry - µH");
                        listLinearChargeTo.add("Nanohenry - nH");
                        listLinearChargeTo.add("Picohenry - pH");
                        listLinearChargeTo.add("Femtohenry - fH");

                        listLinearChargeTo.add("Attohenery - aH" );
                        listLinearChargeTo.add("Weber/ampere - Wb/A");
                        listLinearChargeTo.add("Abhenery - abH");
                        listLinearChargeTo.add("EMU of inductance - EMU");
                        listLinearChargeTo.add("Stathenry - stH");
                        listLinearChargeTo.add("ESU of inductance - ESU");



                        break;



                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(InductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(InductanceConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeTo);


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
                Intent i = new Intent(this,InductanceListActivity.class);
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
    /*@Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(TempertureActivity.this, TempertureActivity.class);  //your class
        startActivity(i);
        finish();

    }*/

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

            InductanceConverter c = new InductanceConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<InductanceConverter.ConversionResults> results = c.calculateInductanceConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strHenry = String.valueOf(formatter.format(item.getHenry()));
                strExahenry =String.valueOf(formatter.format(item.getExahenry()));
                strterahenry =String.valueOf(formatter.format(item.getTerahenry()));
                strPetahenry =String.valueOf(formatter.format(item.getPetahenry()));
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



                switch (strSpinnerFromvalue1) {
                    case "Henry - H":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Exahenry - EH":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Terahenry - TH":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Petahenry - PH":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Gigahenry - GH" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Megahenry - MH":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Kilohenry - kH":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Hectohenry - hH" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Dekahenry - daH":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Decihenry - dH":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Centihenry - cH":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Milihenry - mH":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microhenry - µH" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Nanohenry - nH":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Picohenry - pH":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Femtohenry - fH":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Attohenery - aH" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Weber/ampere - Wb/A" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Abhenery - abH":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "EMU of inductance - EMU":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Stathenry - stH" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "ESU of inductance - ESU":
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

            case "Henry - H":
                editTextValueTo.setText(strHenry);
                break;
            case "Exahenry - EH":
                editTextValueTo.setText(strExahenry);
                break;

            case "Terahenry - TH":
                editTextValueTo.setText(strterahenry);
                break;
            case "Petahenry - PH":
                editTextValueTo.setText(strPetahenry);
                break;

            case "Gigahenry - GH" :
                editTextValueTo.setText(strGigahenry);
                break;
            case "Megahenry - MH":
                editTextValueTo.setText(strMegahenry);
                break;

            case "Kilohenry - kH":
                editTextValueTo.setText(strKilohenry);
                break;
            case "Hectohenry - hH" :
                editTextValueTo.setText(strHectohenry);
                break;
            case "Dekahenry - daH":
                editTextValueTo.setText(strDekahenry);
                break;

            case "Decihenry - dH":
                editTextValueTo.setText(strDecihenry);
                break;
            case "Centihenry - cH":
                editTextValueTo.setText(strCentihenry);
                break;
            case "Milihenry - mH":
                editTextValueTo.setText(strMilihenry);
                break;
            case "Microhenry - µH" :
                editTextValueTo.setText(strMicrohenry);
                break;
            case "Nanohenry - nH":
                editTextValueTo.setText(strNanohenry);
                break;

            case "Picohenry - pH":
                editTextValueTo.setText(strPicohenry);
                break;
            case "Femtohenry - fH":
                editTextValueTo.setText(strFemtohenry);
                break;

            case "Attohenery - aH" :
                editTextValueTo.setText(strAttohenery);
                break;
            case "Weber/ampere - Wb/A" :
                editTextValueTo.setText(strWeberperampere);
                break;
            case "Abhenery - abH":
                editTextValueTo.setText(strAbhenery);
                break;

            case "EMU of inductance - EMU":
                editTextValueTo.setText(strEMUofinductance);
                break;
            case "Stathenry - stH" :
                editTextValueTo.setText(strStathenry);
                break;
            case "ESU of inductance - ESU":
                editTextValueTo.setText(strESUofinductance);
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