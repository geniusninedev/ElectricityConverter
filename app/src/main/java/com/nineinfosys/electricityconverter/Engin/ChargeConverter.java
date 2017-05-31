package com.nineinfosys.electricityconverter.Engin;


        import java.util.ArrayList;

public class ChargeConverter {



    private double c,MC,kC,mC,microC,nC,pC,abC,emu,stc,esu,fr,ah,amin,as,faraday,e;
    private double edtValue;
    private String conversionFrom;




    public ChargeConverter(String conversionFrom, int edtValue) {

        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }



    public ArrayList<ConversionResults> calculatechargeConversion()

    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)

        {
            case "Coulomb - C":

                c=(edtValue)*1;
                MC=(edtValue)*0.000001;
                kC=(edtValue)*0.001;
                mC=(edtValue)*1000;
                microC=(edtValue)*1000000;
                nC=(edtValue)*1000000000;
                pC=(edtValue)*1000000000000.00;
                abC=(edtValue)*0.1;
                emu=(edtValue)*0.1;
                stc=(edtValue)*2997924580.00;
                esu=(edtValue)*2997924580.00;
                fr=(edtValue)*2997924580.00;
                ah=(edtValue)*0.0002777778;
                amin=(edtValue)*0.0166666667;
                as=(edtValue)*1;
                faraday=(edtValue)*0.0000103643;
                e=(edtValue)*6241506363094001000.00;


                break;
            case "Megacoulomb - MC":

                c=(edtValue)*1000000;
                MC=(edtValue)*1;
                kC=(edtValue)*1000;
                mC=(edtValue)*1000000000;
                microC=(edtValue)*1000000000000.00;
                nC=(edtValue)*1000000000000000.00;
                pC=(edtValue)*1000000000000000000.00;
                abC=(edtValue)*100000;
                emu=(edtValue)*100000;
                stc=(edtValue)*2997924579999600.00;
                esu=(edtValue)*2997924579999600.00;
                fr=(edtValue)*2997924579999600.00;
                ah=(edtValue)*277.77777778;
                amin=(edtValue)*16666.666667;
                as=(edtValue)*1000000;
                faraday=(edtValue)*10.36427214;
                e=(edtValue)*6.241506363E+24;


                break;
            case "Kilocoulomb - kC":

                c=(edtValue)*1000;
                MC=(edtValue)*0.001;
                kC=(edtValue)*1;
                mC=(edtValue)*1000000;
                microC=(edtValue)*1000000000;
                nC=(edtValue)*1000000000000.00;
                pC=(edtValue)*1000000000000000.00;
                abC=(edtValue)*100;
                emu=(edtValue)*100;
                stc=(edtValue)*2997924580000.00;
                esu=(edtValue)*2997924580000.00;
                fr=(edtValue)*2997924580000.00;
                ah=(edtValue)*0.2777777778;
                amin=(edtValue)*16.666666667;
                as=(edtValue)*1000;
                faraday=(edtValue)*0.0103642721;
                e=(edtValue)*6.241506363E+21;


                break;
            case "Millicoulomb - mC":

                c=(edtValue)*0.001;
                MC=(edtValue)*1.E-9;
                kC=(edtValue)*0.000001;
                mC=(edtValue)*1;
                microC=(edtValue)*1000;
                nC=(edtValue)*1000000;
                pC=(edtValue)*1000000000;
                abC=(edtValue)*0.0001;
                emu=(edtValue)*0.0001;
                stc=(edtValue)*2997924.58;
                esu=(edtValue)*2997924.58;
                fr=(edtValue)*2997924.58;
                ah=(edtValue)*2.777777777E-7;
                amin=(edtValue)*0.0000166667;
                as=(edtValue)*0.001;
                faraday=(edtValue)*1.036427214E-8;
                e=(edtValue)*6241506363094000.00;



                break;
            case "Microcoulomb - µC":

                c=(edtValue)*0.000001;
                MC=(edtValue)*1.E-12;
                kC=(edtValue)*1.E-9;
                mC=(edtValue)*0.001;
                microC=(edtValue)*1;
                nC=(edtValue)*1000;
                pC=(edtValue)*1000000;
                abC=(edtValue)*1.E-7;
                emu=(edtValue)*1.E-7;
                stc=(edtValue)*2997.92458;
                esu=(edtValue)*2997.92458;
                fr=(edtValue)*2997.92458;
                ah=(edtValue)*2.777777777E-10;
                amin=(edtValue)*1.666666666E-8;
                as=(edtValue)*0.000001;
                faraday=(edtValue)*1.036427214E-11;
                e=(edtValue)*6241506363094.00;


                break;
            case "Nanocoulomb - nC":

                c=(edtValue)*1.E-9;
                MC=(edtValue)*1.E-15;
                kC=(edtValue)*1.E-12;
                mC=(edtValue)*0.000001;
                microC=(edtValue)*0.001;
                nC=(edtValue)*1;
                pC=(edtValue)*1000;
                abC=(edtValue)*1.E-10;
                emu=(edtValue)*1.E-10;
                stc=(edtValue)*2.99792458;
                esu=(edtValue)*2.99792458;
                fr=(edtValue)*2.99792458;
                ah=(edtValue)*2.777777777E-13;
                amin=(edtValue)*1.666666666E-11;
                as=(edtValue)*1.E-9;
                faraday=(edtValue)*1.036427214E-14;
                e=(edtValue)*6241506363.1;


                break;
            case "Picocoulomb - pC":

                c=(edtValue)*1.E-12;
                MC=(edtValue)*1.E-18;
                kC=(edtValue)*1.E-15;
                mC=(edtValue)*1.E-9;
                microC=(edtValue)*0.000001;
                nC=(edtValue)*0.001;
                pC=(edtValue)*1;
                abC=(edtValue)*1.E-13;
                emu=(edtValue)*1.E-13;
                stc=(edtValue)*0.0029979246;
                esu=(edtValue)*0.0029979246;
                fr=(edtValue)*0.0029979246;
                ah=(edtValue)*2.777777777E-16;
                amin=(edtValue)*1.666666666E-14;
                as=(edtValue)*1.E-12;
                faraday=(edtValue)*1.036427214E-17;
                e=(edtValue)*6241506.3631;


                break;
            case "Abcoulomb - abC":

                c=(edtValue)*10;
                MC=(edtValue)*0.00001;
                kC=(edtValue)*0.01;
                mC=(edtValue)*10000;
                microC=(edtValue)*10000000;
                nC=(edtValue)*10000000000.00;
                pC=(edtValue)*10000000000000.00;
                abC=(edtValue)*1;
                emu=(edtValue)*1;
                stc=(edtValue)*29979245800.00;
                esu=(edtValue)*29979245800.00;
                fr=(edtValue)*29979245800.00;
                ah=(edtValue)*0.0027777778;
                amin=(edtValue)*0.1666666667;
                as=(edtValue)*10;
                faraday=(edtValue)*0.0001036427;
                e=(edtValue)*62415063630940004000.00;

                break;
            case "EMU of charge - e":

                c=(edtValue)*10;
                MC=(edtValue)*0.00001;
                kC=(edtValue)*0.01;
                mC=(edtValue)*10000;
                microC=(edtValue)*10000000;
                nC=(edtValue)*10000000000.00;
                pC=(edtValue)*10000000000000.00;
                abC=(edtValue)*1;
                emu=(edtValue)*1;
                stc=(edtValue)*29979245800.00;
                esu=(edtValue)*29979245800.00;
                fr=(edtValue)*29979245800.00;
                ah=(edtValue)*0.0027777778;
                amin=(edtValue)*0.1666666667;
                as=(edtValue)*10;
                faraday=(edtValue)*0.0001036427;
                e=(edtValue)*62415063630940004000.00;



                break;
            case "Statcoulomb - stC":

                c=(edtValue)*3.335640951E-10;
                MC=(edtValue)*3.335640951E-16;
                kC=(edtValue)*3.335640951E-13;
                mC=(edtValue)*3.335640951E-7;
                microC=(edtValue)*0.0003335641;
                nC=(edtValue)*0.3335640952;
                pC=(edtValue)*333.5640952;
                abC=(edtValue)*3.335640951E-11;
                emu=(edtValue)*3.335640951E-11;
                stc=(edtValue)*1;
                esu=(edtValue)*1;
                fr=(edtValue)*1;
                ah=(edtValue)*9.265669311E-14;
                amin=(edtValue)*5.559401586E-12;
                as=(edtValue)*3.335640951E-10;
                faraday=(edtValue)*3.457149058E-15;
                e=(edtValue)*2081942422.7;


                break;
            case "ESU of charge - e":

                c=(edtValue)*3.335640951E-10;
                MC=(edtValue)*3.335640951E-16;
                kC=(edtValue)*3.335640951E-13;
                mC=(edtValue)*3.335640951E-7;
                microC=(edtValue)*0.0003335641;
                nC=(edtValue)*0.3335640952;
                pC=(edtValue)*333.5640952;
                abC=(edtValue)*3.335640951E-11;
                emu=(edtValue)*3.335640951E-11;
                stc=(edtValue)*1;
                esu=(edtValue)*1;
                fr=(edtValue)*1;
                ah=(edtValue)*9.265669311E-14;
                amin=(edtValue)*5.559401586E-12;
                as=(edtValue)*3.335640951E-10;
                faraday=(edtValue)*3.457149058E-15;
                e=(edtValue)*2081942422.7;



                break;
            case "Franklin - Fr":

                c=(edtValue)*3.335640951E-10;
                MC=(edtValue)*3.335640951E-16;
                kC=(edtValue)*3.335640951E-13;
                mC=(edtValue)*3.335640951E-7;
                microC=(edtValue)*0.0003335641;
                nC=(edtValue)*0.3335640952;
                pC=(edtValue)*333.5640952;
                abC=(edtValue)*3.335640951E-11;
                emu=(edtValue)*3.335640951E-11;
                stc=(edtValue)*1;
                esu=(edtValue)*1;
                fr=(edtValue)*1;
                ah=(edtValue)*9.265669311E-14;
                amin=(edtValue)*5.559401586E-12;
                as=(edtValue)*3.335640951E-10;
                faraday=(edtValue)*3.457149058E-15;
                e=(edtValue)*2081942422.7;

                break;

            case "Ampere-hour - A*h":

                c=(edtValue)*3600;
                MC=(edtValue)*0.0036;
                kC=(edtValue)*3.6;
                mC=(edtValue)*3600000;
                microC=(edtValue)*3600000000.00;
                nC=(edtValue)*3600000000000.00;
                pC=(edtValue)*3599999999999972.00;
                abC=(edtValue)*360;
                emu=(edtValue)*360;
                stc=(edtValue)*10792528487998.00;
                esu=(edtValue)*10792528487998.00;
                fr=(edtValue)*10792528487998.00;
                ah=(edtValue)*1;
                amin=(edtValue)*60;
                as=(edtValue)*3600;
                faraday=(edtValue)*0.0373113797;
                e=(edtValue)*2.24694229E+22;

                break;
            case "Ampere-minute - A*min":

                c=(edtValue)*60;
                MC=(edtValue)*0.00006;
                kC=(edtValue)*0.06;
                mC=(edtValue)*60000;
                microC=(edtValue)*60000000;
                nC=(edtValue)*60000000000.00;
                pC=(edtValue)*59999999999999.00;
                abC=(edtValue)*6;
                emu=(edtValue)*6;
                stc=(edtValue)*179875474800.00;
                esu=(edtValue)*179875474800.00;
                fr=(edtValue)*179875474800.00;
                ah=(edtValue)*0.0166666667;
                amin=(edtValue)*1;
                as=(edtValue)*60;
                faraday=(edtValue)*0.0006218563;
                e=(edtValue)*374490381785632540000.00;

                break;

            case "Ampere-second - A*s":

                c=(edtValue)*1;
                MC=(edtValue)*0.000001;
                kC=(edtValue)*0.001;
                mC=(edtValue)*1000;
                microC=(edtValue)*1000000;
                nC=(edtValue)*1000000000;
                pC=(edtValue)*1000000000000.00;
                abC=(edtValue)*0.1;
                emu=(edtValue)*0.1;
                stc=(edtValue)*2997924580.00;
                esu=(edtValue)*2997924580.00;
                fr=(edtValue)*2997924580.00;
                ah=(edtValue)*0.0002777778;
                amin=(edtValue)*0.0166666667;
                as=(edtValue)*1;
                faraday=(edtValue)*0.0000103643;
                e=(edtValue)*6241506363094001000.00;

                break;
            case "Faraday - F":

                c=(edtValue)*96485.309;
                MC=(edtValue)*0.096485309;
                kC=(edtValue)*96.485309;
                mC=(edtValue)*96485309;
                microC=(edtValue)*96485309000.00;
                nC=(edtValue)*96485309000004.00;
                pC=(edtValue)*96485309000004300.00;
                abC=(edtValue)*9648.5309;
                emu=(edtValue)*9648.5309;
                stc=(edtValue)*289255679459970.00;
                esu=(edtValue)*289255679459970.0;
                fr=(edtValue)*289255679459970.0;
                ah=(edtValue)*26.801474722;
                amin=(edtValue)*1608.0884833;
                as=(edtValue)*96485.309;
                faraday=(edtValue)*1;
                e=(edtValue)*6.0221367E+23;

                break;
            case "Elementary charge - e":

                c=(edtValue)*1.60217733E-19;
                MC=(edtValue)*1.60217733E-25;
                kC=(edtValue)*1.60217733E-22;
                mC=(edtValue)*1.60217733E-16;
                microC=(edtValue)*1.60217733E-13;
                nC=(edtValue)*1.60217733E-10;
                pC=(edtValue)*1.60217733E-7;
                abC=(edtValue)*1.60217733E-20;
                emu=(edtValue)*1.60217733E-20;
                stc=(edtValue)*4.803206799E-10;
                esu=(edtValue)*4.803206799E-10;
                fr=(edtValue)*4.803206799E-10;
                ah=(edtValue)*4.450492583E-23;
                amin=(edtValue)*2.67029555E-21;
                as=(edtValue)*1.60217733E-19;
                faraday=(edtValue)*1.660540186E-24;
                e=(edtValue)*1;

                break;



        }
        results.setC(c);
        results.setMC(MC);
        results.setkC(kC);
        results.setmC(mC);
        results.setMicroC(microC);
        results.setnC(nC);
        results.setpC(pC);
        results.setAbC(abC);
        results.setEmu(emu);
        results.setStc(stc);
        results.setEsu(esu);
        results.setFr(fr);
        results.setAh(ah);
        results.setAmin(amin);
        results.setAs(as);
        results.setFaraday(faraday);
        results.setE(e);



        converterArray.add(results);

        return converterArray;


    }
    public class ConversionResults{

        private double c,MC,kC,mC,microC,nC,pC,abC,emu,stc,esu,fr,ah,amin,as,faraday,e;

        public double getMicroC() {
            return microC;
        }

        public void setMicroC(double microC) {
            this.microC = microC;
        }

        public double getC() {
            return c;
        }

        public void setC(double c) {
            this.c = c;
        }

        public double getMC() {
            return MC;
        }

        public void setMC(double mC) {
            MC = mC;
        }

        public double getkC() {
            return kC;
        }

        public void setkC(double kC) {
            this.kC = kC;
        }

        public double getmC() {
            return mC;
        }

        public void setmC(double mC) {
            this.mC = mC;
        }


        public double getnC() {
            return nC;
        }

        public void setnC(double nC) {
            this.nC = nC;
        }

        public double getpC() {
            return pC;
        }

        public void setpC(double pC) {
            this.pC = pC;
        }

        public double getAbC() {
            return abC;
        }

        public void setAbC(double abC) {
            this.abC = abC;
        }

        public double getEmu() {
            return emu;
        }

        public void setEmu(double emu) {
            this.emu = emu;
        }

        public double getStc() {
            return stc;
        }

        public void setStc(double stc) {
            this.stc = stc;
        }

        public double getEsu() {
            return esu;
        }

        public void setEsu(double esu) {
            this.esu = esu;
        }

        public double getFr() {
            return fr;
        }

        public void setFr(double fr) {
            this.fr = fr;
        }

        public double getAh() {
            return ah;
        }

        public void setAh(double ah) {
            this.ah = ah;
        }

        public double getAmin() {
            return amin;
        }

        public void setAmin(double amin) {
            this.amin = amin;
        }

        public double getAs() {
            return as;
        }

        public void setAs(double as) {
            this.as = as;
        }

        public double getFaraday() {
            return faraday;
        }

        public void setFaraday(double faraday) {
            this.faraday = faraday;
        }

        public double getE() {
            return e;
        }

        public void setE(double e) {
            this.e = e;
        }


    }
}
