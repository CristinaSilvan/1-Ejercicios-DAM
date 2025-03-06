package model;

public class Usuarios {
    private int id_usuario;
    private String nombre_usuario;
    private String telefono_usuario;
    private String email_usuario;

    //CONSTRUCTORES
    public Usuarios(){
        
    }

    public Usuarios(int id, String nombre, String telefono, String email){
        this.id_usuario = id;
        this.nombre_usuario = nombre;
        this.telefono_usuario = telefono;
        this.email_usuario = email;
    }

    //GETTERS
    public int getId(){
        return this.id_usuario;
    }
    public String getNombre(){
        return this.nombre_usuario;
    }
    public String getTelefono(){
        return this.telefono_usuario;
    }
    public String getEmail(){
        return this.email_usuario;
    }

    //SETTERS
    public void setId(int id){
        this.id_usuario = id;
    }
    public void setNombre(String nombre){
        this.nombre_usuario = nombre;
    }
    public void setTelefono(String telefono){
        this.telefono_usuario = telefono;
    }
    public void setEmail(String email){
        this.email_usuario = email;
    }

    //TO-STRING
    @Override
    public String toString(){
        return "USUARIO " + id_usuario + "// Nombre: " + nombre_usuario + ", Tlf: " + telefono_usuario + ", Email: " + email_usuario;
    }
}
