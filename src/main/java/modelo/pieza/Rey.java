package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

public class Rey extends Pieza {
    public Rey(int x, int y, Color color) {
        super(x, y, color, 100);
        this.tipoPieza = TipoPieza.REY;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♔');
        } else {
            this.setIcono('♚');
        }
    }

    /**
     * Método con el que podemos hacer que el rey se pueda mover, comprobando todo.
     * @param yDestino El número de la fila donde queremos mover la pieza
     * @param xDestino El número de la columna donde queremos mover la pieza
     * @return Devuelve true si se puede mover y false, si no se puede mover
     */

    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
    return ((Math.abs(yDestino - getY())<=1) && (Math.abs(xDestino - getX()) <=1));
    }
     

    @Override
    public Pieza copiar() {
        return new Rey(this.getX(), this.getY(), this.getColor()); // Creamos un nuevo Rey con los mismos datos actuales
    }
}