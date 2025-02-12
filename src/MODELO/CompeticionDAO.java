package MODELO;

import UTILITIS.CodigoAleatorioUnico;

public class CompeticionDAO {
    public static Competicion abrirCompeticion(Competicion competicion) {
        competicion.setEstado(estadoCompeticion.abierto);
        competicion.setIdCompeticion(CodigoAleatorioUnico.generarCodigo());
        return competicion;
    }

    public static Competicion cerrarCompeticion(Competicion competicion) {
        competicion.setEstado(estadoCompeticion.cerrado);
        competicion.setGanador(null);
        return competicion;
    }
}
