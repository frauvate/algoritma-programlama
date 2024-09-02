/*Bir Java Swing uygulaması yazın. Bu uygulama, 5 adet butona sahiptir 
ve her buton başlangıçta bir asal sayıyı göstermektedir. Butonlar, her 
saniyede bir kendilerini güncelleyerek bir sonraki asal sayıyı göstermelidir. 
Butonlardan birine tıklandığında, sayıların artışı durmalı ve tekrar 
tıklandığında devam etmelidir. Bu işlemi nasıl gerçekleştirirsiniz? */
package calismasorulari.swinggui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main3 extends JFrame {
    private JButton[] buttons = new JButton[5];
    private boolean calisiyor = true;
    private int[] asalSayilar = {2, 3, 5, 7, 11};
    
    public Main3() {
        setTitle("Soru3");
        setSize(400, 400);
        setLayout(new GridLayout(1, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(asalSayilar[i]));
            buttons[i].addActionListener(new ButonDinleyici());
            add(buttons[i]);
        }

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calisiyor) {
                    for (int i = 0; i < asalSayilar.length; i++) {
                        asalSayilar[i] = birSonrakiAsal(asalSayilar[i]);
                        buttons[i].setText(String.valueOf(asalSayilar[i]));
                    }
                }
            }
        });
        timer.start();
    }

        public int birSonrakiAsal(int n) {
            n++;
            while (!asalMi(n)) {
                n++;
            }
            return n;
        }

        public boolean asalMi(int n) {
            if (n <= 1) {
                return false;
            }
            
            for (int i = 2; i < n; i++) {
                if ( n % i == 0) {
                    return false;
                }
            }

            return true;
        }

        private class ButonDinleyici implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                calisiyor = !calisiyor;
            }
        }

    public static void main(String[] args) {
        new Main3().setVisible(true);
    }
}
