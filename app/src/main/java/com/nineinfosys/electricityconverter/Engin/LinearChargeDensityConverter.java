package com.nineinfosys.electricityconverter.Engin;
import java.util.ArrayList;


public class LinearChargeDensityConverter {

    private double  coulombpermeter   , coulombpercentimeter   , coulombperinch ,abcoulombpermeter   ,abcoulombpercentimeter    , abcoulombperinch  ;
    private String conversionFrom;
    private double edtValue;


    public LinearChargeDensityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateLinearChargeDensityConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Coulomb/meter - C/m":

                coulombpermeter=(edtValue)*1;
                coulombpercentimeter=(edtValue)*0.01;
                coulombperinch=(edtValue)*0.0254;
                abcoulombpermeter=(edtValue)*0.1;
                abcoulombpercentimeter=(edtValue)*0.001;
                abcoulombperinch=(edtValue)*0.00254;


                break;
            case "Coulomb/centimeter - C/cm":

                coulombpermeter=(edtValue)*100;
                coulombpercentimeter=(edtValue)*1;
                coulombperinch=(edtValue)*2.54;
                abcoulombpermeter=(edtValue)*10;
                abcoulombpercentimeter=(edtValue)*0.1;
                abcoulombperinch=(edtValue)*0.254;


                break;
            case "Coulomb/inch - C/in":

                coulombpermeter=(edtValue)*39.37007874;
                coulombpercentimeter=(edtValue)*0.3937007874;
                coulombperinch=(edtValue)*1;
                abcoulombpermeter=(edtValue)*3.937007874;
                abcoulombpercentimeter=(edtValue)*0.0393700787;
                abcoulombperinch=(edtValue)*0.1;


                break;

            case "Abcoulomb/meter - abC/m":

                coulombpermeter=(edtValue)*10;
                coulombpercentimeter=(edtValue)*0.1;
                coulombperinch=(edtValue)*0.254;
                abcoulombpermeter=(edtValue)*1;
                abcoulombpercentimeter=(edtValue)*0.01;
                abcoulombperinch=(edtValue)*0.0254;


                break;

            case "Abcoulomb/centimeter - abC/cm":

                coulombpermeter=(edtValue)*1000;
                coulombpercentimeter=(edtValue)*10;
                coulombperinch=(edtValue)*25.4;
                abcoulombpermeter=(edtValue)*100;
                abcoulombpercentimeter=(edtValue)*1;
                abcoulombperinch=(edtValue)*2.54;


                break;

            case "Abcoulomb/inch - abC/in":

                coulombpermeter=(edtValue)*393.7007874;
                coulombpercentimeter=(edtValue)*3.937007874;
                coulombperinch=(edtValue)*10;
                abcoulombpermeter=(edtValue)*39.37007874;
                abcoulombpercentimeter=(edtValue)*0.3937007874;
                abcoulombperinch=(edtValue)*1;


                break;


        }

        results. setCoulombpermeter( coulombpermeter);

        results. setCoulombpercentimeter( coulombpercentimeter) ;

        results. setCoulombperinch( coulombperinch) ;

        results. setAbcoulombpermeter( abcoulombpermeter);

        results. setAbcoulombpercentimeter( abcoulombpercentimeter);

        results. setAbcoulombperinch( abcoulombperinch) ;


        converterArray.add(results);
        return converterArray;

    }

    public class ConversionResults{

        private double  coulombpermeter   , coulombpercentimeter   , coulombperinch ,abcoulombpermeter   ,abcoulombpercentimeter    , abcoulombperinch  ;

        public double getCoulombpermeter() {
            return coulombpermeter;
        }

        public void setCoulombpermeter(double coulombpermeter) {
            this.coulombpermeter = coulombpermeter;
        }

        public double getCoulombpercentimeter() {
            return coulombpercentimeter;
        }

        public void setCoulombpercentimeter(double coulombpercentimeter) {
            this.coulombpercentimeter = coulombpercentimeter;
        }

        public double getCoulombperinch() {
            return coulombperinch;
        }

        public void setCoulombperinch(double coulombperinch) {
            this.coulombperinch = coulombperinch;
        }

        public double getAbcoulombpermeter() {
            return abcoulombpermeter;
        }

        public void setAbcoulombpermeter(double abcoulombpermeter) {
            this.abcoulombpermeter = abcoulombpermeter;
        }

        public double getAbcoulombpercentimeter() {
            return abcoulombpercentimeter;
        }

        public void setAbcoulombpercentimeter(double abcoulombpercentimeter) {
            this.abcoulombpercentimeter = abcoulombpercentimeter;
        }

        public double getAbcoulombperinch() {
            return abcoulombperinch;
        }

        public void setAbcoulombperinch(double abcoulombperinch) {
            this.abcoulombperinch = abcoulombperinch;
        }


    }


/*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinearChargeDensityConverter iA = new LinearChargeDensityConverter("coulombpermeter",1);

        ArrayList<LinearChargeDensityConverter.ConversionResults> results = iA.calculateLinearChargeDensityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            LinearChargeDensityConverter.ConversionResults item  =  results.get(i);

            System.out.println("\n coulombpermeter - " +new DecimalFormat("##.################").format( item.getCoulombpermeter())
                    +"\n coulombpercentimeter- " +new DecimalFormat("##.################").format( item.getCoulombpercentimeter())
                    +"\n coulombperinch - " +new DecimalFormat("##.################").format( item.getCoulombperinch())+
                    "\n abcoulombpermeter - " +new DecimalFormat("##.################").format( item.getAbcoulombpermeter())

                    +"\n abcoulombpercentimeter- " +new DecimalFormat("##.################").format( item.getAbcoulombpercentimeter())
                    +"\n abcoulombperinch - " +new DecimalFormat("##.################").format( item.getAbcoulombperinch())



            );



        }
    }*/
}
