package modelo;
public class Casilla {
    private Pieza pieza;
    private Color colorCasilla;
    private char icono;
    private boolean estaOcupada;

    public Casilla() {
        this.pieza = null;
        this.colorCasilla = null;
        this.icono = ' ';
        this.estaOcupada = false;
    }

    public Casilla(Pieza pieza, Color colorCasilla, char icono) {
        this.pieza = pieza;
        this.colorCasilla = colorCasilla;
        this.icono = icono;
        this.estaOcupada = false;
    }

    public char getIcono() {
        return icono;
    }

    public void setIcono(char icono) {
        this.icono = icono;
    }

    public void setPieza(Pieza pieza){
        this.pieza = pieza;
        this.icono = pieza.getIcono();
        this.estaOcupada = true;
    }

    public void unsetPieza(){
        this.pieza = null;
        if (this.colorCasilla == Color.BLANCO){
            this.setIcono('░');
        }else{
            this.setIcono('▓');
        }
        this.estaOcupada = false;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public Color getColorCasilla() {
        return colorCasilla;
    }

    public void setColorCasilla(Color colorCasilla) {
        this.colorCasilla = colorCasilla;
    }

    public boolean estaOcupada() {
        return estaOcupada;
    }

    public void setEstaOcupada(boolean estaOcupada) {
        this.estaOcupada = estaOcupada;
    }
}
