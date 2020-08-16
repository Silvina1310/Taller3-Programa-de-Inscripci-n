package catrea.servicios;

import catrea.accesodatos.OperadoresDAO;
import catrea.bo.Operador;
import catrea.excepcion.BaseDeDatosException;
import catrea.excepcion.ContraseniaNoEncontradaException;
import catrea.excepcion.ServicioException;
import catrea.excepcion.OperadorNoEncontradoException;

public class Autenticador {
   
    public Operador autenticarOperador(String dni, String contrasenia) throws OperadorNoEncontradoException, 
            ContraseniaNoEncontradaException, ServicioException {
       try {
        OperadoresDAO dao = new OperadoresDAO();
        
        Operador operador= dao.recuperarOperador(dni);
        if(operador != null) {
            //compara dos objetos la que ingreso por teclado y la que tengo en la base de datos
            if(operador.getContrasenia().equals(contrasenia)) {
                return operador;
            }   else {
                throw new ContraseniaNoEncontradaException("La contraseña es incorrecta");
            } 
        } else {
            throw new OperadorNoEncontradoException("El usuario" + dni + "no fue encontrado");
        } 
       } catch(BaseDeDatosException e) {
           throw new ServicioException(e.getMessage()) ;
       }
    }
}
