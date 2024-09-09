package sinavsorulari.swinggui;


/* ekrana y = 10.sinx eğrisini çizen program */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class SinGraph extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Ekran boyutları
        int width = getWidth();
        int height = getHeight();

        // Koordinat sistemini ortalamak için orta noktalar
        int xOffset = width / 2;
        int yOffset = height / 2;

        // Y ekseni ölçeği
        double scale = 10;

        // Çizim alanının temizlenmesi
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Koordinat eksenlerini çiz
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, yOffset, width, yOffset);  // X ekseni
        g2d.drawLine(xOffset, 0, xOffset, height); // Y ekseni

        // Sinüs eğrisini çiz
        g2d.setColor(Color.RED);
        for (int x = -xOffset; x < xOffset; x++) {
            double y = 10 * Math.sin(Math.toRadians(x));
            int x1 = x + xOffset;
            int y1 = yOffset - (int)(y * scale);
            int x2 = x + 1 + xOffset;
            double y2 = 10 * Math.sin(Math.toRadians(x + 1));
            int y2Scaled = yOffset - (int)(y2 * scale);

            // Çizgi oluştur
            g2d.draw(new Line2D.Double(x1, y1, x2, y2Scaled));
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("y = 10 * sin(x) Eğrisi");
        SinGraph graphPanel = new SinGraph();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphPanel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Ekranın ortasında açılır
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
