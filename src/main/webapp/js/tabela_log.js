$("a[href='#tab_log']").on('click', function(e){
    e.preventDefault();
    if(!$.fn.DataTable.isDataTable('#log_table')) {
        $('#log_table').DataTable({
            "language": {
                "url" : "//cdn.datatables.net/plug-ins/1.10.21/i18n/Portuguese-Brasil.json"
            },
            "columnDefs": [{
                "targets": [0,1,2,5,6],
                "className": "dt-center"
            },{
                "targets": [0,1,2,5],
                "width": "1%"
            },{
                "targets": [6],
                "width": "20%"
            },{
                "targets": [3,4],
                "width": "30%"
            }],
            "processing": true,
            "ajax": "./json/data_log_table.json"
        });
    }
});