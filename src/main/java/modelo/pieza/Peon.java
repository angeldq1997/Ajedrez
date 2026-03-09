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
    public boolean puedeMover(int columnaDestino, int filaDestino) {
        boolean puedeMover = false;
        if (this.validaPosicion(columnaDestino, filaDestino)){
            if( Math.abs (columnaDestino - this.getColumna()) == 1 || columnaDestino - this.getColumna() == 0) {
                if (filaDestino - this.getFila() == 1 && this.getColor() == Color.NEGRO)
                    puedeMover = true;
                else if (filaDestino - this.getFila() == -1 && this.getColor() == Color.BLANCO)
                    puedeMover = true;
            }
        }
        return puedeMover;
    }

    @Override
    public Pieza copiar() {
        return null;
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