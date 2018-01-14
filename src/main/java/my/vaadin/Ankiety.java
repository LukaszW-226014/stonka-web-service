package my.vaadin;

import java.io.Serializable;

public class Ankiety implements Serializable {
    private int idAnkiety;
    private String tytul;
    private  String opis;

    public Ankiety(int idAnkiety, String tytul, String opis) {
        this.idAnkiety = idAnkiety;
        this.tytul = tytul;
        this.opis = opis;
    }


    public int getIdAnkiety() {
        return idAnkiety;
    }

    public void setIdAnkiety(int idAnkiety) {
        this.idAnkiety = idAnkiety;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return idAnkiety + " " + tytul + " " + opis;
    }
}
