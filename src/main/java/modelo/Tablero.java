package modelo;
import java.util.ArrayList;
import java.util.List;
public class Tablero {
    String[] matriz;
    List piezasBlancas = new ArrayList<Pieza>();
    List piezasNegras = new ArrayList<Pieza>();
    List piezasEliminadas = new ArrayList<Pieza>();


    public Tablero() {
        this.matriz = new String[64];
    }

    public String getMatriz() {
        String comp = "";
        for (String s: this.matriz){
            comp += s;
        }
        return comp;
    }

    public void setMatriz(String[] matriz) {
        this.matriz = matriz;
    }
}