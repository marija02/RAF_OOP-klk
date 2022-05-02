package paket;

import java.util.ArrayList;
import java.util.List;

public class ResenjeTesta implements Ocenjivo{

    private List<Odgovor> odgovori = new ArrayList<>();
    private String nazivTesta;
    private String kandidat;
    private Ocena ocena;

    public ResenjeTesta(String nazivTesta, String kandidat) {
        this.nazivTesta = nazivTesta;
        this.kandidat = kandidat;
    }

    @Override
    public int oceni() {
        int zbir = 0;
        for(Odgovor odgovor : odgovori){
            zbir += odgovor.oceni();
        }

        this.ocena = new Ocena(zbir);

        return zbir;
    }

    public void odgovori(Pitanje pitanje, String odgovor){

    }

    public List<Odgovor> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(List<Odgovor> odgovori) {
        this.odgovori = odgovori;
    }

    public String getNazivTesta() {
        return nazivTesta;
    }

    public void setNazivTesta(String nazivTesta) {
        this.nazivTesta = nazivTesta;
    }

    public String getKandidat() {
        return kandidat;
    }

    public void setKandidat(String kandidat) {
        this.kandidat = kandidat;
    }

    @Override
    public String toString() {
        return  " RESENJE TESTA " + getNazivTesta() + " " + getKandidat() + " " +getOdgovori().size() + " " + oceni() + " ocena: " + ocena.getBroj();

    }
}
