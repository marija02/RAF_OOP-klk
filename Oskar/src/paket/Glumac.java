package paket;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Glumac extends ClanEkipe{

    private boolean lepGlas;

    public Glumac(String ime, String prezime, Date datumRodjenja, Pol pol) {
        super(ime, prezime, datumRodjenja, pol);
        Random r = new Random();
        int br = r.nextInt(2);
        if(br == 0){
            lepGlas = false;
        }else{
            lepGlas = true;
        }
    }

    @Override
    public void odrziGovor() {
        System.out.println("Primam oskara");
    }

    @Override
    public void predstavi() {

    }

    @Override
    public void primiOskara() {
        Random r = new Random();
        double br = r.nextDouble();
        if(br > 0.1){
            odrziGovor();
        }
    }

    @Override
    public void pripremiGovor() {

    }

    @Override
    public String toString() {
        return "Glumac{" +
                "lepGlas=" + lepGlas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Glumac)) return false;
        Glumac glumac = (Glumac) o;
        return lepGlas == glumac.lepGlas && this.getIme().equals(((Glumac) o).getIme());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lepGlas);
    }

    public boolean isLepGlas() {
        return lepGlas;
    }
}
