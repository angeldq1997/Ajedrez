package modelo.pieza;
import modelo.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Caballo extends Pieza implements Saltadora {

    public Caballo () {}

    public Caballo(int x, int y, Color color) {
        super(x, y, color, 3);
        this.tipoPieza = TipoPieza.CABALLO;
        if (this.getColor() == Color.BLANCO)
            this.setIcono('♘');
        else
            this.setIcono('♞');
    }

    /**
     * Función con la que comprobamos el movimiento del caballo
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
        return (yDestino - getY())*(yDestino - getY()) +(xDestino - getX())*(xDestino - getX()) == 5;
    }

    @Override
    public Pieza copiar() {
        return new Caballo(this.getX(), this.getY(), this.getColor());
    }
}