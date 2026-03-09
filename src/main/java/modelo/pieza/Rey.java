package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Rey extends Pieza {
    public Rey(int columna, int fila, Color color) {
        super(columna, fila, color, 100);
        this.tipoPieza = TipoPieza.REY;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♔');
        } else {
            this.setIcono('♚');
        }
    }

    /**
     * Método con el que podemos hacer que el rey se pueda mover, comprobando todo.
     * @param filaDestino El número de la fila donde queremos mover la pieza
     * @param columnaDestina El número de la columna donde queremos mover la pieza
     * @param tablero Tablero donde se mueve la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */

    @Override
    public boolean puedeMover(int columnaDestino, int filaDestino) {
    return ((Math.abs(filaDestino-getFila())<=1) && (Math.abs(columnaDestino-getColumna()) <=1));
    }
     

    @Override
    public Pieza copiar() {
        return new Rey(this.getFila(), this.getColumna(), this.getColor()); // Creamos un nuevo Rey con los mismos datos actuales
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♔";
        } else {
            return "♚";
        }
    }
}