public class IzborniPredmet extends Predmet implements IzborStudenta{


    public IzborniPredmet(String naziv, int semestar, int espb, OznakaPlana oznakaPlana) {
        super(naziv, semestar, espb, oznakaPlana);
    }

    @Override
    public boolean mozeDaIzabere(Student student) {
        if(student.jePonovac() || !student.getPolozeniPredmeti().contains(this) ||
        student.getPlan().equals(this.getOznakaPlana())){
            int godStudija = student.getUpisaneGodine().get(student.getUpisaneGodine().size()-1);
            switch (godStudija){
                case 1: if(this.getSemestar() == 1 || this.getSemestar() == 2){return true;}break;
                case 2: if(this.getSemestar() == 3 || this.getSemestar() == 4){return true;}break;
                case 3: if(this.getSemestar() == 5 || this.getSemestar() == 6){return true;}break;
                case 4: if(this.getSemestar() == 7 || this.getSemestar() == 8){return true;}break;
            }

            /// 1 - prvi i drugi
            /// 2 - treci i cetvrti
        }
        return false;
    }
}
