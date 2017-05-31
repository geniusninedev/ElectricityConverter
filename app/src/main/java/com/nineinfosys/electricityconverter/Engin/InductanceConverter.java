package com.nineinfosys.electricityconverter.Engin;

import java.util.ArrayList;


public class InductanceConverter {

    private double henry,exahenry,petahenry,terahenry,gigahenry,megahenry,kilohenry,hectohenry,dekahenry,decihenry,centihenry,milihenry,microhenry,nanohenry,picohenry,femtohenry
            ,attohenery,weberperampere,abhenery,EMUofinductance,stathenry,ESUofinductance;
    private double edtValue;
    private String conversionFrom;
    //private String conversionTo;


	/*henry=(edtValue)*;
	exahenry=(edtValue)*;
	petahenry=(edtValue)*;
	terahenry=(edtValue)*;
	gigahenry=(edtValue)*;
	megahenry=(edtValue)*;
	kilohenry=(edtValue)*;
	hectohenry=(edtValue)*;
	dekahenry=(edtValue)*;
	decihenry=(edtValue)*;
	centihenry=(edtValue)*;
	milihenry=(edtValue)*;
	microhenry=(edtValue)*;
	nanohenry=(edtValue)*;
	picohenry=(edtValue)*;
	femtohenry=(edtValue)*;
	attohenery=(edtValue)*;
	weberperampere=(edtValue)*;
	abhenery=(edtValue)*;
	EMUofinductance=(edtValue)*;
	stathenry=(edtValue)*;
	ESUofinductance=(edtValue)*;*/

    public InductanceConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateInductanceConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Henry - H":
                henry=(edtValue)*1;
                exahenry=(edtValue)*1.E-18;
                petahenry=(edtValue)*1.E-15;
                terahenry=(edtValue)*1.E-12;
                gigahenry=(edtValue)*1.E-9;
                megahenry=(edtValue)*0.000001;
                kilohenry=(edtValue)*0.001;
                hectohenry=(edtValue)*0.01;
                dekahenry=(edtValue)*0.1;
                decihenry=(edtValue)*10;
                centihenry=(edtValue)*100;
                milihenry=(edtValue)*1000;
                microhenry=(edtValue)*1000000;
                nanohenry=(edtValue)*1000000000;
                picohenry=(edtValue)*1000000000000.0;
                femtohenry=(edtValue)*1000000000000000.0;
                attohenery=(edtValue)*1000000000000000000.0;
                weberperampere=(edtValue)*1;
                abhenery=(edtValue)*1000000000;
                EMUofinductance=(edtValue)*1000000000;
                stathenry=(edtValue)*1.112650029E-12;
                ESUofinductance=(edtValue)*1.112650029E-12;

                break;


            case "Exahenry - EH":
                henry=(edtValue)*1000000000000000000.0;
                exahenry=(edtValue)*1;
                petahenry=(edtValue)*1000;
                terahenry=(edtValue)*1000000;
                gigahenry=(edtValue)*1000000000;
                megahenry=(edtValue)*1000000000000.0;
                kilohenry=(edtValue)*1000000000000000.0;
                hectohenry=(edtValue)*10000000000000000.0;
                dekahenry=(edtValue)*100000000000000000.0;
                decihenry=(edtValue)*10000000000000000000.0;
                centihenry=(edtValue)*99999999999999980000.0;
                milihenry=(edtValue)*1.E+21;
                microhenry=(edtValue)*1.E+24;
                nanohenry=(edtValue)*1.E+27;
                picohenry=(edtValue)*9.999999999E+29;
                femtohenry=(edtValue)*1.E+33;
                attohenery=(edtValue)*9.999999999E+35;
                weberperampere=(edtValue)*1000000000000000000.0;
                abhenery=(edtValue)*1.E+27;
                EMUofinductance=(edtValue)*1.E+27;
                stathenry=(edtValue)*1112650.0297;
                ESUofinductance=(edtValue)*1112650.0297;

                break;

            case "Terahenry - TH":
                henry=(edtValue)*1000000000000.0;
                exahenry=(edtValue)*0.000001;
                petahenry=(edtValue)*0.001;
                terahenry=(edtValue)*1;
                gigahenry=(edtValue)*1000;
                megahenry=(edtValue)*1000000;
                kilohenry=(edtValue)*1000000000;
                hectohenry=(edtValue)*10000000000.0;
                dekahenry=(edtValue)*100000000000.0;
                decihenry=(edtValue)*10000000000000.0;
                centihenry=(edtValue)*100000000000000.0;
                milihenry=(edtValue)*1000000000000000.0;
                microhenry=(edtValue)*1000000000000000000.0;
                nanohenry=(edtValue)*1.E+21;
                picohenry=(edtValue)*1.E+24;
                femtohenry=(edtValue)*1.E+27;
                attohenery=(edtValue)*9.999999999E+29;
                weberperampere=(edtValue)*1000000000000.0;
                abhenery=(edtValue)*1.E+21;
                EMUofinductance=(edtValue)*1.E+21;
                stathenry=(edtValue)*1.1126500297;
                ESUofinductance=(edtValue)*1.1126500297;

                break;

            case"Petahenry - PH":
                henry=(edtValue)*1000000000000000.0;
                exahenry=(edtValue)*0.001;
                petahenry=(edtValue)*1;
                terahenry=(edtValue)*1000;
                gigahenry=(edtValue)*1000000;
                megahenry=(edtValue)*1000000000;
                kilohenry=(edtValue)*1000000000000.0;
                hectohenry=(edtValue)*10000000000000.0;
                dekahenry=(edtValue)*100000000000000.0;
                decihenry=(edtValue)*10000000000000000.0;
                centihenry=(edtValue)*99999999999999980.0;
                milihenry=(edtValue)*1000000000000000000.0;
                microhenry=(edtValue)*1.E+21;
                nanohenry=(edtValue)*1.E+24;
                picohenry=(edtValue)*1.E+27;
                femtohenry=(edtValue)*1.E+30;
                attohenery=(edtValue)*1.E+33;
                weberperampere=(edtValue)*1000000000000000.0;
                abhenery=(edtValue)*1.E+24;
                EMUofinductance=(edtValue)*1.E+24;
                stathenry=(edtValue)*1112.6500297;
                ESUofinductance=(edtValue)*1112.6500297;

                break;
            case "Gigahenry - GH":
                henry=(edtValue)*1000000000;
                exahenry=(edtValue)*1.E-9;
                petahenry=(edtValue)*0.000001;
                terahenry=(edtValue)*0.001;
                gigahenry=(edtValue)*1;
                megahenry=(edtValue)*1000;
                kilohenry=(edtValue)*1000000;
                hectohenry=(edtValue)*10000000;
                dekahenry=(edtValue)*100000000;
                decihenry=(edtValue)*10000000000.0;
                centihenry=(edtValue)*100000000000.0;
                milihenry=(edtValue)*1000000000000.0;
                microhenry=(edtValue)*1000000000000000.0;
                nanohenry=(edtValue)*1000000000000000000.0;
                picohenry=(edtValue)*1.E+21;
                femtohenry=(edtValue)*1.E+24;
                attohenery=(edtValue)*9.999999999E+26;
                weberperampere=(edtValue)*1000000000;
                abhenery=(edtValue)*1000000000000000000.0;
                EMUofinductance=(edtValue)*1000000000000000000.0;
                stathenry=(edtValue)*0.00111265;
                ESUofinductance=(edtValue)*0.00111265;

                break;
            case "Megahenry - MH":
                henry=(edtValue)*1000000;
                exahenry=(edtValue)*1.E-12;
                petahenry=(edtValue)*1.E-9;
                terahenry=(edtValue)*0.000001;
                gigahenry=(edtValue)*0.001;
                megahenry=(edtValue)*1;
                kilohenry=(edtValue)*1000;
                hectohenry=(edtValue)*10000;
                dekahenry=(edtValue)*100000;
                decihenry=(edtValue)*10000000;
                centihenry=(edtValue)*100000000;
                milihenry=(edtValue)*1000000000;
                microhenry=(edtValue)*1000000000000.0;
                nanohenry=(edtValue)*1000000000000000.0;
                picohenry=(edtValue)*1000000000000000000.0;
                femtohenry=(edtValue)*1.E+21;
                attohenery=(edtValue)*1.E+24;
                weberperampere=(edtValue)*1000000;
                abhenery=(edtValue)*1000000000000000.0;
                EMUofinductance=(edtValue)*1000000000000000.0;
                stathenry=(edtValue)*0.0000011127;
                ESUofinductance=(edtValue)*0.0000011127;

                break;
            case "Kilohenry - kH":
                henry=(edtValue)*1000;
                exahenry=(edtValue)*1.E-15;
                petahenry=(edtValue)*1.E-12;
                terahenry=(edtValue)*1.E-9;
                gigahenry=(edtValue)*0.000001;
                megahenry=(edtValue)*0.001;
                kilohenry=(edtValue)*1;
                hectohenry=(edtValue)*10;
                dekahenry=(edtValue)*100;
                decihenry=(edtValue)*10000;
                centihenry=(edtValue)*100000;
                milihenry=(edtValue)*1000000;
                microhenry=(edtValue)*1000000000;
                nanohenry=(edtValue)*1000000000000.0;
                picohenry=(edtValue)*1000000000000000.0;
                femtohenry=(edtValue)*1000000000000000000.0;
                attohenery=(edtValue)*1.E+21;
                weberperampere=(edtValue)*1000;
                abhenery=(edtValue)*1000000000000.0;
                EMUofinductance=(edtValue)*1000000000000.0;
                stathenry=(edtValue)*1.112650029E-9;
                ESUofinductance=(edtValue)*1.112650029E-9;

                break;
            case "Hectohenry - hH":
                henry=(edtValue)*100;
                exahenry=(edtValue)*1.E-16;
                petahenry=(edtValue)*1.E-13;
                terahenry=(edtValue)*1.E-10;
                gigahenry=(edtValue)*1.E-7;
                megahenry=(edtValue)*0.0001;
                kilohenry=(edtValue)*0.1;
                hectohenry=(edtValue)*1;
                dekahenry=(edtValue)*10;
                decihenry=(edtValue)*1000;
                centihenry=(edtValue)*10000;
                milihenry=(edtValue)*100000;
                microhenry=(edtValue)*100000000;
                nanohenry=(edtValue)*100000000000.0;
                picohenry=(edtValue)*100000000000000.0;
                femtohenry=(edtValue)*100000000000000000.0;
                attohenery=(edtValue)*100000000000000000000.0;
                weberperampere=(edtValue)*100;
                abhenery=(edtValue)*100000000000.0;
                EMUofinductance=(edtValue)*100000000000.0;
                stathenry=(edtValue)*1.112650029E-10;
                ESUofinductance=(edtValue)*1.112650029E-10;

                break;
            case "Dekahenry - daH":
                henry=(edtValue)*10;
                exahenry=(edtValue)*1.E-17;
                petahenry=(edtValue)*1.E-14;
                terahenry=(edtValue)*1.E-11;
                gigahenry=(edtValue)*1.E-8;
                megahenry=(edtValue)*0.00001;
                kilohenry=(edtValue)*0.01;
                hectohenry=(edtValue)*0.1;
                dekahenry=(edtValue)*1;
                decihenry=(edtValue)*100;
                centihenry=(edtValue)*1000;
                milihenry=(edtValue)*10000;
                microhenry=(edtValue)*10000000;
                nanohenry=(edtValue)*10000000000.0;
                picohenry=(edtValue)*10000000000000.0;
                femtohenry=(edtValue)*10000000000000000.0;
                attohenery=(edtValue)*10000000000000000000.0;
                weberperampere=(edtValue)*10;
                abhenery=(edtValue)*10000000000.0;
                EMUofinductance=(edtValue)*10000000000.0;
                stathenry=(edtValue)*1.112650029E-11;
                ESUofinductance=(edtValue)*1.112650029E-11;

                break;
            case "Decihenry - dH":
                henry=(edtValue)*0.1;
                exahenry=(edtValue)*1.E-19;
                petahenry=(edtValue)*1.E-16;
                terahenry=(edtValue)*1.E-13;
                gigahenry=(edtValue)*1.E-10;
                megahenry=(edtValue)*1.E-7;
                kilohenry=(edtValue)*0.0001;
                hectohenry=(edtValue)*0.001;
                dekahenry=(edtValue)*0.01;
                decihenry=(edtValue)*1;
                centihenry=(edtValue)*10;
                milihenry=(edtValue)*100;
                microhenry=(edtValue)*100000;
                nanohenry=(edtValue)*100000000;
                picohenry=(edtValue)*100000000000.0;
                femtohenry=(edtValue)*100000000000000.0;
                attohenery=(edtValue)*100000000000000000.0;
                weberperampere=(edtValue)*0.1;
                abhenery=(edtValue)*100000000;
                EMUofinductance=(edtValue)*100000000;
                stathenry=(edtValue)*1.112650029E-13;
                ESUofinductance=(edtValue)*1.112650029E-13;

                break;
            case "Centihenry - cH":
                henry=(edtValue)*0.01;
                exahenry=(edtValue)*1.E-20;
                petahenry=(edtValue)*1.E-17;
                terahenry=(edtValue)*1.E-14;
                gigahenry=(edtValue)*1.E-11;
                megahenry=(edtValue)*1.E-8;
                kilohenry=(edtValue)*0.00001;
                hectohenry=(edtValue)*0.0001;
                dekahenry=(edtValue)*0.001;
                decihenry=(edtValue)*0.1;
                centihenry=(edtValue)*1;
                milihenry=(edtValue)*10;
                microhenry=(edtValue)*10000;
                nanohenry=(edtValue)*10000000;
                picohenry=(edtValue)*10000000000.0;
                femtohenry=(edtValue)*10000000000000.0;
                attohenery=(edtValue)*10000000000000000.0;
                weberperampere=(edtValue)*0.01;
                abhenery=(edtValue)*10000000;
                EMUofinductance=(edtValue)*10000000;
                stathenry=(edtValue)*1.112650029E-14;
                ESUofinductance=(edtValue)*1.112650029E-14;

                break;
            case "Milihenry - mH":
                henry=(edtValue)*0.001;
                exahenry=(edtValue)*1.E-21;
                petahenry=(edtValue)*1.E-18;
                terahenry=(edtValue)*1.E-15;
                gigahenry=(edtValue)*1.E-12;
                megahenry=(edtValue)*1.E-9;
                kilohenry=(edtValue)*0.000001;
                hectohenry=(edtValue)*0.00001;
                dekahenry=(edtValue)*0.0001;
                decihenry=(edtValue)*0.01;
                centihenry=(edtValue)*0.1;
                milihenry=(edtValue)*1;
                microhenry=(edtValue)*1000;
                nanohenry=(edtValue)*1000000;
                picohenry=(edtValue)*1000000000;
                femtohenry=(edtValue)*1000000000000.0;
                attohenery=(edtValue)*1000000000000000.0;
                weberperampere=(edtValue)*0.001;
                abhenery=(edtValue)*1000000;
                EMUofinductance=(edtValue)*1000000;
                stathenry=(edtValue)*1.112650029E-15;
                ESUofinductance=(edtValue)*1.112650029E-15;

                break;

            case "Microhenry - µH":
                henry=(edtValue)*0.000001;
                exahenry=(edtValue)*1.E-24;
                petahenry=(edtValue)*1.E-21;
                terahenry=(edtValue)*1.E-18;
                gigahenry=(edtValue)*1.E-15;
                megahenry=(edtValue)*1.E-12;
                kilohenry=(edtValue)*1.E-9;
                hectohenry=(edtValue)*1.E-8;
                dekahenry=(edtValue)*1.E-7;
                decihenry=(edtValue)*0.00001;
                centihenry=(edtValue)*0.0001;
                milihenry=(edtValue)*0.001;
                microhenry=(edtValue)*1;
                nanohenry=(edtValue)*1000;
                picohenry=(edtValue)*1000000;
                femtohenry=(edtValue)*1000000000;
                attohenery=(edtValue)*1000000000000.0;
                weberperampere=(edtValue)*0.000001;
                abhenery=(edtValue)*1000;
                EMUofinductance=(edtValue)*1000;
                stathenry=(edtValue)*1.112650029E-18;
                ESUofinductance=(edtValue)*1.112650029E-18;

                break;

            case "Nanohenry - nH":
                henry=(edtValue)*1.E-9;
                exahenry=(edtValue)*1.E-27;
                petahenry=(edtValue)*1.E-24;
                terahenry=(edtValue)*1.E-21;
                gigahenry=(edtValue)*1.E-18;
                megahenry=(edtValue)*1.E-15;
                kilohenry=(edtValue)*1.E-12;
                hectohenry=(edtValue)*1.E-11;
                dekahenry=(edtValue)*1.E-10;
                decihenry=(edtValue)*1.E-8;
                centihenry=(edtValue)*1.E-7;
                milihenry=(edtValue)*0.000001;
                microhenry=(edtValue)*0.001;
                nanohenry=(edtValue)*1;
                picohenry=(edtValue)*1000;
                femtohenry=(edtValue)*1000000;
                attohenery=(edtValue)*1000000000;
                weberperampere=(edtValue)*1.E-9;
                abhenery=(edtValue)*1;
                EMUofinductance=(edtValue)*1;
                stathenry=(edtValue)*1.112650029E-21;
                ESUofinductance=(edtValue)*1.112650029E-21;

                break;

            case "Picohenry - pH":
                henry=(edtValue)*1.E-12;
                exahenry=(edtValue)*1.E-30;
                petahenry=(edtValue)*1.E-27;
                terahenry=(edtValue)*1.E-24;
                gigahenry=(edtValue)*1.E-21;
                megahenry=(edtValue)*1.E-18;
                kilohenry=(edtValue)*1.E-15;
                hectohenry=(edtValue)*1.E-14;
                dekahenry=(edtValue)*1.E-13;
                decihenry=(edtValue)*1.E-11;
                centihenry=(edtValue)*9.999999999E-11;
                milihenry=(edtValue)*1.E-9;
                microhenry=(edtValue)*0.000001;
                nanohenry=(edtValue)*0.001;
                picohenry=(edtValue)*1;
                femtohenry=(edtValue)*1000;
                attohenery=(edtValue)*1000000;
                weberperampere=(edtValue)*1.E-12;
                abhenery=(edtValue)*0.001;
                EMUofinductance=(edtValue)*0.001;
                stathenry=(edtValue)*1.112650029E-24;
                ESUofinductance=(edtValue)*1.112650029E-24;

                break;

            case "Femtohenry - fH":
                henry=(edtValue)*9.999999999E-16;
                exahenry=(edtValue)*9.999999999E-34;
                petahenry=(edtValue)*9.999999999E-31;
                terahenry=(edtValue)*1.E-27;
                gigahenry=(edtValue)*1.E-24;
                megahenry=(edtValue)*1.E-21;
                kilohenry=(edtValue)*9.999999999E-19;
                hectohenry=(edtValue)*9.999999999E-18;
                dekahenry=(edtValue)*1.E-16;
                decihenry=(edtValue)*1.E-14;
                centihenry=(edtValue)*9.999999999E-14;
                milihenry=(edtValue)*1.E-12;
                microhenry=(edtValue)*1.E-9;
                nanohenry=(edtValue)*0.000001;
                picohenry=(edtValue)*0.001;
                femtohenry=(edtValue)*1;
                attohenery=(edtValue)*1000;
                weberperampere=(edtValue)*9.999999999E-16;
                abhenery=(edtValue)*0.000001;
                EMUofinductance=(edtValue)*0.000001;
                stathenry=(edtValue)*1.112650029E-27;
                ESUofinductance=(edtValue)*1.112650029E-27;

                break;

            case "Attohenery - aH":
                henry=(edtValue)*1.E-18;
                exahenry=(edtValue)*1.E-36;
                petahenry=(edtValue)*1.E-33;
                terahenry=(edtValue)*1.E-30;
                gigahenry=(edtValue)*1.E-27;
                megahenry=(edtValue)*1.E-24;
                kilohenry=(edtValue)*1.E-21;
                hectohenry=(edtValue)*1.E-20;
                dekahenry=(edtValue)*1.E-19;
                decihenry=(edtValue)*1.E-17;
                centihenry=(edtValue)*1.E-16;
                milihenry=(edtValue)*1.E-15;
                microhenry=(edtValue)*1.E-12;
                nanohenry=(edtValue)*1.E-9;
                picohenry=(edtValue)*0.000001;
                femtohenry=(edtValue)*0.001;
                attohenery=(edtValue)*1;
                weberperampere=(edtValue)*1.E-18;
                abhenery=(edtValue)*1.E-9;
                EMUofinductance=(edtValue)*1.E-9;
                stathenry=(edtValue)*1.112650029E-30;
                ESUofinductance=(edtValue)*1.112650029E-30;

                break;

            case "Weber/ampere - Wb/A":
                henry=(edtValue)*1;
                exahenry=(edtValue)*1.E-18;
                petahenry=(edtValue)*1.E-15;
                terahenry=(edtValue)*1.E-12;
                gigahenry=(edtValue)*1.E-9;
                megahenry=(edtValue)*0.000001;
                kilohenry=(edtValue)*0.001;
                hectohenry=(edtValue)*0.01;
                dekahenry=(edtValue)*0.1;
                decihenry=(edtValue)*10;
                centihenry=(edtValue)*100;
                milihenry=(edtValue)*1000;
                microhenry=(edtValue)*1000000;
                nanohenry=(edtValue)*1000000000;
                picohenry=(edtValue)*1000000000000.0;
                femtohenry=(edtValue)*1000000000000000.0;
                attohenery=(edtValue)*1000000000000000000.0;
                weberperampere=(edtValue)*1;
                abhenery=(edtValue)*1000000000;
                EMUofinductance=(edtValue)*1000000000;
                stathenry=(edtValue)*1.112650029E-12;
                ESUofinductance=(edtValue)*1.112650029E-12;

                break;

            case "Abhenery - abH":
                henry=(edtValue)*1.E-9;
                exahenry=(edtValue)*1.E-27;
                petahenry=(edtValue)*1.E-24;
                terahenry=(edtValue)*1.E-21;
                gigahenry=(edtValue)*1.E-18;
                megahenry=(edtValue)*1.E-15;
                kilohenry=(edtValue)*1.E-12;
                hectohenry=(edtValue)*1.E-11;
                dekahenry=(edtValue)*1.E-10;
                decihenry=(edtValue)*1.E-8;
                centihenry=(edtValue)*1.E-7;
                milihenry=(edtValue)*0.000001;
                microhenry=(edtValue)*0.001;
                nanohenry=(edtValue)*1;
                picohenry=(edtValue)*1000;
                femtohenry=(edtValue)*1000000;
                attohenery=(edtValue)*1000000000;
                weberperampere=(edtValue)*1.E-9;
                abhenery=(edtValue)*1;
                EMUofinductance=(edtValue)*1;
                stathenry=(edtValue)*1.112650029E-21;
                ESUofinductance=(edtValue)*1.112650029E-21;

                break;

            case "EMU of inductance - EMU":
                henry=(edtValue)*1.E-9;
                exahenry=(edtValue)*1.E-27;
                petahenry=(edtValue)*1.E-24;
                terahenry=(edtValue)*1.E-21;
                gigahenry=(edtValue)*1.E-18;
                megahenry=(edtValue)*1.E-15;
                kilohenry=(edtValue)*1.E-12;
                hectohenry=(edtValue)*1.E-11;
                dekahenry=(edtValue)*1.E-10;
                decihenry=(edtValue)*1.E-8;
                centihenry=(edtValue)*1.E-7;
                milihenry=(edtValue)*0.000001;
                microhenry=(edtValue)*0.001;
                nanohenry=(edtValue)*1;
                picohenry=(edtValue)*1000;
                femtohenry=(edtValue)*1000000;
                attohenery=(edtValue)*1000000000;
                weberperampere=(edtValue)*1.E-9;
                abhenery=(edtValue)*1;
                EMUofinductance=(edtValue)*1;
                stathenry=(edtValue)*1.112650029E-21;
                ESUofinductance=(edtValue)*1.112650029E-21;

                break;

            case "Stathenry - stH":
                henry=(edtValue)*898755200000.0;
                exahenry=(edtValue)*8.987552E-7;
                petahenry=(edtValue)*0.0008987552;
                terahenry=(edtValue)*0.8987552;
                gigahenry=(edtValue)*898.7552;
                megahenry=(edtValue)*898755.2;
                kilohenry=(edtValue)*898755200;
                hectohenry=(edtValue)*8987552000.0;
                dekahenry=(edtValue)*89875520000.0;
                decihenry=(edtValue)*8987552000000.0;
                centihenry=(edtValue)*89875520000001.0;
                milihenry=(edtValue)*898755200000007.0;
                microhenry=(edtValue)*898755200000007000.0;
                nanohenry=(edtValue)*898755200000007100000.0;
                picohenry=(edtValue)*8.987552E+23;
                femtohenry=(edtValue)*8.987552E+26;
                attohenery=(edtValue)*8.987552E+29;
                weberperampere=(edtValue)*898755200000.0;
                abhenery=(edtValue)*898755200000007100000.0;
                EMUofinductance=(edtValue)*898755200000007100000.0;
                stathenry=(edtValue)*1;
                ESUofinductance=(edtValue)*1;

                break;

            case "ESU of inductance - ESU":
                henry=(edtValue)*898755200000.0;
                exahenry=(edtValue)*8.987552E-7;
                petahenry=(edtValue)*0.0008987552;
                terahenry=(edtValue)*0.8987552;
                gigahenry=(edtValue)*898.7552;
                megahenry=(edtValue)*898755.2;
                kilohenry=(edtValue)*898755200;
                hectohenry=(edtValue)*8987552000.0;
                dekahenry=(edtValue)*89875520000.0;
                decihenry=(edtValue)*8987552000000.0;
                centihenry=(edtValue)*89875520000001.0;
                milihenry=(edtValue)*898755200000007.0;
                microhenry=(edtValue)*898755200000007000.0;
                nanohenry=(edtValue)*898755200000007100000.0;
                picohenry=(edtValue)*8.987552E+23;
                femtohenry=(edtValue)*8.987552E+26;
                attohenery=(edtValue)*8.987552E+29;
                weberperampere=(edtValue)*898755200000.0;
                abhenery=(edtValue)*898755200000007100000.0;
                EMUofinductance=(edtValue)*898755200000007100000.0;
                stathenry=(edtValue)*1;
                ESUofinductance=(edtValue)*1;

                break;



        }

        results.setHenry(henry);
        results.setExahenry(exahenry);
        results.setPetahenry(petahenry);
        results.setTerahenry(terahenry);
        results.setGigahenry(gigahenry);
        results.setMegahenry(megahenry);
        results.setKilohenry(kilohenry);
        results.setHectohenry(hectohenry);
        results.setDekahenry(dekahenry);
        results.setDecihenry(decihenry);
        results.setCentihenry(centihenry);
        results.setMilihenry(milihenry);
        results.setMicrohenry(microhenry);
        results.setNanohenry(nanohenry);
        results.setPicohenry(picohenry);
        results.setFemtohenry(femtohenry);
        results.setAttohenery(attohenery);
        results.setWeberperampere(weberperampere);
        results.setAbhenery(abhenery);
        results.setEMUofinductance(EMUofinductance);
        results.setStathenry(stathenry);
        results.setESUofinductance(ESUofinductance);
        converterArray.add(results);
        return converterArray;

    }

    public class ConversionResults{
        private double henry,exahenry,petahenry,terahenry,gigahenry,megahenry,kilohenry,hectohenry,dekahenry,decihenry,centihenry,milihenry,microhenry,nanohenry,picohenry,femtohenry
                ,attohenery,weberperampere,abhenery,EMUofinductance,stathenry,ESUofinductance;

        public double getHenry() {
            return henry;
        }

        public void setHenry(double henry) {
            this.henry = henry;
        }

        public double getExahenry() {
            return exahenry;
        }

        public void setExahenry(double exahenry) {
            this.exahenry = exahenry;
        }

        public double getPetahenry() {
            return petahenry;
        }

        public void setPetahenry(double petahenry) {
            this.petahenry = petahenry;
        }

        public double getTerahenry() {
            return terahenry;
        }

        public void setTerahenry(double terahenry) {
            this.terahenry = terahenry;
        }

        public double getGigahenry() {
            return gigahenry;
        }

        public void setGigahenry(double gigahenry) {
            this.gigahenry = gigahenry;
        }

        public double getMegahenry() {
            return megahenry;
        }

        public void setMegahenry(double megahenry) {
            this.megahenry = megahenry;
        }

        public double getKilohenry() {
            return kilohenry;
        }

        public void setKilohenry(double kilohenry) {
            this.kilohenry = kilohenry;
        }

        public double getHectohenry() {
            return hectohenry;
        }

        public void setHectohenry(double hectohenry) {
            this.hectohenry = hectohenry;
        }

        public double getDekahenry() {
            return dekahenry;
        }

        public void setDekahenry(double dekahenry) {
            this.dekahenry = dekahenry;
        }

        public double getDecihenry() {
            return decihenry;
        }

        public void setDecihenry(double decihenry) {
            this.decihenry = decihenry;
        }

        public double getCentihenry() {
            return centihenry;
        }

        public void setCentihenry(double centihenry) {
            this.centihenry = centihenry;
        }

        public double getMilihenry() {
            return milihenry;
        }

        public void setMilihenry(double milihenry) {
            this.milihenry = milihenry;
        }

        public double getMicrohenry() {
            return microhenry;
        }

        public void setMicrohenry(double microhenry) {
            this.microhenry = microhenry;
        }

        public double getNanohenry() {
            return nanohenry;
        }

        public void setNanohenry(double nanohenry) {
            this.nanohenry = nanohenry;
        }

        public double getPicohenry() {
            return picohenry;
        }

        public void setPicohenry(double picohenry) {
            this.picohenry = picohenry;
        }

        public double getFemtohenry() {
            return femtohenry;
        }

        public void setFemtohenry(double femtohenry) {
            this.femtohenry = femtohenry;
        }

        public double getAttohenery() {
            return attohenery;
        }

        public void setAttohenery(double attohenery) {
            this.attohenery = attohenery;
        }

        public double getWeberperampere() {
            return weberperampere;
        }

        public void setWeberperampere(double weberperampere) {
            this.weberperampere = weberperampere;
        }

        public double getAbhenery() {
            return abhenery;
        }

        public void setAbhenery(double abhenery) {
            this.abhenery = abhenery;
        }

        public double getEMUofinductance() {
            return EMUofinductance;
        }

        public void setEMUofinductance(double eMUofinductance) {
            EMUofinductance = eMUofinductance;
        }

        public double getStathenry() {
            return stathenry;
        }

        public void setStathenry(double stathenry) {
            this.stathenry = stathenry;
        }

        public double getESUofinductance() {
            return ESUofinductance;
        }

        public void setESUofinductance(double eSUofinductance) {
            ESUofinductance = eSUofinductance;
        }





    }





}
