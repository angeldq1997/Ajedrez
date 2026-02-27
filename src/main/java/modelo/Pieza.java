package modelo;

public abstract class Pieza {
    private Color color;
    private int columna;
    private int fila;

    public abstract boolean atacar();

    public abstract boolean mover();

}
