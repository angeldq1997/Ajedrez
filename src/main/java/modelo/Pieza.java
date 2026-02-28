package modelo;
import java.io.Serializable;
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

}