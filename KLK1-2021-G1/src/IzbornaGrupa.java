import java.util.ArrayList;
import java.util.List;

public class IzbornaGrupa implements IzborStudenta{
    private String oznaka;
    private List<IzborniPredmet> predmeti = new ArrayList<>();
    private OznakaPlana plan;

    public boolean dodajPredmet(IzborniPredmet izborniPredmet){
        int godinaStudijaGrupe = Integer.parseInt(oznaka.charAt(0) + "");

        if(izborniPredmet.getOznakaPlana().equals(this.plan)){
            boolean moze = false;

            switch (godinaStudijaGrupe){
                case 1: if(izborniPredmet.getSemestar() == 1 || izborniPredmet.getSemestar() == 2){moze = true;}break;
                case 2: if(izborniPredmet.getSemestar() == 3 || izborniPredmet.getSemestar() == 4){moze = true;}break;
                case 3: if(izborniPredmet.getSemestar() == 5 || izborniPredmet.getSemestar() == 6){moze = true;}break;
                case 4: if(izborniPredmet.getSemestar() == 7 || izborniPredmet.getSemestar() == 8){moze = true;}break;
            }

            if(moze){
                if(!predmeti.contains(izborniPredmet)){
                    predmeti.add(izborniPredmet);
                    return true;
                }
            }
        }
        return false;

    }

    public IzbornaGrupa() {
    }

    @Override
    public boolean mozeDaIzabere(Student student) {
        if (!student.jePonovac() && Integer.parseInt(oznaka.charAt(0) + "") == student.vratiTrenutnuGodinuStudija() &&
            student.getPlan().equals(plan) ){

            for(Predmet predmet : predmeti){
                for(Predmet preduslov : predmet.getPreduslovi()){
                    if(!student.getPolozeniPredmeti().contains(preduslov)){
                        return false;
                    }
                }
            }
            return true;

        }
        return false;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public List<IzborniPredmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<IzborniPredmet> predmeti) {
        this.predmeti = predmeti;
    }

    public OznakaPlana getPlan() {
        return plan;
    }

    public void setPlan(OznakaPlana plan) {
        this.plan = plan;
    }
}
