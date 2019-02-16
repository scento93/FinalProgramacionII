var seleccionTabla;
var editmode = false;

$('#AdministradorDatatable').find('tr').click( function(){
    var row = $(this).find('td:first').text();
    seleccionTabla = row;
    if(editmode){
        $('#idedit').val(row);
        $('#passwordedit').val($(this).find('td:eq(1)').text());
    }
});

function highlight_row_Ad() {
    var table = document.getElementById('AdministradorDatatable');
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