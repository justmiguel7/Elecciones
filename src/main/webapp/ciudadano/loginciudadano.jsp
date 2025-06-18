<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login - Sistema Electoral</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

	<!-- Estilo personalizado -->
	<link rel="stylesheet" href="<%= request.getContextPath()%>/css/estilo-form.css" />
   
	<!-- SweetAlert2 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css"> 
	
	<!-- Bootstrap Icons -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

	<script type="text/javascript">
		var contextPath = '<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/loginCiudadano.js"></script>
    <script src="<%=request.getContextPath()%>/scripts/logoutCiudadano.js"></script>
</head>

<body>
	<div class="wrapper fadeInDown">
		<div id="formContent" class="fadeInDown">

			<h2 class="active fadeIn second"> Ciudadano </h2>

			<div id="Login">
				<input type="text" id="DNI" class="fadeIn second" name="DNI" placeholder="Ingrese su DNI:" required>
				<input type="button" class="fadeIn fourth" id="btn-login" value="Ingresar">
			</div>

			<div class="fadeIn fourth" style="margin-bottom: 20px;">
				<a href="<%=request.getContextPath()%>/menuElecciones.jsp" class="btn btn-secondary">
					<i class="bi bi-arrow-left"></i> Volver al Inicio
				</a>
			</div>

		</div>
	</div>
</body>
</html>
