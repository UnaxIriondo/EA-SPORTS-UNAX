package MODELO;

import java.util.List;

public class Competicion {
    private String idCompeticion;
    private estadoCompeticion estado;
    private List<Jornada> listaJornadas;
    private Equipo ganador;
    private Juego juego;

    public Competicion() {
    }

    public Competicion(String idCompeticion, estadoCompeticion estado, List<Jornada> listaJornadas, Equipo ganador, Juego juego) {
        this.idCompeticion = idCompeticion;
        this.estado = estado;
        this.listaJornadas = listaJornadas;
        this.ganador = ganador;
        this.juego = juego;
    }


    public String getIdCompeticion() {
        return idCompeticion;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void setIdCompeticion(String idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public estadoCompeticion getEstado() {
        return estado;
    }

    public void setEstado(estadoCompeticion estado) {
        this.estado = estado;
    }

    public List<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(List<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }
}
