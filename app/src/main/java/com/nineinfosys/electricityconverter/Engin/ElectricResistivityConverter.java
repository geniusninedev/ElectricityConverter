package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class ElectricResistivityConverter {

    private double ohmmeter,  ohmcentimeter, ohminch,microhmcentimeter,microhminch, abohmcentimeter,statohmcentimeter,circularmilohmperfoot ;
    private String conversionFrom;
    private double edtValue;


    public ElectricResistivityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateElectricResistivityConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Ohm meter - Ωm":

                ohmmeter=(edtValue)*1;
                ohmcentimeter=(edtValue)*100;
                ohminch=(edtValue)*39.37007874;
                microhmcentimeter=(edtValue)*100000000;
                microhminch=(edtValue)*39370078.74;
                abohmcentimeter=(edtValue)*100000000000.0;
                statohmcentimeter=(edtValue)*1.112653456E-10;
                circularmilohmperfoot=(edtValue)*601530493.4;

                break;

            case "Ohm centimeter - Ωcm" :

                ohmmeter=(edtValue)*0.01;
                ohmcentimeter=(edtValue)*1;
                ohminch=(edtValue)*0.3937007874;
                microhmcentimeter=(edtValue)*1000000;
                microhminch=(edtValue)*393700.7874;
                abohmcentimeter=(edtValue)*1000000000.0;
                statohmcentimeter=(edtValue)*1.112653455E-12;
                circularmilohmperfoot=(edtValue)*6015304.934;

                break;


            case "Ohm inch - Ωin" :

                ohmmeter=(edtValue)*0.0254;
                ohmcentimeter=(edtValue)*2.54;
                ohminch=(edtValue)*1;
                microhmcentimeter=(edtValue)*2540000;
                microhminch=(edtValue)*1000000;
                abohmcentimeter=(edtValue)*2540000000.0;
                statohmcentimeter=(edtValue)*2.826139778E-12;
                circularmilohmperfoot=(edtValue)*15278874.532;

                break;



            case "Microhm centimeter - µΩcm" :

                ohmmeter=(edtValue)*1.E-8;
                ohmcentimeter=(edtValue)*0.000001;
                ohminch=(edtValue)*3.937007874E-7;
                microhmcentimeter=(edtValue)*1;
                microhminch=(edtValue)*0.3937007874;
                abohmcentimeter=(edtValue)*1000;
                statohmcentimeter=(edtValue)*1.112653456E-18;
                circularmilohmperfoot=(edtValue)*6.015304934;

                break;


            case "Microhm inch -  µΩin" :

                ohmmeter=(edtValue)*2.54E-8;
                ohmcentimeter=(edtValue)*0.00000254;
                ohminch=(edtValue)*0.000001;
                microhmcentimeter=(edtValue)*2.54;
                microhminch=(edtValue)*1;
                abohmcentimeter=(edtValue)*2540;
                statohmcentimeter=(edtValue)*2.826139778E-18;
                circularmilohmperfoot=(edtValue)*15.278874532;

                break;


            case "Abohm centimeter - abΩcm" :

                ohmmeter=(edtValue)*1.E-11;
                ohmcentimeter=(edtValue)*1.E-9;
                ohminch=(edtValue)*3.937007874E-10;
                microhmcentimeter=(edtValue)*0.001;
                microhminch=(edtValue)*0.0003937008;
                abohmcentimeter=(edtValue)*1;
                statohmcentimeter=(edtValue)*1.112653456E-21;
                circularmilohmperfoot=(edtValue)*0.0060153049;

                break;

            case "Statohm centimeter - stΩcm" :

                ohmmeter=(edtValue)*8987524324.0;
                ohmcentimeter=(edtValue)*898752432402.0;
                ohminch=(edtValue)*353839540314.0;
                microhmcentimeter=(edtValue)*898752432401558100.0;
                microhminch=(edtValue)*353839540314158700.0;
                abohmcentimeter=(edtValue)*898752432401558100000.0;
                statohmcentimeter=(edtValue)*1;
                circularmilohmperfoot=(edtValue)*5406269941069595000.0;

                break;

            case "Circular mil ohm/foot - circular mil Ω/ft" :

                ohmmeter=(edtValue)*1.662426113E-9;
                ohmcentimeter=(edtValue)*1.662426113E-7;
                ohminch=(edtValue)*6.544984696E-8;
                microhmcentimeter=(edtValue)*0.1662426113;
                microhminch=(edtValue)*0.065449847;
                abohmcentimeter=(edtValue)*166.2426113;
                statohmcentimeter=(edtValue)*1.849704159E-19;
                circularmilohmperfoot=(edtValue)*1;

                break;




        }


        results. setOhmmeter( ohmmeter);

        results. setOhmcentimeter( ohmcentimeter);
        results. setOhminch( ohminch) ;

        results. setMicrohmcentimeter( microhmcentimeter) ;

        results. setMicrohminch( microhminch);

        results. setAbohmcentimeter( abohmcentimeter);
        results. setStatohmcentimeter( statohmcentimeter) ;

        results. setCircularmilohmperfoot( circularmilohmperfoot);
        converterArray.add(results);
        return converterArray;

    }


    public class ConversionResults{

        private double ohmmeter,  ohmcentimeter, ohminch,microhmcentimeter,microhminch, abohmcentimeter,statohmcentimeter,circularmilohmperfoot ;

        public double getOhmmeter() {
            return ohmmeter;
        }

        public void setOhmmeter(double ohmmeter) {
            this.ohmmeter = ohmmeter;
        }

        public double getOhmcentimeter() {
            return ohmcentimeter;
        }

        public void setOhmcentimeter(double ohmcentimeter) {
            this.ohmcentimeter = ohmcentimeter;
        }

        public double getOhminch() {
            return ohminch;
        }

        public void setOhminch(double ohminch) {
            this.ohminch = ohminch;
        }

        public double getMicrohmcentimeter() {
            return microhmcentimeter;
        }

        public void setMicrohmcentimeter(double microhmcentimeter) {
            this.microhmcentimeter = microhmcentimeter;
        }

        public double getMicrohminch() {
            return microhminch;
        }

        public void setMicrohminch(double microhminch) {
            this.microhminch = microhminch;
        }

        public double getAbohmcentimeter() {
            return abohmcentimeter;
        }

        public void setAbohmcentimeter(double abohmcentimeter) {
            this.abohmcentimeter = abohmcentimeter;
        }

        public double getStatohmcentimeter() {
            return statohmcentimeter;
        }

        public void setStatohmcentimeter(double statohmcentimeter) {
            this.statohmcentimeter = statohmcentimeter;
        }

        public double getCircularmilohmperfoot() {
            return circularmilohmperfoot;
        }

        public void setCircularmilohmperfoot(double circularmilohmperfoot) {
            this.circularmilohmperfoot = circularmilohmperfoot;
        }



    }


   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        ElectricResistivity iA = new ElectricResistivity("ohmmeter",1);

        ArrayList<ElectricResistivity.ConversionResults> results = iA.calculateElectricResistivityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            ElectricResistivity.ConversionResults item  =  results.get(i);

            System.out.println("\n ohmmeter - " +new DecimalFormat("##.################").format( item.getOhmmeter())
                    +"\n ohmcentimeter- " +new DecimalFormat("##.################").format( item.getOhmcentimeter())
                    +"\n ohminch - " +new DecimalFormat("##.################").format( item.getOhminch())+
                    "\n microhmcentimeter - " +new DecimalFormat("##.################").format( item.getMicrohmcentimeter())

                    +"\n microhminch- " +new DecimalFormat("##.################").format( item.getMicrohminch())
                    +"\n abohmcentimeter - " +new DecimalFormat("##.################").format( item.getAbohmcentimeter())

                    +"\n statohmcentimeter - " +new DecimalFormat("##.################").format( item.getStatohmcentimeter())+
                    "\n circularmilohmperfoot - " +new DecimalFormat("##.################").format( item.getCircularmilohmperfoot())




            );



        }
    }*/

}
