
class Mesa {
    constructor(id, numero, distrito, idPadron, orden) {
        this.id = id;
        this.numero = numero;
        this.distrito = distrito;
        this.idPadron = idPadron;
        this.orden = orden;
    }

    renderizar() {
        return `
            <div class="card m-2" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">Mesa N° ${this.numero}</h5>
                    <p class="card-text"><strong>ID Mesa:</strong> ${this.id}</p>
                    <p class="card-text"><strong>Distrito:</strong> ${this.distrito}</p>
                    <a href="${contextPath}/votar?idMesa=${this.id}" class="btn btn-primary">Entrar</a>
                </div>
            </div>
        `;
    }
}

function cargarListadoMesas() {
    $.ajax({
        url: contextPath + "/LeerDatosMesa",
        method: "GET",
        cache: false,
        success: function(response) {
            console.log("Respuesta servidor:", response);
            $('#seleccion').empty();

            // Validar si la respuesta indica que ya votó:
            if (response.yaVoto) {
                Swal.fire({
                    icon: 'warning',
                    title: 'Atención',
                    text: 'Ya has emitido tu voto. No puedes volver a votar.'
                });
                $('#seleccion').html('<p class="text-danger">Ya votaste. No puedes seleccionar ninguna mesa.</p>');
                return;
            }

            // Si no es objeto {yaVoto: true}, es un array de mesas:
            if (Array.isArray(response)) {
                response.forEach(m => {
                    const mesa = new Mesa(m.id_mesa, m.mesa, m.distrito, m.id_padron, m.orden);
                    $('#seleccion').append(mesa.renderizar());
                });
            } else {
                console.error("Respuesta inesperada del servidor:", response);
                $('#seleccion').html('<p class="text-danger">Error al procesar datos de las mesas.</p>');
            }
        },
        error: function(xhr) {
            console.error("Error al cargar mesas:", xhr);
            $('#seleccion').html('<p class="text-danger">Error al cargar las mesas.</p>');
        }
    });
}

$(document).ready(function() {
    cargarListadoMesas();
});