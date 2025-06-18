<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@ page import="com.sample.core.domain.Candidato" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/CssPadronElectoral.css">
<meta charset="UTF-8">

  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<title>Votar candidatos</title>
	<script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
    	<script src="<%=request.getContextPath()%>/scripts/ListarCandidato.js"></script>
    	<script src="<%=request.getContextPath()%>/scripts/VotarCandidato.js"></script>
    <script type="text/javascript">
        var contextPath = "<%=request.getContextPath()%>";
    </script>
    <script src="<%=request.getContextPath()%>/scripts/logoutCiudadano.js"></script>
    

</head>
 <body>
 
 
    <header>
        <div class="titulo-pagina">
            <h1>Menu Principal</h1>
            <p>Menu principal de la pagina</p>
        </div>
        <nav class="navbar">
            <ul>
                <li><a href="<%=request.getContextPath()%>/menuElecciones.jsp" class="seleccionar">Inicio</a></li>
                <li><a href="<%=request.getContextPath()%>/FAQ/FAQ.jsp" class="seleccionar">FAQ</a></li>
                <li><a href="#" class="seleccionar">Candidatos</a></li>
                              <li class="derecha"><a href="#" id="cerrarSesionCiudadano" class="seleccionar">Cerrar sesión</a></li>

             </ul>
        </nav>
    </header>
 
 <div class="container mt-4">


<%  List<Candidato> candidatos = (List) request.getAttribute("candidatos"); %>

<table class="table">
  <thead>
    <tr>
    </tr>
  </thead>
  <tbody>
 <div class="seleccion_candidatos d-flex flex-wrap">
<%
    for(Candidato c : candidatos){
        String rol = c.getRolEnum().toString().toLowerCase(); // presidente, vicepresidente, gobernador
%>
  <label class="card m-2 p-2 radio-label" style="cursor:pointer;">
    <input type="radio" name="<%=rol%>" value="<%=c.getId_candidato()%>" class="d-none radio-<%=rol%>">
    <span class="custom-radio"></span>
    <div class="card-body">
        <img class="ImagenBorderRadius" src="<%= c.getImagen_candidato() %>" alt="Imagen Candidato" style="width:150px; height:145px; margin-bottom:10px;">
        <h5 class="card-title"><%=c.getNombre_candidato()%></h5>
        <p class="card-text"><%=c.getApellido_candidato()%></p>
        <p class="card-text"><%=c.getPartido() %></p>
        <b><p class="card-text"><%=c.getRolEnum() %></p></b>
    </div>
</label>
<%
    }
%>

<div class="text-center mt-4">
    <button id="btn-votar" class="btn btn-success">Confirmar Voto</button>
</div>

</div>
 </tbody>
 
 
    <footer>
        
            
            
    <h3>¿Cómo funciona esta plataforma?</h3>
    <p>Esta aplicación permite simular un proceso de elecciones en línea. Cada ciudadano registrado en el padrón puede emitir un voto válido en su distrito.</p>
    <p>Los administradores pueden gestionar candidatos, consultar resultados y monitorear la participación.</p>
    <hr>
    <p style="font-size: 12px; color: #999;">Proyecto desarrollado para fines educativos. &copy;GuzmanStudios todos los derechos reservados</p>


        </p>
    </footer>
 
 
</body>
</html>
