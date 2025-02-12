package MAIN;

import CONTROLADOR.CompeticionController;
import MODELO.Competicion;
import VISTA.Menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String respuesta;
        try {
            do {
                respuesta = Menus.menuCompeticion();
                switch (respuesta) {
                    case "1":
                        CompeticionController.abrirCompeticion();
                        break;
                    case "2":  
                        break;
                }
            }while(!respuesta.equals("2"));
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu.");
        }
    }
}