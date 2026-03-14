package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Pieza implements Serializable {
    private int x;
    private int y;
    private Color color;
    private char icono;
    protected TipoPieza tipoPieza;
    private int puntos;

    public Pieza() {
    }

    public Pieza(int x, int y, Color color, int puntos) {
        if (color == null){
            throw new IllegalArgumentException ("Debes de introducir blanco o negro");
        }
        this.x = x;
        this.y = y;
        this.color = color;
        this.puntos = puntos;
    }

    /**
     * Método con el que podemos definir en cada pieza que herede, la manera de moverse en el tablero
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @return Devuelve un booleano
     */
    public abstract boolean puedeMover (int xDestino, int yDestino);

    /**
     * Método con el que podemos hacer una copia de la pieza
     */
    public abstract Pieza copiar();

    /**
     * Método con el que podemos obtener los puntos de una pieza
     * @return Devuelve los puntos de una pieza
     */
    public int getPuntos(){
        return this.puntos;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
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
        return this.x == pieza.x &&
                this.y == pieza.y &&
                this.color == pieza.color &&
                this.tipoPieza == pieza.tipoPieza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color, tipoPieza);
    }

    public void asignarCasilla(Casilla[][] casillas) {
        Casilla c = casillas[this.getX()][this.getY()];
        c.setPieza(this);
    }
  
    public String toString (){
        return this.getIcono() + " " + this.getX() + " " + this.getY() + " " + this.getColor() + " " + this.getPuntos();
    }
}