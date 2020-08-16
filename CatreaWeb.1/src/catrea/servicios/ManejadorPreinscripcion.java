package catrea.servicios;

import catrea.accesodatos.CarrerasDAO;
import catrea.accesodatos.AspirantesDAO;
import catrea.accesodatos.PreinscripcionesDAO;
import catrea.bo.Carrera;
import catrea.bo.Preinscripcion;
import catrea.bo.Aspirante;
import catrea.excepcion.BaseDeDatosException;
import catrea.excepcion.AspiranteExistenteException;
import catrea.excepcion.ServicioException;
import java.util.List;

public class ManejadorPreinscripcion {
    private AspirantesDAO dao = null;
    private CarrerasDAO daoCarreras = null;
    
    
    public void crearPreinscripcion(Preinscripcion preinscripcion) throws AspiranteExistenteException, ServicioException {
       try {
            dao = new AspirantesDAO();
            Aspirante aspirante = preinscripcion.getAspirante();//Recuperamos los 2 objetos
            if(!estaPostulado(aspirante.getDni())) {
                dao.altaAspirante(aspirante); 
            } else {
                throw new AspiranteExistenteException("El aspirante con dni" + aspirante.getDni() + "ya esta"
                   + "inscripto"); 
            }
       } catch (BaseDeDatosException e) {
           throw new ServicioException(e.getMessage()) ;
       }
    }
     
    private boolean estaPostulado(String dni) throws BaseDeDatosException{
        Aspirante aspirante = dao.recuperarAspirante(dni);
        return aspirante != null;
    }
    
    public List<Carrera> obtenerCarreras() throws BaseDeDatosException {
        daoCarreras = new CarrerasDAO();
        List<Carrera> carreras = daoCarreras.recuperarCarreras();
        return carreras;
    }
    
    public List<Preinscripcion> recuperarPreinscripcionesPorOperador(String id) throws ServicioException{
        try{
            PreinscripcionesDAO dao = new PreinscripcionesDAO();
            List <Preinscripcion> preinscripciones = null;
            preinscripciones = dao.recuperarPreinscripcionesPorOperador(id);
            return preinscripciones;
        }catch(BaseDeDatosException e) {
            throw new ServicioException(e.getMessage()) ;
        }    
    }
}
