<%-- 
    Document   : consulta_preinscripcion
    Created on : 09-may-2020, 15:50:57
--%>
<%@page import="catrea.servicios.ManejadorPreinscripcion"%>
<%@page import="catrea.bo.Preinscripcion"%>
<%@page import="catrea.bo.Operador"%>
<%@page import="catrea.excepcion.ServicioException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
%>
<%
	boolean isLoggedIn = (session != null && session.getAttribute("operador") != null);
	if(!isLoggedIn) {
		response.sendRedirect("/CatreaWeb/login.jsp");
	}
	
	Operador miOperador = (Operador)session.getAttribute("operador");
%>
       <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="./CSS/estilos.css" />
    <title>Consulta Preinscripción</title>
</head>

<body>
    <div class="content">
	    <header>  
	    	<div class="operador">
    			<%Operador operador = (Operador)session.getAttribute("operador");%>
    		</div>
    	    
	        <div id="titulo">   
	        <p>CATREA - Centro de Atención Telefónica para el Reclutamiento en el Ejército Argentino</p>                  
	        <p>0800-555-555</p>
	        </div> 
	    </header>

		<div class="contenedor1">
		    <p class="encabezado">Listado de Inscripciones</p>
		        <div id="main-container">
		            <table id="tablaPreinscripciones" class="tabla">
		                <thead>
		                    <tr>
		                        <th scope="col">ID</th>
		                        <th scope="col">Fecha</th>
		                        <th scope="col">Nombre Carrera</th>
		                        <th scope="col">DNI Aspirante</th>
		                        <th scope="col">Nombre</th>
		                        <th scope="col">Apellido</th>
		                        <th scope="col">Mail</th>
		                        <th scope="col">Usuario Operador</th>
		                        <th scope="col"></th>
		                    </tr>
		                </thead>
		        </div>
		        </tbody>
		        <%
		        	try {
			        	ManejadorPreinscripcion servicioPreinscripcion = new ManejadorPreinscripcion();
			        	List<Preinscripcion> preinscripciones = servicioPreinscripcion.recuperarPreinscripcionesPorOperador(miOperador.getDni());
			        	for(Preinscripcion p : preinscripciones) {
			        		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			        		String fecha = format.format(p.getFecha());
			        %>
			        <tr>
			        	<th><%= Integer.toString(p.getIdPreinscripcion()) %></th>
			        	<th><%= fecha %></th>
			        	<th><%= p.getCarrera().getNombre()%></th>
			        	<th><%= p.getAspirante().getDni()%></th>
			        	<th><%= p.getAspirante().getNombre()%></th>
			        	<th><%= p.getAspirante().getApellido()%></th>
			        	<th><%= p.getAspirante().getMail()%></th>
			        	<th><%= p.getOperador().getNombre()%></th>
			            <th><button onclick="darDeBaja(this, '<%= Integer.toString(p.getIdPreinscripcion()) %>', '<%= Integer.toString(p.getAspirante().getIdAspirante()) %>')" type="submit" class="btn btn-primary float-left">Baja</button></th>
			        	
			        </tr>
			        
			        <% } %>
			      	</table>
			        <%
		        	} catch(ServicioException e) {
		        		%>
		        		<h1>Error en recuperar los datos</h1>
		        		<h2><%=e.getMessage() %></h2>
		        		
		        		<% 
		        	}
		        %>
		        </div>
		        </tbody>
		        </table>
		        
		        <%
	   			if(miOperador.getRol().equals("administrador")) {	
	   			%>
	   		  <div>
	        	<button type="submit" class="btn btn-primary float-right"><a href="menu-admin.jsp">
	            	Volver</a></button>
	        </div> 		
	   		<%	} else { %>
		   <div>
	        	<button type="submit" class="btn btn-primary float-right"><a href="menu-opciones.jsp">
	            	Volver</a></button>
	        </div>
	        <% } %>
        </div>
	    </div>
   </div> 
       
	<footer>
        Materia: Taller de Desarrollo e Implementación | Prof. Lic. Mariano Trigila | Alumnos: Ucedo-Rivera-Paez
    </footer>
    
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>    
		<script type="text/javascript" src="./script/baja.js"></script>
	
</body>
 
</html>