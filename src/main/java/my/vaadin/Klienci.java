package my.vaadin;

public class Klienci {
    private int id;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String email;
    private String haslo;
    private String dataUrodzenia;
    private String ulica;
    private String nrDomu;
    private String miejscowosc;
    private String kod;
    private String pocztowy;

    public Klienci(int id, String imie, String nazwisko, String pesel, String email, String haslo, String dataUrodzenia, String ulica, String nrDomu, String miejscowosc, String kod, String pocztowy) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.email = email;
        this.haslo = haslo;
        this.dataUrodzenia = dataUrodzenia;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.miejscowosc = miejscowosc;
        this.kod = kod;
        this.pocztowy = pocztowy;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getPocztowy() {
        return pocztowy;
    }

    public void setPocztowy(String pocztowy) {
        this.pocztowy = pocztowy;
    }
}
