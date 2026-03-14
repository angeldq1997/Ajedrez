package view;

import controlador.ControladorTablero;

public class VistaTablero {

    /**
     * Función que muestra en pantalla un mensaje concreto.
     *
     * @param mensaje La cadena de texto del mensaje a mostrar en pantalla.
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Función que muestra en pantalla un mensaje de error.
     *
     * @param mensaje La cadena de texto a mostrar en pantalla sobre el error (sin la palabra error que ya la añade la función).
     */
    public static void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    public static void mostrarMenuPrincipal() {
        VistaTablero.mostrarMensaje("\n--- MENÚ PRINCIPAL ---");
        VistaTablero.mostrarMensaje("0. Salir");
        VistaTablero.mostrarMensaje("1. Seleccionar pieza");
        VistaTablero.mostrarMensaje("2. Reiniciar tablero");
        VistaTablero.mostrarMensaje("3. Cargar tablero");
        VistaTablero.mostrarMensaje("4. Guardar tablero");
    }

    public static void mostrarMenuPiezaSeleccionada() {
        VistaTablero.mostrarMensaje("\n--- PIEZA SELECCIONADA ---");
        VistaTablero.mostrarMensaje("0. Cancelar");
        VistaTablero.mostrarMensaje("1. Mover");
    }
}