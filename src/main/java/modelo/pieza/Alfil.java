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

    @Override
    public boolean puedeMover(int filaDestino, int columnaDestina, Tablero tablero) {
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