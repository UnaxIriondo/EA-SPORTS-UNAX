package MODELO;

import UTILITIS.CodigoAleatorioUnico;
import UTILITIS.ComprobarTipoJuego;
import UTILITIS.SolicitarValidarDatos;

public class JuegoDAO {

    public static Juego crearJuego() {
        int id = Integer.parseInt(CodigoAleatorioUnico.generarCodigo());
        String nombre = ComprobarTipoJuego.comprobarTipoJuego(SolicitarValidarDatos.solicitarDato("Juego","Introduzca el nombre del juego","[A-Za-z]").toLowerCase()).toString();

        Juego juego = new Juego(id,tipoJuego.valueOf(nombre));

        return juego;
    }

    public static void comprobarRoles(Roles roles){

    }
}
