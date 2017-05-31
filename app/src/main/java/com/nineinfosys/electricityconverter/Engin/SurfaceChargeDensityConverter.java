package com.nineinfosys.electricityconverter.Engin;
import java.util.ArrayList;


public class SurfaceChargeDensityConverter {

    private double  coulombsquaremeter    ,  coulombpersquarecentimeter   , coulombpersquareinch ,abcoulombpersquaremeter   ,abcoulombpersquarecentimeter    , abcoulombpersquareinch  ;
    private String conversionFrom;
    private double edtValue;


    public SurfaceChargeDensityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateSurfaceChargeDensityConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Coulomb/square meter - C/m²":

                coulombsquaremeter=(edtValue)*1;
                coulombpersquarecentimeter=(edtValue)*0.0001;
                coulombpersquareinch=(edtValue)*0.00064516;
                abcoulombpersquaremeter=(edtValue)*0.1;
                abcoulombpersquarecentimeter=(edtValue)*0.00001;
                abcoulombpersquareinch=(edtValue)*0.000064516;


                break;


            case "Coulomb/square centimeter - C/cm²":

                coulombsquaremeter=(edtValue)*10000;
                coulombpersquarecentimeter=(edtValue)*1;
                coulombpersquareinch=(edtValue)*6.4516;
                abcoulombpersquaremeter=(edtValue)*1000;
                abcoulombpersquarecentimeter=(edtValue)*0.1;
                abcoulombpersquareinch=(edtValue)*0.64516;


                break;


            case "Coulomb/square inch - C/in²":

                coulombsquaremeter=(edtValue)*1550.0031;
                coulombpersquarecentimeter=(edtValue)*0.15500031;
                coulombpersquareinch=(edtValue)*1;
                abcoulombpersquaremeter=(edtValue)*155.00031;
                abcoulombpersquarecentimeter=(edtValue)*0.015500031;
                abcoulombpersquareinch=(edtValue)*0.1;


                break;



            case "Abcoulomb/square meter - abC/m²":

                coulombsquaremeter=(edtValue)*10;
                coulombpersquarecentimeter=(edtValue)*0.001;
                coulombpersquareinch=(edtValue)*0.0064516;
                abcoulombpersquaremeter=(edtValue)*1;
                abcoulombpersquarecentimeter=(edtValue)*0.0001;
                abcoulombpersquareinch=(edtValue)*0.00064516;


                break;


            case "Abcoulomb/square centimeter - abC/cm²":

                coulombsquaremeter=(edtValue)*100000;
                coulombpersquarecentimeter=(edtValue)*10;
                coulombpersquareinch=(edtValue)*64.516;
                abcoulombpersquaremeter=(edtValue)*10000;
                abcoulombpersquarecentimeter=(edtValue)*1;
                abcoulombpersquareinch=(edtValue)*6.4516;


                break;

            case "Abcoulomb/square inch - abC/in²":

                coulombsquaremeter=(edtValue)*15500.031;
                coulombpersquarecentimeter=(edtValue)*1.5500031;
                coulombpersquareinch=(edtValue)*10;
                abcoulombpersquaremeter=(edtValue)*1550.0031;
                abcoulombpersquarecentimeter=(edtValue)*0.15500031;
                abcoulombpersquareinch=(edtValue)*1;


        }


        results. setCoulombsquaremeter( coulombsquaremeter) ;

        results. setCoulombpersquarecentimeter( coulombpersquarecentimeter);



        results. setCoulombpersquareinch( coulombpersquareinch);

        results. setAbcoulombpersquaremeter( abcoulombpersquaremeter) ;

        results. setAbcoulombpersquarecentimeter( abcoulombpersquarecentimeter) ;

        results. setAbcoulombpersquareinch( abcoulombpersquareinch) ;


        converterArray.add(results);
        return converterArray;

    }

    public class ConversionResults{

        private double  coulombsquaremeter    ,  coulombpersquarecentimeter   , coulombpersquareinch ,abcoulombpersquaremeter   ,abcoulombpersquarecentimeter    , abcoulombpersquareinch  ;

        public double getCoulombsquaremeter() {
            return coulombsquaremeter;
        }

        public void setCoulombsquaremeter(double coulombsquaremeter) {
            this.coulombsquaremeter = coulombsquaremeter;
        }

        public double getCoulombpersquarecentimeter() {
            return coulombpersquarecentimeter;
        }

        public void setCoulombpersquarecentimeter(double coulombpersquarecentimeter) {
            this.coulombpersquarecentimeter = coulombpersquarecentimeter;
        }

        public double getCoulombpersquareinch() {
            return coulombpersquareinch;
        }

        public void setCoulombpersquareinch(double coulombpersquareinch) {
            this.coulombpersquareinch = coulombpersquareinch;
        }

        public double getAbcoulombpersquaremeter() {
            return abcoulombpersquaremeter;
        }

        public void setAbcoulombpersquaremeter(double abcoulombpersquaremeter) {
            this.abcoulombpersquaremeter = abcoulombpersquaremeter;
        }

        public double getAbcoulombpersquarecentimeter() {
            return abcoulombpersquarecentimeter;
        }

        public void setAbcoulombpersquarecentimeter(double abcoulombpersquarecentimeter) {
            this.abcoulombpersquarecentimeter = abcoulombpersquarecentimeter;
        }

        public double getAbcoulombpersquareinch() {
            return abcoulombpersquareinch;
        }

        public void setAbcoulombpersquareinch(double abcoulombpersquareinch) {
            this.abcoulombpersquareinch = abcoulombpersquareinch;
        }



    }


    /*public static void main(String[] args) {
        // TODO Auto-generated method stub
        SurfaceChargeDensity iA = new SurfaceChargeDensity("coulombsquaremeter",1);

        ArrayList<SurfaceChargeDensity.ConversionResults> results = iA.calculateSurfaceChargeDensityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            SurfaceChargeDensity.ConversionResults item  =  results.get(i);

            System.out.println("\n coulombsquaremeter - " +new DecimalFormat("##.################").format( item.getCoulombsquaremeter())
                    +"\n coulombpersquarecentimeter- " +new DecimalFormat("##.################").format( item.getCoulombpersquarecentimeter())
                    +"\n coulombpersquareinch - " +new DecimalFormat("##.################").format( item.getCoulombpersquareinch())+
                    "\n abcoulombpersquaremeter - " +new DecimalFormat("##.################").format( item.getAbcoulombpersquaremeter())

                    +"\n abcoulombpersquarecentimeter- " +new DecimalFormat("##.################").format( item.getAbcoulombpersquarecentimeter())
                    +"\n abcoulombpersquareinch - " +new DecimalFormat("##.################").format( item.getAbcoulombpersquareinch())



            );*/





}
