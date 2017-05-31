package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class ConductivityConverter {


    private double siemenspermeter, picosiemenspermeter, mhopermeter, mhopercentimeter, abmhopermeter, abmhopercentimeter, statmhopermeter, statmhopercentimeter;
    private String conversionFrom;
    private double edtValue;


    public ConductivityConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateElectricConductivityConversion() {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results = new ConversionResults();

        switch (conversionFrom) {
            case "Siemens/meter - S/m":

                siemenspermeter = (edtValue) * 1;
                picosiemenspermeter = (edtValue) * 1000000000000.0;
                mhopermeter = (edtValue) * 1;
                mhopercentimeter = (edtValue) * 0.01;
                abmhopermeter = (edtValue) * 1.E-9;
                abmhopercentimeter = (edtValue) * 1.E-11;
                statmhopermeter = (edtValue) * 898752432400.0;
                statmhopercentimeter = (edtValue) * 8987524324.0;

                break;


            case "Picosiemens/meter - pS/m":

                siemenspermeter = (edtValue) * 1.E-12;
                picosiemenspermeter = (edtValue) * 1;
                mhopermeter = (edtValue) * 1.E-12;
                mhopercentimeter = (edtValue) * 1.E-14;
                abmhopermeter = (edtValue) * 1.E-21;
                abmhopercentimeter = (edtValue) * 1.E-23;
                statmhopermeter = (edtValue) * 0.8987524324;
                statmhopercentimeter = (edtValue) * 0.0089875243;

                break;

            case "Mho/meter - mho/m":
                siemenspermeter = (edtValue) * 1;
                picosiemenspermeter = (edtValue) * 1000000000000.0;
                mhopermeter = (edtValue) * 1;
                mhopercentimeter = (edtValue) * 0.01;
                abmhopermeter = (edtValue) * 1.E-9;
                abmhopercentimeter = (edtValue) * 1.E-11;
                statmhopermeter = (edtValue) * 898752432400.0;
                statmhopercentimeter = (edtValue) * 8987524324.0;

                break;

            case "Mho/centimeter - mho/cm":

                siemenspermeter = (edtValue) * 100;
                picosiemenspermeter = (edtValue) * 100000000000000.0;
                mhopermeter = (edtValue) * 100;
                mhopercentimeter = (edtValue) * 1;
                abmhopermeter = (edtValue) * 1.E-7;
                abmhopercentimeter = (edtValue) * 9.999999999E-10;
                statmhopermeter = (edtValue) * 89875243240000.0;
                statmhopercentimeter = (edtValue) * 898752432400.0;

                break;


            case "Abmho/meter - abmho/m":

                siemenspermeter = (edtValue) * 1000000000;
                picosiemenspermeter = (edtValue) * 1.E+21;
                mhopermeter = (edtValue) * 1000000000;
                mhopercentimeter = (edtValue) * 10000000;
                abmhopermeter = (edtValue) * 1;
                abmhopercentimeter = (edtValue) * 0.01;
                statmhopermeter = (edtValue) * 898752432400000000000.0;
                statmhopercentimeter = (edtValue) * 8987524323999999000.0;

                break;

            case "Abmho/centimeter - abmho/cm":

                siemenspermeter = (edtValue) * 100000000000.0;
                picosiemenspermeter = (edtValue) * 1.E+23;
                mhopermeter = (edtValue) * 100000000000.0;
                mhopercentimeter = (edtValue) * 1000000000;
                abmhopermeter = (edtValue) * 100;
                abmhopercentimeter = (edtValue) * 1;
                statmhopermeter = (edtValue) * 8.987524324E+22;
                statmhopercentimeter = (edtValue) * 898752432400000100000.0;

                break;


            case "Statmho/meter - stmho/m":

                siemenspermeter = (edtValue) * 1.112653456E-12;
                picosiemenspermeter = (edtValue) * 1.112653456;
                mhopermeter = (edtValue) * 1.112653456E-12;
                mhopercentimeter = (edtValue) * 1.112653456E-14;
                abmhopermeter = (edtValue) * 1.112653456E-21;
                abmhopercentimeter = (edtValue) * 1.112653456E-23;
                statmhopermeter = (edtValue) * 1;
                statmhopercentimeter = (edtValue) * 0.01;

                break;

            case "Statmho/centimeter - st/cm":

                siemenspermeter = (edtValue) * 1.112653456E-10;
                picosiemenspermeter = (edtValue) * 111.2653456;
                mhopermeter = (edtValue) * 1.112653456E-10;
                mhopercentimeter = (edtValue) * 1.112653456E-12;
                abmhopermeter = (edtValue) * 1.112653456E-19;
                abmhopercentimeter = (edtValue) * 1.112653456E-21;
                statmhopermeter = (edtValue) * 100;
                statmhopercentimeter = (edtValue) * 1;

                break;


        }

        results.setSiemenspermeter(siemenspermeter);
        results.setPicosiemenspermeter(picosiemenspermeter);

        results.setMhopermeter(mhopermeter);

        results.setMhopercentimeter(mhopercentimeter);

        results.setAbmhopermeter(abmhopermeter);

        results.setAbmhopercentimeter(abmhopercentimeter);

        results.setStatmhopermeter(statmhopermeter);

        results.setStatmhopercentimeter(statmhopercentimeter);


        converterArray.add(results);
        return converterArray;

    }


    public class ConversionResults {

        private double siemenspermeter, picosiemenspermeter, mhopermeter, mhopercentimeter, abmhopermeter, abmhopercentimeter, statmhopermeter, statmhopercentimeter;

        public double getSiemenspermeter() {
            return siemenspermeter;
        }

        public void setSiemenspermeter(double siemenspermeter) {
            this.siemenspermeter = siemenspermeter;
        }

        public double getPicosiemenspermeter() {
            return picosiemenspermeter;
        }

        public void setPicosiemenspermeter(double picosiemenspermeter) {
            this.picosiemenspermeter = picosiemenspermeter;
        }

        public double getMhopermeter() {
            return mhopermeter;
        }

        public void setMhopermeter(double mhopermeter) {
            this.mhopermeter = mhopermeter;
        }

        public double getMhopercentimeter() {
            return mhopercentimeter;
        }

        public void setMhopercentimeter(double mhopercentimeter) {
            this.mhopercentimeter = mhopercentimeter;
        }

        public double getAbmhopermeter() {
            return abmhopermeter;
        }

        public void setAbmhopermeter(double abmhopermeter) {
            this.abmhopermeter = abmhopermeter;
        }

        public double getAbmhopercentimeter() {
            return abmhopercentimeter;
        }

        public void setAbmhopercentimeter(double abmhopercentimeter) {
            this.abmhopercentimeter = abmhopercentimeter;
        }

        public double getStatmhopermeter() {
            return statmhopermeter;
        }

        public void setStatmhopermeter(double statmhopermeter) {
            this.statmhopermeter = statmhopermeter;
        }

        public double getStatmhopercentimeter() {
            return statmhopercentimeter;
        }

        public void setStatmhopercentimeter(double statmhopercentimeter) {
            this.statmhopercentimeter = statmhopercentimeter;
        }


    }


   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        ElectricConductivity iA = new ElectricConductivity("siemenspermeter",1);

        ArrayList<ElectricConductivity.ConversionResults> results = iA.calculateElectricConductivityConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            ElectricConductivity.ConversionResults item  =  results.get(i);

            System.out.println("\n siemenspermeter - " +new DecimalFormat("##.################").format( item.getSiemenspermeter())
                    +"\n picosiemenspermeter- " +new DecimalFormat("##.################").format( item.getPicosiemenspermeter())
                    +"\n mhopermeter - " +new DecimalFormat("##.################").format( item.getMhopermeter())+
                    "\n mhopercentimeter - " +new DecimalFormat("##.################").format( item.getMhopercentimeter())

                    +"\n abmhopermeter- " +new DecimalFormat("##.################").format( item.getAbmhopermeter())
                    +"\n abmhopercentimeter - " +new DecimalFormat("##.################").format( item.getAbmhopercentimeter())

                    +"\n statmhopermeter - " +new DecimalFormat("##.################").format( item.getStatmhopermeter())+
                    "\n statmhopercentimeter - " +new DecimalFormat("##.################").format( item.getStatmhopercentimeter())




            );



        }
    }

}*/
}