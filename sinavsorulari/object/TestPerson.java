package sinavsorulari.object;

public class TestPerson {
    public static void main(String[] args) {
        Person kisi1 = new Person("Code Knight", 9000.0, 101);
        Person kisi2 = new Person("Code Warrior", 7000.0, 102);
        kisi1.bilgiGoster();
        kisi2.bilgiGoster();
    }
}
