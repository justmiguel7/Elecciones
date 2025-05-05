
$(document).ready(function () {
    $("#input-postre").hide();
    $("#input-bebida").hide();
    $("#input-plato").hide();

    $('select').on('change', function() {
       
       if (this.value ==="Estudiantil") {
        //ocltar el postre
        $("#input-postre").hide();
        //realizar petcion ajax de bebida y plato
            $.ajax({
                type: "get",
                url: "http://localhost:8080/bebidas",
                data: "data",
                dataType: "json",
                success: function (response) {
                    var $dropdown = $("#cmbBebida");
                    $.each(response, function() {
                        $dropdown.append($("<option />").val(this.id).text(this.titulo));
                    });
                }
            });

        $("#input-bebida").show();
        $("#input-plato").show();
        } else if(this.value ==="Dia") {
        //ocultar bebida
        $("#input-bebida").hide();
        //realizar petcion ajax de postre y plato
            $.ajax({
                type: "get",
                url: "http://localhost:8080/postres",
                data: "data",
                dataType: "json",
                success: function (response) {
                    var $dropdown = $("#cmbPostre");
                    $.each(response, function() {
                        $dropdown.append($("<option />").val(this.id).text(this.titulo));
                    });
                }
            });



        $("#input-plato").show();
        $("#input-postre").show();
       }else if(this.value ==="Ejecutivo"){
        //realizar petcion ajax de bebida y plato y plato

        $("#input-postre").show();
        $("#input-bebida").show();
        $("#input-plato").show();
       }else{
        $("#input-postre").hide();
        $("#input-bebida").hide();
        $("#input-plato").hide();
       }
       
       
        console.log( this.value );
      });
    
});
