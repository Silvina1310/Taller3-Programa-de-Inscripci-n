package catrea.bo;

/**
 *bussines object. guarda informacion adentro de un paquete,aspirante, postulante, carrerra
 */
public class Aspirante {
    private int idAspirante;
    private String nombre;
    private String apellido;
    private String dni;
    private String estadoCivil;
    private String nivelEstudio;
    private String localidad;
    private String mail;
    private String telefono;
    //private int id_preinscripcion;
    
    public Aspirante(int idAspirante, String nombre, String apellido,
            String dni, String estadoCivil, String nivelEstudio, String localidad, String mail,
            String telefono) {
        this.idAspirante = idAspirante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
        this.localidad = localidad;
        this.nivelEstudio = nivelEstudio;
        this.mail = mail;
        this.telefono = telefono;
    }
    
    public int getIdAspirante() {
        return idAspirante;
    }

    public void setIdAspirante(int idAspirante) {
        this.idAspirante = idAspirante;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
    
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
