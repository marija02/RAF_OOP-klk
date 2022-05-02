import java.util.ArrayList;
import java.util.List;

public class IzborniModul implements IzborStudenta{
    private String naziv;
    private List<Predmet> predmeti34 = new ArrayList<>();

    public IzborniModul(String naziv, List<Predmet> predmeti34) {
        this.naziv = naziv;
        this.predmeti34 = predmeti34;
    }

    @Override
    public boolean mozeDaIzabere(Student student) {

        int poeni = 0;
        for(Predmet p : student.getPolozeniPredmeti()){
            poeni += p.getEspb();
        }

        if(
                !student.jePonovac()
                && student.vratiTrenutnuGodinuStudija() == 3
                && poeni >= 50
        ){
            return true;
        }
        return false;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Predmet> getPredmeti34() {
        return predmeti34;
    }

    public void setPredmeti34(List<Predmet> predmeti34) {
        this.predmeti34 = predmeti34;
    }
}
