import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Predmet> polozeniPredmeti = new ArrayList<>();
    private int brojIndeksa;
    private int godinaUpisa;
    private List<Integer> upisaneGodine = new ArrayList<>();
    private OznakaPlana plan;

    public Student(int brojIndeksa, int godinaUpisa, OznakaPlana plan) {
        this.brojIndeksa = brojIndeksa;
        this.godinaUpisa = godinaUpisa;
        this.plan = plan;
    }

    public int vratiTrenutnuGodinuStudija(){
        if(upisaneGodine.size() == 0){
            return 0;
        }
        return this.upisaneGodine.get(upisaneGodine.size()-1);
    }

    public boolean jePonovac(){
        int poslednja = vratiTrenutnuGodinuStudija();
        int counter = 0;
        for(Integer godina : upisaneGodine){
            if(godina == poslednja){
                counter++;
            }
        }

        if(counter >= 2){
            return true;
        }
        return false;
    }

    public List<Predmet> getPolozeniPredmeti() {
        return polozeniPredmeti;
    }

    public void setPolozeniPredmeti(List<Predmet> polozeniPredmeti) {
        this.polozeniPredmeti = polozeniPredmeti;
    }

    public int getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(int brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public List<Integer> getUpisaneGodine() {
        return upisaneGodine;
    }

    public void setUpisaneGodine(List<Integer> upisaneGodine) {
        this.upisaneGodine = upisaneGodine;
    }

    public OznakaPlana getPlan() {
        return plan;
    }

    public void setPlan(OznakaPlana plan) {
        this.plan = plan;
    }
}
