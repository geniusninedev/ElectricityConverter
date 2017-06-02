package com.nineinfosys.electricityconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.nineinfosys.electricityconverter.ConverterActivity.ChargeConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ConductanceConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ConductivityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.CurrentConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricFieldStrengthActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricPotentialActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricResistanceConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectricResistivityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.ElectrostaticCapacitanceActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.InductanceConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.LinearChargeDensityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.LinearCurrentDensityActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.SurfaceChargeDensityConverterActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.SurfaceCurrentDensityActivity;
import com.nineinfosys.electricityconverter.ConverterActivity.VolumeChargeDensityActivity;




public class SearchActivity extends AppCompatActivity implements TextWatcher {


    // List view
    private ListView lv;

    private String selectedItem;
    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Search Unit");


        // Listview Data
        String listitem[] = {

                //charge
                "Coulomb - C",
                "Megacoulomb - MC",
                "Kilocoulomb - kC",
                "Millicoulomb - mC",
                "Microcoulomb - µC",
                "Nanocoulomb - nC",
                "Picocoulomb - pC",
                "EMU of charge - e",
                "Statcoulomb - stC",
                "ESU of charge - e",
                "Franklin - Fr",
                "Ampere-hour - A*h",
                "Ampere-minute - A*min",
                "Ampere-second - A*s",
                "Faraday - F",
                "Elementary charge - e",

                //conductance
                "Siemens - S",
                "Megasiemens - MS",
                "Kilosiemens - kS",
                "Milisiemens - mS",
                "Microsiemens - µS",
                "Ampere/volt - A/V",
                "Mho - mho",
                "Gemmho - gemmho",
                "Micromho - µmho",
                "Abmho - abmho",
                "Statmho - stmho",
                "Quantized Hall Conductance - mho",

                //conductivity
                "Siemens/meter - S/m",
                "Picosiemens/meter - pS/m",
                "Mho/meter - mho/m",
                "Mho/centimeter - mho/cm",
                "Abmho/meter - abmho/m",
                "Abmho/centimeter - abmho/cm",
                "Statmho/meter - stmho/m",
                "Statmho/centimeter - st/cm",

                //current
                "Ampere - A",
                "Kiloampere - kA",
                "Milliampere - mA",
                "Biot - Bi",
                "Abampere - abA",
                "EMU of current - emuA",
                "Statampere - stA",
                "ESU of current - esuA",
                "CGS e.m.unit - e.m.unit",
                "CGS e.s.unit - e.s.unit",

                "Volt/meter - V/m",
                "Kilovolt/meter - kV/m",
                "Kilovolt/centimeter - kV/cm",
                "Volt/centimeter - V/cm",
                "Millivolt/meter - mV/m",
                "Microvolt/meter - µ/m",

                "Volt - V",
                "Watt/ampere - W/A",
                "Abvolt - AbV",
                "EMU of electric potential - EMU",
                "Statvolt - stV",
                "ESU of electric potential - ESU",

                //electric resistance
                "Ohm - Ω",
                "Megohm - megohm",
                "Microhm - microhm",
                "Volt/ampere - V/A",
                "Reciprocal siemens - 1/S",
                "Abohm - abΩ",
                "EMU of resistance - EMU",
                "Statohm - stΩ",
                "ESU of resistance - ESU",
                "Quantized Hall resistance - Ω",

                //electric resisitvity
                "Ohm meter - Ωm",
                "Ohm centimeter - Ωcm",
                "Ohm inch - Ωin",
                "Microhm centimeter - µΩcm",
                "Microhm inch -  µΩin",
                "Abohm centimeter - abΩcm",
                "Statohm centimeter - stΩcm",
                "Circular mil ohm/foot - circular mil Ω/ft",

                //electrostatic
                "Farad - F",
                "Exafarad - EF",
                "Petafarad - PF",
                "Terafarad - TF",
                "Gigafarad - GF",
                "Megafarad - MF",
                "Kilofarad - kF",
                "Hectofarad - hF",
                "Dekafarad - dF",
                "Decifarad - dF",
                "Centifarad - cF",
                "Millifarad - mF",
                "Microfarad - µF",
                "Nanofarad - nF",
                "Femtofarad - fF",
                "Attofarad - aF",
                "Coulomb/volt - C/v",
                "Abfarad - abF",
                "EMU of capacitance - EMU",
                "Statfarad - stF",
                "ESU of capacitance - ESU",

                //inductance
                "Henry - H",
                "Exahenry - EH",
                "Terahenry - TH",
                "Petahenry - PH",
                "Gigahenry - GH",
                "Megahenry - MH",
                "Kilohenry - kH",
                "Hectohenry - hH",
                "Dekahenry - daH",
                "Decihenry - dH",
                "Centihenry - cH",
                "Milihenry - mH",
                "Microhenry - µH",
                "Nanohenry - nH",
                "Picohenry - pH",
                "Femtohenry - fH",
                "Attohenery - aH",
                "Weber/ampere - Wb/A",
                "Abhenery - abH",
                "EMU of inductance - EMU",
                "Stathenry - stH",
                "ESU of inductance - ESU",

                //linear charge
                "Coulomb/meter - C/m",
                "Coulomb/centimeter - C/cm",
                "Coulomb/inch - C/in",
                "Abcoulomb/meter - abC/m",
                "Abcoulomb/centimeter - abC/cm",
                "Abcoulomb/inch - abC/in",

                //linear current
                "Ampere/meter(linear) - A/m",
                "Ampere/centimeter - A/cm",
                "Ampere/inch - A/in",
                "Abampere/meter - abA/m",
                "Abampere/centimeter - abA/cm",
                "Abampere/inch - abA/in",
                "Oersted(linear) - Oe",
                "Gilbert/centimeter - Gi/cm",

                //surface charge
                "Coulomb/square meter - C/m²",
                "Coulomb/square centimeter - C/cm²",
                "Coulomb/square inch - C/in²",
                "Abcoulomb/square meter - abC/m²",
                "Abcoulomb/square centimeter - abC/cm²",
                "Abcoulomb/square inch - abC/in²",

                //surface current
                "Ampere/square meter - A/m²",
                "Ampere/square centimeter - A/cm²",
                "Ampere/square inch - A/in²",
                "Ampere/square mil - A/mil²",
                "Ampere/cicular mil - A/mil",
                "Abampere/square centimeter - abA/cm²",

                //volume charge
                "Coulomb/cubic meter - C/m³",
                "Coulomb/cubic centimeter - C/cm³",
                "Coulomb/cubic inch - C/in³",
                "Abcoulomb/cubic meter - abC/m³",
                "Abcoulomb/cubic centimeter - abC/cm³",
                "Abcoulomb/cubic inch - abC/in³"


        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, listitem);
        lv.setAdapter(adapter);

        /*Collections.sort(lv, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });*/

        inputSearch.addTextChangedListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                //Do some more stuff here and launch new activity
                selectedItem = (String) adapterView.getItemAtPosition(position);
                //  Toast.makeText(SearchActivity.this,"Position"+selectedItem,Toast.LENGTH_LONG).show();
                switch (selectedItem) {

                    //electricity charge
                    case "Coulomb - C" : charge(); break;
                    case "Megacoulomb - MC" : charge(); break;
                    case "Kilocoulomb - kC" : charge(); break;
                    case "Millicoulomb - mC" : charge(); break;
                    case "Microcoulomb - µC" : charge(); break;
                    case "Nanocoulomb - nC" : charge(); break;
                    case "Picocoulomb - pC" : charge(); break;
                    case "EMU of charge - e" : charge(); break;
                    case "Statcoulomb - stC" : charge(); break;
                    case "ESU of charge - e" : charge(); break;
                    case "Franklin - Fr" : charge(); break;
                    case "Ampere-hour - A*h" : charge(); break;
                    case "Ampere-minute - A*min" : charge(); break;
                    case "Ampere-second - A*s" : charge(); break;
                    case "Faraday - F" : charge(); break;
                    case "Elementary charge - e" : charge(); break;

                    //conducatnce
                    case "Siemens - S" : conducatnce(); break;
                    case "Megasiemens - MS" : conducatnce(); break;
                    case "Kilosiemens - kS" : conducatnce(); break;
                    case "Milisiemens - mS" : conducatnce(); break;
                    case "Microsiemens - µS" : conducatnce(); break;
                    case "Ampere/volt - A/V" : conducatnce(); break;
                    case "Mho - mho" : conducatnce(); break;
                    case "Gemmho - gemmho" : conducatnce(); break;
                    case "Micromho - µmho" : conducatnce(); break;
                    case "Abmho - abmho" : conducatnce(); break;
                    case "Statmho - stmho" : conducatnce(); break;
                    case "Quantized Hall Conductance - mho" : conducatnce(); break;

                    //conductivity
                    case "Siemens/meter - S/m" : conductivity(); break;
                    case "Picosiemens/meter - pS/m" : conductivity(); break;
                    case "Mho/meter - mho/m" : conductivity(); break;
                    case "Mho/centimeter - mho/cm" : conductivity(); break;
                    case "Abmho/meter - abmho/m" : conductivity(); break;
                    case "Abmho/centimeter - abmho/cm" : conductivity(); break;
                    case "Statmho/meter - stmho/m" : conductivity(); break;
                    case "Statmho/centimeter - st/cm" : conductivity(); break;

                    case "Ampere - A" : electriccurrent(); break;
                    case "Kiloampere - kA" : electriccurrent(); break;
                    case "Milliampere - mA" : electriccurrent(); break;
                    case "Biot - Bi" : electriccurrent(); break;
                    case "Abampere - abA" : electriccurrent(); break;
                    case "EMU of current - emuA" : electriccurrent(); break;
                    case "Statampere - stA" : electriccurrent(); break;
                    case "ESU of current - esuA" : electriccurrent(); break;
                    case "CGS e.m.unit - e.m.unit" : electriccurrent(); break;
                    case "CGS e.s.unit - e.s.unit" : electriccurrent(); break;

                    //eelctric field
                    case "Volt/meter - V/m" : electricfield(); break;
                    case "Kilovolt/meter - kV/m" : electricfield(); break;
                    case "Kilovolt/centimeter - kV/cm" : electricfield(); break;
                    case "Volt/centimeter - V/cm" : electricfield(); break;
                    case "Millivolt/meter - mV/m" : electricfield(); break;
                    case "Microvolt/meter - µ/m" : electricfield(); break;

                    //electric potential
                    case "Volt - V" : electricpotential(); break;
                    case "Watt/ampere - W/A" : electricpotential(); break;
                    case "Abvolt - AbV" : electricpotential(); break;
                    case "EMU of electric potential - EMU" : electricpotential(); break;
                    case "Statvolt - stV" : electricpotential(); break;
                    case "ESU of electric potential - ESU" : electricpotential(); break;

                    //electric resistance
                    case "Ohm - Ω" : electricResistance(); break;
                    case "Megohm - megohm" : electricResistance(); break;
                    case "Microhm - microhm" : electricResistance(); break;
                    case "Volt/ampere - V/A" : electricResistance(); break;
                    case "Reciprocal siemens - 1/S" : electricResistance(); break;
                    case "Abohm - abΩ" : electricResistance(); break;
                    case "EMU of resistance - EMU" : electricResistance(); break;
                    case "Statohm - stΩ" : electricResistance(); break;
                    case "ESU of resistance - ESU" : electricResistance(); break;
                    case "Quantized Hall resistance - Ω" : electricResistance(); break;

                    //electric resistivity
                    case "Ohm meter - Ωm" : electricResistivity(); break;
                    case "Ohm centimeter - Ωcm" : electricResistivity(); break;
                    case "Ohm inch - Ωin" : electricResistivity(); break;
                    case "Microhm centimeter - µΩcm" : electricResistivity(); break;
                    case "Microhm inch -  µΩin" : electricResistivity(); break;
                    case "Abohm centimeter - abΩcm" : electricResistivity(); break;
                    case "Statohm centimeter - stΩcm" : electricResistivity(); break;
                    case "Circular mil ohm/foot - circular mil Ω/ft" : electricResistivity(); break;


                    //electrostatic
                    case "Farad - F" : electrostatic(); break;
                    case "Exafarad - EF" : electrostatic(); break;
                    case "Petafarad - PF" : electrostatic(); break;
                    case "Terafarad - TF" : electrostatic(); break;
                    case "Gigafarad - GF" : electrostatic(); break;
                    case "Megafarad - MF" : electrostatic(); break;
                    case "Kilofarad - kF" : electrostatic(); break;
                    case "Hectofarad - hF" : electrostatic(); break;
                    case "Dekafarad - dF" : electrostatic(); break;
                    case "Decifarad - dF" : electrostatic(); break;
                    case "Centifarad - cF" : electrostatic(); break;
                    case "Millifarad - mF" : electrostatic(); break;
                    case "Microfarad - µF" : electrostatic(); break;
                    case "Nanofarad - nF" : electrostatic(); break;
                    case "Femtofarad - fF" : electrostatic(); break;
                    case "Attofarad - aF" : electrostatic(); break;
                    case "Coulomb/volt - C/v" : electrostatic(); break;
                    case "Abfarad - abF" : electrostatic(); break;
                    case "EMU of capacitance - EMU" : electrostatic(); break;
                    case "Statfarad - stF" : electrostatic(); break;
                    case "ESU of capacitance - ESU" : electrostatic(); break;

                    //inductance
                    case "Henry - H" : inductance(); break;
                    case "Exahenry - EH" : inductance(); break;
                    case "Terahenry - TH" : inductance(); break;
                    case "Petahenry - PH" : inductance(); break;
                    case "Gigahenry - GH" : inductance(); break;
                    case "Megahenry - MH" : inductance(); break;
                    case "Kilohenry - kH" : inductance(); break;
                    case "Hectohenry - hH" : inductance(); break;
                    case "Dekahenry - daH" : inductance(); break;
                    case "Decihenry - dH" : inductance(); break;
                    case "Centihenry - cH" : inductance(); break;
                    case "Milihenry - mH" : inductance(); break;
                    case "Microhenry - µH" : inductance(); break;
                    case "Nanohenry - nH" : inductance(); break;
                    case "Picohenry - pH" : inductance(); break;
                    case "Femtohenry - fH" : inductance(); break;
                    case "Attohenery - aH" : inductance(); break;
                    case "Weber/ampere - Wb/A" : inductance(); break;
                    case "Abhenery - abH" : inductance(); break;
                    case "EMU of inductance - EMU" : inductance(); break;
                    case "Stathenry - stH" : inductance(); break;
                    case "ESU of inductance - ESU" : inductance(); break;

                    //linear charge
                    case "Coulomb/meter - C/m" : linearcharge(); break;
                    case "Coulomb/centimeter - C/cm" : linearcharge(); break;
                    case "Coulomb/inch - C/in" : linearcharge(); break;
                    case "Abcoulomb/meter - abC/m" : linearcharge(); break;
                    case "Abcoulomb/centimeter - abC/cm" : linearcharge(); break;
                    case "Abcoulomb/inch - abC/in" : linearcharge(); break;

                    //linear current
                    case "Ampere/meter(linear) - A/m" : linearurrent(); break;
                    case "Ampere/centimeter - A/cm" : linearurrent(); break;
                    case "Ampere/inch - A/in" : linearurrent(); break;
                    case "Abampere/meter - abA/m" : linearurrent(); break;
                    case "Abampere/centimeter - abA/cm" : linearurrent(); break;
                    case "Abampere/inch - abA/in" : linearurrent(); break;
                    case "Oersted(linear) - Oe" : linearurrent(); break;
                    case "Gilbert/centimeter - Gi/cm" : linearurrent(); break;

                    //surface charge
                    case "Coulomb/square meter - C/m²" : surfacecharge(); break;
                    case "Coulomb/square centimeter - C/cm²" : surfacecharge(); break;
                    case "Coulomb/square inch - C/in²" : surfacecharge(); break;
                    case "Abcoulomb/square meter - abC/m²" : surfacecharge(); break;
                    case "Abcoulomb/square centimeter - abC/cm²" : surfacecharge(); break;
                    case "Abcoulomb/square inch - abC/in²" : surfacecharge(); break;

                    //surface current
                    case "Ampere/square meter - A/m²" : surfacecurrent(); break;
                    case "Ampere/square centimeter - A/cm²" : surfacecurrent(); break;
                    case "Ampere/square inch - A/in²" : surfacecurrent(); break;
                    case "Ampere/square mil - A/mil²" : surfacecurrent(); break;
                    case "Ampere/cicular mil - A/mil" : surfacecurrent(); break;
                    case "Abampere/square centimeter - abA/cm²" : surfacecurrent(); break;

                    //volumecharge
                    case "Coulomb/cubic meter - C/m³" : voulmecharge(); break;
                    case "Coulomb/cubic centimeter - C/cm³" : voulmecharge(); break;
                    case "Coulomb/cubic inch - C/in³" : voulmecharge(); break;
                    case "Abcoulomb/cubic meter - abC/m³" : voulmecharge(); break;
                    case "Abcoulomb/cubic centimeter - abC/cm³" : voulmecharge(); break;
                    case "Abcoulomb/cubic inch - abC/in³" : voulmecharge(); break;

                }
            }
        });
        }

    private void voulmecharge() {
        Intent i7=new Intent(SearchActivity.this,VolumeChargeDensityActivity.class);
        startActivity(i7);
    }
    private void surfacecurrent() {
        Intent i7=new Intent(SearchActivity.this,SurfaceCurrentDensityActivity.class);
        startActivity(i7);
    }
    private void surfacecharge() {
        Intent i7=new Intent(SearchActivity.this,SurfaceChargeDensityConverterActivity.class);
        startActivity(i7);
    }
    private void linearurrent() {
        Intent i7=new Intent(SearchActivity.this,LinearCurrentDensityActivity.class);
        startActivity(i7);
    }
    private void linearcharge() {
        Intent i7=new Intent(SearchActivity.this,LinearChargeDensityConverterActivity.class);
        startActivity(i7);
    }
    private void inductance() {
        Intent i7=new Intent(SearchActivity.this,InductanceConverterActivity.class);
        startActivity(i7);
    }
    private void electrostatic() {
        Intent i7=new Intent(SearchActivity.this,ElectrostaticCapacitanceActivity.class);
        startActivity(i7);
    }
    private void electricResistivity() {
        Intent i7=new Intent(SearchActivity.this,ElectricResistivityConverterActivity.class);
        startActivity(i7);
    }
    private void electricResistance() {
        Intent i7=new Intent(SearchActivity.this,ElectricResistanceConverterActivity.class);
        startActivity(i7);
    }
    private void electricpotential() {
        Intent i7=new Intent(SearchActivity.this,ElectricPotentialActivity.class);
        startActivity(i7);
    }
    private void electricfield() {
        Intent i7=new Intent(SearchActivity.this,ElectricFieldStrengthActivity.class);
        startActivity(i7);
    }

    private void electriccurrent() {
        Intent i7=new Intent(SearchActivity.this,CurrentConverterActivity.class);
        startActivity(i7);
    }


    private void conductivity() {
        Intent i7=new Intent(SearchActivity.this,ConductivityConverterActivity.class);
        startActivity(i7);
    }

    private void conducatnce() {
        Intent i7=new Intent(SearchActivity.this,ConductanceConverterActivity.class);
        startActivity(i7);
    }

    private void charge() {
        Intent i7=new Intent(SearchActivity.this,ChargeConverterActivity.class);
        startActivity(i7);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        SearchActivity.this.adapter.getFilter().filter(s);
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



