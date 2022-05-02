package paket;

import java.util.Objects;

public abstract class Ucesnik {
    private String ime;

    public Ucesnik(String ime) {
        this.ime = ime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ucesnik ucesnik = (Ucesnik) o;
        return Objects.equals(ime, ucesnik.ime);
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }
}
