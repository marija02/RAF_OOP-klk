import java.util.ArrayList;
import java.util.List;

public class PomocnaKlasa {
    private Student student;
    private IzborStudenta izborStudenta;
    private List<IzborniPredmet> izborniPredmeti = new ArrayList<>();

    public PomocnaKlasa(Student student, IzborStudenta izborStudenta) {
        this.student = student;
        this.izborStudenta = izborStudenta;
    }

    public PomocnaKlasa(Student student, List<IzborniPredmet> izborniPredmeti) {
        this.student = student;
        this.izborniPredmeti = izborniPredmeti;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public IzborStudenta getIzborStudenta() {
        return izborStudenta;
    }

    public void setIzborStudenta(IzborStudenta izborStudenta) {
        this.izborStudenta = izborStudenta;
    }

    public List<IzborniPredmet> getIzborniPredmeti() {
        return izborniPredmeti;
    }
}
