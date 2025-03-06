package dao;

import java.util.ArrayList;
import java.util.List;
import model.Usuarios;
import model.ConexionBD;
import java.sql.*;

public class UsuariosDAO {

    //CREATE
    public void crearUsuario(Usuarios nuevo_usuario){
        String sql = "INSERT INTO usuarios (Id_Usuario, Nombre_Us, Telefono_Us, Email_Us) VALUES (?, ?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, nuevo_usuario.getId());
            stmt.setString(2, nuevo_usuario.getNombre());
            stmt.setString(3, nuevo_usuario.getTelefono());
            stmt.setString(4, nuevo_usuario.getEmail());
    
            stmt.executeUpdate();
            System.out.println("(USUARIO AGREGADO CORRECTAMENTE) " + nuevo_usuario);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("(NO SE HA PODIDO CREAR EL USUARIO)...");
        }
    }

    // READ (Devuelve un solo usuario mediante su id)
    public Usuarios obtenerUsuarioMedianteID(int id){
        String sql = "SELECT * FROM usuarios WHERE Id_Usuario = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId(rs.getInt("Id_Usuario"));
                usuario.setNombre(rs.getString("Nombre_Us"));
                usuario.setTelefono(rs.getString("Telefono_Us"));
                usuario.setEmail(rs.getString("Email_Us"));
                return usuario;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(USUARIO NO ENCONTRADO)...");
        return null;
    }
    
    // READ (Devuelve la lista de todos los usuarios)
    public List<Usuarios> obtenerTodosUsuarios(){
        List<Usuarios> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId(rs.getInt("Id_Usuario"));
                usuario.setNombre(rs.getString("Nombre_Us"));
                usuario.setTelefono(rs.getString("Telefono_Us"));
                usuario.setEmail(rs.getString("Email_Us"));
                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("(ALGO HA SALIDO MAL)...");
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    // UPDATE
    public boolean actualizarUsuario(int id, String nuevo_nombre, String nuevo_telefono, String nuevo_email){
        String sql = "UPDATE usuarios SET Nombre_Us = ?, Telefono_Us = ?, Email_Us = ? WHERE Id_Usuario = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevo_nombre);
            stmt.setString(2, nuevo_telefono);
            stmt.setString(3, nuevo_email);
            stmt.setInt(4, id);

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("(USUARIO ACTUALIZADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarUsuario(int id){
        String sql = "DELETE FROM usuarios WHERE Id_Usuario = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("(USUARIO ELIMINADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(USUARIO NO ENCONTRADO)...");
        return false;
    }
}

/*
//VERSION DE PRUEBA
public class UsuariosDAO {
    //SIMULACIÓN CONEXIÓN CON BASE DE DATOS
    private List<Usuarios> usuarios_BD = new ArrayList<>();
    private int id_autoincremental = 1;

    //CREATE
    public void crearUsuario(Usuarios nuevo_usuario){
        nuevo_usuario.setId(id_autoincremental);
        usuarios_BD.add(nuevo_usuario);

        id_autoincremental++;
        System.out.println("(AGREDADO) " + nuevo_usuario);
    }

    //READ (Devuelve un solo usuario mediante su id)
    public Usuarios obtenerUsuarioMedianteID(int id){
        for(Usuarios c: usuarios_BD){
            if(c.getId() == id){
                return c;
            }
        }
        System.out.println("(USUARIO NO ENCONTRADO)...");
        return null;
    }

    //READ (Devuelve la lista de todos los Usuarios)
    public List<Usuarios> obtenerTODOS(){
        return usuarios_BD;
    }

    //UPDATE
    public boolean actualizarUsuario(int id, String nuevo_nombre, long nurevo_telefono, String nuevo_email){
        Usuarios usuario = obtenerUsuarioMedianteID(id);
        if(usuario != null){
            usuario.setNombre(nuevo_nombre);
            usuario.setTelefono(nurevo_telefono);
            usuario.setEmail(nuevo_email);
            System.out.println("(USUARIO ACTUALIZADO)");
            return true;
        }
        return false;
    }

    //DELETE
    public boolean eliminarUsuario(int id){
        for(Usuarios c: usuarios_BD){
            if(c.getId() == id){
                usuarios_BD.remove(c);
                System.out.println("(USUARIO ELIMINADO)");
                return true;
            }
        }
        System.out.println("(USUARIO NO ENCONTRADO)...");
        return false;
    }
}
*/