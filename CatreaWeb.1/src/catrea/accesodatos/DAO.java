package catrea.accesodatos;

import catrea.excepcion.BaseDeDatosException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    protected final String NOMBRE_BASE_DE_DATOS = "catrea";
    protected final String NOMBRE_USUARIO = "root";
    protected final String PASSWORD_USUARIO = "";
    
    protected Connection obtenerConexion() throws BaseDeDatosException {
        Connection conexion = null;

        try {
            //Cargamos el Driver MySQL
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + NOMBRE_BASE_DE_DATOS, NOMBRE_USUARIO, PASSWORD_USUARIO);
            System.out.println("conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            throw new BaseDeDatosException("Error de conexion a la base de datos: "+ e.getMessage());
        }
        return conexion;
    }  
    
    protected void cerrarConexion( Connection conexion) throws BaseDeDatosException {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new BaseDeDatosException("Error en el cierre de conexion con la base de datos: "+ e.getMessage());
        }
    }
}

