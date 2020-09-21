package catrea.controlador;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catrea.bo.Aspirante;
import catrea.bo.Carrera;
import catrea.bo.Operador;
import catrea.bo.Preinscripcion;
import catrea.excepcion.AspiranteExistenteException;
import catrea.excepcion.ServicioException;
import catrea.servicios.ManejadorPreinscripcion;

/**
 * Servlet implementation class AltaAspirantesServlet
 */
public class AltaAspirantesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaAspirantesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (HttpSession)request.getSession(true);
		Operador miOperador = (Operador)session.getAttribute("operador");
		List<Carrera> listaCarreras = (List<Carrera>)session.getAttribute("listaCarreras");
		
		String nombre = (String)request.getParameter("NOMBRE");
		String apellido = (String)request.getParameter("APELLIDO");
		String dni = (String)request.getParameter("DNI");
		String localidad = (String)request.getParameter("LOCALIDAD");
		String email = (String)request.getParameter("E-MAIL");
		String telefono = (String)request.getParameter("TELEFONO");
		String estadoCivil = (String)request.getParameter("ESTADOCIVIL");
		String nivelEstudio = (String)request.getParameter("NIVELESTUDIO");
		String idCarreraDisponible = (String)request.getParameter("CARRERADISPONIBLE");
		
		boolean sonLosDatosValidos = esValorValido(nombre) && esValorValido(apellido) &&
				esValorValido(dni) && esValorValido(localidad) && esValorValido(email) && 
				esValorValido(telefono) && esValorValido(estadoCivil) && esValorValido(nivelEstudio) &&
				esValorValido(idCarreraDisponible);
		
		if(sonLosDatosValidos) {
			ManejadorPreinscripcion manejador = new ManejadorPreinscripcion();
			Aspirante aspirante = new Aspirante(-1, nombre, apellido, dni, estadoCivil, nivelEstudio, localidad, email, telefono);

			Carrera carrera = obtenerCarrera(listaCarreras, idCarreraDisponible);			
			Preinscripcion preinscripcion = new Preinscripcion(-1, new Date(), aspirante, carrera, miOperador);
			
			try {
				manejador.crearPreinscripcion(preinscripcion);
				response.sendRedirect("confir-formulario.jsp");
			} catch(ServicioException e) {
				response.sendRedirect("conexion-bd-error.jsp");		
			} catch(AspiranteExistenteException e) {
				response.sendRedirect("aspirante-existente-error.jsp");		
			}
		} else {
			response.sendRedirect("conexion-bd-error.jsp");
		}
	}
	
	private boolean esValorValido(String str) {
		return str != null && !str.isEmpty();
	}
	
	private Carrera obtenerCarrera(List<Carrera> listaCarreras, String idCarrera) {
		for(Carrera c : listaCarreras) {
			if(c.getIdCarrera() == Integer.parseInt(idCarrera)) {
				return c;
			}
		}
		
		return null;
	}

}
