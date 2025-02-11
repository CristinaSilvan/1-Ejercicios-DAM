document.addEventListener("DOMContentLoaded", function(){
    const contenedorPadre = document.getElementById("contenedor");
    const contenedorImagen = document.createElement("div");
    contenedorImagen.id = "contenedorImagen";
    const imagen = document.createElement("img");

    const boton1 = document.getElementById("boton1");
    const boton2 = document.getElementById("boton2");
    const boton3 = document.getElementById("boton3");
    const boton4 = document.getElementById("boton4");
    const boton5 = document.getElementById("boton5");

    let numero;
    boton1.addEventListener("click", function(){
        crearImagen(1);
    });

    boton2.addEventListener("click", function(){
        crearImagen(2);
    });

    boton3.addEventListener("click", function(){
        crearImagen(3);
    });

    boton4.addEventListener("click", function(){
        crearImagen(4);
    });

    boton5.addEventListener("click", function(){
        crearImagen(5);
    });

    function crearImagen(numero){
        const url = "./img/" + numero + ".png";
        imagen.src = url;

        contenedorImagen.appendChild(imagen);
        contenedorPadre.appendChild(contenedorImagen);
    }
});