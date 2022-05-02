package paket;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private String naziv;
    private int godina;
    private Zanr zanr;
    private int trajanje;
    private Reziser predstavnik;
    private double rejting;
    private List<Kritika> kritike = new ArrayList<>();
    private List<ClanEkipe> clanoviEkipe = new ArrayList<>();

    public Film(String naziv, int godina, int trajanje, Reziser reziser, Zanr zanr) {
        this.naziv = naziv;
        this.godina = godina;
        this.zanr = zanr;
        this.predstavnik= reziser;
        this.rejting = 0;
        dodajRezisera(reziser);
        if(trajanje <= 0){
            System.out.println("Neispravno trajanje");
        }else{
            this.trajanje = trajanje;
        }
    }

    public boolean dodajGlumca(Glumac glumac){
        if(!clanoviEkipe.contains(glumac)){
            if(zanr== Zanr.MJUZIKL || zanr == Zanr.ANIMIRANI){
                if(glumac.isLepGlas()){
                    clanoviEkipe.add(glumac);
                    return true;
                }
            }else{
                clanoviEkipe.add(glumac);
                return true;
            }
        }

        return false;
    }

    public void dodajRezisera(Reziser reziser){
        if(!clanoviEkipe.contains(reziser)){
            clanoviEkipe.add(reziser);
            reziser.setBrReziranihFilmova(reziser.getBrReziranihFilmova() + 1);
            if(reziser.getDatumRodjenja().before(predstavnik.getDatumRodjenja())){
                predstavnik = reziser;
            }
        }
    }

    @Override
    public String toString() {
        return "Film{" +
                "naziv='" + naziv + '\'' +
                ", zanr=" + zanr +
                ", rejting=" + rejting +
                '}';
    }

    public void primiOskara(){
        this.predstavnik.primiOskara();
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public void setPredstavnik(Reziser predstavnik) {
        this.predstavnik = predstavnik;
    }

    public void setRejting(double rejting) {
        this.rejting = rejting;
    }

    public void setKritike(List<Kritika> kritike) {
        this.kritike = kritike;
    }

    public void setClanoviEkipe(List<ClanEkipe> clanoviEkipe) {
        this.clanoviEkipe = clanoviEkipe;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getGodina() {
        return godina;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public Reziser getPredstavnik() {
        return predstavnik;
    }

    public double getRejting() {
        return rejting;
    }

    public List<Kritika> getKritike() {
        return kritike;
    }

    public List<ClanEkipe> getClanoviEkipe() {
        return clanoviEkipe;
    }
}
