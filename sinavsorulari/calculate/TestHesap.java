package sinavsorulari.calculate;

public class TestHesap {
   public static void main(String[] args) {
    System.out.println(Hesap.kareAl(9));
    System.out.println(Hesap.kupAl(8));
    System.out.println(Hesap.karekokAl(10000));
    System.out.println(Hesap.karekokAl(Hesap.hesapKatsayi));
    Hesap hesap1 = new Hesap();
    Hesap hesap2 = new Hesap();
    System.out.println(Hesap.karekokAl(hesap2.hesapKatsayi));
    Hesap hesap3 = new Hesap();
    Hesap hesap4 = new Hesap();
    System.out.println(Hesap.karekokAl(Hesap.hesapKatsayi));
    System.out.println(Hesap.karekokAl(hesap3.hesapKatsayi));
   } 
}
