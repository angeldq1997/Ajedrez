package controlador;

import modelo.*;
import view.VistaTablero;

public class ControladorTablero {
    Tablero tableroActual;

    public void setTableroActual(Tablero tableroActual) {
        this.tableroActual = tableroActual;
    }

    /**
     * Método con el que movemos una pieza en el tablero, con todas las comprobaciones
     * @param columnaDestino Columna donde queremos mover la pieza
     * @param filaDestino Fila donde queremos mover la pieza
     * @param pieza Pieza que queremos mover
     */
    public void moverPieza(int columnaDestino, int filaDestino, Pieza pieza){

        Casilla cDest = this.tableroActual.getCasillas()[columnaDestino][filaDestino];

        if (this.tableroActual.estaEnLimites(columnaDestino, filaDestino)){
            if(pieza.puedeMover(columnaDestino, filaDestino)) {
                if (cDest.estaOcupada()) {
                    if (this.tableroActual.hayReyEnemigoOPiezaMismoColor(columnaDestino, filaDestino, pieza)) {
                        if (pieza.getColor() == Color.BLANCO) {
                            this.tableroActual.getPiezasBlancas().remove(this.tableroActual.getPiezasBlancas().get(this.tableroActual.posicionPieza(cDest.getPieza())));
                        } else {
                            this.tableroActual.getPiezasNegras().remove(this.tableroActual.getPiezasNegras().get(this.tableroActual.posicionPieza(cDest.getPieza())));
                        }
                        cDest.unsetPieza();
                    }
                }
            }
        }
        pieza.setColumna(columnaDestino);
        pieza.setFila(filaDestino);

        cDest.setPieza(pieza);
        this.tableroActual.getCasillas()[pieza.getColumna()][pieza.getFila()].unsetPieza();
        }else{
            VistaTablero.mostrarMensaje("No es posible mover la pieza a la posición seleccionada.");
        }
    }
}