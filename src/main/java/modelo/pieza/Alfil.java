package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;

import java.util.Scanner;

public class Alfil extends Pieza {

    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color, 3, TipoPieza.ALFIL);
    }


    @Override
    public boolean atacar() {
        return false;
    }

    @Override
    public boolean mover() {

        return false;
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