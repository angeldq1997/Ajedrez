package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.TipoPieza;

public class Alfil extends Pieza {

    public Alfil(int x, int y, Color color) {
        super(x, y, color, 3);
        this.tipoPieza = TipoPieza.ALFIL;
        if (this.getColor() == Color.BLANCO) {
            this.setIcono('♗');
        } else {
            this.setIcono('♝');
        }
    }

    @Override
    public boolean puedeMover(int xDestino, int yDestino) {
        boolean posible = false;
        int diferenciaFilas = yDestino - this.getY();
        int diferenciaColumnas = xDestino -this.getX();
        if (Math.abs(diferenciaFilas) == Math.abs(diferenciaColumnas)){
            posible = true;
        }else{
            throw  new IllegalArgumentException("Movimiento inválido.");
        }
        return posible;
    }

    @Override
    public Pieza copiar() {
        return new Alfil(this.getX(), this.getY(), this.getColor());
    }
}