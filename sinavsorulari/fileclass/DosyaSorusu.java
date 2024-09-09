package sinavsorulari.fileclass;

import java.io.*;
import java.util.*;

public class DosyaSorusu {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        List<Integer> years = new ArrayList<>();

        try {
            // arabalar.txt dosyasını oku
            BufferedReader carReader = new BufferedReader(new FileReader("arabalar.txt"));
            String line;
            while ((line = carReader.readLine()) != null) {
                cars.add(line);
            }
            carReader.close();

            // yıllar.txt dosyasını oku
            BufferedReader yearReader = new BufferedReader(new FileReader("yıllar.txt"));
            while ((line = yearReader.readLine()) != null) {
                years.add(Integer.parseInt(line));
            }
            yearReader.close();

            // Arabaları yıllar ile eşleştir ve 2020'den büyük yıllara sahip olanları yazdır
            for (int i = 0; i < cars.size(); i++) {
                if (years.get(i) > 2020) {
                    System.out.println("Araba: " + cars.get(i) + ", Yıl: " + years.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Yıl format hatası: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Liste elemanları arasında eşleşme hatası: " + e.getMessage());
        }
    }
}
