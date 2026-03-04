package modelo;
import java.io.Serializable;
public abstract class Pieza implements Serializable {
    private int columna;
    private int fila;
    private Color color;
    private char icono;

    public Pieza(int fila, int columna, Color color) {
        validaPosicion(fila, columna);
        if (color == null){
            throw new IllegalArgumentException ("Debes de introducir un color");
        }
        this.fila = fila;
        this.columna = columna;
        this.color = color;
    }

    protected void validaPosicion (int fila, int columna){
        if (fila < 0 || fila > 7 || columna < 0 || columna > 7){
            throw new IllegalArgumentException("Debes de introducir un número entre 0-7");
        }
    }

    public abstract boolean atacar();

    public abstract boolean mover();

}