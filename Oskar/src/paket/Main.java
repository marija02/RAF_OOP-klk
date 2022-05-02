package paket;

import java.io.FileNotFoundException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Date d = new Date();
        d.setYear(1999);
        d.setMonth(5);
        d.setDate(25);
        Glumac g1 = new Glumac("Nikola", "Boskovic", d, Pol.MUSKI);

        Glumac g2 = new Glumac("Marija", "Stopa", new Date(2002, 4, 9), Pol.ZENSKI);

        Reziser r = new Reziser("Dragan", "Bijelogrlic", new Date(1970, 3, 3), Pol.MUSKI);

        Kriticar k = new Kriticar("Petar", "Petrovic");
        Kriticar k2 = new Kriticar("Marko", "Markovic");

        Film f = new Film("Inception", 2021, 2, r, Zanr.HOROR);
        Film f1 = new Film("Duga", 2021, 1, r, Zanr.BIOGRAFSKI);

        k.oceniFilm(f, new Kritika(8.9));
        k.pohvali(k2);
        k2.oceniFilm(f, new Kritika(10));

        k.oceniFilm(f1, new Kritika(10));

        System.out.printf("Film " + f + " ocena " + f.getRejting());


        FilmskaAkademija fa = new FilmskaAkademija();
        fa.nominujMuskogGlumca(g1);
        fa.nominujZenskogGlumca(g2);
        fa.nominujRezisera(r);
        fa.nominujFilm(f);
        fa.nominujFilm(f1);

        fa.dodeliOskare();

        fa.napraviIzvestaj();

        fa.statistika();

    }
}
