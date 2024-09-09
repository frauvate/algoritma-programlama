package sinavsorulari.swinggui;


/* 6 adet harf tuşu(bir çeşit klavye gibi, 
bunlar a, b, c, d, e ve f olacak.) ve bir adet 
"şifreyi göster" tuşu. her bir harf butonuna 
basıldığında 3 sonraki harf "şifre" olarak yazılacak. 
örneğin abcde yazıldığında şifre defgh olacak. */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CipherApp extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton showCipherButton;

    public CipherApp() {
        setTitle("Cipher App");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Metin alanı oluşturulması
        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        // Harf düğmeleri paneli
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f'};

        for (char letter : letters) {
            JButton button = new JButton(String.valueOf(letter));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Şifreyi göster düğmesi
        showCipherButton = new JButton("Şifreyi Göster");
        showCipherButton.addActionListener(e -> showCipher());
        add(showCipherButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentText = textField.getText();
        String buttonLabel = ((JButton) e.getSource()).getText();
        textField.setText(currentText + buttonLabel);
    }

    private void showCipher() {
        String text = textField.getText();
        StringBuilder cipherText = new StringBuilder();

        for (char c : text.toCharArray()) {
            cipherText.append((char) ((c - 'a' + 3) % 26 + 'a'));
        }

        textField.setText(cipherText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CipherApp frame = new CipherApp();
            frame.setVisible(true);
        });
    }
}
