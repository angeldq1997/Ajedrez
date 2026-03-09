package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Reina extends Pieza {

    public Reina(int columna, int fila, Color color) {
        super(columna, fila, color, 9);
        this.tipoPieza = TipoPieza.REINA;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♕');
        } else {
            this.setIcono('♛');
        }
    }

    /**
     * Método con el que podemos hacer que la reina se pueda mover, comprobando todo.
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param columnaDestino El número de la columna donde queremos mover la pieza
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int filaDestino, int columnaDestino, Tablero tablero) {
        int diferenciaFila = Math.abs(filaDestino - getFila());
        int diferenciaColumna = Math.abs(columnaDestino - getColumna());

        if (getFila() == filaDestino && getColumna() == columnaDestino){ // No puede quedarse en la misma posición
            return false;
        }

        if (!(diferenciaFila == diferenciaColumna || getFila() == filaDestino || getColumna() == columnaDestino)){ // Comprobamos que la reina hago los movimientos que puede hacer
            return false;
        }
        // Vemos qué movimiento hacemos en la fila, 0 = misma posición, 1 = hacia delante, -1 = movimiento hacia detrás.
        int pasoFila = 0;
        if (filaDestino > getFila()) {
            pasoFila = 1;
        } else if (filaDestino < getFila()) {
            pasoFila = -1;
        }
        // Vemos qué movimiento hacemos en la columna, 0 = misma posición, 1 = hacia delante, -1 = movimiento hacia detrás.
        int pasoColumna = 0;
        if (columnaDestino > getColumna()) {
            pasoColumna = 1;
        } else if (columnaDestino < getColumna()) {
            pasoColumna = -1;
        }

        int filaActual = getFila() + pasoFila;
        int columnaActual = getColumna() + pasoColumna;

        while (filaActual != filaDestino || columnaActual != columnaDestino) { // Comprobamos que no haya piezas intermedias
            if (tablero.estaOcupado(filaActual, columnaActual)) {
                return false;
            }
            filaActual += pasoFila;
            columnaActual += pasoColumna;
        }

        Pieza piezaDestino = tablero.getPieza(filaDestino, columnaDestino);
        if (piezaDestino != null && piezaDestino.getColor() == this.getColor()) {
            return false; // No puede capturar una pieza del mismo color
        }
        return true;
    }

    @Override
    public Pieza copiar() {
        return new Reina(getFila(), getColumna(), getColor());
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♕";
        } else {
            return "♛";
        }
    }
}