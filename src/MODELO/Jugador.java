package MODELO;

import java.time.LocalDate;
import java.util.List;

public class Jugador {
    private String idJugador;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private LocalDate fechaNac;
    private double sueldo;
    private Equipo equipo;
    private rolesValorant rolesValorant;
    private List<Jugador> listaJugadores;
    //Constructor
    public Jugador() {

    }

    public Jugador(String idJugador, String nombre, String apellido, String nacionalidad, LocalDate fechaNac, double sueldo, Equipo equipo, rolesValorant rolesValorant) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.equipo = equipo;
        this.rolesValorant = rolesValorant;
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public rolesValorant getRolesValorant() {
        return rolesValorant;
    }

    public void setRolesValorant(rolesValorant rolesValorant) {
        this.rolesValorant = rolesValorant;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador='" + idJugador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNac=" + fechaNac +
                ", sueldo=" + sueldo +
                ", equipo=" + equipo +
                ", rol=" + rolesValorant +
                '}';
    }
}