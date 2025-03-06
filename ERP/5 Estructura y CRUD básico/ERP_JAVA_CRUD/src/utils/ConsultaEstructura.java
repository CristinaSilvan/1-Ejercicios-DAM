package utils;

import java.util.Scanner;
import model.ConexionBD;
import java.sql.*;

public class ConsultaEstructura {

    public static void verEstructuraTabla(String tabla) {
        String sql = "PRAGMA table_info(" + tabla + ");";

        System.out.println("\n");
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("\n...\n");
            System.out.println("/TABLA " + tabla.toUpperCase() + "/");
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int notnull = rs.getInt("notnull");
                String dflt_value = rs.getString("dflt_value");
                int pk = rs.getInt("pk");

                System.out.println("CID: " + cid + "||| Columna: " + name + "||| Tipo: " 
                + type + "||| Not Null: " + notnull + "||| Default: " + dflt_value + "||| Clave primaria: " + pk + "|||");
                /*
                CID es el índice de la columna (comienza desde 0).
                NAME es el nombre de la columna.
                TYPE es el tipo de datos de la columna.
                NOTNULL indica si la columna permite valores nulos (0 es permitido, 1 no lo es).
                DFLT_VALUE es el valor predeterminado de la columna (si tiene uno).
                PK indica si la columna es una clave primaria (1 es clave primaria, 0 no lo es).
                 */
            }
            System.out.println("...\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Llamada al método para ver la estructura de la tabla
        Scanner entrada = new Scanner(System.in);
        String eleccion = new String();

        do{
            System.out.println("(¿QUE TABLA QUIERES VER?)");
            System.out.println("0: SALIR");
            System.out.println("1: CLIENTES");
            System.out.println("2: PROVEEDORES");
            System.out.println("3: PRODUCTOS");
            System.out.println("4: USUARIOS");
            System.out.println("5: ALMACEN");

            System.out.print("-> ");
            eleccion = entrada.nextLine();

            switch (eleccion) {
                case "1":
                    verEstructuraTabla("clientes");
                    break;
                case "2":
                    verEstructuraTabla("proveedores");
                    break;
                case "3":
                    verEstructuraTabla("productos");
                    break;
                case "4":
                    verEstructuraTabla("usuarios");
                    break;
                case "5":
                    verEstructuraTabla("almacen");
                    break;
                default:
                    System.out.println("//SALIENDO...");
                    return;
            }

        }while(!eleccion.equals("0"));

        entrada.close();
    }
}