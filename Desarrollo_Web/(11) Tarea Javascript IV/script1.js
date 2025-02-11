document.addEventListener("DOMContentLoaded", function(){
    const inputCeldas = document.getElementById("celdas");
    const botonCrear = document.getElementById("crearArray");
    const contenedorPadre = document.getElementById("contenedor");

    botonCrear.addEventListener("click", function(){
        if((parseInt(inputCeldas.value) > 0) && esEntero()){
            //Borrar array previo
            borrar();

            let arrayCeldas = new Array(parseInt(inputCeldas.value));
            const contenedorArray = document.createElement("div");
            contenedorArray.id = "contenedorArray";

            //Bucle while
            const h3_while = document.createElement("h3");
            h3_while.textContent = "BUCLE WHILE: ";
            contenedorArray.appendChild(h3_while);
            const tablaArray1 = document.createElement("table");
            const fila1 = document.createElement("tr");

            let contador = 0;
            while(contador < parseInt(inputCeldas.value)){
                arrayCeldas[contador] = contador;
                const celda1 = document.createElement("td");
                celda1.textContent = arrayCeldas[contador];
                fila1.appendChild(celda1);
                contador++;
            }
            tablaArray1.appendChild(fila1);
            contenedorArray.appendChild(tablaArray1);

            //Bucle For
            const h3_for = document.createElement("h3");
            h3_for.textContent = "BUCLE FOR:    "
            contenedorArray.appendChild(h3_for);
            const tablaArray2 = document.createElement("table");
            const fila2 = document.createElement("tr");

            for(let i = 0; i < arrayCeldas.length; i++){
                const celda2 = document.createElement("td");
                celda2.textContent = arrayCeldas[arrayCeldas[i]];
                fila2.appendChild(celda2);
            }
            tablaArray2.appendChild(fila2);
            contenedorArray.appendChild(tablaArray2);

            contenedorPadre.appendChild(contenedorArray);
            inputCeldas.value = "";
        }
        else{
            console.log("ERROR: No se puede introducir un número decimal o negativo");
            alert("ERROR: No se puede introducir un número decimal o negativo");
        }
    });

    function esEntero(){
        const parteEntera = parseInt(inputCeldas.value) - (parseInt(inputCeldas.value) % 1);
        const parteDecimal = parseInt(inputCeldas.value) - parteEntera;

        if(parteDecimal == 0){
            return true;
        }
        else{
            return false;
        }
    }

    function borrar(){
        if(document.getElementById("contenedorArray")){
            contenedorPadre.removeChild(document.getElementById("contenedorArray"));
        }
    }
});