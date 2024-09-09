package sinavsorulari.swinggui;


/* , 100x100'lük bir alanda mouse'un her giriş ve 
çıkışında ekranda gösterilen sayaç değişkenini 
1 artıran bir Java programı */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseCounter extends JFrame implements MouseListener {

    private int counter = 0;
    private JLabel counterLabel;

    public MouseCounter() {
        setTitle("Mouse Counter");
        setSize(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sayaç etiketini oluşturma
        counterLabel = new JLabel("Counter: 0", SwingConstants.CENTER);
        counterLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(counterLabel, BorderLayout.CENTER);

        // JFrame'e MouseListener ekleme
        addMouseListener(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        updateCounter();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        updateCounter();
    }

    private void updateCounter() {
        counter++;
        counterLabel.setText("Counter: " + counter);
    }

    // Diğer MouseListener metotları
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseCounter frame = new MouseCounter();
            frame.setVisible(true);
        });
    }
}

