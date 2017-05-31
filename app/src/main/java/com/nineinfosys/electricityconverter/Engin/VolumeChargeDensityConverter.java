package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class VolumeChargeDensityConverter {

    private double  coulombcubicmeter    ,  coulombpercubiccentimeter   , coulombpercubicinch ,abcoulombpercubicmeter   ,abcoulombpercubiccentimeter    , abcoulombpercubicinch  ;
    private String conversionFrom;
    private double edtValue;


    public VolumeChargeDensityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateVolumeChargeDensityConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Coulomb/cubic meter - C/m³":

                coulombcubicmeter=(edtValue)*1;
                coulombpercubiccentimeter=(edtValue)*0.000001;
                coulombpercubicinch=(edtValue)*0.0000163871;
                abcoulombpercubicmeter=(edtValue)*0.1;
                abcoulombpercubiccentimeter=(edtValue)*1.E-7;
                abcoulombpercubicinch=(edtValue)*0.0000016387;


                break;

            case "Coulomb/cubic centimeter - C/cm³":

                coulombcubicmeter=(edtValue)*1000000;
                coulombpercubiccentimeter=(edtValue)*1;
                coulombpercubicinch=(edtValue)*16.387064;
                abcoulombpercubicmeter=(edtValue)*100000;
                abcoulombpercubiccentimeter=(edtValue)*0.1;
                abcoulombpercubicinch=(edtValue)*1.6387064;


                break;



            case "Coulomb/cubic inch - C/in³":

                coulombcubicmeter=(edtValue)*61023.744095;
                coulombpercubiccentimeter=(edtValue)*0.0610237441;
                coulombpercubicinch=(edtValue)*1;
                abcoulombpercubicmeter=(edtValue)*6102.3744095;
                abcoulombpercubiccentimeter=(edtValue)*0.0061023744;
                abcoulombpercubicinch=(edtValue)*0.1;


                break;


            case "Abcoulomb/cubic meter - abC/m³":

                coulombcubicmeter=(edtValue)*10;
                coulombpercubiccentimeter=(edtValue)*0.00001;
                coulombpercubicinch=(edtValue)*0.0001638706;
                abcoulombpercubicmeter=(edtValue)*1;
                abcoulombpercubiccentimeter=(edtValue)*0.000001;
                abcoulombpercubicinch=(edtValue)*0.0000163871;


                break;


            case "Abcoulomb/cubic centimeter - abC/cm³":

                coulombcubicmeter=(edtValue)*10000000;
                coulombpercubiccentimeter=(edtValue)*10;
                coulombpercubicinch=(edtValue)*163.87064;
                abcoulombpercubicmeter=(edtValue)*1000000;
                abcoulombpercubiccentimeter=(edtValue)*1;
                abcoulombpercubicinch=(edtValue)*16.387064;


                break;

            case "Abcoulomb/cubic inch - abC/in³":

                coulombcubicmeter=(edtValue)*610237.44095;
                coulombpercubiccentimeter=(edtValue)*0.6102374409;
                coulombpercubicinch=(edtValue)*0.6102374409;
                abcoulombpercubicmeter=(edtValue)*61023.744095;
                abcoulombpercubiccentimeter=(edtValue)*0.0610237441;
                abcoulombpercubicinch=(edtValue)*1;


                break;

        }

        results. setCoulombcubicmeter( coulombcubicmeter) ;

        results. setCoulombpercubiccentimeter( coulombpercubiccentimeter);



        results. setCoulombpercubicinch( coulombpercubicinch);

        results. setAbcoulombpercubicmeter( abcoulombpercubicmeter) ;

        results. setAbcoulombpercubiccentimeter( abcoulombpercubiccentimeter) ;

        results. setAbcoulombpercubicinch( abcoulombpercubicinch) ;



        converterArray.add(results);
        return converterArray;

    }

    public class ConversionResults{
        private double  coulombcubicmeter    ,  coulombpercubiccentimeter   , coulombpercubicinch ,abcoulombpercubicmeter   ,abcoulombpercubiccentimeter    , abcoulombpercubicinch  ;

        public double getCoulombcubicmeter() {
            return coulombcubicmeter;
        }

        public void setCoulombcubicmeter(double coulombcubicmeter) {
            this.coulombcubicmeter = coulombcubicmeter;
        }

        public double getCoulombpercubiccentimeter() {
            return coulombpercubiccentimeter;
        }

        public void setCoulombpercubiccentimeter(double coulombpercubiccentimeter) {
            this.coulombpercubiccentimeter = coulombpercubiccentimeter;
        }

        public double getCoulombpercubicinch() {
            return coulombpercubicinch;
        }

        public void setCoulombpercubicinch(double coulombpercubicinch) {
            this.coulombpercubicinch = coulombpercubicinch;
        }

        public double getAbcoulombpercubicmeter() {
            return abcoulombpercubicmeter;
        }

        public void setAbcoulombpercubicmeter(double abcoulombpercubicmeter) {
            this.abcoulombpercubicmeter = abcoulombpercubicmeter;
        }

        public double getAbcoulombpercubiccentimeter() {
            return abcoulombpercubiccentimeter;
        }

        public void setAbcoulombpercubiccentimeter(double abcoulombpercubiccentimeter) {
            this.abcoulombpercubiccentimeter = abcoulombpercubiccentimeter;
        }

        public double getAbcoulombpercubicinch() {
            return abcoulombpercubicinch;
        }

        public void setAbcoulombpercubicinch(double abcoulombpercubicinch) {
            this.abcoulombpercubicinch = abcoulombpercubicinch;
        }




    }


   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        VolumeChargeDensity iA = new VolumeChargeDensity("coulombcubicmeter",1);

        ArrayList<VolumeChargeDensity.ConversionResults> results = iA.calculateVolumeChargeDensityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            VolumeChargeDensity.ConversionResults item  =  results.get(i);

            System.out.println("\n coulombcubicmeter - " +new DecimalFormat("##.################").format( item.getCoulombcubicmeter())
                    +"\n coulombpercubiccentimeter- " +new DecimalFormat("##.################").format( item.getCoulombpercubiccentimeter())
                    +"\n coulombpercubicinch - " +new DecimalFormat("##.################").format( item.getCoulombpercubicinch())+
                    "\n abcoulombpercubicmeter - " +new DecimalFormat("##.################").format( item.getAbcoulombpercubicmeter())

                    +"\n abcoulombpercubiccentimeter- " +new DecimalFormat("##.################").format( item.getAbcoulombpercubiccentimeter())
                    +"\n abcoulombpercubicinch - " +new DecimalFormat("##.################").format( item.getAbcoulombpercubicinch())



            );



        }
    }
*/
}
