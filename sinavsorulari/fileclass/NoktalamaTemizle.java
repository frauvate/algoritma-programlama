package sinavsorulari.fileclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NoktalamaTemizle {
    public static void main(String[] args) {
        // Dosyanın yolunu belirt
        String dosyaYolu = "dosya.txt";  // Örnek: "C:\\kullanici\\Belgeler\\dosya.txt"
        String yeniDosyaYolu = "temizlenmis_dosya.txt";
        
        try {
            // Dosyanın içeriğini oku
            File dosya = new File(dosyaYolu);
            Scanner okuyucu = new Scanner(dosya);
            StringBuilder dosyaIcerigi = new StringBuilder();
            
            while (okuyucu.hasNextLine()) {
                String satir = okuyucu.nextLine();
                // Noktalama işaretlerini sil
                String temizlenmisSatir = satir.replaceAll("\\p{Punct}", "");
                dosyaIcerigi.append(temizlenmisSatir).append(System.lineSeparator());
            }
            okuyucu.close();
            
            // Temizlenmiş içeriği yeni bir dosyaya yaz
            FileWriter yazici = new FileWriter(yeniDosyaYolu);
            yazici.write(dosyaIcerigi.toString());
            yazici.close();
            
            System.out.println("Dosya başarıyla temizlendi ve yeni dosyaya yazıldı.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Dosya yazılırken hata oluştu: " + e.getMessage());
        }
    }
}
