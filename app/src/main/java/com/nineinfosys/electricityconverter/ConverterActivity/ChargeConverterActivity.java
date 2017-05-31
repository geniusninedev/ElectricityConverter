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


import com.nineinfosys.electricityconverter.ConverterActivityList.ChargeConverterListActivity;
import com.nineinfosys.electricityconverter.Engin.ChargeConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChargeConverterActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

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
    private int basicunit = 6;
    private int allunit = 17;
    DecimalFormat formatter = null;

    ChargeConverter.ConversionResults item;
    private String strCoulomb = null;
    private String strMegacoulomb = null;
    private String strKilocoulomb = null;
    private String strMillicoulomb = null;
    private  String strMicrocoulomb = null;
    private String strNanocoulomb = null;
    private String strPicocoulomb = null;
    private String strAbcoulomb = null;
    private String strEMUofcharge = null;
    private String strStatcoulomb = null;
    private String strESUofcharge = null;
    private String strFranklin = null;
    private  String strAmperehour = null;
    private String strAmperesecond = null;
    private String strAmpereminute = null;
    private  String strFaraday = null;
    private String strElementarycharge = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2eaf46")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Charge");

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

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007e17"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listLinearChargeFirstfrom = new ArrayList<String>();
        listLinearChargeFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listLinearChargeFirstfrom.add("Coulomb - C");
        listLinearChargeFirstfrom.add("Megacoulomb - MC");
        listLinearChargeFirstfrom.add("Kilocoulomb - kC");
        listLinearChargeFirstfrom.add("Millicoulomb - mC");
        listLinearChargeFirstfrom.add("Microcoulomb - µC");
        listLinearChargeFirstfrom.add("Nanocoulomb - nC");
        //for first time running spinner
        listLinearChargeFirsttempTo.add("Coulomb - C");
        listLinearChargeFirsttempTo.add("Megacoulomb - MC");
        listLinearChargeFirsttempTo.add("Kilocoulomb - kC");
        listLinearChargeFirsttempTo.add("Millicoulomb - mC");
        listLinearChargeFirsttempTo.add("Microcoulomb - µC");
        listLinearChargeFirsttempTo.add("Nanocoulomb - nC");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ChargeConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ChargeConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirsttempTo);


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
                        listLinearChargefrom.add("Coulomb - C");
                        listLinearChargefrom.add("Megacoulomb - MC");
                        listLinearChargefrom.add("Kilocoulomb - kC");
                        listLinearChargefrom.add("Millicoulomb - mC");
                        listLinearChargefrom.add("Microcoulomb - µC");
                        listLinearChargefrom.add("Nanocoulomb - nC");
                        //for first time running spinner
                        listLinearChargeTo.add("Coulomb - C");
                        listLinearChargeTo.add("Megacoulomb - MC");
                        listLinearChargeTo.add("Kilocoulomb - kC");
                        listLinearChargeTo.add("Millicoulomb - mC");
                        listLinearChargeTo.add("Microcoulomb - µC");
                        listLinearChargeTo.add("Nanocoulomb - nC");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        //for first  running spinner
                        listLinearChargefrom.add("Coulomb - C");
                        listLinearChargefrom.add("Megacoulomb - MC");
                        listLinearChargefrom.add("Kilocoulomb - kC");
                        listLinearChargefrom.add("Millicoulomb - mC");
                        listLinearChargefrom.add("Microcoulomb - µC");
                        listLinearChargefrom.add("Nanocoulomb - nC");
                        listLinearChargefrom.add("Picocoulomb - pC");
                        listLinearChargefrom.add("EMU of charge - e");
                        listLinearChargefrom.add("Statcoulomb - stC");
                        listLinearChargefrom.add("ESU of charge - e");
                        listLinearChargefrom.add("Franklin - Fr");
                        listLinearChargefrom.add("Ampere-hour - A*h");
                        listLinearChargefrom.add("Ampere-minute - A*min");
                        listLinearChargefrom.add("Ampere-second - A*s");
                        listLinearChargefrom.add("Faraday - F");
                        listLinearChargefrom.add("Elementary charge - e");




                        //for second running spinner
                        listLinearChargeTo.add("Coulomb - C");
                        listLinearChargeTo.add("Megacoulomb - MC");
                        listLinearChargeTo.add("Kilocoulomb - kC");
                        listLinearChargeTo.add("Millicoulomb - mC");
                        listLinearChargeTo.add("Microcoulomb - µC");
                        listLinearChargeTo.add("Nanocoulomb - nC");
                        listLinearChargeTo.add("Picocoulomb - pC");
                        listLinearChargeTo.add("EMU of charge - e");
                        listLinearChargeTo.add("Statcoulomb - stC");
                        listLinearChargeTo.add("ESU of charge - e");
                        listLinearChargeTo.add("Franklin - Fr");
                        listLinearChargeTo.add("Ampere-hour - A*h");
                        listLinearChargeTo.add("Ampere-minute - A*min");
                        listLinearChargeTo.add("Ampere-second - A*s");
                        listLinearChargeTo.add("Faraday - F");
                        listLinearChargeTo.add("Elementary charge - e");

                        break;



                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ChargeConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ChargeConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeTo);


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
                Intent i = new Intent(this,ChargeConverterListActivity.class);
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

            ChargeConverter c = new ChargeConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<ChargeConverter.ConversionResults> results = c.calculatechargeConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strCoulomb = String.valueOf(formatter.format(item.getC()));
                strMegacoulomb =String.valueOf(formatter.format(item.getMC()));
                strKilocoulomb =String.valueOf(formatter.format(item.getkC()));
                strMillicoulomb =String.valueOf(formatter.format(item.getmC()));
                strMicrocoulomb = String.valueOf(formatter.format(item.getMicroC()));
                strNanocoulomb =String.valueOf(formatter.format(item.getnC()));
                strPicocoulomb = String.valueOf(formatter.format(item.getpC()));
                strAbcoulomb =String.valueOf(formatter.format(item.getAbC()));
                strEMUofcharge =String.valueOf(formatter.format(item.getEmu()));
                strStatcoulomb =String.valueOf(formatter.format(item.getStc()));
                strESUofcharge = String.valueOf(formatter.format(item.getEsu()));
                strFranklin =String.valueOf(formatter.format(item.getFr()));

                strAmperehour = String.valueOf(formatter.format(item.getAh()));
                strAmpereminute =String.valueOf(formatter.format(item.getAmin()));
                strAmperesecond = String.valueOf(formatter.format(item.getAs()));
                strFaraday =String.valueOf(formatter.format(item.getFaraday()));
                strElementarycharge =String.valueOf(formatter.format(item.getE()));


                switch (strSpinnerFromvalue1) {
                    case "Coulomb - C":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Megacoulomb - MC":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocoulomb - kC":
                        conversion(strSpinnerTovalue2);
                        break;


                    case "Millicoulomb - mC" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microcoulomb - µC":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Nanocoulomb - nC":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Picocoulomb - pC":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Abcoulomb - abC" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "EMU of charge - e":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Statcoulomb - stC":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "ESU of charge - e":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Franklin - Fr":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Ampere-hour - A*h":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ampere-minute - A*min":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Ampere-second - A*s":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Faraday - F":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Elementary charge - e":
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



            case "Coulomb - C":
                editTextValueTo.setText(strCoulomb);
                break;
            case "Megacoulomb - MC":
                editTextValueTo.setText(strMegacoulomb);
                break;
            case "Kilocoulomb - kC":
                editTextValueTo.setText(strKilocoulomb);
                break;


            case "Millicoulomb - mC" :
                editTextValueTo.setText(strMillicoulomb);
                break;
            case "Microcoulomb - µC":
                editTextValueTo.setText(strMicrocoulomb);
                break;
            case "Nanocoulomb - nC":
                editTextValueTo.setText(strNanocoulomb);
                break;
            case "Picocoulomb - pC":
                editTextValueTo.setText(strPicocoulomb);
                break;
            case "Abcoulomb - abC" :
                editTextValueTo.setText(strAbcoulomb);
                break;
            case "EMU of charge - e":
                editTextValueTo.setText(strEMUofcharge);
                break;

            case "Statcoulomb - stC":
                editTextValueTo.setText(strStatcoulomb);
                break;
            case "ESU of charge - e":
                editTextValueTo.setText(strESUofcharge);
                break;
            case "Franklin - Fr":
                editTextValueTo.setText(strFranklin);
                break;

            case "Ampere-hour - A*h":
                editTextValueTo.setText(strAmperehour);
                break;
            case "Ampere-minute - A*min":
                editTextValueTo.setText(strAmpereminute);
                break;

            case "Ampere-second - A*s":
                editTextValueTo.setText(strAmperesecond);
                break;

            case "Faraday - F":
                editTextValueTo.setText(strFaraday);
                break;

            case "Elementary charge - e":
                editTextValueTo.setText(strElementarycharge);
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