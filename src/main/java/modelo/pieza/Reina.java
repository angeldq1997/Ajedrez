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
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param columnaDestino El número de la columna donde queremos mover la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int filaDestino, int columnaDestino) {
        int diferenciaFila = Math.abs(filaDestino - getFila());
        int diferenciaColumna = Math.abs(columnaDestino - getColumna());

        // Comprobamos que la reina no se quede en la misma posición
        if (diferenciaFila == 0 && diferenciaColumna == 0) return false;

        // Movimiento vertical
        if (getColumna() == columnaDestino) return true;

        // Movimiento horizontal
        if (getFila() == filaDestino) return true;

        // Movimiento diagonal
        if (diferenciaFila == diferenciaColumna) return true;
        return false;
    }

    @Override
    public Pieza copiar() {
        return new Reina(getY(), getX(), getColor());
    }
}