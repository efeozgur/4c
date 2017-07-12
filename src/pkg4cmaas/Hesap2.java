package pkg4cmaas;
public class Hesap2 {
   
    
   private double sozlesmeUcreti,cocukYardimi,esYardimi,sendikaOdenegi,esIstisna,cocukIstisna, ekOdeme,fazlaMesai,maasMatrahi,sgkMatrahi,sgkIsci,sgkIsveren, damgaVergisiMatrahi,damgaVergisi,odemelerToplami,kesintilerToplami,gelirVergisiMatrahi, gelirVergisi, agiMiktari,sendikaAidati,bireyselEmeklilik,okulGosterge,netOdenen; 
   private int altiYasKucuk, altiYasBuyuk; 

    public int getAltiYasKucuk  () {
        return altiYasKucuk;
    }

    public void setAltiYasKucuk(int altiYasKucuk) {
        this.altiYasKucuk = altiYasKucuk;
    }

    public int getAltiYasBuyuk() {
        return altiYasBuyuk;
    }

    public void setAltiYasBuyuk(int altiYasBuyuk) {
        this.altiYasBuyuk = altiYasBuyuk;
    }

    public double getOkulGosterge() {
        return okulGosterge;
    }

    public void setOkulGosterge(int okul) {
        if (okul==1) {
            this.okulGosterge = SABITLER.ILKOKUL;
        } else if(okul==2) {
            this.okulGosterge=SABITLER.LISE_VE_DENGI;
        } else if(okul==3) {
            this.okulGosterge=SABITLER.YUKSEKOKUL;
        } else this.okulGosterge=0;
        
    }
   
   
   
    public double getSozlesmeUcreti() {
        return SABITLER.MEMUR_MAAS_KATSAYISI*okulGosterge;
    }

    public double getCocukYardimi() {
        return (getAltiYasBuyuk()*SABITLER.COCUK_YARDIM_ORANI*SABITLER.MEMUR_MAAS_KATSAYISI)+(getAltiYasKucuk()*SABITLER.COCUK_YARDIM_ORANI*2*SABITLER.MEMUR_MAAS_KATSAYISI);
    }
    
    public double getEsYardimi() {
        return esYardimi;
    }

    public void setEsYardimi(boolean esYardimiAliyormu) {
        if (esYardimiAliyormu) {
            this.esYardimi = SABITLER.ES_YARDIM_ORANI*SABITLER.MEMUR_MAAS_KATSAYISI;
        } else this.esYardimi=0;         
    }
    public double getSendikaOdenegi() {
        return sendikaOdenegi;
    }
    public void setSendikaOdenegi(boolean sendikaOdenekVarmi) {
        if (!sendikaOdenekVarmi) {
            this.sendikaOdenegi =SABITLER.SENDIKA_GOSTERGE_RAKAMI*SABITLER.MEMUR_MAAS_KATSAYISI;
        } else this.sendikaOdenegi=0; 
    }
    public double getEsIstisna() {
        return esIstisna;
    }
    public void setEsIstisna(boolean esYardimiAliyormu) {
        if (esYardimiAliyormu) {
            this.esIstisna = SABITLER.ES_YARDIMI_ISTISNA_ORANI*SABITLER.ASGARI_UCRET;;
        } else this.esIstisna=0; 
    }
    public double getCocukIstisna() {
        if (getAltiYasBuyuk()+getAltiYasKucuk()>2) {
            return SABITLER.ASGARI_UCRET*SABITLER.COCUK_YARDIMI_ISTISNA_ORANI*2;
        } else return SABITLER.ASGARI_UCRET*SABITLER.COCUK_YARDIMI_ISTISNA_ORANI*(getAltiYasBuyuk()+getAltiYasKucuk());
    }

 
    
    
    
    public double getEkOdeme() {
        return SABITLER.MEMUR_MAAS_KATSAYISI*SABITLER.EK_ODEME_ORANI;
    }

    public double getFazlaMesai() {
        return fazlaMesai;
    }

    public void setFazlaMesai(double fazlaMesai) {
        this.fazlaMesai = fazlaMesai;
    }

    public double getMaasMatrahi() {
        return (getSozlesmeUcreti()+ getCocukYardimi()+getEsYardimi()+getEkOdeme())-(getSgkIsci()+getSendikaAidati());
    }


    public double getSgkMatrahi() {
        return (getCocukYardimi()+getEsYardimi()+getSozlesmeUcreti()+getFazlaMesai())-(getCocukIstisna()+getEsIstisna());
    }


    public double getSgkIsci() {
        return  getSgkMatrahi()*SABITLER.SGK_ISCI_ORAN/100;
    }

    public double getSgkIsveren() {
        return getSgkMatrahi()*SABITLER.SGK_ISVEREN_ORAN/100;
    }

   

    public double getDamgaVergisiMatrahi() {
        return getSozlesmeUcreti()+getCocukYardimi()+getEsYardimi()+getEkOdeme()+getSendikaOdenegi()+getFazlaMesai();
    }


    public double getDamgaVergisi() {
        return getDamgaVergisiMatrahi()*SABITLER.DAMGA_VERGISI_ORANI;   
    }

    public double getOdemelerToplami() {
        return getCocukYardimi()+ getEsYardimi()+  getSozlesmeUcreti()+ getFazlaMesai()+ getSgkIsveren()+ getEkOdeme()+ getSendikaOdenegi();
    }

    public double getKesintilerToplami() {
        return getDamgaVergisi()+getGelirVergisi()+getSgkIsci()+ getSgkIsveren()+getSendikaAidati()+getBireyselEmeklilik();
    }

    public double getGelirVergisiMatrahi() {
        return (getSozlesmeUcreti() - getSgkIsci()) +(getCocukYardimi()+getEsYardimi()) +getFazlaMesai();
    }

  

    public double getGelirVergisi() {
        return gelirVergisi;
    }

    public void setGelirVergisi(int gvOran) {
        this.gelirVergisi = (getGelirVergisiMatrahi()*gvOran/100)-getAgiMiktari();
    }

    public double getAgiMiktari() {
        return agiMiktari;
    }

    public void setAgiMiktari(int agi) {
        if (agi==0) {
            this.agiMiktari=SABITLER.BEKAR;
        } else if(agi==1) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISMAYAN;
        } else if (agi==2) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISMAYAN_1_COCUKLU;
        } else if(agi==3) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISMAYAN_2_COCUKLU;
        } else if(agi==4) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISMAYAN_3_COCUKLU;
        } else if(agi==5) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISMAYAN_4_COCUKLU;
        } else if(agi==6) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISMAYAN_5_COCUKLU;
        } else if(agi==7) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISAN;
        } else if(agi==8) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISAN_1_COCUKLU;
        } else if(agi==9) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISAN_2_COCUKLU;
        } else if(agi==10) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISAN_3_COCUKLU;
        } else if(agi==11) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISAN_4_COCUKLU;
        } else if(agi==12) {
            this.agiMiktari = SABITLER.EVLI_ESI_CALISAN_5_COCUKLU;
        }       
    }

    public double getSendikaAidati() {
        return sendikaAidati;
    }

    public void setSendikaAidati(boolean sendikalimi) {
        if (sendikalimi) {
            this.sendikaAidati = getDamgaVergisiMatrahi()*SABITLER.SENDIKA_KESINTI_ORANI/1000;;
        } else this.sendikaAidati=0; 
    }
    public double getBireyselEmeklilik() {
        return bireyselEmeklilik;
    }
    public void setBireyselEmeklilik(boolean bireyselEmeklilikVarmi) {
        if (!bireyselEmeklilikVarmi) {
            this.bireyselEmeklilik = getSgkMatrahi()*SABITLER.BIREYSEL_EMEKLILIK_ORANI/100;
        } else this.bireyselEmeklilik= 0; 
    }
    public double getNetOdenen() {
        return netOdenen = getOdemelerToplami()-getKesintilerToplami();
    }
}
   
