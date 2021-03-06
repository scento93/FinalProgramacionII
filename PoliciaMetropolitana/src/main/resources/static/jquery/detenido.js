var seleccionTabla;
var editmode = false;

$('#DetenidoDatatable').find('tr').click( function(){
    var row = $(this).find('td:first').text();
    seleccionTabla = row;
    if(editmode){
        $('#claveedit').val(row);
        $('#nombreCompletoedit').val($(this).find('td:eq(1)').text());
        $('#bandaPertenceedit').val($(this).find('td:eq(2)').text());
    }
});

function highlight_row() {
    var table = document.getElementById('DetenidoDatatable');
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
                url : "/api/detenido/" + seleccionTabla,
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
function buscarDetenidoById() {
    var url = '/api/detenido';
    if ($('#searchId').val() != '') {
        url = url + '/' + $('#searchId').val();
    }
    $("#resultsBlock").load(url);
}


