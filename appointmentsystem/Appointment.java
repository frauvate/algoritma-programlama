package appointmentsystem;

class Appointment {
    private Student öğrenci;
    private Instructor akademisyen;
    private String tarih;
    private String başlangıçSaati;
    private String bitişSaati;

    // Constructor ve getter/setter metotları
    public Appointment(Student öğrenci, Instructor akademisyen, String tarih, String başlangıçSaati, String bitişSaati) {
        this.öğrenci = öğrenci;
        this.akademisyen = akademisyen;
        this.tarih = tarih;
        this.başlangıçSaati = başlangıçSaati;
        this.bitişSaati = bitişSaati;
    }

    public Student getÖğrenci() {
        return öğrenci;
    }

    public Instructor getAkademisyen() {
        return akademisyen;
    }

    public String getTarih() {
        return tarih;
    }

    public String getBaşlangıçSaati() {
        return başlangıçSaati;
    }

    public String getBitişSaati() {
        return bitişSaati;
    }
}
