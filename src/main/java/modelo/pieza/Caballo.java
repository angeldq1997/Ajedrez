package modelo.pieza;
import modelo.Color;
import modelo.Pieza;
import modelo.Saltadora;
import modelo.TipoPieza;

public class Caballo extends Pieza implements Saltadora {

    public Caballo(int columna, int fila, Color color) {
        super(columna, fila, color, 3, TipoPieza.CABALLO);
        extracted();
    }

    private void extracted() {
        if(Color.valueOf("NEGRA").equals(Color.NEGRA)){
            super.setForma("♞");
        }else{
            super.setForma("♘");
        }
    }

    @Override
    public boolean atacar() {
        return false;
    }

    @Override
    public boolean mover() {
        return false;
    }
}