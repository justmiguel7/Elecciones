
$(function() {
    // Definir la instancia de SweetAlert con los botones de Bootstrap
    // Esto debe estar definido ANTES de que lo uses en el evento click
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: "btn btn-success m-2",
            cancelButton: "btn btn-danger m-2"
        },
        buttonsStyling: false
    });

    $("#btn-login").click(function (e) {
        e.preventDefault(); // Previene el envío inmediato del formulario
		console.log("🔍 El botón fue clickeado");


        var usuario =$("#usuario").val();
        var password =$("#password").val();

        // Validación básica en el cliente
        if (!usuario || !password) {
            Swal.fire({ // Usa Swal.fire aquí para la alerta de campos vacíos
                icon: 'warning',
                title: 'Campos Vacíos',
                text: 'Por favor, ingresa tu usuario y contraseña.',
                confirmButtonText: 'Entendido'
            });
            return; // Detiene la ejecución si los campos están vacíos
        }

        // *** ESTE ES EL SWEETALERT DE CONFIRMACIÓN INICIAL (COMO EN TU IMAGEN) ***
        swalWithBootstrapButtons.fire({
            title: "¿Confirmar inicio de sesión?", // Título para el login
            text: `¿Estás seguro de que quieres iniciar sesión como "${usuario}"?`, // Mensaje de confirmación
            icon: "question", // Icono de pregunta, no 'warning' a menos que sea un riesgo
            showCancelButton: true,
            confirmButtonText: "Sí, iniciar sesión", 
            reverseButtons: true // Opcional: invierte el orden de los botones
        }).then((result) => {
            if (result.isConfirmed) {
                // Si el usuario confirma, entonces se realiza la llamada AJAX
                $.ajax({
                    url: contextPath + '/ingresarUsuario', 
                    dataType: 'json',
                    success: function (data) {
                        // *** REEMPLAZA EL 'alert(data.mensaje);' CON ESTE SWEETALERT DE ÉXITO ***
                        Swal.fire({
                            icon: 'success',
                            title: '¡Éxito!',
                            text: data.mensaje,
                            showConfirmButton: false, // Se cierra automáticamente
                            timer: 2000 // Cierra después de 2 segundos
                        }).then(() => {
                            window.location.href = contextPath + '/menuElecciones.jsp'; // Redirige después de que la alerta se cierra
                        });
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        // *** REEMPLAZA EL 'alert(data.responseJSON.mensaje);' CON ESTE SWEETALERT DE ERROR ***
                        let errorMessage = "Ocurrió un error inesperado al conectar con el servidor.";
                        if (jqXHR.responseJSON && jqXHR.responseJSON.mensaje) {
                            errorMessage = jqXHR.responseJSON.mensaje;
                        } else if (errorThrown) {
                            errorMessage = errorThrown;
                        }
                        
                        Swal.fire({
                            icon: 'error',
                            title: '¡Error de Autenticación!',
                            text: errorMessage,
                            confirmButtonText: 'Entendido' // Botón para que el usuario cierre la alerta
                        });
                    },
                    data: {
                        usuario: usuario,
                        password: password,
                    },
                    cache: false, // Para peticiones de login, mejor no cachear
                    type: 'post'
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                // Si el usuario cancela la confirmación inicial
                swalWithBootstrapButtons.fire({
                    title: "Inicio de sesión cancelado",
                    text: "Puedes revisar tus datos o intentar más tarde.",
                    icon: "info", // Icono informativo
                    showConfirmButton: false,
                    timer: 2000
                });
            }
        });
    });
});  

