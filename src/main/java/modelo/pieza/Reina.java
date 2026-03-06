package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Reina extends Pieza {
    public Reina(int fila, int columna, Color color) {
        super(columna, fila, color);
        this.tipoPieza = TipoPieza.REINA;
    }

    /**
     * Método con el que podemos hacer que la reina se pueda mover, comprobando todo.
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param columnaDestina El número de la columna donde queremos mover la pieza
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int filaDestino, int columnaDestina, Tablero tablero) {
        int diferenciaFila = Math.abs(filaDestino - getFila());
        int diferenciaColumna = Math.abs(columnaDestina - getColumna());

        if (getFila() == filaDestino && getColumna() == columnaDestina){ // No puede quedarse en la misma posición
            return false;
        }

        if (!(diferenciaFila == diferenciaColumna || getFila() == filaDestino || getColumna() == columnaDestina)){ // Comprobamos que la reina hago los movimientos que puede hacer
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
        if (columnaDestina > getColumna()) {
            pasoColumna = 1;
        } else if (columnaDestina < getColumna()) {
            pasoColumna = -1;
        }

        int filaActual = getFila() + pasoFila;
        int columnaActual = getColumna() + pasoColumna;

        while (filaActual != filaDestino || columnaActual != columnaDestina) { // Comprobamos que no haya piezas intermedias
            if (tablero.estaOcupado(filaActual, columnaActual)) {
                return false;
            }
            filaActual += pasoFila;
            columnaActual += pasoColumna;
        }

        Pieza piezaDestino = tablero.obtenerPieza(filaDestino, columnaDestina);
        if (piezaDestino != null && piezaDestino.getColor() == this.getColor()) {
            return false; // No puede capturar una pieza del mismo color
        }
        return true;
    }

    @Override
    public Pieza copiar() {
        return new Reina(getFila(), getColumna(), getColor());
    }

    @Override
    public int getPuntos() {
        return 9;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCA) {
            return "♕";
        } else {
            return "♛";
        }
    }
}