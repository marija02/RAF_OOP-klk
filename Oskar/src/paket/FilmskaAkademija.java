package paket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FilmskaAkademija {
    private List<Glumac> nomMuskiGlumci = new ArrayList<>();
    private List<Glumac> nomZenskiGlumci = new ArrayList<>();
    private List<Reziser> nomReziseri = new ArrayList<>();
    private List<Film> nomFilmovi = new ArrayList<>();
    private final double MIN_REJTING = 8;

    public void nominujMuskogGlumca(Glumac g){
        if(!nomMuskiGlumci.contains(g) && g.getPol() == Pol.MUSKI){
            nomMuskiGlumci.add(g);
        }
    }

    public void nominujZenskogGlumca(Glumac g){
        if(!nomZenskiGlumci.contains(g) && g.getPol() == Pol.ZENSKI){
            nomZenskiGlumci.add(g);
        }
    }

    public void nominujRezisera(Reziser reziser){
        if(!nomReziseri.contains(reziser)){
            nomReziseri.add(reziser);
        }
    }

    public void nominujFilm(Film film){
        if(!nomFilmovi.contains(film) && film.getRejting() >= MIN_REJTING){
            if(film.getZanr() == Zanr.BIOGRAFSKI || film.getZanr() == Zanr.DOKUMENTARNI){
                if(film.getTrajanje() < 2.5){
                    nomFilmovi.add(film);
                }
            }else{
                nomFilmovi.add(film);
            }
        }
    }

    public void napraviIzvestaj() throws FileNotFoundException {
        String izvestaj = "";
        //************ PROVERI POREDAK TREBA NAM OPADAJUCE
        nomReziseri.sort(Comparator.comparing(Reziser::getBrReziranihFilmova));
        nomFilmovi.sort(Comparator.comparing(Film::getRejting));
        Collections.reverse(nomReziseri);
        Collections.reverse(nomFilmovi);

        for(Film f : nomFilmovi){
            izvestaj += f + "\n";
        }

        for(Glumac g : nomMuskiGlumci){
            izvestaj += g + "\n";
        }

        for(Glumac g : nomZenskiGlumci){
            izvestaj += g + "\n";
        }

        for(Reziser r : nomReziseri){
            izvestaj += r + "\n";
        }

        System.out.println(izvestaj);


        PrintWriter pw = new PrintWriter(new File("nominacije.txt"));

        pw.println(izvestaj);

        pw.close();
    }

    public void statistika(){
        HashMap<Zanr, Integer> mapa = new HashMap<>();
        mapa.put(Zanr.AKCIJA, 0);
        mapa.put(Zanr.AVANTURA, 0);
        mapa.put(Zanr.ANIMIRANI, 0);
        mapa.put(Zanr.BIOGRAFSKI, 0);
        mapa.put(Zanr.KOMEDIJA, 0);
        mapa.put(Zanr.DOKUMENTARNI, 0);
        mapa.put(Zanr.DRAMA, 0);
        mapa.put(Zanr.HOROR, 0);
        mapa.put(Zanr.MJUZIKL, 0);
        mapa.put(Zanr.SCIFI, 0);
        mapa.put(Zanr.TRILER, 0);
        mapa.put(Zanr.VESTERN, 0);

        for(Film f : nomFilmovi){
            mapa.put(f.getZanr(), mapa.get(f.getZanr()) +1);
        }

        for (Map.Entry<Zanr, Integer> entry : mapa.entrySet()) {
            Zanr key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + " - " + value + " nominovanih filmova");
        }

    }

    public void dodeliOskare(){
        if(nomFilmovi.size() > 0 && nomReziseri.size() > 0 && nomMuskiGlumci.size() > 0 && nomZenskiGlumci.size() > 0){
            Random r = new Random();
            int index = r.nextInt(nomZenskiGlumci.size());
            System.out.println("Pobednica je "+ nomZenskiGlumci.get(index));

            index = r.nextInt(nomMuskiGlumci.size());
            System.out.println("Pobednik je "+ nomMuskiGlumci.get(index));

            index = r.nextInt(nomReziseri.size());
            System.out.println("Reziser je "+ nomReziseri.get(index));

            index = r.nextInt(nomFilmovi.size());
            System.out.println("Najbolji film je "+ nomFilmovi.get(index));

        }else{
            System.out.println("Nije moguca dodela oskara na akademiji");
        }
    }

}
