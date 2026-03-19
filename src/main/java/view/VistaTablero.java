package view;

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

    /**
     * Función que muestra el menú principal con las opciones:
     * 0 Salir
     * 1 Seleccionar pieza
     * 2 Reiniciar tablero
     * 3 Cargar tablero
     * 4 Guardar tablero
     */
    public static void mostrarMenuPrincipal() {
        VistaTablero.mostrarMensaje("\n╔═══════════════════════════════════════╗");
        VistaTablero.mostrarMensaje("║         AJEDREZ - MENÚ PRINCIPAL      ║");
        VistaTablero.mostrarMensaje("╠═══════════════════════════════════════╣");
        VistaTablero.mostrarMensaje("║  1.  Seleccionar pieza                ║");
        VistaTablero.mostrarMensaje("║  2.  Reiniciar tablero                ║");
        VistaTablero.mostrarMensaje("║  3.  Cargar tablero                   ║");
        VistaTablero.mostrarMensaje("║  4.  Guardar tablero                  ║");
        VistaTablero.mostrarMensaje("║  0.  Salir                            ║");
        VistaTablero.mostrarMensaje("╚═══════════════════════════════════════╝");
        VistaTablero.mostrarMensaje("❯ Seleccione una opción: ");
    }

    /**
     * Función que muestra el submenu Pieza
     * 0 Cancelar
     * 1 Mover
     */
    public static void mostrarMenuPiezaSeleccionada() {
        VistaTablero.mostrarMensaje("\n┌───────────────────────────┐");
        VistaTablero.mostrarMensaje("│    PIEZA SELECCIONADA     │");
        VistaTablero.mostrarMensaje("├───────────────────────────┤");
        VistaTablero.mostrarMensaje("│  [1] Mover pieza          │");
        VistaTablero.mostrarMensaje("│  [0] Cancelar             │");
        VistaTablero.mostrarMensaje("└───────────────────────────┘");
        VistaTablero.mostrarMensaje("❯ ¿Qué desea hacer? ");
    }
}