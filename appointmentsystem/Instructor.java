package appointmentsystem;

class Instructor {
    private String sicilNo;
    private String ad;
    private String soyad;
    private String anabilimDalı;
    private String email;
    private String telefon;
    private String unvan;

    // Constructor ve getter/setter metotları
    public Instructor(String sicilNo, String ad, String soyad, String anabilimDalı, String email, String telefon, String unvan) {
        this.sicilNo = sicilNo;
        this.ad = ad;
        this.soyad = soyad;
        this.anabilimDalı = anabilimDalı;
        this.email = email;
        this.telefon = telefon;
        this.unvan = unvan;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getAnabilimDalı() {
        return anabilimDalı;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getUnvan() {
        return unvan;
    }
}