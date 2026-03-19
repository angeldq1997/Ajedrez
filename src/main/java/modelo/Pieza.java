package modelo;

import modelo.pieza.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.Objects;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Alfil.class, Caballo.class, Peon.class, Reina.class, Rey.class, Torre.class})
public abstract class Pieza implements Serializable {
    private Color color;
    private int x;
    private int y;
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
     * Función con la que podemos definir en cada pieza que herede, la manera de moverse en el tablero
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @return Devuelve un booleano
     */
    public abstract boolean puedeMover (int xDestino, int yDestino);

    /**
     * Función con la que podemos hacer una copia de la pieza
     */
    public abstract Pieza copia();

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

    /**
     * Función que asigna una pieza a una casilla concreta con su posición, pasando a estar ocupada
     * @param casillas Las casillas del tablero concreto
     */
    public void asignarCasilla(Casilla[][] casillas) {
        Casilla c = casillas[this.getX()][this.getY()];
        c.setPieza(this);
    }
  
    public String toString (){
        return this.getIcono() + " " + this.getTipoPieza() + " " + this.getX() + " " + this.getY() + " " + this.getColor() + " " + this.getPuntos();
    }
}