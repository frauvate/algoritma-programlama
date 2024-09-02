/* Aşağıdaki senaryoya uygun bir Java Swing uygulaması tasarlayın: 
Uygulamanızda 3 buton, bir metin alanı (JTextField), ve bir etiket 
(JLabel) bulunmalıdır. Kullanıcı, butonlardan birine tıkladığında, 
metin alanına bir değer girip, bu değeri etiketin metni olarak 
belirleyebilmelidir. Her buton farklı bir etiket metnini değiştirsin. 
Bu uygulamanın kodunu yazın ve işleyişini açıklayın. */
package calismasorulari.swinggui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main4 extends JFrame {
    private JTextField textField;
    private JLabel label1, label2, label3;
    private JButton button1, button2, button3;

    public Main4() {
        setTitle("Soru 4");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        textField = new JTextField();
        label1 = new JLabel("Etiket 1");
        label2 = new JLabel("Etiket 2");
        label3 = new JLabel("Etiket 3");

        button1 = new JButton("Buton 1");
        button2 = new JButton("Buton 2");
        button3 = new JButton("Buton 3");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText(textField.getText());
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setText(textField.getText());
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label3.setText(textField.getText());
            }
        });

        add(textField);
        add(button1);
        add(button2);
        add(button3);
        add(label1);
        add(label2);
        add(label3);
    }

    public static void main(String[] args) {
            new Main4().setVisible(true);
    }
}
