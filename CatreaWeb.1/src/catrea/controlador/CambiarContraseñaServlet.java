package catrea.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catrea.bo.Operador;
import catrea.servicios.Operadores;

/**
 * Servlet implementation class CambiarContraseñaServlet
 */
public class CambiarContraseñaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarContraseñaServlet() {
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
		boolean estaLogueado = miOperador != null;
		String dni = null;
		Operadores servicioOperadores = new Operadores();

		try {
			if(estaLogueado) { 
				dni = miOperador.getDni();
				String nuevoPassword = (String)request.getParameter("pass");
				servicioOperadores.actualizarPassword(dni, nuevoPassword);
				response.sendRedirect("password-modificado-exitosamente.jsp");

			} else {
				dni = (String)request.getParameter("dni");
				servicioOperadores.recuperarPassword(dni);
				response.sendRedirect("login.jsp");
			}
			
		} catch(Exception e) {
			response.sendRedirect("conexion-bd-error.jsp");
		}
	}

}
