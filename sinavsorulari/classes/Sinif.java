package sinavsorulari.classes;

public class Sinif {
    public static int num = 1000;
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        SinifA a = new SinifA();
        SinifB b = new SinifB(10);
        b.p(num);
        
    }
}
