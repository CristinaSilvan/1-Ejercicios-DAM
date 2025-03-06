package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:Empresa_SQLite.db";

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(URL);
            System.out.println("(CONEXION ESTABLECIDA CON LA BASE DE DATOS)");
        }catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.out.println("(NO SE ENCONTRO LA BASE DE DATOS)");
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("(LA CONEXION NO SE PUDO ESTABLECER)");            
        }
        return conexion;
    }
}
