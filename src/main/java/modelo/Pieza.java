package modelo;
import java.io.Serializable;
public abstract class Pieza implements Serializable {
    private int columna;
    private int fila;
    private Color color;
    private int puntos;
    private TipoPieza tipoPieza;
    private String forma;

    public Pieza(int columna, int fila, Color color, int puntos, TipoPieza tipoPieza) {
        this.columna = columna;
        this.fila = fila;
        this.color = color;
        this.puntos = puntos;
        this.tipoPieza = tipoPieza;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public abstract boolean atacar();

    public abstract boolean mover();

}