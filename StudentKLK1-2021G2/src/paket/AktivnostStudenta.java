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
            return -1;
        }else if(brojZaSort == brojZaSort2){
            return 0;
        }else{
            return 1;
        }

    }
}
