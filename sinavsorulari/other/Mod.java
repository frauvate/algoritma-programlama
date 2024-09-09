package sinavsorulari.other;

public class Mod {
    public static int modCount(int [] array) {
        int min = array[0];
        int max = array[0];

        for(int i=0; i<array.length; i++) {
            if(array[i]>max) {
                max = array[i];
            }
        }

        for(int i=0; i<array.length; i++) {
            if(array[i]<min) {
                min = array[i];
            }
        }

        return max-min;
    }

    public static void main(String[] args) {
        int [] array = {5, 1, 4, 8};

        System.out.println(modCount(array));
    }
}
