package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Alfil extends Pieza {
    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color, 3);
        this.tipoPieza = TipoPieza.ALFIL;
    }

    int nuevacolumna;
    int nuevafila;
    @Override
    public boolean puedeMover(int filaDestino, int columnaDestina, Tablero tablero) {
        return false;
    }

    @Override
    public Pieza copiar() {
        return null;
    }

    @Override
    public int getPuntos() {
        return 5;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♗";
        } else {
            return "♝";
        }
    }

    public int pidemovimiento() {
        boolean posible = false;
        while (!posible) {
            if (!Tablero.estaOcupado(nuevafila, nuevacolumna)) {
                setColumna(nuevacolumna);
                setFila(nuevafila);
                posible = true;
            } else {
                System.out.println("Moviento invalido.");
                posible = false;
            }
        }
        return 0;
    }
}