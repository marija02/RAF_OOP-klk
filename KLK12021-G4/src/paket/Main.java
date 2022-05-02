package paket;

public class Main {
    public static void main(String[] args) {
        Ocenjivanje ocenjivanje = new Ocenjivanje();

        PitanjePonudjeniOdgovori ppo = new PitanjePonudjeniOdgovori("Kad je bila Kosovska bitka?");
        PitanjePonudjeniOdgovori ppo2 = new PitanjePonudjeniOdgovori("Koji dan je danas?");

        PitanjeSlobodanOdgovor pso = new PitanjeSlobodanOdgovor("Sta se desilo u toj bitci?");
        PitanjeSlobodanOdgovor pso2 = new PitanjeSlobodanOdgovor("Sta se desilo posle?");

        ResenjeTesta rt = new ResenjeTesta("Test1", "Pera");

        Odgovor o1 = new Odgovor(ppo, "1389");
        Odgovor o2 = new Odgovor(ppo2, "Cetvrtak");
        Odgovor o3 = new Odgovor(ppo, "Ubijen je Murat");
        Odgovor o4 = new Odgovor(ppo, "Okupacija Srbije");

        rt.getOdgovori().add(o1);
        rt.getOdgovori().add(o2);
        rt.getOdgovori().add(o3);
        rt.getOdgovori().add(o4);

        ocenjivanje.getZaOcenjivanje().add(rt);

        ocenjivanje.ispisRezultata();
    }
}
