package Examen;

public class Periode {
    private String DateDebut;
    private int horaire;
    private int duree;

    public Periode(String dateDebut, int horaire, int duree) {
        DateDebut = dateDebut;
        this.horaire = horaire;
        this.duree = duree;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(String dateDebut) {
        DateDebut = dateDebut;
    }

    public int getHoraire() {
        return horaire;
    }

    public void setHoraire(int horaire) {
        this.horaire = horaire;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Periode{" +
                "DateDebut='" + DateDebut + '\'' +
                ", horaire=" + horaire +
                ", duree=" + duree +
                '}';
    }
}
