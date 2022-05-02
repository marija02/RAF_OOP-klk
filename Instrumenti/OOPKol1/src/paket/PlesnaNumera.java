package paket;

import java.util.ArrayList;
import java.util.List;

public class PlesnaNumera implements Izvodjenje{
    private String naziv;
    private List<Ucesnik> ucesnici = new ArrayList<>();

    public PlesnaNumera() {
    }

    @Override
    public void dodajUcesnika(Ucesnik ucesnik) {
        ucesnici.add(ucesnik);
    }

    @Override
    public boolean jeMoguceIzvesti() {
        int brojac = 0;
        for(Ucesnik u : ucesnici){
            if(u instanceof Plesac){
                if(((Plesac) u).getUloga().equals("SOLISTA")){
                    brojac++;
                }
            }else if(u instanceof Muzicar){
                if(((Muzicar) u).isVokal()){
                    brojac++;
                }
            }

        }

        if(brojac < 2){
            return true;
        }
        return false;
    }

    @Override
    public void izvedi() {
        System.out.println("Izvodjenje plesne numere "+ this.naziv);
        ispisiUcesnike();
    }

    private void ispisiUcesnike(){
        for(Ucesnik u : ucesnici){
            if (u instanceof Plesac) {
                if(((Plesac) u).getUloga().equals("SOLISTA")){
                    System.out.println(u);
                }
            }
        }

        for(Ucesnik u : ucesnici){
            if(u instanceof Muzicar){
                if(((Muzicar) u).isVokal()){
                    System.out.println(u);
                }
            }
        }


        for(Ucesnik u : ucesnici){
            if(u instanceof Plesac && !((Plesac) u).getUloga().equals("SOLISTA")){
                System.out.println(u);
            }
        }

        for(Ucesnik u : ucesnici){
            if(u instanceof Muzicar && !((Muzicar) u).isVokal()){
                System.out.println(u);
            }
        }
    }

    public boolean proveriKostime(List<Kostim> kostimi){
        boolean moze = true;

        for(Ucesnik u : ucesnici){
            boolean tmp = false;
            for(Kostim k : kostimi){
                if(u instanceof Plesac){
                    if(((Plesac) u).getUloga().equals("SOLISTA")){
                        if(k.isSolisticki() && k.getVelicina().equals(((Plesac) u).getVelicina())){
                            tmp = true;
                        }
                    }else{
                        if(k.getVelicina().equals(((Plesac) u).getVelicina()) && !k.isSolisticki()){
                            tmp = true;
                        }
                    }
                }
            }

            if(!tmp){
                moze = false;
            }
        }

        return moze;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setUcesnici(List<Ucesnik> ucesnici) {
        this.ucesnici = ucesnici;
    }

    public String getNaziv() {
        return naziv;
    }

    public List<Ucesnik> getUcesnici() {
        return ucesnici;
    }
}
