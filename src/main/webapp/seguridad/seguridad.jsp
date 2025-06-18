<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="<%=request.getContextPath()%>/icon/icon.png">

    <meta charset="UTF-8">
    <title>Privacidad y Seguridad del Voto - Sistema Electoral Digital</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/CssPadronElectoral.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body class="pagina-seguridad"> <%-- ¡Añadido! Esta es la clase que usaremos --%>

<header>
    <div class="titulo-pagina">
        <h1>Seguridad</h1>
        <p id="opacity">Acerca de la seguridad de los votos</p>
    </div>
    <nav class="navbar">
        <ul>
            <li><a href="<%= request.getContextPath() %>/" class="seleccionar">Inicio</a></li>
            <li><a href="<%= request.getContextPath() %>/FAQ/FAQ.jsp" class="seleccionar">FAQ</a></li>
                <li><a href="<%=request.getContextPath()%>/seguridad/seguridad.jsp" class="seleccionar">Seguridad y Privacidad</a></li>
            <li class="derecha"><a href="#" id="iniciarsesioncheck">Iniciar Sesión</a></li>
        </ul>
    </nav>
</header>

<div class="imagenfondo3">
    <h2>Privacidad y Seguridad del Voto</h2>
    <p style="opacity: 0.8; font-size: 18px;">Conocé cómo cuidamos tu identidad y protegemos tu decisión electoral</p>
</div>

<main class="container mt-4">

    <section class="section-voto-seguro">
        <h3>Principios Fundamentales de Seguridad Electoral</h3>
        <p class="section-description">Nuestra plataforma está diseñada con los más altos estándares de seguridad y privacidad para garantizar un proceso electoral justo, transparente y confiable.</p>

        <div class="card-group">
            <div class="card-voto-seguro mb-3">
                <div class="card-header"><i class="fas fa-lock"></i> Seguridad del Sistema</div>
                <div class="card-body">
                    <p>Implementamos robustas medidas de seguridad informática para garantizar la integridad de cada voto y la protección general de la plataforma.</p>
                    <ul>
                        <li><i class="fas fa-shield-alt"></i> **Conexiones Cifradas (HTTPS):** Toda la comunicación entre tu navegador y nuestra plataforma está protegida mediante cifrado SSL/TLS, impidiendo que terceros intercepten tus datos.</li>
                        <li><i class="fas fa-user-check"></i> **Acceso Restringido y Autenticado:** Solo los ciudadanos previamente registrados y validados pueden acceder al sistema de votación, utilizando credenciales seguras para su identificación.</li>
                        <li><i class="fas fa-vote-yea"></i> **Un Voto por Ciudadano:** Nuestro sistema cuenta con mecanismos estrictos para asegurar que cada votante registrado pueda emitir su voto una única vez, previniendo duplicidades o intentos de fraude.</li>
                        <li><i class="fas fa-server"></i> **Infraestructura Protegida:** Los servidores que albergan el sistema están resguardados con medidas de seguridad física y lógica, incluyendo firewalls, monitoreo constante y copias de seguridad.</li>
                    </ul>
                </div>
            </div>

            <div class="card-voto-seguro mb-3">
                <div class="card-header"><i class="fas fa-user-secret"></i> Protección de Datos Personales y Anonymato</div>
                <div class="card-body">
                    <p>Tu privacidad es nuestra prioridad absoluta. Manejamos tus datos personales con la máxima confidencialidad y aseguramos el secreto de tu voto.</p>
                    <ul>
                        <li><i class="fas fa-id-card"></i> **Uso Exclusivo para Validación:** Tu DNI y nombre completo se utilizan únicamente para verificar tu elegibilidad en el padrón electoral, y no son vinculados a tu elección de voto.</li>
                        <li><i class="fas fa-mask"></i> **Separación de Identidad y Voto:** Una vez que tu identidad ha sido validada, tu voto es procesado de forma completamente anónima. El sistema registra el voto, no la identidad de quien lo emitió.</li>
                        <li><i class="fas fa-user-slash"></i> **Confidencialidad Absoluta:** Garantizamos que tu elección de voto es completamente secreta. Ni los administradores del sistema, ni los auditores, ni ningún tercero pueden conocer por quién votaste individualmente.</li>
                        <li><i class="fas fa-gavel"></i> **Cumplimiento Normativo:** Nuestra plataforma se adhiere estrictamente a las leyes de protección de datos personales vigentes, asegurando un tratamiento legítimo, leal y transparente de tu información.</li>
                    </ul>
                </div>
            </div>

            <div class="card-voto-seguro mb-3">
                <div class="card-header"><i class="fas fa-lightbulb"></i> Transparencia y Auditabilidad</div>
                <div class="card-body">
                    <p>Creemos en un proceso electoral abierto y verificable para generar plena confianza en los resultados.</p>
                    <ul>
                        <li><i class="fas fa-file-invoice"></i> **Registro Inmutable de Votos:** Cada voto emitido se registra de manera segura en una base de datos con mecanismos de integridad que impiden su modificación, alteración o eliminación posterior.</li>
                        <li><i class="fas fa-eye"></i> **Resultados Verificables:** Los datos agregados de los resultados electorales son computados y presentados de manera que permiten su verificación y auditoría por parte de observadores autorizados.</li>
                        <li><i class="fas fa-cogs"></i> **Auditorías Independientes (Simuladas):** En un entorno real, el código fuente y la infraestructura del sistema serían sometidos a rigurosas auditorías de seguridad por entidades externas e independientes para validar su robustez y ausencia de vulnerabilidades.</li>
                        <li><i class="fas fa-fingerprint"></i> **Rastreo y Trazabilidad:** Aunque los votos son anónimos, el sistema mantiene registros de auditoría que permiten rastrear eventos sin comprometer la privacidad, lo que facilita la investigación en caso de incidencias.</li>
                    </ul>
                </div>
            </div>
        </div>
    </section>

    <div class="text-center mt-5 mb-5">
        <a href="<%= request.getContextPath() %>/Padron" class="btn btn-primary btn-lg">¡Votá Ahora de Forma Segura! <i class="fas fa-arrow-right"></i></a>
    </div>
</main>

<footer class="mt-5">
    <h3>¿Cómo funciona esta plataforma?</h3>
    <p>Esta aplicación simula un proceso electoral digital. Cada ciudadano registrado puede emitir su voto de forma segura y confidencial.</p>
    <p>Los administradores gestionan los candidatos, los resultados electorales y la participación, asegurando la equidad del proceso.</p>
    <hr>
    <p style="font-size: 12px; color: #999;">Proyecto desarrollado con fines educativos y de demostración. &copy; GuzmanStudios</p>
</footer>

</body>
</html>