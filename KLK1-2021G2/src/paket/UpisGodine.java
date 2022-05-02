package paket;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UpisGodine extends AktivnostStudenta{

    private int godinaKojuUpisuje;
    private List<Predmet> prenetiPredmeti = new ArrayList<>();

    public UpisGodine(int godina, int mesec, int dan, int godinaUpisa) {
        super(godina, mesec, dan);
        this.godinaKojuUpisuje = godinaUpisa;
//        this.prenetiPredmeti = new ArrayList<>();
    }

    @Override
    public int getGodinaStudija() {
        return godinaKojuUpisuje;
    }

    @Override
    public boolean proveriUslov(Student student) {
        if(godinaKojuUpisuje == 1){
            return true;
        }
        int ukupnoESPB = 0;
        for(Predmet p : student.getPolozeniPredmeti()){
            ukupnoESPB += p.getEspb();
        }

        if(student.getAktivnosti().size() > 0){
            AktivnostStudenta poslednjaAktivnost = student.getAktivnosti().get(student.getAktivnosti().size()-1);
            if(poslednjaAktivnost instanceof ObnovaGodine){
                if(godinaKojuUpisuje - poslednjaAktivnost.getGodinaStudija() != 1 ){
                    return false;
                }
            }else{
                if(godinaKojuUpisuje - poslednjaAktivnost.getGodinaStudija() != 1){

                    return false;
                }

            }

        }else{

            return false;
        }

        if(godinaKojuUpisuje == 2 && ukupnoESPB >= 30){
            return true;
        }else if (godinaKojuUpisuje == 3 && ukupnoESPB >= 90){
            return true;
        }else if(godinaKojuUpisuje == 4 && ukupnoESPB >=150){
            return true;
        }
        return false;
    }

    public int getGodinaKojuUpisuje() {
        return godinaKojuUpisuje;
    }

    public void setGodinaKojuUpisuje(int godinaKojuUpisuje) {
        this.godinaKojuUpisuje = godinaKojuUpisuje;
    }

    public List<Predmet> getPrenetiPredmeti() {
        return prenetiPredmeti;
    }

    public void setPrenetiPredmeti(List<Predmet> prenetiPredmeti) {
        this.prenetiPredmeti = prenetiPredmeti;
    }

    @Override
    public String toString() {
        return super.toString()  +godinaKojuUpisuje +"";
    }
}
