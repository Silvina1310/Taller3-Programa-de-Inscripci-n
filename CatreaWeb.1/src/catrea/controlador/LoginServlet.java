package catrea.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				response.sendRedirect("menu-opciones.jsp");
			} catch (OperadorNoEncontradoException e) {
				response.sendRedirect("error-operador-no-encontrado.html");
			} catch (ContraseniaNoEncontradaException e) {
				response.sendRedirect("error-operador-no-encontrado.html");
			} catch (ServicioException e) {
				e.printStackTrace();
			}
		}
	}

}
