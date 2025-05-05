<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.Voto"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VISTA DE LOS VOTOS</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

	<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/eliminarvoto.js"> </script>


</head>
<body>

<div class="container mt-4">


<span>
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/formulario?form=votosform" > Nuevo </a>
</span>

<%  List<Voto> votos = (List) request.getAttribute("votos"); %>

<table class="table">
  <thead>
    <tr>
      <th scope="col">id_voto</th>
      <th scope="col">DNI</th>
      <th scope="col">id_candidato</th>
      <th scope="col">fecha_hora</th>
    </tr>
  </thead>
  <tbody>
<% for(int i = 0; i < votos.size(); i++) { %>
    <tr bgcolor="white">
      <td><%= votos.get(i).getId_voto() %></td>
      <td><%= votos.get(i).getDNI() %></td>
      <td><%= votos.get(i).getId_candidato() %></td>
      <td><%= votos.get(i).getFecha_Hora() %></td>
      <td> 
        <a class="btn btn-primary" href="<%= request.getContextPath() %>/loadVotosForm?id=<%= votos.get(i).getId_voto() %>">editar</a>
        <button class="btn btn-danger" data-id="<%= votos.get(i).getId_voto() %>" onClick="myFunction(this)">eliminar</button>
      </td>
    </tr>
<% } %>
  </tbody>
</table>

</div>
</body>
</html>