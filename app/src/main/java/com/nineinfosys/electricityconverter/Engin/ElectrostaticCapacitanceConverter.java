package com.nineinfosys.electricityconverter.Engin;

import java.util.ArrayList;


public class ElectrostaticCapacitanceConverter {

    private double farad,exafarad,petafarad,terafarad,gigafarad,megafarad,kilofarad,hectofarad,dekafarad,decifarad,centifarad,millifarad,microfarad,nanofarad,
            picofarad,femtofarad,attofarad,coulomb,abfarad,EMU,statfarad,ESU;

    private double edtValue;
    private String conversionFrom;




    public ElectrostaticCapacitanceConverter(String conversionFrom, int edtValue) {

        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }



    public ArrayList<ConversionResults> calculatecapacitanceConversion()

    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)

        {
            case "Farad - F":

                farad=(edtValue)*1;
                exafarad=(edtValue)*1.E-18;
                petafarad=(edtValue)*1.E-15;
                terafarad=(edtValue)*1.E-12;
                gigafarad=(edtValue)*1.E-9;
                megafarad=(edtValue)*0.000001;
                kilofarad=(edtValue)*0.001;
                hectofarad=(edtValue)*0.01;
                dekafarad=(edtValue)*0.1;
                decifarad=(edtValue)*10;
                centifarad=(edtValue)*100;
                millifarad=(edtValue)*1000;
                microfarad=(edtValue)*1000000;
                nanofarad=(edtValue)*1000000000;
                picofarad=(edtValue)*1000000000000.00;
                femtofarad=(edtValue)*1000000000000000.00;
                attofarad=(edtValue)*1000000000000000000.00;
                coulomb=(edtValue)*1;
                abfarad=(edtValue)*1.E-9;
                EMU=(edtValue)*1.E-9;
                statfarad=(edtValue)*898755178737.00;
                ESU=(edtValue)*898755178737.00;



                break;
            case "Exafarad - EF":

                farad=(edtValue)*1000000000000000000.00;
                exafarad=(edtValue)*1;
                petafarad=(edtValue)*1000;
                terafarad=(edtValue)*1000000;
                gigafarad=(edtValue)*1000000000;
                megafarad=(edtValue)*1000000000000.00;
                kilofarad=(edtValue)*1000000000000000.00;
                hectofarad=(edtValue)*10000000000000000.00;
                dekafarad=(edtValue)*100000000000000000.00;
                decifarad=(edtValue)*10000000000000000000.00;
                centifarad=(edtValue)*100000000000000000000.00;
                millifarad=(edtValue)*1.E+21;
                microfarad=(edtValue)*1.E+24;
                nanofarad=(edtValue)*1.E+27;
                picofarad=(edtValue)*1.E+30;
                femtofarad=(edtValue)*1.E+33;
                attofarad=(edtValue)*1.E+36;
                coulomb=(edtValue)*1000000000000000000.00;
                abfarad=(edtValue)*1000000000;
                EMU=(edtValue)*1000000000;
                statfarad=(edtValue)*8.987551787E+29;
                ESU=(edtValue)*8.987551787E+29;


                break;
            case "Petafarad - PF":

                farad=(edtValue)*1000000000000000.00;
                exafarad=(edtValue)*0.001;
                petafarad=(edtValue)*1;
                terafarad=(edtValue)*1000;
                gigafarad=(edtValue)*1000000;
                megafarad=(edtValue)*1000000000;
                kilofarad=(edtValue)*1000000000000.00;
                hectofarad=(edtValue)*10000000000000.00;
                dekafarad=(edtValue)*100000000000000.00;
                decifarad=(edtValue)*10000000000000000.00;
                centifarad=(edtValue)*100000000000000000.00;
                millifarad=(edtValue)*1000000000000000000.00;
                microfarad=(edtValue)*1.E+21;
                nanofarad=(edtValue)*1.E+24;
                picofarad=(edtValue)*1.E+27;
                femtofarad=(edtValue)*9.999999999E+29;
                attofarad=(edtValue)*1.E+33;
                coulomb=(edtValue)*1000000000000000.00;
                abfarad=(edtValue)*1000000;
                EMU=(edtValue)*1000000;
                statfarad=(edtValue)*8.987551787E+26;
                ESU=(edtValue)*8.987551787E+26;

                break;
            case "Terafarad - TF":

                farad=(edtValue)*1000000000000.00;
                exafarad=(edtValue)*0.000001;
                petafarad=(edtValue)*0.001;
                terafarad=(edtValue)*1;
                gigafarad=(edtValue)*1000;
                megafarad=(edtValue)*1000000;
                kilofarad=(edtValue)*1000000000;
                hectofarad=(edtValue)*10000000000.00;
                dekafarad=(edtValue)*100000000000.00;
                decifarad=(edtValue)*10000000000000.00;
                centifarad=(edtValue)*100000000000000.00;
                millifarad=(edtValue)*1000000000000000.00;
                microfarad=(edtValue)*1000000000000000000.00;
                nanofarad=(edtValue)*1.E+21;
                picofarad=(edtValue)*1.E+24;
                femtofarad=(edtValue)*1.E+27;
                attofarad=(edtValue)*1.E+30;
                coulomb=(edtValue)*1000000000000.00;
                abfarad=(edtValue)*1000;
                EMU=(edtValue)*1000;
                statfarad=(edtValue)*8.987551787E+23;
                ESU=(edtValue)*8.987551787E+23;



                break;
            case "Gigafarad - GF":

                farad=(edtValue)*1000000000;
                exafarad=(edtValue)*1.E-9;
                petafarad=(edtValue)*0.000001;
                terafarad=(edtValue)*0.001;
                gigafarad=(edtValue)*1;
                megafarad=(edtValue)*1000;
                kilofarad=(edtValue)*1000000;
                hectofarad=(edtValue)*10000000;
                dekafarad=(edtValue)*100000000;
                decifarad=(edtValue)*10000000000.00;
                centifarad=(edtValue)*100000000000.00;
                millifarad=(edtValue)*1000000000000.00;
                microfarad=(edtValue)*1000000000000000.00;
                nanofarad=(edtValue)*1000000000000000000.00;
                picofarad=(edtValue)*1.E+21;
                femtofarad=(edtValue)*1.E+24;
                attofarad=(edtValue)*1.E+27;
                coulomb=(edtValue)*1000000000;
                abfarad=(edtValue)*1;
                EMU=(edtValue)*1;
                statfarad=(edtValue)*898755178736500000000.00;
                ESU=(edtValue)*898755178736500000000.00;

                break;
            case "Megafarad - MF":

                farad=(edtValue)*1000000;
                exafarad=(edtValue)*1.E-12;
                petafarad=(edtValue)*1.E-9;
                terafarad=(edtValue)*0.000001;
                gigafarad=(edtValue)*0.001;
                megafarad=(edtValue)*1;
                kilofarad=(edtValue)*1000;
                hectofarad=(edtValue)*10000;
                dekafarad=(edtValue)*100000;
                decifarad=(edtValue)*10000000;
                centifarad=(edtValue)*100000000;
                millifarad=(edtValue)*1000000000;
                microfarad=(edtValue)*1000000000000.00;
                nanofarad=(edtValue)*1000000000000000.00;
                picofarad=(edtValue)*1000000000000000000.00;
                femtofarad=(edtValue)*1.E+21;
                attofarad=(edtValue)*1.E+24;
                coulomb=(edtValue)*1000000;
                abfarad=(edtValue)*0.001;
                EMU=(edtValue)*0.001;
                statfarad=(edtValue)*898755178736500000.00;
                ESU=(edtValue)*898755178736500000.00;


                break;
            case "Kilofarad - kF":

                farad=(edtValue)*1000;
                exafarad=(edtValue)*1.E-15;
                petafarad=(edtValue)*1.E-12;
                terafarad=(edtValue)*1.E-9;
                gigafarad=(edtValue)*0.000001;
                megafarad=(edtValue)*0.001;
                kilofarad=(edtValue)*1;
                hectofarad=(edtValue)*10;
                dekafarad=(edtValue)*100;
                decifarad=(edtValue)*10000;
                centifarad=(edtValue)*100000;
                millifarad=(edtValue)*1000000;
                microfarad=(edtValue)*1000000000;
                nanofarad=(edtValue)*1000000000000.00;
                picofarad=(edtValue)*1000000000000000.00;
                femtofarad=(edtValue)*1000000000000000000.00;
                attofarad=(edtValue)*1.E+21;
                coulomb=(edtValue)*1000;
                abfarad=(edtValue)*0.000001;
                EMU=(edtValue)*0.000001;
                statfarad=(edtValue)*898755178736500.00;
                ESU=(edtValue)*898755178736500.00;


                break;
            case "Hectofarad - hF":

                farad=(edtValue)*100;
                exafarad=(edtValue)*1.E-16;
                petafarad=(edtValue)*1.E-13;
                terafarad=(edtValue)*1.E-10;
                gigafarad=(edtValue)*1.E-7;
                megafarad=(edtValue)*0.0001;
                kilofarad=(edtValue)*0.1;
                hectofarad=(edtValue)*1;
                dekafarad=(edtValue)*10;
                decifarad=(edtValue)*1000;
                centifarad=(edtValue)*10000;
                millifarad=(edtValue)*100000;
                microfarad=(edtValue)*100000000;
                nanofarad=(edtValue)*100000000000.00;
                picofarad=(edtValue)*100000000000000.00;
                femtofarad=(edtValue)*100000000000000000.00;
                attofarad=(edtValue)*100000000000000000000.00;
                coulomb=(edtValue)*100;
                abfarad=(edtValue)*1.E-7;
                EMU=(edtValue)*1.E-7;
                statfarad=(edtValue)*89875517873650.00;
                ESU=(edtValue)*89875517873650.00;

                break;

            case "Dekafarad - dF":

                farad=(edtValue)*10;
                exafarad=(edtValue)*1.E-17;
                petafarad=(edtValue)*1.E-14;
                terafarad=(edtValue)*1.E-11;
                gigafarad=(edtValue)*1.E-8;
                megafarad=(edtValue)*0.00001;
                kilofarad=(edtValue)*0.01;
                hectofarad=(edtValue)*0.1;
                dekafarad=(edtValue)*1;
                decifarad=(edtValue)*100;
                centifarad=(edtValue)*1000;
                millifarad=(edtValue)*10000;
                microfarad=(edtValue)*10000000;
                nanofarad=(edtValue)*10000000000.00;
                picofarad=(edtValue)*10000000000000.00;
                femtofarad=(edtValue)*10000000000000000.00;
                attofarad=(edtValue)*10000000000000000000.00;
                coulomb=(edtValue)*10;
                abfarad=(edtValue)*1.E-8;
                EMU=(edtValue)*1.E-8;
                statfarad=(edtValue)*8987551787365.00;
                ESU=(edtValue)*8987551787365.00;



                break;
            case "Decifarad - dF":

                farad=(edtValue)*0.1;
                exafarad=(edtValue)*1.E-19;
                petafarad=(edtValue)*1.E-16;
                terafarad=(edtValue)*1.E-13;
                gigafarad=(edtValue)*1.E-10;
                megafarad=(edtValue)*1.E-7;
                kilofarad=(edtValue)*0.0001;
                hectofarad=(edtValue)*0.001;
                dekafarad=(edtValue)*0.01;
                decifarad=(edtValue)*1;
                centifarad=(edtValue)*10;
                millifarad=(edtValue)*100;
                microfarad=(edtValue)*100000;
                nanofarad=(edtValue)*100000000;
                picofarad=(edtValue)*100000000000.00;
                femtofarad=(edtValue)*100000000000000.00;
                attofarad=(edtValue)*100000000000000000.00;
                coulomb=(edtValue)*0.1;
                abfarad=(edtValue)*1.E-10;
                EMU=(edtValue)*1.E-10;
                statfarad=(edtValue)*89875517874.00;
                ESU=(edtValue)*89875517874.00;

                break;
            case "Centifarad - cF":

                farad=(edtValue)*0.01;
                exafarad=(edtValue)*1.E-20;
                petafarad=(edtValue)*1.E-17;
                terafarad=(edtValue)*1.E-14;
                gigafarad=(edtValue)*1.E-11;
                megafarad=(edtValue)*1.E-8;
                kilofarad=(edtValue)*0.00001;
                hectofarad=(edtValue)*0.0001;
                dekafarad=(edtValue)*0.001;
                decifarad=(edtValue)*0.1;
                centifarad=(edtValue)*1;
                millifarad=(edtValue)*10;
                microfarad=(edtValue)*10000;
                nanofarad=(edtValue)*10000000;
                picofarad=(edtValue)*10000000000.00;
                femtofarad=(edtValue)*10000000000000.00;
                attofarad=(edtValue)*10000000000000000.00;
                coulomb=(edtValue)*0.01;
                abfarad=(edtValue)*1.E-11;
                EMU=(edtValue)*1.E-11;
                statfarad=(edtValue)*8987551787.4;
                ESU=(edtValue)*8987551787.4;


                break;

            case "Millifarad - mF":

                farad=(edtValue)*0.001;
                exafarad=(edtValue)*1.E-21;
                petafarad=(edtValue)*1.E-18;
                terafarad=(edtValue)*1.E-15;
                gigafarad=(edtValue)*1.E-12;
                megafarad=(edtValue)*1.E-9;
                kilofarad=(edtValue)* 0.000001;
                hectofarad=(edtValue)* 0.00001;
                dekafarad=(edtValue)* 0.0001;
                decifarad=(edtValue)*0.01 ;
                centifarad=(edtValue)*0.1 ;
                millifarad=(edtValue)* 1;
                microfarad=(edtValue)*1000 ;
                nanofarad=(edtValue)*1000000 ;
                picofarad=(edtValue)*1000000000 ;
                femtofarad=(edtValue)*1000000000000.0 ;
                attofarad=(edtValue)*1000000000000000.0 ;
                coulomb=(edtValue)* 0.001 ;
                abfarad=(edtValue)* 1.E-12;
                EMU=(edtValue)* 1.E-12;
                statfarad=(edtValue)* 898755178.74;
                ESU=(edtValue)*898755178.74 ;

                break;


            case "Microfarad - µF":

                farad=(edtValue)*0.000001;
                exafarad=(edtValue)*1.E-24;
                petafarad=(edtValue)*1.E-21;
                terafarad=(edtValue)*1.E-18;
                gigafarad=(edtValue)*1.E-15;
                megafarad=(edtValue)*1.E-12;
                kilofarad=(edtValue)*1.E-9;
                hectofarad=(edtValue)*1.E-8;
                dekafarad=(edtValue)*1.E-7;
                decifarad=(edtValue)*0.00001;
                centifarad=(edtValue)*0.0001;
                millifarad=(edtValue)*0.001;
                microfarad=(edtValue)*1;
                nanofarad=(edtValue)*1000;
                picofarad=(edtValue)*1000000;
                femtofarad=(edtValue)*1000000000;
                attofarad=(edtValue)*1000000000000.00;
                coulomb=(edtValue)*0.000001;
                abfarad=(edtValue)*1.E-15;
                EMU=(edtValue)*1.E-15;
                statfarad=(edtValue)*898755.17874;
                ESU=(edtValue)*898755.17874;

                break;
            case "Nanofarad - nF":

                farad=(edtValue)*1.E-9;
                exafarad=(edtValue)*1.E-27;
                petafarad=(edtValue)*1.E-24;
                terafarad=(edtValue)*1.E-21;
                gigafarad=(edtValue)*1.E-18;
                megafarad=(edtValue)*1.E-15;
                kilofarad=(edtValue)*1.E-12;
                hectofarad=(edtValue)*1.E-11;
                dekafarad=(edtValue)*1.E-10;
                decifarad=(edtValue)*1.E-8;
                centifarad=(edtValue)*1.E-7;
                millifarad=(edtValue)*0.000001;
                microfarad=(edtValue)*0.001;
                nanofarad=(edtValue)*1;
                picofarad=(edtValue)*1000;
                femtofarad=(edtValue)*1000000;
                attofarad=(edtValue)*1000000000;
                coulomb=(edtValue)*1.E-9;
                abfarad=(edtValue)*1.E-18;
                EMU=(edtValue)*1.E-18;
                statfarad=(edtValue)*898.75517874;
                ESU=(edtValue)*898.75517874;

                break;

            case "Picofarad - pF":

                farad=(edtValue)*1.E-12;
                exafarad=(edtValue)*9.999999999E-31;
                petafarad=(edtValue)*1.E-27;
                terafarad=(edtValue)*1.E-24;
                gigafarad=(edtValue)*1.E-21;
                megafarad=(edtValue)*1.E-18;
                kilofarad=(edtValue)*1.E-15;
                hectofarad=(edtValue)*1.E-14;
                dekafarad=(edtValue)*1.E-13;
                decifarad=(edtValue)*1.E-11;
                centifarad=(edtValue)*1.E-10;
                millifarad=(edtValue)*1.E-9;
                microfarad=(edtValue)*0.000001;
                nanofarad=(edtValue)*0.001;
                picofarad=(edtValue)*1;
                femtofarad=(edtValue)*1000;
                attofarad=(edtValue)*1000000;
                coulomb=(edtValue)*1.E-12;
                abfarad=(edtValue)*1.E-21;
                EMU=(edtValue)*1.E-21;
                statfarad=(edtValue)*0.8987551787;
                ESU=(edtValue)*0.8987551787;

                break;

            case "Femtofarad - fF":

                farad=(edtValue)*1.E-15;
                exafarad=(edtValue)*1.E-33;
                petafarad=(edtValue)*1.E-30;
                terafarad=(edtValue)*1.E-27;
                gigafarad=(edtValue)*1.E-24;
                megafarad=(edtValue)*1.E-21;
                kilofarad=(edtValue)*1.E-18;
                hectofarad=(edtValue)*1.E-17;
                dekafarad=(edtValue)*1.E-16;
                decifarad=(edtValue)*1.E-14;
                centifarad=(edtValue)*1.E-13;
                millifarad=(edtValue)*1.E-12;
                microfarad=(edtValue)*1.E-9;
                nanofarad=(edtValue)*0.000001;
                picofarad=(edtValue)*0.001;
                femtofarad=(edtValue)*1;
                attofarad=(edtValue)*1000;
                coulomb=(edtValue)*1.E-15;
                abfarad=(edtValue)*1.E-24;
                EMU=(edtValue)*1.E-15;
                statfarad=(edtValue)*0.0008987552;
                ESU=(edtValue)*0.0008987552;

                break;

            case "Attofarad - aF":

                farad=(edtValue)*9.999999999E-19;
                exafarad=(edtValue)*1.E-36;
                petafarad=(edtValue)*9.999999999E-34;
                terafarad=(edtValue)*9.999999999E-31;
                gigafarad=(edtValue)*1.E-27;
                megafarad=(edtValue)*1.E-24;
                kilofarad=(edtValue)*1.E-21;
                hectofarad=(edtValue)*1.E-20;
                dekafarad=(edtValue)*1.E-19;
                decifarad=(edtValue)*9.999999999E-18;
                centifarad=(edtValue)*1.E-16;
                millifarad=(edtValue)*9.999999999E-16;
                microfarad=(edtValue)*1.E-12;
                nanofarad=(edtValue)*1.E-9;
                picofarad=(edtValue)*0.000001;
                femtofarad=(edtValue)*0.001;
                attofarad=(edtValue)*1;
                coulomb=(edtValue)*9.999999999E-19;
                abfarad=(edtValue)*1.E-27;
                EMU=(edtValue)*1.E-27;
                statfarad=(edtValue)*8.987551787E-7;
                ESU=(edtValue)*8.987551787E-7;

                break;

            case "Coulomb/volt - C/v":

                farad=(edtValue)*1;
                exafarad=(edtValue)*1.E-18;
                petafarad=(edtValue)*1.E-15;
                terafarad=(edtValue)*1.E-12;
                gigafarad=(edtValue)*1.E-9;
                megafarad=(edtValue)*0.000001;
                kilofarad=(edtValue)*0.001;
                hectofarad=(edtValue)*0.01;
                dekafarad=(edtValue)*0.1;
                decifarad=(edtValue)*10;
                centifarad=(edtValue)*100;
                millifarad=(edtValue)*1000;
                microfarad=(edtValue)*1000000;
                nanofarad=(edtValue)*1000000000;
                picofarad=(edtValue)*1000000000000.00;
                femtofarad=(edtValue)*1000000000000000.00;
                attofarad=(edtValue)*1000000000000000000.00;
                coulomb=(edtValue)*1;
                abfarad=(edtValue)*1.E-9;
                EMU=(edtValue)*1.E-9;
                statfarad=(edtValue)*898755178737.00;
                ESU=(edtValue)*898755178737.00;

                break;

            case "Abfarad - abF":

                farad=(edtValue)*1000000000;
                exafarad=(edtValue)*1.E-9;
                petafarad=(edtValue)*0.000001;
                terafarad=(edtValue)*0.001;
                gigafarad=(edtValue)*1;
                megafarad=(edtValue)*1000;
                kilofarad=(edtValue)*1000000;
                hectofarad=(edtValue)*10000000;
                dekafarad=(edtValue)*100000000;
                decifarad=(edtValue)*10000000000.00;
                centifarad=(edtValue)*100000000000.00;
                millifarad=(edtValue)*1000000000000.00;
                microfarad=(edtValue)*1000000000000000.00;
                nanofarad=(edtValue)*1000000000000000000.00;
                picofarad=(edtValue)*1.E+21;
                femtofarad=(edtValue)*1.E+24;
                attofarad=(edtValue)*1.E+27;
                coulomb=(edtValue)*1000000000;
                abfarad=(edtValue)*1;
                EMU=(edtValue)*1;
                statfarad=(edtValue)*898755178736500000000.00;
                ESU=(edtValue)*898755178736500000000.00;

                break;

            case "EMU of capacitance - EMU":

                farad=(edtValue)*1000000000;
                exafarad=(edtValue)*1.E-9;
                petafarad=(edtValue)*0.000001;
                terafarad=(edtValue)*0.001;
                gigafarad=(edtValue)*1;
                megafarad=(edtValue)*1000;
                kilofarad=(edtValue)*1000000;
                hectofarad=(edtValue)*10000000;
                dekafarad=(edtValue)*100000000;
                decifarad=(edtValue)*10000000000.00;
                centifarad=(edtValue)*100000000000.00;
                millifarad=(edtValue)*1000000000000.00;
                microfarad=(edtValue)*1000000000000000.00;
                nanofarad=(edtValue)*1000000000000000000.00;
                picofarad=(edtValue)*1.E+21;
                femtofarad=(edtValue)*1.E+24;
                attofarad=(edtValue)*1.E+27;
                coulomb=(edtValue)*1000000000;
                abfarad=(edtValue)*1;
                EMU=(edtValue)*1;
                statfarad=(edtValue)*898755178736500000000.00;
                ESU=(edtValue)*898755178736500000000.00;

                break;

            case "Statfarad - stF":

                farad=(edtValue)*1.112650056E-12;
                exafarad=(edtValue)*1.112650056E-30;
                petafarad=(edtValue)*1.112650056E-27;
                terafarad=(edtValue)*1.112650056E-24;
                gigafarad=(edtValue)*1.112650056E-21;
                megafarad=(edtValue)*1.112650056E-18;
                kilofarad=(edtValue)*1.112650056E-15;
                hectofarad=(edtValue)*1.112650056E-14;
                dekafarad=(edtValue)*1.112650056E-13;
                decifarad=(edtValue)*1.112650056E-11;
                centifarad=(edtValue)*1.112650056E-10;
                millifarad=(edtValue)*1.112650056E-9;
                microfarad=(edtValue)*0.0000011127;
                nanofarad=(edtValue)*0.0011126501;
                picofarad=(edtValue)*1.1126500561;
                femtofarad=(edtValue)*1112.6500561;
                attofarad=(edtValue)*1112650.0561;
                coulomb=(edtValue)*1.112650056E-12;
                abfarad=(edtValue)*1.112650056E-21;
                EMU=(edtValue)*1.112650056E-21;
                statfarad=(edtValue)*1;
                ESU=(edtValue)*1;

                break;

            case "ESU of capacitance - ESU":

                farad=(edtValue)*1.112650056E-12;
                exafarad=(edtValue)*1.112650056E-30;
                petafarad=(edtValue)*1.112650056E-27;
                terafarad=(edtValue)*1.112650056E-24;
                gigafarad=(edtValue)*1.112650056E-21;
                megafarad=(edtValue)*1.112650056E-18;
                kilofarad=(edtValue)*1.112650056E-15;
                hectofarad=(edtValue)*1.112650056E-14;
                dekafarad=(edtValue)*1.112650056E-13;
                decifarad=(edtValue)*1.112650056E-11;
                centifarad=(edtValue)*1.112650056E-10;
                millifarad=(edtValue)*1.112650056E-9;
                microfarad=(edtValue)*0.0000011127;
                nanofarad=(edtValue)*0.0011126501;
                picofarad=(edtValue)*1.1126500561;
                femtofarad=(edtValue)*1112.6500561;
                attofarad=(edtValue)*1112650.0561;
                coulomb=(edtValue)*1.112650056E-12;
                abfarad=(edtValue)*1.112650056E-21;
                EMU=(edtValue)*1.112650056E-21;
                statfarad=(edtValue)*1;
                ESU=(edtValue)*1;

                break;

        }
        results.setFarad(farad);
        results.setExafarad(exafarad);
        results.setPetafarad(petafarad);
        results.setTerafarad(terafarad);
        results.setGigafarad(gigafarad);
        results.setMegafarad(megafarad);
        results.setKilofarad(kilofarad);
        results.setHectofarad(hectofarad);
        results.setDekafarad(dekafarad);
        results.setDecifarad(decifarad);
        results.setCentifarad(centifarad);
        results.setMillifarad(millifarad);
        results.setMicrofarad(microfarad);
        results.setNanofarad(nanofarad);
        results.setPicofarad(picofarad);
        results.setFemtofarad(femtofarad);
        results.setAttofarad(attofarad);
        results.setCoulomb(coulomb);
        results.setAbfarad(abfarad);
        results.setEMU(EMU);
        results.setStatfarad(statfarad);
        results.setESU(ESU);




        converterArray.add(results);

        return converterArray;


    }
    public class ConversionResults{

        private double farad,exafarad,petafarad,terafarad,gigafarad,megafarad,kilofarad,hectofarad,dekafarad,decifarad,centifarad,millifarad,microfarad,nanofarad,
                picofarad,femtofarad,attofarad,coulomb,abfarad,EMU,statfarad,ESU;

        public double getFarad() {
            return farad;
        }

        public void setFarad(double farad) {
            this.farad = farad;
        }

        public double getExafarad() {
            return exafarad;
        }

        public void setExafarad(double exafarad) {
            this.exafarad = exafarad;
        }

        public double getPetafarad() {
            return petafarad;
        }

        public void setPetafarad(double petafarad) {
            this.petafarad = petafarad;
        }

        public double getTerafarad() {
            return terafarad;
        }

        public void setTerafarad(double terafarad) {
            this.terafarad = terafarad;
        }

        public double getGigafarad() {
            return gigafarad;
        }

        public void setGigafarad(double gigafarad) {
            this.gigafarad = gigafarad;
        }

        public double getMegafarad() {
            return megafarad;
        }

        public void setMegafarad(double megafarad) {
            this.megafarad = megafarad;
        }

        public double getKilofarad() {
            return kilofarad;
        }

        public void setKilofarad(double kilofarad) {
            this.kilofarad = kilofarad;
        }

        public double getHectofarad() {
            return hectofarad;
        }

        public void setHectofarad(double hectofarad) {
            this.hectofarad = hectofarad;
        }

        public double getDekafarad() {
            return dekafarad;
        }

        public void setDekafarad(double dekafarad) {
            this.dekafarad = dekafarad;
        }

        public double getDecifarad() {
            return decifarad;
        }

        public void setDecifarad(double decifarad) {
            this.decifarad = decifarad;
        }

        public double getCentifarad() {
            return centifarad;
        }

        public void setCentifarad(double centifarad) {
            this.centifarad = centifarad;
        }

        public double getMillifarad() {
            return millifarad;
        }

        public void setMillifarad(double millifarad) {
            this.millifarad = millifarad;
        }

        public double getMicrofarad() {
            return microfarad;
        }

        public void setMicrofarad(double microfarad) {
            this.microfarad = microfarad;
        }

        public double getNanofarad() {
            return nanofarad;
        }

        public void setNanofarad(double nanofarad) {
            this.nanofarad = nanofarad;
        }

        public double getPicofarad() {
            return picofarad;
        }

        public void setPicofarad(double picofarad) {
            this.picofarad = picofarad;
        }

        public double getFemtofarad() {
            return femtofarad;
        }

        public void setFemtofarad(double femtofarad) {
            this.femtofarad = femtofarad;
        }

        public double getAttofarad() {
            return attofarad;
        }

        public void setAttofarad(double attofarad) {
            this.attofarad = attofarad;
        }

        public double getCoulomb() {
            return coulomb;
        }

        public void setCoulomb(double coulomb) {
            this.coulomb = coulomb;
        }

        public double getAbfarad() {
            return abfarad;
        }

        public void setAbfarad(double abfarad) {
            this.abfarad = abfarad;
        }

        public double getEMU() {
            return EMU;
        }

        public void setEMU(double eMU) {
            EMU = eMU;
        }

        public double getStatfarad() {
            return statfarad;
        }

        public void setStatfarad(double statfarad) {
            this.statfarad = statfarad;
        }

        public double getESU() {
            return ESU;
        }

        public void setESU(double eSU) {
            ESU = eSU;
        }




    }
}
