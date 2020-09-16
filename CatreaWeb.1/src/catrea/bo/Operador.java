package catrea.bo;

public class Operador {
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String mailOperador;
    private String rol;
    
    public Operador(String dni, String nombre, String apellido, String contrasenia, String mailOperador, String rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia= contrasenia;
        this.mailOperador = mailOperador;
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getMailOperador() {
        return mailOperador;
    }

    public void setMailOperador(String mail) {
        this.mailOperador = mail;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
