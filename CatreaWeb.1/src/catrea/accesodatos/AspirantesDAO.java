package catrea.accesodatos;

import catrea.bo.Aspirante;
import catrea.excepcion.BaseDeDatosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class AspirantesDAO extends DAO {
    private final String ALTA_ASPIRANTE = "INSERT INTO aspirantes (nombre, apellido, dni, estadocivil, nivelestudio,"
        + "localidad, mail, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CONSULTA_ASPIRANTE = "Select * from aspirantes where dni = ?";
    private final String BAJA_ASPIRANTE = "DELETE FROM aspirantes WHERE id_aspirante = ?;";
    
    public int altaAspirante(Aspirante aspirante) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        try {
          prsmt = conn.prepareStatement(ALTA_ASPIRANTE, Statement.RETURN_GENERATED_KEYS);
          prsmt.setString(1, aspirante.getNombre());
          prsmt.setString(2, aspirante.getApellido());
          prsmt.setString(3, aspirante.getDni());
          prsmt.setString(4, aspirante.getEstadoCivil());
          prsmt.setString(5, aspirante.getNivelEstudio());
          prsmt.setString(6, aspirante.getLocalidad());
          prsmt.setString(7, aspirante.getMail());
          prsmt.setString(8, aspirante.getTelefono());
          prsmt.execute();
          ResultSet resultSet = prsmt.getGeneratedKeys();
          resultSet.next();
          int idGeneratedId = resultSet.getInt(1);
          cerrarConexion(conn);
          
          return idGeneratedId;

        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el alta de aspirantes: "+ e.getMessage());
        }
    }
    
    public Aspirante recuperarAspirante(String dni) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        Aspirante aspirante = null;
        try {
          prsmt = conn.prepareStatement(CONSULTA_ASPIRANTE);
          prsmt.setString(1, dni);//setear el dni
          ResultSet rs = prsmt.executeQuery();//Lista con los registros
          
          while(rs.next()) {//Pregunta si hay un registro mas
            aspirante = new Aspirante(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
            rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
          }
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en la consulta de postulantes: "+ e.getMessage());
        }
        cerrarConexion(conn);
        return aspirante;
    }
    
    public void darDeBajaAspirante(int idAspirante) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        
        try {
          prsmt = conn.prepareStatement(BAJA_ASPIRANTE);
          prsmt.setInt(1, idAspirante);
          prsmt.execute();
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el borrado de aspirante: "+ e.getMessage());
        }
        cerrarConexion(conn);
    }
} 
