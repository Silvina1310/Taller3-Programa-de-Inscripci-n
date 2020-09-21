package catrea.controlador.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutenticacionFilter
 */
@WebFilter("/AutenticacionFilter")
public class AutenticacionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutenticacionFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;

		HttpSession session = (HttpSession)req.getSession();
		boolean isLoginRequest = req.getRequestURI().endsWith("login");
		boolean isLoginPageRequest = req.getRequestURI().endsWith("login.jsp");
		boolean isLoggedIn = (session != null && session.getAttribute("operador") != null);
		boolean isLoggingError = req.getRequestURI().endsWith("error.jsp");
		boolean isRecuperarContrasenia = req.getRequestURI().endsWith("contrasenia.jsp") || req.getRequestURI().endsWith("cambiarContrasenia");

	    if(req.getRequestURI().endsWith(".css") || 
	    		req.getRequestURI().endsWith(".js") || 
	    		req.getRequestURI().endsWith(".jfif")){
	    	
	        chain.doFilter(request,response);
	        return;
	      }
	    	    
		// Esta logueado y se quiere loguear -> vamos al menu de opciones
		if(isLoggedIn && isLoginRequest || isLoggedIn && isLoginPageRequest) {
			res.sendRedirect("/CatreaWeb/menu-opciones.jsp");
			return;
		} else if(!isLoggedIn && isLoginRequest) { // No esta logueado y quiere loguearse
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}
		else if(!isLoggedIn && isLoggingError || !isLoggedIn && isRecuperarContrasenia) {
	        chain.doFilter(request,response);
	        return;
		} if(!isLoggedIn && !isLoginPageRequest) {// No esta logueado y quiere navegar la pagina		
			//RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			//dispatcher.forward(request, response);
			res.sendRedirect("/CatreaWeb/login.jsp");
			return;
		} 
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
