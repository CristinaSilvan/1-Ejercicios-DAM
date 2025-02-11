/*
Se pide por pantalla mediante una ventana de tipo prompt, el importe en Euros. Se imprime
en el documento la equivalencia en libras.
1euro---0,87libras
*/

document.addEventListener("DOMContentLoaded", function(){
    const tasaCambio = 0.87;
    let euros, libras;

    eurosInput = document.getElementById("euros");
    librasInput = document.getElementById("libras");
    boton = document.getElementById("convertir");

    eurosInput.addEventListener("focus", function() {
        librasInput.value = "0.00";
    });

    librasInput.addEventListener("focus", function() {
        eurosInput.value = "0.00";
    });

    boton.addEventListener("click", function() {
        euros = parseFloat(eurosInput.value);
        libras = parseFloat(librasInput.value);

        if (euros == 0.00){
            eurosInput.value = (libras / tasaCambio).toFixed(2);
        }
        else if (libras == 0.00){
            librasInput.value = (euros * tasaCambio).toFixed(2);
        }
        else{
            console.log("ERROR");
            alert("Introduce un valor numérico válido");
        }
    });
});