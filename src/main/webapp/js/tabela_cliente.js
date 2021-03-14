$(document).ready(function() {
    $('#clients_table').DataTable({
        "language": {
            "url" : "//cdn.datatables.net/plug-ins/1.10.21/i18n/Portuguese-Brasil.json"
        },
        "columnDefs": [{
            "targets": [0,1,2,5],
            "className": "dt-center"
        },{
            "targets": [0,1,2],
            "width": "1%"
        },{
            "targets": [5],
            "width": "18%"
        },{
            "targets": [3],
            "width": "35%"
        }],
        "processing": true,
        "ajax": "TableConstructor?tabela=Cliente&operacao=GERAR_TABELA"
    });
});