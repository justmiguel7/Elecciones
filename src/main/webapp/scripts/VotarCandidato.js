$(function () {
    $("#btn-votar").click(function () {

		const urlParams = new URLSearchParams(window.location.search);
		const idMesa = urlParams.get('idMesa'); // esto captura el idMesa=5 por ejemplo
		

        // Obtener candidatos seleccionados
        let voto = {
            presidente: $("input[name='presidente']:checked").val(),
            vicepresidente: $("input[name='vicepresidente']:checked").val(),
            gobernador: $("input[name='gobernador']:checked").val(),
			mesa: idMesa // agrega la mesa del url
        };

        // Validar si están todos seleccionados
        if (!voto.presidente || !voto.vicepresidente || !voto.gobernador) {
            Swal.fire({
                icon: "warning",
                title: "Faltan candidatos",
                text: "Debes seleccionar un candidato para cada rol."
            });
            return;
        }

        // SweetAlert2 de confirmación
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: "btn btn-success me-2",
                cancelButton: "btn btn-danger"
            },
            buttonsStyling: false
        });

        swalWithBootstrapButtons.fire({
            title: "¿Estás seguro?",
            text: "Una vez enviado, no podrás modificar tu voto.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonText: "Sí, confirmar voto",
            cancelButtonText: "No, cancelar",
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                // Enviar por AJAX
                $.ajax({
                    url: contextPath + "/confirmarVoto",
                    method: "POST",
                    contentType: "application/json",
                    data: JSON.stringify(voto),
                    success: function (data) {
                        Swal.fire({
                            icon: "success",
                            title: "¡Voto registrado!",
                            text: "Redirigiendo a la confirmación...",
                            showConfirmButton: false,
                            timer: 2000
                        });

                        // Redirigir después de 2 segundos
                        setTimeout(function () {
                            if (data.redirect) {
                                window.location.href = data.redirect;
                            }
                        }, 2000);
                    },
                    error: function () {
                        Swal.fire({
                            icon: "error",
                            title: "Error",
                            text: "No se pudo registrar tu voto."
                        });
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire({
                    title: "Cancelado",
                    text: "Tu voto no fue enviado.",
                    icon: "error"
                });
            }
        });
    });

    // Efecto visual al seleccionar tarjetas
    $(".seleccion_candidatos label").click(function () {
        let input = $(this).find("input[type='radio']");
        let group = "input[name='" + input.attr("name") + "']";

        $(group).each(function () {
            $(this).closest("label").removeClass("border border-primary");
        });

        $(this).addClass("border border-primary");
        input.prop("checked", true);
    });
});