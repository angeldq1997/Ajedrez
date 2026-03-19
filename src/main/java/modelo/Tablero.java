package modelo;
import modelo.pieza.*;
import view.VistaTablero;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "tablero")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tablero implements Serializable {
    @XmlElementWrapper(name = "PiezasBlancas")
    @XmlElements({
            @XmlElement(name= "Alfil", type = Alfil.class),
            @XmlElement(name= "Caballo", type = Caballo.class),
            @XmlElement(name= "Peon", type = Peon.class),
            @XmlElement(name= "Reina", type = Reina.class),
            @XmlElement(name= "Rey", type = Rey.class),
            @XmlElement(name= "Torre", type = Torre.class)
    })
    private ArrayList<Pieza> piezasBlancas;
    @XmlElementWrapper(name = "PiezasNegras")
    @XmlElements({
            @XmlElement(name= "Alfil", type = Alfil.class),
            @XmlElement(name= "Caballo", type = Caballo.class),
            @XmlElement(name= "Peon", type = Peon.class),
            @XmlElement(name= "Reina", type = Reina.class),
            @XmlElement(name= "Rey", type = Rey.class),
            @XmlElement(name= "Torre", type = Torre.class)
    })
    private ArrayList<Pieza> piezasNegras;
    @XmlElementWrapper(name = "PiezasEliminadas")
    @XmlElements({
            @XmlElement(name= "Alfil", type = Alfil.class),
            @XmlElement(name= "Caballo", type = Caballo.class),
            @XmlElement(name= "Peon", type = Peon.class),
            @XmlElement(name= "Reina", type = Reina.class),
            @XmlElement(name= "Rey", type = Rey.class),
            @XmlElement(name= "Torre", type = Torre.class)
    })
    private ArrayList<Pieza> piezasEliminadas;
    @XmlElement
    private Casilla[][] casillas;

    public Tablero(ArrayList<Pieza> piezasBlancas, ArrayList<Pieza> piezasNegras, ArrayList<Pieza> piezasEliminadas, Casilla[][] casillas) {
        this.piezasBlancas = piezasBlancas;
        this.piezasNegras = piezasNegras;
        this.piezasEliminadas = piezasEliminadas;
        this.casillas = casillas;
    }

    public Tablero(){

    }

    public Tablero(int maxX, int maxY) {
        this.piezasEliminadas = new ArrayList<Pieza>();
        this.casillas = new Casilla[maxX][maxY];
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

    /**
     * Función que coloca las piezas en la zona superior del tablero requiere el color y la lista
     * @param color Color de las piezas a colocar
     * @param piezas Array de piezas que van a colocarse
     */
    private void colocarPiezasArriba(Color color, ArrayList<Pieza> piezas) {
        for (int x = 0; x < 8; x++) {
            Peon peon = new Peon(x, 1, color);
            piezas.add(peon);
        }
        Torre torre = new Torre(0, 0, color);
        Caballo caballo = new Caballo(1, 0, color);
        Alfil alfil = new Alfil(2, 0, color);
        Reina reina = new Reina(3, 0, color);
        Rey rey = new Rey(4, 0, color);
        Alfil alfil2 = new Alfil(5, 0, color);
        Caballo caballo2 = new Caballo(6, 0, color);
        Torre torre2 = new Torre(7, 0, color);
        piezas.add(torre);
        piezas.add(torre2);
        piezas.add(caballo);
        piezas.add(caballo2);
        piezas.add(alfil);
        piezas.add(alfil2);
        piezas.add(reina);
        piezas.add(rey);
        for (Pieza p : piezas) {
            p.asignarCasilla(this.casillas);
        }
    }

    /**
     * Función que coloca las piezas en la zona inferior del tablero requiere el color y la lista
     * @param color Color de las piezas a colocar
     * @param piezas Array de piezas que van a colocarse
     */
    private void colocarPiezasAbajo(Color color, ArrayList<Pieza> piezas) {
        for (int x = 0; x < 8; x++) {
            Peon peon = new Peon(x, 6, color);
            piezas.add(peon);
        }
        Torre torre = new Torre(0, 7, color);
        Caballo caballo = new Caballo(1, 7, color);
        Alfil alfil = new Alfil(2, 7, color);
        Reina reina = new Reina(3, 7, color);
        Rey rey = new Rey(4, 7, color);
        Alfil alfil2 = new Alfil(5, 7, color);
        Caballo caballo2 = new Caballo(6, 7, color);
        Torre torre2 = new Torre(7, 7, color);
        piezas.add(torre);
        piezas.add(torre2);
        piezas.add(caballo);
        piezas.add(caballo2);
        piezas.add(alfil);
        piezas.add(alfil2);
        piezas.add(reina);
        piezas.add(rey);
        for (Pieza p : piezas) {
            p.asignarCasilla(this.casillas);
        }
    }

    /**
     * Comprobación de si está ocupada o no una posición
     * @param x Columna de la casilla
     * @param y Fila de la casilla
     * @return Devuelve TRUE si está ocupado y FALSE si no lo está
     */
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
     * Función que comprueba si hay piezas intermedias
     * @param xInicial Columna inicial (normalmente donde se encuentra la pieza)
     * @param yInicial Fila inicial (normalmente donde se encuentra la pieza)
     * @param xDestino Columna final (normalmente donde se encuentra la pieza)
     * @param yDestino Fila final (normalmente donde se encuentra la pieza)
     * @return Devuelve TRUE si hay alguna pieza y FALSE si no ha encontrado ninguna
     */
    public boolean hayPiezasIntermedias(int xInicial, int yInicial, int xDestino, int yDestino) {
        int filDir = Integer.signum(yDestino - yInicial); // +1, -1, o 0
        int colDir = Integer.signum(xDestino - xInicial); // +1, -1, o 0

        int filaActual = yInicial + filDir;
        int colActual = xInicial + colDir;

        // Recorre mientras no llegue a la casilla de destino
        while (filaActual != yDestino || colActual != xDestino) {
            if (this.casillas[colActual][filaActual].estaOcupada()) {
                return true; // Hay una pieza en el camino
            }
            filaActual += filDir;
            colActual += colDir;
        }
        return false;
    }

    /**
     * Función con la cual obtenemos el lugar exacto de la pieza
     * @param x Columna en la que se encuentra la pieza
     * @param y Fila en la que se encuentra la pieza
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

    /**
     * Función que permite vaciar las piezas del tablero moviendo todas a eliminadas y quitándolas de los arrayList
     */
    public void vaciarPiezas() {
        for (Pieza p : this.piezasBlancas) {
            piezasEliminadas.add(p);
            piezasBlancas.remove(p);
        }
        for (Pieza p2 : this.piezasNegras) {
            piezasEliminadas.add(p2);
            piezasNegras.remove(p2);
        }
    }

    /**
     * Función que hace una copia del tablero con los datos que contiene
     * @return Devuelve el tablero nuevo con los mismos datos
     */
    public Tablero copiarTablero() {
        return new Tablero(this.piezasBlancas, this.piezasNegras, this.piezasEliminadas, this.casillas);
    }

    /**
     * Función que permite agregarPieza al tablero dada una pieza concreta, un color y una posición
     * @param pieza Pieza a agregar al tablero
     * @return Devuelve TRUE si se ha podido agregar la pieza, FALSE si no ha podido agregarse
     */
    public boolean agregarPieza(Pieza pieza) {
        boolean estaAgregada = false;
        if (pieza != null && (pieza.getColor() == Color.BLANCO || pieza.getColor() == Color.NEGRO)) {
            if (pieza.getColor() == Color.BLANCO)
                this.piezasBlancas.add(pieza);
            else
                this.piezasNegras.add(pieza);
        }
        return estaAgregada;
    }

    /**
     * Función que genera una puntuación dado un color y devuelve esta
     * @param color Color del equipo para generar la puntuación
     * @return Devuelve la puntuación total
     */
    public int puntuacionColor(Color color) {
        int puntuacionTotal = 0;
        if (color == Color.BLANCO) {
            for (Pieza p : piezasBlancas)
                puntuacionTotal += p.getPuntos();
        } else if (color == Color.NEGRO) {
            for (Pieza p : piezasNegras)
                puntuacionTotal += p.getPuntos();
        } else {
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

    /**
     * Función que comprueba si hay un rey enemigo o una pieza del mismo color en la casilla destino
     * @param xDestino Columna de la casilla destino
     * @param yDestino Fila de la casilla destino
     * @param pieza Pieza de la que se toma casilla inicial
     * @return TRUE si hay rey enemigo o Pieza del mismo color y FALSE si no es el caso
     */
    public boolean hayReyEnemigoOPiezaMismoColor(int xDestino, int yDestino, Pieza pieza) {
        boolean hayReyOPieza = false;
        Casilla c = this.getCasillas()[xDestino][yDestino];
        if (pieza == null) {
            throw new IllegalArgumentException("Error, la pieza no existe.");
        }
        if (c.estaOcupada()) {
            if (c.getPieza().getColor() == pieza.getColor()) {
                hayReyOPieza = true;
                throw new IllegalArgumentException("Error, en la casilla destino hay una pieza del mismo color.");
            } else if (c.getPieza().getTipoPieza() == TipoPieza.REY) {
                hayReyOPieza = true;
                throw new IllegalArgumentException("Error, en la casilla destino está el rey enemigo.");
            }
        }
        return hayReyOPieza;
    }

    /**
     * Función para comprobar si está en los límites del tablero
     * @param x Columna del tablero
     * @param y Fila del tablero
     * @return Devuelve TRUE si está en los límites y FALSE si se encuentra fuera de estos.
     */
    public boolean estaEnLimites(int x, int y) {
        if (y < 0 || y > 7 || x < 0 || x > 7)
            throw new IllegalArgumentException("La casilla seleccionada está fuera de los límites.");
        else
            return true;
    }

    /**
     * Función que busca la posición de una pieza en el arrayList a partir de la pieza
     * @param pieza Pieza para conseguir su posición
     * @return Entero con la posición de la pieza y -1 si no la encuentra
     */
    public int posicionPieza(Pieza pieza) {
        int posicionPieza = -1;
        boolean existe = false;
        if (pieza.getColor() == Color.BLANCO) {
            for (int i = 0; i < this.getPiezasBlancas().size() && !existe; i++) {
                if (this.getPiezasBlancas().get(i).equals(pieza)) {
                    posicionPieza = i;
                    existe = true;
                }
            }
        } else {
            for (int i = 0; i < this.getPiezasNegras().size() && !existe; i++) {
                if (this.getPiezasNegras().get(i).equals(pieza)) {
                    posicionPieza = i;
                    existe = true;
                }
            }
        }
        return posicionPieza;
    }

    /**
     * Función que comprueba las piezas intermedias dada una posición para comprobar la casilla destino y una posición inicial
     * @param xDestino Columna final del tablero
     * @param yDestino Fila final del tablero
     * @param x Columna inicial del tablero
     * @param y Fila inicial del tablero
     * @return TRUE si hay piezas intermedias y FALSE si no lo encuentra
     */
    public boolean compruebaPiezasIntermedias(int xDestino, int yDestino, int x, int y) {
        boolean posible = false;
        int comprobacion1 = yDestino - y;
        int comprobacion2 = xDestino - x;

        int pasoFila;
        if (comprobacion1 > 0) pasoFila = 1;
        else if (comprobacion1 < 0) pasoFila = -1;
        else pasoFila = 0;

        int pasoColumna;
        if (comprobacion2 > 0) pasoColumna = 1;
        else if (comprobacion2 < 0) pasoColumna = -1;
        else pasoColumna = 0;

        int filaActual = y + pasoFila;
        int columnaActual = x + pasoColumna;

        while (filaActual != yDestino || columnaActual != xDestino) {
            if (estaOcupado(filaActual, columnaActual)) {
                posible = true;
            } else {
                filaActual += pasoFila;
                columnaActual += pasoColumna;
            }
            return posible;
        }
        return false;
    }

    /**
     * Función que muestra por pantalla las piezas eliminadas/"muertas" del tablero
     */
    public void mostrarPiezasMuertas() {
        if (piezasEliminadas.isEmpty()) {
            VistaTablero.mostrarMensaje("No hay piezas eliminadas.");
            return;
        }

        VistaTablero.mostrarMensaje("Piezas eliminadas:");
        for (Pieza p : piezasEliminadas) {
            VistaTablero.mostrarMensaje(p.toString() + "\n");
        }
    }

    /**
     * Función que elimina una pieza concreta colocándola en el arrayList de eliminadas y quitándola del arrayList propio
     * @param pieza Pieza a eliminar colocándola en eliminadas y quitándola de su arrayList
     */
    public void eliminarPieza(Pieza pieza) {
        if (pieza == null) {
            throw new IllegalArgumentException("La pieza a eliminar no existe");
        }
        if (pieza.getColor() == Color.BLANCO) {
            this.getPiezasBlancas().remove(pieza);
            this.getPiezasEliminadas().add(pieza);
        } else {
            this.getPiezasNegras().remove(pieza);
            this.getPiezasEliminadas().add(pieza);
        }
        pieza.setX(-1);
        pieza.setY(-1);
    }

    /**
     * Función que comprueba si está atacando a un rey una pieza concreta
     * @param pieza Pieza a comprobar si está atacando a un rey
     * @return Devuelve TRUE si hay jaque y FALSE si no lo hay
     */
    public boolean hayJaque(Pieza pieza) {
        boolean hayJaque = false;
        if (pieza.getColor() == Color.BLANCO) {
            try {
                movimientoPiezaCorrecto(this.getPiezasNegras().getLast().getX(), this.getPiezasNegras().getLast().getY(), pieza);
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equalsIgnoreCase("Error, en la casilla destino está el rey enemigo.")) {
                    hayJaque = true;
                }
            }
        } else {
            try {
                movimientoPiezaCorrecto(this.getPiezasBlancas().getLast().getX(), this.getPiezasNegras().getLast().getY(), pieza);
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equalsIgnoreCase("Error, en la casilla destino está el rey enemigo.")) {
                    hayJaque = true;
                }
            }
        }
        return hayJaque;
    }

    /**
     * Función que comprueba el movimiento de la pieza con las diferentes condiciones (dentro de límites, puede mover, hay piezas intermedias)
     * @param xDestino Columna de la casilla destino
     * @param yDestino Fila de la casilla destino
     * @param pieza Pieza
     * @return Devuelve TRUE si pasa todas las condiciones y FALSE si alguna no se cumple
     * Lanza excepciones para conocer que fallo ha habido
     */
    public boolean movimientoPiezaCorrecto(int xDestino, int yDestino, Pieza pieza) {
        boolean movimientoCorrecto = false;

        if (pieza == null) return false;

        if (!this.estaEnLimites(xDestino, yDestino)) {
            VistaTablero.mostrarError("Fuera de límites.");
        }

        if (pieza instanceof Peon){
            if (this.casillas[xDestino][yDestino].estaOcupada()){
                if (!compruebaAtaquePeon(xDestino, yDestino, pieza)){
                    throw new IllegalArgumentException("Error: movimiento de ataque inválido para el peón");
                }
            } else {
                if (!pieza.puedeMover(xDestino, yDestino)){
                    throw new IllegalArgumentException("Error: movimiento inválido para el peón");
                }
            }
        } else {
            if (!pieza.puedeMover(xDestino, yDestino)) {
                throw new IllegalArgumentException("ERROR: Fuera de las casillas disponibles de movimiento.");
            }
        }

        if (!(pieza instanceof Saltadora)) {
            if (this.hayPiezasIntermedias(pieza.getX(), pieza.getY(), xDestino, yDestino)) {
                throw new IllegalArgumentException("ERROR: Hay una pieza en medio del camino.");
            }
        }

        if (seDejaEnJaqueReyAliado(pieza)) {
            throw new IllegalArgumentException("Se está dejando en jaque al rey aliado");
        }

        Casilla cInicio = this.getCasillas()[pieza.getX()][pieza.getY()];
        Casilla cDestino = this.getCasillas()[xDestino][yDestino];

        if (!this.hayReyEnemigoOPiezaMismoColor(xDestino, yDestino, pieza) ) {
            if (cDestino.estaOcupada()) {
                //CASILLA DESTINO ESTÁ OCUPADA POR ENEMIGO
                VistaTablero.mostrarMensaje("La casilla destino tiene una pieza: " + cDestino.getPieza() + " se procede a su captura y eliminación.");
                this.eliminarPieza(cDestino.getPieza());

                cInicio.unsetPieza();
                cDestino.unsetPieza();
                cDestino.setPieza(pieza);
                pieza.setX(xDestino);
                pieza.setY(yDestino);
                movimientoCorrecto = true;
                VistaTablero.mostrarMensaje("Pieza movida al destino capturando correctamente.");
            } else {
                //CUANDO ESTÁ VACÍA LA CASILLA DESTINO
                cInicio.unsetPieza();
                cDestino.setPieza(pieza);
                pieza.setX(xDestino);
                pieza.setY(yDestino);
                movimientoCorrecto = true;
                VistaTablero.mostrarMensaje("Pieza movida al destino correctamente.");
            }
        } else {
            VistaTablero.mostrarMensaje("No es posible mover la pieza a la posición seleccionada.");
        }
        return movimientoCorrecto;
    }

    /**
     * Función que comprueba si el ataque del peón es válido
     * @param xDestino Columna final
     * @param yDestino Fila final
     * @param pieza Pieza (Peon) a comprobar
     * @return TRUE si puede atacar y FALSE si no es el caso
     */
    public boolean compruebaAtaquePeon(int xDestino, int yDestino, Pieza pieza) {
        boolean esPeonYPuedeAtacar = false;
        if (((Peon) pieza).puedeAtacar(xDestino, yDestino)) {
            esPeonYPuedeAtacar = true;
        }
        return esPeonYPuedeAtacar;
    }

    /**
     * Función que comprueba si se deja en jaque al equipo aliado
     * @param pieza Pieza de la que tomar el color del equipo
     * @return TRUE si se deja en jaque al rey y FALSE si no es el caso
     */
    public boolean seDejaEnJaqueReyAliado(Pieza pieza) {
        boolean hayJaque = false;
        ArrayList<Pieza> piezasAliadas = null;
        ArrayList<Pieza> piezasEnemigas = null;
        if (pieza.getColor() == Color.BLANCO){
            piezasAliadas = this.getPiezasBlancas();
            piezasEnemigas = this.getPiezasNegras();
        }else{
            piezasAliadas = this.getPiezasNegras();
            piezasEnemigas = this.getPiezasBlancas();
        }

        for (Pieza pieza1 : piezasEnemigas) {
            try {
                movimientoPiezaCorrecto(piezasAliadas.getLast().getX(), piezasAliadas.getLast().getY(), pieza1);
            } catch (IllegalArgumentException e) {
                if (e.getMessage().equalsIgnoreCase("Error, en la casilla destino está el rey enemigo.")) {
                    hayJaque = true;
                }
            }
        }
        return hayJaque;
    }

    @Override
    public String toString() {
        String tablero = "";
        for (int y = 0; y < 8; y++) {
            tablero += "\n" + y + " ";
            for (int x = 0; x < 8; x++) {
                tablero += this.getCasillas()[x][y].getIcono();
            }
        }
        return tablero;
    }
}