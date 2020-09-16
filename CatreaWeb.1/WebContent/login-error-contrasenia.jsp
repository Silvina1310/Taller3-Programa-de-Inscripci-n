<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="./CSS/estilos.css" />
    <title>Error en el login Contrase�a</title>
</head>
<body>
    <header>      
        <div id="titulo">   
        <p>CATREA - Centro de Atenci�n Telef�nica para el Reclutamiento en el Ej�rcito Argentino</p>                  
        <p>0800-555-555</p>
        </div> 
    </header>
<center>
    <section>
        <form action="login-error-contrasenia.html" method="post"></form>
        <div class="contenedor-login-error-contrasenia">
            <a href="login.html">
                <p>No se ha podido ingresar: Contrase�a err�nea</p>
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
        Materia: Taller de Desarrollo e Implementaci�n | Prof. Lic. Mariano Trigila | Alumnos: Ucedo-Rivera-Paez
    </footer>
</body>
</html>