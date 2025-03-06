import dao.*;
import java.util.Scanner;
import model.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            // Carga el driver
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver JDBC cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC.");
            e.printStackTrace();
        }
    }
}


/*
//VERSION DE PRUEBA
public class Main {
    public static void main (String[] args){
        ClientesDAO clienteDAO = new ClientesDAO();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú CRUD de Clientes ---");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Buscar Cliente por ID");
            System.out.println("4. Actualizar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.print("NIF: ");
                    String nif = entrada.nextLine();
                    System.out.print("Domicilio: ");
                    String domicilio = entrada.nextLine();
                    System.out.print("Poblacion: ");
                    String poblacion = entrada.nextLine();
                    System.out.print("Telefono: ");
                    int telefono = 0;
                    try {
                        telefono = Integer.parseInt(entrada.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("(FORMATO DE TELEFONO NO VALIDO)...");
                    }
                    System.out.print("Email: ");
                    String email = entrada.nextLine();
                    clienteDAO.crearCliente(new Clientes(0, nombre, nif, domicilio, email, telefono, email));
                    break;
                case 2:
                    clienteDAO.obtenerTodosClientes().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("ID del Cliente que Busca: ");
                    int idBuscar1 = entrada.nextInt();
                    Clientes cliente1 = clienteDAO.obtenerClienteMedianteID(idBuscar1);
                    if(cliente1 != null) {
                        System.out.println(cliente1);
                    }
                    break;
                case 4:
                    System.out.print("ID del Cliente que quiere actualizar: ");
                    int idBuscar2 = entrada.nextInt();
                    Clientes cliente2 = clienteDAO.obtenerClienteMedianteID(idBuscar2);
                    if(cliente2 != null) {
                        System.out.print("Nombre: ");
                        String nuevo_nombre = entrada.nextLine();
                        System.out.print("NIF: ");
                        String nuevo_nif = entrada.nextLine();
                        System.out.print("Domicilio: ");
                        String nuevo_domicilio = entrada.nextLine();
                        System.out.print("Poblacion: ");
                        String nuevo_poblacion = entrada.nextLine();
                        System.out.print("Telefono: ");
                        int nuevo_telefono = 0;
                        try {
                            nuevo_telefono = Integer.parseInt(entrada.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("(FORMATO DE TELEFONO NO VALIDO)...");
                        }
                        System.out.print("Email: ");
                        String nuevo_email = entrada.nextLine();
                        clienteDAO.actualizarCliente(opcion, nuevo_nombre, nuevo_nif, nuevo_poblacion, nuevo_poblacion, nuevo_telefono, nuevo_email);
                        System.out.println(cliente2);
                    }
                    break;   
                case 5:
                    System.out.print("ID del Cliente a eliminar: ");
                    int idEliminar = entrada.nextInt();
                    clienteDAO.eliminarCliente(idEliminar);
                    break;
                case 0:
                    System.out.println("(CERRANDO)...");
                    break;
                default:
                    System.out.println("(OPCION NO VALIDA)");
                }
                
        } while (opcion != 0);

        entrada.close();
    }
}

*/