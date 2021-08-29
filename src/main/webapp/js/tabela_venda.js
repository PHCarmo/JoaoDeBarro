$("a[href='#tab_vendas']").on('click', function(e){
    e.preventDefault();
    if(!$.fn.DataTable.isDataTable('#vendas_table')) {
        $('#vendas_table').DataTable({
            "language": {
                "url" : "//cdn.datatables.net/plug-ins/1.10.21/i18n/Portuguese-Brasil.json"
            },
            "order": [[ 1, "desc" ]],
            "columnDefs": [{
                "targets": [0,1,2,3,4,5],
                "className": "dt-center"
            },{
                "targets": [0,1,2],
                "width": "1%"
            },{
                "targets": [3],
                "width": "15%"
            },{
                "targets": [4],
                "width": "8%"
            },{
                "targets": [5],
                "width": "10%"
            }],
            "processing": true,
            "ajax": "TableConstructor?tabela=Venda&operacao=GERAR_TABELA"
        });
    }
});