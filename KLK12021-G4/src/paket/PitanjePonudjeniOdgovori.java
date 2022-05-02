package paket;

import java.util.ArrayList;
import java.util.List;

public class PitanjePonudjeniOdgovori extends Pitanje{

    private List<String> ponudjeniOdgovori = new ArrayList<>();
    private List<Integer> indeksiTacnih = new ArrayList<>();

    public PitanjePonudjeniOdgovori(String tekstPitanja) {
        super(tekstPitanja);
        dodajPonudjeniOdgovor("Jabuka", false);
        dodajPonudjeniOdgovor("Jabuka", false);

    }

    @Override
    public int brojPoena(String str) {
        int tacnih= 0;
        String[] odgovori = str.split(",");
        for(String odgovor : odgovori){
            if(ponudjeniOdgovori.contains(odgovor)){
                tacnih++;
            }
        }

        return tacnih;
    }

    public void dodajPonudjeniOdgovor(String odgovor, boolean tacan){
        if(!ponudjeniOdgovori.contains(odgovor) && indeksiTacnih.size() < getBrojPoena()){
            ponudjeniOdgovori.add(odgovor);
            if(tacan){
                indeksiTacnih.add(ponudjeniOdgovori.indexOf(odgovor));
            }
        }

    }

    public List<String> getPonudjeniOdgovori() {
        return ponudjeniOdgovori;
    }

    public void setPonudjeniOdgovori(List<String> ponudjeniOdgovori) {
        this.ponudjeniOdgovori = ponudjeniOdgovori;
    }

    public List<Integer> getIndeksiTacnih() {
        return indeksiTacnih;
    }

    public void setIndeksiTacnih(List<Integer> indeksiTacnih) {
        this.indeksiTacnih = indeksiTacnih;
    }
}
