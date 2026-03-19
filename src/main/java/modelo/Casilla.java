package modelo;

import modelo.pieza.*;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Casilla implements Serializable {
    @XmlElements({
            @XmlElement(name= "Alfil", type = Alfil.class),
            @XmlElement(name= "Caballo", type = Caballo.class),
            @XmlElement(name= "Peon", type = Peon.class),
            @XmlElement(name= "Reina", type = Reina.class),
            @XmlElement(name= "Rey", type = Rey.class),
            @XmlElement(name= "Torre", type = Torre.class)
    })
    private Pieza pieza;
    private Color colorCasilla;
    private char icono;
    private boolean estaOcupada;

    public Casilla() {
        this.pieza = null;
        this.colorCasilla = null;
        this.icono = ' ';
        this.estaOcupada = false;
    }

    public Casilla(Pieza pieza, Color colorCasilla, char icono) {
        this.pieza = pieza;
        this.colorCasilla = colorCasilla;
        this.icono = icono;
        this.estaOcupada = false;
    }

    public char getIcono() {
        return icono;
    }

    public void setIcono(char icono) {
        this.icono = icono;
    }

    /**
     * Función que asigna una pieza a la casilla
     * @param pieza Pieza a asignar a la casilla
     */
    public void setPieza(Pieza pieza){
        this.pieza = pieza;
        this.icono = pieza.getIcono();
        this.estaOcupada = true;
    }

    /**
     * Función que quita la asignación para que pase a no tener (aparece como null)
     */
    public void unsetPieza(){
        this.pieza = null;
        if (this.colorCasilla == Color.BLANCO){
            this.setIcono('░');
        }else{
            this.setIcono('▓');
        }
        this.estaOcupada = false;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public Color getColorCasilla() {
        return colorCasilla;
    }

    public void setColorCasilla(Color colorCasilla) {
        this.colorCasilla = colorCasilla;
    }

    public boolean estaOcupada() {
        return estaOcupada;
    }

    public void setEstaOcupada(boolean estaOcupada) {
        this.estaOcupada = estaOcupada;
    }
}