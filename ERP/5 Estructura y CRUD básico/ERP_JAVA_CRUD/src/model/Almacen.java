package model;

public class Almacen{
    private int id_almacen;
    private String nombre_almacen;
    private String ubicacion_almacen;

    //CONSTRUCTORES
    public Almacen(){
        
    }

    public Almacen(int id, String nombre, String ubicacion){
        this.id_almacen = id;
        this.nombre_almacen = nombre;
        this.ubicacion_almacen = ubicacion;
    }

    //GETTERS
    public int getId(){
        return this.id_almacen;
    }
    public String getNombre(){
        return this.nombre_almacen;
    }
    public String getUbicacion(){
        return this.ubicacion_almacen;
    }

    //SETTERS
    public void setId(int id){
        this.id_almacen = id;
    }
    public void setNombre(String nombre){
        this.nombre_almacen = nombre;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion_almacen = ubicacion;
    }

    //TO-STRING
    @Override
    public String toString(){
        return "ALMACEN " + id_almacen + "// Nombre: " + nombre_almacen + ", Ubicacion: " + ubicacion_almacen;
    }
}