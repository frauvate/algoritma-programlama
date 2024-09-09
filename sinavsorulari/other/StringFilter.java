package sinavsorulari.other;


/* kendisine parametre olarak iki boyutlu string 
dizisi alan ve bunlardan ilk harfinde a olan 
stringleri geri döndüren metod */
import java.util.ArrayList;

public class StringFilter {

    public static String[] getStringsStartingWithA(String[][] strings) {
        // A ile başlayan stringleri depolamak için liste
        ArrayList<String> result = new ArrayList<>();

        // İki boyutlu dizinin üzerinde gezerek elemanları kontrol etme
        for (String[] row : strings) {
            for (String str : row) {
                if (str != null && !str.isEmpty() && str.charAt(0) == 'a') {
                    result.add(str);
                }
            }
        }

        // Listeyi diziye dönüştürerek geri döndürme
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[][] strings = {
            {"apple", "banana", "avocado"},
            {"pear", "apricot", "grape"},
            {"melon", "kiwi", "ananas"}
        };

        String[] filteredStrings = getStringsStartingWithA(strings);

        // Sonuçları ekrana yazdırma
        for (String str : filteredStrings) {
            System.out.println(str);
        }
    }
}
