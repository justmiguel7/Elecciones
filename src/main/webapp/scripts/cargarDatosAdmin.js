var contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

// Función para cargar los datos del administrador si está autenticado
function cargarDatosAdmin() {
    $.ajax({
        url: contextPath + "/obtenerDatosAdmin", // Ojo: respetar minúsculas como en @WebServlet
        method: "GET",
        cache: false, // evita cachear peticiones
        success: function(response) {
            console.log(response); // Para debug
            $('#contenedorAdmin').html(response);
        },
        error: function(xhr, status, error) {
            console.log("Error al cargar los datos o usuario no autenticado");
            $('#contenedorAdmin').html('<p>No tienes permiso para ver estos datos.</p>');
        }
    });
}

$(document).ready(function() {
    cargarDatosAdmin();
});



function verificarSesionYActualizarBoton() {
    $.ajax({
        url: contextPath + "/obtenerDatosAdmin",
        method: "GET",
        success: function(response) {
            // Si entra acá, es porque hay sesión activa
            $("#botonSesion").attr("href", contextPath + "/logout");
            $("#botonSesion").text("Cerrar Sesión");
        },
        error: function(xhr) {
            if (xhr.status === 401) {
                // No hay sesión activa
                $("#botonSesion").attr("href", contextPath + "/formulario?form=login");
                $("#botonSesion").text("Iniciar Sesión");
            }
        }
    });
}

$(document).ready(function() {
    cargarDatosAdmin();
    verificarSesionYActualizarBoton(); // Esta línea es nueva
});