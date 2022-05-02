package paket;

import java.util.ArrayList;
import java.util.List;

public class Predstava {
    private static List<Izvodjenje> izvodjenja = new ArrayList<>();
    private static List<Kostim> kostimi = new ArrayList<>();

    public static boolean izvedi(){
        for(Izvodjenje izvodjenje: izvodjenja){
            if(!izvodjenje.jeMoguceIzvesti()){
                System.out.println("1");
                return false;
            }
            if(izvodjenje instanceof PlesnaNumera){
                if(!((PlesnaNumera) izvodjenje).proveriKostime(kostimi)){
                    System.out.println("2");
                    return false;
                }
            }
        }

        for(int i =0; i<izvodjenja.size()-1; i++){

            if(izvodjenja.get(i).getClass() == izvodjenja.get(i+1).getClass()){
                System.out.println("3");

                return false;
            }

            /// 1,3,4,5,6
            if(izvodjenja.get(i) instanceof PlesnaNumera){
                if(izvodjenja.get(i+1) instanceof MuzickaNumera){
                    for(Ucesnik u : ((PlesnaNumera) izvodjenja.get(i)).getUcesnici()){
                        for(Ucesnik u1 : ((MuzickaNumera) izvodjenja.get(i+1)).getUcesnici()){
                            if(u.equals(u1)){
                                System.out.println("4");

                                return false;
                            }
                        }
                    }
                }

            }else if(izvodjenja.get(i) instanceof MuzickaNumera){
                 if(izvodjenja.get(i+1) instanceof PlesnaNumera){
                    for(Ucesnik u : ((MuzickaNumera) izvodjenja.get(i)).getUcesnici()){
                        for(Ucesnik u1 : ((PlesnaNumera) izvodjenja.get(i+1)).getUcesnici()){
                            if(u.equals(u1)){
                                System.out.println("5");

                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Ucesnik u1 = KreiranjeUcesnika.napraviUcesnika("P Petar L");
        Ucesnik u2 = KreiranjeUcesnika.napraviUcesnika("P Aca XL solista");

        Ucesnik u3 = KreiranjeUcesnika.napraviUcesnika("M Pavle PEVAC GITARISTA");
        Ucesnik u4 = KreiranjeUcesnika.napraviUcesnika("M Masa PIJANISTA"); // VIOLINISTA BUBNJAR
        Ucesnik u5 = KreiranjeUcesnika.napraviUcesnika("M Nikola VIOLINISTA"); // VIOLINISTA BUBNJAR
        Ucesnik u6 = KreiranjeUcesnika.napraviUcesnika("M Marija BUBNJAR"); // VIOLINISTA BUBNJAR

        KreiranjeUcesnika.br = 4;


        Predstava p = new Predstava();

        PlesnaNumera pn1 = new PlesnaNumera();
        PlesnaNumera pn2 = new PlesnaNumera();
        PlesnaNumera pn3 = new PlesnaNumera();

        MuzickaNumera mn1 = new MuzickaNumera();
        MuzickaNumera mn2 = new MuzickaNumera();

        p.izvodjenja.add(pn1);
        p.izvodjenja.add(mn1);
        p.izvodjenja.add(pn2);
        p.izvodjenja.add(mn2);
        p.izvodjenja.add(pn3);

        pn1.dodajUcesnika(u1);
        pn1.dodajUcesnika(u2);

        mn1.dodajUcesnika(u3);
        mn1.dodajUcesnika(u4);
        mn1.dodajUcesnika(u5);
        mn1.dodajUcesnika(u6);

        pn2.dodajUcesnika(u1);
        pn2.dodajUcesnika(u2);

        mn2.dodajUcesnika(u3);
        mn2.dodajUcesnika(u4);
        mn2.dodajUcesnika(u5);
        mn2.dodajUcesnika(u6);

        Kostim k1 = new Kostim(true, Velicina.XL);
        Kostim k2 = new Kostim(false, Velicina.L);

        kostimi.add(k1);
        kostimi.add(k2);

        if(izvedi()){
            System.out.println("Uspesno izvodjenje predstave");
        }else{
            System.out.println("Neuspesno.");
        }
    }
}
