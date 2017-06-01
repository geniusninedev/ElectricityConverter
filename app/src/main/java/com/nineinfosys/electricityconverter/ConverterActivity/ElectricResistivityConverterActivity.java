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
import com.nineinfosys.electricityconverter.ConverterActivityList.ElectricResistivityListActivity;
import com.nineinfosys.electricityconverter.Engin.ElectricResistivityConverter;
import com.nineinfosys.electricityconverter.R;
import com.nineinfosys.electricityconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectricResistivityConverterActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

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
    private int basicunit = 3;
    private int allunit = 8;
    DecimalFormat formatter = null;

    ElectricResistivityConverter.ConversionResults item;
    private String strOhmmeter = null;
    private String strOhmcentimeter = null;
    private String strOhminch = null;
    private  String strMicrohmcentimeter = null;
    private String strMicrohminch = null;
    private String strAbohmcentimeter = null;

    private String strStatohmcentimeter = null;
    private  String strCircularmilohmperfoot = null;
    private static final int REQUEST_CODE = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d32f2f")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Electric Resistivity");

        formatsetting();
        MobileAds.initialize(ElectricResistivityConverterActivity.this, getString(R.string.ads_app_id));
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
        listLinearChargeFirstfrom.add("Ohm meter - Ωm");
        listLinearChargeFirstfrom.add("Ohm centimeter - Ωcm");
        listLinearChargeFirstfrom.add("Ohm inch - Ωin");

        //for first time running spinner
        listLinearChargeFirsttempTo.add("Ohm meter - Ωm");
        listLinearChargeFirsttempTo.add("Ohm centimeter - Ωcm");
        listLinearChargeFirsttempTo.add("Ohm inch - Ωin");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ElectricResistivityConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(ElectricResistivityConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeFirsttempTo);


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
                        listLinearChargefrom.add("Ohm meter - Ωm");
                        listLinearChargefrom.add("Ohm centimeter - Ωcm");
                        listLinearChargefrom.add("Ohm inch - Ωin");
                        //for first time running spinner
                        listLinearChargeTo.add("Ohm meter - Ωm");
                        listLinearChargeTo.add("Ohm centimeter - Ωcm");
                        listLinearChargeTo.add("Ohm inch - Ωin");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listLinearChargefrom.clear();
                        listLinearChargeTo.clear();

                        //for first  running spinner
                        listLinearChargefrom.add("Ohm meter - Ωm");
                        listLinearChargefrom.add("Ohm centimeter - Ωcm");
                        listLinearChargefrom.add("Ohm inch - Ωin");
                        listLinearChargefrom.add("Microhm centimeter - µΩcm");
                        listLinearChargefrom.add("Microhm inch -  µΩin");
                        listLinearChargefrom.add("Abohm centimeter - abΩcm");
                        listLinearChargefrom.add("Statohm centimeter - stΩcm");
                        listLinearChargefrom.add("Circular mil ohm/foot - circular mil Ω/ft");


                        //for second running spinner

                        listLinearChargeTo.add("Ohm meter - Ωm");
                        listLinearChargeTo.add("Ohm centimeter - Ωcm");
                        listLinearChargeTo.add("Ohm inch - Ωin");
                        listLinearChargeTo.add("Microhm centimeter - µΩcm");
                        listLinearChargeTo.add("Microhm inch -  µΩin");
                        listLinearChargeTo.add("Abohm centimeter - abΩcm");
                        listLinearChargeTo.add("Statohm centimeter - stΩcm");
                        listLinearChargeTo.add("Circular mil ohm/foot - circular mil Ω/ft");


                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ElectricResistivityConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargefrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(ElectricResistivityConverterActivity.this, android.R.layout.simple_spinner_item, listLinearChargeTo);


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
                Intent i = new Intent(this,ElectricResistivityListActivity.class);
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

            ElectricResistivityConverter c = new ElectricResistivityConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<ElectricResistivityConverter.ConversionResults> results = c.calculateElectricResistivityConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strOhmmeter = String.valueOf(formatter.format(item.getOhmmeter()));
                strOhmcentimeter =String.valueOf(formatter.format(item.getOhmcentimeter()));
                strOhminch =String.valueOf(formatter.format(item.getOhminch()));
                strMicrohmcentimeter =String.valueOf(formatter.format(item.getMicrohmcentimeter()));
                strMicrohminch = String.valueOf(formatter.format(item.getMicrohminch()));
                strAbohmcentimeter =String.valueOf(formatter.format(item.getAbohmcentimeter()));

                strStatohmcentimeter =String.valueOf(formatter.format(item.getStatohmcentimeter()));
                strCircularmilohmperfoot =String.valueOf(formatter.format(item.getCircularmilohmperfoot()));



                switch (strSpinnerFromvalue1) {
                    case "Ohm meter - Ωm" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Ohm centimeter - Ωcm":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Ohm inch - Ωin" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microhm centimeter - µΩcm" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microhm inch -  µΩin":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Abohm centimeter - abΩcm":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Statohm centimeter - stΩcm" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Circular mil ohm/foot - circular mil Ω/ft":
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

            case "Ohm meter - Ωm" :
                editTextValueTo.setText(strOhmmeter);
                break;
            case "Ohm centimeter - Ωcm":
                editTextValueTo.setText(strOhmcentimeter);
                break;

            case "Ohm inch - Ωin" :
                editTextValueTo.setText(strOhminch);
                break;
            case "Microhm centimeter - µΩcm" :
                editTextValueTo.setText(strMicrohmcentimeter);
                break;


            case "Microhm inch -  µΩin":
                editTextValueTo.setText(strMicrohminch);
                break;
            case "Abohm centimeter - abΩcm":
                editTextValueTo.setText(strAbohmcentimeter);
                break;
            case "Statohm centimeter - stΩcm" :
                editTextValueTo.setText(strStatohmcentimeter);
                break;

            case "Circular mil ohm/foot - circular mil Ω/ft":
                editTextValueTo.setText(strCircularmilohmperfoot);
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