document.addEventListener('DOMContentLoaded', function() {
	fetch(contextPath + '/BuscarCiudadanoPorSesion')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la respuesta del servidor');
            }
            return response.json();
        })
        .then(data => {
            if(data.error) {
                document.getElementById('infoCiudadano').innerText = data.error;
                return;
            }
            const infoHTML = `
			<div class="dni-info">
                <p><strong>DNI:</strong> ${data.DNI}</p>
                <p><strong>Nombre:</strong> ${data.nombre} ${data.apellido}</p>
                <p><strong>Sexo:</strong> ${data.sexo}</p>
                <p><strong>Nacionalidad:</strong> ${data.nacionalidad}</p>
                <p><strong>Dirección:</strong> ${data.direccion}</p>
                <p><strong>Código Postal:</strong> ${data.cp}</p>
                <p><strong>Localidad:</strong> ${data.localidad}</p>
                <p><strong>Teléfono:</strong> ${data.telefono}</p>
				</div>
            `;
            document.getElementById('infoCiudadano').innerHTML = infoHTML;
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('infoCiudadano').innerText = "No se pudieron cargar los datos.";
        });
});
/**
 * 
 */