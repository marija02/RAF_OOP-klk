package paket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MuzickaNumera implements Izvodjenje{

    private List<Ucesnik> ucesnici = new ArrayList<>();

    @Override
    public void dodajUcesnika(Ucesnik ucesnik) {
        if(ucesnik instanceof Muzicar){
            ucesnici.add(ucesnik);
        }
    }

    @Override
    public boolean jeMoguceIzvesti() {

        int brVokala = 0;
        int bubnjari = 0;

        Instrument i1 = null, i2 = null;
        for(Ucesnik u : ucesnici){
            if(u instanceof Muzicar){
                if(((Muzicar) u).isVokal()){
                    brVokala++;
                }
                if(((Muzicar) u).getInstrumenti().contains(Instrument.BUBANJ)){
                    bubnjari++;
                }

                for(Instrument i : ((Muzicar) u).getInstrumenti()){
                    if(i1 == null && i!=Instrument.BUBANJ){
                        i1 = i;
                        break;
                    }else if(i != Instrument.BUBANJ && i!=i1){
                        i2 = i;
                    }
                }
            }
        }

        if(brVokala == 0 || bubnjari != 1 || i1 == null || i2 == null){
            return false;
        }
        return true;


    }

    @Override
    public void izvedi() {
        System.out.println("Izvodjenje muzicke numere");

        ucesnici.sort(Comparator.comparing(Ucesnik::getIme));

        ///System.out.println(ucesnici);
        for(Ucesnik u : ucesnici){
            System.out.println(u);
        }

    }
}
