/**
 * 
 */


// Este código irá dentro de $(document).ready(function() { ... });
// Puedes añadirlo al final de tu ListarMesa.js o en un nuevo archivo.

$(document).ready(function () {
    // === Lógica para el botón de Cerrar Sesión del CIUDADANO ===
    const cerrarSesionCiudadanoBtn = document.getElementById("cerrarSesionCiudadano");

    if (cerrarSesionCiudadanoBtn) { // Asegura que el botón exista en la página
        cerrarSesionCiudadanoBtn.href = "#"; // Asegura que no navegue
        cerrarSesionCiudadanoBtn.onclick = function(e) {
            e.preventDefault(); // Evita la acción por defecto del enlace

            // Usando jQuery.ajax para la consistencia
            $.ajax({
                url: contextPath + "/LogOut", // Asumo que este Servlet /LogOut es genérico y cierra cualquier sesión
                type: "get", // O "post" si tu Servlet LogOut espera POST
                dataType: "json",
                success: function(data) {
                    console.log("Logout Ciudadano:", data.mensaje);
                    alert(data.mensaje); // Mostrar mensaje de éxito/información
                    // REDIRECCIÓN CAMBIADA AQUÍ:
                    window.location.href = contextPath + "/Padron"; // Redirige a tu nueva página de login de ciudadano
                },
                error: function(xhr) {
                    if (xhr.responseJSON && xhr.responseJSON.mensaje) {
                        alert("Error al cerrar sesión: " + xhr.responseJSON.mensaje);
                        console.error("Error al cerrar sesión (responseJSON):", xhr.responseJSON);
                    } else {
                        alert("Error desconocido al cerrar sesión.");
                        console.error("Error desconocido al cerrar sesión (xhr):", xhr);
                    }
                    // Si el logout falla (ej. porque no había sesión), aún puedes redirigir
                    // para evitar que el usuario se quede "atrapado".
                    window.location.href = contextPath + "/Padron"; // Redirige incluso en caso de error
                }
            });
        };
    }
});

// Tu código existente para el administrador y otras funcionalidades sigue aquí:
/*
$(document).ready(function () {
    const loginLink = document.getElementById("iniciarsesioncheck"); // Este ID parece ser para el admin

    // Tu lógica fetch para administrador (que te proporcioné antes)
    // ...
});
*/

