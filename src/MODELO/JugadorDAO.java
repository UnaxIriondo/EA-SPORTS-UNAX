package MODELO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {
    private static List<Jugador> listajugadores;

    public JugadorDAO() {
        this.listajugadores = new ArrayList<>();
    }

    public boolean agregarJugador(Jugador jugador) {
        if (buscarjugador(jugador.getIdJugador()) ==null ){
            listajugadores.add(jugador);
            return true;
        }
        return false;
    }

    public boolean eliminarJugador(String idJugador) {
        Jugador jugador = buscarjugador(idJugador);
        if (jugador != null) {
            listajugadores.remove(jugador);
            return true;
        }
        return false;
    }

    public boolean modificarJugador( String idJugador, String nuevoNombre, String nuevoApellido, String nuevaNacionalidad, LocalDate nuevaFechaNac, double nuevoSueldo, Equipo equipo, Roles nuevoRol) {
        Jugador jugador = buscarjugador(idJugador);
        if (jugador != null) {
            if ()
        }
    }













    public Jugador buscarjugador(String idJugador) {
        for (Jugador jugador : listajugadores) {
            if (jugador.getIdJugador().equals(idJugador)){
                return jugador;
            }
        }
        return null;
    }
}