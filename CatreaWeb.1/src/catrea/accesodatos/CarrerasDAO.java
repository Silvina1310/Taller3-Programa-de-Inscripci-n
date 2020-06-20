package catrea.accesodatos;

import catrea.bo.Carrera;
import catrea.excepcion.BaseDeDatosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrerasDAO extends DAO{
    private final String ALTA_CARRERAS = "INSERT INTO carreras (nombre, duracion) values (?, ?)";
    private final String CONSULTA_CARRERAS = " Select * from carreras";
    
    public void altaCarrera(Carrera carrera) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
   
        try {
          prsmt = conn.prepareStatement(ALTA_CARRERAS);
          prsmt.setString(1, carrera.getNombre());
          prsmt.setInt(2, carrera.getDuracion());
          
          prsmt.execute();
          cerrarConexion(conn);
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el alta de carreras: "+ e.getMessage());
        }
    }
    
    public List<Carrera> recuperarCarreras() throws BaseDeDatosException {
        List<Carrera> carreras = new ArrayList<>();//Creo una lista de objetos carrera
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        
        try {
          prsmt = conn.prepareStatement(CONSULTA_CARRERAS);
          ResultSet rs = prsmt.executeQuery();//Lista con los registros
          while(rs.next()) {//Pregunta si hay un registro mas
              Carrera carrera = new Carrera(rs.getInt(1), rs.getString(2), rs.getInt(3));
              carreras.add(carrera);
          }
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el consulta de carreras: "+ e.getMessage());
        }
        cerrarConexion(conn);
        return carreras;
    }
}
