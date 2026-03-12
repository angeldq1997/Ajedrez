package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

public class Reina extends Pieza {

    public Reina(int x, int y, Color color) {
        super(x, y, color, 9);
        this.tipoPieza = TipoPieza.REINA;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♕');
        } else {
            this.setIcono('♛');
        }
    }

    /**
     * Método con el que podemos hacer que la reina se pueda mover, comprobando todo.
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
        int diferenciaFila = Math.abs(yDestino - getY());
        int diferenciaColumna = Math.abs(xDestino - getX());

        if (getY() == yDestino && getX() == xDestino){ // No puede quedarse en la misma posición
            return false;
        }

        if (!(diferenciaFila == diferenciaColumna || getY() == yDestino || getX() == xDestino)){ // Comprobamos que la reina hago los movimientos que puede hacer
            return false;
        }
        // Vemos qué movimiento hacemos en la fila, 0 = misma posición, 1 = hacia delante, -1 = movimiento hacia detrás.
        int pasoFila = 0;
        if (yDestino > getY()) {
            pasoFila = 1;
        } else if (yDestino < getY()) {
            pasoFila = -1;
        }
        // Vemos qué movimiento hacemos en la columna, 0 = misma posición, 1 = hacia delante, -1 = movimiento hacia detrás.
        int pasoColumna = 0;
        if (xDestino > getX()) {
            pasoColumna = 1;
        } else if (xDestino < getX()) {
            pasoColumna = -1;
        }

        int filaActual = getY() + pasoFila;
        int columnaActual = getX() + pasoColumna;
        return true;
    }

    @Override
    public Pieza copiar() {
        return new Reina(getY(), getX(), getColor());
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♕";
        } else {
            return "♛";
        }
    }
}