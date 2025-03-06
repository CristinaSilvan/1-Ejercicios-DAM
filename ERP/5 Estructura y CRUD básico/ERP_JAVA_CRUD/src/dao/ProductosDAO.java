package dao;

import java.util.ArrayList;
import java.util.List;
import model.Productos;
import model.ConexionBD;
import java.sql.*;

public class ProductosDAO{

    //CREATE
    public void crearProducto(Productos nuevo_producto){
        String sql = "INSERT INTO productos (Id_Prod, Nombre_Prod, Proveedor_Prod, Precio_Compra, Precio_Venta) VALUES (?, ?, ?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, nuevo_producto.getId());
            stmt.setString(2, nuevo_producto.getNombre());
            stmt.setString(2, nuevo_producto.getProveedor());
            stmt.setFloat(2, nuevo_producto.getPrecioCompra());
            stmt.setFloat(2, nuevo_producto.getPrecioVenta());

            stmt.executeUpdate();
            System.out.println("(PRODUCTO AGREGADO CORRECTAMENTE) " + nuevo_producto);

            stmt.executeUpdate();
            System.out.println("(PRODUCTO AGREGADO CORRECTAMENTE)");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("(NO SE HA PODIDO CREAR EL PRODUCTO)...");
        }
    }

    // READ (Devuelve un solo producto mediante su id)
    public Productos obtenerProductoMedianteID(int id){
        String sql = "SELECT * FROM productos WHERE Id_Prod = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Productos producto = new Productos();
                producto.setId(rs.getInt("Id_Prod"));
                producto.setNombre(rs.getString("Nombre_Prod"));
                producto.setProveedor(rs.getString("Proveedor_Prod"));
                producto.setPrecioCompra(rs.getFloat("Precio_Compra"));
                producto.setPrecioVenta(rs.getFloat("Precio_Venta"));
                return producto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(PRODUCTO NO ENCONTRADO)...");
        return null;
    }
    
    // READ (Devuelve la lista de todos los productos)
    public List<Productos> obtenerTodosProductos(){
        List<Productos> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Productos producto = new Productos();
                producto.setId(rs.getInt("Id_Prod"));
                producto.setNombre(rs.getString("Nombre_Prod"));
                producto.setProveedor(rs.getString("Proveedor_Prod"));
                producto.setPrecioCompra(rs.getFloat("Precio_Compra"));
                producto.setPrecioVenta(rs.getFloat("Precio_Venta"));
                listaProductos.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("(ALGO HA SALIDO MAL)...");
            e.printStackTrace();
        }
        return listaProductos;
    }

    // UPDATE
    public boolean actualizarProducto(int id, String nuevo_nombre, String nuevo_proveedor, Float nuevo_precio_compra, Float nuevo_precio_venta){
        String sql = "UPDATE productos SET Nombre_Prod = ?, Proveedor_Prod = ?, Precio_Compra = ?, Precio_Venta = ? WHERE Id_Prod = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevo_nombre);
            stmt.setString(2, nuevo_proveedor);
            stmt.setFloat(3, nuevo_precio_compra);
            stmt.setFloat(4, nuevo_precio_venta);
            stmt.setInt(5, id);

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("(PRODUCTO ACTUALIZADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarProducto(int id){
        String sql = "DELETE FROM productos WHERE Id_Prod = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("(PRODUCTO ELIMINADO)");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("(PRODUCTO NO ENCONTRADO)...");
        return false;
    }
}

/*
//VERSION DE PRUEBA
public class ProductosDAO {
    //SIMULACIÓN CONEXIÓN CON BASE DE DATOS
    private List<Productos> productos_BD = new ArrayList<>();
    private int id_autoincremental = 1;

    //CREATE
    public void crearProducto(Productos nuevo_producto){
        nuevo_producto.setId(id_autoincremental);
        productos_BD.add(nuevo_producto);

        id_autoincremental++;
        System.out.println("(AGREDADO) " + nuevo_producto);
    }

    //READ (Devuelve un solo producto mediante su id)
    public Productos obtenerProductoMedianteID(int id){
        for(Productos c: productos_BD){
            if(c.getId() == id){
                return c;
            }
        }
        System.out.println("(PRODUCTO NO ENCONTRADO)...");
        return null;
    }

    //READ (Devuelve la lista de todos los productos)
    public List<Productos> obtenerTODOS(){
        return productos_BD;
    }

    //UPDATE
    public boolean actualizarProducto(int id, String nuevo_nombre, Proveedores nuevo_proveedor, int nuevo_precio_compra, int nuevo_precio_venta){
        Productos producto = obtenerProductoMedianteID(id);
        if(producto != null){
            producto.setNombre(nuevo_nombre);
            producto.setProveedor(nuevo_proveedor);
            producto.setPrecioCompra(nuevo_precio_compra);
            producto.setPrecioVenta(nuevo_precio_venta);
            System.out.println("(PRODUCTO ACTUALIZADO)");
            return true;
        }
        return false;
    }

    //DELETE
    public boolean eliminarProducto(int id){
        for(Productos c: productos_BD){
            if(c.getId() == id){
                productos_BD.remove(c);
                System.out.println("(PRODUCTO ELIMINADO)");
                return true;
            }
        }
        System.out.println("(PRODUCTO NO ENCONTRADO)...");
        return false;
    }
}
*/