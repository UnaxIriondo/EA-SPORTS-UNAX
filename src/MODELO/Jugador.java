package MODELO;

import java.time.LocalDate;

public class Jugador {
    private String idJugador;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private LocalDate fechaNac;
    private rolJugador rolJugador;
    private double sueldo;

    //Constructor
    public Jugador() {}

    public Jugador(String idJugador, String nombre, String apellido, String nacionalidad, LocalDate fechaNac, MODELO.rolJugador rolJugador, double sueldo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fechaNac = fechaNac;
        this.rolJugador = rolJugador;
        this.sueldo = sueldo;
    }

    //Get y Set

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public MODELO.rolJugador getRolJugador() {
        return rolJugador;
    }

    public void setRolJugador(MODELO.rolJugador rolJugador) {
        this.rolJugador = rolJugador;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
