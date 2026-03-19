package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Peon extends Pieza {

    public Peon (){}

    public Peon(int x, int y, Color color) {
      super(x, y, color, 1);
      this.tipoPieza = TipoPieza.PEON;
        if (this.getColor() == Color.BLANCO)
            this.setIcono('♙');
        else
            this.setIcono('♟');
    }

    /**
     * Función con la que hacemos que el peon compruebe movimiento
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @return Devuelve si el movimiento es válido (true) o si no lo es (false)
     */
    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
        // Calculamos cuanto se mueve el peon
        int diferenciaFila = yDestino - getY();
        int diferenciaColumna = xDestino - getX();

        int direccion; // Las piezas blancas suben (-1), las negras bajan (1)
        if (getColor() == Color.BLANCO) {
            direccion = -1;
        } else {
            direccion = 1;
        }

        // Movimiento normal, 1 hacia delante
        if (diferenciaColumna == 0 && diferenciaFila == direccion) return true;

        // Movimiento inicial doble
        if (diferenciaColumna == 0 && diferenciaFila == 2 * direccion){
            if (getColor() == Color.BLANCO && getY() == 6 || getColor() == Color.NEGRO && getY() == 1) return true;
        }
        return false;
    }

    /**
     * Función con la que podemos atacar con el peon
     * @param yDestino El número de la columna donde queremos mover a la pieza en el tablero
     * @param xDestino El número de la fila donde queremos mover a la pieza en el tablero
     * @return Devuelve si el peon puede atacar (true) o no puede atacar (false)
     */
    public boolean puedeAtacar(int yDestino, int xDestino) {
        // Solo puede atacar 1 casilla diagonal hacia delante
        int diferenciaFila = yDestino - getY();
        int diferenciaColumna = xDestino - getX();

        int direccion;
        if (getColor() == Color.BLANCO) {
            direccion = -1;
        } else {
            direccion = 1;
        }

        // Verifica que sea diagonal de 1 paso
        if (Math.abs(diferenciaColumna) == 1 && diferenciaFila == direccion) {
            return true;
        }
        return false;
    }

    @Override
    public Pieza copiar() {
        return new Peon(getX(), getY(), getColor());
    }
}