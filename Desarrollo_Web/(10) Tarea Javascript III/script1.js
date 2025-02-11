document.addEventListener("DOMContentLoaded", function(){
    const inputNumero = document.getElementById("numero");
    const inputNombre = document.getElementById("nombre");
    const imprimir = document.getElementById("imprimir");


    imprimir.addEventListener("click", function(){

        if(inputNombre.value && inputNumero.value){
            console.log("Se han impreso los datos");
            alert("Nombre: " + inputNombre.value + "\nNúmero: " + parseInt(inputNumero.value));
        }
        else{
            console.log("Falta un dato por introducir");
            alert("Falta un dato por introducir");
        }

        inputNombre.value = "";
        inputNumero.value = "";
    });
});