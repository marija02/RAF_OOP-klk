package paket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Student student = new Student();

        UpisGodine ug = new UpisGodine(2019, 10, 1, 1);


        student.dodajAktivnost(ug);


        Predmet p = new Predmet("Algebra", 8, 5);
        Predmet p2 = new Predmet("ORS", 8, 1);
        Predmet p3 = new Predmet("UUP", 8, 2);
        Predmet p4 = new Predmet("OOP", 8, 3);
        Predmet p6 = new Predmet("OOP", 8, 3);
        Predmet p7 = new Predmet("OOP", 8, 3);
        Predmet p8 = new Predmet("OOP", 8, 3);

        Predmet p9 = new Predmet("OOP", 8, 3);

        Predmet p5 = new Predmet("Srpski", 8, 4);

        student.getPolozeniPredmeti().add(p2);
        student.getPolozeniPredmeti().add(p3);
        student.getPolozeniPredmeti().add(p4);
        student.getPolozeniPredmeti().add(p5);
        student.getPolozeniPredmeti().add(p6);
        student.getPolozeniPredmeti().add(p7);
        student.getPolozeniPredmeti().add(p8);
        student.getPolozeniPredmeti().add(p9);

        UpisGodine ug1 = new UpisGodine(2020, 10, 1, 2);
        ug1.getPrenetiPredmeti().add(p);
        ObnovaGodine og = new ObnovaGodine(2021, 10, 1, 2);
        PromenaStudijskogPrograma psp = new PromenaStudijskogPrograma(2022, 10, 1, "RN", 3, 100, ug1.getPrenetiPredmeti());

        student.dodajAktivnost(ug1);
        student.dodajAktivnost(og);
        student.dodajAktivnost(psp);



        System.out.println(student.jePonovac());
        System.out.println(student.getPolozeniPredmeti());
        System.out.println(student.slusaPredmet(p));

        System.out.println(student.getAktivnosti());

        PrintWriter pw = new PrintWriter("ispis.txt");

        for(AktivnostStudenta as : student.getAktivnosti()){
            pw.println(as);
        }
        pw.close();
    }
}
