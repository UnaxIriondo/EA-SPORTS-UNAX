package MODELO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class JornadaDAO {
    public static void insertarJornada(ArrayList<Jornada> listaJornadas, String numJornada, LocalDate fechaInicio, ArrayList<Equipo> listaEquipos) {
        if (listaEquipos.size() < 2) {
            System.out.println("No hay suficientes equipos para generar una jornada.");
            return;
        }

        Collections.shuffle(listaEquipos);
        ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<>();
        boolean equipoDescansa = (listaEquipos.size() % 2 != 0);
        Equipo equipoSinPartido = null;

        if (equipoDescansa) {
            equipoSinPartido = listaEquipos.remove(listaEquipos.size() - 1);
            System.out.println("El equipo que descansa en esta jornada es: " + equipoSinPartido.getNombre());
        }

        for (int i = 0; i < listaEquipos.size(); i += 2) {
            Enfrentamiento enfrentamiento = new Enfrentamiento();
            enfrentamiento.setIdEnfrentamiento(numJornada + "-" + (i / 2 + 1));
            enfrentamiento.setResultado("Pendiente");
            enfrentamiento.setFecha(fechaInicio);
            enfrentamiento.setHora(LocalTime.of(20, 0)); // Hora predeterminada

            ArrayList<Equipo> equiposEnfrentamiento = new ArrayList<>();
            equiposEnfrentamiento.add(listaEquipos.get(i));
            equiposEnfrentamiento.add(listaEquipos.get(i + 1));
            enfrentamiento.setListaEquipos(equiposEnfrentamiento);

            enfrentamientos.add(enfrentamiento);
        }

        Jornada jornada = new Jornada(numJornada, fechaInicio, enfrentamientos);
        listaJornadas.add(jornada);
        System.out.println("Jornada creada con éxito.");
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
