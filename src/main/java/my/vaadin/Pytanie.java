package my.vaadin;

import java.io.Serializable;

public class Pytanie implements Serializable {
    private int idPytania;
    private String tresc;

    public Pytanie(int idPytania, String tresc) {
        this.idPytania = idPytania;
        this.tresc = tresc;
    }

    public int getIdPytania() {
        return idPytania;
    }

    public void setIdPytania(int idPytania) {
        this.idPytania = idPytania;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    @Override
    public String toString() {
        return idPytania + ". " + tresc;
    }
}
