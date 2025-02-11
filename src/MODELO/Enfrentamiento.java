package MODELO;

import java.time.LocalDate;
import java.time.LocalTime;

public class Enfrentamiento {
    private String idEnfrentamiento;
    private String resultado;
    private LocalDate fecha;
    private LocalTime hora;
    private String[] equipos;

    public Enfrentamiento(String id_enfrentamiento, String resultado, LocalDate fecha, LocalTime hora, String[] equipos) {
        this.idEnfrentamiento = id_enfrentamiento;
        this.resultado = resultado;
        this.fecha = fecha;
        this.hora = hora;
        this.equipos = equipos;
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

    public String[] getEquipos() {
        return equipos;
    }

    public void setEquipos(String[] equipos) {
        this.equipos = equipos;
    }
}
