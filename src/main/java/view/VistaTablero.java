package view;

public class VistaTablero {
    /**
     * Función que muestra en pantalla un mensaje concreto.
     * @param mensaje La cadena de texto del mensaje a mostrar en pantalla.
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Función que muestra en pantalla un mensaje de error.
     * @param mensaje La cadena de texto a mostrar en pantalla sobre el error (sin la palabra error que ya la añade la función).
     */
    public static void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }
}
