document.addEventListener("DOMContentLoaded", function(){
    //Sección del header
    const header_seccion = document.createElement("header");
    const header_container = document.createElement("div");
    header_container.setAttribute("id", "contenedor_header");

    const header_logo = document.createElement("img");
    header_logo.setAttribute("src", "./img/logo-azul-marino-viajes.jpg");
    header_logo.setAttribute("alt", "Logo Azul Marino Viajes");

    const header_nav = document.createElement("nav");
    const nav_ul = document.createElement("ul");
    const  menu = ["Inicio", "Nosotros", "Servicios", "Contacto"];

    for(let i = 0; i < 4; i++){
        let options_li = document.createElement("li");
        let options_a = document.createElement("a");
        
        options_a.textContent = menu[i];
        options_li.appendChild(options_a);
        nav_ul.appendChild(options_li);
    }

    /*
    const li_1 = document.createElement("li");
    const a_1 = document.createElement("a");

    const li_2 = document.createElement("li");
    const a_2 = document.createElement("a");

    const li_3 = document.createElement("li");
    const a_3 = document.createElement("a");

    const li_4 = document.createElement("li");
    const a_4 = document.createElement("a");
        
    a_1.textContent = menu[0];
    a_2.textContent = menu[1];
    a_3.textContent = menu[2];
    a_4.textContent = menu[3];

    li_1.appendChild(a_1);
    li_2.appendChild(a_2);
    li_3.appendChild(a_3);
    li_4.appendChild(a_4);

    nav_ul.appendChild(li_1);
    nav_ul.appendChild(li_2);
    nav_ul.appendChild(li_3);
    nav_ul.appendChild(li_4);
    */

    header_nav.appendChild(nav_ul);
    header_container.appendChild(header_logo);
    header_container.appendChild(header_nav);
    header_seccion.appendChild(header_container);
    document.body.appendChild(header_seccion);

    //Sección principal
    const body_container = document.createElement("div");
    body_container.setAttribute("id", "contenedor_body");

    const section_1  = document.createElement("div");
    section_1.setAttribute("id", "seccion1");
    const section_2  = document.createElement("div");
    section_2.setAttribute("id", "seccion2");
    const section_3  = document.createElement("div");
    section_3.setAttribute("id", "seccion3");

        //Sección 1
        const section_1_img_div  = document.createElement("div");
        section_1_img_div.setAttribute("id", "imagen_titular");
        const section_1_p_div  = document.createElement("div");
        section_1_p_div.setAttribute("id", "parrafo_titular");

        const section_1_img = document.createElement("img");
        section_1_img.setAttribute("src", "./img/articulos-808572.jpg");
        section_1_img.setAttribute("alt", "Una foto de la sagrada familia en Berlín");

        const section_1_p = document.createElement("p");
        const section_1_h2 = document.createElement("h2");
        section_1_h2.textContent = "Este es el titular del div de texto";
        section_1_p.textContent = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        const section_1_button = document.createElement("button");
        section_1_button.textContent = "Ver más";
        /* AÑADIR A MIS APUNTES: En los navegadores no se admite que un h2 esté directamente dentro de un p, debe estar
        en un contenedor o fuera de esto, sino da error */

        section_1_img_div.appendChild(section_1_img);
        section_1_p_div.appendChild(section_1_h2);
        section_1_p_div.appendChild(section_1_p);
        section_1_p_div.appendChild(section_1_button);
        section_1.appendChild(section_1_img_div);
        section_1.appendChild(section_1_p_div);

        //Sección 2
        const section_2_h2 = document.createElement("h2");
        section_2_h2.textContent = "Este es el titular de la sección 2";
        const section_2_img = document.createElement("img");
        section_2_img.setAttribute("src", "./img/foto6 (2).jpg");
        section_2_img.setAttribute("alt", "Dos esquimales en lo alto de una montaña");

        section_2.appendChild(section_2_h2);
        section_2.appendChild(section_2_img);
        body_container.appendChild(section_2);
        const src_img = ["./img/Viajes_Donde_Viajes_3.jpg", "./img/kayak-valencia.jpeg", "./img/600x400_viajes-lujo-FOTO-1-White-Dessert-experiencia-Polo-Norte-en-jet-privaso.jpg"];
        const alt_img = ["Una foto de una baía con aguas cristalinas", "Una foto de unas personas remando en kayaks en Valencia", "Una foto de un avión aterrizando en el Polo Norte"];

        //Sección 3
        for(let i = 0; i < 3; i++){
            const contenedores = document.createElement("div");
            contenedores.className = "contenedores";

            const contenedores_img = document.createElement("img");
            contenedores_img.setAttribute("src", src_img[i]);
            contenedores_img.setAttribute("alt", alt_img[i]);

            const contenedores_p = document.createElement("p");
            contenedores_p.textContent = "Lorem ipsum dolor sit amet consectetur adipisicing elit.";

            const contenedores_button = document.createElement("button");
            contenedores_button.textContent = "Comprar";

            contenedores.appendChild(contenedores_img);
            contenedores.appendChild(contenedores_p);
            contenedores.appendChild(contenedores_button);

            section_3.appendChild(contenedores);
        }

        
    body_container.appendChild(section_1);
    body_container.appendChild(section_2);
    body_container.appendChild(section_3);
    document.body.appendChild(body_container);
    
    //Imprime un mensaje cada vez que se pula un enlace o un botón
    document.querySelectorAll('a, button').forEach(function(elemento) {
        elemento.addEventListener('click', function(evento) {
            console.log("Página todavía en desarrollo, esta función no está implementada");
            alert("Página todavía en desarrollo, esta función no está implementada");
        });
    });

});