// --------------------------------------------------------
// Clase alumno
/*class alumno {
    constructor(id, nombre, imagen, notas) {
        this.id = id,
        this.nombre = nombre,
        this.imagen = imagen,
        this.notas = notas
    }
}

// Creo 4 alumnos de prueba
// El array de notas va en orden según la tabla html
const alumno1 = new alumno(1, "Tyson Fury", "imgs/avatar1.jpg", [10, 8, 5, 9, 7, 9]);
const alumno2 = new alumno(2, "Katie Taylor", "imgs/avatar2.jpg", [1, 5, 6, 9, 10, 3]);
const alumno3 = new alumno(3, "Carolina Marín", "imgs/avatar3.jpg", [5, 7, 5, 3, 7, 10]);
const alumno4 = new alumno(4, "Sandra Sánchez", "imgs/avatar4.jpg", [7, 8, 5, 2, 7, 9]);

// Base de Datos
const baseDeDatos = [alumno1, alumno2, alumno3, alumno4];*/

// ES EQUIVALENTE USAR CLASS QUE DIRECTAMENTE CREAR LOS OBJETOS EN EL ARRAY
const baseDeDatos =[
    {
        id: 1,
        nombre: 'Tyson Fury',
        imagen: 'imgs/avatar1.jpg',
        notas: [10, 8, 5, 9, 7, 9]
    },
    {
        id: 2,
        nombre: 'Katie Taylor',
        imagen: 'imgs/avatar2.jpg',
        notas: [1, 5, 6, 9, 10, 3]
    },
    {
        id: 3,
        nombre: 'Carolina Marín',
        imagen: 'imgs/avatar3.jpg',
        notas: [5, 7, 5, 3, 7, 10]
    },    
    {
        id: 4,
        nombre: 'Sandra Sánchez',
        imagen: 'imgs/avatar4.jpg',
        notas: [7, 8, 5, 2, 7, 9]
    }    
];


// --------------------------------------------------------------------
// Elemento HTML del DOM donde crear la información html de cada alumno
const DOMTableBody = document.querySelector("tbody"); // Especifica el selector adecuado


function calcularNotaMedia(notas) {
    let suma = notas.reduce((a, b) => a + b, 0);
    return (suma / notas.length).toFixed(2);
}


// Crear la tabla
function renderizarTabla() {
    //Pendiente de completar
    baseDeDatos.forEach(alumno => {
        let row = document.createElement('tr');
        let img = document.createElement('img');
        img.src = alumno.imagen;
        img.style.height = '50px';
        img.style.width = '50px';
        /*Metodo menos predecible
        img.onmouseover = function () {
            this.style.height = `${this.offsetHeight * 2}px`;
            this.style.width = `${this.offsetWidth * 2}px`;
        };
        
        img.onmouseout = function () {
            this.style.height = `${this.offsetHeight / 2}px`;
            this.style.width = `${this.offsetWidth / 2}px`;
        };*/        

        img.onmouseover = function () {
            this.style.height = '100px';
            this.style.width = '100px';
        };

        img.onmouseout = function () {
            this.style.height = '50px';
            this.style.width = '50px';
        };

        let imgCell = document.createElement('td');
        imgCell.appendChild(img);
        row.appendChild(imgCell);

        let nombreCell = document.createElement('td');
        nombreCell.textContent = alumno.nombre;
        row.appendChild(nombreCell);

        alumno.notas.forEach(nota => {
            let notaCell = document.createElement('td');
            notaCell.textContent = nota;
            row.appendChild(notaCell);
            notaCell.classList.add('centrar'); // Añade esta línea después de crear cada 'notaCell'
        });

        let radioButton = document.createElement('input');
        radioButton.type = 'radio';
        radioButton.name = 'alumno';
        radioButton.onclick = function () {
            //FORMA 1 SIN NEGRITA: document.querySelector('aside p span').textContent = alumno.nombre;
            /*FORMA 2 CON INNER:*/ document.querySelector('aside p span').innerHTML = `<strong>${alumno.nombre}</strong>`;
            /*FORMA 3 NEGRITA Y SIN INNER: let nombreStrong = document.createElement('strong');
            nombreStrong.textContent = alumno.nombre;
            document.querySelector('aside p span').textContent = ''; // Limpiar el contenido existente
            document.querySelector('aside p span').appendChild(nombreStrong);*/
            document.querySelector('aside p:nth-child(2) span').textContent = calcularNotaMedia(alumno.notas);
            //document.querySelector('aside p:nth-child(2) span').innerHTML = "<strong>" + calcularNotaMedia(alumno.notas) + "</strong>";
            let notasDivs = document.querySelectorAll('aside div div');
            for(let i=0; i<notasDivs.length; i++){
                notasDivs[i].style.height = `${alumno.notas[i]*30}px`;
                notasDivs[i].textContent = alumno.notas[i];
            }
        };

        let radioCell = document.createElement('td');
        radioCell.appendChild(radioButton);
        radioCell.classList.add('centrar'); // Añade esta línea después de crear cada 'radioCell'

        row.appendChild(radioCell);

        DOMTableBody.appendChild(row);
    });
}

// Añadiendo un nuevo alumno a baseDeDatos
baseDeDatos.push({
    id: 5,
    nombre: 'Nuevo Alumno',
    imagen: 'imgs/avatar1.jpg',
    notas: [6, 7, 8, 9, 10, 5]
});

//EVENTOS---------------------------------
// Selecciona el botón Enviar por su ID
let enviarBtn = document.querySelector("#enviar");

// Agrega un event listener al botón Enviar para abrir una nueva ventana/tab al hacer clic
enviarBtn.addEventListener("click", function(){
    window.open('form.html', '_blank');
});

// ---------------------------------------
// INICIO
// Se pinta la tabla cuando se carga la página
window.onload = renderizarTabla;

// ------------------------------------------
// COMPLETA TU CÓDIGO JS

//BORRAR ULTIMA FILA Y RECUPERAR ULTIMA FILA BORRADA
let deletedRows = [];

document.getElementById('delete-row').addEventListener('click', () => {
    let tableBody = document.querySelector("tbody");
    let rows = tableBody.querySelectorAll('tr');
    if(rows.length > 0) {
        //let firstRow = rows[0]; // Obtiene la primera fila en lugar de la última
        let lastRow = rows[rows.length-1];
        deletedRows.push(lastRow); // acordarse de cambiarlo por firstRow
        tableBody.removeChild(lastRow);
    }
});

document.getElementById('recover-row').addEventListener('click', () => {
    if(deletedRows.length > 0) {
        //let firstDeletedRow = deletedRows.shift(); // Usa shift() para obtener el primer elemento eliminado
        let lastDeletedRow = deletedRows.pop();
        document.querySelector("tbody").appendChild(lastDeletedRow);//usariamos firstDeletedRow
    } else {
        alert("No se ha borrado previamente ninguna fila");
    }
});

/**Explicación:
En este código, deletedRows es una array que funciona como una pila. Cada vez que haces clic en el botón
"Borrar última fila", el último hijo de tbody (es decir, la última fila de la tabla) se elimina y se añade a la pila deletedRows.
Cuando haces clic en el botón "Recuperar última fila borrada", se saca la última fila de la pila deletedRows y se añade de nuevo a tbody, es decir, se recupera en la tabla.

Si tratas de recuperar una fila cuando no se ha borrado ninguna fila (es decir, cuando deletedRows está vacío), 
se muestra una alerta que dice "No se ha borrado previamente ninguna fila". */
/**
 * 
 * const DOMTableBody = document.querySelector("tbody");
 * 
 * 
 * 
 * // FUNCIÓN DONDE SE CREAN DINÁMICAMENTE LOS ELEMENTOS HTML ACORDE A ESPECIFICACIONES
function renderizar() {
    // Limpiar el contenido actual
    DOMTableBody.innerHTML = "";

    // Para cada Pokemon en la base de datos
    for (let pokemon of baseDeDatos) {
        // Crea un nuevo row
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
        //tipoCell.innerText = pokemon.tipos.join(', '); por si no quiero hacer lo de los cuadritos

        let tipoTable = document.createElement("table");
        tipoTable.classList.add("tablaTipos");
        let tipoRow = document.createElement("tr");
        

        for(let tipo of pokemon.tipos){
            let tipoData = document.createElement("td");
            tipoData.textContent = tipo;
            tipoRow.appendChild(tipoData);
        }
        
        tipoTable.appendChild(tipoRow);
        tipoCell.appendChild(tipoTable);
 * 
 * 
 * 
 * 
 *  // Agrega las celdas al row
        row.appendChild(imgCell);
        row.appendChild(nombreCell);
        row.appendChild(tipoCell);

        // Agrega el row al cuerpo de la tabla
        DOMTableBody.appendChild(row);
    }
}
 * 
 *
 * 
 * 
 * // PENDIENTE DE COMPLETAR CON TU CÓDIGO Y FUNCIONES

document.getElementById('add').addEventListener('click', function() {
    // Añadir a Pikachu a la base de datos
    baseDeDatos.push(pikachu);

    // Renderizar de nuevo la tabla
    renderizar();
});

document.getElementById('delete').addEventListener('click', function() {
    // Filtrar la base de datos para remover a Pikachu
    baseDeDatos = baseDeDatos.filter(pokemon => pokemon.nombre !== "Pikachu");

    // Renderizar de nuevo la tabla
    renderizar();
});

document.getElementById('filtrar').addEventListener('click', function() {
    // Filtrar la base de datos para mostrar solo Pokémon de tipo Poison
    baseDeDatos = baseDeDatos.filter(pokemon => pokemon.tipos.includes("Poison"));

    // Renderizar de nuevo la tabla
    renderizar();
});

 document.getElementById('btnReiniciar').addEventListener('click', function() {
    location.reload();
});
 * 


window.onload = renderizar;
 */