package controlador;

import modelo.*;
import view.VistaTablero;

public class ControladorTablero {
    Tablero tableroActual;

    public void setTableroActual(Tablero tableroActual) {
        this.tableroActual = tableroActual;
    }

    public void moverPieza(int xDestino, int yDestino, Pieza pieza){
        if (!this.tableroActual.estaEnLimites(xDestino, yDestino)){
            VistaTablero.mostrarError("Fuera de límites.");
        }
        if (pieza != null && !pieza.puedeMover(xDestino, yDestino)){
            throw new IllegalArgumentException("ERROR: Fuera de las casillas disponibles de movimiento.");
        }
        if (!(pieza instanceof Saltadora)){
            if(tableroActual.hayPiezasIntermedias(pieza.getX(), pieza.getY(), xDestino, yDestino)) {
                throw new IllegalArgumentException("ERROR: Hay una pieza en medio del camino.");
            }
        }

        Casilla cInicio = tableroActual.getCasillas()[pieza.getX()][pieza.getY()];
        Casilla cDest = tableroActual.getCasillas()[xDestino][yDestino];

        if (tableroActual.noHayReyEnemigoOPiezaMismoColor(xDestino, yDestino, pieza)){
                if (cDest.estaOcupada()) {
                    //CASILLA DESTINO ESTÁ OCUPADA POR ENEMIGO
                    eliminarPieza(cDest.getPieza());

                    cInicio.unsetPieza();
                    cDest.unsetPieza();
                    cDest.setPieza(pieza);
                    pieza.setX(xDestino);
                    pieza.setY(yDestino);
                } else {
                    //CUANDO ESTÁ VACÍA LA CASILLA DESTINO
                    cInicio.unsetPieza();
                    cDest.setPieza(pieza);
                    pieza.setX(xDestino);
                    pieza.setY(yDestino);
                }
        }else{
            VistaTablero.mostrarMensaje("No es posible mover la pieza a la posición seleccionada.");
        }
    }

    public void eliminarPieza(Pieza pieza){
        if (pieza ==null){
            throw new IllegalArgumentException("La pieza a eliminar no existe");
        }
        if (pieza.getColor() == Color.BLANCO){
            this.tableroActual.getPiezasBlancas().remove(pieza);
            this.tableroActual.getPiezasEliminadas().add(pieza);
        }else{
            this.tableroActual.getPiezasNegras().remove(pieza);
            this.tableroActual.getPiezasEliminadas().add(pieza);
        }
        pieza.setX(-1);
        pieza.setY(-1);
    }
}