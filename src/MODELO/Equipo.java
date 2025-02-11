package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String id_equipo;
    private String nombre;
    private LocalDate fecha_fund;
    private List<Jugador> listajugadores;

    public Equipo(String id_equipo, String nombre, LocalDate fecha_fund) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.fecha_fund = fecha_fund;
        this.listajugadores = new ArrayList<>();
    }

    public String getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(String id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_fund() {
        return fecha_fund;
    }

    public void setFecha_fund(LocalDate fecha_fund) {
        this.fecha_fund = fecha_fund;
    }

    public List<Jugador> getListajugadores() {
        return listajugadores;
    }

    public void setListajugadores(List<Jugador> listajugadores) {
        this.listajugadores = listajugadores;
    }
}