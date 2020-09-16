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
    <title>Menu administrador</title>
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
        <p class="encabezado">Administrador : Menú de Opciones</p>
        
        <div class="contenedor-menu-opcion">
            <div class="contenedor-button">
                <div class="primeraopcion">  
                <button type="button" class="unoAdmin"><a href="altaOperadores.jsp">
                            Alta operadores</a></button>
                </div>

                <div class="segundoopcion">
                    <button type="button" class="dosAdmin"><a href="consulta_preinscripcion.jsp">
                            Consultar Preinscripciones</a></button>
                </div>
                
                <div class="terceraopcion">
                    <button type="button" class="tresAdmin"><a href="consulta-operadores.jsp">
                            Consultar Operadores</a></button>
                </div>
                
                 <div class="cuartaopcion">
                    <button type="button" class="cuatroAdmin"><a href="cambiar-contrasenia.jsp">
                            Cambiar Contraseña</a></button>
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