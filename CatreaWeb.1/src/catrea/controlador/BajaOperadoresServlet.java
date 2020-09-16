<<<<<<< HEAD
package catrea.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catrea.excepcion.ServicioException;
import catrea.servicios.Operadores;

/**
 * Servlet implementation class BajaOperadoresServlet
 */
public class BajaOperadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaOperadoresServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String dni = request.getParameter("dni");
			Operadores operadores = new Operadores();
			operadores.bajaOperador(dni);
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
=======
package catrea.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catrea.excepcion.ServicioException;
import catrea.servicios.Operadores;

/**
 * Servlet implementation class BajaOperadoresServlet
 */
public class BajaOperadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaOperadoresServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String dni = request.getParameter("dni");
			Operadores operadores = new Operadores();
			operadores.bajaOperador(dni);
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
>>>>>>> 86c1c97ec9cbffddabed5ad798a53819f061f3b4
