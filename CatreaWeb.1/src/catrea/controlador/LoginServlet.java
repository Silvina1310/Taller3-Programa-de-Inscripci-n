package catrea.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catrea.bo.Operador;
import catrea.excepcion.ContraseniaNoEncontradaException;
import catrea.excepcion.OperadorNoEncontradoException;
import catrea.excepcion.ServicioException;
import catrea.servicios.Autenticador;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ADMINISTRADOR = "administrador";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String dni = (String)request.getParameter("dni");
		String password = (String)request.getParameter("pass");
		
		if((dni != null && !dni.isEmpty()) && (password != null && !password.isEmpty())) {
			try {
				Autenticador autenticador = new Autenticador();
				Operador miOperador = autenticador.autenticarOperador(dni, password);
				HttpSession session = (HttpSession)request.getSession(true);
				session.setAttribute("operador", miOperador);

				if(ADMINISTRADOR.equals(miOperador.getRol())) {
					response.sendRedirect("menu-admin.jsp");
				} else {
					response.sendRedirect("menu-opciones.jsp");
				}
			} catch (OperadorNoEncontradoException e) {
				response.sendRedirect("login-operador-error.jsp");
			} catch (ContraseniaNoEncontradaException e) {
				response.sendRedirect("login-contrasenia-error.jsp");
			} catch (ServicioException e) {
				e.printStackTrace();
			}
		}
	}

}
