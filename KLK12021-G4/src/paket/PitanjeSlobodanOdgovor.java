package paket;

import java.util.ArrayList;
import java.util.List;

public class PitanjeSlobodanOdgovor extends Pitanje{

    private List<String> kljucneReci = new ArrayList<>();

    public PitanjeSlobodanOdgovor(String tekstPitanja) {
        super(tekstPitanja);
    }

    @Override
    public int brojPoena(String str) {
        int tacnih= 0;
        String[] odgovori = str.split(" ");
        for(String odgovor : odgovori){
            if(kljucneReci.contains(odgovor)){
                tacnih++;
            }
        }

        return tacnih;
    }

    public List<String> getKljucneReci() {
        return kljucneReci;
    }

    public void setKljucneReci(List<String> kljucneReci) {
        if(kljucneReci.size() == getBrojPoena()){
            this.kljucneReci = kljucneReci;
        }
    }
}
