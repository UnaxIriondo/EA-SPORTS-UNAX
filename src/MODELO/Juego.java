package MODELO;

import java.util.List;

public class Juego {
    private int idJuego;
    private tipoJuego juego;
    private List<String> roles;
    private List<Competicion> competiciones;

    public Juego(int idJuego, tipoJuego juego, List<String> roles) {
        this.idJuego = idJuego;
        this.juego = juego;
        this.roles = roles;
    }

    public Juego(int idJuego, tipoJuego juego, List<String> roles, List<Competicion> competiciones) {
        this.idJuego = idJuego;
        this.juego = juego;
        this.roles = roles;
        this.competiciones = competiciones;
    }

    public List<Competicion> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competicion> competiciones) {
        this.competiciones = competiciones;
    }

    public Juego(int idJuego, tipoJuego juego) {
        this.idJuego = idJuego;
        this.juego = juego;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
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
