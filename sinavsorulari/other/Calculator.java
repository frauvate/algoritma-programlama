package sinavsorulari.other;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter number:");
        int num1 = scan.nextInt();
        System.out.print("enter another number:");
        int num2 = scan.nextInt();
        System.out.print("enter 1 for plus, 2 for minus:");
        int secim = scan.nextInt();

        switch(secim) {
            case 1:
            toplam(num1, num2);
            break;
            case 2:
            fark(num1, num2);
            break;
        }
        scan.close();
    }

    public static void toplam(int a, int b) {
        int toplam = a+b;
        System.out.println(a + " + " + b + " = " + toplam);
    }

    public static void fark(int a, int b) {
        if(a>b) {
            int fark = a-b;
            System.out.println(a + " - " + b + " = " + fark);
        } else {
            int fark = b-a;
            System.out.println(b + " - " + a + " = " + fark);
        }
    }

}