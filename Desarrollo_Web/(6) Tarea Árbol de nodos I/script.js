document.addEventListener("DOMContentLoaded", function(){
    const selector1 = document.getElementById("plato_principal");
    const selector2 = document.getElementById("plato_segundo");
    const selector3 = document.getElementById("plato_tercero");

    const imagen1 = document.getElementById("imagen1");
    const imagen2 = document.getElementById("imagen2");
    const imagen3 = document.getElementById("imagen3");

    const descuento = document.getElementById("descuento");
    const boton = document.getElementById("a_comer");

    let cuenta = 0;
    let resultado = "";

    selector1.addEventListener("change", function(){
        if(selector1.value == "opcion1"){
            imagen1.src = "./img/Lentejas_con_chorizo.png";
            imagen1.alt = "Imagen de Lentejas con chorizo";
        }
        else if(selector1.value == "opcion2"){
            imagen1.src = "./img/Crema_calabaza.png";
            imagen1.alt = "Imagen de Crema de calabaza";
        }
    });

    selector2.addEventListener("change", function(){
        if(selector2.value == "opcion1"){
            imagen2.src = "./img/Escalope_pollo.png";
            imagen2.alt = "Imagen de Escalope con pollo";
        }
        else if(selector2.value == "opcion2"){
            imagen2.src = "./img/Lubina_horno.png";
            imagen2.alt = "Imagen de Lubina al horno";
        }
    });

    selector3.addEventListener("change", function(){
        if(selector3.value == "opcion1"){
            imagen3.src = "./img/Flan_huevo.png";
            imagen3.alt = "Imagen de Flan de huevo";
        }
        else if(selector3.value == "opcion2"){
            imagen3.src = "./img/Arroz_leche.png";
            imagen3.alt = "Imagen de Arroz con leche";
        }
    });

    boton.addEventListener("click", function(){
        calculoCuenta();

        console.log("Se ha emitido la cuenta del pedido");
        alert(resultado);

        reiniciar();
    });

    function reiniciar(){
        cuenta = 0;
        
        selector1.value = "";
        imagen1.src = "./img/1.png";
        imagen1.alt = "Imagen predeterminada";
        
        selector2.value = "";
        imagen2.src = "./img/1.png";
        imagen2.alt = "Imagen predeterminada";

        selector3.value = "";
        imagen3.src = "./img/1.png";
        imagen3.alt = "Imagen predeterminada";

        resultado = "";
        descuento.checked = false;
    }

    function calculoCuenta (){
        switch (selector1.value){
            case "opcion1":
                cuenta = cuenta + 3;
                break;
            case "opcion2":
                cuenta = cuenta + 2;
                break;
            default:
                resultado = "No se ha completado el pedido";
                return;
        }

        switch (selector2.value){
            case "opcion1":
                cuenta = cuenta + 4;
                break;
            case "opcion2":
                cuenta = cuenta + 5;
                break;
            default:
                resultado = "No se ha completado el pedido";
                return;
        }

        switch (selector3.value){
            case "opcion1":
                cuenta = cuenta + 1;
                break;
            case "opcion2":
                cuenta = cuenta + 2;
                break;
            default:
                resultado = "No se ha completado el pedido";
                return;
        }

        if(descuento.checked){
            cuenta = cuenta - (cuenta * 0.10);
            resultado = resultado + "(Descuento 10%) ";
        }
        resultado = resultado + "La cuenta total es: " +  cuenta + "€";
    }
});