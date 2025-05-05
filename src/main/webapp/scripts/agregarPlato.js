$(function() {

    $("#btn-confirmar").click(function (e) {
            e.preventDefault(); 
            var titulo =$("#titulo").val();
            var precio =$("#precio").val();
            var descripcion =$("#descripcion").val();
                $.ajax({
                    url: contextPath + '/CrearPlato',
                    dataType: 'json',
                    success: function (data) {
                        alert(data.mensaje   );
                        window.location.href=contextPath+'/LeerDatosPlato';
                    },
                    error: function(xhr, status, error) {
                          alert(error);               
                    },
                    data: {
                        titulo: titulo,
                        precio: precio,
                        descripcion: descripcion
                    },
                    cache: true,
                    type: 'post'
                });
        });

});