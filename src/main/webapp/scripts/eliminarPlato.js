 
function myFunction(data){
    value =  $(data).attr("data-id");

    $.ajax({
        type: "get",
        url: contextPath+"/PlatoEliminar?id="+value,
        dataType: "json",
        success: function (response) {
       
            location.reload();
        }
    });

}