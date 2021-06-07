<script src="https://d3js.org/d3.v6.min.js"></script>
<div class="row">
    <div class="col-12">
        <div id="combochart"></div>
    </div>
    <div class="col-6">
        <div id="donutchart"></div>
    </div>
    <div class="col-6">
        <div id="barchart"></div>
    </div>
</div>
<div class="row">
    <div class="col-3">
        <hr style="border: none">
        <h2 class="title">Período de Busca</h2>
        <hr style="border: none">
    </div>
</div>
<div class="row">
    <div class="col-6">
        <h3>Início</h3>
        <input class="form-control data_filter" placeholder="Data Inicial" type="date" id="dt_inicio" value="2021-06-01" required>
    </div>
    <div class="col-6">
        <h3>Fim</h3>
        <input class="form-control data_filter" placeholder="Data Final" type="date" id="dt_fim" value="2021-06-30" required>
    </div>
</div>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    var data_inicio = document.getElementById("dt_inicio").value;
    var data_final = document.getElementById("dt_fim").value;
    
    //Donut Chart Construction
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    
    function drawChart() {
        var jsonData = $.ajax({
            url: "GraphConstructor?grafico=VendaStatus&operacao=GERAR_GRAFICO&dt_inicio="+data_inicio+"&dt_fim="+data_final,
            dataType: "json",
            async: false
        }).responseText;
        
        console.log(jsonData);
        
        var data = google.visualization.arrayToDataTable($.parseJSON(jsonData));

        var options = {
            title: 'Vendas por Status',
            titleTextStyle: {
                bold: false,
                fontName: 'poppins',
                color: '#111111',
                fontSize: 18,
            },
            chartArea: {width: '70%'},
            colors: ['cornflowerblue', 'lightskyblue', 'orange', 'yellow', 'green', 'red', 'greenyellow'],
            width: 480,
            height: 350,
            pieHole: 0.4,
            backgroundColor: { fill:'transparent' }
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
    }
    
    //Bar Chart Construction
    google.charts.load('current', {packages: ['corechart', 'bar']});
    google.charts.setOnLoadCallback(drawBarColors);

    function drawBarColors() {
        var jsonData = $.ajax({
            url: "GraphConstructor?grafico=CadastroNovo&operacao=GERAR_GRAFICO&dt_inicio="+data_inicio+"&dt_fim="+data_final,
            dataType: "json",
            async: false
        }).responseText;
        
        var data = google.visualization.arrayToDataTable($.parseJSON(jsonData));

        var options = {
            title: 'Novos Cadastros',
            titleTextStyle: {
                bold: false,
                fontName: 'poppins',
                color: '#111111',
                fontSize: 18,
            },
            chartArea: {width: '60%'},
            colors: ['#a58461', '#75410a', '#c8b39d'],
            hAxis: {
                title: 'Quantidade',
                minValue: 0
            },
            width: 480,
            height: 350,
            backgroundColor: { fill:'transparent' }
        };
        var chart = new google.visualization.BarChart(document.getElementById('barchart'));
        chart.draw(data, options);
    }
    
    //Combo Chart Construction
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawVisualization);

    function drawVisualization() {
        var jsonData = $.ajax({
            url: "GraphConstructor?grafico=VendaValor&operacao=GERAR_GRAFICO&dt_inicio="+data_inicio+"&dt_fim="+data_final,
            dataType: "json",
            async: false
        }).responseText;
        
        var data = google.visualization.arrayToDataTable($.parseJSON(jsonData));

        var options = {
            title : 'Resultado de Vendas',
            titleTextStyle: {
                bold: false,
                fontName: 'poppins',
                color: '#111111',
                fontSize: 18,
            },
            colors: ['#a58461', '#c8b39d', '#75410a'],
            vAxis: {title: 'Valor (R$)'},
            hAxis: {title: 'Mês/Ano'},
            seriesType: 'bars',
            series: {2: {type: 'line'}},
            width: 960,
            height: 400,
            backgroundColor: { fill:'transparent' }
        };

        var chart = new google.visualization.ComboChart(document.getElementById('combochart'));
        chart.draw(data, options);
    }
    
    document.querySelectorAll('.data_filter').forEach(item => {
        item.addEventListener("input", function(){
            data_inicio = document.getElementById("dt_inicio").value;
            data_final = document.getElementById("dt_fim").value;
            
            drawChart();
            drawBarColors();
            drawVisualization();
        });
    });
</script>