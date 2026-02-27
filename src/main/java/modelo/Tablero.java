package modelo;

public class Tablero {
    String[] matriz;

    public Tablero() {
        this.matriz = new String[64];
    }

    public String getMatriz() {
        String comp = "";
        for (String s: this.matriz){
            comp += s;
        }
        return comp;
    }

    public void setMatriz(String[] matriz) {
        this.matriz = matriz;
    }
}
