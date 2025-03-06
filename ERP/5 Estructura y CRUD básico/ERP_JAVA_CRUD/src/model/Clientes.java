package model;

public class Clientes {
    private int id_cliente;
    private String nombre_cliente;
    private String nif_cliente;
    private String direccion_cliente;
    private String poblacion_cliente;
    private String telefono_cliente;
    private String email_cliente;

    //CONSTRUCTORES
    public Clientes(){
        
    }

    public Clientes(int id, String nombre, String nif, String direccion, String poblacion, String telefono, String email){
        this.id_cliente = id;
        this.nombre_cliente = nombre;
        this.nif_cliente = nif;
        this.direccion_cliente = direccion;
        this.poblacion_cliente = poblacion;
        this.telefono_cliente = telefono;
        this.email_cliente = email;
    }

    //GETTERS
    public int getId(){
        return this.id_cliente;
    }
    public String getNombre(){
        return this.nombre_cliente;
    }
    public String getNif(){
        return this.nif_cliente;
    }
    public String getDireccion(){
        return this.direccion_cliente;
    }
    public String getPoblacion (){
        return this.poblacion_cliente;
    }
    public String getTelefono(){
        return this.telefono_cliente;
    }
    public String getEmail(){
        return this.email_cliente;
    }

    //SETTERS
    public void setId(int id){
        this.id_cliente = id;
    }
    public void setNombre(String nombre){
        this.nombre_cliente = nombre;
    }
    public void setNif(String nif){
        this.nif_cliente = nif;
    }
    public void setDireccion(String direccion){
        this.direccion_cliente = direccion;
    }
    public void setPoblacion(String poblacion){
        this.poblacion_cliente = poblacion;
    }
    public void setTelefono(String telefono){
        this.telefono_cliente = telefono;
    }
    public void setEmail(String email){
        this.email_cliente = email;
    }

    //TO-STRING
    @Override
    public String toString(){
        return "CLIENTE " + id_cliente + "// Nombre: " + nombre_cliente + ", NIF: " + nif_cliente + ", Direccion: " + direccion_cliente + ", Poblacion: " + poblacion_cliente + ", Tlf: " + telefono_cliente + ", Email: " + email_cliente;
    }
}
