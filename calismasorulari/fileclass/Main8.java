/* Soru 4:
Bir metin dosyasının içeriğini tersine çeviren (her bir satırı tersine çevirerek) 
ve sonucu yeni bir dosyaya yazan bir Java programı yazınız. Program, kullanıcıdan 
dosya yolunu almalı ve dosya işlemleri sırasında oluşabilecek hataları düzgün bir 
şekilde yakalayıp yönetmelidir. */
package calismasorulari.fileclass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter file path : ");
        String filename = input.nextLine();
        input.close();

        try {
        Scanner scan = new Scanner(new File(filename));
        String reversedLine = "";
        char ch;
        StringBuilder content = new StringBuilder();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            for (int i=0; i<line.length(); i++) {
              ch= line.charAt(i);
              reversedLine = ch + reversedLine; 
            }

            content.append(reversedLine).append(System.lineSeparator());
        }
        scan.close();

        FileWriter writer = new FileWriter("tersDosya.txt");
        writer.write(content.toString());
        writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
