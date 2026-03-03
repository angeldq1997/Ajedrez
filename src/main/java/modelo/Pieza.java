package modelo;
import java.io.Serializable;
import java.util.Objects;

public abstract class Pieza implements Serializable {
    private int columna;
    private int fila;
    private Color color;
    private int puntos;

    public Pieza(int columna, int fila, Color color, int puntos) {
        this.columna = columna;
        this.fila = fila;
        this.color = color;
        this.puntos = puntos;
    }

    public abstract boolean atacar();

    public abstract boolean mover();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pieza pieza = (Pieza) o;
        return this.color == pieza.color;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.color);
    }
}