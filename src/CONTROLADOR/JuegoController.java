package CONTROLADOR;

import MODELO.CompeticionDAO;
import MODELO.Juego;
import MODELO.JuegoDAO;

public class JuegoController {

    public static Juego crearJuego(){
        System.out.println("---DATOS JUEGO---");

        Juego juego = JuegoDAO.crearJuego();

        return juego;
    }
}
