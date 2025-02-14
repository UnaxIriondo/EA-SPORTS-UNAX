package CONTROLADOR;

import MODELO.Juego;
import MODELO.Roles;
import MODELO.RolesDAO;
import UTILITIS.CodigoAleatorioUnico;

import java.util.ArrayList;
import java.util.List;

public class RolesController {

    public static void crearRol(Juego juego) {
        int id = Integer.parseInt(CodigoAleatorioUnico.generarCodigo());
        Roles roles = new Roles(RolesDAO.obtenerRoles(),id,juego);
        juego.setRoles(roles.getRolesValorant());


    }
}
