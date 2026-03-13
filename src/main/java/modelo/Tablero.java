package modelo;
import modelo.pieza.*;

import java.util.ArrayList;

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
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                this.casillas[x][y] = new Casilla();
            }
        }
        asignacionColorCasillas();

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
        for (int x = 0; x < 8; x++) {
            Peon peon = new Peon(x, 1, color);
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
            p.asignarCasilla(this.casillas);
        }
    }

    private void colocarPiezasAbajo(Color color, ArrayList<Pieza> piezas) {
        for (int x = 0; x < 8; x++) {
            Peon peon = new Peon(x, 6, color);
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
            p.asignarCasilla(this.casillas);
        }
    }

    public boolean estaOcupado(int x, int y) {
        for (Pieza p : piezasBlancas) {
            if (p.getY() == y && p.getX() == x) {
                return true;
            }
        }
        for (Pieza p : piezasNegras) {
            if (p.getY() == y && p.getX() == x) {
                return true;
            }

        }
        return false;
    }

    /**
     * Método con el que obtenemos el lugar exacto de la pieza
     * @param columna Columna en la que se encuentra la pieza
     * @param fila Fila en la que se encuentra la pieza
     * @return Devuelve la pieza o null, si no hay pieza en esa casilla
     */
    public Pieza getPieza(int x, int y) {
        for (Pieza p : piezasBlancas) {
            if (p.getX() == x && p.getY() == y) return p;
        }
        for (Pieza p : piezasNegras) {
            if (p.getX() == x && p.getY() == y) return p;
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

    public boolean agregarPieza(Pieza pieza, Color color, int x, int y) {
        boolean estaAgregada = false;
        if (pieza != null && (color == Color.BLANCO || color == Color.NEGRO) && estaEnLimites(x, y)) {
            if (color == Color.BLANCO)
                this.piezasBlancas.add(pieza);
            }else{
                this.piezasNegras.add(pieza);
            }
        }
        return estaAgregada;
    }

    public int puntuacionColor(Color color){
        int puntuacionTotal = 0;
        if (color == Color.BLANCO){
            for (Pieza p: piezasBlancas){
                puntuacionTotal += p.getPuntos();
            }
        }else if (color == Color.NEGRO){
            for (Pieza p: piezasNegras){
                puntuacionTotal += p.getPuntos();
            }
        }else{
            throw new IllegalArgumentException("Ha introducido un color incorrecto, debe introducir NEGRO o BLANCO.");
        }
        return puntuacionTotal;
    }

    private void asignacionColorCasillas() {
        Casilla[][] c = this.casillas;
        for (int y = 0; y < 8; y++) {
            if (y % 2 == 0) {
                for (int x = 0; x < 8; x++) {
                    if (x % 2 == 0) {
                        c[x][y].setColorCasilla(Color.BLANCO);
                        c[x][y].setIcono('░');
                    } else {
                        c[x][y].setColorCasilla(Color.NEGRO);
                        c[x][y].setIcono('▓');
                    }
                }
            } else {
                for (int x = 0; x < 8; x++) {
                    if (x % 2 == 0) {
                        c[x][y].setColorCasilla(Color.NEGRO);
                        c[x][y].setIcono('▓');
                    } else {
                        c[x][y].setColorCasilla(Color.BLANCO);
                        c[x][y].setIcono('░');
                    }
                }
            }

        }
    }

    public boolean noHayReyEnemigoOPiezaMismoColor(int xDestino, int yDestino, Pieza pieza){
        boolean puedeMover = true;
        Casilla c = this.getCasillas()[xDestino][yDestino];
        if (pieza == null){
            throw new IllegalArgumentException("Error, la pieza no existe.");
        }
        if (c.estaOcupada()){
            if( c.getPieza().getColor() == pieza.getColor()) {
                puedeMover = false;
                throw new IllegalArgumentException("Error, en la casilla destino hay una pieza del mismo color.");
            }else if (c.getPieza().getTipoPieza() == TipoPieza.REY){
                puedeMover = false;
                throw new IllegalArgumentException("Error, en la casilla destino está el rey enemigo.");
            }
        }

    public boolean estaEnLimites(int x, int y){
        if (y < 0 || y > 7 || x < 0 || x > 7)
            throw new IllegalArgumentException("La casilla seleccionada está fuera de los límites.");
        else
            return true;
    }

    public int posicionPieza(Pieza pieza){
        int posicionPieza = -1;
        boolean existe = false;
        if (pieza.getColor() == Color.BLANCO) {
            for (int i = 0; i < this.getPiezasBlancas().size() && !existe; i++) {
                if (this.getPiezasBlancas().get(i).equals(pieza)) {
                    posicionPieza = i;
                    existe = true;
                }
            }
        }else{
            for (int i = 0; i < this.getPiezasNegras().size() && !existe; i++) {
                if (this.getPiezasNegras().get(i).equals(pieza)) {
                    posicionPieza = i;
                    existe = true;
                }
            }
        }
    }

    public String mostrarTablero() {
        String tablero = "";
        for (int y = 0; y < 8; y++) {
            tablero += "\n"+y;
            for (int x = 0; x < 8; x++) {
                tablero += this.getCasillas()[x][y].getIcono();
            }
        }
        return tablero;
    }

    public boolean compruebaPiezasIntermedias(int nuevaFila, int nuevaColumna){
        boolean posible = false;
        int comprobacion1 = nuevaFila - fila;
        int comprobacion2 = nuevaColumna -columna;

        int pasoFila;
        if (comprobacion1 > 0) pasoFila = 1;
            else if (comprobacion1 < 0) pasoFila = -1;
            else pasoFila = 0;

        int pasoColumna;
            if (comprobacion2 > 0) pasoColumna = 1;
            else if (comprobacion2 < 0) pasoColumna = -1;
            else pasoColumna = 0;

        int filaActual = fila + pasoFila;
        int columnaActual = columna + pasoColumna;

        while (filaActual != nuevaFila || columnaActual != nuevaColumna){
            if (estaOcupado(filaActual,columnaActual)){
                posible =  true;
            }else{
                filaActual += pasoFila;
                columnaActual += pasoColumna;
            }
            return posible;
        }

      public void mostrarPiezasMuertas() {
        if (piezasEliminadas.isEmpty()) {
            System.out.println("No hay piezas eliminadas.");
            return;
        }

        System.out.println("Piezas eliminadas:");
        for (Pieza p : piezasEliminadas) {
            // usamos getters directamente porque toString() está vacío
            System.out.println(
                    p.getTipoPieza() + " " + p.getColor() + " (" + p.getFila() + "," + p.getColumna() + ")"
            );
        }
    }
}