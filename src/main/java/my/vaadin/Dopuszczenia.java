package my.vaadin;

public class Dopuszczenia {
    private int idDopuszczenia;
    private String dataDopuszczenia;
    private String dataWycofania;
    int idAnkiety;
    int idSklepu;

    public Dopuszczenia(int idDopuszczenia, String dataDopuszczenia, String dataWycofania, int idAnkiety, int idSklepu) {
        this.idDopuszczenia = idDopuszczenia;
        this.dataDopuszczenia = dataDopuszczenia;
        this.dataWycofania = dataWycofania;
        this.idAnkiety = idAnkiety;
        this.idSklepu = idSklepu;
    }

    public int getIdDopuszczenia() {
        return idDopuszczenia;
    }

    public void setIdDopuszczenia(int idDopuszczenia) {
        this.idDopuszczenia = idDopuszczenia;
    }

    public String getDataDopuszczenia() {
        return dataDopuszczenia;
    }

    public void setDataDopuszczenia(String dataDopuszczenia) {
        this.dataDopuszczenia = dataDopuszczenia;
    }

    public String getDataWycofania() {
        return dataWycofania;
    }

    public void setDataWycofania(String dataWycofania) {
        this.dataWycofania = dataWycofania;
    }

    public int getIdAnkiety() {
        return idAnkiety;
    }

    public void setIdAnkiety(int idAnkiety) {
        this.idAnkiety = idAnkiety;
    }

    public int getIdSklepu() {
        return idSklepu;
    }

    public void setIdSklepu(int idSklepu) {
        this.idSklepu = idSklepu;
    }
}
