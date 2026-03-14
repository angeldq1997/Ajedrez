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

    public static void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Seleccionar pieza");
        System.out.println("2. Reiniciar tablero");
        System.out.println("3. Cargar tablero");
        System.out.println("4. Guardar tablero");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void mostrarMenuPiezaSeleccionada() {
        System.out.println("\n--- PIEZA SELECCIONADA ---");
        System.out.println("1. Mover");
        System.out.println("2. Cancelar");
        System.out.print("Selecciona una opción: ");
    }
}