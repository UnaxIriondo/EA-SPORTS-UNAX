package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private List<Equipo> listaequipos;

    public EquipoDAO() {
        this.listaequipos = new ArrayList<>();
    }

    public boolean agregarEquipo(Equipo equipo) {
        if (buscarEquipo(equipo.getIdEquipo()) == null) {
            listaequipos.add(equipo);
            return true;
        }
        return false;
    }

    public boolean eliminarEquipo(String idEquipo) {
        Equipo equipo = buscarEquipo(idEquipo);
        if (equipo != null) {
            listaequipos.remove(equipo);
            return true;
        }
        return false;
    }

    public boolean modificarEquipo(String idEquipo, String nuevoNombre, LocalDate nuevaFecha, tipoEquipo nuevoTipo) {
        Equipo equipo = buscarEquipo(idEquipo);
        if (equipo != null) {
            if (nuevoNombre != null) {
                equipo.setNombre(nuevoNombre);
            }
            if (nuevaFecha != null) {
                equipo.setFechaFund(nuevaFecha);
            }
            if (nuevoTipo != null) {
                equipo.setTipoEquipo(nuevoTipo);
            }
            return true;
        }
        return false; // Equipo no encontrado
    }

    public List<Equipo> listarEquipos() {
        return new ArrayList<>(listaequipos);
    }

    public Equipo buscarEquipo(String idEquipo) {
        for (Equipo equipo : listaequipos) {
            if (equipo.getIdEquipo().equals(idEquipo)) {
                return equipo;
            }
        }
        return null;
    }

}