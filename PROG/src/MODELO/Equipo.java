package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String idEquipo;
    private String nombre;
    private LocalDate fechaFund;
    private List<Jugador> listaJugadores;
    private List<Enfrentamiento> listaEnfrentamientos;

    public Equipo(String idEquipo, String nombre, LocalDate fechaFund) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
    }

    public Equipo(String idEquipo, String nombre, LocalDate fechaFund, List<Jugador> listaJugadores, List<Enfrentamiento> listaEnfrentamientos) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
        this.listaJugadores = listaJugadores;
        this.listaEnfrentamientos = listaEnfrentamientos;
    }

    public Equipo() {
        this.listaJugadores = new ArrayList<>();
        this.listaEnfrentamientos = new ArrayList<>();
    }

    public Equipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(String idEquipo, String nombre, LocalDate fechaFund, MODELO.tipoEquipo tipoEquipo) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
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

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo='" + idEquipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaFund=" + fechaFund +
                '}';
    }

    public void agregarJugador(Jugador jugador) {
        if (!listaJugadores.contains(jugador)) {
            listaJugadores.add(jugador);
            jugador.setEquipo(this); // Vincular el jugador con el equipo
        }
    }
    public void eliminarJugador(Jugador jugador) {
        listaJugadores.remove(jugador);
    }


}