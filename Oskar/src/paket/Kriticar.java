package paket;

public class Kriticar {
    private String ime;
    private String prezime;
    private double reputacija;

    public Kriticar(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
        this.reputacija = 1;
    }

    public void pohvali(Kriticar kriticar){
        kriticar.setReputacija(kriticar.getReputacija() + this.reputacija*0.1);
        if(kriticar.getReputacija() > 100){
            kriticar.setReputacija(100);
        }
    }

    public void oceniFilm(Film film, Kritika kritika){
        film.getKritike().add(kritika);
        double zbir = 0;
        for(Kritika k : film.getKritike()){
            zbir += k.getOcena();
        }

        film.setRejting(zbir/film.getKritike().size());
    }
    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setReputacija(double reputacija) {
        this.reputacija = reputacija;
    }

    public double getReputacija() {
        return reputacija;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }


}
