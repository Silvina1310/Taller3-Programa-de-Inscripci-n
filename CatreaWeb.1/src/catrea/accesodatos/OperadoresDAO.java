package catrea.accesodatos;

import catrea.bo.Operador;
import catrea.excepcion.BaseDeDatosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperadoresDAO extends DAO {
    private final String ALTA_OPERADOR = "INSERT INTO operadores (dni, nombre, apellido, "
            + "contrasenia) VALUES (?, ?, ?, ?)";
    private final String CONSULTA_OPERADOR = "Select * from operadores where dni = ?";
    
    public void altaOperador(Operador operador) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;

        try {
          prsmt = conn.prepareStatement(ALTA_OPERADOR);
          prsmt.setString(1, operador.getDni());
          prsmt.setString(2, operador.getNombre());
          prsmt.setString(3, operador.getApellido());
          prsmt.setString(4, operador.getContrasenia());
          prsmt.execute();
          cerrarConexion(conn);
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el alta de usuarios: "+ e.getMessage());
        }
    }
    public Operador recuperarOperador(String dni) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        Operador operador = null;
        try {
          prsmt = conn.prepareStatement(CONSULTA_OPERADOR);
          prsmt.setString(1, dni);//setear el dni
          ResultSet rs = prsmt.executeQuery();//Lista con los registros
          
          while(rs.next()) {//Pregunta si hay un registro mas
            operador = new Operador(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
          }
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en la consulta de operadores: "+ e.getMessage());
        }
        cerrarConexion(conn);
        return operador;
    }
} 

