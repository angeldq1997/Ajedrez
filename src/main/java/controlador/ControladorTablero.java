package controlador;

import modelo.*;
import view.VistaTablero;

public class ControladorTablero {
    Tablero tableroActual;

    public void setTableroActual(Tablero tableroActual) {
        this.tableroActual = tableroActual;
    }

    public void moverPieza(int columnaDestino, int filaDestino, Pieza pieza){
        //Casilla Destino
        Casilla cDest = tableroActual.getCasillas()[columnaDestino][filaDestino];

        if (tableroActual.hayReyEnemigoOPiezaMismoColor(columnaDestino, filaDestino, pieza)){
            if( pieza.puedeMover(columnaDestino, filaDestino) ) {
                if (cDest.estaOcupada()) {
                    if (pieza.getColor() == Color.BLANCO) {
                        tableroActual.getPiezasBlancas().remove(tableroActual.getPiezasBlancas().get(tableroActual.posicionPieza(cDest.getPieza())));
                    } else {
                        tableroActual.getPiezasNegras().remove(tableroActual.getPiezasNegras().get(tableroActual.posicionPieza(cDest.getPieza())));
                    }
                    tableroActual.getCasillas()[pieza.getColumna()][pieza.getFila()].unsetPieza();
                    cDest.unsetPieza();
                    cDest.setPieza(pieza);
                    pieza.setColumna(columnaDestino);
                    pieza.setFila(filaDestino);
                } else {
                    this.tableroActual.getCasillas()[pieza.getColumna()][pieza.getFila()].unsetPieza();
                    cDest.setPieza(pieza);
                    pieza.setColumna(columnaDestino);
                    pieza.setFila(filaDestino);
                }
            }
        }else{
            VistaTablero.mostrarMensaje("No es posible mover la pieza a la posición seleccionada.");
        }
    }
}