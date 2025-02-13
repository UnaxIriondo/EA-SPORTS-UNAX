package MODELO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EnfrentamientoDAO {
public static void insertarEnfrentamiento(Jornada jornada, String id_enfrentamiento, String resultado, LocalDate fecha, LocalTime hora, ArrayList<Equipo> listaEquipos){
        Enfrentamiento enfrentamiento = new Enfrentamiento();
        enfrentamiento.setIdEnfrentamiento(id_enfrentamiento);
        enfrentamiento.setResultado(resultado);
        enfrentamiento.setFecha(fecha);
        enfrentamiento.setHora(hora);
        enfrentamiento.setListaEquipos(listaEquipos);

        jornada.getEnfrentamientos().add(enfrentamiento);
        System.out.println("Enfrentamiento creado y añadido con exito");
    }
    public static void ModificarEnfrentamiento(Jornada jornada, String id_enfrentamiento, String nuevoResultado, LocalDate nuevaFecha, LocalTime nuevaHora){
        Enfrentamiento enfrentamientoAModificar = null;
        for (Enfrentamiento enfrentamiento : jornada.getEnfrentamientos()) {
            if (enfrentamiento.getIdEnfrentamiento().equals(id_enfrentamiento)) {
                enfrentamientoAModificar = enfrentamiento;
                break;
            }
        }

        if (enfrentamientoAModificar != null) {
            enfrentamientoAModificar.setResultado(nuevoResultado);
            enfrentamientoAModificar.setFecha(nuevaFecha);
            enfrentamientoAModificar.setHora(nuevaHora);
            System.out.println("Enfrentamiento modificado con éxito: " + id_enfrentamiento);
        } else {
            System.out.println("Enfrentamiento no encontrado: " + id_enfrentamiento);
        }
    }
}
