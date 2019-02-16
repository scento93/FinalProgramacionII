var seleccionTabla;
var editmode = false;

$('#ContratacionDatatable').find('tr').click( function(){
    var id = $(this).find('td:first').text();
    seleccionTabla = id;
    if(editmode){
        $('#idedit').val(id);
        $('#fechaedit').val($(this).find('td:eq(1)').text());
        $('#codsucursaledit').val($(this).find('td:eq(3)').text());
        $('#codvigilanteedit').val($(this).find('td:eq(4)').text());
        if($(this).find('td:eq(5)').text() === "Con Arma"){
            $('#conarmaedit').prop('checked',true);
        }else{
            $('#conarmaedit').prop('checked',false);
        }
    }
});

function highlight_row() {
    var table = document.getElementById('ContratacionDatatable');
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
                url : "/api/contratacion/" + seleccionTabla,
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
function buscarContratacionBySucursal() {
    var url = '/api/contratacion/sucursal';
    if ($('#searchId').val() != '') {
        url = url + '/' + $('#searchId').val();
    }
    $("#resultsBlock").load(url);
}

//accion del boton buscar
function buscarContratacionByVigilante() {
    var url = '/api/contratacion/vigilante';
    if ($('#searchId').val() != '') {
        url = url + '/' + $('#searchId').val();
    }
    $("#resultsBlock").load(url);
}