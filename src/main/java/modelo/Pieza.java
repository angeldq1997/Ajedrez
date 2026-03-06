package modelo;
import java.io.Serializable;
import java.util.Objects;

public abstract class Pieza implements Serializable {
    private int columna;
    private int fila;
    private Color color;
    private char icono;
    protected TipoPieza tipoPieza;
    private int puntos;

    public Pieza(int columna, int fila, Color color, int puntos) {
        validaPosicion(columna, fila);
        if (color == null){
            throw new IllegalArgumentException ("Debes de introducir un color");
        }
        this.columna = columna;
        this.fila = fila;
        this.color = color;
        this.puntos = puntos;
    }

    protected boolean validaPosicion (int columna, int fila){
        if (fila < 0 || fila > 7 || columna < 0 || columna > 7){
            throw new IllegalArgumentException("Debes de introducir un número entre 0-7");
        }else{
            return true;
        }
    }

    /**
     * Método con el que podemos definir en cada pieza que herede, la manera de moverse en el tablero
     * @param columnaDestino El número de la columna donde queremos mover la pieza
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve un booleano
     */
    public abstract boolean puedeMover (int columnaDestino, int filaDestino, Tablero tablero);

    /**
     * Método con el que podemos hacer una copia de la pieza
     * @return Devuelve la copia de la pieza
     */
    public abstract Pieza copiar ();

    /**
     * Método con el que podemos obtener los puntos de una pieza
     * @return Devuelve los puntos de una pieza
     */
    public int getPuntos(){
        return this.puntos;
    }

    public abstract String toString ();

    /**
     * Método con el que movemos a una pieza de sitio en el tablero
     * @param filaDestino El número de la fila donde queremos mover a la pieza en el tablero
     * @param columnaDestino El número de la columna donde queremos mover a la pieza en el tablero
     * @param tablero Tablero donde se mueve la pieza
     */
    public void mover (int columnaDestino, int filaDestino, Tablero tablero){
        validaPosicion(filaDestino, columnaDestino);
        if (!puedeMover(filaDestino, columnaDestino, tablero)){
            throw new IllegalArgumentException("Movimiento no permitido para esta pieza");
        }
        this.fila = filaDestino;
        this.columna = columnaDestino;
    }

    /**
     * Método con el que podemos atacar a otra pieza que esté en el tablero
     * @param filaDestino El número de la fila donde queremos mover a la pieza en el tablero
     * @param columnaDestino El número de la columna donde queremos mover a la pieza en el tablero
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve si puede atacar o no
     */
    public boolean puedeAtacar (int columnaDestino, int filaDestino, Tablero tablero){
        return puedeMover(columnaDestino, filaDestino, tablero);
    }

    public int getColumna() {
        return this.columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return this.fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public char getIcono() {
        return this.icono;
    }

    public void setIcono(char icono) {
        this.icono = icono;
    }

    public TipoPieza getTipoPieza() {
        return this.tipoPieza;
    }

    public void setTipoPieza(TipoPieza tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pieza pieza = (Pieza) o;
        return this.columna == pieza.columna &&
                this.fila == pieza.fila &&
                this.color == pieza.color &&
                this.tipoPieza == pieza.tipoPieza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columna, fila, color, tipoPieza);
    }

    public void asignarCasilla(Casilla[][] casillas) {
        Casilla c = casillas[this.getColumna()][this.getFila()];
        c.setPieza(this);
    }
}