package CONTROLADOR;

import MODELO.Enfrentamiento;
import MODELO.Equipo;
import MODELO.Jornada;
import UTILITIS.SolicitarValidarDatos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static MODELO.EnfrentamientoDAO.ModificarEnfrentamiento;
import static MODELO.EnfrentamientoDAO.insertarEnfrentamiento;

public class
EnfrentamientoController {
    public static void crearEnfrentamiento(Jornada jornada, ArrayList<Equipo> listaEquipos) {
        String idEnfrentamiento = SolicitarValidarDatos.solicitarDato("Id Enfrentamiento", "Teclea el id del enfrentamiento (alfanumérico)", "^[a-zA-Z0-9]+$");
        String resultado = SolicitarValidarDatos.solicitarDato("Resultado", "Teclea el resultado del enfrentamiento (formato: N-N)", "^\\d{1,2}-\\d{1,2}$");
        String fechaStr = SolicitarValidarDatos.solicitarDato("Fecha", "Teclea la fecha del enfrentamiento (YYYY-MM-DD)", "^\\d{4}-\\d{2}-\\d{2}$");
        String horaStr = SolicitarValidarDatos.solicitarDato("Hora", "Teclea la hora del enfrentamiento (HH:MM)", "^\\d{2}:\\d{2}$");

        LocalDate fecha = LocalDate.parse(fechaStr);
        LocalTime hora = LocalTime.parse(horaStr);

        insertarEnfrentamiento(jornada, idEnfrentamiento, resultado, fecha, hora, listaEquipos);
    }

    public static void eliminarEnfrentamiento(Jornada jornada) {
        String idEnfrentamiento = SolicitarValidarDatos.solicitarDato("ID Enfrentamiento", "Teclea el ID del enfrentamiento a eliminar", "^[a-zA-Z0-9]+$");

        Enfrentamiento enfrentamientoParaEliminar = null;
        for (Enfrentamiento enfrentamiento : jornada.getEnfrentamientos()) {
            if (enfrentamiento.getIdEnfrentamiento().equals(idEnfrentamiento)) {
                enfrentamientoParaEliminar = enfrentamiento;
                break;
            }
        }

        if (enfrentamientoParaEliminar != null) {
            jornada.getEnfrentamientos().remove(enfrentamientoParaEliminar);
            System.out.println("Enfrentamiento eliminado.");
        } else {
            System.out.println("Enfrentamiento no encontrado.");
        }
    }

    public static void modificarEnfrentamiento(Jornada jornada) {
        String idEnfrentamiento = SolicitarValidarDatos.solicitarDato("ID Enfrentamiento", "Teclea el ID del enfrentamiento a modificar", "^[a-zA-Z0-9]+$");
        String nuevoResultado = SolicitarValidarDatos.solicitarDato("Nuevo Resultado", "Teclea el nuevo resultado (formato: N-N)", "^\\d{1,2}-\\d{1,2}$");
        String nuevaFechaStr = SolicitarValidarDatos.solicitarDato("Nueva Fecha", "Teclea la nueva fecha (YYYY-MM-DD)", "^\\d{4}-\\d{2}-\\d{2}$");
        String nuevaHoraStr = SolicitarValidarDatos.solicitarDato("Nueva Hora", "Teclea la nueva hora (HH:MM)", "^\\d{2}:\\d{2}$");

        LocalDate nuevaFecha = LocalDate.parse(nuevaFechaStr);
        LocalTime nuevaHora = LocalTime.parse(nuevaHoraStr);

        ModificarEnfrentamiento(jornada, idEnfrentamiento, nuevoResultado, nuevaFecha, nuevaHora);
    }

    public static void mostrarEnfrentamiento(Jornada jornada) {
        String idEnfrentamiento = SolicitarValidarDatos.solicitarDato("ID Enfrentamiento", "Teclea el ID del Enfrentamiento", "^[a-zA-Z0-9]+$");

        for (Enfrentamiento enfrentamiento : jornada.getEnfrentamientos()) {
            if (enfrentamiento.getIdEnfrentamiento().equals(idEnfrentamiento)) {
                System.out.println("ID: " + enfrentamiento.getIdEnfrentamiento());
                System.out.println("Resultado: " + enfrentamiento.getResultado());
                System.out.println("Fecha: " + enfrentamiento.getFecha());
                System.out.println("Hora: " + enfrentamiento.getHora());
                return;
            }
        }
        System.out.println("Enfrentamiento no encontrado.");
    }

    public static void mostrarEnfrentamientos(Jornada jornada) {
        if (jornada.getEnfrentamientos().isEmpty()) {
            System.out.println("No hay enfrentamientos registrados.");
            return;
        }

        System.out.println("Lista de enfrentamientos:");
        for (Enfrentamiento enfrentamiento : jornada.getEnfrentamientos()) {
            System.out.println("ID: " + enfrentamiento.getIdEnfrentamiento() + " | Resultado: " + enfrentamiento.getResultado() +
                    " | Fecha: " + enfrentamiento.getFecha() + " | Hora: " + enfrentamiento.getHora());
        }
    }
}
