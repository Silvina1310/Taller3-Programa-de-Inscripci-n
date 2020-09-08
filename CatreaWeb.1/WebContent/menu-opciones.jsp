<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="catrea.bo.Operador"%>

<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="./CSS/estilos.css" /> 
    <title>Menu opciones</title>
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
        <p class="encabezado">Menú de Opciones</p>
        
        <div class="contenedor-menu-opcion">
            <div class="contenedor-button">
                <div class="primeropcion">  
                <button type="button" class="uno"><a href="consulta_preinscripcion.jsp">
                            Consulta Preinscripción</a></button>
                </div>

                <div class="segundaopcion">
                    <button type="button" class="dos"><a href="formulario.jsp">
                            Alta Preinscripción</a></button>
                </div>
                
                <div class="terceraopcion">  
                	<button type="button" class="tres"><a href="cambiar-contrasenia.jsp">
                            Cambiar contraseña</a></button>
                </div>
                
            </div>
            
            <div>
                <button type="submit" class="btn btn-primary float-right">
	                    <a href="/CatreaWeb/logout">Logout</a></button>
            </div>

        </div>
    </div>
    <footer>
    Materia: Taller de Desarrollo e Implementación | Prof. Lic. Mariano Trigila | Alumnos: Ucedo-Rivera-Paez
    </footer>
</body>
</html>