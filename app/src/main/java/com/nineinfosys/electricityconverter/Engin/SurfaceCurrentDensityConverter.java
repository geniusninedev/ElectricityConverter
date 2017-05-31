package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class SurfaceCurrentDensityConverter {


    private double amperesquaremeter    ,  amperepersquarecentimeter   , amperepersquareinch ,amperepersquaremil    ,amperepercicularmil    , abamperepersquarecentimeter   ;
    private String conversionFrom;
    private double edtValue;


    public SurfaceCurrentDensityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateSurfaceCurrentDensityConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Ampere/square meter - A/m²":

                amperesquaremeter=(edtValue)*1;
                amperepersquarecentimeter=(edtValue)*0.0001;
                amperepersquareinch=(edtValue)*0.00064516;
                amperepersquaremil=(edtValue)*6.4516E-10;
                amperepercicularmil=(edtValue)*5.067074792E-10;
                abamperepersquarecentimeter=(edtValue)*0.00001;


                break;


            case "Ampere/square centimeter - A/cm²":

                amperesquaremeter=(edtValue)*10000;
                amperepersquarecentimeter=(edtValue)*1;
                amperepersquareinch=(edtValue)*6.4516;
                amperepersquaremil=(edtValue)*0.0000064516;
                amperepercicularmil=(edtValue)*0.0000050671;
                abamperepersquarecentimeter=(edtValue)*0.1;

                break;

            case "Ampere/square inch - A/in²" :

                amperesquaremeter=(edtValue)*1550.0031;
                amperepersquarecentimeter=(edtValue)*0.15500031;
                amperepersquareinch=(edtValue)*1;
                amperepersquaremil=(edtValue)*0.000001;
                amperepercicularmil=(edtValue)*7.853981635E-7;
                abamperepersquarecentimeter=(edtValue)*0.015500031;

                break;


            case "Ampere/square mil - A/mil²":

                amperesquaremeter=(edtValue)*1550003100;
                amperepersquarecentimeter=(edtValue)*155000.31;
                amperepersquareinch=(edtValue)*1000000;
                amperepersquaremil=(edtValue)*1;
                amperepercicularmil=(edtValue)*0.7853981636;
                abamperepersquarecentimeter=(edtValue)*15500.031;


                break;

            case "Ampere/cicular mil - A/mil":

                amperesquaremeter=(edtValue)*1973525241;
                amperepersquarecentimeter=(edtValue)*197352.5241;
                amperepersquareinch=(edtValue)*1273239.5445;
                amperepersquaremil=(edtValue)*1.2732395445;
                amperepercicularmil=(edtValue)*1;
                abamperepersquarecentimeter=(edtValue)*19735.25241;

                break;

            case "Abampere/square centimeter - abA/cm²":

                amperesquaremeter=(edtValue)*100000;
                amperepersquarecentimeter=(edtValue)*10;
                amperepersquareinch=(edtValue)*64.516;
                amperepersquaremil=(edtValue)*0.000064516;
                amperepercicularmil=(edtValue)*0.0000506707;
                abamperepersquarecentimeter=(edtValue)*1;



        }



        results.  setAmperesquaremeter( amperesquaremeter);

        results.  setAmperepersquarecentimeter( amperepersquarecentimeter) ;

        results.  setAmperepersquareinch( amperepersquareinch) ;

        results.  setAmperepersquaremil( amperepersquaremil) ;


        results. setAmperepercicularmil( amperepercicularmil) ;

        results. setAbamperepersquarecentimeter( abamperepersquarecentimeter);


        converterArray.add(results);
        return converterArray;

    }


    public class ConversionResults{

        private double amperesquaremeter    ,  amperepersquarecentimeter   , amperepersquareinch ,amperepersquaremil    ,amperepercicularmil    , abamperepersquarecentimeter   ;

        public double getAmperesquaremeter() {
            return amperesquaremeter;
        }

        public void setAmperesquaremeter(double amperesquaremeter) {
            this.amperesquaremeter = amperesquaremeter;
        }

        public double getAmperepersquarecentimeter() {
            return amperepersquarecentimeter;
        }

        public void setAmperepersquarecentimeter(double amperepersquarecentimeter) {
            this.amperepersquarecentimeter = amperepersquarecentimeter;
        }

        public double getAmperepersquareinch() {
            return amperepersquareinch;
        }

        public void setAmperepersquareinch(double amperepersquareinch) {
            this.amperepersquareinch = amperepersquareinch;
        }

        public double getAmperepersquaremil() {
            return amperepersquaremil;
        }

        public void setAmperepersquaremil(double amperepersquaremil) {
            this.amperepersquaremil = amperepersquaremil;
        }

        public double getAmperepercicularmil() {
            return amperepercicularmil;
        }

        public void setAmperepercicularmil(double amperepercicularmil) {
            this.amperepercicularmil = amperepercicularmil;
        }

        public double getAbamperepersquarecentimeter() {
            return abamperepersquarecentimeter;
        }

        public void setAbamperepersquarecentimeter(double abamperepersquarecentimeter) {
            this.abamperepersquarecentimeter = abamperepersquarecentimeter;
        }




    }


/*

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SurfaceCurrentDensity iA = new SurfaceCurrentDensity("amperesquaremeter",1);

        ArrayList<SurfaceCurrentDensity.ConversionResults> results = iA.calculateSurfaceCurrentDensityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            SurfaceCurrentDensity.ConversionResults item  =  results.get(i);

            System.out.println("\n amperesquaremeter - " +new DecimalFormat("##.################").format( item.getAmperesquaremeter())
                    +"\n amperepersquarecentimeter- " +new DecimalFormat("##.################").format( item.getAmperepersquarecentimeter())
                    +"\n amperepersquareinch - " +new DecimalFormat("##.################").format( item.getAmperepersquareinch())+
                    "\n amperepersquareinch - " +new DecimalFormat("##.################").format( item.getAmperepersquareinch())

                    +"\n amperepercicularmil- " +new DecimalFormat("##.################").format( item.getAmperepercicularmil())
                    +"\n abamperepersquarecentimeter - " +new DecimalFormat("##.################").format( item.getAbamperepersquarecentimeter())



            );



        }
    }
*/

}
