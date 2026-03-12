package modelo.pieza;
import modelo.*;

public class Caballo extends Pieza implements Saltadora {
    public Caballo(int x, int y, Color color) {
        super(x, y, color, 3);
        this.tipoPieza = TipoPieza.CABALLO;
        if (this.getColor() == Color.BLANCO)
            this.setIcono('♘');
        else
            this.setIcono('♞');
    }

    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
        return (yDestino - getY())*(yDestino - getY()) +(xDestino - getX())*(xDestino - getX()) == 5;
    }

    @Override
    public Pieza copiar() {
        return new Caballo(this.getX(), this.getY(), this.getColor());
    }

    public String toString() {
        if (this.getColor() == Color.BLANCO)
            return "♘";
        else
            return "♞";
    }
}