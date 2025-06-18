<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voto Confirmado</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/votoConfirmado.css">
</head>
<body>
    <div class="container">
        <h1>¡Tu voto ha sido registrado correctamente!</h1>
        <p>Gracias por participar de las elecciones.</p>

        <table class="button-table">
            <tr>
                <td><button id="descargarTicket">Descargar Ticket de Voto</button></td>
            </tr>
            <tr>
                <td><button id="menuPrincipal">Regresar al menú principal</button></td>
            </tr>
        </table>
    </div>

    <script>
        document.getElementById("descargarTicket").addEventListener("click", function() {
            // Abrir el PDF en nueva pestaña
            window.open('<%= request.getContextPath() %>/GenerarTicketVoto', '_blank');
        });

        document.getElementById("menuPrincipal").addEventListener("click", function() {
            // Abrir el PDF en nueva pestaña
            window.open('<%= request.getContextPath() %>/', '_self'); // Changed to _self to stay in the same tab
        });
    </script>

</body>
</html>