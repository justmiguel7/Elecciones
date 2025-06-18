<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sample.core.domain.Voto" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="<%=request.getContextPath()%>/icon/icon.png">

    <title>Resultados de Votación</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/Admin.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<div class="imagenfondo3">
    <h1>Resultados de la Votación</h1>
    <p style="opacity: 0.8;">Visualizá quién lidera por rol y cómo se distribuyeron los votos</p>
</div>

<div class="container-principal">



    <!-- Gráfico -->
    <div class="graficos">
        <h2>Gráfico por Rol</h2>
        <label for="rolSelect">Seleccioná un rol:</label>
        <select id="rolSelect">
            <option value="presidente">Presidente</option>
            <option value="vicepresidente">Vicepresidente</option>
            <option value="gobernador">Gobernador</option>
        </select>
        <canvas id="graficoCircular"></canvas>
    </div>


<!-- Script para cargar gráfico y manejar select -->
<script>
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
        'Partido Azul': 'rgba(54, 162, 235, 0.7)',
        'Partido Rojo': 'rgba(255, 99, 132, 0.7)',
        'Partido Verde': 'rgba(75, 192, 192, 0.7)'
    };

    const bordesPorPartido = {
        'Partido Azul': 'rgba(54, 162, 235, 1)',
        'Partido Rojo': 'rgba(255, 99, 132, 1)',
        'Partido Verde': 'rgba(75, 192, 192, 1)'
    };

    function cargarGraficoPorRol() {
        const rol = document.getElementById("rolSelect").value;
        const contextPath = '<%=request.getContextPath()%>';

        fetch(contextPath + '/votosPorRol?rol=' + rol)
            .then(response => {
                if (!response.ok) throw new Error("Error al obtener los datos");
                return response.json();
            })
            .then(data => {
                graficoCircular.data.labels = data.labels;
                graficoCircular.data.datasets[0].data = data.data;
                graficoCircular.data.datasets[0].backgroundColor = data.labels.map(label => coloresPorPartido[label] || 'rgba(201, 203, 207, 0.7)');
                graficoCircular.data.datasets[0].borderColor = data.labels.map(label => bordesPorPartido[label] || 'rgba(201, 203, 207, 1)');
                graficoCircular.update();
            })
            .catch(error => console.error("Error:", error));
    }

    document.getElementById('rolSelect').addEventListener('change', cargarGraficoPorRol);

    cargarGraficoPorRol(); // carga inicial
</script>


    <!-- Tabla de resultados -->
    <div class="tabla-votos">
        <h2>Tabla de Votos</h2>
        <%
            List<Voto> votos = (List) request.getAttribute("votos");
        %>
        <table>
            <thead>
                <tr>
                    <th>ID Voto</th>
                    <th>DNI</th>
                    <th>Presidente</th>
                    <th>Vicepresidente</th>
                    <th>Gobernador</th>
                    <th>Mesa</th>
                    <th>Fecha</th>
                </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < votos.size(); i++) { %>
                <tr>
                    <td><%= votos.get(i).getId_voto() %></td>
                    <td><%= votos.get(i).getDNI() %></td>
                    <td><%= votos.get(i).getId_presidente() %></td>
                    <td><%= votos.get(i).getId_vicepresidente() %></td>
                    <td><%= votos.get(i).getId_gobernador() %></td>
                    <td><%= votos.get(i).getId_mesa() %></td>
                    <td><%= votos.get(i).getFecha_Hora() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>


<div style="text-align: center; margin: 30px 0;">
    <a href="<%= request.getContextPath() %>/" class="btn-volver">
        ⬅ Volver al Inicio
    </a>
</div>


</div>

</body>
</html>
