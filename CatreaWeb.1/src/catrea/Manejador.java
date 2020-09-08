package catrea;

import catrea.accesodatos.AspirantesDAO;
import catrea.accesodatos.CarrerasDAO;
import catrea.accesodatos.OperadoresDAO;
import catrea.accesodatos.PreinscripcionesDAO;
import catrea.bo.Aspirante;
import catrea.bo.Carrera;
import catrea.bo.Operador;
import catrea.bo.Preinscripcion;
import catrea.excepcion.BaseDeDatosException;
import java.util.Date;
import java.util.List;

public class Manejador {
    
    //Punto de entrada a la aplicacion
    public static void main (String[] args) throws BaseDeDatosException {
      /*Carrera miCarrera = new Carrera(1, "soldado voluntario", 4);
       CarrerasDAO dao = new CarrerasDAO();
       dao.altaCarrera(miCarrera);*/
      
      /*Aspirante miAspirante = new Aspirante(-1, "flor", "lopez", "98473357", "casado",
      "secundario", "caba", "iifjsdmdfs", "847366357");
      AspirantesDAO dao = new AspirantesDAO(); 
      dao.altaAspirante(miAspirante);*/
      
      /*Operador miOperador = new Operador("94847474", "pablo", "gonzalez", "Espinosa");
      OperadoresDAO dao = new OperadoresDAO();
      dao.altaOperador(miOperador);*/
      /*Carrera miCarrera = new Carrera(8, "soldado voluntario", 4);
      Aspirante miAspirante = new Aspirante(18, "flor", "lopez", "98473357", "casado",
      "secundario", "caba", "iifjsdmdfs", "847366357");
      Operador miOperador = new Operador("94847474", "pablo", "gonzalez", "Espinosa");
      
      Date date = new Date();
      
      //Preinscripcion miPreinscripcion = new Preinscripcion(-1, date, miAspirante,
      //miCarrera, miOperador);
      PreinscripcionesDAO dao = new PreinscripcionesDAO();
      //dao.altaPreinscripcion(miPreinscripcion);
      List <Preinscripcion> miPreinscripcion = null;
      miPreinscripcion = dao.recuperarPreinscripciones();
      System.out.println(miPreinscripcion);*/
    }
}