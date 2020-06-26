package catrea.bo;

public class Operador {
    private String dni;
    private String nombre;
    private String apellido;
    private String contrasenia;
    
    public Operador(String dni, String nombre, String apellido, String contrasenia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia= contrasenia;
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
}
