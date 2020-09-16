
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>Aspirante ya existente</title>
</head>
<body>
    <header>      
        <div id="titulo">   
        <p>CATREA - Centro de Atención Telefónica para el Reclutamiento en el Ejército Argentino</p>                  
        <p>0800-555-555</p>
        </div> 
    </header>

	<div class="container">
	    
        <form action="conexion-bd-error.jsp" method="post"></form>
        <div class="contenedor-conexion-bd-error-">
            <a href="login.jsp">
                <p>Un aspirante con el DNI ingresado ya existe en la Base de Datos</p>
            </a>
            <div>
                <button type="submit" class="btn btn-primary float-right"><a href="formulario.jsp">
                    Volver</a></button>
            </div>
        </div>
        </form>
	   
    </div>
    
    <footer>
        Materia: Taller de Desarrollo e Implementaciï¿½n | Prof. Lic. Mariano Trigila | Alumnos: Ucedo-Rivera-Paez
    </footer>
</body>
</html>