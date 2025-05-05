<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>

	<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/loginCiudadano.js"></script>

</head>
	<body>
	
		<div class="container mt-4" >
			
		<h1>Ingresar al Padron</h1>
		<form class="form" id="#Login">
		  <div class="form-group">
		    <label>DNI</label>
		    <input type="text" class="form-control" id="DNI" name="DNI" aria-describedby="emailHelp" placeholder="Ingrese su DNI">
		  </div>
		  
		  
		  <button type="button" class="btn btn-primary" id="btn-login">Submit</button>
		</form>
		
		</div>
			
	</body>
</html>