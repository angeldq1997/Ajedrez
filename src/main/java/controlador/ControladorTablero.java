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

    public void setColorTurno(Color colorTurno) {
        this.colorTurno = colorTurno;
    }

    public void setPiezaActual(Pieza piezaActual) {
        this.piezaActual = piezaActual;
    }

    /**
     * Función que inicia la aplicación mostrando menu principal, estableciendo el tablero a su estado inicial
     */
    public void iniciarApp() {
        Tablero t = new Tablero(8, 8);
        setTableroActual(t);
        setColorTurno(Color.BLANCO);
        menuPrincipal();
    }

    /**
     * Función que muestra el menú principal, moviendo al usuario por las diferentes opciones y saliendo de este cuando lo desea el usuario
     * 0. Salir
     * 1. Seleccionar pieza
     * 2. Reiniciar tablero
     * 3. Cargar tablero
     * 4. Guardar tablero
     */
    public void menuPrincipal() {
        boolean enMenu = true;
        do {
            estadoActual();
            VistaTablero.mostrarMenuPrincipal();
            int opcion = Utils.pideIntAcotado(0, 4, "Introduce opción:", "Error, debe introducir un número entre 0 y 4");
            switch (opcion) {
                case 0:
                    VistaTablero.mostrarMensaje("Ha seleccionado salir del programa. Gracias por su tiempo.");
                    enMenu = false;
                    break;

                case 1:
                    try {
                        subMenuPiezaSeleccionada(seleccionarPieza());
                        //subMenuPiezaSeleccionada(seleccionarPiezaConLetra());
                    } catch (IllegalArgumentException e) {
                        VistaTablero.mostrarMensaje(e.getMessage());
                    }
                    break;

                case 2:
                    resetearTablero();
                    break;

                case 3:
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
     * Submenú que permite tras haber seleccionado una pieza, mover a una posición o cancelar
     * 0. Cancelar
     * 1. Mover
     */
    public void subMenuPiezaSeleccionada(Pieza pieza) {
        boolean quedarseEnMenu = true;
        setPiezaActual(pieza);
        do {
            VistaTablero.mostrarMenuPiezaSeleccionada();
            VistaTablero.mostrarMensaje("Pieza seleccionada: " + pieza.toString());
            mostrarTablero();
            int opcion = Utils.pideIntAcotado(0, 1, "Introduce opción: ", "Error, debe introducir un número entre 0 y 1");
            switch (opcion) {
                case 0:
                    VistaTablero.mostrarMensaje("Ha seleccionado deshacer la selección de pieza.");
                    quedarseEnMenu = false;
                    break;

                case 1:
                    if (realizaMovimientoPieza()) {
                        cambiaTurno();
                        quedarseEnMenu = false;
                    }
                    break;

                default:
                    VistaTablero.mostrarError("se ha seleccionado una opción incorrecta, inténtelo de nuevo.");
            }
        } while (quedarseEnMenu);
    }

    /**
     * Función que permite resetear el tablero a su configuración original
     */
    public void resetearTablero(){
        setTableroActual(new Tablero(8, 8));
        VistaTablero.mostrarMensaje("Tablero reseteado correctamente.");
    }

    /**
     * Función que muestra el estado actual de la partida, mostrando:
     * Jaques si hay, el turno actual, las piezas eliminadas, la puntuacion de ambos colores y el tablero
     */
    public void estadoActual() {
        mostrarJaques();
        VistaTablero.mostrarMensaje("Es el turno de las piezas de color: " + colorTurno);
        tableroActual.mostrarPiezasMuertas();
        VistaTablero.mostrarMensaje("La puntuación actual de piezas blancas en juego es: " + tableroActual.puntuacionColor(Color.BLANCO));
        VistaTablero.mostrarMensaje("La puntuación actual de piezas negras en juego es: " + tableroActual.puntuacionColor(Color.NEGRO));
        mostrarTablero();
    }

    /**
     * Función que muestra los jaques si hay uno comenta a cuál, si no hay ninguno lo muestra por pantalla también
     */
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

    /**
     * Función que permite seleccionar una pieza concreta introduciendo columna y fila
     * @return Devuelve la pieza si la ha encontrado si no lanza excepción
     */
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

    /**
     * NO SE ACABA UTILIZANDO PERO LA IDEA ES SUSTITUIR EN CASO DE QUERER UTILIZAR LETRAS PARA LAS COLUMNAS
     * Función que permite seleccionar una pieza del tablero mediante la columna y fila, recibiendo el input del usuario:
     * como carácter para la letra y como entero para la fila
     * @return Devuelve la pieza encontrada en el array correspondiente
     */
    public Pieza seleccionarPiezaConLetra(){
        Pieza p = null;
        char columna = Utils.validarChar("Introduzca columna de la pieza");
        int x = comprobarLetra(columna);
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

    /**
     * Función que devuelve el valor de la columna como entero dependiendo de la letra introducida
     * @param letra Letra para modificar el valor A = 0 hasta H = 7
     * @return devuelve el entero correspondiente a la letra
     */
    public int comprobarLetra(char letra){
        int columna = -1;
        switch(letra){
            case 'A', 'a' -> columna = 0;
            case 'B', 'b' -> columna = 1;
            case 'C', 'c' -> columna = 2;
            case 'D', 'd' -> columna = 3;
            case 'E', 'e' -> columna = 4;
            case 'F', 'f' -> columna = 5;
            case 'G', 'g' -> columna = 6;
            case 'H', 'h' -> columna = 7;
            default -> throw new InputMismatchException("La letra introducida no corresponde a una letra entre A y H");
        }
        return columna;
    }

    /**
     * Muestra el tablero en consola mediante su toString
     */
    public void mostrarTablero() {
        VistaTablero.mostrarMensaje(tableroActual.toString());
    }

    /**
     * Función que realiza un movimiento de la pieza si el movimiento es correcto si captura una excepción lanza un mensaje
     * @return True si ha realizado el movimiento tras comprobar si es correcto o FALSE si no lo ha realizado
     */
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
        return movimientoCorrecto;
    }

    /**
     * Función que cambia el turno dependiendo del actual, pasa del Blanco al Negro y viceversa
     */
    public void cambiaTurno(){
        if (this.colorTurno == Color.BLANCO) {
            this.setColorTurno(Color.NEGRO);
        } else {
            this.setColorTurno(Color.BLANCO);
        }
    }

    /**
     * Función que permite cargar el tablero preguntando previamente si quieres cargarlo para no perder datos
     * Muestra si no se ha podido cargar o si se ha cancelado
     */
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
                setTableroActual( XMLManager.readXML(tableroActual, nombreArchivo) );
                VistaTablero.mostrarMensaje("Se ha cargado correctamente.");
            } else {
                VistaTablero.mostrarMensaje("No se ha podido cargar el tablero.");
            }
        } else {
            VistaTablero.mostrarMensaje("Se ha cancelado cargar el tablero.");
        }
    }

    /**
     * Función que almacena el tablero con los datos, permitiendo un nombre personalizado, lanza excepción si no ha sido posible
     */
    public void guardarTablero() {
        String nombreArchivo = "ERROR";
        try {
            nombreArchivo = Utils.validarString("Introduzca nombre de archivo para guardar el tablero (sin la extensión .xml).");
            nombreArchivo += ".xml";
        } catch (InputMismatchException e) {
            VistaTablero.mostrarMensaje(e.getMessage());
        }
        if (!nombreArchivo.equalsIgnoreCase("ERROR.xml") || !nombreArchivo.isBlank()) {
            try{
                XMLManager.writeXML(tableroActual, nombreArchivo);
                VistaTablero.mostrarMensaje("Se ha guardado correctamente.");
            } catch (RuntimeException e) {
                VistaTablero.mostrarError(e.getMessage());
            }
        } else {
            VistaTablero.mostrarMensaje("No se ha podido guardar el tablero, no se ha asignado un nombre válido.");
        }
    }
}