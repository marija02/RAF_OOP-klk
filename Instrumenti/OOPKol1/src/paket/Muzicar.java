package paket;

import java.util.ArrayList;
import java.util.List;

public class Muzicar extends Ucesnik{
    private boolean vokal;
    private List<Instrument> instrumenti = new ArrayList<>();

    /// alt + insert
    public Muzicar(String ime, boolean vokal, List<Instrument> instrumenti) {
        super(ime);
        this.vokal = vokal;
        this.instrumenti = instrumenti;
    }

    @Override
    public String toString() {
        String s = "MUZICAR-";
        for(Instrument i : instrumenti){
            switch(i){
                case VIOLINA: s +="VIOLINISTA, "; break;
                case KLAVIR: s += "PIJANISTA, "; break;
                case BUBANJ: s += "BUBNJAR, "; break;
                case GITARA: s += "GITARISTA, "; break;
            }
        }

        if(this.vokal){
            s += "VOKAL";
        }

        return s;
    }

    public void setVokal(boolean vokal) {
        this.vokal = vokal;
    }

    public void setInstrumenti(List<Instrument> instrumenti) {
        this.instrumenti = instrumenti;
    }

    public boolean isVokal() {
        return vokal;
    }

    public List<Instrument> getInstrumenti() {
        return instrumenti;
    }
}
