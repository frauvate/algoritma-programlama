package appointmentsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentSystem {

    private static List<Student> öğrenciler = new ArrayList<>();
    private static List<Instructor> akademisyenler = new ArrayList<>();
    private static List<Appointment> randevular = new ArrayList<>();

    public static void main(String[] args) {
        // Başlangıçta dosyalardan veri oku
        öğrenciBilgileriniYükle();
        akademisyenBilgileriniYükle();
        randevuBilgileriniYükle();

        // Konsol menüsü
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Öğrenci Ekle");
            System.out.println("2. Akademisyen Ekle");
            System.out.println("3. Randevu Ekle");
            System.out.println("4. Öğrencileri Listele");
            System.out.println("5. Akademisyenleri Listele");
            System.out.println("6. Randevuları Listele");
            System.out.println("7. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int seçim = scanner.nextInt();
            scanner.nextLine(); // Yeni satır karakterini temizle

            switch (seçim) {
                case 1:
                    öğrenciEkle(scanner);
                    break;
                case 2:
                    akademisyenEkle(scanner);
                    break;
                case 3:
                    randevuEkle(scanner);
                    break;
                case 4:
                    öğrencileriListele();
                    break;
                case 5:
                    akademisyenleriListele();
                    break;
                case 6:
                    randevularıListele();
                    break;
                case 7:
                    dosyalaraKaydet();
                    System.out.println("Programdan çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
    }

    private static void öğrenciBilgileriniYükle() {
        try (BufferedReader reader = new BufferedReader(new FileReader("öğrenci.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String numara = parts[0];
                String ad = parts[1];
                String soyad = parts[2];
                String bölüm = parts[3];
                int kayıtYılı = Integer.parseInt(parts[4]);
                String email = parts[5];
                String telefon = parts[6];
                öğrenciler.add(new Student(numara, ad, soyad, bölüm, kayıtYılı, email, telefon));
            }
        } catch (IOException e) {
            System.out.println("Öğrenci bilgileri yüklenirken hata oluştu: " + e.getMessage());
        }
    }

    private static void akademisyenBilgileriniYükle() {
        try (BufferedReader reader = new BufferedReader(new FileReader("akademisyen.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String sicilNo = parts[0];
                String ad = parts[1];
                String soyad = parts[2];
                String anabilimDalı = parts[3];
                String email = parts[4];
                String telefon = parts[5];
                String unvan = parts[6];
                akademisyenler.add(new Instructor(sicilNo, ad, soyad, anabilimDalı, email, telefon, unvan));
            }
        } catch (IOException e) {
            System.out.println("Akademisyen bilgileri yüklenirken hata oluştu: " + e.getMessage());
        }
    }

    private static void randevuBilgileriniYükle() {
        try (BufferedReader reader = new BufferedReader(new FileReader("randevu.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String öğrenciNumara = parts[0];
                String akademisyenSicilNo = parts[1];
                String tarih = parts[2];
                String başlangıçSaati = parts[3];
                String bitişSaati = parts[4];

                Student öğrenci = öğrenciler.stream()
                        .filter(o -> o.getNumara().equals(öğrenciNumara))
                        .findFirst().orElse(null);
                Instructor akademisyen = akademisyenler.stream()
                        .filter(a -> a.getSicilNo().equals(akademisyenSicilNo))
                        .findFirst().orElse(null);

                if (öğrenci != null && akademisyen != null) {
                    randevular.add(new Appointment(öğrenci, akademisyen, tarih, başlangıçSaati, bitişSaati));
                }
            }
        } catch (IOException e) {
            System.out.println("Randevu bilgileri yüklenirken hata oluştu: " + e.getMessage());
        }
    }

    private static void öğrenciEkle(Scanner scanner) {
        System.out.print("Öğrenci numarası: ");
        String numara = scanner.nextLine();
        System.out.print("Ad: ");
        String ad = scanner.nextLine();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();
        System.out.print("Bölüm: ");
        String bölüm = scanner.nextLine();
        System.out.print("Kayıt yılı: ");
        int kayıtYılı = scanner.nextInt();
        scanner.nextLine(); // Yeni satır karakterini temizle
        System.out.print("E-posta: ");
        String email = scanner.nextLine();
        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();

        öğrenciler.add(new Student(numara, ad, soyad, bölüm, kayıtYılı, email, telefon));
        System.out.println("Öğrenci başarıyla eklendi.");
    }

    private static void akademisyenEkle(Scanner scanner) {
        System.out.print("Sicil numarası: ");
        String sicilNo = scanner.nextLine();
        System.out.print("Ad: ");
        String ad = scanner.nextLine();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();
        System.out.print("Anabilim dalı: ");
        String anabilimDalı = scanner.nextLine();
        System.out.print("E-posta: ");
        String email = scanner.nextLine();
        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();
        System.out.print("Unvan: ");
        String unvan = scanner.nextLine();

        akademisyenler.add(new Instructor(sicilNo, ad, soyad, anabilimDalı, email, telefon, unvan));
        System.out.println("Akademisyen başarıyla eklendi.");
    }

    private static void randevuEkle(Scanner scanner) {
        System.out.print("Öğrenci numarası: ");
        String öğrenciNumara = scanner.nextLine();
        System.out.print("Akademisyen sicil numarası: ");
        String akademisyenSicilNo = scanner.nextLine();
        System.out.print("Tarih (GG.AA.YYYY): ");
        String tarih = scanner.nextLine();
        System.out.print("Başlangıç saati (SS.DD): ");
        String başlangıçSaati = scanner.nextLine();
        System.out.print("Bitiş saati (SS.DD): ");
        String bitişSaati = scanner.nextLine();

        Student öğrenci = öğrenciler.stream()
                .filter(o -> o.getNumara().equals(öğrenciNumara))
                .findFirst().orElse(null);
        Instructor akademisyen = akademisyenler.stream()
                .filter(a -> a.getSicilNo().equals(akademisyenSicilNo))
                .findFirst().orElse(null);

        if (öğrenci == null || akademisyen == null) {
            System.out.println("Öğrenci veya akademisyen bulunamadı.");
            return;
        }

        boolean çakışmaVar = randevular.stream()
                .anyMatch(r -> r.getÖğrenci().equals(öğrenci) && r.getTarih().equals(tarih) &&
                        ((r.getBaşlangıçSaati().compareTo(başlangıçSaati) <= 0 && r.getBitişSaati().compareTo(başlangıçSaati) > 0) ||
                        (r.getBaşlangıçSaati().compareTo(bitişSaati) < 0 && r.getBitişSaati().compareTo(bitişSaati) >= 0)) ||
                        (r.getAkademisyen().equals(akademisyen) && r.getTarih().equals(tarih) &&
                        ((r.getBaşlangıçSaati().compareTo(başlangıçSaati) <= 0 && r.getBitişSaati().compareTo(başlangıçSaati) > 0) ||
                        (r.getBaşlangıçSaati().compareTo(bitişSaati) < 0 && r.getBitişSaati().compareTo(bitişSaati) >= 0))));

        if (çakışmaVar) {
            System.out.println("Randevu çakışması var. Lütfen başka bir zaman seçin.");
        } else {
            randevular.add(new Appointment(öğrenci, akademisyen, tarih, başlangıçSaati, bitişSaati));
            System.out.println("Randevu başarıyla eklendi.");
        }
    }

    private static void öğrencileriListele() {
        System.out.println("Öğrenciler:");
        for (Student öğrenci : öğrenciler) {
            System.out.printf("%s %s %s %s %d %s %s%n", öğrenci.getNumara(), öğrenci.getAd(), öğrenci.getSoyad(),
                    öğrenci.getBölüm(), öğrenci.getKayıtYılı(), öğrenci.getEmail(), öğrenci.getTelefon());
        }
    }

    private static void akademisyenleriListele() {
        System.out.println("Akademisyenler:");
        for (Instructor akademisyen : akademisyenler) {
            System.out.printf("%s %s %s %s %s %s %s%n", akademisyen.getSicilNo(), akademisyen.getAd(), akademisyen.getSoyad(),
                    akademisyen.getAnabilimDalı(), akademisyen.getEmail(), akademisyen.getTelefon(), akademisyen.getUnvan());
        }
    }

    private static void randevularıListele() {
        System.out.println("Randevular:");
        for (Appointment randevu : randevular) {
            System.out.printf("%s %s %s %s %s%n", randevu.getÖğrenci().getNumara(), randevu.getAkademisyen().getSicilNo(),
                    randevu.getTarih(), randevu.getBaşlangıçSaati(), randevu.getBitişSaati());
        }
    }

    private static void dosyalaraKaydet() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("öğrenci.txt"))) {
            for (Student öğrenci : öğrenciler) {
                writer.write(String.format("%s %s %s %s %d %s %s%n", öğrenci.getNumara(), öğrenci.getAd(),
                        öğrenci.getSoyad(), öğrenci.getBölüm(), öğrenci.getKayıtYılı(), öğrenci.getEmail(), öğrenci.getTelefon()));
            }
        } catch (IOException e) {
            System.out.println("Öğrenci bilgileri kaydedilirken hata oluştu: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("akademisyen.txt"))) {
            for (Instructor akademisyen : akademisyenler) {
                writer.write(String.format("%s %s %s %s %s %s %s%n", akademisyen.getSicilNo(), akademisyen.getAd(),
                        akademisyen.getSoyad(), akademisyen.getAnabilimDalı(), akademisyen.getEmail(), akademisyen.getTelefon(), akademisyen.getUnvan()));
            }
        } catch (IOException e) {
            System.out.println("Akademisyen bilgileri kaydedilirken hata oluştu: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("randevu.txt"))) {
            for (Appointment randevu : randevular) {
                writer.write(String.format("%s %s %s %s %s%n", randevu.getÖğrenci().getNumara(),
                        randevu.getAkademisyen().getSicilNo(), randevu.getTarih(), randevu.getBaşlangıçSaati(), randevu.getBitişSaati()));
            }
        } catch (IOException e) {
            System.out.println("Randevu bilgileri kaydedilirken hata oluştu: " + e.getMessage());
        }
    }
}