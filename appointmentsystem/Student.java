package appointmentsystem;

class Student {
    private String numara;
    private String ad;
    private String soyad;
    private String bölüm;
    private int kayıtYılı;
    private String email;
    private String telefon;

    // Constructor ve getter/setter metotları
    public Student(String numara, String ad, String soyad, String bölüm, int kayıtYılı, String email, String telefon) {
        this.numara = numara;
        this.ad = ad;
        this.soyad = soyad;
        this.bölüm = bölüm;
        this.kayıtYılı = kayıtYılı;
        this.email = email;
        this.telefon = telefon;
    }

    public String getNumara() {
        return numara;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getBölüm() {
        return bölüm;
    }

    public int getKayıtYılı() {
        return kayıtYılı;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }
}