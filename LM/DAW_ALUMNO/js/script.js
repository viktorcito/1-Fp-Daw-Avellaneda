let baseDeDatos = [
    {
        id: 1,
        nombre: "Bulbasaur",
        imagen: "imgs/bulbasaur.png",
        tipos: ["Grass", "Poison"],
        estadisticas: [4,4,4,4,4],
        info: "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo"
    },
    {
        id: 7,
        nombre: "Squirtle",
        imagen: "imgs/squirtle.png",
        tipos: ["Water"],
        estadisticas: [4,3,4,3,4],
        info: "Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble"
    },
    {
        id: 77,
        nombre: "Geodude",
        imagen: "imgs/geodude.png",
        tipos: ["Rock", "Ground"],
        estadisticas: [2,4,3,4,3],
        info: "Se suele encontrar en senderos de montaña y sitios parecidos. Conviene andar con cuidado para no pisarlo sin querer y provocar su enfado"
    },
    {
        id: 10,
        nombre: "Caterpie",
        imagen: "imgs/caterpie.png",
        tipos: ["Bug"],
        estadisticas: [3,3,4,1,2],
        info: "Para protegerse, despide un hedor horrible por las antenas con el que repele a sus enemigos"
    }
];

// TIPOS DE POKEMON ASOCIADO CON SU COLOR
const tiposPokemon = [
    {
        tipo: "Grass",
        color: "lightgreen"
    },
    {
        tipo: "Poison",
        color: "lightsalmon"
    },
    {   tipo: "Water",
        color: "lightblue"
    },
    {
        tipo: "Rock",
        color: "lightgrey"
    },
    {
        tipo: "Ground",
        color: "lightcyan"
    },
    {
        tipo: "Bug",
        color: "lightseagreen"
    },
    {
        tipo: "Electric",
        color: "yellow"
    }    
];

// PENDIENTE COMPLETAR
const DOMItems = document.querySelector("main div");


// Objetos Ivysaur
const Ivysaur = {
    id: 2,
    nombre: "Ivysaur",
    imagen: "imgs/ivysaur.png",
    tipos: ["Grass","Poison"],
    estadisticas: [2,2,3,1,2],
    info: "Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras"
};



function renderizar() {

    // Limpiar el contenido actual
    DOMItems.innerHTML = "";

    for (let pokemon of baseDeDatos) {
        
        
        let nodoDiv = document.createElement('div');

        
        // para la imagen, el nombre y el tipo

               
        let nodoImg = document.createElement('img');
        nodoImg.src = pokemon.imagen;
        nodoDiv.append(nodoImg); 

        let nodoNombre = document.createElement("h3");
        nodoNombre.textContent = pokemon.nombre;
        nodoDiv.append(nodoNombre);
        
        let nodoTipo = document.createElement("ul");
        nodoTipo.classList.add("lista");
        nodoDiv.append(nodoTipo);
        
        
        for (const tipo of pokemon.tipos) {
            let nodoLi = document.createElement("li");
            // Agregar el color de fondo según el tipo de pokemon
            let tipoColor = tiposPokemon.find(t => t.tipo === tipo).color;
            nodoLi.style.background = tipoColor;
            nodoLi.textContent = tipo;
            nodoTipo.append(nodoLi);
        }


        nodoImg.addEventListener('mouseover', function() {
            // Código para mostrar la información...
            document.getElementById('nombrePokemon').textContent = pokemon.nombre;
            document.getElementById('infoPokemon').textContent = pokemon.info;
            document.querySelector('#secPokemon .media').textContent = calcularNotaMedia(pokemon.estadisticas);
            document.querySelector('aside section').style.display = "block"; // muestra la sección
        });
        
        nodoImg.addEventListener('mouseout', function() {
            // Código para ocultar la información...
            document.querySelector('aside section').style.display = "none"; // oculta la sección
            document.getElementById('nombrePokemon').textContent = "Informacion del Pokemon";
        });
        
        

        DOMItems.append(nodoDiv);

        
    }

    
}

// PENDIENTE DE COMPLETAR CON TU CÓDIGO Y FUNCIONES


//Por cada boton añadire un eventlistener

document.getElementById('addPokemon').addEventListener('click', function() {
    let existe = false;

    for (const poke of baseDeDatos) {
        
        if (poke === Ivysaur) {
            existe = true; 

            
           
           
        }

    }
    if (existe == false) {
        baseDeDatos.push(Ivysaur);
        
    }else{
        alert("ya existe");
    }

        
    
    renderizar();
});

/**
 * document.getElementById('addPokemon').addEventListener('click', function() {
    if (!baseDeDatos.some(poke => poke.nombre === Ivysaur.nombre)) {
        baseDeDatos.push(Ivysaur);
    } else {
        alert("ya existe");
    }
    renderizar();
});

 * 
 */


    //esto lo utilizate para las medias de los pokemon
function calcularNotaMedia(estadisticas) {
    let suma = estadisticas.reduce((a, b) => a + b, 0);
    return (suma / estadisticas.length).toFixed(2);
}
/**
 * function calcularNotaMedia(estadisticas) {
    let suma = 0;
    for (let i = 0; i < estadisticas.length; i++) {
        suma += estadisticas[i];
    }
    return (suma / estadisticas.length).toFixed(2);
}

 */

// ---------------------------------------
// INICIO
// Se pinta la tabla cuando se carga la página
window.onload = renderizar;




