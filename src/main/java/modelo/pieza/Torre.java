package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Torre extends Pieza {

    public Torre (){}

    public Torre(int x, int y, Color color) {
        super(x, y, color, 5);
        this.tipoPieza = TipoPieza.TORRE;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♖');
        } else {
            this.setIcono('♜');
        }
    }

    /**
     * Función con la que comprobamos el movimiento de la torre
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover (int xDestino, int yDestino) {
        boolean puedeMover = false;
        if(xDestino == this.getX() || yDestino == this.getY()) {
           puedeMover = true;
        }
        return puedeMover;
    }

    @Override
    public Pieza copiar () {
        return new Torre (this.getY(), this.getX(), this.getColor()) ;
    }
}