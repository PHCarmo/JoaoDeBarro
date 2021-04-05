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
        <input class="form-control" placeholder="Data de Início" type="date" name="dt_inicio" value="2021-01-01" required>
    </div>
    <div class="col-6">
        <h3>Fim</h3>
        <input class="form-control" placeholder="Data de Início" type="date" name="dt_inicio" value="2021-03-31" required>
    </div>
</div>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    //Donut Chart Construction
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    
    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Status',  'Quantidade'],
            ['Em Processamento',   1],
            ['Reprovada',          2],
            ['Aprovada',          12],
            ['Em Trânsito',       21],
            ['Entregue',          35],
            ['Em Troca',           3],
            ['Troca Autorizada',  17]
        ]);

        var options = {
            title: 'Vendas por Status',
            titleTextStyle: {
                bold: false,
                fontName: 'poppins',
                color: '#111111',
                fontSize: 18,
            },
            chartArea: {width: '70%'},
            colors: ['lightskyblue', 'red', 'cornflowerblue', 'orange', 'green', 'yellow', 'greenyellow'],
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
        var data = google.visualization.arrayToDataTable([
            ['Mês', 'Clientes', 'Produtos', 'Vendas'],
            ['Jan/2021', 15, 80, 14],
            ['Fev/2021', 12, 33, 29],
            ['Mar/2021', 200, 345, 109]
        ]);

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
        var data = google.visualization.arrayToDataTable([
            ['Mês/Ano', 'Vendido', 'Descontado', 'Faturado'],
            ['Out/20',  130000,      10000,         120000],
            ['Nov/20',  70000,      11000,        59000],
            ['Dez/20',  255000,      27000,        228000],
            ['Jan/21',  108000,      9000,        99000],
            ['Fev/21',  204000,      47000,        157000],
            ['Mar/21',  89000,      7000,         82000]
        ]);

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
</script>