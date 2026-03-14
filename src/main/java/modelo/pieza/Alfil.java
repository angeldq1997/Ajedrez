package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.TipoPieza;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Alfil extends Pieza {

    public Alfil (){}

    public Alfil(int columna, int fila, Color color) {
        super(columna, fila, color, 3);
        this.tipoPieza = TipoPieza.ALFIL;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♔');
        } else {
            this.setIcono('♚');
        }

    }

    @Override
    public boolean puedeMover(int filaDestino, int columnaDestina) {
            boolean posible = false;
            int diferenciafilas = filaDestino - this.getY();
            int diferenciacolumnas = columnaDestina -this.getX();
            if (Math.abs(diferenciafilas) == Math.abs(diferenciacolumnas)){
                this.setY(filaDestino);
                this.setX(columnaDestina);
            }else{
                System.out.println("Movimiento invalido.");
                posible = false;
            }
            return posible;
    }

    @Override
    public Pieza copiar() {
        return new Alfil(getX(), getY(), getColor());
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO) {
            return "♗";
        } else {
            return "♝";
        }
    }

}