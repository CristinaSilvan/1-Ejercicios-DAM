document.addEventListener("DOMContentLoaded", function(){
    const contenedorPadre = document.getElementById("contenedor");
    const inputCeldas = document.getElementById("celdas");
    const inputFilas = document.getElementById("filas");
    const botonCrearTabla = document.getElementById("crear_tabla");

    botonCrearTabla.addEventListener("click", function(){
        //Borrar tablas previas
        borrar();

        // TABLA WHILE
        const h3_while = document.createElement("h3");
        h3_while.textContent = "BLOQUE CON WHILE";

        const contenedor_tabla2 = document.createElement("div");
        contenedor_tabla2.id = "contenedor_tabla2";

        const tabla2 = document.createElement("table");
        tabla2.id = "tabla2";
        

        let contador_i = 0;
        let contador_j = 0;
        while(contador_i < parseInt(inputFilas.value)){
            const fila = document.createElement("tr");
            while(contador_j < parseInt(inputCeldas.value)){
                const celda = document.createElement("td");
                celda.textContent = contador_j + 1;
                contador_j++;

                fila.appendChild(celda);
            }

            tabla2.appendChild(fila);
            contador_j = 0;
            contador_i++;
        }

        contenedor_tabla2.appendChild(h3_while);
        contenedor_tabla2.appendChild(tabla2);
        contenedorPadre.appendChild(contenedor_tabla2);

        // TABLA DO_WHILE
        const h3_doWhile = document.createElement("h3");
        h3_doWhile.textContent = "BLOQUE CON DO-WHILE";

        const contenedor_tabla3 = document.createElement("div");
        contenedor_tabla3.id = "contenedor_tabla3";

        const tabla3 = document.createElement("table");
        tabla3.id = "tabla3";

        contador_i = 0;
        contador_j = 0;
        do{
            const fila = document.createElement("tr");
            do{
                const celda = document.createElement("td");
                celda.textContent = contador_j + 1;
                contador_j++;
                fila.appendChild(celda);
            }while(contador_j < parseInt(inputCeldas.value));

            tabla3.appendChild(fila);
            contador_j = 0;
            contador_i++;
        }while(contador_i < parseInt(inputFilas.value));

        contenedor_tabla3.appendChild(h3_doWhile);
        contenedor_tabla3.appendChild(tabla3);
        contenedorPadre.appendChild(contenedor_tabla3);

        // TABLA FOR
        const h3_for = document.createElement("h3");
        h3_for.textContent = "BLOQUE CON FOR";

        const contenedor_tabla1 = document.createElement("div");
        contenedor_tabla1.id = "contenedor_tabla1";

        const tabla1 = document.createElement("table");
        tabla1.id = "tabla1";

        for(let i = 0; i < parseInt(inputFilas.value); i++){
            const fila = document.createElement("tr");

            for(let j = 0; j < parseInt(inputCeldas.value); j++){
                const celda = document.createElement("td");
                celda.textContent = j + 1;

                fila.appendChild(celda);
            }
            tabla1.appendChild(fila);
        }

        contenedor_tabla1.appendChild(h3_for);
        contenedor_tabla1.appendChild(tabla1);
        contenedorPadre.appendChild(contenedor_tabla1);
    });

    function borrar(){
        if(document.getElementById("contenedor_tabla1") && document.getElementById("contenedor_tabla2") && document.getElementById("contenedor_tabla3")){
            contenedorPadre.removeChild(document.getElementById("contenedor_tabla1"));
            contenedorPadre.removeChild(document.getElementById("contenedor_tabla2"));
            contenedorPadre.removeChild(document.getElementById("contenedor_tabla3"));
        }
    }
});