<%-- 
    Document   : consulta_preinscripcion
    Created on : 09-may-2020, 15:50:57
--%>
<%@page import="catrea.servicios.Operadores"%>
<%@page import="catrea.bo.Preinscripcion"%>
<%@page import="catrea.bo.Operador"%>
<%@page import="catrea.excepcion.ServicioException"%>

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
    <title>Consulta Operadores</title>
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
		    <p class="encabezado">Listado de Usuarios del Sistema</p>
		        <div id="main-container">
		            <table id="tablaOperadores" class="tabla">
		                <thead>
		                    <tr>
		                        <th scope="col">DNI</th>
		                        <th scope="col">NOMBRE</th>
		                        <th scope="col">APELLIDO</th>
		                        <th scope="col">MAIL_OPERADOR</th>
		                        <th scope="col">ROL</th>
		                        <th scope="col"></th>
		                    </tr>
		                </thead>
		        </div>
		        </tbody>
		        <%
		        	try {
			        	Operadores manejador = new Operadores();
			        	List<Operador> operadores = manejador.recuperarOperadores();
			        	for(Operador o : operadores) {
			        %>
			        <tr>
			        	<th><%= o.getDni() %></th>
			        	<th><%= o.getNombre() %></th>
			        	<th><%= o.getApellido()%></th>
			        	<th><%= o.getMailOperador()%></th>
			        	<th><%= o.getRol()%></th>

			            <th><button onclick="darDeBajaOperador(this, '<%= o.getDni() %>')" type="submit" class="btn btn-primary float-left">Baja</button></th> 
			        	
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
		        
		        <div class="contenedor-button-consulta">
		            <a href="menu-admin.jsp"><button type="submit" class="btn btn-primary float-right">Volver</button></a>
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