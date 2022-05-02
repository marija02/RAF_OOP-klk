package paket;

public class Kostim {
    private boolean solisticki;
    private Velicina velicina;

    public Kostim(boolean solisticki, Velicina velicina) {
        this.solisticki = solisticki;
        this.velicina = velicina;
    }

    public void setSolisticki(boolean solisticki) {
        this.solisticki = solisticki;
    }

    public void setVelicina(Velicina velicina) {
        this.velicina = velicina;
    }

    public boolean isSolisticki() {
        return solisticki;
    }

    public Velicina getVelicina() {
        return velicina;
    }
}
