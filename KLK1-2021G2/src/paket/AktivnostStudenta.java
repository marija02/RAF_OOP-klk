package paket;

public abstract class AktivnostStudenta implements Uslovljeno, Comparable<AktivnostStudenta>{
    private int godina;
    private int mesec;
    private int dan;

    public AktivnostStudenta(int godina, int mesec, int dan) {
        this.godina = godina;
        this.mesec = mesec;
        this.dan = dan;
    }

    public abstract int getGodinaStudija();


    @Override
    public int compareTo(AktivnostStudenta o) {
        // godinamesecdan
        int brojZaSort = godina;
        /// 20110525
        brojZaSort*=100;
        brojZaSort += mesec;
        brojZaSort*=100;
        brojZaSort += dan;

        int brojZaSort2 = o.godina;
        brojZaSort2*=100;
        brojZaSort2 += o.mesec;
        brojZaSort2*=100;
        brojZaSort2 += o.dan;

        if(brojZaSort > brojZaSort2){
            return 1;
        }else if(brojZaSort == brojZaSort2){
            return 0;
        }else{
            return -1;
        }

    }

    @Override
    public String toString() {
        return dan+"."+mesec+"."+godina+". ";
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }
}
