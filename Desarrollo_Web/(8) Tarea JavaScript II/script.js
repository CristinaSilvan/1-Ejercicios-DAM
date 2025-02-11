document.addEventListener("DOMContentLoaded", function(){
    input1 = document.getElementById("ejercicio1");
    input2 = document.getElementById("ejercicio2");
    boton1 = document.getElementById("boton1");
    boton2 = document.getElementById("boton2");
    let numero1, numero2, numCifras, resto, auxiliar;

    boton1.addEventListener("click", function() {
        try{
            numero1 = parseInt(input1.value);
        }
        catch{
            console.log("Error");
            alert("ERROR: Introduzca un dato válido");
        }

        if(input1.value != ""){
            if(!(numero1 % 2)){
                console.log("El número es par");
                alert("El número es par");
            }
            else{
                console.log("El número es impar");
                alert("El número es impar");
            }
        }
        else{
            console.log("Error");
            alert("ERROR: El Input está vacío");
        }

        input1.value = "";
    });

    boton2.addEventListener("click", function() {
        numCifras = 0;
        auxiliar = 0;

        try{
            numero2 = parseInt(input2.value);
        }
        catch{
            console.log("Error");
            alert("ERROR: Introduzca un dato válido");
        }
        if(input2.value != ""){
            if(numero2 >= 0){
                auxiliar = numero2;
                while (auxiliar >= 1) {
                    auxiliar = parseInt(auxiliar / 10);
                    numCifras++;
                }

                if (numCifras == 2) {
                    if(!(numero2 % 2)){
                        console.log("El número es par");
                        alert("El número tiene 2 cifras y es par");
                    }
                    else{
                        console.log("El número es impar");
                        alert("El número tiene 2 cifras y es impar");
                    }
                } else if (numCifras == 3) {
                    resto = numero2/2;
                    console.log("El número tiene tres cifras");
                    alert("El número tiene 3 cifras\nEl resto de dividir " + numero2 + " entre 2 es " + resto);
                }
                else{
                    console.log("No cumple ninguna condición");
                    alert("ERROR: No cumple ninguna condición");
                }
            }
            else{
                console.log("No cumple ninguna condición");
                alert("ERROR: No cumple ninguna condición");
            }
        }
        else{
            console.log("Error");
            alert("ERROR: El Input está vacío");
        }

        input2.value = "";
    });
});