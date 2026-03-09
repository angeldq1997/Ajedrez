package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

public class Alfil extends Pieza {

    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color, 3);
        this.tipoPieza = TipoPieza.ALFIL;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♗');
        } else {
            this.setIcono('♝');
        }
    }

    @Override
    public boolean puedeMover(int filaDestino, int columnaDestino) {
        if( Math.abs(filaDestino - this.getFila()) == Math.abs(columnaDestino - getColumna()) ){
            return true;
        }
        return false;
    }

    @Override
    public Pieza copiar() {
        return null;
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♗";
        } else {
            return "♝";
        }
    }

    public boolean movimiento(int nuevafila, int nuevacolumna){
        boolean posible = false;
        int diferenciafilas = nuevafila - this.getFila();
        int diferenciacolumnas = nuevacolumna -this.getColumna();
        if (Math.abs(diferenciafilas) == Math.abs(diferenciacolumnas)&& Tablero.estaOcupado(nuevacolumna,nuevafila)){
            this.setFila(nuevafila);
            this.setColumna(nuevacolumna);
            posible = true;
        }else{
            System.out.println("Movimiento invalido.");
            posible = false;
        }
        return posible;
    }
}