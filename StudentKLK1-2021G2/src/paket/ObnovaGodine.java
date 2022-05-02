package paket;

import java.util.ArrayList;
import java.util.List;

public class ObnovaGodine extends AktivnostStudenta{
    private int godinaObnove;
    private List<Predmet> predmetiKojeUpisuje = new ArrayList<>();

    public ObnovaGodine(int godina, int mesec, int dan) {
        super(godina, mesec, dan);
    }

    @Override
    public int getGodinaStudija() {
        return godinaObnove;
    }

    @Override
    public boolean proveriUslov(Student student) {
        AktivnostStudenta poslednjaAktivnost = student.getAktivnosti().get(student.getAktivnosti().size()-1);
        if(poslednjaAktivnost.getGodinaStudija() == godinaObnove){
            return true;
        }
        return false;
    }

    public int getGodinaObnove() {
        return godinaObnove;
    }

    public void setGodinaObnove(int godinaObnove) {
        this.godinaObnove = godinaObnove;
    }

    public List<Predmet> getPredmetiKojeUpisuje() {
        return predmetiKojeUpisuje;
    }

    public void setPredmetiKojeUpisuje(List<Predmet> predmetiKojeUpisuje) {
        this.predmetiKojeUpisuje = predmetiKojeUpisuje;
    }
}
