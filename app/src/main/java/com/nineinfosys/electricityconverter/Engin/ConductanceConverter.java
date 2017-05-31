package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;


public class ConductanceConverter {


    private double siemens,megasiemens,kilosiemens,milisiemens,microsiemens,amperepervolt,mho,gemmho,micromho,abmho,statmho,quantizedhallconductance;

    private double edtValue;
    private String conversionFrom;


    public ConductanceConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateConductanceConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Siemens - S":

                siemens=(edtValue)*1;
                megasiemens=(edtValue)*0.000001;
                kilosiemens=(edtValue)*0.001;
                milisiemens=(edtValue)*1000;
                microsiemens=(edtValue)*1000000;
                amperepervolt=(edtValue)*1;
                mho=(edtValue)*1;
                gemmho=(edtValue)*1000000;
                micromho=(edtValue)*1000000;
                abmho=(edtValue)*1.E-9;
                statmho=(edtValue)*899000000000.0;
                quantizedhallconductance=(edtValue)*25812.805627;

                break;

            case "Megasiemens - MS" :

                siemens=(edtValue)*1000000;
                megasiemens=(edtValue)*1;
                kilosiemens=(edtValue)*1000;
                milisiemens=(edtValue)*1000000000;
                microsiemens=(edtValue)*1000000000000.0;
                amperepervolt=(edtValue)*1000000;
                mho=(edtValue)*1000000;
                gemmho=(edtValue)*1000000000000.0;
                micromho=(edtValue)*1000000000000.0;
                abmho=(edtValue)*0.001;
                statmho=(edtValue)*898999999999999900.0;
                quantizedhallconductance=(edtValue)*25812805627.0;
                break;

            case "Kilosiemens - kS" :
                siemens=(edtValue)*1000;
                megasiemens=(edtValue)*0.001;
                kilosiemens=(edtValue)*1;
                milisiemens=(edtValue)*1000000;
                microsiemens=(edtValue)*1000000000;
                amperepervolt=(edtValue)*1000;
                mho=(edtValue)*1000;
                gemmho=(edtValue)*1000000000;
                micromho=(edtValue)*1000000000;
                abmho=(edtValue)*0.000001;
                statmho=(edtValue)*899000000000000.0;
                quantizedhallconductance=(edtValue)*25812805.627;
                break;

            case "Milisiemens - mS" :
                siemens=(edtValue)*0.001;
                megasiemens=(edtValue)*1.E-9;
                kilosiemens=(edtValue)*0.000001;
                milisiemens=(edtValue)*1;
                microsiemens=(edtValue)*1000;
                amperepervolt=(edtValue)*0.001;
                mho=(edtValue)*0.001;
                gemmho=(edtValue)*1000;
                micromho=(edtValue)*1000;
                abmho=(edtValue)*1.E-12;
                statmho=(edtValue)*899000000;
                quantizedhallconductance=(edtValue)*25.812805627;
                break;

            case "Microsiemens - µS":
                siemens=(edtValue)*0.000001;
                megasiemens=(edtValue)*1.E-12;
                kilosiemens=(edtValue)*1.E-9;
                milisiemens=(edtValue)*0.001;
                microsiemens=(edtValue)*1;
                amperepervolt=(edtValue)*0.000001;
                mho=(edtValue)*0.000001;
                gemmho=(edtValue)*1;
                micromho=(edtValue)*1;
                abmho=(edtValue)*1.E-15;
                statmho=(edtValue)*899000;
                quantizedhallconductance=(edtValue)*0.0258128056;
                break;



            case "Ampere/volt - A/V":
                siemens=(edtValue)*1;
                megasiemens=(edtValue)*0.000001;
                kilosiemens=(edtValue)*0.001;
                milisiemens=(edtValue)*1000;
                microsiemens=(edtValue)*1000000;
                amperepervolt=(edtValue)*1;
                mho=(edtValue)*1;
                gemmho=(edtValue)*1000000;
                micromho=(edtValue)*1000000;
                abmho=(edtValue)*1.E-9;
                statmho=(edtValue)*899000000000.00;
                quantizedhallconductance=(edtValue)*25812.805627;
                break;


            case "Mho - mho":
                siemens=(edtValue)*1;
                megasiemens=(edtValue)*0.000001;
                kilosiemens=(edtValue)*0.001;
                milisiemens=(edtValue)*1000;
                microsiemens=(edtValue)*1000000;
                amperepervolt=(edtValue)*1;
                mho=(edtValue)*1;
                gemmho=(edtValue)*1000000;
                micromho=(edtValue)*1000000;
                abmho=(edtValue)*1.E-9;
                statmho=(edtValue)*899000000000.0;
                quantizedhallconductance=(edtValue)*25812.805627;
                break;


            case "Gemmho - gemmho" :
                siemens=(edtValue)*0.000001;
                megasiemens=(edtValue)*1.E-12;
                kilosiemens=(edtValue)*1.E-9;
                milisiemens=(edtValue)*0.001;
                microsiemens=(edtValue)*1;
                amperepervolt=(edtValue)*0.000001;
                mho=(edtValue)*0.000001;
                gemmho=(edtValue)*1;
                micromho=(edtValue)*1;
                abmho=(edtValue)*1.E-15;
                statmho=(edtValue)*899000;
                quantizedhallconductance=(edtValue)*0.0258128056;
                break;

            case "Micromho - µmho":
                siemens=(edtValue)*0.000001;
                megasiemens=(edtValue)*1.E-12;
                kilosiemens=(edtValue)*1.E-9;
                milisiemens=(edtValue)*0.001;
                microsiemens=(edtValue)*1;
                amperepervolt=(edtValue)*0.000001;
                mho=(edtValue)*0.000001;
                gemmho=(edtValue)*1;
                micromho=(edtValue)*1;
                abmho=(edtValue)*1.E-15;
                statmho=(edtValue)*899000;
                quantizedhallconductance=(edtValue)*0.0258128056;
                break;

            case "Abmho - abmho":
                siemens=(edtValue)*1000000000;
                megasiemens=(edtValue)*1000;
                kilosiemens=(edtValue)*1000000;
                milisiemens=(edtValue)*1000000000000.0;
                microsiemens=(edtValue)*1000000000000000.0;
                amperepervolt=(edtValue)*1000000000;
                mho=(edtValue)*1000000000;
                gemmho=(edtValue)*1000000000000000.0;
                micromho=(edtValue)*1000000000000000.0;
                abmho=(edtValue)*1;
                statmho=(edtValue)*899000000000000000000.0;
                quantizedhallconductance=(edtValue)*25812805626523.0;
                break;

            case "Statmho - stmho":
                siemens=(edtValue)*1.112347052E-12;
                megasiemens=(edtValue)*1.112347052E-18;
                kilosiemens=(edtValue)*1.112347052E-15;
                milisiemens=(edtValue)*1.112347052E-9;
                microsiemens=(edtValue)*0.0000011123;
                amperepervolt=(edtValue)*1.112347052E-12;
                mho=(edtValue)*1.112347052E-12;
                gemmho=(edtValue)*0.0000011123;
                micromho=(edtValue)*0.0000011123;
                abmho=(edtValue)*1.112347052E-21;
                statmho=(edtValue)*1.0;
                quantizedhallconductance=(edtValue)*2.871279824E-8;
                break;

            case "Quantized Hall Conductance - mho":
                siemens=(edtValue)*0.0000387405;
                megasiemens=(edtValue)*3.874046139E-11;
                kilosiemens=(edtValue)*3.874046139E-8;
                milisiemens=(edtValue)*0.0387404614;
                microsiemens=(edtValue)*38.7404614;
                amperepervolt=(edtValue)*0.0000387405;
                mho=(edtValue)*0.0000387405;
                gemmho=(edtValue)*38.7404614;
                micromho=(edtValue)*38.7404614;
                abmho=(edtValue)*3.874046139E-14;
                statmho=(edtValue)*34827674.799;
                quantizedhallconductance=(edtValue)*1;
                break;

        }
        results.setSiemens(siemens);
        results.setMegasiemens(megasiemens);
        results.setKilosiemens(kilosiemens);
        results.setMilisiemens(milisiemens);
        results.setMicrosiemens(microsiemens);
        results.setAmperepervolt(amperepervolt);
        results.setMho(mho);
        results.setGemmho(gemmho);
        results.setMicromho(micromho);
        results.setAbmho(abmho);
        results.setStatmho(statmho);
        results.setQuantizedhallconductance(quantizedhallconductance);

        converterArray.add(results);
        return converterArray;
    }
    public class ConversionResults{
        private double siemens,megasiemens,kilosiemens,milisiemens,microsiemens,amperepervolt,mho,gemmho,micromho,abmho,statmho,quantizedhallconductance;

        public double getSiemens() {
            return siemens;
        }

        public void setSiemens(double siemens) {
            this.siemens = siemens;
        }

        public double getMegasiemens() {
            return megasiemens;
        }

        public void setMegasiemens(double megasiemens) {
            this.megasiemens = megasiemens;
        }

        public double getKilosiemens() {
            return kilosiemens;
        }

        public void setKilosiemens(double kilosiemens) {
            this.kilosiemens = kilosiemens;
        }

        public double getMilisiemens() {
            return milisiemens;
        }

        public void setMilisiemens(double milisiemens) {
            this.milisiemens = milisiemens;
        }

        public double getMicrosiemens() {
            return microsiemens;
        }

        public void setMicrosiemens(double microsiemens) {
            this.microsiemens = microsiemens;
        }

        public double getAmperepervolt() {
            return amperepervolt;
        }

        public void setAmperepervolt(double amperepervolt) {
            this.amperepervolt = amperepervolt;
        }

        public double getMho() {
            return mho;
        }

        public void setMho(double mho) {
            this.mho = mho;
        }

        public double getGemmho() {
            return gemmho;
        }

        public void setGemmho(double gemmho) {
            this.gemmho = gemmho;
        }

        public double getMicromho() {
            return micromho;
        }

        public void setMicromho(double micromho) {
            this.micromho = micromho;
        }

        public double getAbmho() {
            return abmho;
        }

        public void setAbmho(double abmho) {
            this.abmho = abmho;
        }

        public double getStatmho() {
            return statmho;
        }

        public void setStatmho(double statmho) {
            this.statmho = statmho;
        }

        public double getQuantizedhallconductance() {
            return quantizedhallconductance;
        }

        public void setQuantizedhallconductance(double quantizedhallconductance) {
            this.quantizedhallconductance = quantizedhallconductance;
        }




    }






}
