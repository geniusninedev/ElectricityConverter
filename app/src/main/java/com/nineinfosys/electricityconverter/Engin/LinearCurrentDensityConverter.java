package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class LinearCurrentDensityConverter {

    private double  amperepermeter    , amperepercentimeter   , ampereperinch  ,abamperepermeter   ,abamperepercentimeter    , abampereperinch, oersted ,gilbertpercentimeter  ;
    private String conversionFrom;
    private double edtValue;


    public LinearCurrentDensityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateLinearCurrentDensityConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Ampere/meter - A/m":

                amperepermeter=(edtValue)*1;
                amperepercentimeter=(edtValue)*0.01;
                ampereperinch=(edtValue)*0.0254;
                abamperepermeter=(edtValue)*0.1;
                abamperepercentimeter=(edtValue)*0.001;
                abampereperinch=(edtValue)*0.00254;
                oersted=(edtValue)*0.0125663706;
                gilbertpercentimeter=(edtValue)*0.0125663706;




                break;


            case "Ampere/centimeter - A/cm":

                amperepermeter=(edtValue)*100;
                amperepercentimeter=(edtValue)*1;
                ampereperinch=(edtValue)*2.54;
                abamperepermeter=(edtValue)*10;
                abamperepercentimeter=(edtValue)*0.1;
                abampereperinch=(edtValue)*0.254;
                oersted=(edtValue)*1.256637062;
                gilbertpercentimeter=(edtValue)*1.256637062;




                break;


            case "Ampere/inch - A/in":

                amperepermeter=(edtValue)*39.37007874;
                amperepercentimeter=(edtValue)*0.3937007874;
                ampereperinch=(edtValue)*1;
                abamperepermeter=(edtValue)*3.937007874;
                abamperepercentimeter=(edtValue)*0.0393700787;
                abampereperinch=(edtValue)*0.1;
                oersted=(edtValue)*0.4947390008;
                gilbertpercentimeter=(edtValue)*0.4947390008;




                break;


            case "Abampere/meter - abA/m":

                amperepermeter=(edtValue)*10;
                amperepercentimeter=(edtValue)*0.1;
                ampereperinch=(edtValue)*0.254;
                abamperepermeter=(edtValue)*1;
                abamperepercentimeter=(edtValue)*0.01;
                abampereperinch=(edtValue)*0.0254;
                oersted=(edtValue)*0.1256637062;
                gilbertpercentimeter=(edtValue)*0.1256637062;




                break;


            case "Abampere/centimeter - abA/cm":

                amperepermeter=(edtValue)*1000;
                amperepercentimeter=(edtValue)*10;
                ampereperinch=(edtValue)*25.4;
                abamperepermeter=(edtValue)*100;
                abamperepercentimeter=(edtValue)*1;
                abampereperinch=(edtValue)*2.54;
                oersted=(edtValue)*12.56637062;
                gilbertpercentimeter=(edtValue)*12.56637062;




                break;


            case "Abampere/inch - abA/in":

                amperepermeter=(edtValue)*393.7007874;
                amperepercentimeter=(edtValue)*3.937007874;
                ampereperinch=(edtValue)*10;
                abamperepermeter=(edtValue)*39.37007874;
                abamperepercentimeter=(edtValue)*0.3937007874;
                abampereperinch=(edtValue)*1;
                oersted=(edtValue)*4.9473900079;
                gilbertpercentimeter=(edtValue)*4.9473900079;




                break;

            case "Oersted - Oe":

                amperepermeter=(edtValue)*79.57747151;
                amperepercentimeter=(edtValue)*0.7957747151;
                ampereperinch=(edtValue)*2.0212677764;
                abamperepermeter=(edtValue)*7.957747151;
                abamperepercentimeter=(edtValue)*0.0795774715;
                abampereperinch=(edtValue)*0.2021267776;
                oersted=(edtValue)*1;
                gilbertpercentimeter=(edtValue)*1;




                break;

            case "Gilbert/centimeter - Gi/cm":

                amperepermeter=(edtValue)*79.57747151;
                amperepercentimeter=(edtValue)*0.7957747151;
                ampereperinch=(edtValue)*2.0212677764;
                abamperepermeter=(edtValue)*7.957747151;
                abamperepercentimeter=(edtValue)*0.0795774715;
                abampereperinch=(edtValue)*0.2021267776;
                oersted=(edtValue)*1;
                gilbertpercentimeter=(edtValue)*1;






        }


        results. setAmperepermeter( amperepermeter) ;

        results. setAmperepercentimeter( amperepercentimeter);
        results. setAmpereperinch( ampereperinch) ;

        results. setAbamperepermeter( abamperepermeter) ;
        results. setAbamperepercentimeter( abamperepercentimeter) ;
        results. setAbampereperinch( abampereperinch) ;
        results. setOersted( oersted);

        results. setGilbertpercentimeter( gilbertpercentimeter) ;


        converterArray.add(results);
        return converterArray;

    }


    public class ConversionResults{

        private double  amperepermeter    , amperepercentimeter   , ampereperinch  ,abamperepermeter   ,abamperepercentimeter    , abampereperinch, oersted ,gilbertpercentimeter  ;

        public double getAmperepermeter() {
            return amperepermeter;
        }

        public void setAmperepermeter(double amperepermeter) {
            this.amperepermeter = amperepermeter;
        }

        public double getAmperepercentimeter() {
            return amperepercentimeter;
        }

        public void setAmperepercentimeter(double amperepercentimeter) {
            this.amperepercentimeter = amperepercentimeter;
        }

        public double getAmpereperinch() {
            return ampereperinch;
        }

        public void setAmpereperinch(double ampereperinch) {
            this.ampereperinch = ampereperinch;
        }

        public double getAbamperepermeter() {
            return abamperepermeter;
        }

        public void setAbamperepermeter(double abamperepermeter) {
            this.abamperepermeter = abamperepermeter;
        }

        public double getAbamperepercentimeter() {
            return abamperepercentimeter;
        }

        public void setAbamperepercentimeter(double abamperepercentimeter) {
            this.abamperepercentimeter = abamperepercentimeter;
        }

        public double getAbampereperinch() {
            return abampereperinch;
        }

        public void setAbampereperinch(double abampereperinch) {
            this.abampereperinch = abampereperinch;
        }

        public double getOersted() {
            return oersted;
        }

        public void setOersted(double oersted) {
            this.oersted = oersted;
        }

        public double getGilbertpercentimeter() {
            return gilbertpercentimeter;
        }

        public void setGilbertpercentimeter(double gilbertpercentimeter) {
            this.gilbertpercentimeter = gilbertpercentimeter;
        }


    }


 /*   public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinearCurrentDensity iA = new LinearCurrentDensity("amperepermeter",1);

        ArrayList<LinearCurrentDensity.ConversionResults> results = iA.calculateLinearCurrentDensityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            LinearCurrentDensity.ConversionResults item  =  results.get(i);

            System.out.println("\n amperepermeter - " +new DecimalFormat("##.################").format( item.getAmperepermeter())
                    +"\n amperepercentimeter- " +new DecimalFormat("##.################").format( item.getAmperepercentimeter())
                    +"\n ampereperinch - " +new DecimalFormat("##.################").format( item.getAmpereperinch())+
                    "\n abamperepermeter - " +new DecimalFormat("##.################").format( item.getAbamperepermeter())

                    +"\n abamperepercentimeter- " +new DecimalFormat("##.################").format( item.getAbamperepercentimeter())
                    +"\n abampereperinch - " +new DecimalFormat("##.################").format( item.getAbampereperinch())

                    +"\n oersted- " +new DecimalFormat("##.################").format( item.getOersted())
                    +"\n gilbertpercentimeter - " +new DecimalFormat("##.################").format( item.getGilbertpercentimeter())


            );



        }
    }
*/
}
