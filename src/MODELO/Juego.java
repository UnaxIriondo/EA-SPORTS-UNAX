package MODELO;

public class Juego {
    private int idJuego;
    private tipoJuego juego;
    private Competicion competicion; //Relacion objeto competicion

    public Juego(int idJuego, tipoJuego juego) {
        this.idJuego = idJuego;
        this.juego = juego;
    }

    public Juego() {
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public tipoJuego getJuego() {
        return juego;
    }

    public void setJuego(tipoJuego juego) {
        this.juego = juego;
    }
}
