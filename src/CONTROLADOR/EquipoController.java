package CONTROLADOR;

import EXCEPTIONS.DatoNoValido;
import MODELO.Equipo;
import UTILITIS.SolicitarValidarDatos;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquipoController {
    private List<Equipo>listaequipos;

    public EquipoController() {
        this.listaequipos = new ArrayList();
    }

    public static void agregarEquipos(){
    }
    public static  void actualizarDatosEquipo(){

        String idEquipo = SolicitarValidarDatos.solicitarDato("Id Equipo","Teclea el id del equipo","");
        String nombre = SolicitarValidarDatos.solicitarDato("Nombre","Teclea el nombre del equipo","^[A-Z][a-zA-ZñÑ ]{1,19}$");
        LocalDate fechaFund = LocalDate.parse(SolicitarValidarDatos.solicitarDato("Fecha de fundacion","Teclea la fecha de fundacion del equipo",""));


    }


}