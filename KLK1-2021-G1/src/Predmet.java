import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Predmet {

    private List<Predmet> preduslovi = new ArrayList<>();
    private String naziv;
    private int semestar;
    private int espb;
    private OznakaPlana oznakaPlana;

    public Predmet(String naziv, int semestar, int espb, OznakaPlana oznakaPlana) {
        this.naziv = naziv;
        this.semestar = semestar;
        this.espb = espb;
        this.oznakaPlana = oznakaPlana;
    }

    public void dodajPreduslov(Predmet predmet){
        if(predmet.getOznakaPlana().equals(this.oznakaPlana)){
            if(predmet.getSemestar() < this.semestar){
                preduslovi.add(predmet);
            }
        }
    }

    public List<Predmet> getPreduslovi() {
        return preduslovi;
    }

    public void setPreduslovi(List<Predmet> preduslovi) {
        this.preduslovi = preduslovi;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public OznakaPlana getOznakaPlana() {
        return oznakaPlana;
    }

    public void setOznakaPlana(OznakaPlana oznakaPlana) {
        this.oznakaPlana = oznakaPlana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predmet predmet = (Predmet) o;
        return semestar == predmet.semestar && espb == predmet.espb && Objects.equals(preduslovi, predmet.preduslovi) && Objects.equals(naziv, predmet.naziv) && oznakaPlana == predmet.oznakaPlana;
    }


}
