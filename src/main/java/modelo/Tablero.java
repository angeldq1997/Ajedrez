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

    /**
     * Método con el que obtenemos el lugar exacto de la pieza
     * @param fila Fila en la que se encuentra la pieza
     * @param columna Columna en la que se encuentra la pieza
     * @return Devuelve la pieza o null, si no hay pieza en esa casilla
     */
    public Pieza getPieza(int fila, int columna) {
        for (Pieza p : piezasBlancas) {
            if (p.getFila() == fila && p.getColumna() == columna) return p;
        }
        for (Pieza p : piezasNegras) {
            if (p.getFila() == fila && p.getColumna() == columna) return p;
        }
        return null;
    }

    public void vaciarPiezas(){
        for (Pieza p: this.piezasBlancas){
            piezasEliminadas.add(p);
            piezasBlancas.remove(p);
        }
        for (Pieza p2: this.piezasNegras){
            piezasEliminadas.add(p2);
            piezasNegras.remove(p2);
        }
    }
}
