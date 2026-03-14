package utils;
import view.VistaTablero;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Utils {

    /**
     * Solicita al usuario un número entero por consola y verifica que la entrada sea correcta.
     * Si el usuario introduce un valor que no es un entero (por ejemplo, texto o decimales),
     * la función muestra un mensaje de error y vuelve a pedir el número hasta que sea válido.
     * @param msn      mensaje que se muestra al usuario para solicitar el número
     * @param msnError mensaje que se muestra cuando la entrada no es válida
     * @return el número entero introducido correctamente por el usuario
     */
    public static int pideEntero(String msn, String msnError) {
        int resultado = 0;
        boolean esValido = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(msn);
                resultado = sc.nextInt();
                esValido = true;
            } catch (InputMismatchException e) {
                System.out.println(msnError);
                esValido = false;
                sc.nextLine();

            }
        } while (!esValido);
        return resultado;
    }

    /**
     * Lee un número entero introducido por el usuario y verifica que esté dentro de un rango
     * específico definido por min y max.
     * Si el número está fuera del rango, se muestra un mensaje de aviso y se vuelve a solicitar la entrada.
     * @param min      valor mínimo permitido (incluido)
     * @param max      valor máximo permitido (incluido)
     * @param msn      mensaje que se muestra para pedir el número
     * @param msnError mensaje que se muestra cuando la entrada no es válida
     * @return un número entero dentro del rango [min, max]
     */
    public static int pideIntAcotado(int min, int max, String msn, String msnError) {
        int resultado = 0;
        boolean esValido = false;
        do {
            resultado = pideEntero(msn, msnError);
            if (resultado >= min && resultado <= max) {
                esValido = true;
            } else {
                System.out.println(msnError);
                esValido = false;
            }
        } while (!esValido);
        return resultado;
    }

    /**
     * Method para recibir la confirmación de un usuario ante un cambio importante o que pueda tener consecuencias graves
     * @param mensajeConfirmar Mensaje para pedir de forma personalizada la confirmación al usuario
     * @return Devuelve TRUE si acepta y FALSE si introduce cualquier input salvo "SI" en texto
     */
    public static boolean confirmarInput(String mensajeConfirmar){
        boolean usuarioAcepta = false;
        VistaTablero.mostrarMensaje(mensajeConfirmar);
        String confirmar = validarString("Introduzca SI para confirmar o NO para cancelar.");
        if (confirmar.equalsIgnoreCase("SI")){
            usuarioAcepta = true;
        }
        return usuarioAcepta;
    }

    public static String validarString(String mensajeAPedir){
        Scanner keyboard =  new Scanner(System.in);
        String cadenaAValidar = "";
        VistaTablero.mostrarMensaje(mensajeAPedir);
        cadenaAValidar = keyboard.nextLine();
        if (cadenaAValidar.isBlank()){
            throw new InputMismatchException("No ha introducido texto.");
        }
        return cadenaAValidar;
    }
}