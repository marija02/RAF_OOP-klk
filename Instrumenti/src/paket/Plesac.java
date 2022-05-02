package paket;

public class Plesac extends Ucesnik{
    private String uloga;
    private Velicina velicina;

    public Plesac(String ime, Velicina velicina, boolean jeSolista) {
        super(ime);
        if(jeSolista){
            this.uloga = "SOLISTA";
        }else{
            this.uloga = "PRATNJA";
        }
        this.velicina = velicina;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public void setVelicina(Velicina velicina) {
        this.velicina = velicina;
    }

    public String getUloga() {
        return uloga;
    }

    public Velicina getVelicina() {
        return velicina;
    }

    @Override
    public String toString() {
        return "Plesac-<" + this.uloga+">";
    }
}
