<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="catrea.servicios.ManejadorPreinscripcion"%>
<%@page import="catrea.excepcion.ServicioException"%>
<%@page import="catrea.bo.Carrera"%>
<%@page import="catrea.bo.Operador"%>
<%@page import="java.util.List"%>

<%
	boolean isLoggedIn = (session != null && session.getAttribute("operador") != null);
	if(!isLoggedIn) {
		response.sendRedirect("/CatreaWeb/login.jsp");
	}

   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   
   ManejadorPreinscripcion manejadorPreinscripcion = new ManejadorPreinscripcion();
   List<Carrera> listaCarreras = manejadorPreinscripcion.obtenerCarreras();
   session.setAttribute("listaCarreras", listaCarreras);
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="./CSS/estilos.css" />
    <title>Formulario</title>
</head>

<body>
    <header>  
    	<div class="operador">
    		<%Operador miOperador = (Operador)session.getAttribute("operador");%>
    	</div>
    	    
        <div id="titulo">   
        <p>CATREA - Centro de Atención Telefónica para el Reclutamiento en el Ejército Argentino</p>                  
        <p>0800-555-555</p>
        </div> 
    </header>
    
    <div class="contenedor1">
	    <p class="encabezado">Formulario de Inscripción</p>
	    <form id="altaForm" action="/CatreaWeb/altaAspirante" method="post" class="contenedor-fieldset" onsubmit="validarCamposFormulario(event)">
	    
	        <div class="contenedor">    
	            <div>
	                <button type="submit" class="btn btn-primary float-right">
	                    <a href="/CatreaWeb/logout">Logout</a></button>
	            </div>
	            
	            <fieldset>
	                <legend>Complete los datos</legend>
	                <div class="contenedor-input">
	                    <input class="form-login" placeholder="Nombre" name="NOMBRE" id="nombre" type="text" />
	                </div>
	                <div class="contenedor-input">
	                    <input class="form-login" placeholder="Apellido" name="APELLIDO" id="apellido" type="text" />
	                </div>
	                <div class="contenedor-input">
	                    <input class="form-login" placeholder="DNI" name="DNI" type="text" size="10" id="dni"maxlength="9" />
	                </div>
	                <div class="contenedor-input">
	                    <input class="form-login" placeholder="Localidad" name="LOCALIDAD" type="text" id="localidad"/>
	                </div>
	                <div class="contenedor-input">
	                <label>Estado civil</label><br>
	                    <input type="radio" name="ESTADOCIVIL" id="cbox2" value="soltero" checked="checked"> <label for="cbox2">Soltero</label><br>
	                	<input type="radio" name="ESTADOCIVIL" id="cbox3" value="casado"> <label for="cbox3">Casado</label>
	                </div>
	                <div class="contenedor-input">
	                    <label for="seleccionar">Nivel de estudio</label>
	                    <select id="nivelEstudio" class="form-control" name="NIVELESTUDIO">
		                    <option value="sinSeleccion" selected>Seleccionar...</option>
		                    <option value="secundarioCompleto">Secundario completo</option>
		                    <option value="secundarioIncompleto">Secundario incompleto</option>
	                    </select>
	                </div>
	                <div class="contenedor-input">
	                    <input class="form-login" placeholder="E-mail" name="E-MAIL" type="text" id="email"/>
	                </div>
	                <div class="contenedor-input">
	                    <input class="form-login" placeholder="Teléfono" name="TELEFONO" type="number" id="telefono"/>
	                </div>
	                <div class="form-group col-md-4">
	                    <label for="seleccionar">Carreras Disponibles</label>
	                    <select id="carerraDisponible" class="form-control" name="CARRERADISPONIBLE">
		                    <option value="-1" selected>Seleccionar...</option>
		                    <%
		                    	for(Carrera c : listaCarreras) {
		                    %>
		                    	<option value="<%=c.getIdCarrera() %>"><%=c.getNombre()%></option>
		                    <%	
		                    	}
		                    %>
	                    </select>   
	                </div>
	            </fieldset>
	        </div>
	        <div class="guardar">
	        	<button type="submit" name="enviar" value="Guardar" class="btn btn-primary float-right">
	        	<a>Guardar</a></button><br>
	        	<button type="submit" class="btn btn-primary float-left">
	            <a href="menu-opciones.jsp">Volver</a></button>
	            
	            
	            
	        </div> 
	    </form>
    </div>
    
    <footer>
        Materia: Taller de Desarrollo e Implementación | Prof. Lic. Mariano Trigila | Alumnos: Ucedo-Rivera-Paez
    </footer>
    
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script type="text/javascript" src="./script/validacion.js"></script>
   
</body>
</html>