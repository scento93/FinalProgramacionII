$(document).ready(function() {
    $('#muestraTabla').click(function() {
        if($('#consultarDiv').is(':hidden') ){
            $('#consultarDiv').show();
        }else{
            $('#consultarDiv').hide();
        }


        $('#eliminarLabel').hide();
        $('#ingresarDiv').hide();
        $('#editarDiv').hide();
        $('#accionEliminar').hide();
        $('#errorNoSeleccion').hide();
    });
});

$(document).ready(function() {
    $('#muestraIngreso').click(function() {
        if($('#ingresarDiv').is(':hidden') ){
            $('#ingresarDiv').show();
        }
        $('#eliminarLabel').hide();
        $('#editarDiv').hide();
        $('#accionEliminar').hide();
        $('#errorNoSeleccion').hide();
        $('#consultarDiv').hide();
    });
});

$(document).ready(function() {
    $('#muestraEditar').click(function() {
        if($('#editarDiv').is(':hidden') ){
            $('#editarDiv').show();
            editmode = true;
        }

        $('#eliminarLabel').hide();
        $('#ingresarDiv').hide();
        $('#accionEliminar').hide();
        $('#errorNoSeleccion').hide();
        $('#consultarDiv').hide();
    });
});

$(document).ready(function() {
    $('#muestraEliminar').click(function() {
        if($('#eliminarLabel').is(':hidden') ){
            $('#eliminarLabel').show();
            $('#accionEliminar').show();
        }else{
            $('#eliminarLabel').hide();
        }

        $('#editarDiv').hide();
        $('#ingresarDiv').hide();
        $('#consultarDiv').hide();
    });
});