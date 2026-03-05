package modelo;
import java.util.ArrayList;
import java.util.List;
public class Tablero {
    List <Pieza>piezasBlancas = new ArrayList<>();
    List <Pieza>piezasNegras = new ArrayList<>();
    List <Pieza>piezasEliminadas = new ArrayList<>();

    public Tablero(List piezasBlancas, List piezasNegras, List piezasEliminadas) {
        this.piezasBlancas = piezasBlancas;
        this.piezasNegras = piezasNegras;
        this.piezasEliminadas = piezasEliminadas;
    }
    public boolean estaOcupado(int fila, int columna) {
        for (Pieza p : piezasBlancas){
            if (p.getFila()== fila && p.getColumna() == columna){
                return true;
            }
        }
        for (Pieza p : piezasNegras){
            if (p.getFila()== fila && p.getColumna() == columna){
                return true;
            }

        }
        return false;
    }
}