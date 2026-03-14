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
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
        int diferenciaFila = Math.abs(yDestino - getY());
        int diferenciaColumna = Math.abs(xDestino - getX());

        // Comprobamos que la reina no se quede en la misma posición
        if (diferenciaFila == 0 && diferenciaColumna == 0) return false;

        // Movimiento vertical
        if (getX() == xDestino) return true;

        // Movimiento horizontal
        if (getY() == yDestino) return true;

        // Movimiento diagonal
        if (diferenciaFila == diferenciaColumna) return true;
        return false;
    }

    @Override
    public Pieza copiar() {
        return new Reina(getY(), getX(), getColor());
    }
}