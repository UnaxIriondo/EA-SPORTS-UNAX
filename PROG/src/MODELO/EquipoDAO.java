package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private static List<Equipo> listaequipos = new ArrayList<>();

    public EquipoDAO() {
        this.listaequipos = new ArrayList<>();
    }

    public static boolean agregarEquipo(Equipo equipo) {
        if (buscarEquipo(equipo.getIdEquipo()) == null) {
            listaequipos.add(equipo);
            return true;
        }
        return false;
    }

    public static boolean eliminarEquipo(String idEquipo) {
        Equipo equipo = buscarEquipo(idEquipo);
        if (equipo != null) {
            listaequipos.remove(equipo);
            return true;
        }
        return false;
    }

    public static Equipo modificarEquipo(String idEquipo, String nuevoNombre, LocalDate nuevaFecha, tipoEquipo nuevoTipo) {
        Equipo equipo = buscarEquipo(idEquipo);
        if (equipo != null) {
            if (nuevoNombre != null) {
                equipo.setNombre(nuevoNombre);
            }
            if (nuevaFecha != null) {
                equipo.setFechaFund(nuevaFecha);
            }
        }
        return equipo; // Equipo no encontrado
    }

    public static List<Equipo> listarEquipos() {
        return new ArrayList<>(listaequipos);
    }

    public static Equipo buscarEquipo(String idEquipo) {
        for (Equipo equipo : listaequipos) {
            if (equipo.getIdEquipo().equals(idEquipo)) {
                return equipo;
            }
        }
        return null;
    }

}