package modelo;
import java.util.ArrayList;
import java.util.List;
public class Tablero {
    private ArrayList<Pieza> piezasBlancas;
    private ArrayList<Pieza> piezasNegras;
    private ArrayList<Pieza> piezasEliminadas;
    private Casilla[][] casillas;

    public Tablero(ArrayList<Pieza> piezasBlancas, ArrayList<Pieza> piezasNegras, ArrayList<Pieza> piezasEliminadas, Casilla[][] casillas) {
        this.piezasBlancas = piezasBlancas;
        this.piezasNegras = piezasNegras;
        this.piezasEliminadas = piezasEliminadas;
        this.casillas = casillas;
    }

    public Tablero() {
        this.piezasEliminadas = new ArrayList<Pieza>();
        this.casillas = new Casilla[8][8];

        this.piezasNegras = new ArrayList<>();
        colocarPiezasArriba(Color.NEGRO, this.piezasNegras);
        this.piezasBlancas = new ArrayList<>();
        colocarPiezasAbajo(Color.BLANCO, this.piezasBlancas);
    }

    public ArrayList<Pieza> getPiezasBlancas() {
        return piezasBlancas;
    }

    public void setPiezasBlancas(ArrayList<Pieza> piezasBlancas) {
        this.piezasBlancas = piezasBlancas;
    }

    public ArrayList<Pieza> getPiezasNegras() {
        return piezasNegras;
    }

    public void setPiezasNegras(ArrayList<Pieza> piezasNegras) {
        this.piezasNegras = piezasNegras;
    }

    public ArrayList<Pieza> getPiezasEliminadas() {
        return piezasEliminadas;
    }

    public void setPiezasEliminadas(ArrayList<Pieza> piezasEliminadas) {
        this.piezasEliminadas = piezasEliminadas;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    private void colocarPiezasArriba(Color color, ArrayList<Pieza> piezas) {
        for (int j = 0; j < 8; j++) {
            Peon peon = new Peon(j, 1, color);
            piezas.add(peon);
        }
        Torre torre = new Torre(0, 0, color);
        Caballo caballo = new Caballo(2, 0, color);
        Alfil alfil = new Alfil(3, 0, color);
        Reina reina = new Reina(4, 0, color);
        Rey rey = new Rey(5, 0, color);
        piezas.add(torre);
        piezas.add(caballo);
        piezas.add(alfil);
        piezas.add(reina);
        piezas.add(rey);
        torre.setColumna(7);
        piezas.add(torre);
        caballo.setColumna(6);
        piezas.add(caballo);
        alfil.setColumna(5);
        piezas.add(alfil);
        for (Pieza p: piezas){
            p.definirCasilla(this.casillas);
        }
    }

    private void colocarPiezasAbajo(Color color, ArrayList<Pieza> piezas) {
        for (int j = 0; j < 8; j++) {
            Peon peon = new Peon(j, 6, color);
            piezas.add(peon);
        }
        Torre torre = new Torre(0, 7, color);
        Caballo caballo = new Caballo(2, 7, color);
        Alfil alfil = new Alfil(3, 7, color);
        Reina reina = new Reina(4, 7, color);
        Rey rey = new Rey(5, 7, color);
        piezas.add(torre);
        piezas.add(caballo);
        piezas.add(alfil);
        piezas.add(reina);
        piezas.add(rey);
        torre.setColumna(7);
        piezas.add(torre);
        caballo.setColumna(6);
        piezas.add(caballo);
        alfil.setColumna(5);
        piezas.add(alfil);
        for (Pieza p: piezas){
            p.definirCasilla(this.casillas);
        }
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

    public Tablero copiarTablero(){
        return new Tablero(this.piezasBlancas, this.piezasNegras, this.piezasEliminadas,this.casillas);
    }

    public void resetearTablero(){
        this.piezasEliminadas = new ArrayList<Pieza>();
        this.casillas = new Casilla[8][8];

        this.piezasNegras = new ArrayList<>();
        colocarPiezasArriba(Color.NEGRO, this.piezasNegras);
        this.piezasBlancas = new ArrayList<>();
        colocarPiezasAbajo(Color.BLANCO, this.piezasBlancas);
    }
}
