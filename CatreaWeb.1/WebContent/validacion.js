// Devuelve verdadero si el string esta vacio
function estaVacio(str) {
    return str.indexOf(' ') >= 0 || str.length == 0;
}

function esNumeroValido(num) {
    // Si es un numero y no tiene decimales
    numTrim = num.trim();
    if(!isNaN(numTrim) && !numTrim.match(/^\d+\.\d+$/)) {
        return true;
    }

    return false;
}
    function esDNIValido(dni) {
        if(!estaVacio(dni) && esNumeroValido(dni)) {
        return true;
    } else {
            return false;
        }
    }
        
    // Chequea si un password valido
    function esPasswordValido(pass) {
        if(!estaVacio(pass)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Chequea que los campos del login sean validos

function validarCamposLogin(e) {
    e.preventDefault();
    dni = document.getElementById("dni").value;
    password = document.getElementById("password").value;

    if(esDNIValido(dni) && esPasswordValido(password)) {
        window.location.replace("/CatreaWeb/login");
    } else {
        console.log("Campos invalidos");
    }
}     