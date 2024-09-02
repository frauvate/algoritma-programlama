/* Bir Java Swing uygulaması oluşturun. Uygulamanızda 4 adet buton ve 2 adet etiket (JLabel) bulunmalıdır.
Her bir butona tıklandığında, ilgili etiketin metni değişsin.
Butonların ve etiketlerin başlangıç değerlerini ve düzenlemelerini belirleyin. (20 puan) */
package calismasorulari.swinggui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main1 extends JFrame implements ActionListener {
    private JButton[] buttons = new JButton[4];
    private int[] sayilar = {1, 2, 3, 4};
    public  JLabel[] tags = new JLabel[2];
    private int[] counters = {0, 0};
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (i < 2) {
                    counters[0]++;
                    tags[0].setText("Counter 1: " + counters[0]);
                } else {
                    counters[1]++;
                    tags[1].setText("Counter 2: " + counters[1]);
                }
            }
        }
    }

    public Main1() {
        setTitle("BirinciSoru");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new  GridLayout(2, 4));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(sayilar[i]));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        tags[0] = new JLabel("counter 1: 0");
        tags[1] = new JLabel("counter 2: 0");
        add(tags[0]);
        add(tags[1]);
    }

    public static void main(String[] args) {
        Main1 app = new Main1();
        app.setVisible(true);
    }
}