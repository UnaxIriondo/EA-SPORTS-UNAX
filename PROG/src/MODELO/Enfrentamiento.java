package MODELO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Enfrentamiento {
    private String idEnfrentamiento;
    private String resultado;
    private LocalDate fecha;
    private LocalTime hora;
    private ArrayList<Equipo> listaEquipos;

    public Enfrentamiento() {
    }

    public String getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(String idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
}
