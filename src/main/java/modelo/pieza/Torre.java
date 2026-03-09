package modelo.pieza;

import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Torre extends Pieza {
    public Torre(int columna, int fila, Color color) {
        super(columna, fila, color, 5);
        this.tipoPieza = TipoPieza.TORRE;
    }

    /**
     * Método con el que podemos hacer que la torre se pueda mover, comprobando todo.
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param columnaDestina El número de la columna donde queremos mover la pieza
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */

    @Override
    public boolean puedeMover(int filaDestino, int columnaDestina, Tablero tablero) {
        if (getFila() != filaDestino && getColumna() != columnaDestina) { //Verificamos que se mueva en línea recta (o cambia fila o cambia columna)
        return false;
    }
        if (getFila() == filaDestino && getColumna() == columnaDestina) { //No puede quedarse en la misma casilla
            return false;
        }

        int pasoFila = Integer.compare(filaDestino, getFila()); // Calculamos la dirección del paso (-1, 0 o 1)
        int pasoColumna = Integer.compare(columnaDestina, getColumna());


        int f = getFila() + pasoFila; //Bucle para comprobar si hay piezas en el camino
        int c = getColumna() + pasoColumna;

        while (f != filaDestino || c != columnaDestina) {
            if (tablero.getPieza(f, c) != null) {
                return false; // Hay una pieza bloqueando el camino
            }
            f += pasoFila;
            c += pasoColumna;
        }

        Pieza destino = tablero.getPieza(filaDestino, columnaDestina); //Comprobar que en el destino no haya una pieza del mismo color
        if (destino != null && destino.getColor() == this.getColor()) {
            return false;
        }

        return true;
    }


    @Override
    public Pieza copiar() {
        return new Torre(this.getFila(), this.getColumna(), this.getColor());
    }

    @Override
    public int getPuntos() {
        return 5;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♖";
        } else {
            return "♜";
        }
    }
}