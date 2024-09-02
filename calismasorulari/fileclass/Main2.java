/* Bir dosyanın içindeki tüm noktalama işaretlerini silen bir Java programı yazın.
Programın hem dosya okuma hem de dosya yazma işlemlerini nasıl gerçekleştirdiğini 
adım adım açıklayın. Regex (regular expression) kullanarak noktalama 
işaretlerini nasıl temizlersiniz? */
package calismasorulari.fileclass;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        try {
        File file = new File("dosya.txt");
        Scanner reader = new Scanner(file);
        StringBuilder contains = new StringBuilder();

        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            String cleanLine = line.replaceAll("\\p{Punct}", " ");
            contains.append(cleanLine).append(System.lineSeparator());
        }
        reader.close();
        FileWriter writer = new FileWriter("yenidosya.txt");
        writer.write(contains.toString());
        writer.close();

        System.out.println("islem basarili");
        } 
        catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
}
