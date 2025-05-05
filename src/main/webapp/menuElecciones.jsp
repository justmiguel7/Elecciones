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
		<a href="<%=request.getContextPath()%>/formulario?form=login" class="navbar-brand">Iniciar Sesion</a>
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
	
	
</div>

</body>
</html>
