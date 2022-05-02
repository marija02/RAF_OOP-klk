package paket;


import java.util.ArrayList;
import java.util.List;

public class KreiranjeUcesnika {
    public static int br = 5;
    public static Ucesnik napraviUcesnika(String string){
        if(string.charAt(0) == 'P'){
            String input[] = string.split(" ");
            boolean jeSolista = false;
            if(input.length > 3){
                jeSolista = true;
            }
            Plesac p = new Plesac(input[1], Velicina.valueOf(input[2]), jeSolista);
            return p;
        }else if(string.charAt(0) == 'M'){
            String input[] = string.split(" ");

            List<Instrument> instrumenti = new ArrayList<>();

            boolean vokal = false;
            for(String str : input){
                if(str.equals("PEVAC")){
                    vokal = true;
                }
                /// M Marija BUBNJAR
                if(str.equals("BUBNJAR")){
                    instrumenti.add(Instrument.BUBANJ);
                }
                if(str.equals("GITARISTA")){
                    instrumenti.add(Instrument.GITARA);
                }

                if(str.equals("PIJANISTA")){
                    instrumenti.add(Instrument.KLAVIR);
                }

                if(str.equals("VIOLINISTA")){
                    instrumenti.add(Instrument.VIOLINA);
                }
            }

            Muzicar m = new Muzicar(input[1], vokal, instrumenti);
            return m;
        }else{
            System.out.println("GRESKA");
            return null;
        }
    }
}
