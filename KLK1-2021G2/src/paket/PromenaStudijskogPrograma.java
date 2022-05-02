package paket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromenaStudijskogPrograma extends AktivnostStudenta{
    private String studProgramOznaka;
    private int godinaUpisa;
    private int broj;

    private List<Predmet> prenetiPredmeti = new ArrayList<>();

    public PromenaStudijskogPrograma(int godina, int mesec, int dan, String studProgramOznaka, int godinaUpisa, int broj, List<Predmet> prenetiPredmeti) {
        super(godina, mesec, dan);
        this.studProgramOznaka = studProgramOznaka;
        this.godinaUpisa = godinaUpisa;
        this.broj = broj;
        this.prenetiPredmeti = prenetiPredmeti;
    }

    @Override
    public int getGodinaStudija() {
        return 0;
    }

    @Override
    public boolean proveriUslov(Student student) {
        int ukupnoESPB = 0;
        for(Predmet p : student.getPolozeniPredmeti()){
            ukupnoESPB += p.getEspb();
        }
        AktivnostStudenta poslednjaAktivnost = student.getAktivnosti().get(student.getAktivnosti().size()-1);

        if(ukupnoESPB >= 48){
            student.setGodinaUpisa(godinaUpisa);
            student.setBroj(broj);
            student.setStudProgramOznaka(studProgramOznaka);

            Date date = new Date();

            UpisGodine upisGodine = new UpisGodine(date.getYear(), date.getMonth(), date.getDay(), godinaUpisa);
            upisGodine.setPrenetiPredmeti(prenetiPredmeti);

            if(poslednjaAktivnost instanceof UpisGodine){
                upisGodine.setGodinaKojuUpisuje(((UpisGodine) poslednjaAktivnost).getGodinaKojuUpisuje() +1);
            }else if(poslednjaAktivnost instanceof ObnovaGodine){
                upisGodine.setGodinaKojuUpisuje(((ObnovaGodine) poslednjaAktivnost).getGodinaObnove()+1);
            }

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " " + godinaUpisa + " " + studProgramOznaka + " " + broj;
    }
}
