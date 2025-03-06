package model;

public class Proveedores {
    private int id_proveedor;
    private String nombre_proveedor;
    private String nif_proveedor;
    private String direccion_proveedor;
    private String poblacion_proveedor;
    private String telefono_proveedor;
    private String email_proveedor;

    //CONSTRUCTORES
    public Proveedores(){
        
    }

    public Proveedores(int id, String nombre, String nif, String direccion, String poblacion, String telefono, String email){
        this.id_proveedor = id;
        this.nombre_proveedor = nombre;
        this.nif_proveedor = nif;
        this.direccion_proveedor = direccion;
        this.poblacion_proveedor = poblacion;
        this.telefono_proveedor = telefono;
        this.email_proveedor = email;
    }

    //GETTERS
    public int getId(){
        return this.id_proveedor;
    }
    public String getNombre(){
        return this.nombre_proveedor;
    }
    public String getNif(){
        return this.nif_proveedor;
    }
    public String getDireccion(){
        return this.direccion_proveedor;
    }
    public String getPoblacion (){
        return this.poblacion_proveedor;
    }
    public String getTelefono(){
        return this.telefono_proveedor;
    }
    public String getEmail(){
        return this.email_proveedor;
    }

    //SETTERS
    public void setId(int id){
        this.id_proveedor = id;
    }
    public void setNombre(String nombre){
        this.nombre_proveedor = nombre;
    }
    public void setNif(String nif){
        this.nif_proveedor = nif;
    }
    public void setDireccion(String direccion){
        this.direccion_proveedor = direccion;
    }
    public void setPoblacion(String poblacion){
        this.poblacion_proveedor = poblacion;
    }
    public void setTelefono(String telefono){
        this.telefono_proveedor = telefono;
    }
    public void setEmail(String email){
        this.email_proveedor = email;
    }

    //TO-STRING
    @Override
    public String toString(){
        return "PROVEEDOR " + id_proveedor + "// Nombre: " + nombre_proveedor + ", NIF: " + nif_proveedor + ", Direccion: " + direccion_proveedor + ", Poblacion: " + poblacion_proveedor + ", Tlf: " + telefono_proveedor + ", Email: " + email_proveedor;
    }

}
