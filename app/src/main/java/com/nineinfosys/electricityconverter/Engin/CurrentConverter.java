package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class CurrentConverter {

    private double ampere,kiloampere,miliampere,biot,abampere,EMUofcurrent,statampere,ESUofcurrent,CGSemunit,CGSesunit;
    private double edtValue;
    private String conversionFrom;


    public CurrentConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateCurrentConversion()
    {

        ArrayList<ConversionResults> currentArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Ampere - A":
                ampere=(edtValue)*1;
                kiloampere=(edtValue)*0.001;
                miliampere=(edtValue)*1000;
                biot=(edtValue)*0.1;
                abampere=(edtValue)*0.1;
                EMUofcurrent=(edtValue)*0.1;
                statampere=(edtValue)*2997924536.8;
                ESUofcurrent=(edtValue)*2997924536.8;
                CGSemunit=(edtValue)*0.1;
                CGSesunit=(edtValue)*2997924536.8;

                break;


            case "Kiloampere - kA":
                ampere=(edtValue)*1000;
                kiloampere=(edtValue)*1;
                miliampere=(edtValue)*1000000;
                biot=(edtValue)*100;
                abampere=(edtValue)*100;
                EMUofcurrent=(edtValue)*100;
                statampere=(edtValue)*2997924536843.0;
                ESUofcurrent=(edtValue)*2997924536843.0;
                CGSemunit=(edtValue)*100;
                CGSesunit=(edtValue)*2997924536843.0;
                break;

            case "Milliampere - mA":
                ampere=(edtValue)*0.001;
                kiloampere=(edtValue)*0.000001;
                miliampere=(edtValue)*1;
                biot=(edtValue)*0.0001;
                abampere=(edtValue)*0.0001;
                EMUofcurrent=(edtValue)*0.0001;
                statampere=(edtValue)*2997924.5368;
                ESUofcurrent=(edtValue)*2997924.5368;
                CGSemunit=(edtValue)*0.0001;
                CGSesunit=(edtValue)*2997924.5368;
                break;

            case "Biot - Bi":
                ampere=(edtValue)*10;
                kiloampere=(edtValue)*0.01;
                miliampere=(edtValue)*10000;
                biot=(edtValue)*1;
                abampere=(edtValue)*1;
                EMUofcurrent=(edtValue)*1;
                statampere=(edtValue)*29979245368.0;
                ESUofcurrent=(edtValue)*29979245368.0;
                CGSemunit=(edtValue)*1;
                CGSesunit=(edtValue)*29979245368.0;
                break;
            case "Abampere - abA":
                ampere=(edtValue)*10;
                kiloampere=(edtValue)*0.01;
                miliampere=(edtValue)*10000;
                biot=(edtValue)*1;
                abampere=(edtValue)*1;
                EMUofcurrent=(edtValue)*1;
                statampere=(edtValue)*29979245368.0;
                ESUofcurrent=(edtValue)*29979245368.0;
                CGSemunit=(edtValue)*1;
                CGSesunit=(edtValue)*29979245368.0;
                break;
            case "EMU of current - emuA":
                ampere=(edtValue)*10;
                kiloampere=(edtValue)*0.01;
                miliampere=(edtValue)*10000;
                biot=(edtValue)*1;
                abampere=(edtValue)*1;
                EMUofcurrent=(edtValue)*1;
                statampere=(edtValue)*29979245368.0;
                ESUofcurrent=(edtValue)*29979245368.0;
                CGSemunit=(edtValue)*1;
                CGSesunit=(edtValue)*29979245368.0;
                break;
            case "Statampere - stA":
                ampere=(edtValue)*3.335641E-10;
                kiloampere=(edtValue)*3.335641E-13;
                miliampere=(edtValue)*3.335641E-7;
                biot=(edtValue)*3.335641E-11;
                abampere=(edtValue)*3.335641E-11;
                EMUofcurrent=(edtValue)*3.335641E-11;
                statampere=(edtValue)*1.0;
                ESUofcurrent=(edtValue)*1;
                CGSemunit=(edtValue)*3.335641E-11;
                CGSesunit=(edtValue)*1;
                break;
            case "ESU of current - esuA":
                ampere=(edtValue)*3.335641E-10;
                kiloampere=(edtValue)*3.335641E-13;
                miliampere=(edtValue)*3.335641E-7;
                biot=(edtValue)*3.335641E-11;
                abampere=(edtValue)*3.335641E-11;
                EMUofcurrent=(edtValue)*3.335641E-11;
                statampere=(edtValue)*1;
                ESUofcurrent=(edtValue)*1;
                CGSemunit=(edtValue)*3.335641E-11;
                CGSesunit=(edtValue)*1;
                break;
            case "CGS e.m.unit - e.m.unit":
                ampere=(edtValue)*10;
                kiloampere=(edtValue)*0.01;
                miliampere=(edtValue)*10000;
                biot=(edtValue)*1;
                abampere=(edtValue)*1;
                EMUofcurrent=(edtValue)*1;
                statampere=(edtValue)*29979245368.0;
                ESUofcurrent=(edtValue)*29979245368.0;
                CGSemunit=(edtValue)*1;
                CGSesunit=(edtValue)*29979245368.0;
                break;
            case "CGS e.s.unit - e.s.unit":
                ampere=(edtValue)*3.335641E-10;
                kiloampere=(edtValue)*3.335641E-13;
                miliampere=(edtValue)*3.335641E-7;
                biot=(edtValue)*3.335641E-11;
                abampere=(edtValue)*3.335641E-11;
                EMUofcurrent=(edtValue)*3.335641E-11;
                statampere=(edtValue)*1;
                ESUofcurrent=(edtValue)*1;
                CGSemunit=(edtValue)*3.335641E-11;
                CGSesunit=(edtValue)*1;
                break;

        }
        results.setAmpere(ampere);
        results.setKiloampere(kiloampere);
        results.setMiliampere(miliampere);
        results.setBiot(biot);
        results.setAbampere(abampere);
        results.setEMUofcurrent(EMUofcurrent);
        results.setStatampere(statampere);
        results.setESUofcurrent(ESUofcurrent);
        results.setCGSemunit(CGSemunit);
        results.setCGSesunit(CGSesunit);


        currentArray.add(results);
        return currentArray;



    }

    public class ConversionResults{
        private double ampere,kiloampere,miliampere,biot,abampere,EMUofcurrent,statampere,ESUofcurrent,CGSemunit,CGSesunit;


        public double getAmpere() {
            return ampere;
        }

        public void setAmpere(double ampere) {
            this.ampere = ampere;
        }

        public double getKiloampere() {
            return kiloampere;
        }

        public void setKiloampere(double kiloampere) {
            this.kiloampere = kiloampere;
        }

        public double getMiliampere() {
            return miliampere;
        }

        public void setMiliampere(double miliampere) {
            this.miliampere = miliampere;
        }

        public double getBiot() {
            return biot;
        }

        public void setBiot(double biot) {
            this.biot = biot;
        }

        public double getAbampere() {
            return abampere;
        }

        public void setAbampere(double abampere) {
            this.abampere = abampere;
        }

        public double getESUofcurrent() {
            return ESUofcurrent;
        }

        public void setESUofcurrent(double eSUofcurrent) {
            ESUofcurrent = eSUofcurrent;
        }

        public double getCGSemunit() {
            return CGSemunit;
        }

        public void setCGSemunit(double cGSemunit) {
            CGSemunit = cGSemunit;
        }

        public double getCGSesunit() {
            return CGSesunit;
        }

        public void setCGSesunit(double cGSesunit) {
            CGSesunit = cGSesunit;
        }

        public double getEMUofcurrent() {
            return EMUofcurrent;
        }

        public void setEMUofcurrent(double eMUofcurrent) {
            EMUofcurrent = eMUofcurrent;
        }

        public double getStatampere() {
            return statampere;
        }

        public void setStatampere(double statampere) {
            this.statampere = statampere;
        }
    }

}

