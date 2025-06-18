
$(function () {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: "btn btn-success m-2",
            cancelButton: "btn btn-danger m-2"
        },
        buttonsStyling: false
    });

    $("#btn-login").click(function (e) {
        e.preventDefault();
        const DNI = $("#DNI").val();

        if (!DNI) {
            Swal.fire({
                icon: 'warning',
                title: 'Campo vacío',
                text: 'Por favor, ingresa tu DNI.',
                confirmButtonText: 'Entendido'
            });
            return;
        }

        swalWithBootstrapButtons.fire({
            title: "¿Deseas continuar?",
            text: `Vas a ingresar con el DNI: ${DNI}`,
            icon: "question",
            showCancelButton: true,
            confirmButtonText: "Sí, ingresar",
            cancelButtonText: "Cancelar",
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: contextPath + '/IngresarCiudadano',
                    dataType: 'json',
                    type: 'post',
                    data: { DNI: DNI },
                    cache: true,
                    success: function (data) {
                        Swal.fire({
                            icon: 'success',
                            title: '¡Ingreso exitoso!',
                            text: data.mensaje,
                            showConfirmButton: false,
                            timer: 2000
                        }).then(() => {
                            if (data.redirect) {
                                window.location.href = data.redirect;
                            } else {
                                Swal.fire({
                                    icon: 'info',
                                    title: 'Sin redirección',
                                    text: 'No se proporcionó una URL de redirección.'
                                });
                            }
                        });
                    },
                    error: function (xhr) {
                        let errorMessage = "Ocurrió un error inesperado.";
                        if (xhr.responseJSON && xhr.responseJSON.mensaje) {
                            errorMessage = xhr.responseJSON.mensaje;
                        }
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: errorMessage,
                            confirmButtonText: 'Cerrar'
                        });
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire({
                    title: "Ingreso cancelado",
                    text: "Revisa tu información antes de continuar.",
                    icon: "info",
                    showConfirmButton: false,
                    timer: 2000
                });
            }
        });
    });
});

