package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class ElectricPotentialConverter {


    private double volt     ,  wattperampere   , abvolt  , EMUofelectricpotential    ,statvolt     , ESUofelectricpotential   ;
    private String conversionFrom;
    private double edtValue;


    public ElectricPotentialConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateElectricPotentialConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Volt - V":

                volt=(edtValue)*1;
                wattperampere=(edtValue)*1;
                abvolt=(edtValue)*100000000;
                EMUofelectricpotential=(edtValue)*100000000;
                statvolt=(edtValue)*0.0033356405;
                ESUofelectricpotential=(edtValue)*0.0033356405;


                break;

            case "Watt/ampere - W/A":

                volt=(edtValue)*1;
                wattperampere=(edtValue)*1;
                abvolt=(edtValue)*100000000;
                EMUofelectricpotential=(edtValue)*100000000;
                statvolt=(edtValue)*0.0033356405;
                ESUofelectricpotential=(edtValue)*0.0033356405;


                break;

            case "Abvolt - AbV":

                volt=(edtValue)*1.E-8;
                wattperampere=(edtValue)*1.E-8;
                abvolt=(edtValue)*1;
                EMUofelectricpotential=(edtValue)*1;
                statvolt=(edtValue)*3.335640484E-11;
                ESUofelectricpotential=(edtValue)*3.335640484E-11;


                break;

            case "EMU of electric potential - EMU" :

                volt=(edtValue)*1.E-8;
                wattperampere=(edtValue)*1.E-8;
                abvolt=(edtValue)*1;
                EMUofelectricpotential=(edtValue)*1;
                statvolt=(edtValue)*3.335640484E-11;
                ESUofelectricpotential=(edtValue)*3.335640484E-11;


                break;

            case "Statvolt - stV" :

                volt=(edtValue)*299.7925;
                wattperampere=(edtValue)*299.7925;
                abvolt=(edtValue)*29979250000.0;
                EMUofelectricpotential=(edtValue)*29979250000.0;
                statvolt=(edtValue)*1;
                ESUofelectricpotential=(edtValue)*1;


                break;

            case "ESU of electric potential - ESU" :

                volt=(edtValue)*299.7925;
                wattperampere=(edtValue)*299.7925;
                abvolt=(edtValue)*29979250000.0;
                EMUofelectricpotential=(edtValue)*29979250000.0;
                statvolt=(edtValue)*1;
                ESUofelectricpotential=(edtValue)*1;


                break;


        }


        results. setVolt( volt) ;

        results. setWattperampere( wattperampere) ;

        results. setAbvolt( abvolt) ;
        results. setEMUofelectricpotential( EMUofelectricpotential);
        results. setStatvolt( statvolt) ;

        results. setESUofelectricpotential( ESUofelectricpotential) ;




        converterArray.add(results);
        return converterArray;

    }


    public class ConversionResults{

        private double volt     ,  wattperampere   , abvolt  , EMUofelectricpotential    ,statvolt     , ESUofelectricpotential   ;

        public double getVolt() {
            return volt;
        }

        public void setVolt(double volt) {
            this.volt = volt;
        }

        public double getWattperampere() {
            return wattperampere;
        }

        public void setWattperampere(double wattperampere) {
            this.wattperampere = wattperampere;
        }

        public double getAbvolt() {
            return abvolt;
        }

        public void setAbvolt(double abvolt) {
            this.abvolt = abvolt;
        }

        public double getEMUofelectricpotential() {
            return EMUofelectricpotential;
        }

        public void setEMUofelectricpotential(double eMUofelectricpotential) {
            EMUofelectricpotential = eMUofelectricpotential;
        }

        public double getStatvolt() {
            return statvolt;
        }

        public void setStatvolt(double statvolt) {
            this.statvolt = statvolt;
        }

        public double getESUofelectricpotential() {
            return ESUofelectricpotential;
        }

        public void setESUofelectricpotential(double eSUofelectricpotential) {
            ESUofelectricpotential = eSUofelectricpotential;
        }




    }


   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        ElectricPotential iA = new ElectricPotential("volt",1);

        ArrayList<ElectricPotential.ConversionResults> results = iA.calculateElectricPotentialConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            ElectricPotential.ConversionResults item  =  results.get(i);

            System.out.println("\n volt - " +new DecimalFormat("##.################").format( item.getVolt())
                    +"\n wattperampere- " +new DecimalFormat("##.################").format( item.getWattperampere())
                    +"\n abvolt - " +new DecimalFormat("##.################").format( item.getAbvolt())+
                    "\n eMUofelectricpotential - " +new DecimalFormat("##.################").format( item.getEMUofelectricpotential())

                    +"\n statvolt- " +new DecimalFormat("##.################").format( item.getStatvolt())
                    +"\n eSUofelectricpotential - " +new DecimalFormat("##.################").format( item.getESUofelectricpotential())



            );



        }
    }

*/
}
