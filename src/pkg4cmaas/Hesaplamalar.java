package pkg4cmaas;

/**
 *
 * @author AB96600
 */
public class Hesaplamalar {
    private double sgkPrimineEsasMatrah,sozlesmeucreti,sgkisci,sgkisveren, cocukyardimi,esyardimi,fazlamesai,sendikaodenek; 
    private double gelirvergisi,damgavergisi,sendikaAidat,odemelertoplami,kesintilertoplami, maasmatrahi,ekodeme; 

    public double getSgkisveren() {
        return sgkisveren;
    }

    public double getSendikaodenek() {
        return sendikaodenek;
    }

    public double getGelirvergisi() {
        return gelirvergisi;
    }

    public double getDamgavergisi() {
        return damgavergisi;
    }

    public double getSendikaAidat() {
        return sendikaAidat;
    }

    public double getOdemelertoplami() {
        return odemelertoplami;
    }

    public double getKesintilertoplami() {
        return kesintilertoplami;
    }

    public double getMaasmatrahi() {
        return maasmatrahi;
    }

    public double getEkodeme() {
        return ekodeme;
    }
 
    public double getSgkPrimineEsasMatrah() {
        return sgkPrimineEsasMatrah;
    }

    public double getSozlesmeucreti() {
        return sozlesmeucreti;
    }

    public double getSgkisci() {
        return sgkisci;
    }

    public double getCocukyardimi() {
        return cocukyardimi;
    }



    public double getEsyardimi() {
        return esyardimi;
    }
    
    public void setEsyardimi(double esyardimi) {
        this.esyardimi = esyardimi;
    }
    

    public double getFazlamesai() {
        return fazlamesai;
    }
       
    public double SozlesmeUcreti(int okulGostergesi) {
        sozlesmeucreti= SABITLER.MEMUR_MAAS_KATSAYISI*okulGostergesi;
        return sozlesmeucreti;
    }
    
    public double cocukYardimi(int altiYasAlti, int altiYasUstu) {
        cocukyardimi= (altiYasUstu*SABITLER.COCUK_YARDIM_ORANI*SABITLER.MEMUR_MAAS_KATSAYISI)+(altiYasAlti*SABITLER.COCUK_YARDIM_ORANI*2*SABITLER.MEMUR_MAAS_KATSAYISI);
        return cocukyardimi;
    }
    
    public double esYardimi(boolean esYardimiAliyormu) {
        if (esYardimiAliyormu) {
            return SABITLER.ES_YARDIM_ORANI*SABITLER.MEMUR_MAAS_KATSAYISI;
        } else return 0 ; 
    }
    
    public double sendikaOdenegi(boolean sendikalimi, boolean buAySendikaOdenegiVarmi) {
        if (sendikalimi) {
        if (buAySendikaOdenegiVarmi) {
            sendikaodenek= SABITLER.SENDIKA_GOSTERGE_RAKAMI*SABITLER.MEMUR_MAAS_KATSAYISI;
            return sendikaodenek;
        } else return 0 ;             
        } else return 0; 
    }
    
    public double istisnaCocuk(int altiYasAlti, int altiYasUstu) {
        if (altiYasAlti+altiYasUstu>2) {
            return SABITLER.ASGARI_UCRET*SABITLER.COCUK_YARDIMI_ISTISNA_ORANI*2;
        } else return SABITLER.ASGARI_UCRET*SABITLER.COCUK_YARDIMI_ISTISNA_ORANI*(altiYasAlti+altiYasUstu);
    }
    
    public double istisnaEs(boolean esYardimi) {
        if (esYardimi) {
            return SABITLER.ES_YARDIMI_ISTISNA_ORANI*SABITLER.ASGARI_UCRET;
        } else return 0; 
    }
    
    public double EkOdeme(){
        ekodeme= SABITLER.MEMUR_MAAS_KATSAYISI*SABITLER.EK_ODEME_ORANI;
        return ekodeme;
    }
    
    public double fazlaMesai(boolean fazlaMesaiVarmi, double fazlaMesaiMiktari) {
        if (fazlaMesaiVarmi) {
            fazlamesai= fazlaMesaiMiktari;
            return fazlamesai;
        } else return 0;         
    }
    
    public double maasMatrah(double sozlesmeUcreti, double esYardimi, double cocukYardimi,double ekodeme, double sendikaAidati, double sgkIsci){
        maasmatrahi=(sozlesmeUcreti+cocukYardimi+esYardimi+ekodeme)-(sgkIsci+sendikaAidati);
        return maasmatrahi; 
    }
    
    public double sgkPrimineEsasMatrahH(double cocukyardimi, double esyardimi, double sozlesmeUcreti, double fazlaMesai, double cocukIstisna, double esIstisna){
        sgkPrimineEsasMatrah=(cocukyardimi+esyardimi+sozlesmeUcreti+fazlaMesai)-(cocukIstisna+esIstisna);
        return sgkPrimineEsasMatrah;
    }
    
    public double sgkIsci () { 
        
        sgkisci = getSgkPrimineEsasMatrah()*SABITLER.SGK_ISCI_ORAN/100;
        return sgkisci;
    }
    
    public double sgkIsveren() {
        return sgkPrimineEsasMatrah * SABITLER.SGK_ISVEREN_ORAN/100;
    }
    
    public double BireyselEmeklilik(){
        return getSgkPrimineEsasMatrah()*SABITLER.BIREYSEL_EMEKLILIK_ORANI/100;
    }
    
    public double GelirVergisiMatrahi () {        
        return (sozlesmeucreti - sgkIsci()) +(cocukyardimi+esyardimi) + fazlamesai;
    }
    
    public double GelirVergisi(int gvoran, double agiTutar){
        gelirvergisi=(GelirVergisiMatrahi()*gvoran/100)-agiTutar;
        return gelirvergisi;
    }
    
    public double DamgaVergisiMatrahi () {
        return sozlesmeucreti+cocukyardimi+esyardimi+EkOdeme()+getSendikaodenek()+fazlamesai;
    }
    
    public double DamgaVergisi () {
        damgavergisi=DamgaVergisiMatrahi()*SABITLER.DAMGA_VERGISI_ORANI;                
        return damgavergisi;
    }
    
    public double Kesintler(){
        return DamgaVergisi()+gelirvergisi+sgkIsci()+sgkIsveren()+BireyselEmeklilik()+getSendikaAidat();
        
    }
    
    public double SendikaAidati(boolean sendikayaKayitlimi) {
        if (sendikayaKayitlimi) {
            sendikaAidat= DamgaVergisiMatrahi()*SABITLER.SENDIKA_KESINTI_ORANI/1000;
            return sendikaAidat;
        } else return 0; 
    }
    
    public double odemelerToplami(){
        odemelertoplami = cocukyardimi+esyardimi+sozlesmeucreti+fazlamesai+sgkIsveren()+EkOdeme()+sendikaodenek;
        return odemelertoplami;
    }  
  
    public double netEleGecen() {
        return odemelerToplami()-Kesintler();
    }
    
    public double agiBul(int agi) {
        if (agi==1) {
            return SABITLER.BEKAR;
        } else if (agi==2) {
            return SABITLER.EVLI_ESI_CALISMAYAN;
        } else if (agi==3) {
            return SABITLER.EVLI_ESI_CALISMAYAN_1_COCUKLU;
        } else if (agi==4) {
            return SABITLER.EVLI_ESI_CALISMAYAN_2_COCUKLU;
        } else if(agi==5) {
            return SABITLER.EVLI_ESI_CALISMAYAN_3_COCUKLU;
        }else if(agi==6) {
            return SABITLER.EVLI_ESI_CALISMAYAN_4_COCUKLU; 
        }else if(agi==7) {
            return SABITLER.EVLI_ESI_CALISMAYAN_5_COCUKLU; 
        }else if(agi==8) {
            return SABITLER.EVLI_ESI_CALISAN;
        } else if(agi==9) {
            return SABITLER.EVLI_ESI_CALISAN_1_COCUKLU;
        } else if(agi==10) {
            return SABITLER.EVLI_ESI_CALISAN_2_COCUKLU;
        } else if(agi==11) {
            return SABITLER.EVLI_ESI_CALISAN_3_COCUKLU;
        } else if(agi==12) {
            return SABITLER.EVLI_ESI_CALISAN_4_COCUKLU;
        } else if(agi==13) {
            return SABITLER.EVLI_ESI_CALISAN_5_COCUKLU;
        } else return 0; 
            
    }
    
    public boolean sendikaKaydi(boolean sendika){
        return sendika;
    }
}
