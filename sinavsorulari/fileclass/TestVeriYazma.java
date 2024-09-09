package sinavsorulari.fileclass;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TestVeriYazma {
    public static void main(String[] args) throws IOException {
        File dosyacik = new File("sinif_listesi.txt");
        if(dosyacik.exists()) {
            System.out.println("dosya mevcut");
            System.exit(1);
        }

        PrintWriter cikan = new PrintWriter(dosyacik);

        cikan.print("1-yaman-akbulut-aritmetik");
        cikan.println(85);

        cikan.close();
    }
}
