package MODELO;

import java.util.List;

public class Roles {
    private List<String> rolesValorant;
    private int idRol;
    private Juego juego;

    public Roles(List<String> rolesValorant, int idRol, Juego juego) {
        this.rolesValorant = rolesValorant;
        this.idRol = idRol;
        this.juego = juego;
    }

    public Roles(List<String> rolesValorant) {
        this.rolesValorant = rolesValorant;
    }

    public Roles() {
    }

    public List<String> getRolesValorant() {
        return rolesValorant;
    }

    public void setRolesValorant(List<String> rolesValorant) {
        this.rolesValorant = rolesValorant;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "rolesValorant=" + rolesValorant +
                ", idRol=" + idRol +
                ", juego=" + juego +
                '}';
    }
}
