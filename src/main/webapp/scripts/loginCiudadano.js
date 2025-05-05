$(function() {
    $("#btn-login").click(function (e) {
        e.preventDefault(); 
        var DNI =$("#DNI").val();
            $.ajax({
                url: contextPath + '/IngresarCiudadano',
                dataType: 'json',
                success: function (data) {
                    alert(data.mensaje   );
                    window.location.href=contextPath+'/';
                },
                error: function(data) {
                    alert(data.responseJSON.mensaje);            
                },
                data: {
                    DNI: DNI,
                },
                cache: true,
                type: 'post'
            });
    });


});