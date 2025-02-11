package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String idEquipo;
    private String nombre;
    private LocalDate fechaFund;
    private List<Jugador> listajugadores;

    public Equipo(String idEquipo, String nombre, LocalDate fechaFund) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
        this.listajugadores = new ArrayList<>();
    }

    public String getId_equipo() {
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

    public void setFecha_fund(LocalDate fechaFund) {
        this.fechaFund = fechaFund;
    }

    public List<Jugador> getListajugadores() {
        return listajugadores;
    }

    public void setListajugadores(List<Jugador> listajugadores) {
        this.listajugadores = listajugadores;
    }
}