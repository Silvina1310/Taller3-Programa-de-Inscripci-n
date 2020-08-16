package catrea.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import catrea.bo.Operador;
import catrea.bo.Preinscripcion;
import catrea.excepcion.ServicioException;
import catrea.servicios.ManejadorPreinscripcion;

/**
 * Servlet implementation class ConsultaPreinscripcionServlet
 */
@WebServlet("/consultaPreinscripcion")
public class ConsultaPreinscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPreinscripcionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("consulta_preinscripciones.jsp");
			ManejadorPreinscripcion manejadorPreinscripcion = new ManejadorPreinscripcion();
			HttpSession session = (HttpSession)request.getSession();
			Operador operador = (Operador)session.getAttribute("operador");		
			List<Preinscripcion> preinscripciones = manejadorPreinscripcion.
					recuperarPreinscripcionesPorOperador(operador.getDni());
			request.setAttribute("preinscripciones", preinscripciones);
			requestDispatcher.forward(request, response);
		} catch (ServicioException e) {
			// Tiene que redirigir a una pagina de error
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
