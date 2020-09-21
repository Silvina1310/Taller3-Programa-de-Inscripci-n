package catrea.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catrea.excepcion.ServicioException;
import catrea.servicios.ManejadorPreinscripcion;

/**
 * Servlet implementation class BajaPreinscripcionServlet
 */
public class BajaPreinscripcionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaPreinscripcionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idPreinscripcion = Integer.parseInt((String)request.getParameter("idPreinscripcion"));
			int idAspirante = Integer.parseInt((String)request.getParameter("idAspirante"));
			ManejadorPreinscripcion manejadorPreinscripcion = new ManejadorPreinscripcion();
			manejadorPreinscripcion.bajaPreinscripcion(idPreinscripcion, idAspirante);
			response.sendRedirect("consulta_preinscripcion.jsp");
		} catch(ServicioException e) {
			response.sendRedirect("conexion-bd-error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
