package sinavsorulari.fileclass;


/* ali.txt isimli bir dosyada satır satır yazılmış 
rakam ve harfler bulunmaktadır. bu dosyadaki harf 
ve rakamları alıp rakam.txt ve harf.txt adlı dosyalara 
türüne göre ayıran program */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileSeparator {

    public static void separateCharacters(String inputFilename, String digitFilename, String letterFilename) {
        try {
            File inputFile = new File(inputFilename);
            Scanner scanner = new Scanner(inputFile);
            
            // Dosyaları yazma modunda açma
            FileWriter digitWriter = new FileWriter(digitFilename);
            FileWriter letterWriter = new FileWriter(letterFilename);

            // Dosyayı satır satır oku
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                for (char ch : line.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        digitWriter.write(ch);
                        digitWriter.write(System.lineSeparator());
                    } else if (Character.isLetter(ch)) {
                        letterWriter.write(ch);
                        letterWriter.write(System.lineSeparator());
                    }
                }
            }

            // Kaynakları kapatma
            scanner.close();
            digitWriter.close();
            letterWriter.close();
            
            System.out.println("Ayrıştırma tamamlandı!");

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + inputFilename);
        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        separateCharacters("duru.txt", "rakam.txt", "harf.txt");  
    } 
}

