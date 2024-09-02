/* Soru 3:
Bir öğrenci sınıfı oluşturun (Student), bu sınıf öğrencinin adı, 
numarası ve notlarını tutmalıdır. Sınıf, öğrencinin not ortalamasını hesaplayan 
ve öğrencinin geçtiğini veya kaldığını (60 ortalamaya göre) belirten bir metot 
içermelidir. Öğrencinin bilgilerini ve notlarını içeren bir metin dosyasını okuyup 
bu bilgileri Student nesnelerine dönüştüren ve öğrencilerin sonuçlarını ekrana 
yazdıran bir program yazınız. */

package calismasorulari.fileclass;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main7 {
    String name;
    int stuno;
    int score1, score2, score3;

    public Main7(String name, int stuno, int score1, int score2, int score3) {
        this.name = name;
        this.stuno = stuno;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    private static Main7[] addStudent(Main7[] students, Main7 studentToAdd) {
        Main7[] newStudents = new Main7[students.length + 1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[newStudents.length - 1] = studentToAdd;

        return newStudents;
    }

    public static double average(Main7 s1) {
        return (s1.score1 + s1.score2 + s1.score3) / 3.0;
    }

    public static boolean isPass(Main7 s1) {
        return average(s1) >= 60;
    }

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(new File("list.txt"));

            Main7[] students = new Main7[0];
            int studentCount = 0;  // Eklenen öğrenci sayısını takip etmek için

            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                String[] parts = line.split("\\s+");

                if (parts.length == 5) {
                    String name = parts[0];
                    int stuno = Integer.parseInt(parts[1]);
                    int score1 = Integer.parseInt(parts[2]);
                    int score2 = Integer.parseInt(parts[3]);
                    int score3 = Integer.parseInt(parts[4]);

                    Main7 student = new Main7(name, stuno, score1, score2, score3);
                    students = addStudent(students, student);
                    studentCount++;  // Her öğrenci eklendiğinde sayıyı artır

                    System.out.println("Added student: " + name);  // Hangi öğrenci eklendiğini görmek için
                }
            }

            input.close();

            System.out.println("Total students added: " + studentCount);  // Toplam eklenen öğrenci sayısını yazdır

            for (Main7 student : students) {
                System.out.println("Name: " + student.name + ", Student No: " + student.stuno +
                        ", Scores: " + student.score1 + ", " + student.score2 + ", " + student.score3);
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number format error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
