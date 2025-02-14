package MAIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD {
    public static Connection connection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/EA-SPORTS";
            String user = "root";
            String password = "usbw";
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado");
        } catch (SQLException e) {
            System.out.println("Estoy aqui");
            System.out.println("Error de conexión SQL");
        }
        return con;
    }
}
