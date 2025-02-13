package MODELO;

import CONTROLADOR.JuegoController;
import EXCEPTIONS.TipoJuegoException;
import UTILITIS.CodigoAleatorioUnico;
import UTILITIS.SolicitarValidarDatos;

public class CompeticionDAO {
    public static Competicion abrirCompeticion(Competicion competicion) {
        competicion.setEstado(estadoCompeticion.abierto);
        competicion.setIdCompeticion(CodigoAleatorioUnico.generarCodigo());
        competicion.setJuego(JuegoController.crearJuego());
        return competicion;
    }

    public static Competicion cerrarCompeticion(Competicion competicion) {
        competicion.setEstado(estadoCompeticion.cerrado);
        competicion.setGanador(null);
        return competicion;
    }
}
