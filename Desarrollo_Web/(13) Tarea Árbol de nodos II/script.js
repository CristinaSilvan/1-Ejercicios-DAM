document.addEventListener("DOMContentLoaded", function(){
    const contenedor_titulo = document.getElementById("contenedor_titulo");

    const elegir_pais = document.getElementById("elegir_pais");
    const imagen = document.getElementById("imagen");

    const titulo_segundo = document.createElement("h3");
    let opcion;

    elegir_pais.addEventListener("change", function(){
        opcion = elegir_pais.options[elegir_pais.selectedIndex].innerText;
        titulo_segundo.textContent = "Su destino es " + opcion;

        switch (opcion){
            case "Francia":
                imagen.setAttribute("src", "./img/francia.png");
                imagen.setAttribute("alt", "Imagen de Francia");
                break;
            case "Italia":
                imagen.setAttribute("src", "./img/italia.png");
                imagen.setAttribute("alt", "Imagen de Italia");
                break;
            case "Alemania":
                imagen.setAttribute("src", "./img/alemania.png");
                imagen.setAttribute("alt", "Imagen de Alemania");
                break;
            case "Portugal":
                imagen.setAttribute("src", "./img/portugal.png");
                imagen.setAttribute("alt", "Imagen de Portugal");
                break;
            case "España":
                imagen.setAttribute("src", "./img/espana.png");
                imagen.setAttribute("alt", "Imagen de España");
                break;
        }

        contenedor_titulo.appendChild(titulo_segundo);
    });
});