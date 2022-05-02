import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentiIzbori {
    private List<PomocnaKlasa> izbori = new ArrayList<>();

    public void dodajIzbor(Student student, IzborStudenta izborStudenta){
        if(student.jePonovac() && izborStudenta instanceof IzborniPredmet){
            PomocnaKlasa pk = new PomocnaKlasa(student, izborStudenta);
            izbori.add(pk);
        }else if(!student.jePonovac() && (izborStudenta instanceof IzbornaGrupa || izborStudenta instanceof IzborniModul)){
            PomocnaKlasa pk = new PomocnaKlasa(student, izborStudenta);
            izbori.add(pk);
        }
    }

    public void dodajIzbor(Student student, List<IzborniPredmet> izborStudenta){
        if(student.jePonovac()){
            PomocnaKlasa pk = new PomocnaKlasa(student, izborStudenta);
            izbori.add(pk);
        }
    }

    public void ispisiFajl() throws FileNotFoundException {
        /// Scanner sc = new Scanner(new File("citaj.txt"));
        PrintWriter pw = new PrintWriter("ispis.txt");
        for(PomocnaKlasa pk : izbori){
            if(pk.getIzborniPredmeti().isEmpty()){
                if(pk.getIzborStudenta() instanceof IzbornaGrupa){
                   pw.println(pk.getStudent().getBrojIndeksa() + " " + ((IzbornaGrupa)pk.getIzborStudenta()).getOznaka() + " ");
                }else if (pk.getIzborStudenta() instanceof IzborniModul){
                    pw.println(pk.getStudent().getBrojIndeksa() + " " + ((IzborniModul)pk.getIzborStudenta()).getNaziv() + " ");
                }else{
                    pw.println(pk.getStudent().getBrojIndeksa() + " " + ((IzborniPredmet)pk.getIzborStudenta()).getNaziv() + " ");
                }
            }else{
                System.out.println("CAO");
                pw.print(pk.getStudent().getBrojIndeksa() + " " );
                for(IzborniPredmet ip : pk.getIzborniPredmeti()){
                    pw.print(ip.getNaziv() + " ");
                }
                pw.println();
            }
        }

        pw.close(); /// ***************
    }



}
