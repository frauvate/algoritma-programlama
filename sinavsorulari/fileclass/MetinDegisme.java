package sinavsorulari.fileclass;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MetinDegisme {
    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.out.println("kullanim: java MetinDegistirme kaynakDosya hedefDosya");
            System.exit(1);
        }

        File kaynakDosya = new File(args[0]);
        if (!kaynakDosya.exists()) {
            System.out.println("kaynak dosya " + args[0] + " mevcut degil");
            System.exit(2);
        }

        File hedefDosya = new File(args[1]);
        if (hedefDosya.exists()) {
            System.out.println("hedef dosya " + args[1] + " zaten mevcut");
            System.exit(3);
        }

        try (
            Scanner giris = new Scanner(kaynakDosya);
            PrintWriter cikis = new PrintWriter(hedefDosya);
        ) {
            while (giris.hasNext()) {
                String s1 = giris.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                cikis.println(s2);
            }
        }
    }
}
