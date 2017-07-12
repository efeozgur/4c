package pkg4cmaas;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        Dimension ekran = Toolkit.getDefaultToolkit().getScreenSize();
        double yukseklik = ekran.getHeight();
        double genislik = ekran.getWidth();
        Anaform frm = new Anaform();
        frm.setAlwaysOnTop(true);
        frm.setResizable(false);
        
        frm.setLocation(((int)genislik/2)-(frm.getWidth()/2), ((int) yukseklik/2)-(frm.getHeight()/2));

        
        frm.setVisible(true); 
    }
}
