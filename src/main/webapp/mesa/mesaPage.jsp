<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.sample.core.domain.Mesa"%>
<%@page import="com.sample.core.domain.LoginCiudadano"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="<%=request.getContextPath()%>/icon/icon.png">

    <meta charset="UTF-8">
    <title>Listado de Mesas</title>
    
    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/CssPadronElectoral.css">

    <!-- Context Path para JS -->
    <script type="text/javascript">
        var contextPath = '<%=request.getContextPath()%>';
    </script>

    <!-- Scripts -->
    <script src="<%=request.getContextPath()%>/scripts/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/scripts/ListarMesa.js"></script>
    <script src="<%=request.getContextPath()%>/scripts/logoutCiudadano.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body>

    <header>
        <div class="titulo-pagina">
            <h1>Mesas</h1>
            <p id="opacity">Bienvenido al padrón! Estas son las mesas disponibles para votar</p>
        </div>
        <nav class="navbar">
            <ul>
              <li><a href="<%= request.getContextPath() %>/" class="seleccionar">Inicio</a></li>
            <li><a href="<%= request.getContextPath() %>/FAQ/FAQ.jsp" class="seleccionar">FAQ</a></li>
                <li><a href="<%=request.getContextPath()%>/seguridad/seguridad.jsp" class="seleccionar">Seguridad y Privacidad</a></li>
                           <li class="derecha"><a href="#" id="cerrarSesionCiudadano" class="seleccionar">Cerrar sesión</a></li>
            </ul>
        </nav>
    </header>

    <div class="container mt-4">
        <section class="imagenfondo2">
            <h2>Listado de Mesas del Distrito</h2>
            <div class="container mt-5">
                <h1>Mesas habilitadas en tu distrito:</h1>
                <div id="seleccion" class="d-flex flex-wrap"></div>
            </div>
        </section>

<div class="container-dni">

 <!-- DNI Card -->
        <div class="dni-card">
            <div class="dni-header">
                <span>República Argentina</span>
                <span>DNI Electrónico</span>
            </div>
            <div class="dni-body">
                <div class="dni-photo">
                    <img src="<%=request.getContextPath()%>/images/profile-picture.png" alt="Foto Ciudadano">
                </div>
                
                
<div id="infoCiudadano">
    Cargando datos...
</div>

<!-- Importamos el JS externo -->
<script src="<%=request.getContextPath()%>/scripts/DNIVirtual.js"></script>

                
                
                

            </div>
        </div>
    </div>
</div>
        <section class="repetidor" style="background-color: #f8f9fa; padding: 40px;">
            <div class="fila" style="display: flex; gap: 20px; margin-bottom: 30px;">
                <!-- Últimas novedades -->
                <div class="columna" style="flex: 1;">
                    <h2>📢 Últimas novedades</h2>
                    <ul style="list-style: none; padding: 0;">
                        <li><strong>📅 12 de mayo:</strong> Simulador de votación digital habilitado.</li>
                        <li><strong>🗳️ 5 de mayo:</strong> Nuevos candidatos en distrito centro.</li>
                        <li><strong>📌 28 de abril:</strong> Cierre padrón provisorio.</li>
                    </ul>
                </div>

                <!-- Cómo emitir tu voto -->
                <div class="columna" style="flex: 1;">
                    <h2>✅ ¿Cómo emitir tu voto?</h2>
                    <ul>
                        <li>Ingresá a la sección <strong>Padron</strong>.</li>
                        <li>Colocá tu DNI y elegí tu mesa.</li>
                        <li>Seleccioná candidatos y confirmá tu voto.</li>
                        <li>¡Listo! Tu voto será registrado.</li>
                    </ul>
                </div>
            </div>

            <div class="fila" style="display: flex; gap: 20px; margin-bottom: 30px;">
                <!-- Qué se vota -->
                <div class="columna" style="flex: 1;">
                    <h2>🗳️ ¿Qué se vota en esta elección?</h2>
                    <p>Se elige un representante por distrito. Cada ciudadano puede emitir un solo voto.</p>
                </div>

                <!-- Contacto institucional -->
                <div class="columna" style="flex: 1;">
                    <h2>📞 Contacto institucional</h2>
                    <p>Email: elecciones@colegio.edu.ar</p>
                    <p>Teléfono: (011) 1234-5678</p>
                </div>
            </div>

            <div class="fila" style="display: flex; gap: 20px;">
                <!-- Citas sobre democracia -->
                <div class="columna" style="flex: 1;">
                    <h2>💬 Citas sobre democracia</h2>
                    <p>“La democracia es la claridad de exponer problemas y resolverlos.” — Enrique Múgica</p>
                    <p>“Votar es el derecho más poderoso en una democracia.” — Barack Obama</p>
                </div>

                <!-- Preguntas frecuentes -->
                <div class="columna" style="flex: 1;">
                    <h2>❓ Preguntas frecuentes</h2>
                    <p><strong>¿Puedo votar más de una vez?</strong> No.</p>
                    <p><strong>¿Qué pasa si cierro la página?</strong> Tu voto no será registrado hasta confirmar.</p>
                </div>
            </div>
        </section>

       

    <footer>
        <h3>¿Cómo funciona esta plataforma?</h3>
        <p>Simula un proceso de elecciones en línea. Cada ciudadano puede emitir un voto válido.</p>
        <hr>
        <p style="font-size: 12px; color: #999;">Proyecto educativo. © GuzmanStudios</p>
    </footer>

</body>
</html>
