<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voto Confirmado</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/votoConfirmado.css">
</head>
<body>
    <h1>¡Tu voto ha sido registrado correctamente!</h1>
    <p>Gracias por participar de las elecciones.</p>

    <button id="descargarTicket">Descargar Ticket de Voto</button>



    <br>
        <button id="menuPrincipal">Regresar al menu principal</button>

     <script>
        document.getElementById("descargarTicket").addEventListener("click", function() {
            // Abrir el PDF en nueva pestaña
            window.open('<%= request.getContextPath() %>/GenerarTicketVoto', '_blank');
        });

        document.getElementById("menuPrincipal").addEventListener("click", function() {
            // Abrir el PDF en nueva pestaña
            window.open('<%= request.getContextPath() %>/', '_blank');
        });
    </script>

</body>
</html>