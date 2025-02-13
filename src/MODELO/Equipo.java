package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String idEquipo;
    private String nombre;
    private LocalDate fechaFund;
    private tipoEquipo tipoEquipo;
    private List<Jugador> listaJugadores;
    private List<Enfrentamiento> listaEnfrentamientos;

    public Equipo(String idEquipo, String nombre, LocalDate fechaFund, tipoEquipo tipoEquipo, List<Jugador> listaJugadores, List<Enfrentamiento> listaEnfrentamientos) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
        this.tipoEquipo = tipoEquipo;
        this.listaJugadores = listaJugadores;
        this.listaEnfrentamientos = listaEnfrentamientos;
    }
    public Equipo() {
        this.listaJugadores = new ArrayList<>();
        this.listaEnfrentamientos = new ArrayList<>();
    }

    public Equipo(String idEquipo, String nombre, LocalDate fechaFund, String tipoEquipo, ArrayList<Jugador> listaJugadores, ArrayList<Enfrentamiento> listaEnfrentamientos) {
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFund() {
        return fechaFund;
    }

    public void setFechaFund(LocalDate fechaFund) {
        this.fechaFund = fechaFund;
    }

    public MODELO.tipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(MODELO.tipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public List<Enfrentamiento> getListaEnfrentamientos() {
        return listaEnfrentamientos;
    }

    public void setListaEnfrentamientos(List<Enfrentamiento> listaEnfrentamientos) {
        this.listaEnfrentamientos = listaEnfrentamientos;
    }
}