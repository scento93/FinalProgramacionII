//accion del boton eliminar
$(document).ready(function() {
    $('#accionEliminar').click(function() {
        if(seleccionTabla != null){
            $.ajax({
                type : "DELETE",
                url : "/api/usuario/" + seleccionTabla,
                success: function (result) {
                    console.log(result);
                    location.reload();
                },
                error: function (e) {
                    console.log(e);
                }
            })
        }else{
            $('#errorNoSeleccion').show();
        }
    });
});

//accion del boton buscar
function buscarUsuarioById() {
    var url = '/api/usuario';
    if ($('#searchId').val() != '') {
        url = url + '/' + $('#searchId').val();
    }
    $("#resultsBlock").load(url);
}
