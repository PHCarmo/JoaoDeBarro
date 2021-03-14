<%@ include file="header.jsp" %>
<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Administra��o</h2>
                </div>
            </div>
        </div>
    </div>

</div>
<div class="about">
    <div class="container">
        <div class="row">
            <div class="col-2">
                <nav class="nav-sidebar">
                    <ul class="nav tabs">
                        <li class="col-12 active"><a href="#tab_clientes"   data-toggle="tab">Clientes</a></li>
                        <li class="col-12"><a href="#tab_no_content"        data-toggle="tab">Estoque</a></li>
                        <li class="col-12"><a href="#tab_no_content"        data-toggle="tab">Log Sist�mico</a></li>
                        <li class="col-12"><a href="#tab_no_content"        data-toggle="tab">Par�metros</a></li>
                        <li class="col-12"><a href="#tab_no_content"        data-toggle="tab">Produtos</a></li>
                        <li class="col-12"><a href="#tab_no_content"        data-toggle="tab">Ranking</a></li>
                        <li class="col-12"><a href="#tab_no_content"        data-toggle="tab">Vendas</a></li>
                        <li class="col-12"><a href="login.jsp">Sair</a></li>
                    </ul>
                </nav>
            </div>
                
            <div class="col-10 tab-content">
                <div class="tab-pane active text-style" id="tab_clientes">
                    <%@ include file="tabela_cliente.jsp" %>
                </div>
                
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table order-column hover stripe" id="minhatable">
                                <thead class="">
                                    <tr>
                                        <th class="dt-center" scope="col">Status</th>
                                        <th class="" scope="col">ID</th>
                                        <th class="" scope="col">Usu�rio</th>
                                        <th class="" scope="col">Nome Completo</th>
                                        <th class="" scope="col">CPF</th>
                                        <th class="dt-center" scope="col">A��es</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_no_content">
                    <div class="row">
                        <div class="col-md-12">
                            <center><figure><img src="images/no_content.png" alt="img" /></figure>
                            <h3>Ops! Parece que o conte�do saiu voando.</h3></center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script>
    $(document).ready(function() {
        var end_wrapper;
        var y = 1;
        $(".add_end_fields").click(function(e){
            e.preventDefault();
                end_wrapper = $("div.end-" + y).last(); y++;                
                $(end_wrapper).after('<div class="col-3 end-' + y + '"><input class="form-control" placeholder="CEP" type="text" name="end_cep"></div><div class="col-6 end-' + y + '"><input class="form-control" placeholder="Cidade" type="text" name="end_cidade"></div><div class="col-3 end-' + y + '"><input class="form-control" placeholder="Estado" type="text" name="end_estado"></div><div class="col-9 end-' + y + '"><input class="form-control" placeholder="Logradouro" type="text" name="end_lograd"></div><div class="col-3 end-' + y + '"><input class="form-control" placeholder="N�mero" type="text" name="end_numero"></div><div class="col-9 end-' + y + '"><input class="form-control" placeholder="Complemento" type="text" name="end_comple"></div><div class="col-3 end-' + y + '"><select class="form-control" name="end_tipo"><option value="">Selecione o Tipo</option><option value="cpf">Entrega</option><option value="cnpj">Cobran�a</option><option value="cnpj">Entrega e Cobran�a</option></select><div class="nice-select form-control" tabindex="0"><span class="current">Selecione o Tipo</span><ul class="list"><li class="option selected" data-value="">Selecione o Tipo</li><li class="option " data-value="cpf">Entrega</li><li class="option " data-value="cnpj">Cobran�a</li><li class="option " data-value="cnpj">Entrega e Cobran�a</li></ul></div></div>');
        });

        $(this).on("click",".rem_end_fields", function(e){
            e.preventDefault();
            if(y > 1){ $('div.end-' + y).remove(); y--; }
        })
    });
    
    $(".nav-sidebar li a").on('click', function(e){
        $(".nav-sidebar .active").removeClass('active');
        $(this).parent().addClass('active');
    });
</script>
<script src="js/tabela_cliente.js"></script>
