document.addEventListener("DOMContentLoaded", function(){
    const parrafo1 = document.getElementById("parrafo1");
    const parrafo2 = document.getElementById("parrafo2");
    const parrafo3 = document.getElementById("parrafo3");

    let contador = 1;
    
    while(contador <= 100){
        parrafo1.textContent += contador + " ";
        if(contador % 10 == 0){
            parrafo1.textContent += "\n";
        }
        contador++;
    }
    
    contador = 1;
    do{
        parrafo2.textContent += contador + " ";
        if(contador % 10 == 0){
            parrafo2.textContent += "\n";
        }
        contador++;
    }while(contador <= 100);

    for(let i = 1; i <= 100; i++){
        parrafo3.textContent += i + " ";
        if(i % 10 == 0){
            parrafo3.textContent += "\n";
        }
    }
});