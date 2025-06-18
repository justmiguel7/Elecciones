<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.Candidato"%>
    
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


<%  List<Candidato> candidatos = (List) request.getAttribute("candidatos"); %>

<table class="table">
  <thead>
    <tr>
      <th scope="col">id_candidato</th>
      <th scope="col">DNI</th>
      <th scope="col">nombre_candidato</th>
      <th scope="col">apellido_candidato</th>
      <th scope="col">sexo_candidato</th>
      <th scope="col">partido</th>
    </tr>
  </thead>
  <tbody>
  
<%for(int i=0;i<candidatos.size();i++){
	%>
	 
	<tr bgcolor="white">
	<td><%=candidatos.get(i).getId_candidato() %></td>
	<td><%=candidatos.get(i).getDNI() %></td>
	<td><%=candidatos.get(i).getNombre_candidato()%></td>
	<td><%=candidatos.get(i).getApellido_candidato()%></td>
		<td><%=candidatos.get(i).getSexo_candidato() %></td>
		<td><%=candidatos.get(i).getPartido() %></td>

<%		
}
%>
 </tbody>

</table>

</div>
</body>
</html>