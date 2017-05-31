package com.nineinfosys.electricityconverter.Engin;

        import java.util.ArrayList;


public class ElectricResistanceConverter{
    private double ohm,megohm,microhm,voltperampere,reciprocalsiemens,abohm,EMUofresistance,statohm,ESUofresistance,QuantizedHallresistance;
    private double edtValue;
    private String conversionFrom;
    //private String conversionTo;
    public ElectricResistanceConverter(String conversionFrom, int edtValue){
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }
    public ArrayList<ConversionResults> calculateResistanceConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Ohm - Ω":

                ohm=(edtValue)*1;
                megohm=(edtValue)*0.000001;
                microhm=(edtValue)*1000000;
                voltperampere=(edtValue)*1;
                reciprocalsiemens=(edtValue)*1;
                abohm=(edtValue)*1000000000;
                EMUofresistance=(edtValue)*1000000000;
                statohm=(edtValue)*1.112650029E-12;
                ESUofresistance=(edtValue)*1.112650029E-12;
                QuantizedHallresistance=(edtValue)*0.0000387405;

                break;

            case "Megohm - megohm":

                ohm=(edtValue)*1000000;
                megohm=(edtValue)*1;
                microhm=(edtValue)*1000000000000.0000000000;
                voltperampere=(edtValue)*1000000;
                reciprocalsiemens=(edtValue)*1000000;
                abohm=(edtValue)*1000000000000000.0000000000;
                EMUofresistance=(edtValue)*1000000000000000.0000000000;
                statohm=(edtValue)*0.0000011127;
                ESUofresistance=(edtValue)*0.0000011127;
                QuantizedHallresistance=(edtValue)*38.74046144;


                break;

            case "Microhm - microhm":

                ohm=(edtValue)*0.000001;
                megohm=(edtValue)*1.E-12;
                microhm=(edtValue)*1;
                voltperampere=(edtValue)*0.000001;
                reciprocalsiemens=(edtValue)*0.000001;
                abohm=(edtValue)*1000;
                EMUofresistance=(edtValue)*1000;
                statohm=(edtValue)*1.112650029E-18;
                ESUofresistance=(edtValue)*1.112650029E-18;
                QuantizedHallresistance=(edtValue)*3.874046143E-11;


                break;
            case "Volt/ampere - V/A":

                ohm=(edtValue)*1;
                megohm=(edtValue)*0.000001;
                microhm=(edtValue)*1000000;
                voltperampere=(edtValue)*1;
                reciprocalsiemens=(edtValue)*1;
                abohm=(edtValue)*1000000000;
                EMUofresistance=(edtValue)*1000000000;
                statohm=(edtValue)*1.112650029E-12;
                ESUofresistance=(edtValue)*1.112650029E-12;
                QuantizedHallresistance=(edtValue)*0.0000387405;


                break;
            case "Reciprocal siemens - 1/S":

                ohm=(edtValue)*1;
                megohm=(edtValue)*0.000001;
                microhm=(edtValue)*1000000;
                voltperampere=(edtValue)*1;
                reciprocalsiemens=(edtValue)*1;
                abohm=(edtValue)*1000000000;
                EMUofresistance=(edtValue)*1000000000;
                statohm=(edtValue)*1.112650029E-12;
                ESUofresistance=(edtValue)*1.112650029E-12;
                QuantizedHallresistance=(edtValue)*0.0000387405  ;


                break;
            case "Abohm - abΩ":

                ohm=(edtValue)*1.E-9;
                megohm=(edtValue)*1.E-15;
                microhm=(edtValue)*0.001;
                voltperampere=(edtValue)*1.E-9;
                reciprocalsiemens=(edtValue)*1.E-9;
                abohm=(edtValue)*1;
                EMUofresistance=(edtValue)*1;
                statohm=(edtValue)*1.112650029E-21;
                ESUofresistance=(edtValue)*1.112650029E-21;
                QuantizedHallresistance=(edtValue)*3.874046143E-14;


                break;

            case "EMU of resistance - EMU" :

                ohm=(edtValue)*1.E-9;
                megohm=(edtValue)*1.E-15;
                microhm=(edtValue)*0.001;
                voltperampere=(edtValue)*1.E-9;
                reciprocalsiemens=(edtValue)*1.E-9;
                abohm=(edtValue)*1;
                EMUofresistance=(edtValue)*1;
                statohm=(edtValue)*1.112650029E-21;
                ESUofresistance=(edtValue)*1.112650029E-21;
                QuantizedHallresistance=(edtValue)*3.874046143E-14;


                break;

            case "Statohm - stΩ":

                ohm=(edtValue)*898755200000.0000000000;
                megohm=(edtValue)*898755.2;
                microhm=(edtValue)*898755200000007200.0000000000;
                voltperampere=(edtValue)*898755200000.0000000000;
                reciprocalsiemens=(edtValue)*898755200000.0000000000;
                abohm=(edtValue)*898755200000007100000.0000000000;
                EMUofresistance=(edtValue)*898755200000007100000.0000000000;
                statohm=(edtValue)*1;
                ESUofresistance=(edtValue)*1;
                QuantizedHallresistance=(edtValue)*34818191.169;


                break;
            case "ESU of resistance - ESU" :

                ohm=(edtValue)*898755200000.0000000000;
                megohm=(edtValue)*898755.2;
                microhm=(edtValue)*898755200000007200.0000000000;
                voltperampere=(edtValue)*898755200000.0000000000;
                reciprocalsiemens=(edtValue)*898755200000.0000000000;
                abohm=(edtValue)*898755200000007100000.0000000000;
                EMUofresistance=(edtValue)*898755200000007100000.0000000000;
                statohm=(edtValue)*1;
                ESUofresistance=(edtValue)*1;
                QuantizedHallresistance=(edtValue)*34818191.169;


                break;

            case "Quantized Hall resistance - Ω":

                ohm=(edtValue)*25812.8056;
                megohm=(edtValue)*0.0258128056;
                microhm=(edtValue)*25812805600.0000000000;
                voltperampere=(edtValue)*25812.8056;
                reciprocalsiemens=(edtValue)*25812.8056;
                abohm=(edtValue)*25812805600000.0000000000;
                EMUofresistance=(edtValue)*25812805600000.0000000000;
                statohm=(edtValue)*2.872061891E-8;
                ESUofresistance=(edtValue)*2.872061891E-8;
                QuantizedHallresistance=(edtValue)*1;


                break;
            case "Default":
                break;

        }
        results.setOhm(ohm);
        results.setMegohm(megohm);
        results.setMicrohm(microhm);
        results.setVoltperampere(voltperampere);
        results.setReciprocalsiemens(reciprocalsiemens);
        results.setAbohm(abohm);
        results.setEMUofresistance(EMUofresistance);
        results.setStatohm(statohm);
        results.setESUofresistance(ESUofresistance);
        results.setQuantizedHallresistance(QuantizedHallresistance);
        converterArray.add(results);
        return converterArray;
    }

    public class ConversionResults{
        private double ohm,megohm,microhm,voltperampere,reciprocalsiemens,abohm,EMUofresistance,statohm,ESUofresistance,QuantizedHallresistance;

        public double getOhm() {
            return ohm;
        }

        public void setOhm(double ohm) {
            this.ohm = ohm;
        }

        public double getMegohm() {
            return megohm;
        }

        public void setMegohm(double megohm) {
            this.megohm = megohm;
        }

        public double getMicrohm() {
            return microhm;
        }

        public void setMicrohm(double microhm) {
            this.microhm = microhm;
        }

        public double getVoltperampere() {
            return voltperampere;
        }

        public void setVoltperampere(double voltperampere) {
            this.voltperampere = voltperampere;
        }

        public double getReciprocalsiemens() {
            return reciprocalsiemens;
        }

        public void setReciprocalsiemens(double reciprocalsiemens) {
            this.reciprocalsiemens = reciprocalsiemens;
        }

        public double getAbohm() {
            return abohm;
        }

        public void setAbohm(double abohm) {
            this.abohm = abohm;
        }

        public double getEMUofresistance() {
            return EMUofresistance;
        }

        public void setEMUofresistance(double eMUofresistance) {
            EMUofresistance = eMUofresistance;
        }

        public double getStatohm() {
            return statohm;
        }

        public void setStatohm(double statohm) {
            this.statohm = statohm;
        }

        public double getESUofresistance() {
            return ESUofresistance;
        }

        public void setESUofresistance(double eSUofresistance) {
            ESUofresistance = eSUofresistance;
        }

        public double getQuantizedHallresistance() {
            return QuantizedHallresistance;
        }

        public void setQuantizedHallresistance(double quantizedHallresistance) {
            QuantizedHallresistance = quantizedHallresistance;
        }

    }
}
