package controlador;

import modelo.Casilla;
import modelo.Tablero;

public class ControladorTablero {

    public String nuevoTablero(){
        String[] posiciones = {  "♜","♞","♝","♚","♛","♝","♞","♜"
                                ,"\n♟","♟","♟","♟","♟","♟","♟","♟"
                                ,"\n░","▓","░","▓","░","▓","░","▓"
                                ,"\n▓","░","▓","░","▓","░","▓","░"
                                ,"\n░","▓","░","▓","░","▓","░","▓"
                                ,"\n▓","░","▓","░","▓","░","▓","░"
                                ,"\n♙","♙","♙","♙","♙","♙","♙","♙"
                                ,"\n♖","♘","♗","♕","♔","♗","♘","♖"
        };
        Tablero tablero = new Tablero();
        tablero.setMatriz(posiciones);
        return tablero.getMatriz();
    }

}
