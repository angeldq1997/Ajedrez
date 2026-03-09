package modelo.pieza;
import modelo.*;

public class Caballo extends Pieza implements Saltadora {
    public Caballo(int columna, int fila, Color color) {
        super(columna, fila, color, 3);
        this.tipoPieza = TipoPieza.CABALLO;
        if (this.getColor() == Color.BLANCO)
            this.setIcono('♘');
        else
            this.setIcono('♞');
    }

    @Override
    public boolean puedeMover(int columnaDestino, int filaDestino) {
        boolean puedeMover = false;
        if (this.validaPosicion(columnaDestino, filaDestino)){
            if ( (filaDestino-getFila())*(filaDestino-getFila()) +(columnaDestino-getColumna())*(columnaDestino-getColumna()) == 5){
                puedeMover = true;
            }
        }
        return puedeMover;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO)
            return "♘";
        else
            return "♞";
    }
}