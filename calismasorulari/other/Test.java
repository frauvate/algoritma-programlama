package calismasorulari.other;

public class Test {
   public static void main(String[] args) {
    Main6 c1 = new Main6(3, 2);
    Main6 c2 = new Main6(5, 1);

    Main6 sum = Main6.add(c1, c2);
    System.out.println("Toplama: " + sum);

    Main6 difference = Main6.sub(c1, c2);
    System.out.println("Çıkarma: " + difference);

    Main6 quotient = Main6.division(c1, c2);
    System.out.println("Bölme: " + quotient);
   
    Main6 conjugate = c1.conjugate();
    System.out.println("Eşlenik: " + conjugate);

    Main6 multiplied = Main6.multiply(c1, c2);
    System.out.println("Çarpım: " + multiplied);

   } 
}
