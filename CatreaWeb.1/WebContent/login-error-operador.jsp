<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="./CSS/estilos.css" />
    <title>Error en el login Operador</title>
</head>
<body>
    <header>      
        <div id="titulo">   
        <p>CATREA - Centro de Atención Telefónica para el Reclutamiento en el Ejército Argentino</p>                  
        <p>0800-555-555</p>
        </div> 
    </header>
<center>
    <section>
        <form action="login-error-operador.html" method="post"></form>
        <div class="contenedor-login-error-operador">
            <a href="login.html">
                <p>No se ha podido ingresar: Usuario erróneo</p>
            </a>
            <div>
                <button type="submit" class="btn btn-primary float-right"><a href="login.html">
                    Volver</a></button>
            </div>
        </div>
        </form>
    </section>
    
    </center>
    <footer>
        Materia: Taller de Desarrollo e Implementación | Prof. Lic. Mariano Trigila | Alumnos: Ucedo-Rivera-Paez
    </footer>
</body>
</html>