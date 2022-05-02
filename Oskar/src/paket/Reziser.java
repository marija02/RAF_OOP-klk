package paket;

import java.util.Date;
import java.util.Objects;

public class Reziser extends ClanEkipe{

    private int brReziranihFilmova;

    public Reziser(String ime, String prezime, Date datumRodjenja, Pol pol) {
        super(ime, prezime, datumRodjenja, pol);
        this.brReziranihFilmova = 0;
    }

    @Override
    public void odrziGovor() {
        System.out.println("Reziser prima oskara");
    }

    public void povecajFilmove(){
        this.brReziranihFilmova++;
    }

    @Override
    public void predstavi() {

    }

    @Override
    public void primiOskara() {
        odrziGovor();
    }

    @Override
    public void pripremiGovor() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reziser)) return false;
        Reziser reziser = (Reziser) o;
        return brReziranihFilmova == reziser.brReziranihFilmova;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brReziranihFilmova);
    }

    public int getBrReziranihFilmova() {
        return brReziranihFilmova;
    }

    public void setBrReziranihFilmova(int brReziranihFilmova) {
        this.brReziranihFilmova = brReziranihFilmova;
    }
}
