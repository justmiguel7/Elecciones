<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %> 
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.LoginCiudadano"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Admin.css">

<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>

<script type="text/javascript">
    var contextPath='<%=request.getContextPath()%>';
</script>

</head>
<body>

<div class="imagenfondo3">
    <h1>Resultados de la Votación</h1>
    <p style="opacity: 0.8;">Visualizá quién lidera por rol y cómo se distribuyeron los votos</p>
</div>

<div class="container-principal">



<%  
    List<LoginCiudadano> ciudadanos  = (List) request.getAttribute("ciudadanos"); 
%>

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
<% for(int i=0; i<ciudadanos.size(); i++){ %>
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
    </tr>
<% } %>
 </tbody>

</table>

<div style="text-align: center; margin: 30px 0;">
    <a href="<%= request.getContextPath() %>/" class="btn-volver">
        ⬅ Volver al Inicio
    </a>
</div>

</div>
</body>
</html>
