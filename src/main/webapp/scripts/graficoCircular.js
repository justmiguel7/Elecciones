const ctx = document.getElementById('graficoCircular').getContext('2d');

const graficoCircular = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: [],
        datasets: [{
            label: 'Votos por Partido',
            data: [],
            backgroundColor: [],
            borderColor: [],
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'bottom'
            }
        }
    }
});

const coloresPorPartido = {
    'Partido Azul': 'rgba(54, 162, 235, 0.7)', // azul
    'Partido Rojo': 'rgba(255, 99, 132, 0.7)', // rojo
    'Partido Verde': 'rgba(75, 192, 192, 0.7)', // verde
    // Podés agregar más partidos si es necesario
};

const bordesPorPartido = {
    'Partido Azul': 'rgba(54, 162, 235, 1)',
    'Partido Rojo': 'rgba(255, 99, 132, 1)',
    'Partido Verde': 'rgba(75, 192, 192, 1)',
    // Idem arriba
};

function cargarGraficoPorRol() {
    const rol = document.getElementById("rolSelect").value;

    fetch(contextPath + '/votosPorRol?rol=' + rol)
        .then(response => {
            if (!response.ok) {
                throw new Error("Error al obtener los datos");
            }
            return response.json();
        })
        .then(data => {
            graficoCircular.data.labels = data.labels;
            graficoCircular.data.datasets[0].data = data.data;

            // Asignar colores según el nombre del partido
            graficoCircular.data.datasets[0].backgroundColor = data.labels.map(label => coloresPorPartido[label] || 'rgba(201, 203, 207, 0.7)');
            graficoCircular.data.datasets[0].borderColor = data.labels.map(label => bordesPorPartido[label] || 'rgba(201, 203, 207, 1)');

            graficoCircular.update();
        })
        .catch(error => {
            console.error("Error:", error);
        });
}

document.addEventListener("DOMContentLoaded", function() {
    cargarGraficoPorRol(); // carga inicial
});
