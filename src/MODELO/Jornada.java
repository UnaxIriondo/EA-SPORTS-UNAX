package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;

public class Jornada {
    private String numJornada;
    private LocalDate fechaInicio;
    private ArrayList<Enfrentamiento> enfrentamientos;

    public Jornada(String num_jornada, LocalDate fecha_inicio, ArrayList<Enfrentamiento> enfrentamientos) {
        this.numJornada = num_jornada;
        this.fechaInicio = fecha_inicio;
        this.enfrentamientos = enfrentamientos;
    }

    public String getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(String numJornada) {
        this.numJornada = numJornada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ArrayList<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(ArrayList<Enfrentamiento> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }
}

