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
