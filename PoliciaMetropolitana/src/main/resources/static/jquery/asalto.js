var seleccionTabla;
var editmode = false;

$('#condenado').click(function() {
    if( $(this).is(':checked')) {
        $("#condenaDiv").show();
    } else {
        $("#condenaDiv").hide();
    }
});

$('#condenadoedit').click(function() {
    if( $(this).is(':checked')) {
        $("#condenaeditDiv").show();
    } else {
        $("#condenaeditDiv").hide();
    }
});

$('#AsaltoDatatable').find('tr').click( function(){
    var id = $(this).find('td:first').text();
    seleccionTabla = id;
    if(editmode){
        $('#idedit').val(id);
        $('#fechaasaltoedit').val($(this).find('td:eq(1)').text());
        $('#sucursalasaltoedit').val($(this).find('td:eq(3)').text());
        $('#clavedetenidoedit').val($(this).find('td:eq(4)').text());
        $('#juezencargadoedit').val($(this).find('td:eq(5)').text());
        if($(this).find('td:eq(6)').text() === "Si"){
            $('#condenadoedit').prop('checked',true);
        }else{
            $('#condenadoedit').prop('checked',false);
            $('#condenaedit').val($(this).find('td:eq(7)').text());
        }
    }
});

function highlight_row() {
    var table = document.getElementById('AsaltoDatatable');
    var cells = table.getElementsByTagName('td');

    for (var i = 0; i < cells.length; i++) {
        // Take each cell
        var cell = cells[i];
        // do something on onclick event for cell
        cell.onclick = function () {
            // Get the row id where the cell exists
            var rowId = this.parentNode.rowIndex;

            var rowsNotSelected = table.getElementsByTagName('tr');
            for (var row = 0; row < rowsNotSelected.length; row++) {
                rowsNotSelected[row].style.backgroundColor = "";
                rowsNotSelected[row].classList.remove('selected');
            }
            var rowSelected = table.getElementsByTagName('tr')[rowId];
            rowSelected.style.backgroundColor = "lightblue";
            rowSelected.className += " selected";
        }
    }
}

window.onload = highlight_row;

//accion del boton eliminar
$(document).ready(function() {
    $('#accionEliminar').click(function() {
        if(seleccionTabla != null){
            $.ajax({
                type : "DELETE",
                url : "/api/asalto/" + seleccionTabla,
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
function buscarAsaltoBySucursal() {
    var url = '/api/asalto/sucursal';
    if ($('#searchId').val() != '') {
        url = url + '/' + $('#searchId').val();
    }
    $("#resultsBlock").load(url);
}

//accion del boton buscar
function buscarAsaltoByDetenido() {
    var url = '/api/asalto/detenido';
    if ($('#searchId').val() != '') {
        url = url + '/' + $('#searchId').val();
    }
    $("#resultsBlock").load(url);
}