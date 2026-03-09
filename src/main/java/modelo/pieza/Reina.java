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
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */
    @Override
    public boolean puedeMover(int filaDestino, int columnaDestino) {
        if (this.validaPosicion(columnaDestino, filaDestino)){
            if(columnaDestino == this.getColumna() || filaDestino == this.getFila() || Math.abs(filaDestino - this.getFila()) == Math.abs(columnaDestino - getColumna()) )
                return true;
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