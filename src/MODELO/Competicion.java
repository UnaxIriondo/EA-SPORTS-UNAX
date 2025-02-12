package MODELO;

import java.util.List;

public class Competicion {
    private String idCompeticion;
    private estadoCompeticion estado;
    private List<Jornada> listaJornadas;
    private Equipo ganador;

    public Competicion() {
    }

    public Competicion(String idCompeticion, estadoCompeticion estado, List<Jornada> listaJornadas, Equipo ganador) {
        this.idCompeticion = idCompeticion;
        this.estado = estado;
        this.listaJornadas = listaJornadas;
        this.ganador = ganador;
    }


    public String getIdCompeticion() {
        return idCompeticion;
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
