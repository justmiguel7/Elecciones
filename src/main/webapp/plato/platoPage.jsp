<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.Plato"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

	<script type="text/javascript">
			var contextPath='<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/scripts/eliminarPlato.js"> </script>


</head>
<body>

<div class="container mt-4">


<span>
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/formulario?form=platoform" > Nuevo </a>
</span>

<%  List<Plato> platos  = (List) request.getAttribute("platos"); %>

<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Titulo</th>
      <th scope="col">Precio</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Operaciones</th>
    </tr>
  </thead>
  <tbody>
<%for(int i=0;i<platos.size();i++){
	%>
	 
	<tr bgcolor="white">
	<td><%=platos.get(i).getId() %></td>
	<td><%=platos.get(i).getTitulo() %></td>
	<td><%=platos.get(i).getPrecio()%></td>
	<td><%=platos.get(i).getDescripcion()%></td>
	<td> 
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/loadPlatoForm?id=<%=platos.get(i).getId()%>" > editar </a>
	 	<button class="btn btn-danger"  data-id="<%=platos.get(i).getId()%>"  onClick="myFunction(this)" > eliminar </button>
	 </td>
<%		
}
%>
 </tbody>

</table>

</div>
</body>
</html>