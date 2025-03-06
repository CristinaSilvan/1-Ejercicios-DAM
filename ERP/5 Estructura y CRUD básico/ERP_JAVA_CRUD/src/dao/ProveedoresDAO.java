package dao;

import java.util.ArrayList;
import java.util.List;
import model.Proveedores;
import model.ConexionBD;
import java.sql.*;

public class ProveedoresDAO{

    //CREATE
    public void crearProveedor(Proveedores nuevo_proveedor){
        String sql = "INSERT INTO productos (Id_Proveedor, Nombre_Prov, NIF_Prov, Direccion_Prov, Poblacion_Prov, Telefono_Prov, Email_Prov) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, nuevo_proveedor.getId());
            stmt.setString(2, nuevo_proveedor.getNombre());
            stmt.setString(3, nuevo_proveedor.getNif());
            stmt.setString(4, nuevo_proveedor.getDireccion());
            stmt.setString(5, nuevo_proveedor.getPoblacion());
            stmt.setString(6, nuevo_proveedor.getTelefono());
            stmt.setString(7, nuevo_proveedor.getEmail());

            stmt.executeUpdate();
            System.out.println("(PROVEEDOR AGREGADO CORRECTAMENTE) " + nuevo_proveedor);

            stmt.executeUpdate();
            System.out.println("(PROVEEDOR AGREGADO CORRECTAMENTE)");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("(NO SE HA PODIDO CREAR EL PROVEEDOR)...");
        }
    }

    // READ (Devuelve un solo proveedor mediante su id)
    public Proveedores obtenerProveedorMedianteID(int id){
        String sql = "SELECT * FROM productos WHERE Id_Proveedor = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Proveedores proveedor = new Proveedores();
                proveedor.setId(rs.getInt("Id_Proveedor"));
                proveedor.setNombre(rs.getString("Nombre_Prov"));
                proveedor.setNif(rs.getString("NIF_Prov"));
                proveedor.setDireccion(rs.getString("Direccion_Prov"));
                proveedor.setPoblacion(rs.getString("Poblacion_Prov"));
                proveedor.setTelefono(rs.getString("Telefono_Prov"));
                proveedor.setEmail(rs.getString("Email_Prov"));
                return proveedor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(PROVEEDOR NO ENCONTRADO)...");
        return null;
    }
    
    // READ (Devuelve la lista de todos los proveedores)
    public List<Proveedores> obtenerTodosProveedores(){
        List<Proveedores> listaProveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Proveedores proveedor = new Proveedores();
                proveedor.setId(rs.getInt("Id_Proveedor"));
                proveedor.setNombre(rs.getString("Nombre_Prov"));
                proveedor.setNif(rs.getString("NIF_Prov"));
                proveedor.setDireccion(rs.getString("Direccion_Prov"));
                proveedor.setPoblacion(rs.getString("Poblacion_Prov"));
                proveedor.setTelefono(rs.getString("Telefono_Prov"));
                proveedor.setEmail(rs.getString("Email_Prov"));
                listaProveedores.add(proveedor);
            }

        } catch (SQLException e) {
            System.out.println("(ALGO HA SALIDO MAL)...");
            e.printStackTrace();
        }
        return listaProveedores;
    }

    // UPDATE
    public boolean actualizarProveedor(int id, String nuevo_nombre, String nuevo_NIF, String nuevo_direccion, String nuevo_poblacion, String nuevo_telefono, String nuevo_email){
        String sql = "UPDATE productos SET Nombre_Prov = ?, NIF_Prov = ?, Direccion_Prov = ?, Poblacion_Prov = ?, Telefono_Prov = ?, Email_Prov = ? WHERE Id_Proveedor = ?";

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
                System.out.println("(PROVEEDOR ACTUALIZADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarProveedor(int id){
        String sql = "DELETE FROM productos WHERE Id_Proveedor = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("(PROVEEDOR ELIMINADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(PROVEEDOR NO ENCONTRADO)...");
        return false;
    }
}

/*
//VERSION DE PRUEBA
public class ProveedoresDAO {
    //SIMULACIÓN CONEXIÓN CON BASE DE DATOS
    private List<Proveedores> proveedores_BD = new ArrayList<>();
    private int id_autoincremental = 1;

    //CREATE
    public void crearProveedor(Proveedores nuevo_proveedor){
        nuevo_proveedor.setId(id_autoincremental);
        proveedores_BD.add(nuevo_proveedor);

        id_autoincremental++;
        System.out.println("(AGREDADO) " + nuevo_proveedor);
    }

    //READ (Devuelve un solo proveedor mediante su id)
    public Proveedores obtenerProveedorMedianteID(int id){
        for(Proveedores c: proveedores_BD){
            if(c.getId() == id){
                return c;
            }
        }
        System.out.println("(PROVEEDOR NO ENCONTRADO)...");
        return null;
    }

    //READ (Devuelve la lista de todos los proveedores)
    public List<Proveedores> obtenerTODOS(){
        return proveedores_BD;
    }

    //UPDATE
    public boolean actualizarProveedor(int id, String nuevo_nombre, String nuevo_NIF, String nuevo_direccion, String nuevo_poblacion, String nurevo_telefono, String nuevo_email){
        Proveedores proveedor = obtenerProveedorMedianteID(id);
        if(proveedor != null){
            proveedor.setNombre(nuevo_nombre);
            proveedor.setNif(nuevo_NIF);
            proveedor.setDireccion(nuevo_direccion);
            proveedor.setPoblacion(nuevo_poblacion);
            proveedor.setTelefono(nurevo_telefono);
            proveedor.setEmail(nuevo_email);
            System.out.println("(PROVEEDOR ACTUALIZADO)");
            return true;
        }
        return false;
    }

    //DELETE
    public boolean eliminarProveedor(int id){
        for(Proveedores c: proveedores_BD){
            if(c.getId() == id){
                proveedores_BD.remove(c);
                System.out.println("(PROVEEDOR ELIMINADO)");
                return true;
            }
        }
        System.out.println("(PROVEEDOR NO ENCONTRADO)...");
        return false;
    }
}
*/