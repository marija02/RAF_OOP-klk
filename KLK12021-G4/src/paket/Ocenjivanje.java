package paket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ocenjivanje {
    private List<Ocenjivo> zaOcenjivanje = new ArrayList<>();

    public Ocenjivanje() {

    }

    public void dodaj(Ocenjivo ocenjivo){

    }

    public void ispisRezultata(){
        for(Ocenjivo ocenjivo : zaOcenjivanje){
            System.out.println(ocenjivo);
        }
    }

    public List<Ocenjivo> getZaOcenjivanje() {
        return zaOcenjivanje;
    }

    public void setZaOcenjivanje(List<Ocenjivo> zaOcenjivanje) {
        this.zaOcenjivanje = zaOcenjivanje;
    }


}
