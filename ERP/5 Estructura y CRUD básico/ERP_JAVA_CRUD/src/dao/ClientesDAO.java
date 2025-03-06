package dao;

import java.util.ArrayList;
import java.util.List;
import model.Clientes;
import model.ConexionBD;
import java.sql.*;

public class ClientesDAO {

    //CREATE
    public void crearCliente(Clientes nuevo_cliente){
        String sql = "INSERT INTO clientes (Id_Cliente, Nombre_Cli, NIF_Cli, Direccion_Cli, Poblacion_Cli, Telefono_Cli, Email_Cli) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, nuevo_cliente.getId());
            stmt.setString(2, nuevo_cliente.getNombre());
            stmt.setString(3, nuevo_cliente.getNif());
            stmt.setString(4, nuevo_cliente.getDireccion());
            stmt.setString(5, nuevo_cliente.getPoblacion());
            stmt.setString(6, nuevo_cliente.getTelefono());
            stmt.setString(7, nuevo_cliente.getEmail());
    
            stmt.executeUpdate();
            System.out.println("(CLIENTE AGREGADO CORRECTAMENTE) " + nuevo_cliente);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("(NO SE HA PODIDO CREAR EL CLIENTE)...");
        }
    }

    // READ (Devuelve un solo cliente mediante su id)
    public Clientes obtenerClienteMedianteID(int id){
        String sql = "SELECT * FROM clientes WHERE Id_Cliente = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setId(rs.getInt("Id_Cliente"));
                cliente.setNombre(rs.getString("Nombre_Cli"));
                cliente.setNif(rs.getString("NIF_Cli"));
                cliente.setDireccion(rs.getString("Direccion_Cli"));
                cliente.setPoblacion(rs.getString("Poblacion_Cli"));
                cliente.setTelefono(rs.getString("Telefono_Cli"));
                cliente.setEmail(rs.getString("Email_Cli"));
                return cliente;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(CLIENTE NO ENCONTRADO)...");
        return null;
    }
    
    // READ (Devuelve la lista de todos los clientes)
    public List<Clientes> obtenerTodosClientes(){
        List<Clientes> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setId(rs.getInt("Id_Cliente"));
                cliente.setNombre(rs.getString("Nombre_Cli"));
                cliente.setNif(rs.getString("NIF_Cli"));
                cliente.setDireccion(rs.getString("Direccion_Cli"));
                cliente.setPoblacion(rs.getString("Poblacion_Cli"));
                cliente.setTelefono(rs.getString("Telefono_Cli"));
                cliente.setEmail(rs.getString("Email_Cli"));
                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("(ALGO HA SALIDO MAL)...");
            e.printStackTrace();
        }
        return listaClientes;
    }

    // UPDATE
    public boolean actualizarCliente(int id, String nuevo_nombre, String nuevo_NIF, String nuevo_direccion, String nuevo_poblacion, String nuevo_telefono, String nuevo_email){
        String sql = "UPDATE clientes SET Nombre_Cli = ?, NIF_Cli = ?, Direccion_Cli = ?, Poblacion_Cli = ?, Telefono_Cli = ?, Email_Cli = ? WHERE Id_Cliente = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevo_nombre);
            stmt.setString(2, nuevo_NIF);
            stmt.setString(3, nuevo_direccion);
            stmt.setString(4, nuevo_poblacion);
            stmt.setString(5, nuevo_telefono);
            stmt.setString(6, nuevo_email);
            stmt.setInt(7, id);

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("(CLIENTE ACTUALIZADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarCliente(int id){
        String sql = "DELETE FROM clientes WHERE Id_Cliente = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("(CLIENTE ELIMINADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(CLIENTE NO ENCONTRADO)...");
        return false;
    }
}

/*
//VERSION DE PRUEBA
public class ClientesDAO {
    //SIMULACIÓN CONEXIÓN CON BASE DE DATOS
    private List<Clientes> clientes_BD = new ArrayList<>();
    private int id_autoincremental = 1;

    //CREATE
    public void crearCliente(Clientes nuevo_cliente){
        nuevo_cliente.setId(id_autoincremental);
        clientes_BD.add(nuevo_cliente);

        id_autoincremental++;
        System.out.println("(AGREDADO) " + nuevo_cliente);
    }

    //READ (Devuelve un solo cliente mediante su id)
    public Clientes obtenerClienteMedianteID(int id){
        for(Clientes c: clientes_BD){
            if(c.getId() == id){
                return c;
            }
        }
        System.out.println("(CLIENTE NO ENCONTRADO)...");
        return null;
    }

    //READ (Devuelve la lista de todos los clientes)
    public List<Clientes> obtenerTODOS(){
        return clientes_BD;
    }

    //UPDATE
    public boolean actualizarCliente(int id, String nuevo_nombre, String nuevo_NIF, String nuevo_direccion, String nuevo_poblacion, String nurevo_telefono, String nuevo_email){
        Clientes cliente = obtenerClienteMedianteID(id);
        if(cliente != null){
            cliente.setNombre(nuevo_nombre);
            cliente.setNif(nuevo_NIF);
            cliente.setDireccion(nuevo_direccion);
            cliente.setPoblacion(nuevo_poblacion);
            cliente.setTelefono(nurevo_telefono);
            cliente.setEmail(nuevo_email);
            System.out.println("(CLIENTE ACTUALIZADO)");
            return true;
        }
        return false;
    }

    //DELETE
    public boolean eliminarCliente(int id){
        for(Clientes c: clientes_BD){
            if(c.getId() == id){
                clientes_BD.remove(c);
                System.out.println("(CLIENTE ELIMINADO)");
                return true;
            }
        }
        System.out.println("(CLIENTE NO ENCONTRADO)...");
        return false;
    }
}
*/