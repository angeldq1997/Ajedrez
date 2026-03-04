package modelo;
import java.util.ArrayList;
import java.util.List;
public class Tablero {
    List piezasBlancas = new ArrayList<Pieza>();
    List piezasNegras = new ArrayList<Pieza>();
    List piezasEliminadas = new ArrayList<Pieza>();

    public Tablero(List piezasBlancas, List piezasNegras, List piezasEliminadas) {
        this.piezasBlancas = piezasBlancas;
        this.piezasNegras = piezasNegras;
        this.piezasEliminadas = piezasEliminadas;
    }
}