package sinavsorulari.fileclass;


/* ali.txt dosyasındaki sayıları okuyup en büyük 
ve en küçük olanları ekrana yazdıran metod */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberProcessor {

    public static void findMinMax(String filename) {
        try {
            System.out.println("Çalışma dizini: " + System.getProperty("user.dir"));
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Başlangıç değerlerini ayarla
            Integer min = null;
            Integer max = null;

            // Dosyayı satır satır oku
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    int number = Integer.parseInt(line.trim());

                    // En büyük ve en küçük değerleri güncelle
                    if (min == null || number < min) {
                        min = number;
                    }
                    if (max == null || number > max) {
                        max = number;
                    }

                } catch (NumberFormatException e) {
                    // Geçerli bir sayı değilse hata mesajı yazdır
                    System.out.println("Geçerli bir sayı değil: " + line);
                }
            }

            scanner.close();

            // Sonuçları ekrana yazdır
            if (min != null && max != null) {
                System.out.println("En küçük sayı: " + min);
                System.out.println("En büyük sayı: " + max);
            } else {
                System.out.println("Dosyada geçerli sayı bulunamadı.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + filename);
        }
    }

    public static void main(String[] args) {
        findMinMax("ali.txt");
    }
}
