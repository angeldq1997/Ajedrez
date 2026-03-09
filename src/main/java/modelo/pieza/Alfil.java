package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

import java.util.Scanner;

public class Alfil extends Pieza {
    public String toString() {
        if (this.getColor() == Color.BLANCA) {
            return "♗";
        } else {
            return "♝";
        }
    }

    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color);
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

    @Override
    public int getPuntos() {
        return 5;
    }

    @Override
    public String toString() {
        return "";
    }

    public boolean movimiento(int nuevafila, int nuevacolumna){
        boolean posible = false;
        int diferenciafilas = nuevafila - getFila();
        int diferenciacolumnas = nuevacolumna -getColumna();
        if (Math.abs(diferenciafilas) == Math.abs(diferenciacolumnas)&& Tablero.estaOcupado(nuevafila,nuevacolumna)){
            this.setFila(nuevafila);
            this.setColumna(nuevacolumna);
        }else{
            System.out.println("Movimiento invalido.");
            posible = false;
        }
        return posible;
    }
}