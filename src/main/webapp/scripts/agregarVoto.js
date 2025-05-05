
/*

$(function() {

    $("#btn-confirmar").click(function (e) {
            e.preventDefault(); 
            var usuario =$("#usuario").val();
            var distrito =$("#distrito").val();
            var ya_voto =$("#ya_voto").val();
                $.ajax({
                    url: contextPath + '/CrearPadron',
                    dataType: 'json',
                    success: function (data) {
                        alert(data.mensaje   );
                        window.location.href=contextPath+'/LeerDatosPadron';
                    },
                    error: function(xhr, status, error) {
                          alert(error);               
                    },
                    data: {
                        usuario: usuario,
                        distrito: distrito,
                        ya_voto: ya_voto
                    },
                    cache: true,
                    type: 'post'
                });
        });

}); */

$(function() {

    $("#btn-confirmar").click(function (e) {
        e.preventDefault(); 

        var DNI = $("#DNI").val();
        var candidato = $("#candidato").val();
      

        $.ajax({
            url: contextPath + '/CrearVoto',
            type: 'POST',  // <-- tipo primero
            dataType: 'json',
            data: {
                usuario: usuario,
                candidato: candidato,
    
            },
            cache: true,
            success: function (data) {
                alert(data.mensaje);
                window.location.href = contextPath + '/LeerDatosVotos';
            },
            error: function(xhr, status, error) {
                alert("Error: " + error);
                console.log(xhr.responseText); // Para debug
            }
        });
    });

});