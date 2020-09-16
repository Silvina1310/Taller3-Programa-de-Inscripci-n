<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	<title>Cambiar Contraseña</title>
</head>

<body>
	<header>
		<div id="titulo">
			<p>CATREA - Centro de Atención Telefónica para el Reclutamiento	en el Ejército Argentino</p>
			<p>0800-555-5555</p>
		</div>
	</header>

	<div class="containerCamContr">
		<p class="encabezado">Cambiar contraseña</p>
		
		<form action="/CatreaWeb/cambiarContrasenia" method="post" id="cambiarContraseñaForm" class="contenedor" onsubmit="validarCamposCambiarContraseña(event)">
			
			<div class="contenedor-contrasenia2">
				<label for="dni">Ingrese su nuevo password</label>
				
				<div class="contenedor-input-pass">
					<input class="form-input-pass" id="pass" name="pass" type="text" />
				</div>
				
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary float-left">Enviar</button>
				</div>
				
				<div>
					<button type="submit" class="btn btn-primary float-right">
						<a href="login.jsp"> Volver</a>
					</button>
				
				</div>
			</div>
		</form>
	</div>	
		
	<footer> 
		Materia: Taller de Desarrollo e Implementación |Prof. Lic. Mariano Trigila | Alumnos: Ucedo-Rivera-Paez 
	</footer>

		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>	
	<script type="text/javascript" src="./script/validacion.js"></script>

</body>
</html>