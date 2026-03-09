package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

public class Peon extends Pieza {
    public Peon(int columna, int fila, Color color) {
      super(columna, fila, color, 1);
      this.tipoPieza = TipoPieza.PEON;
        if (this.getColor() == Color.BLANCO)
            this.setIcono('♙');
        else
            this.setIcono('♟');
    }

    @Override
    public boolean puedeMover(int filaDestino, int columnaDestino, Tablero tablero) {
        // Calculamos cuanto se mueve el peon
        int diferenciaFila = filaDestino - getFila();
        int diferenciaColumna = columnaDestino - getColumna();

        int direccion; // Las piezas blancas suben (-1), las negras bajan (1)
        if (getColor() == Color.BLANCO) {
            direccion = -1;
        } else {
            direccion = 1;
        }

        // Movimiento normal del peon, 1 hacia delante
        if (diferenciaColumna == 0 && diferenciaFila == direccion) {
            if (!tablero.estaOcupado(columnaDestino, filaDestino)) {
                return true;
            }
        }

        // Movimiento doble del inicio
        if (diferenciaColumna == 0 && diferenciaFila == 2 * direccion) {
            if ((getColor() == Color.BLANCO && getFila() == 6) || (getColor() == Color.NEGRO && getFila() == 1)) {
                int filaIntermedia = getFila() + direccion;
                if (!tablero.estaOcupado(columnaDestino, filaIntermedia) &&
                        !tablero.estaOcupado(columnaDestino, filaDestino)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean puedeAtacar(int filaDestino, int columnaDestino, Tablero tablero) {
        // Solo puede atacar 1 casilla diagonal hacia delante
        int diferenciaFila = filaDestino - getFila();
        int diferenciaColumna = columnaDestino - getColumna();

        int direccion;
        if (getColor() == Color.BLANCO) {
            direccion = -1;
        } else {
            direccion = 1;
        }

        // Verifica que sea diagonal de 1 paso
        if (Math.abs(diferenciaColumna) == 1 && diferenciaFila == direccion) {
            // La casilla debe estar ocupada por una pieza contraria
            Pieza piezaDestino = tablero.getPieza(columnaDestino, filaDestino);
            if (piezaDestino != null && piezaDestino.getColor() != getColor()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Pieza copiar() {
        return new Peon(getColumna(), getFila(), getColor());
    }

    @Override
    public int getPuntos() {
        return 1;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♙";
        } else {
            return "♟";
        }
    }
}