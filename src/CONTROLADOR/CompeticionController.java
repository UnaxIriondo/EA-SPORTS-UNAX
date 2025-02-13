package CONTROLADOR;

import EXCEPTIONS.TipoJuegoException;
import MODELO.Competicion;
import MODELO.CompeticionDAO;
import MODELO.tipoJuego;
import UTILITIS.SolicitarValidarDatos;

public class CompeticionController {
    private static Competicion competicion = new Competicion();

    public static Competicion abrirCompeticion() {
        System.out.println("---DATOS COMPETICION---");
        System.out.println("Estado: " + CompeticionDAO.abrirCompeticion(competicion).getEstado());
        System.out.println("ID: " + CompeticionDAO.abrirCompeticion(competicion).getIdCompeticion());
        System.out.println("Juego: " + CompeticionDAO.abrirCompeticion(competicion).getJuego());

        return competicion;

    }
    public static void cerrarCompeticion() {
        System.out.println("---DATOS COMPETICION---");
        System.out.println("Estado: " + CompeticionDAO.cerrarCompeticion(competicion).getEstado());
        System.out.println("ID: " + CompeticionDAO.cerrarCompeticion(competicion).getIdCompeticion());
        System.out.println("Ganador: " + CompeticionDAO.cerrarCompeticion(competicion).getGanador());
    }
}
