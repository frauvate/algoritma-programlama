package sinavsorulari.object;

public class Person {
    private int sicilNo;
    private String adSoyad;
    private double maas;

    public Person(String a, double m, int s) {
        this.sicilNo = s;
        this.adSoyad = a;
        this.maas = m;
    }

    void bilgiGoster() {
        System.out.println(adSoyad + " " + maas + " " + sicilNo);
    }
}
