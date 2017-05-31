package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class ElectricFieldStrengthConverter {

    private double  voltpermeter    , kilovoltpermeter   ,  kilovoltpercentimeter   ,voltpercentimeter   ,millivoltpermeter    , microvoltpermeter,  kilovoltperinch ,voltperinch,voltpermil,abvoltpercentimeter,statvoltpercentimeter,statvoltperinch,newtonpercoulomb   ;
    private String conversionFrom;
    private double edtValue;


    public ElectricFieldStrengthConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateLElectricFieldStrengthConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Volt/meter - V/m":

                voltpermeter=(edtValue)*1;
                kilovoltpermeter=(edtValue)*0.001;
                kilovoltpercentimeter=(edtValue)*0.00001;
                voltpercentimeter=(edtValue)*0.01;
                millivoltpermeter=(edtValue)*1000;
                microvoltpermeter=(edtValue)*1000000;
                kilovoltperinch=(edtValue)*0.0000254;
                voltperinch=(edtValue)*0.0000254;

                voltpermil=(edtValue)*0.0000254;
                abvoltpercentimeter=(edtValue)*1000000;
                statvoltpercentimeter=(edtValue)*0.0000333565;
                statvoltperinch=(edtValue)*0.0000847254;
                newtonpercoulomb=(edtValue)*1;



                break;


            case "Kilovolt/meter - kV/m":

                voltpermeter=(edtValue)*1000;
                kilovoltpermeter=(edtValue)*1;
                kilovoltpercentimeter=(edtValue)*0.01;
                voltpercentimeter=(edtValue)*10;
                millivoltpermeter=(edtValue)*1000000;
                microvoltpermeter=(edtValue)*1000000000;
                kilovoltperinch=(edtValue)*0.0254;
                voltperinch=(edtValue)*25.4;

                voltpermil=(edtValue)*0.0254;
                abvoltpercentimeter=(edtValue)*1000000000;
                statvoltpercentimeter=(edtValue)*0.0333564605;
                statvoltperinch=(edtValue)*0.0847254096;
                newtonpercoulomb=(edtValue)*1000;



                break;


            case "Kilovolt/centimeter - kV/cm":

                voltpermeter=(edtValue)*100000;
                kilovoltpermeter=(edtValue)*100;
                kilovoltpercentimeter=(edtValue)*1;
                voltpercentimeter=(edtValue)*1000;
                millivoltpermeter=(edtValue)*100000000;
                microvoltpermeter=(edtValue)*100000000000.0;
                kilovoltperinch=(edtValue)*2.54;
                voltperinch=(edtValue)*2540;

                voltpermil=(edtValue)*2.54;
                abvoltpercentimeter=(edtValue)*100000000000.0;
                statvoltpercentimeter=(edtValue)*3.335646048;
                statvoltperinch=(edtValue)*8.472540962;
                newtonpercoulomb=(edtValue)*100000;



                break;


            case "Volt/centimeter - V/cm" :

                voltpermeter=(edtValue)*100;
                kilovoltpermeter=(edtValue)*0.1;
                kilovoltpercentimeter=(edtValue)*0.001;
                voltpercentimeter=(edtValue)*1;
                millivoltpermeter=(edtValue)*100000;
                microvoltpermeter=(edtValue)*100000000;
                kilovoltperinch=(edtValue)*0.00254;
                voltperinch=(edtValue)*2.54;

                voltpermil=(edtValue)*0.00254;
                abvoltpercentimeter=(edtValue)*100000000;
                statvoltpercentimeter=(edtValue)*0.003335646;
                statvoltperinch=(edtValue)*0.008472541;
                newtonpercoulomb=(edtValue)*100;



                break;



            case "Millivolt/meter - mV/m":

                voltpermeter=(edtValue)*0.001;
                kilovoltpermeter=(edtValue)*0.000001;
                kilovoltpercentimeter=(edtValue)*1.E-8;
                voltpercentimeter=(edtValue)*0.00001;
                millivoltpermeter=(edtValue)*1;
                microvoltpermeter=(edtValue)*1000;
                kilovoltperinch=(edtValue)*2.54E-8;
                voltperinch=(edtValue)*0.0000254;

                voltpermil=(edtValue)*2.54E-8;
                abvoltpercentimeter=(edtValue)*1000;
                statvoltpercentimeter=(edtValue)*3.335646048E-8;
                statvoltperinch=(edtValue)*8.472540962E-8;
                newtonpercoulomb=(edtValue)*0.001;



                break;



            case "Microvolt/meter - µ/m":

                voltpermeter=(edtValue)*0.000001;
                kilovoltpermeter=(edtValue)*1.E-9;
                kilovoltpercentimeter=(edtValue)*1.E-11;
                voltpercentimeter=(edtValue)*1.E-8;
                millivoltpermeter=(edtValue)*0.001;
                microvoltpermeter=(edtValue)*1;
                kilovoltperinch=(edtValue)*2.54E-11;
                voltperinch=(edtValue)*2.54E-8;

                voltpermil=(edtValue)*2.54E-11;
                abvoltpercentimeter=(edtValue)*1;
                statvoltpercentimeter=(edtValue)*3.335646048E-11;
                statvoltperinch=(edtValue)*8.472540962E-11;
                newtonpercoulomb=(edtValue)*0.000001;



                break;


            case "Kilovolt/inch - kV/in":

                voltpermeter=(edtValue)*39370.07874;
                kilovoltpermeter=(edtValue)*39.37007874;
                kilovoltpercentimeter=(edtValue)*0.3937007874;
                voltpercentimeter=(edtValue)*393.7007874;
                millivoltpermeter=(edtValue)*39370078.74;
                microvoltpermeter=(edtValue)*39370078740.0;
                kilovoltperinch=(edtValue)*1;
                voltperinch=(edtValue)*1000;

                voltpermil=(edtValue)*1;
                abvoltpercentimeter=(edtValue)*39370078740.0;
                statvoltpercentimeter=(edtValue)*1.3132464756;
                statvoltperinch=(edtValue)*3.335646048;
                newtonpercoulomb=(edtValue)*39370.07874;



                break;


            case "Volt/inch - V/in":

                voltpermeter=(edtValue)*39.37007874;
                kilovoltpermeter=(edtValue)*0.0393700787;
                kilovoltpercentimeter=(edtValue)*0.0003937008;
                voltpercentimeter=(edtValue)*0.3937007874;
                millivoltpermeter=(edtValue)*39370.07874;
                microvoltpermeter=(edtValue)*39370078.74;
                kilovoltperinch=(edtValue)*0.001;
                voltperinch=(edtValue)*1;

                voltpermil=(edtValue)*0.001;
                abvoltpercentimeter=(edtValue)*39370078.74;
                statvoltpercentimeter=(edtValue)*0.0013132465;
                statvoltperinch=(edtValue)*0.003335646;
                newtonpercoulomb=(edtValue)*39.37007874;



                break;


            case "Volt/mil - V/mil":

                voltpermeter=(edtValue)*39370.07874;
                kilovoltpermeter=(edtValue)*39.37007874;
                kilovoltpercentimeter=(edtValue)*0.3937007874;
                voltpercentimeter=(edtValue)*393.7007874;
                millivoltpermeter=(edtValue)*39370078.74;
                microvoltpermeter=(edtValue)*39370078740.0;
                kilovoltperinch=(edtValue)*1;
                voltperinch=(edtValue)*1000;

                voltpermil=(edtValue)*1;
                abvoltpercentimeter=(edtValue)*39370078740.0;
                statvoltpercentimeter=(edtValue)*1.3132464756;
                statvoltperinch=(edtValue)*3.335646048;
                newtonpercoulomb=(edtValue)*39370.07874;



                break;


            case "Abvolt/centimeter - abV/cm":

                voltpermeter=(edtValue)*0.000001;
                kilovoltpermeter=(edtValue)*1.E-9;
                kilovoltpercentimeter=(edtValue)*1.E-11;
                voltpercentimeter=(edtValue)*1.E-8;
                millivoltpermeter=(edtValue)*0.001;
                microvoltpermeter=(edtValue)*1;
                kilovoltperinch=(edtValue)*2.54E-11;
                voltperinch=(edtValue)*2.54E-8;

                voltpermil=(edtValue)*2.54E-11;
                abvoltpercentimeter=(edtValue)*1;
                statvoltpercentimeter=(edtValue)*3.335646048E-11;
                statvoltperinch=(edtValue)*8.472540962E-11;
                newtonpercoulomb=(edtValue)*0.000001;



                break;


            case "Statvolt/centimeter - stV/cm":

                voltpermeter=(edtValue)*29979.199999;
                kilovoltpermeter=(edtValue)*29.979199999;
                kilovoltpercentimeter=(edtValue)*0.299792;
                voltpercentimeter=(edtValue)*299.79199999;
                millivoltpermeter=(edtValue)*29979199.999;
                microvoltpermeter=(edtValue)*29979199999.0;
                kilovoltperinch=(edtValue)*0.76147168;
                voltperinch=(edtValue)*761.47167998;

                voltpermil=(edtValue)*0.76147168;
                abvoltpercentimeter=(edtValue)*29979199999.0;
                statvoltpercentimeter=(edtValue)*1;
                statvoltperinch=(edtValue)*2.54;
                newtonpercoulomb=(edtValue)*29979.199999;



                break;

            case "Statvolt/inch - stV/in":

                voltpermeter=(edtValue)*11802.834645;
                kilovoltpermeter=(edtValue)*11.802834645;
                kilovoltpercentimeter=(edtValue)*0.1180283465;
                voltpercentimeter=(edtValue)*118.02834645;
                millivoltpermeter=(edtValue)*11802834.645;
                microvoltpermeter=(edtValue)*11802834645.0;
                kilovoltperinch=(edtValue)*0.299792;
                voltperinch=(edtValue)*299.79199999;

                voltpermil=(edtValue)*0.299792;
                abvoltpercentimeter=(edtValue)*11802834645.0;
                statvoltpercentimeter=(edtValue)*0.3937007874;
                statvoltperinch=(edtValue)*1;
                newtonpercoulomb=(edtValue)*11802.834645;



                break;

            case "Newton/coulomb - N/C":

                voltpermeter=(edtValue)*1;
                kilovoltpermeter=(edtValue)*0.001;
                kilovoltpercentimeter=(edtValue)*0.00001;
                voltpercentimeter=(edtValue)*0.01;
                millivoltpermeter=(edtValue)*1000;
                microvoltpermeter=(edtValue)*1000000;
                kilovoltperinch=(edtValue)*0.0000254;
                voltperinch=(edtValue)*0.0254;

                voltpermil=(edtValue)*0.0000254;
                abvoltpercentimeter=(edtValue)*1000000;
                statvoltpercentimeter=(edtValue)*0.0000333565;
                statvoltperinch=(edtValue)*0.0000847254;
                newtonpercoulomb=(edtValue)*1;



                break;


        }


        results. setVoltpermeter( voltpermeter);

        results. setKilovoltpermeter( kilovoltpermeter);
        results. setKilovoltpercentimeter( kilovoltpercentimeter);
        results. setVoltpercentimeter( voltpercentimeter);

        results. setMillivoltpermeter( millivoltpermeter);


        results. setMicrovoltpermeter( microvoltpermeter) ;

        results. setKilovoltperinch( kilovoltperinch);

        results. setVoltperinch( voltperinch);
        results. setVoltpermil( voltpermil) ;
        results. setAbvoltpercentimeter( abvoltpercentimeter);
        results. setStatvoltpercentimeter( statvoltpercentimeter);

        results. setStatvoltperinch( statvoltperinch);

        results. setNewtonpercoulomb( newtonpercoulomb);
        converterArray.add(results);
        return converterArray;

    }


    public class ConversionResults{

        private double  voltpermeter    , kilovoltpermeter   ,  kilovoltpercentimeter   ,voltpercentimeter   ,millivoltpermeter    , microvoltpermeter,  kilovoltperinch ,voltperinch,voltpermil,abvoltpercentimeter,statvoltpercentimeter,statvoltperinch,newtonpercoulomb   ;

        public double getVoltpermeter() {
            return voltpermeter;
        }

        public void setVoltpermeter(double voltpermeter) {
            this.voltpermeter = voltpermeter;
        }

        public double getKilovoltpermeter() {
            return kilovoltpermeter;
        }

        public void setKilovoltpermeter(double kilovoltpermeter) {
            this.kilovoltpermeter = kilovoltpermeter;
        }

        public double getKilovoltpercentimeter() {
            return kilovoltpercentimeter;
        }

        public void setKilovoltpercentimeter(double kilovoltpercentimeter) {
            this.kilovoltpercentimeter = kilovoltpercentimeter;
        }

        public double getVoltpercentimeter() {
            return voltpercentimeter;
        }

        public void setVoltpercentimeter(double voltpercentimeter) {
            this.voltpercentimeter = voltpercentimeter;
        }

        public double getMillivoltpermeter() {
            return millivoltpermeter;
        }

        public void setMillivoltpermeter(double millivoltpermeter) {
            this.millivoltpermeter = millivoltpermeter;
        }

        public double getMicrovoltpermeter() {
            return microvoltpermeter;
        }

        public void setMicrovoltpermeter(double microvoltpermeter) {
            this.microvoltpermeter = microvoltpermeter;
        }

        public double getKilovoltperinch() {
            return kilovoltperinch;
        }

        public void setKilovoltperinch(double kilovoltperinch) {
            this.kilovoltperinch = kilovoltperinch;
        }

        public double getVoltperinch() {
            return voltperinch;
        }

        public void setVoltperinch(double voltperinch) {
            this.voltperinch = voltperinch;
        }

        public double getVoltpermil() {
            return voltpermil;
        }

        public void setVoltpermil(double voltpermil) {
            this.voltpermil = voltpermil;
        }

        public double getAbvoltpercentimeter() {
            return abvoltpercentimeter;
        }

        public void setAbvoltpercentimeter(double abvoltpercentimeter) {
            this.abvoltpercentimeter = abvoltpercentimeter;
        }

        public double getStatvoltpercentimeter() {
            return statvoltpercentimeter;
        }

        public void setStatvoltpercentimeter(double statvoltpercentimeter) {
            this.statvoltpercentimeter = statvoltpercentimeter;
        }

        public double getStatvoltperinch() {
            return statvoltperinch;
        }

        public void setStatvoltperinch(double statvoltperinch) {
            this.statvoltperinch = statvoltperinch;
        }

        public double getNewtonpercoulomb() {
            return newtonpercoulomb;
        }

        public void setNewtonpercoulomb(double newtonpercoulomb) {
            this.newtonpercoulomb = newtonpercoulomb;
        }



    }




  /*  public static void main(String[] args) {
        // TODO Auto-generated method stub
        ElectricFieldStrength iA = new ElectricFieldStrength("voltpermeter",1);

        ArrayList<ElectricFieldStrength.ConversionResults> results = iA.calculateLElectricFieldStrengthConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            ElectricFieldStrength.ConversionResults item  =  results.get(i);

            System.out.println("\n voltpermeter - " +new DecimalFormat("##.################").format( item.getVoltpermeter())
                    +"\n kilovoltpermeter- " +new DecimalFormat("##.################").format( item.getKilovoltpermeter())
                    +"\n kilovoltpercentimeter - " +new DecimalFormat("##.################").format( item.getKilovoltpercentimeter())+
                    "\n voltpercentimeter - " +new DecimalFormat("##.################").format( item.getVoltpercentimeter())

                    +"\n millivoltpermeter- " +new DecimalFormat("##.################").format( item.getMillivoltpermeter())
                    +"\n microvoltpermeter - " +new DecimalFormat("##.################").format( item.getMicrovoltpermeter())

                    +"\n kilovoltperinch - " +new DecimalFormat("##.################").format( item.getKilovoltperinch())+
                    "\n voltperinch - " +new DecimalFormat("##.################").format( item.getVoltperinch())

                    +"\n voltpermil- " +new DecimalFormat("##.################").format( item.getVoltpermil())
                    +"\n abvoltpercentimeter - " +new DecimalFormat("##.################").format( item.getAbvoltpercentimeter())


                    +"\n statvoltpercentimeter - " +new DecimalFormat("##.################").format( item.getStatvoltpercentimeter())+
                    "\n statvoltperinch - " +new DecimalFormat("##.################").format( item.getStatvoltperinch())

                    +"\n newtonpercoulomb- " +new DecimalFormat("##.################").format( item.getNewtonpercoulomb())




            );



        }
    }*/
}
