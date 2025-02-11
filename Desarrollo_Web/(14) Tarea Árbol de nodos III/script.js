document.addEventListener("DOMContentLoaded", function(){
    //Contenedor padre
    const contenedor_padre = document.createElement("div");
    contenedor_padre.id = "contenedor_padre";
    document.body.appendChild(contenedor_padre);

    //Contenedores secundarios
    const contenedor1 = document.createElement("div");
    contenedor1.id = "contenedor1";

    const contenedor2 = document.createElement("div");
    contenedor2.id = "contenedor2";

    const contenedor3 = document.createElement("div");
    contenedor3.id = "contenedor3";

    //Contenedores de imagen y enlace
    const contenedor_imagen1 = document.createElement("div");
    contenedor_imagen1.id = "imagen1";

    const contenedor_imagen2 = document.createElement("div");
    contenedor_imagen2.id = "imagen2";

    const contenedor_imagen3 = document.createElement("div");
    contenedor_imagen3.id = "imagen3";

    const contenedor_enlace1 = document.createElement("div");
    contenedor_enlace1.id = "enlace1";

    const contenedor_enlace2 = document.createElement("div");
    contenedor_enlace2.id = "enlace2";

    const contenedor_enlace3 = document.createElement("div");
    contenedor_enlace3.id = "enlace3";

    //Creación de imágenes
    const imagen1 = document.createElement("img");
    imagen1.setAttribute("src", "./img/1.jpg");
    imagen1.setAttribute("alt", "Imagen de una playa rocosa donde se ve un barco al horizonte");

    const imagen2 = document.createElement("img");
    imagen2.setAttribute("src", "./img/2.jpg");
    imagen2.setAttribute("alt", "Imagen de una playa al lado de una montaña donde vuelan cometas y hacen windsurf");

    const imagen3 = document.createElement("img");
    imagen3.setAttribute("src", "./img/3.jpg");
    imagen3.setAttribute("alt", "Imagen de una playa con un coche antiguo aparcado");

    //Creación de enlaces
    const enlace1 = document.createElement("a");
    enlace1.setAttribute("href", "https://pixabay.com/es/photos/mar-oceano-costa-naturaleza-bote-3352341/");

    const enlace2 = document.createElement("a");
    enlace2.setAttribute("href", "https://pixabay.com/es/photos/costa-mar-playa-viaje-3352363/");

    const enlace3 = document.createElement("a");
    enlace3.setAttribute("href", "https://pixabay.com/es/photos/viaje-exterior-el-verano-veh%C3%ADculo-3351825/");

    const texto1 = document.createTextNode("ENLACE");
    const texto2 = document.createTextNode("ENLACE");
    const texto3 = document.createTextNode("ENLACE");

    //Appends
    enlace1.appendChild(texto1);
    enlace2.appendChild(texto2);
    enlace3.appendChild(texto3);

    contenedor_imagen1.appendChild(imagen1);
    contenedor_enlace1.appendChild(enlace1);
    contenedor1.appendChild(contenedor_imagen1);
    contenedor1.appendChild(contenedor_enlace1);

    contenedor_imagen2.appendChild(imagen2);
    contenedor_enlace2.appendChild(enlace2);
    contenedor2.appendChild(contenedor_imagen2);
    contenedor2.appendChild(contenedor_enlace2);

    contenedor_imagen3.appendChild(imagen3);
    contenedor_enlace3.appendChild(enlace3);
    contenedor3.appendChild(contenedor_imagen3);
    contenedor3.appendChild(contenedor_enlace3);

    contenedor_padre.appendChild(contenedor1);
    contenedor_padre.appendChild(contenedor2);
    contenedor_padre.appendChild(contenedor3);
});