package MODELO;

public class Competicion {
    private String idCompeticion;
    estadoCompeticion estado;

    public Competicion(String idCompeticion, estadoCompeticion estado) {
        this.idCompeticion = idCompeticion;
        this.estado = estado;
    }

    public String getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(String idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public estadoCompeticion getEstado() {
        return estado;
    }

    public void setEstado(estadoCompeticion estado) {
        this.estado = estado;
    }
}
