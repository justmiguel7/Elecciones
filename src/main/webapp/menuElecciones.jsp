<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/CssElecciones.css">
	<meta charset="UTF-8">
	<title>Elecciones</title>

	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
    <script type="text/javascript">
        var contextPath = "<%=request.getContextPath()%>";
    </script>
	<script src="<%=request.getContextPath()%>/scripts/cargarDatosAdmin.js"></script>
	<script src="<%=request.getContextPath()%>/scripts/scripts-barcito.js"></script>
</head>
<body>

<div class="container">
	<nav class="navbar">
		<a class="navbar-brand">Menu principal</a>
		<!--<a href="<%=request.getContextPath()%>/formulario?form=login" class="navbar-brand">Iniciar Sesion</a>-->
		<a id="botonSesion" class="navbar-brand"></a>
	</nav>

	<div class="seleccion">
		<div class="card m-2">
			<img class="card-img-top" src="https://cloudfront-us-east-1.images.arcpublishing.com/infobae/PA5VI6NG75FA3MW5G4GSNWCY6Y.jpg" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Padron</h5>
				<p class="card-text">Ingresar al padron para votar</p>
				<a href="<%= request.getContextPath()%>/ciudadano/loginciudadano.jsp" class="btn btn-primary">Ir</a>
			</div>
		</div>


	</div>
	
	
			<div id="contenedorAdmin"></div>
			
			<div class="container mt-5">
    <h2>Últimas novedades</h2>
    <ul style="list-style: none; padding: 0;">
        <li>
            <strong>📅 12 de mayo:</strong> Se habilitó el simulador de votación digital para prácticas ciudadanas.
        </li>
        <li>
            <strong>🗳️ 5 de mayo:</strong> Nuevos candidatos cargados para las elecciones del distrito centro.
        </li>
        <li>
            <strong>📌 28 de abril:</strong> Cierre del padrón provisorio. Verificá tu inscripción.
        </li>
    </ul>
</div>

<div class="container mt-5">
    <h2>¿Cómo emitir tu voto?</h2>
    <ol>
        <li>Ingresá a la sección <strong>Padron</strong>.</li>
        <li>Colocá tu DNI y elegí tu distrito.</li>
        <li>Seleccioná un candidato y confirmá tu voto.</li>
        <li>¡Listo! Tu voto será registrado y podrás ver los resultados.</li>
    </ol>
</div>

<div class="container mt-5">
    <h2>¿Qué se vota en esta elección?</h2>
    <p>En esta simulación electoral se elige un representante por distrito entre los candidatos registrados. Cada distrito puede tener candidatos distintos y solo se permite un voto por ciudadano.</p>
</div>

<div class="container mt-5">
    <h2>Contacto institucional</h2>
    <p>Ante cualquier duda o inconveniente, contactate con el equipo organizador de las elecciones escolares.</p>
    <p><strong>Email:</strong> elecciones@colegio.edu.ar</p>
    <p><strong>Teléfono:</strong> (011) 1234-5678</p>
</div>

<div class="container mt-5" style="font-style: italic; color: #2c3e50;">
    <h3>Citas sobre democracia</h3>
    <p>“La democracia no es el silencio, es la claridad con que se exponen los problemas y la existencia de medios para resolverlos.” — Enrique Múgica</p>
    <p>“Votar es el derecho más básico y poderoso en una democracia.” — Barack Obama</p>
</div>

<div class="container mt-5">
    <h2>Preguntas frecuentes</h2>
    <p><strong>¿Puedo votar más de una vez?</strong><br>No. El sistema valida que cada ciudadano vote una sola vez.</p>
    <p><strong>¿Qué pasa si cierro la página mientras voto?</strong><br>Tu voto no será registrado hasta que confirmes la selección.</p>
</div>
	

	
	
	
</div>

	<footer class="container mt-5 nav" style="text-align: center;">
    <h3>¿Cómo funciona esta plataforma?</h3>
    <p>Esta aplicación permite simular un proceso de elecciones en línea. Cada ciudadano registrado en el padrón puede emitir un voto válido en su distrito.</p>
    <p>Los administradores pueden gestionar candidatos, consultar resultados y monitorear la participación.</p>
    <hr>
    <p style="font-size: 12px; color: #999;">Proyecto desarrollado para fines educativos.</p>
</footer>

</body>
</html>
