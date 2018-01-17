package my.vaadin;

public class Sklepy {

    private int idSklepu;
    private String miejscowosc;
    private String ulica;
    private int nrBudynku;
    private String kodPocztowy;

    public Sklepy(int idSklepu, String miejscowosc, String ulica, int nrBudynku, String kodPocztowy) {
        this.idSklepu = idSklepu;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrBudynku = nrBudynku;
        this.kodPocztowy = kodPocztowy;
    }

    public int getIdSklepu() {
        return idSklepu;
    }

    public void setIdSklepu(int idSklepu) {
        this.idSklepu = idSklepu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(int nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
