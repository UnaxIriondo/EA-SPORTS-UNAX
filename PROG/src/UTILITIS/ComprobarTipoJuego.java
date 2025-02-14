package UTILITIS;

import EXCEPTIONS.TipoJuegoException;
import MODELO.tipoJuego;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ComprobarTipoJuego {

    public static String comprobarTipoJuego(String juego) {
        List<String> tiposJuego = new ArrayList<>();
        for (tipoJuego tipo : tipoJuego.values()) {
            tiposJuego.add(tipo.toString());
        }

        String juegoValido = "";
        boolean encontrado = false;

        do {
            try {
                if (tiposJuego.contains(juego)) {
                    juegoValido = juego;
                    encontrado = true;
                } else {
                    throw new TipoJuegoException();
                }
            } catch (TipoJuegoException e) {
                System.out.println("Juego no encontrado");
                juego = ComprobarTipoJuego.comprobarTipoJuego(
                        SolicitarValidarDatos.solicitarDato("Juego", "Introduzca el nombre del juego", "[A-Za-z]+").toLowerCase()
                ).toString();
            }
        } while (!encontrado);
        return juegoValido;
    }
    public static String comprobarTipoEquipo(String tipoEquipo) {
        List<String> tiposJuego = new ArrayList<>();
        for (tipoJuego tipo : tipoJuego.values()) {
            tiposJuego.add(tipo.toString());
        }

        String juegoValido = "";
        boolean encontrado = false;

        do {
            try {
                if (tiposJuego.contains(tipoEquipo)) {
                    juegoValido = tipoEquipo;
                    encontrado = true;
                } else {
                    throw new TipoJuegoException();
                }
            } catch (TipoJuegoException e) {
                System.out.println("Juego no encontrado");
                tipoEquipo = ComprobarTipoJuego.comprobarTipoJuego(
                        SolicitarValidarDatos.solicitarDato("Juego", "Introduzca el nombre del juego", "[A-Za-z]+").toLowerCase()
                ).toString();
            }
        } while (!encontrado);
        return juegoValido;
    }

}
