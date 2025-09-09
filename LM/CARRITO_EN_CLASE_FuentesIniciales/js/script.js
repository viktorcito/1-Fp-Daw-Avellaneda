// -----------------------------------------------------
// Variables

// Creación de un array de productos (simulando su obtención de una base de datos)
const baseDeDatos = [
    {
        id: 1,
        nombre: 'Patata',
        precio: 1,
        imagen: 'imgs/patata.jpg',
        categorias: ['de temporada', 'hortaliza']
    },
    {
        id: 2,
        nombre: 'Cebolla',
        precio: 1.2,
        imagen: 'imgs/cebolla.jpg',
        categorias: ['de temporada', 'hortaliza']
    },
    {
        id: 3,
        nombre: 'Calabacin',
        precio: 2.1,
        imagen: 'imgs/calabacin.jpg',
        categorias: ['de temporada', 'hortaliza']
    },
    {
        id: 4,
        nombre: 'Fresas',
        precio: 0.6,
        imagen: 'imgs/fresas.jpg',
        categorias: ['de temporada', 'hortaliza']
    }

];

// variables globales varias...
let carrito = []; //carrito que guarda los id de las unidades compradas
const divisa = '€';

//observa el html y pon los selectores adecuados
// Son los elementos HTML principales a modificar (añadir contenido) vía JS
const DOMitems = document.querySelector('#items'); //main
//const DOMitems2 = document.getElementById("items"); //otra forma de cargar vía ID
const DOMcarrito = document.querySelector('#carrito');
const DOMtotal = document.querySelector('#total');
const DOMbotonVaciar = document.querySelector('#boton-vaciar');

// -----------------------------------------------------

// Funciones

/**
 * Dibuja todos los productos a partir de la base de datos. 
 * Son los productos a vender.
 * No confundir con el carrito
 */
function renderizarProductos() {

    baseDeDatos.forEach((producto) => {

        // PISTA 1
        // Observa la captura del div correspondiente a cada producto y construye dinámicamente el correspondiente código HTML
        // https://github.com/profeMelola/LM_2022-23/blob/main/JAVASCRIPT/_PROYECTO/EN_CLASE/readme.md#construyendo-din%C3%A1micamente-mediante-js-la-parte-de-los-productos-a-comprar
        
         // div principal
        const miNodo = document.createElement('div');
        miNodo.classList.add('card','col-sm-4');

        // Div CardBody
        const miNodoCarBody = document.createElement('div');
        miNodoCarBody.classList.add('card-body');

        // Imagen
        const miNodoImagen = document.createElement('img');
        miNodoImagen.classList.add('img-fluid');
        miNodoImagen.setAttribute('src',producto.imagen);

         // Titulo
         const miNodoTitulo = document.createElement('h5');
         miNodoTitulo.classList.add('card-title');
         miNodoTitulo.textContent = producto.nombre;

          // Precio
        const miNodoPrecio = document.createElement('p');
        miNodoPrecio.classList.add('card-text');
        //miNodoPrecio.textContent = producto.precio+divisa;
        miNodoPrecio.textContent = `${producto.precio}${divisa}`;

        // Botón para agregar al carrito
        const miNodoBoton = document.createElement('button');
        miNodoBoton.classList.add('btn','btn-primary');
        miNodoBoton.textContent = '+';
        miNodoBoton.setAttribute('marcador',producto.id);
        miNodoBoton.addEventListener('click',anyadirProductoAlCarrito);

        // Botón para quitar del carrito MEJORAAAAAA
        const miNodoBotonQuitar = document.createElement('button');
        miNodoBotonQuitar.classList.add('btn','btn-danger');
        miNodoBotonQuitar.textContent = '-';
        miNodoBotonQuitar.setAttribute('marcador',producto.id);
        miNodoBotonQuitar.addEventListener('click',quitarProductoDelCarrito);

        
        //MONTANDO ESTRUCTURA
        miNodoCarBody.append(miNodoImagen);
        miNodoCarBody.append(miNodoTitulo);
        miNodoCarBody.append(miNodoPrecio);
        miNodoCarBody.append(miNodoBoton);
        miNodoCarBody.append(miNodoBotonQuitar);
        
        miNodo.append(miNodoCarBody);




        DOMitems.append(miNodo);
 

    });


    /*function filtrarPorCategoria(categoria) {
        // Limpiar la lista de productos
        DOMitems.innerHTML = '';
    
        // Filtrar productos
        let productosFiltrados = productos.filter(producto => producto.categorias.includes(categoria));
    
        // Llamar a la función de renderizar productos pasando la lista filtrada
        renderizarProductos(productosFiltrados);
    }*/
    

    /*function filtrarProductos(categoria) {
        // Primero, limpia todos los productos existentes
        DOMitems.innerHTML = '';
    
        // A continuación, filtra y renderiza los productos de la categoría seleccionada
        baseDeDatos
            .filter(producto => categoria ? producto.categorias.includes(categoria) : true)
            .forEach(renderizarProducto);
    }*/
    



}
//MEJORAAAAA
function quitarProductoDelCarrito(evento) {
    // Obtenemos el producto ID que hay en el boton pulsado
    const id = evento.target.getAttribute('marcador')
    // Obtenemos el índice del producto ID que el usuario quiere borrar
    const index = carrito.indexOf(id);
    // Si el producto está en el carrito, lo borramos
    if (index > -1) {
        carrito.splice(index, 1);
    }
    // Después de cada cambio, volvemos a renderizar el carrito
    renderizarCarrito();
}



/**
 * Evento para añadir un producto al carrito de la compra
 */
function anyadirProductoAlCarrito(evento) {
    carrito.push(evento.target.getAttribute('marcador'));
    renderizarCarrito();
}

/**
 * Dibuja todos los productos guardados en el carrito
 */
function renderizarCarrito() {

    // PISTA 2: 
    // https://github.com/profeMelola/LM_2022-23/blob/main/JAVASCRIPT/_PROYECTO/EN_CLASE/readme.md#construyendo-din%C3%A1micamente-mediante-js-el-carrito-de-la-compra

    //limpia los hijos html del ul (que es el carrito)
    DOMcarrito.innerHTML = '';

    // Colección de id de productos no duplicados
    const carritoSinDuplicados = new Set(carrito);


        //For ... of ... también es válido
    carritoSinDuplicados.forEach((idProducto) => {

        // Buscar el producto por id y obtener el objeto producto
        const producto = getItem(idProducto);
        console.log(producto);

        // Obtener el número de unidades compradas del producto
        const numUnidadesProducto = getNumUnidades(idProducto);
        console.log(`NumUnidadesProducto: ${numUnidadesProducto}`);

        // Creamos el node del item del carrito <li>
        const miNodo = document.createElement('li');
        miNodo.classList.add('list-group-item','text-right','mx-2');

        // Creamos la imagen del producto y la añadimos al nodo
        const miNodoImagen = document.createElement('img');
        miNodoImagen.classList.add('img-fluid');
        miNodoImagen.setAttribute('src', producto.imagen);
        miNodoImagen.style.maxWidth = '50px';  // puedes ajustar el tamaño de la imagen //MEJORAAAAAAAA
        
        

        miNodo.textContent = `${numUnidadesProducto} X ${producto.nombre} - ${producto.precio}${divisa}`;

        const miBoton = document.createElement('button');
        miBoton.classList.add('btn','btn-danger','mx-5');
        miBoton.textContent = 'X';
        //miBoton.style.display = 'none';
        miBoton.style.marginLeft = '1rem';
        miBoton.dataset.idProducto = idProducto;
        miBoton.addEventListener('click',borrarItemCarrito);

        miNodo.append(miNodoImagen);
        miNodo.append(miBoton);

        DOMcarrito.append(miNodo);
    });

    DOMtotal.textContent = `${calcularTotal()}${divisa}`;

    // Guardo el carrito en el LocalStorage
    guardarCarritoEnLocalStorage();
}



/**
 * Devuelve el item del carrito
 */
function getItem(id){
    
    return baseDeDatos.find((producto) => producto.id == id);

}


/**
 * Devuelve el número de unidades de un mismo producto en el carrito
 */
function getNumUnidades(id){

    return carrito.filter(itemId => itemId == id).length;
}


/**
 * Evento para borrar un elemento del carrito
 */
function borrarItemCarrito(evento) {
    const id = evento.target.dataset.idProducto;

    carrito = carrito.filter( elemento => elemento != id);

    renderizarCarrito();
}

/**
 * Calcula el precio total teniendo en cuenta los productos repetidos
 */
function calcularTotal() {
    let total = 0;
    for(const id of carrito){
        const objProducto = getItem(id);
        total += objProducto.precio;
        //total = total + objProducto.precio;
    }

    return total.toFixed(2);
}

/**
 * Varia el carrito y vuelve a dibujarlo
 */
function vaciarCarrito() {
    if (confirm('¿Seguro que quieres vaciar el carrito?')){
        carrito = [];
        renderizarCarrito();
    }

}

// -----------------------------------------------------------------------------
// Eventos
// -----------------------------------------------------------------------------
DOMbotonVaciar.addEventListener('click',vaciarCarrito);
// -----------------------------------------------------------------------------

// LocalStorage
// -----------------------------------------------------------------------------
function guardarCarritoEnLocalStorage(){
    window.localStorage.setItem('carrito',JSON.stringify(carrito));
}
function cargarCarritoDeLocalStorage(){
    if(window.localStorage.getItem('carrito') != null)
        carrito = JSON.parse(window.localStorage.getItem('carrito'));
}

// Inicio
window.addEventListener('load',cargarCarritoDeLocalStorage);
window.addEventListener('load',renderizarProductos);
window.addEventListener('load',renderizarCarrito);

//renderizarProductos(); //para cargar los productos en el main con id="items"
//renderizarCarrito(); //para cargar los productos en el carrito (ul con id="carrito")
// -----------------------------------------------------------------------------