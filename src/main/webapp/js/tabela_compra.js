$("a[href='#tab_compra']").on('click', function(e){
    e.preventDefault();
    if(!$.fn.DataTable.isDataTable('#compras_table')) {
        $('#compras_table').DataTable({
            "language": {
                "url" : "//cdn.datatables.net/plug-ins/1.10.21/i18n/Portuguese-Brasil.json"
            },
            "columnDefs": [{
                "targets": [0,1,2,3,4],
                "className": "dt-center"
            },{
                "targets": [0,1],
                "width": "1%"
            },{
                "targets": [2],
                "width": "15%"
            },{
                "targets": [3],
                "width": "8%"
            },{
                "targets": [4],
                "width": "10%"
            }],
            "processing": true,
            "ajax": "./json/data_compra_table.json"
        });
    }
});