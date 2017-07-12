package pkg4cmaas;

import java.awt.Dimension;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Dimension ekran = Toolkit.getDefaultToolkit().getScreenSize();
        double yukseklik = ekran.getHeight();
        double genislik = ekran.getWidth();
        
        Anaform frm = new Anaform();
        frm.setAlwaysOnTop(true);
        frm.setResizable(false);
        System.out.println(frm.getWidth());
        System.out.println(frm.getHeight());
        System.out.println(yukseklik);
        System.out.println(genislik);
        frm.setLocation(((int)genislik/2)-(frm.getWidth()/2), ((int) yukseklik/2)-(frm.getHeight()/2));
        System.out.println(frm.getLocation());
        
        frm.setVisible(true); 
    }
}
