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

    int nuevacolumna;
    int nuevafila;
    @Override
    public boolean atacar() {
        return false;
    }

    @Override
    public boolean mover() {

        return false;
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