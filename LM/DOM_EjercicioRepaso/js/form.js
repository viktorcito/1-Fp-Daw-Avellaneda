/**1 Verificar que las dos contraseñas sean idénticas antes de enviar el formulario.
2 Guardar los datos del usuario en localStorage.
3 Verificar si ya existe un usuario en localStorage y modificar el formulario en consecuencia. */

document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("#form");

    
    form.addEventListener("submit", function(event) {
        event.preventDefault();

        let username = document.querySelector("#username").value;
        let email = document.querySelector("#email").value;
        let password = document.querySelector("#password").value;
        let confirmPassword = document.querySelector("#confirmPassword").value;
        let address = document.querySelector("#address").value;

        if (password !== confirmPassword) {
            alert("Las contraseñas no coinciden.");
            return;
        }

        if (address.length < 10) {
            alert("Dirección demasiado corta. No has escrito la dirección de envío completa");
            return; //si esto queremos que funcione a que quitar el minlength=10
        }

        let user = {
            username: username,
            email: email,
            password: password,
            address: address
        };

        localStorage.setItem("user", JSON.stringify(user));

        alert("El usuario ha sido registrado con éxito.");
        form.reset();
    });

    let user = JSON.parse(localStorage.getItem("user"));

    if(user) {
        // Modificar el formulario para iniciar sesión
        form.innerHTML = `
            <fieldset>
                <label for="username">Usuario:</label>
                <input type="text" id="username" name="username" required>
            </fieldset>
            <fieldset>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </fieldset>
            <input type="submit" value="Iniciar Sesión">
        `;

        form.addEventListener("submit", function(event) {
            event.preventDefault();

            let username = document.querySelector("#username").value;
            let password = document.querySelector("#password").value;

            if(username !== user.username || password !== user.password) {
                alert("Usuario o contraseña incorrectos.");
                return;
            }

            form.style.display = "none";
            alert("Has iniciado sesión correctamente.");
        });
    }
});



/**
 * document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("#form");

    let user = JSON.parse(localStorage.getItem("user"));

    if (user) {
        // Modificar el formulario para iniciar sesión
        form.innerHTML = `
            <fieldset>
                <label for="username">Usuario:</label>
                <input type="text" id="username" name="username" required>
            </fieldset>
            <fieldset>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </fieldset>
            <input type="submit" value="Iniciar Sesión">
        `;

        form.addEventListener("submit", function(event) {
            event.preventDefault();

            let username = document.querySelector("#username").value;
            let password = document.querySelector("#password").value;

            if(username !== user.username || password !== user.password) {
                alert("Usuario o contraseña incorrectos.");
                return;
            }

            form.style.display = "none";
            alert("Has iniciado sesión correctamente.");
        });

    } else {
        // Manejo del formulario de registro
        form.addEventListener("submit", function(event) {
            event.preventDefault();

            let username = document.querySelector("#username").value;
            let email = document.querySelector("#email").value;
            let password = document.querySelector("#password").value;
            let confirmPassword = document.querySelector("#confirmPassword").value;
            let address = document.querySelector("#address").value;

            if (password !== confirmPassword) {
                alert("Las contraseñas no coinciden.");
                return;
            }

            if (address.length < 10) {
                alert("Dirección demasiado corta. No has escrito la dirección de envío completa");
                return;
            }

            let user = {
                username: username,
                email: email,
                password: password,
                address: address
            };

            localStorage.setItem("user", JSON.stringify(user));

            alert("El usuario ha sido registrado con éxito.");
            location.reload();
        });
    }
});

 * 
 * 
 */



/**
 * document.form.address.addEventListener('input', cambiarMensaje);

function cambiarMensaje(evento) {
    if (evento.target.validity.tooShort) {
        evento.target.setCustomValidity("Dirección demasiado corta. No has escrito la dirección de envío completa");
    }
    else {
        evento.target.setCustomValidity("");
    }
}

 * 
 */



/**FORMA DOM COÑAZO
 * document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("#form");

    function handleRegistrationForm() {
        form.addEventListener("submit", function(event) {
            event.preventDefault();

            let username = document.querySelector("#username").value;
            let email = document.querySelector("#email").value;
            let password = document.querySelector("#password").value;
            let confirmPassword = document.querySelector("#confirmPassword").value;
            let address = document.querySelector("#address").value;

            if (password !== confirmPassword) {
                alert("Las contraseñas no coinciden.");
                return;
            }

            if (address.length < 10) {
                alert("Dirección demasiado corta. No has escrito la dirección de envío completa");
                return;
            }

            let user = {
                username: username,
                email: email,
                password: password,
                address: address
            };

            localStorage.setItem("user", JSON.stringify(user));

            alert("El usuario ha sido registrado con éxito.");
            form.reset();
        });
    }

    let user = JSON.parse(localStorage.getItem("user"));

    if(user) {
        // Vacía el formulario
        while (form.firstChild) {
            form.firstChild.remove();
        }

        // Crea y añade los nuevos elementos para el formulario de inicio de sesión
        let userFieldset = document.createElement("fieldset");
        let userLabel = document.createElement("label");
        userLabel.setAttribute("for", "username");
        userLabel.textContent = "Usuario:";
        let userInput = document.createElement("input");
        userInput.type = "text";
        userInput.id = "username";
        userInput.name = "username";
        userInput.required = true;
        userFieldset.appendChild(userLabel);
        userFieldset.appendChild(userInput);

        let passFieldset = document.createElement("fieldset");
        let passLabel = document.createElement("label");
        passLabel.setAttribute("for", "password");
        passLabel.textContent = "Contraseña:";
        let passInput = document.createElement("input");
        passInput.type = "password";
        passInput.id = "password";
        passInput.name = "password";
        passInput.required = true;
        passFieldset.appendChild(passLabel);
        passFieldset.appendChild(passInput);

        let submitInput = document.createElement("input");
        submitInput.type = "submit";
        submitInput.value = "Iniciar Sesión";

        form.appendChild(userFieldset);
        form.appendChild(passFieldset);
        form.appendChild(submitInput);

        form.addEventListener("submit", function(event) {
            event.preventDefault();

            let username = document.querySelector("#username").value;
            let password = document.querySelector("#password").value;

            if(username !== user.username || password !== user.password) {
                alert("Usuario o contraseña incorrectos.");
                return;
            }

            form.style.display = "none";
            alert("Has iniciado sesión correctamente.");
        });
    } else {
        handleRegistrationForm();
    }
});

 * 
 */
