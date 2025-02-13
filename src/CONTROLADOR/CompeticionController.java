package CONTROLADOR;

import EXCEPTIONS.TipoJuegoException;
import MODELO.*;
import UTILITIS.CodigoAleatorioUnico;
import UTILITIS.ComprobarTipoJuego;
import UTILITIS.SolicitarValidarDatos;

import java.util.ArrayList;
import java.util.List;


public class CompeticionController {
    private static Competicion competicion;
    private static List<Competicion> competiciones = new ArrayList<Competicion>();

    public static Competicion abrirCompeticion() {
        String idCompeticion = CodigoAleatorioUnico.generarCodigo();
        estadoCompeticion estado = estadoCompeticion.abierto;
        competicion = new Competicion(idCompeticion,estado);
        competiciones.add(competicion);

        JuegoController.crearJuego(competicion,competiciones);

        return competicion;

    }

    public static void cerrarCompeticion() {
        estadoCompeticion estado = estadoCompeticion.cerrado;
    }
}
