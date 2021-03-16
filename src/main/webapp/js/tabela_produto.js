$("a[href='#tab_produtos']").on('click', function(e){
    e.preventDefault();
    if(!$.fn.DataTable.isDataTable('#produtos_table')) {
        $('#produtos_table').DataTable({
            "language": {
                "url" : "//cdn.datatables.net/plug-ins/1.10.21/i18n/Portuguese-Brasil.json"
            },
            "columnDefs": [{
                "targets": [0,1,2,3,4,5,6],
                "className": "dt-center"
            },{
                "targets": [0,1,3],
                "width": "1%"
            },{
                "targets": [4],
                "width": "15%"
            },{
                "targets": [5],
                "width": "17%"
            }],
            "processing": true,
            "ajax": "./json/data_prod_table.json"
        });
    }
});