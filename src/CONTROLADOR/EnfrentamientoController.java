package CONTROLADOR;

import MODELO.Enfrentamiento;
import MODELO.Equipo;
import MODELO.Jornada;
import UTILITIS.SolicitarValidarDatos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;



public class EnfrentamientoController {
    //TODO FALTA VALIDACIONES DE EXPRESIONREGULAR
    public static void crearEnfrentamiento(Jornada jornada, ArrayList<Equipo> listaEquipos) {
        String idEnfrentamiento = SolicitarValidarDatos.solicitarDato("Id Enfrentamiento","Teclea el id del enfrentamiento","");
        String resultado = SolicitarValidarDatos.solicitarDato("Resultado","Teclea resultado del enfrentamiento","");
        LocalDate fecha = LocalDate.parse(SolicitarValidarDatos.solicitarDato("Fecha","Teclea la fecha del enfrentamiento",""));
        LocalTime hora = LocalTime.parse(SolicitarValidarDatos.solicitarDato("Hora","Teclea la hora del enfrentamiento",""));


        Enfrentamiento enfrentamiento = new Enfrentamiento();
        enfrentamiento.setIdEnfrentamiento(idEnfrentamiento);
        enfrentamiento.setResultado(resultado);
        enfrentamiento.setFecha(fecha);
        enfrentamiento.setHora(hora);
        enfrentamiento.setListaEquipos(listaEquipos);

        jornada.getEnfrentamientos().add(enfrentamiento);
        System.out.println("Enfrentamiento creado y añadido con exito");
    };
    public static void eliminarEnfrentamiento(Jornada jornada, String id_enfrentamiento) {

        System.out.println("Escribe el ID del enfrentamiento que quieras eliminar");
        Scanner sc = new Scanner(System.in);
        String idEnfrentamiento = sc.nextLine();

        Enfrentamiento enfrentamientoparaeliminar = new Enfrentamiento();
        for (Enfrentamiento enfrentamiento : jornada.getEnfrentamientos()) {
            if (enfrentamiento.getIdEnfrentamiento().equals(idEnfrentamiento)) {
                enfrentamientoparaeliminar = enfrentamiento;
                break;
            }
        }
    if (enfrentamientoparaeliminar != null) {
        jornada.getEnfrentamientos().remove(enfrentamientoparaeliminar);
        System.out.println("Enfrentamiento eliminado");
    }else {System.out.println("Enfrentamiento no encontrado");}
    };



    public static void modificarEnfrentamiento(Jornada jornada, String id_enfrentamiento, String nuevoresultado, LocalDate nuevafecha, LocalTime nuevaHora) {
        if (jornada.getEnfrentamientos().contains(id_enfrentamiento)){

            Enfrentamiento enfrentamiento = jornada.getEnfrentamientos().get(Integer.parseInt(id_enfrentamiento));
            enfrentamiento.setResultado(nuevoresultado);
            enfrentamiento.setFecha(nuevafecha);
            enfrentamiento.setHora(nuevaHora);

        }else {System.out.println("Enfrentamiento no encontrado");}

    };




    public static void mostarEnfrentamiento(String id_enfrentamiento) {

    };
    public static void mostrarEnfrentamientos() {

    };
}
