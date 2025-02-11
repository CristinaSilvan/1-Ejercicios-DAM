document.addEventListener("DOMContentLoaded", function(){
    const contenido = document.getElementById("principal");
    const botonSi = document.getElementById("si");
    const botonNo = document.getElementById("no");

    function borrar(){
        while (contenido.firstChild) {
            contenido.removeChild(contenido.firstChild);
        }
    }

    botonSi.addEventListener("click", function(){
        borrar();

        const eligeDestino = document.createElement("p");
        eligeDestino.textContent = "Elige un destino"
        contenido.appendChild(eligeDestino);

        const franciaBoton = document.createElement("button");
        franciaBoton.textContent = "Francia";
        contenido.appendChild(franciaBoton);

        const espanaBoton = document.createElement("button");
        espanaBoton.textContent = "España";
        contenido.appendChild(espanaBoton);

        const portugalBoton = document.createElement("button");
        portugalBoton.textContent = "Portugal";
        contenido.appendChild(portugalBoton);

        franciaBoton.addEventListener("click", function(){
            mostrarDestino("francia");
        });

        espanaBoton.addEventListener("click", function(){
            mostrarDestino("españa");
        });

        portugalBoton.addEventListener("click", function(){
            mostrarDestino("portugal");
        });

    });

    botonNo.addEventListener("click", function(){
        borrar();

        const mensaje = document.createElement("p");
        mensaje.textContent = "Tú te lo pierdes!!!";
        contenido.appendChild(mensaje);

        const imagenBurlona = document.createElement("img");
        imagenBurlona.src = "./img/no.png"
        imagenBurlona.alt = "Imagen de un señor sacando la lengua en forma de burla";
        contenido.appendChild(imagenBurlona);
    });

    function mostrarDestino(destino){
        borrar();

        let contenidoDestino;
        if(destino == "francia"){
            contenidoDestino = crearContenidoDestino("Bienvenido a Francia", "Francia", "./img/francia1.png", "./img/francia2.png", "./img/francia3.png");
        } else if (destino === "españa") {
            contenidoDestino = crearContenidoDestino("Bienvenido a España", "España", "./img/espana1.png", "./img/espana2.png", "./img/espana3.png");
        } else if (destino === "portugal") {
            contenidoDestino = crearContenidoDestino("Bienvenido a Portugal", "Portugal", "./img/portugal1.png", "./img/portugal2.png", "./img/portugal3.png");
        }

        contenido.appendChild(contenidoDestino);
    }

    function crearContenidoDestino(titulo, nombreDestino, img1, img2, img3){
        const destinoDiv = document.createElement("div");

        document.title = titulo;
        const bienvenido = document.createElement("h2");
        bienvenido.textContent = titulo;
        destinoDiv.appendChild(bienvenido);

        const parrafo = document.createElement("p");
        parrafo.textContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et augue in libero varius venenatis non a ligula.";
        destinoDiv.appendChild(parrafo);

        const imagenPais1 = document.createElement("img");
        imagenPais1.src = img1;
        imagenPais1.alt = "Imagen de " + nombreDestino;
        destinoDiv.appendChild(imagenPais1);

        const imagenPais2 = document.createElement("img");
        imagenPais2.src = img2;
        imagenPais2.alt = "Imagen de " + nombreDestino;
        destinoDiv.appendChild(imagenPais2);

        const imagenPais3 = document.createElement("img");
        imagenPais3.src = img3;
        imagenPais3.alt = "Imagen de " + nombreDestino;
        destinoDiv.appendChild(imagenPais3);

        return destinoDiv;
    }
});