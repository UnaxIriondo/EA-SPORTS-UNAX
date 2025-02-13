package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;

public class JornadaDAO {
    public static void insertarJornada(ArrayList<Jornada> listaJornadas, String numJornada, LocalDate fechaInicio) {
        Jornada jornada = new Jornada(numJornada, fechaInicio, new ArrayList<Enfrentamiento>());
        listaJornadas.add(jornada);
        System.out.println("Jornada creada con éxito.");
    }

    public static void eliminarJornadaDAO(ArrayList<Jornada> listaJornadas, String idJornada) {
        Jornada jornadaAEliminar = null;
        for (Jornada jornada : listaJornadas) {
            if (jornada.getNumJornada().equals(idJornada)) {
                jornadaAEliminar = jornada;
                break;
            }
        }

        if (jornadaAEliminar != null) {
            listaJornadas.remove(jornadaAEliminar);
            System.out.println("Jornada eliminada con éxito.");
        } else {
            System.out.println("Jornada no encontrada.");
        }
    }

    public static void modificarJornadaDAO(ArrayList<Jornada> listaJornadas, String idJornada, LocalDate nuevaFecha) {
        for (Jornada jornada : listaJornadas) {
            if (jornada.getNumJornada().equals(idJornada)) {
                jornada.setFechaInicio(nuevaFecha);
                System.out.println("Jornada modificada con éxito.");
                return;
            }
        }
        System.out.println("Jornada no encontrada.");
    }

    public static void mostrarJornadaDAO(ArrayList<Jornada> listaJornadas, String idJornada) {
        for (Jornada jornada : listaJornadas) {
            if (jornada.getNumJornada().equals(idJornada)) {
                System.out.println("Jornada: " + jornada.getNumJornada());
                System.out.println("Fecha de Inicio: " + jornada.getFechaInicio());
                System.out.println("Enfrentamientos: " + jornada.getEnfrentamientos().size());
                return;
            }
        }
        System.out.println("Jornada no encontrada.");
    }

    public static void mostrarJornadasDAO(ArrayList<Jornada> listaJornadas) {
        if (listaJornadas.isEmpty()) {
            System.out.println("No hay jornadas registradas.");
            return;
        }
        for (Jornada jornada : listaJornadas) {
            System.out.println("Jornada: " + jornada.getNumJornada() + " | Fecha de Inicio: " + jornada.getFechaInicio() + " | Enfrentamientos: " + jornada.getEnfrentamientos().size());
        }
    }
}
