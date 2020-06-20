
package catrea.accesodatos;

import catrea.bo.Aspirante;
import catrea.bo.Carrera;
import catrea.bo.Operador;
import catrea.bo.Preinscripcion;
import catrea.excepcion.BaseDeDatosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreinscripcionesDAO extends DAO{
    
    private final String ALTA_PREINSCRIPCION = "INSERT INTO preinscripciones (fecha, id_carrera, "
            + "id_operador, id_aspirante) values (?, ?, ?, ?)";
    private final String CONSULTA_PREINSCRIPCION = "select pr.id_preinscripcion, pr.fecha, ca.id_carrera, "
            + "ca.nombre, ca.duracion, op.dni, op.nombre, op.apellido, op.contrasenia, "
            + "asp.id_aspirante, asp.nombre, asp.apellido, asp.dni, asp.estadocivil, asp.nivelestudio, asp.localidad, "
            + "asp.telefono, asp.mail from preinscripciones as pr, carreras as ca, operadores as op, "
            + "aspirantes as asp where pr.id_carrera = ca.id_carrera and pr.id_operador = op.dni and "
            + "pr.id_aspirante = asp.id_aspirante;";
    
    public void altaPreinscripcion(Preinscripcion preinscripcion) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        try {
          prsmt = conn.prepareStatement(ALTA_PREINSCRIPCION);
          java.sql.Date date = new java.sql.Date(preinscripcion.getFecha().getTime());
          prsmt.setDate(1, date);
          prsmt.setInt(2, preinscripcion.getCarrera().getIdCarrera());
          prsmt.setString(3, preinscripcion.getOperador().getDni());
          prsmt.setInt(4, preinscripcion.getAspirante().getIdAspirante());
          prsmt.execute();
          cerrarConexion(conn);
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el alta de preinscripcion: "+ e.getMessage());
        }
        
    }
    
    public List<Preinscripcion> recuperarPreinscripciones() throws BaseDeDatosException {
        List<Preinscripcion> preinscripciones = new ArrayList<>();//Creo una lista de objetos carrera
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        
        try {
          prsmt = conn.prepareStatement(CONSULTA_PREINSCRIPCION);
          ResultSet rs = prsmt.executeQuery();//Lista con los registros
          while(rs.next()) {//Pregunta si hay un registro mas
                
                Carrera carrera = new Carrera(rs.getInt(3), rs.getString(4), rs.getInt(5));
                Operador operador = new Operador(rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                Aspirante aspirante = new Aspirante(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13),
                rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
                java.util.Date date = new java.util.Date(rs.getDate(2).getTime());
                Preinscripcion preinscripcion = new Preinscripcion(rs.getInt(1), date, aspirante, carrera, operador);
                preinscripciones.add(preinscripcion);
          }
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el consulta de carreras: "+ e.getMessage());
        }
        cerrarConexion(conn);
        return preinscripciones;
    }
    
}
