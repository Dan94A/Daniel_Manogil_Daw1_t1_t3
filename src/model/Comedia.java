package model;

import model.enums.Humor;

import java.util.Objects;

public class Comedia extends Libro{
    private Humor tipohumor;

    public Comedia() {
    }

    public Comedia(String titulo, String autor, String isbn, int numPag, Humor tipohumor) {
        super(titulo, autor, isbn, numPag);
        this.tipohumor = tipohumor;
    }

    public Humor getTipohumor() {
        return tipohumor;
    }

    public void setTipohumor(Humor tipohumor) {
        this.tipohumor = tipohumor;
    }

    @Override
    public String toString() {
        return "Comedia{" +
                "tipohumor=" + tipohumor +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comedia comedia)) return false;
        if (!super.equals(o)) return false;
        return tipohumor == comedia.tipohumor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipohumor);
    }
}
