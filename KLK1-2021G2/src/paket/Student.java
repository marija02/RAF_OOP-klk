package paket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Object{
    private List<Predmet> polozeniPredmeti = new ArrayList<>();
    private List<AktivnostStudenta> aktivnosti = new ArrayList<>();

    private String studProgramOznaka;
    private int broj;
    private int godinaUpisa;

    public Student() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return broj == student.broj && godinaUpisa == student.godinaUpisa && Objects.equals(polozeniPredmeti, student.polozeniPredmeti) && Objects.equals(aktivnosti, student.aktivnosti) && Objects.equals(studProgramOznaka, student.studProgramOznaka);
    }

    @Override
    public String toString() {
        return "Student{" +
                "polozeniPredmeti=" + polozeniPredmeti +
                ", aktivnosti=" + aktivnosti +
                ", studProgramOznaka='" + studProgramOznaka + '\'' +
                ", broj=" + broj +
                ", godinaUpisa=" + godinaUpisa +
                '}';
    }

    public boolean dodajAktivnost(AktivnostStudenta aktivnostStudenta){
        if(aktivnostStudenta.proveriUslov(this)){
            aktivnosti.add(aktivnostStudenta);
            aktivnosti.sort(null);
            return true;
        }
        System.out.println("NE VALJA");
        return false;


    }

    public int vratiGodinuStudija(){
        this.aktivnosti.sort(null);

        return aktivnosti.get(aktivnosti.size()-1).getGodinaStudija();
    }

    public boolean jePonovac(){
        this.aktivnosti.sort(null);

        AktivnostStudenta as = aktivnosti.get(aktivnosti.size()-1);

        if(as instanceof ObnovaGodine){
            return true;
        }
        return false;

    }

    public boolean slusaPredmet(Predmet predmet){
        AktivnostStudenta as = aktivnosti.get(aktivnosti.size()-1);

        if(as instanceof UpisGodine){
            if(((UpisGodine) as).getPrenetiPredmeti().contains(predmet)){
                return true;
            }
        }else if(as instanceof ObnovaGodine){
            if(((ObnovaGodine) as).getPredmetiKojeUpisuje().contains(predmet)){
                return true;
            }
        }

        return false;
    }

    public List<Predmet> getPolozeniPredmeti() {
        return polozeniPredmeti;
    }

    public void setPolozeniPredmeti(List<Predmet> polozeniPredmeti) {
        this.polozeniPredmeti = polozeniPredmeti;
    }

    public List<AktivnostStudenta> getAktivnosti() {
        return aktivnosti;
    }

    public void setAktivnosti(List<AktivnostStudenta> aktivnosti) {
        this.aktivnosti = aktivnosti;
    }

    public String getStudProgramOznaka() {
        return studProgramOznaka;
    }

    public void setStudProgramOznaka(String studProgramOznaka) {
        this.studProgramOznaka = studProgramOznaka;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }
}
