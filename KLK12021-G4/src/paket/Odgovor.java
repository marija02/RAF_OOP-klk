package paket;

public class Odgovor implements Ocenjivo {
    private Pitanje pitanje;
    private String odgovor;

    public Odgovor(Pitanje pitanje, String odgovor) {
        this.pitanje = pitanje;
        this.odgovor = odgovor;
    }

    public int oceni(){
        return pitanje.brojPoena(odgovor);
    }

    public Pitanje getPitanje() {
        return pitanje;
    }

    public void setPitanje(Pitanje pitanje) {
        this.pitanje = pitanje;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    @Override
    public String toString() {
        return " ODGOVOR " + getPitanje().getTekstPitanja() + " "+ getOdgovor() + " " + getPitanje().getBrojPoena();

    }
}
