
$(function() {
    
    function cargarMesas() {
        $.ajax({
            type: "get",
            url: contextPath +'/mesas',
            data: "data",
            dataType: "json",
            success: function (response) {
                //agregamos la logica para agregar las mesas
                //iteramos la lista
                $.each(response, function(index,value){

                    $("#boxGroupMesas").append("");

                    
                    
                })
            }
        });
    }  



    $(document).ready(function () {
        cargarMesas();    
    });


});