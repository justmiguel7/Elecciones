<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Preguntas Frecuentes Antes de Votar</title>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CssPadronElectoral.css" />

</head>
<body>

<header>
        <div class="titulo-pagina">
            <h1>Menu Principal</h1>
            <p>Menu principal de la pagina</p>
        </div>
        <nav class="navbar">
            <ul>
                <li><a href="<%=request.getContextPath()%>/" class="seleccionar">Inicio</a></li>
                <li><a href="<%=request.getContextPath()%>/FAQ/FAQ.jsp" class="seleccionar">FAQ</a></li>
                <li><a href="<%=request.getContextPath()%>/seguridad/seguridad.jsp" class="seleccionar">Seguridad y Privacidad</a></li>
                
                <li class="derecha"><a href="#" class="seleccionar">Iniciar sesión</a></li>
             </ul>
        </nav>
    </header>

<div class="faq-container">
  <h1>Preguntas Frecuentes Antes de Votar</h1>

  <div class="faq-item">
    <div class="faq-question">
      ¿Quiénes son los candidatos?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Son las personas que se postulan para cargos públicos en una elección.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué experiencia política o profesional tienen?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Depende de cada candidato. Algunos tienen trayectoria, otros son nuevos.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué propuestas concretas tienen?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Debés revisar su plan de gobierno para conocerlas.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué postura tienen sobre temas importantes?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Depende del candidato. Podés comparar sus declaraciones y propuestas.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Es confiable?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Revisá su historial, denuncias y declaraciones anteriores.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Pertenece a un partido con el que me identifico?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Esto puede ayudarte a decidir tu voto.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Cumple sus promesas?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Compará lo que dijo con lo que hizo antes.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Es un verdadero líder?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Fijate si toma decisiones o es un “títere” del partido.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Con qué personas se rodea?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Su equipo puede decir mucho sobre su gestión futura.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Son viables sus propuestas?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Algunas lo son, otras suenan bien pero no tienen sustento.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Cómo va a financiar lo que propone?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Es importante que lo explique claramente.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿A quién beneficia más?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Revisá si sus políticas ayudan a todos o solo a algunos sectores.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Perjudica a alguien?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Toda decisión política tiene impacto social.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué dice sobre el medio ambiente?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Es un tema clave que no todos los candidatos priorizan.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué propone en derechos humanos y justicia social?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Algunos los defienden, otros los minimizan.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué pasó en los últimos años?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Hubo crisis, inflación, reformas. Eso influye en tu decisión.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué quiero mejorar?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Identificar tus prioridades te ayuda a decidir.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Cómo está la economía?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      La inflación, pobreza y desempleo son factores clave.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿El partido ya gobernó?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Podés evaluar su gestión pasada.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Me beneficiaría su gobierno?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Es válido pensar cómo impactará su gestión en tu vida.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué pasa si no voto?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Es obligatorio. Podés ser sancionado y, además, perdés voz.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Mi voto hace la diferencia?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Sí. Especialmente en elecciones reñidas.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Qué dicen los medios?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Escuchalos, pero también analizá por tu cuenta.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Voto por convicción o por miedo?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Lo ideal es votar por tus ideas, no por temor.
    </div>
  </div>

  <div class="faq-item">
    <div class="faq-question">
      ¿Estoy bien informado?
      <span class="arrow">&#9660;</span>
    </div>
    <div class="faq-answer">
      Evitá fake news. Informate por medios confiables.
    </div>
  </div>

</div>

<footer>
        
            
            
    <h3>¿Cómo funciona esta plataforma?</h3>
    <p>Esta aplicación permite simular un proceso de elecciones en línea. Cada ciudadano registrado en el padrón puede emitir un voto válido en su distrito.</p>
    <p>Los administradores pueden gestionar candidatos, consultar resultados y monitorear la participación.</p>
    <hr>
    <p style="font-size: 12px; color: #999;">Proyecto desarrollado para fines educativos. &copy;GuzmanStudios todos los derechos reservados</p>


        </p>
    </footer>
    <script>
    document.querySelectorAll('.faq-item').forEach(item => {
  const question = item.querySelector('.faq-question');
  const answer = item.querySelector('.faq-answer');
  const arrow = item.querySelector('.arrow');

  question.addEventListener('click', () => {
    const isOpen = answer.classList.contains('open');

    // Cerrar todos
    document.querySelectorAll('.faq-answer.open').forEach(openAnswer => openAnswer.classList.remove('open'));
    document.querySelectorAll('.arrow.open').forEach(openArrow => openArrow.classList.remove('open'));

    // Abrir solo si no estaba abierto
    if (!isOpen) {
      answer.classList.add('open');
      arrow.classList.add('open');
    }
  });
});
    </script>
</body>
</html>