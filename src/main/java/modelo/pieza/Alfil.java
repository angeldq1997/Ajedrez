package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Alfil extends Pieza {

    public Alfil (){

    }

    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color, 3);
        this.tipoPieza = TipoPieza.ALFIL;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♗');
        } else {
            this.setIcono('♝');
        }

    }

    /**
     * Función con la que comprobamos el movimiento del alfil
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
        boolean posible = false;
        int diferenciaFilas = yDestino - this.getY();
        int diferenciaColumnas = xDestino - this.getX();
        if (Math.abs(diferenciaFilas) == Math.abs(diferenciaColumnas)){
            posible = true;
        }else{
            throw  new IllegalArgumentException("Movimiento inválido.");
        }
        return posible;
    }

    @Override
    public Pieza copiar() {
        return new Alfil(getX(), getY(), getColor());
    }
}