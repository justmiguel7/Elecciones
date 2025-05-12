<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.LoginCiudadano"%>
    
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


</head>
<body>

<div class="container mt-4">


<span>
</span>

<%  List<LoginCiudadano> ciudadanos  = (List) request.getAttribute("ciudadanos"); %>

<table class="table">
  <thead>
    <tr>
 
      <th scope="col">DNI</th>
      <th scope="col">nombre</th>
      <th scope="col">apellido</th>
      <th scope="col">sexo</th>
      <th scope="col">nacionalidad</th>
      <th scope="col">direccion</th>
      <th scope="col">cp</th>
      <th scope="col">localidad</th>
      <th scope="col">telefono</th>
      
    </tr>
  </thead>
  <tbody>
<%for(int i=0;i<ciudadanos.size();i++){
	%>
	 
	<tr bgcolor="white">
	<td><%=ciudadanos.get(i).getDNI() %></td>
	<td><%=ciudadanos.get(i).getNombre() %></td>
	<td><%=ciudadanos.get(i).getApellido()%></td>
	<td><%=ciudadanos.get(i).getSexo()%></td>
	<td><%=ciudadanos.get(i).getNacionalidad() %></td>
	<td><%=ciudadanos.get(i).getDireccion() %></td>
	<td><%=ciudadanos.get(i).getCp()%></td>
	<td><%=ciudadanos.get(i).getLocalidad()%></td>
	<td><%=ciudadanos.get(i).getTelefono()%></td>
	
	<td> 

	 </td>
<%		
}
%>
 </tbody>

</table>

</div>
</body>
</html>