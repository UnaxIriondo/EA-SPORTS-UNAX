package UTILITIS;

import EXCEPTIONS.DatoNoValido;

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolicitarValidarDatos {
    private static Scanner sc = new Scanner(System.in);
    public static String solicitarDato(String dato, String mensaje,String expresionRegular)
    {
        String variable = "";
        boolean error;
        do
        {
            try {
                System.out.print(dato+": ");
                variable = sc.nextLine();
                if (variable.isEmpty())
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                Pattern pat = Pattern.compile(expresionRegular);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValido(dato + " no tiene un formato adecuado\n");
                error = false;
            } catch (DatoNoValido e) {
                error = true;
                System.out.println(e.getMessage());
            }
        }
        while(error);
        return variable;
    }
}
