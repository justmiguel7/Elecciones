
$(document).ready(function () {
    const loginLink = document.getElementById("iniciarsesioncheck");

    fetch(contextPath + "/api/opciones-admin")
        .then(res => {
            if (!res.ok) {
                if (res.status === 401) {
                    // No hay sesión: mostrar "Iniciar Sesión"
                    if (loginLink) {
                        loginLink.textContent = "Iniciar sesión como Administrador";
                        loginLink.href = contextPath + "/administrador/login.jsp"; // ruta login
                        loginLink.onclick = null; // quitar cualquier handler anterior
                    }
                }
                throw new Error("No autorizado o error interno");
            }
            return res.json();
        })
        .then(opciones => {
            // Hay sesión: mostrar "Cerrar Sesión" con logout vía AJAX
            if (loginLink) {
                loginLink.textContent = "Cerrar Sesión";
                loginLink.href = "#"; // para que no navegue
                loginLink.onclick = function(e) {
                    e.preventDefault(); // evita que recargue la página
                    fetch(contextPath + "/LogOut")
                        .then(res => res.json())
                        .then(data => {
                            console.log("Logout:", data.mensaje);
                            // recargar o ir al login
                            window.location.href = contextPath + "/administrador/login.jsp"; 
                        })
                        .catch(err => console.error("Error en logout:", err));
                };
            }

            const contenedor = document.getElementById("contenedorAdmin");
            contenedor.innerHTML = ""; // limpio
            opciones.forEach(op => {
                const card = `
                    <div class="card m-2" style="width: 18rem;">
                        <img class="card-img-top" src="${op.imagen_url}" alt="Imagen">
                        <div class="card-body">
                            <h5 class="card-title">${op.titulo}</h5>
                            <p class="card-text">${op.descripcion}</p>
                            <a href="${contextPath + op.enlace_url}" class="btn btn-primary">Ir</a>
                        </div>
                    </div>`;
                contenedor.innerHTML += card;
            });
        })
        .catch(err => console.warn("Admin no logueado o error:", err));
});


