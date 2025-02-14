package MODELO;

import java.util.ArrayList;
import java.util.List;

public class RolesDAO {

    public static List<String> obtenerRoles() {

        List<String> listaRoles = new ArrayList<>();
        for (rolesValorant rol : rolesValorant.values()) {
            listaRoles.add(rol.toString());
        }

        return listaRoles;
    }
}
