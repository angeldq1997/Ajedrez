package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Rey extends Pieza {
    public Rey(int columna, int fila, Color color) {
        super(columna, fila, color, 100);
        this.tipoPieza = TipoPieza.REY;
    }

    /**
     * Método con el que podemos hacer que el rey se pueda mover, comprobando todo.
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param columnaDestina El número de la columna donde queremos mover la pieza
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */

    @Override
    public boolean puedeMover(int filaDestino, int columnaDestina, Tablero tablero) {
        int diferenciaFila = Math.abs(filaDestino - this.getFila());
        int diferenciaColumna = Math.abs(columnaDestina - this.getColumna());

        if (diferenciaFila == 0 && diferenciaColumna == 0) { //Si no se mueve (destino igual a origen), es falso
            return false;
        }


        if (diferenciaFila <= 1 && diferenciaColumna <= 1) { // El Rey solo puede mover 1 casilla en cualquier dirección

            Pieza destino = tablero.getPieza(filaDestino, columnaDestina);
            if (destino != null && destino.getColor() == this.getColor()) { //Comprobamos si en el destino hay una pieza del mismo color
                return false;
            }

            return true; // Si pasa los filtros, el movimiento es válido
        }

        return false;
    }

    @Override
    public Pieza copiar() {
        return new Rey(this.getFila(), this.getColumna(), this.getColor()); // Creamos un nuevo Rey con los mismos datos actuales
    }

    @Override
    public int getPuntos() {
        return 100;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♔";
        } else {
            return "♚";
        }
    }
}