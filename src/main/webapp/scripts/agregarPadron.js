
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




/*
$(function() {

    $("#btn-confirmar").click(function (e) {
        e.preventDefault(); 

        var usuario = $("#usuario").val();
        var distrito = $("#distrito").val();
        var ya_voto = $("#ya_voto").val();

        $.ajax({
            url: contextPath + '/CrearPadron',
            type: 'POST',  // <-- tipo primero
            dataType: 'json',
            data: {
                usuario: usuario,
                distrito: distrito,
                ya_voto: ya_voto
            },
            cache: true,
            success: function (data) {
                alert(data.mensaje);
                window.location.href = contextPath + '/LeerDatosPadron';
            },
            error: function(xhr, status, error) {
                alert("Error: " + error);
                console.log(xhr.responseText); // Para debug
            }
        });
    });

});

*/

$(function() {

    $("#btn-confirmar").click(function (e) {
        e.preventDefault(); 

        var DNI = $("#DNI").val();
        var distrito = $("#distrito").val();
        var ya_voto = $("#ya_voto").val(); // 👈😛 esto es importante

        console.log("Enviando:", { DNI, distrito, ya_voto });

        $.ajax({
            url: contextPath + '/CrearPadron',
            type: 'POST',
            dataType: 'json',
            data: {
                DNI: DNI,
                distrito: distrito,
                ya_voto: ya_voto
            },
            success: function (data) {
                alert(data.mensaje);
                window.location.href = contextPath + '/LeerDatosPadron';
            },
            error: function(xhr, status, error) {
                alert("Error: " + error);
                console.log(xhr.responseText); // para ver el error real
            }
        });
    });

});