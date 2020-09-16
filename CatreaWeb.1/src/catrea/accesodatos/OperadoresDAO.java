package catrea.accesodatos;

import catrea.bo.Operador;
import catrea.excepcion.BaseDeDatosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperadoresDAO extends DAO {
    private final String ALTA_OPERADOR = "INSERT INTO operadores (dni, nombre, apellido, "
            + "contrasenia, mail_operador, rol) VALUES (?, ?, ?, ?, ?, ?)";
    private final String CONSULTA_OPERADOR = "Select * from operadores where dni = ?";
    private final String CONSULTA_MAIL = "Select mail_operador from operadores where dni = ?";
    private final String ACTUALIZAR_PASSWORD = "UPDATE operadores SET contrasenia = ? WHERE dni = ?";
    private final String CONSULTA_OPERADORES = "Select * from operadores";
    private final String BAJA_OPERADOR = "DELETE FROM operadores WHERE dni = ?;";

    public void altaOperador(Operador operador) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;

        try {
          prsmt = conn.prepareStatement(ALTA_OPERADOR);
          prsmt.setString(1, operador.getDni());
          prsmt.setString(2, operador.getNombre());
          prsmt.setString(3, operador.getApellido());
          prsmt.setString(4, operador.getContrasenia());
          prsmt.setString(5, operador.getMailOperador());
          prsmt.setString(6, operador.getRol());
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
            operador = new Operador(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), 
            		rs.getString(6));
          }
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en la consulta de operadores: "+ e.getMessage());
        }
        cerrarConexion(conn);
        return operador;
    }
    
    public List<Operador> recuperarOperadores() throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        List<Operador> operadores = new ArrayList<>();
        try {
          prsmt = conn.prepareStatement(CONSULTA_OPERADORES);
          ResultSet rs = prsmt.executeQuery();//Lista con los registros
          
          while(rs.next()) {//Pregunta si hay un registro mas
            operadores.add(new Operador(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), 
            		rs.getString(6)));
          }
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en la consulta de operadores: "+ e.getMessage());
        }
        cerrarConexion(conn);
        return operadores;
    }
    
    public int actualizarPasswordOperador(String dni, String nuevoPassword) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        int rows = 0;
        try {
          prsmt = conn.prepareStatement(ACTUALIZAR_PASSWORD);
          prsmt.setString(1, nuevoPassword);//setear el dni
          prsmt.setString(2, dni);//setear el dni
          rows = prsmt.executeUpdate();
          
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en la actualizacion de operadores: "+ e.getMessage());
        } finally {
            cerrarConexion(conn);
        }
        return rows;
    }
    
    public String recuperarMailOperador(String dni) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        ResultSet rs;
        String mail = null;
        try {
          prsmt = conn.prepareStatement(CONSULTA_MAIL);
          prsmt.setString(1, dni);//setear el dni
          rs = prsmt.executeQuery();//Lista con los registros
          if(rs.next())
        	  mail = rs.getString(1);
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en la actualizacion de operadores: "+ e.getMessage());
        } finally {
            cerrarConexion(conn);
        }
        
        return mail;
    }
    
    public void darDeBajaOperador(String dni) throws BaseDeDatosException {
        Connection conn = obtenerConexion();
        PreparedStatement prsmt = null;
        
        try {
          prsmt = conn.prepareStatement(BAJA_OPERADOR);
          prsmt.setString(1, dni);
          prsmt.execute();
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el borrado de operador: "+ e.getMessage());
        }
        cerrarConexion(conn);
    }
} 

