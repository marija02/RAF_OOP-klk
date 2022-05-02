import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // String naziv, int semestar, int espb, OznakaPlana oznakaPlana
        Predmet p1 = new Predmet("Matematika", 2, 8, OznakaPlana.RN);
        Predmet p2 = new Predmet("OOP", 1, 8, OznakaPlana.RI);
        Predmet p3 = new Predmet("UUP", 2, 8, OznakaPlana.RN);

        /// (String naziv, int semestar, int espb, OznakaPlana oznakaPlana
        IzborniPredmet ip1 = new IzborniPredmet("SRV", 3, 8, OznakaPlana.RI);
        IzborniPredmet ip2 = new IzborniPredmet("Srpski", 3, 8, OznakaPlana.RN);
        IzborniPredmet ip3 = new IzborniPredmet("Engleski", 3, 4, OznakaPlana.RI);
        IzborniPredmet ip4 = new IzborniPredmet("WEB", 6, 8, OznakaPlana.RN);
        IzborniPredmet ip5 = new IzborniPredmet("Napredan WEB", 7, 8, OznakaPlana.RI);


        IzbornaGrupa ig1 = new IzbornaGrupa();
        IzbornaGrupa ig2 = new IzbornaGrupa();

        // int brojIndeksa, int godinaUpisa, OznakaPlana plan
        Student s1 = new Student(100, 2018, OznakaPlana.RN);
        s1.getUpisaneGodine().add(1);
        s1.getUpisaneGodine().add(1);
        s1.getUpisaneGodine().add(2);

        Student s2 = new Student(13, 2019, OznakaPlana.RI);
        s1.getUpisaneGodine().add(1);
        s1.getUpisaneGodine().add(2);

        s1.getPolozeniPredmeti().add(p1);
        s1.getPolozeniPredmeti().add(p2);
        s1.getPolozeniPredmeti().add(ip5);

        s2.getPolozeniPredmeti().add(ip3);
        s2.getPolozeniPredmeti().add(p2);
        s2.getPolozeniPredmeti().add(ip5);


        StudentiIzbori si = new StudentiIzbori();
        List<IzborniPredmet> izborniPredmetList = new ArrayList<>();
        izborniPredmetList.add(ip2);
        izborniPredmetList.add(ip4);

        si.dodajIzbor(s1, izborniPredmetList);

        List<Predmet> predmetList = new ArrayList<>();
        predmetList.add(p1);
        predmetList.add(p2);
        predmetList.add(p3);
        IzborniModul im = new IzborniModul("Modul1", predmetList);

        si.dodajIzbor(s2, im);

        si.ispisiFajl();
    }
}
