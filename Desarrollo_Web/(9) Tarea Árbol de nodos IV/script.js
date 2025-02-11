document.addEventListener("DOMContentLoaded", function(){
    const imagen_principal = document.getElementById("img_principal");
    const imagen1 = document.getElementById("img_1");
    const imagen2 = document.getElementById("img_2");
    const imagen3 = document.getElementById("img_3");
    const imagen4 = document.getElementById("img_4");
    const imagen5 = document.getElementById("img_5");

    imagen1.addEventListener("click", function(){
        imagen_principal.setAttribute("src", "./img/1.png");
        imagen_principal.setAttribute("alt", "Caravana en la nieve");
    });

    imagen2.addEventListener("click", function(){
        imagen_principal.setAttribute("src", "./img/2.png");
        imagen_principal.setAttribute("alt", "Campistas en la nieve");
    });

    imagen3.addEventListener("click", function(){
        imagen_principal.setAttribute("src", "./img/3.png");
        imagen_principal.setAttribute("alt", "Hoguera junto a las caravanas");
    });

    imagen4.addEventListener("click", function(){
        imagen_principal.setAttribute("src", "./img/4.png");
        imagen_principal.setAttribute("alt", "Caravana con las ventanas congeladas");
    });

    imagen5.addEventListener("click", function(){
        imagen_principal.setAttribute("src", "./img/5.png");
        imagen_principal.setAttribute("alt", "Dueño jugando con su perro en la nieve");
    });
});