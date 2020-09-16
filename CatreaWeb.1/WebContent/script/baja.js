function darDeBaja(r, idPreinscripcion, idAspirante) {
	let xmlHttp = new XMLHttpRequest();
	let url = "/CatreaWeb/bajaPreinscripcion?idPreinscripcion=" + idPreinscripcion + "&" + "idAspirante=" + idAspirante;
	xmlHttp.open("GET", url, false);
	xmlHttp.send();
	let i = r.parentNode.parentNode.rowIndex;
	document.getElementById("tablaPreinscripciones").deleteRow(i);
}

function darDeBajaOperador(r, dniOperador) {
	let xmlHttp = new XMLHttpRequest();
	let url = "/CatreaWeb/bajaOperadores?dni=" + dniOperador;
	xmlHttp.open("GET", url, false);
	xmlHttp.send();
	let i = r.parentNode.parentNode.rowIndex;
	document.getElementById("tablaOperadores").deleteRow(i);
}