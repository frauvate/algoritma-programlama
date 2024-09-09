package sinavsorulari.swinggui;


/* threat kulanarak ekrana ilk kelimeyi 10 sn 
ikinci kelimeyi 20 sn gösteren program. */
import javax.swing.*;
import java.awt.*;

public class WordDisplay extends JFrame {

    private JLabel label;

    public WordDisplay() {
        // JFrame ayarları
        setTitle("Kelime Gösterim");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // JLabel oluşturma ve ekleme
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 32));
        add(label);

        // Görünürlük
        setVisible(true);

        // Kelimeleri gösteren thread'i başlat
        new Thread(() -> displayWords()).start();
    }

    private void displayWords() {
        try {
            // İlk kelimeyi göster
            label.setText("ilk");
            Thread.sleep(10000); // 10 saniye bekle

            // İkinci kelimeyi göster
            label.setText("iki");
            Thread.sleep(20000); // 20 saniye bekle

            // Gösterim tamamlandıktan sonra pencereyi kapat
            dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordDisplay());
    }
}
