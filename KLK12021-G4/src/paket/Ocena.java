package paket;

public class Ocena {
    private int broj;

    public Ocena(int osvojeniPoeni){
        if(osvojeniPoeni >= 30 && osvojeniPoeni  <=40){
            this.broj = 6;
        }else if (osvojeniPoeni >=41 && osvojeniPoeni <= 50){
            this.broj = 7;
        }
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }
}
