<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Privacidad y Seguridad del Voto</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/CssPadronElectoral.css" />
</head>
<body>

<header>
    <div class="titulo-pagina">
        <h1>Menu Principal</h1>
        <p>Menu principal de la página</p>
    </div>
    <nav class="navbar">
        <ul>
            <li><a href="<%= request.getContextPath() %>/menuElecciones.jsp" class="seleccionar">Inicio</a></li>
            <li><a href="<%= request.getContextPath() %>/FAQ/FAQ.jsp" class="seleccionar">FAQ</a></li>
            <li><a href="#" class="seleccionar">Candidatos</a></li>
            <li class="derecha"><a href="#" id="iniciarsesioncheck">Iniciar sesion</a></li>
        </ul>
    </nav>
</header>

<!-- SOLO el título está dentro del fondo -->
<div class="imagenfondo3">
    <h2>Privacidad y Seguridad del Voto</h2>
    <p style="opacity: 0.8; font-size: 18px;">Conocé cómo cuidamos tu identidad y protegemos tu decisión electoral</p>
</div>

<!-- Contenido principal sin fondo -->
<div class="container mt-4">

    <div class="card-voto-seguro mb-3">
        <div class="card-header">🔒 Seguridad del Sistema</div>
        <div class="card-body">
            <ul>
                <li>Tus datos están protegidos con conexiones cifradas (HTTPS).</li>
                <li>Solo votantes registrados acceden al sistema.</li>
                <li>Cada ciudadano puede votar solo una vez.</li>
                <li>El sistema registra el voto, no la identidad del votante.</li>
            </ul>
        </div>
    </div>

    <div class="card-voto-seguro mb-3">
        <div class="card-header">🛡️ Protección de Datos Personales</div>
        <div class="card-body">
            <ul>
                <li>Tu DNI y nombre no se comparten con terceros.</li>
                <li>Se usan solo para validar tu identidad.</li>
                <li>Los administradores no pueden saber tu elección.</li>
            </ul>
        </div>
    </div>

    <div class="text-center mt-4">
        <a href="<%= request.getContextPath() %>/votar" class="btn btn-primary">Ir a votar</a>
    </div>
</div>

<footer class="mt-5">
    <h3>¿Cómo funciona esta plataforma?</h3>
    <p>Esta aplicación simula un proceso electoral digital. Cada ciudadano registrado puede emitir su voto de forma segura.</p>
    <p>Los administradores gestionan candidatos, resultados y participación.</p>
    <hr>
    <p style="font-size: 12px; color: #999;">Proyecto desarrollado para fines educativos. &copy; GuzmanStudios</p>
</footer>

</body>
</html>
