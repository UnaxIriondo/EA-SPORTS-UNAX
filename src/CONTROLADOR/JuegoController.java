package CONTROLADOR;

import MODELO.*;
import UTILITIS.CodigoAleatorioUnico;
import UTILITIS.ComprobarTipoJuego;
import UTILITIS.SolicitarValidarDatos;

import java.util.List;

public class JuegoController {

    public static Juego crearJuego(Competicion competicion, List<Competicion> competiciones) {
        int id = Integer.parseInt(CodigoAleatorioUnico.generarCodigo());
        String nombre = ComprobarTipoJuego.comprobarTipoJuego(SolicitarValidarDatos.solicitarDato("Juego","Introduzca el nombre del juego","[A-Za-z]+").toLowerCase()).toString();
        Juego juego = new Juego(id, tipoJuego.valueOf(nombre));

        competicion.setJuego(juego);
        juego.setCompeticiones(competiciones);
        RolesController.crearRol(juego);
        return juego;
    }
}
