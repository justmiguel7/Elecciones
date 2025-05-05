<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.Padron"%>
    
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
	<script src="<%=request.getContextPath()%>/scripts/eliminarPadron.js"> </script>


</head>
<body>

<div class="container mt-4">


<span>
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/formulario?form=padronform" > Nuevo </a>
</span>

<%  List<Padron> padrones  = (List) request.getAttribute("padrones"); %>

<table class="table">
  <thead>
    <tr>
 
      <th scope="col">id_padron</th>
      <th scope="col">DNI</th>
      <th scope="col">distrito</th>
      <th scope="col">ya_voto</th>
    </tr>
  </thead>
  <tbody>
<%for(int i=0;i<padrones.size();i++){
	%>
	 
	<tr bgcolor="white">
	<td><%=padrones.get(i).getId_padron() %></td>
	<td><%=padrones.get(i).getDNI() %></td>
	<td><%=padrones.get(i).getDistrito()%></td>
	<td><%=padrones.get(i).isYa_voto()%></td>
	<td> 
		<a class="btn btn-primary"  href="<%=request.getContextPath()%>/loadPadronForm?id_padron=<%=padrones.get(i).getId_padron()%>" > editar </a>
	 	<button class="btn btn-danger"  data-id="<%=padrones.get(i).getId_padron()%>"  onClick="myFunction(this)" > eliminar </button>
	 </td>
<%		
}
%>
 </tbody>

</table>

</div>
</body>
</html>