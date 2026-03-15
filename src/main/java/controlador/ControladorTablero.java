package controlador;

import modelo.*;
import utils.Utils;
import utils.XMLManager;
import view.VistaTablero;

import java.util.InputMismatchException;

public class ControladorTablero {
    private Tablero tableroActual;
    private Color colorTurno;
    private Pieza piezaActual;

    public void setTableroActual(Tablero tableroActual) {
        this.tableroActual = tableroActual;
    }

    public Color getColorTurno() {
        return colorTurno;
    }

    public void setColorTurno(Color colorTurno) {
        this.colorTurno = colorTurno;
    }

    public Pieza getPiezaActual() {
        return piezaActual;
    }

    public void setPiezaActual(Pieza piezaActual) {
        this.piezaActual = piezaActual;
    }

    public void iniciarApp() {
        menuPrincipal();
        Tablero t = new Tablero();
        setTableroActual(t);
        setColorTurno(Color.BLANCO);
    }


    /**
     * 1. Seleccionar pieza
     * 2. Reiniciar tablero
     * 3. Cargar tablero
     * 4. Guardar tablero
     * 0. Salir
     */
    public void menuPrincipal() {
        boolean enMenu = true;
        estadoActual();

        do {
            VistaTablero.mostrarMenuPrincipal();
            int opcion = Utils.pideIntAcotado(0, 4, "Introduce opción.", "Error, debe introducir un número entre 0 y 4");
            switch (opcion) {
                case 0:
                    VistaTablero.mostrarMensaje("Ha seleccionado salir del programa. Gracias por su tiempo.");
                    enMenu = false;
                    break;

                case 1:
                    try {
                        subMenuPiezaSeleccionada(seleccionarPieza());
                    } catch (IllegalArgumentException e) {
                        VistaTablero.mostrarMensaje(e.getMessage());
                    }
                    break;

                case 2:
                    tableroActual.resetearTablero();
                    break;

                case 3:
                    //TODO: PENDIENTE DE TERMINAR ACTUALIZANDO TABLERO CON ROOT_ELEMENT Y ELEMENT
                    cargarTablero();
                    break;

                case 4:
                    guardarTablero();
                    break;

                default:
                    VistaTablero.mostrarError("se ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (enMenu);
    }

    /**
     * 0. Cancelar
     * 1. Mover
     */
    public void subMenuPiezaSeleccionada(Pieza pieza) {
        boolean quedarseEnMenu = true;
        setPiezaActual(pieza);
        VistaTablero.mostrarMensaje("Pieza seleccionada: " + pieza.toString());
        do {
            int opcion = Utils.pideIntAcotado(0, 1, "Introduce opción.", "Error, debe introducir un número entre 0 y 1");
            VistaTablero.mostrarMenuPiezaSeleccionada();
            switch (opcion) {
                case 0:
                    VistaTablero.mostrarMensaje("Ha seleccionado deshacer la selección de pieza.");
                    quedarseEnMenu = false;
                    break;

                case 1:
                    if (realizaMovimientoPieza()) {
                        quedarseEnMenu = false;
                    }
                    break;

                default:
                    VistaTablero.mostrarError("se ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (quedarseEnMenu);
    }

    public void estadoActual() {
        mostrarJaques();
        VistaTablero.mostrarMensaje("Es el turno de las piezas de color: " + colorTurno);
        tableroActual.mostrarPiezasMuertas();
        VistaTablero.mostrarMensaje("La puntuación actual de piezas blancas en juego es: " + tableroActual.puntuacionColor(Color.BLANCO));
        VistaTablero.mostrarMensaje("La puntuación actual de piezas negras en juego es: " + tableroActual.puntuacionColor(Color.NEGRO));
        mostrarTablero();
    }

    public void mostrarJaques(){
        String jaque = "";
        for (Pieza pieza: this.tableroActual.getPiezasBlancas()){
            if( this.tableroActual.hayJaque(pieza) ){
                jaque += "\nHay un jaque al rey negro por parte de: " + pieza;
            }
        }
        for (Pieza pieza: this.tableroActual.getPiezasNegras()){
            if( this.tableroActual.hayJaque(pieza) ){
                jaque += "\nHay un jaque al rey blanco por parte de: " + pieza;
            }
        }
        if (jaque.isEmpty()){
            VistaTablero.mostrarMensaje("No hay jaque actualmente a ningún rey.");
        }else{
            VistaTablero.mostrarMensaje(jaque);
        }
    }

    public Pieza seleccionarPieza() {
        Pieza p = null;
        int x = Utils.pideEntero("Introduzca columna de la pieza", "Error debe introducir un número entero.");
        int y = Utils.pideEntero("Introduzca fila de la pieza", "Error debe introducir un número entero.");
        p = tableroActual.getPieza(x, y);
        if (p == null) {
            throw new IllegalArgumentException("Error, la pieza con las posiciones introducidas no se encuentra.");
        } else if (p.getColor() != colorTurno) {
            throw new IllegalArgumentException("ERROR, la pieza seleccionada es del equipo contrario.");
        }
        VistaTablero.mostrarMensaje("Pieza seleccionada correctamente.");
        return p;
    }

    public void mostrarTablero() {
        VistaTablero.mostrarMensaje(tableroActual.toString());
    }

    public boolean realizaMovimientoPieza() {
        int x = Utils.pideEntero("Introduzca columna destino para el movimiento.", "No ha introducido un número entero.");
        int y = Utils.pideEntero("Introduzca fila destino para el movimiento.", "No ha introducido un número entero.");
        boolean movimientoCorrecto = false;
        try {
            if (!this.tableroActual.movimientoPiezaCorrecto(x, y, piezaActual)) {
                movimientoCorrecto = false;
            } else {
                movimientoCorrecto = true;
            }
        } catch (IllegalArgumentException e) {
            VistaTablero.mostrarMensaje(e.getMessage());
        }
        if (this.colorTurno == Color.BLANCO) {
            this.colorTurno = Color.NEGRO;
        } else {
            this.colorTurno = Color.BLANCO;
        }
        return movimientoCorrecto;
    }

    public void cargarTablero() {
        if (Utils.confirmarInput("¿Está seguro que desea cargar el tablero? Recomendamos guardar el actual para no perder los datos.", "Se ha confirmado cargar el tablero sobreescribiendo el estado anterior.")) {
            String nombreArchivo = "ERROR";
            try {
                nombreArchivo = Utils.validarString("Introduzca nombre de archivo para cargar el tablero (sin la extensión .xml).");
                nombreArchivo += ".xml";
            } catch (InputMismatchException e) {
                VistaTablero.mostrarMensaje(e.getMessage());
            }
            if (!nombreArchivo.equalsIgnoreCase("ERROR") || !nombreArchivo.isBlank()) {
                XMLManager.readXML(tableroActual, nombreArchivo);
            } else {
                VistaTablero.mostrarMensaje("No se ha podido cargar el tablero.");
            }
        } else {
            VistaTablero.mostrarMensaje("Se ha cancelado cargar el tablero.");
        }
    }

    public void guardarTablero() {
        String nombreArchivo = "ERROR";
        try {
            nombreArchivo = Utils.validarString("Introduzca nombre de archivo para guardar el tablero (sin la extensión .xml).");
            nombreArchivo += ".xml";
        } catch (InputMismatchException e) {
            VistaTablero.mostrarMensaje(e.getMessage());
        }
        if (!nombreArchivo.equalsIgnoreCase("ERROR") || !nombreArchivo.isBlank()) {
            XMLManager.readXML(tableroActual, nombreArchivo);
        } else {
            VistaTablero.mostrarMensaje("No se ha podido cargar el tablero.");
        }
    }
}