package sinavsorulari.swinggui;
/*5 adet butonun olduğu ve butonların her birinde bir asal sayının yazılı olduğu, 
her bir saniyede bu sayıların bir sonraki asal sayıya artış gösterdiği ve butonlardan 
birine tıklandığında duran, tekrar tıklandığında devam eden program. örneğin butonlar 
ilk anda 2, 3, 5, 7, 11 şeklindeyken 1 saniye sonra 3, 5, 7, 11, 13 şeklinde olmalı 
ve tıkladığımızda artış durmalı */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsalSayilar extends JFrame {
    private JButton[] butonlar = new JButton[5];
    private boolean calisiyor = true;
    private int[] asalSayilar = {2, 3, 5, 7, 11};

    public AsalSayilar() {
        setTitle("Asal Sayılar");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 5));

        for (int i = 0; i < butonlar.length; i++) {
            butonlar[i] = new JButton(String.valueOf(asalSayilar[i]));
            butonlar[i].addActionListener(new ButonDinleyici());
            add(butonlar[i]);
        }

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calisiyor) {
                    for (int i = 0; i < asalSayilar.length; i++) {
                        asalSayilar[i] = birSonrakiAsal(asalSayilar[i]);
                        butonlar[i].setText(String.valueOf(asalSayilar[i]));
                    }
                }
            }
        });
        timer.start();
    }

    private int birSonrakiAsal(int n) {
        n++;
        while (!asalMi(n)) {
            n++;
        }
        return n;
    }

    private boolean asalMi(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private class ButonDinleyici implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calisiyor = !calisiyor; // Butona her tıklamada durumu değiştir
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AsalSayilar().setVisible(true);
            }
        });
    }
}
