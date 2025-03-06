package model;

public class Productos{
    private int id_producto;
    private String nombre_producto;
    private String proveedor_producto;
    private float precio_compra_producto;
    private float precio_venta_producto;

    //CONSTRUCTORES
    public Productos(){
        
    }

    public Productos(int id, String nombre, String proveedor, float compra, float venta){
        this.id_producto = id;
        this.nombre_producto = nombre;
        this.proveedor_producto = proveedor;
        this.precio_compra_producto = compra;
        this.precio_venta_producto = venta;
    }

    //GETTERS
    public int getId(){
        return this.id_producto;
    }
    public String getNombre(){
        return this.nombre_producto;
    }
    public String getProveedor(){
        return this.proveedor_producto;
    }
    public float getPrecioCompra(){
        return this.precio_compra_producto;
    }
    public float getPrecioVenta(){
        return this.precio_venta_producto;
    }

    //SETTERS
    public void setId(int id){
        this.id_producto = id;
    }
    public void setNombre(String nombre){
        this.nombre_producto = nombre;
    }
    public void setProveedor(String proveedor){
        this.proveedor_producto = proveedor;
    }
    public void setPrecioCompra(float compra){
        this.precio_compra_producto = compra;
    }
    public void setPrecioVenta(float venta){
        this.precio_venta_producto = venta;
    }

    //TO-STRING
    @Override
    public String toString(){
        return "PRODUCTO " + id_producto + "// Nombre: " + nombre_producto + ", Proveedor: " + proveedor_producto + ", Precio de Compra: " + precio_compra_producto + ", Precio de Venta: " + precio_venta_producto;
    }
}