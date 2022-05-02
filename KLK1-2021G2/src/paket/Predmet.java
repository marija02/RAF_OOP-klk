package paket;

public class Predmet {
    private String naziv;
    private int espb;
    private int semestar;

    public Predmet(String naziv, int espb, int semestar) {
        this.naziv = naziv;
        this.espb = espb;
        this.semestar = semestar;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getEspb() {
        return espb;
    }

    public int getSemestar() {
        return semestar;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "naziv='" + naziv + '\'' +
                ", espb=" + espb +
                ", semestar=" + semestar +
                '}';
    }
}
