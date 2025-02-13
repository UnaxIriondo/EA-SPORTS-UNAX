package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {
    private List<Jugador> listaJugadores;

    // Constructor
    public JugadorDAO() {
        this.listaJugadores = new ArrayList<>();
    }

    // Método para agregar un jugador
    public boolean agregarJugador(Jugador jugador) {
        if (buscarJugador(jugador.getIdJugador()) == null) {
            listaJugadores.add(jugador);
            return true;
        }
        return false;
    }

    // Método para eliminar un jugador
    public boolean eliminarJugador(String idJugador) {
        Jugador jugador = buscarJugador(idJugador);
        if (jugador != null) {
            listaJugadores.remove(jugador);
            return true;
        }
        return false;
    }

    // Método para modificar un jugador
    public boolean modificarJugador(String idJugador, String nuevoNombre, String nuevoApellido, String nuevaNacionalidad, LocalDate nuevaFechaNac, double nuevoSueldo, Equipo nuevoEquipo, rolesValorant nuevoRol) {
        Jugador jugador = buscarJugador(idJugador);
        if (jugador != null) {
            jugador.setNombre(nuevoNombre);
            jugador.setApellido(nuevoApellido);
            jugador.setNacionalidad(nuevaNacionalidad);
            jugador.setFechaNac(nuevaFechaNac);
            jugador.setSueldo(nuevoSueldo);
            jugador.setEquipo(nuevoEquipo);
            jugador.setRolesValorant(nuevoRol);
            return true;
        }
        return false;
    }

    // Método para listar todos los jugadores
    public List<Jugador> listarJugadores() {
        return new ArrayList<>(listaJugadores);
    }

    // Método para buscar un jugador por ID
    public Jugador buscarJugador(String idJugador) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getIdJugador().equals(idJugador)) {
                return jugador;
            }
        }
        return null;
    }


}
