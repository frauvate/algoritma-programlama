package sinavsorulari.circle;
public class CemberYakala {
    private double yaricap;
    private static int nesnesayisi = 0;
    public CemberYakala() {
        this(1.0);
    }

    public CemberYakala(double yeniYaricap) {
        setYaricap(yeniYaricap);
        nesnesayisi++;
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yeniYaricap) throws IllegalArgumentException {
            if (yeniYaricap >= 0) {
                yaricap = yeniYaricap;
            } else {
                throw new java.lang.IllegalArgumentException("yaricap negatif olamaz");
            }
    }

    public static int getNesnesayisi() {
        return nesnesayisi;
    }

    public double getHesap() {
        return yaricap * yaricap * 3.14;
    }
}
