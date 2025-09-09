let baseDeDatos = [
    {
        id: 1,
        nombre: "Bulbasaur",
        imagen: "imgs/bulbasaur.png",
        tipos: ["Grass", "Poison"],
        info: "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo"
    },
    {
        id: 7,
        nombre: "Squirtle",
        imagen: "imgs/squirtle.png",
        tipos: ["Water"],
        info: "Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble"
    },
    {
        id: 77,
        nombre: "Geodude",
        imagen: "imgs/geodude.png",
        tipos: ["Rock", "Ground"],
        info: "Se suele encontrar en senderos de montaña y sitios parecidos. Conviene andar con cuidado para no pisarlo sin querer y provocar su enfado"
    },
    {
        id: 10,
        nombre: "Caterpie",
        imagen: "imgs/caterpie.png",
        tipos: ["Bug"],
        info: "Para protegerse, despide un hedor horrible por las antenas con el que repele a sus enemigos"
    },
    {
        id: 2,
        nombre: "Ivysaur",
        imagen: "imgs/ivysaur.png",
        tipos: ["Grass","Poison"],
        info: "Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras"
    },
];

// PENDIENTE COMPLETAR
const DOMTableBody = document.querySelector("tbody");

// Objeto Pikachu
const pikachu = {
    id: 11,
    nombre: "Pikachu",
    imagen: "imgs/pikachu.png",
    tipos: ["Electric"],
    info: "Cuando se enfada, este Pokémon descarga la energía que almacena en el interior de las bolsas de las mejillas"
};

// FUNCIÓN DONDE SE CREAN DINÁMICAMENTE LOS ELEMENTOS HTML ACORDE A ESPECIFICACIONES
function renderizar() {
    // Limpiar el contenido actual
    DOMTableBody.innerHTML = "";

    // Para cada Pokemon en la base de datos
    for (let pokemon of baseDeDatos) {
        let row = document.createElement("tr");

        // Crea y rellena las celdas para la imagen, el nombre y el tipo
        let imgCell = document.createElement("td");
        let img = document.createElement("img");
        img.src = pokemon.imagen;
        img.onmouseover = function() {
            document.getElementById('infoPokemon').innerText = pokemon.info;
        };
        img.onmouseout = function() {
            document.getElementById('infoPokemon').innerText = "?????????????????????";
        };
        imgCell.appendChild(img);

        let nombreCell = document.createElement("td");
        nombreCell.innerText = pokemon.nombre;

        let tipoCell = document.createElement("td");
        tipoCell.innerText = pokemon.tipos.join(', ');

        // Agrega las celdas al row
        row.appendChild(imgCell);
        row.appendChild(nombreCell);
        row.appendChild(tipoCell);

        // Agrega el row al cuerpo de la tabla
        DOMTableBody.appendChild(row);
    

    }
}

// PENDIENTE DE COMPLETAR CON TU CÓDIGO Y FUNCIONES




// ---------------------------------------
// INICIO
// Se pinta la tabla cuando se carga la página
window.onload = renderizar;

