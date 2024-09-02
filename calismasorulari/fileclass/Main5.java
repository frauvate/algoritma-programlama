/* Bir dosya içeriğini okuyarak, her bir kelimenin kaç kez 
geçtiğini hesaplayan ve sonuçları ekrana yazdıran bir Java programı yazınız. 
Kelimeleri büyük/küçük harf duyarsız olarak saydırın ve sadece kelime 
olmayan karakterleri temizleyin (noktalama işaretleri gibi). */
package calismasorulari.fileclass;

import java.io.*;
import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        try {
            // Dosyayı oku ve noktalama işaretlerini temizle
            File file = new File("abc.txt");
            Scanner scan = new Scanner(file);
            StringBuilder cont = new StringBuilder();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String cleanLine = line.replaceAll("[^a-zA-Z]", " ");
                cont.append(cleanLine).append(System.lineSeparator());
            }
            scan.close();

            // Temizlenmiş içeriği yeni bir dosyaya yaz
            FileWriter writer = new FileWriter("yeni.txt");
            writer.write(cont.toString());
            writer.close();

            // Kullanıcıdan kelime al
            Scanner scanner = new Scanner(System.in);
            System.out.println("Aramak istediginiz kelimeyi girin:");
            String find = scanner.nextLine();
            scanner.close();

            // Yeni dosyayı tekrar oku ve kelimeyi ara
            Scanner lastscan = new Scanner(new File("yeni.txt"));
            boolean bulundu = false;

            while (lastscan.hasNextLine()) {
                String line = lastscan.nextLine();
                if (line.toLowerCase().contains(find.toLowerCase())) {
                    System.out.println("Bulunan satır: " + line);
                    bulundu = true;
                }
            }
            lastscan.close();

            if (!bulundu) {
                System.out.println("Aranan kelimeyi içeren satır bulunamadı.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Dosya yazılırken hata oluştu: " + e.getMessage());
        }
    }
}
