package catrea.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catrea.bo.Carrera;
import catrea.bo.Operador;
import catrea.excepcion.OperadorExistenteException;
import catrea.excepcion.ServicioException;
import catrea.servicios.Operadores;

/**
 * Servlet implementation class AltaOperadorServlet
 */
public class AltaOperadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ADMINISTRADOR = "administrador";
    private static final String OPERADOR = "operador";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaOperadorServlet() {
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
		String nombre = (String)request.getParameter("nombre");
		String apellido = (String)request.getParameter("apellido");
		String dni = (String)request.getParameter("dni");
		String email = (String)request.getParameter("email");
		String contrasenia = (String)request.getParameter("contrasenia");
		String rol = (String)request.getParameter("rol");
		
		boolean sonLosDatosValidos = esValorValido(nombre) && esValorValido(apellido) &&
				esValorValido(dni) && esValorValido(email) && esValorValido(dni) && esValorValido(email) &&
				esValorValido(contrasenia) && esValorValido(rol) && (ADMINISTRADOR.equals(rol) || OPERADOR.equals(rol));
		
		if(sonLosDatosValidos) {
			try {
				Operadores manejador = new Operadores();
				Operador operador = new Operador(dni, nombre, apellido, contrasenia, email, rol);
				manejador.altaOperador(operador);
				response.sendRedirect("confir-formulario.jsp");
			} catch(ServicioException e) {
				e.printStackTrace();
				response.sendRedirect("conexion-bd-error.jsp");		
			} catch(OperadorExistenteException e) {
				response.sendRedirect("operador-existente-error.jsp");		
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
