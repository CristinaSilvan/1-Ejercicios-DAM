package dao;

import java.util.ArrayList;
import java.util.List;
import model.Almacen;
import model.ConexionBD;
import java.sql.*;

public class AlmacenDAO {

    //CREATE
    public void crearAlmacen(Almacen nuevo_almacen){
        String sql = "INSERT INTO almacen (Id_Almacen, Nombre_Alm, Ubicacion_Alm) VALUES (?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, nuevo_almacen.getId());
            stmt.setString(2, nuevo_almacen.getNombre());
            stmt.setString(3, nuevo_almacen.getUbicacion());
    
            stmt.executeUpdate();
            System.out.println("(ALMACEN AGREGADO CORRECTAMENTE) " + nuevo_almacen);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("(NO SE HA PODIDO CREAR EL ALMACEN)...");
        }
    }

    // READ (Devuelve un solo almacen mediante su id)
    public Almacen obtenerAlmacenMedianteID(int id){
        String sql = "SELECT * FROM almacen WHERE Id_Almacen = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Almacen almacen = new Almacen();
                almacen.setId(rs.getInt("Id_Almacen"));
                almacen.setNombre(rs.getString("Nombre_Alm"));
                almacen.setUbicacion(rs.getString("Ubicacion_Alm"));
                return almacen;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(ALMACEN NO ENCONTRADO)...");
        return null;
    }
    
    // READ (Devuelve la lista de todos los almacenes)
    public List<Almacen> obtenerTodosAlmacenes(){
        List<Almacen> listaAlmacen = new ArrayList<>();
        String sql = "SELECT * FROM almacen";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Almacen almacen = new Almacen();
                almacen.setId(rs.getInt("Id_Almacen"));
                almacen.setNombre(rs.getString("Nombre_Alm"));
                almacen.setUbicacion(rs.getString("Ubicacion_Alm"));
                listaAlmacen.add(almacen);
            }

        } catch (SQLException e) {
            System.out.println("(ALGO HA SALIDO MAL)...");
            e.printStackTrace();
        }
        return listaAlmacen;
    }

    // UPDATE
    public boolean actualizarAlmacen(int id, String nuevo_nombre, String nuevo_ubicacion){
        String sql = "UPDATE almacen SET Nombre_Alm = ?, Ubicacion_Alm = ? WHERE Id_Almacen = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevo_nombre);
            stmt.setString(2, nuevo_ubicacion);
            stmt.setInt(3, id);

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("(ALMACEN ACTUALIZADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminaralmacen(int id){
        String sql = "DELETE FROM almacen WHERE Id_Almacen = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("(ALMACEN ELIMINADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(ALMACEN NO ENCONTRADO)...");
        return false;
    }
}

/*
//VERSION DE PRUEBA
public class AlmacenDAO{
    //SIMULACIÓN CONEXIÓN CON BASE DE DATOS
    private List<Almacen> almacenes_BD = new ArrayList<>();
    private int id_autoincremental = 1;

    //CREATE
    public void crearAlmacen(Almacen nuevo_almacen){
        nuevo_almacen.setId(id_autoincremental);
        almacenes_BD.add(nuevo_almacen);

        id_autoincremental++;
        System.out.println("(AGREDADO) " + nuevo_almacen);
    }

    //READ (Devuelve un solo almacen mediante su id)
    public Almacen obtenerAlmacenMedianteID(int id){
        for(Almacen c: almacenes_BD){
            if(c.getId() == id){
                return c;
            }
        }
        System.out.println("(ALMACEN NO ENCONTRADO)...");
        return null;
    }

    //READ (Devuelve la lista de todos los almacenes)
    public List<Almacen> obtenerTODOS(){
        return almacenes_BD;
    }

    //UPDATE
    public boolean actualizarAlmacen(int id, String nuevo_nombre, String nuevo_ubicacion){
        Almacen almacen = obtenerAlmacenMedianteID(id);
        if(almacen != null){
            almacen.setNombre(nuevo_nombre);
            almacen.setUbicacion(nuevo_ubicacion);
            System.out.println("(ALMACEN ACTUALIZADO)");
            return true;
        }
        return false;
    }

    //DELETE
    public boolean eliminarAlmacen(int id){
        for(Almacen c: almacenes_BD){
            if(c.getId() == id){
                almacenes_BD.remove(c);
                System.out.println("(ALMACEN ELIMINADO)");
                return true;
            }
        }
        System.out.println("(ALMACEN NO ENCONTRADO)...");
        return false;
    }
}
*/