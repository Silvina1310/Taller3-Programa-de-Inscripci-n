package catrea.servicios;

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
    	
      new LoginUI().setVisible(true);
    	Carrera miCarrera = new Carrera(2, "soldado voluntario", 4);
    	CarrerasDAO dao = new CarrerasDAO();
    	dao.altaCarrera(miCarrera);
      
    	List<Carrera> carreras = dao.recuperarCarreras();
    	for(Carrera c : carreras) {
    		System.out.println(c);
    	}
    	
      Aspirante miAspirante = new Aspirante(-1, "flor", "lopez", "9897357", "casado",
      "secundario", "caba", "iifjsdmdfs", "847366357");
      AspirantesDAO aspi = new AspirantesDAO(); 
      aspi.altaAspirante(miAspirante); 
      
      Operador miOperador = new Operador("94847478", "pablo", "gonzalez", "Espinosa");
      OperadoresDAO oper = new OperadoresDAO();
      oper.altaOperador(miOperador);
      
     
      
      
    }
}
