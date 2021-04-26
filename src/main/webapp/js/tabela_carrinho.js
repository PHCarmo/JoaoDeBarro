$(document).ready(function() {
    $('#carrinho_table').DataTable({
        "language": {
            "url" : "//cdn.datatables.net/plug-ins/1.10.21/i18n/Portuguese-Brasil.json"
        },
        "columnDefs": [{
            "targets": [0,1,2,3,4],
            "className": "dt-center"
        },{
            "targets": [0],
            "width": "10%"
        },{
            "targets": [1],
            "width": "20%"
        },{
            "targets": [2,3,4],
            "width": "18%"
        }],
        "order": [[1, "asc"]],
        "processing": true,
        "ajax": "TableConstructor?tabela=Carrinho&operacao=GERAR_TABELA"
    });
});