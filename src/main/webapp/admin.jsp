<%@ include file="header.jsp" %>
<%
    String temp =       null;
    if(temp == null)     temp = "";
%>

<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Administração</h2>
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
                        <li class="col-12"><a href="#tab_dashboard"         data-toggle="tab">Dashboard</a></li>
                        <li class="col-12"><a href="#tab_log"               data-toggle="tab">Log Sistêmico</a></li>
                        <li class="col-12"><a href="#tab_parametros"        data-toggle="tab">Parâmetros</a></li>
                        <li class="col-12"><a href="#tab_produtos"          data-toggle="tab">Produtos</a></li>
                        <li class="col-12"><a href="#tab_ranking"           data-toggle="tab">Ranking</a></li>
                        <li class="col-12"><a href="#tab_vendas"            data-toggle="tab">Vendas</a></li>
                        <li class="col-12"><a href="login.jsp">Sair</a></li>
                    </ul>
                </nav>
            </div>
                
            <div class="col-10 tab-content">
                <div class="tab-pane active text-style" id="tab_clientes">
                    <%@ include file="tabela_cliente.jsp" %>
                </div>
                
                <div class="tab-pane text-style" id="tab_dashboard">
                    <%@ include file="dashboard.jsp" %>
                </div>
                
                <div class="tab-pane text-style" id="tab_log">
                    <%@ include file="tabela_log.jsp" %>
                </div>
                
                <div class="tab-pane text-style" id="tab_parametros">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="#">
                                <div class="row">
                                    <div class="col-3">
                                        <h2 class="title">Produto</h2>
                                        <hr style="border: none">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <h3>Prazo no Carrinho (Horas)</h3>
                                        <input class="form-control" placeholder="Horas" type="number" min="0" maxlength="4" name="par_1" value="<%=temp%>" required>
                                    </div>
                                    <div class="col-6">
                                        <h3>Valor Mínimo de Vendas para Itens sem Estoque</h3>
                                        <input class="form-control" placeholder="Mínimo" type="number" min="0" maxlength="4" name="par_2" value="<%=temp%>" required>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-3">
                                        <h2 class="title">Precificação</h2>
                                        <hr style="border: none">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <h3>Padrão</h3>
                                        <input class="form-control" placeholder="Margem de Lucro %" type="number" min="0" maxlength="3" name="gp_1" value="<%=temp%>" required>
                                    </div>
                                    <div class="col-6">
                                        <h3>Promoção</h3>
                                        <input class="form-control" placeholder="Margem de Lucro %" type="number" min="0" maxlength="3" name="gp_2" value="<%=temp%>" required>
                                    </div>
                                    <div class="col-6">
                                        <h3>Grupo X</h3>
                                        <input class="form-control" placeholder="Margem de Lucro %" type="number" min="0" maxlength="3" name="gp_3" value="<%=temp%>" required>
                                    </div>
                                    <div class="col-12">
                                        <button class="send" name="operacao" value="ALTERAR">Salvar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_produtos">
                    <%@ include file="tabela_produto.jsp" %>
                    <form class="main_form" action="form_produto.jsp">
                        <div class="row">
                            <div class="col-12">
                                <hr style="border: none">
                                <table class="float-left">
                                    <th>Legenda: </th>
                                    <td><div class="circle green"></div></td><td>Ativo</td>
                                    <td><div class="circle grey"></div></td><td>Inativo</td>
                                    <td><div class="circle orange"></div></td><td>Em Liberação</td>
                                </table>
                                <button class="send float-right" name="operacao" value="SALVAR">+ Novo</button>
                            </div>
                        </div>
                    </form>
                </div>
                
                <div class="tab-pane text-style" id="tab_ranking">
                    <div class="row">
                        <div class="col-12">
                            <div class="col-5"><h2>Clientes Fiéis do Mês de Março!</h2><hr></div>
                        </div>
                        <div class="col-4">
                            <center>
                                <div class="col-7">
                                    <img src="images/bronze-medal.png" alt="img" />
                                </div>
                                <h2>#3</h2>
                                <strong>Leila Goncalves Pereira</strong><br>
                                <span>R$ 20.000,00</span>
                                <hr style="border: none">
                                <button class="send">Presentear com Vale</button>
                            </center>
                        </div>
                        <div class="col-4">
                            <center>
                                <div class="col-7">
                                    <img src="images/gold-medal.png" alt="img" />
                                </div>
                                <h2>#1</h2>
                                <strong>Nicolas Ferreira da Silva</strong><br>
                                <span>R$ 60.000,00</span>
                                <hr style="border: none">
                                <button class="send">Presentear com Vale</button>
                            </center>
                        </div>
                        <div class="col-4">
                            <center>
                                <div class="col-7">
                                    <img src="images/silver-medal.png" alt="img" />
                                </div>
                                <h2>#2</h2>
                                <strong>Julia Rodrigues Souza</strong><br>
                                <span>R$ 40.000,00</span>
                                <hr style="border: none">
                                <button class="send">Presentear com Vale</button>
                            </center>
                        </div>
                    </div>
                </div>
                    
                <div class="tab-pane text-style" id="tab_vendas">
                    <%@ include file="tabela_venda.jsp" %>
                    <div class="row">
                        <div class="col-12">
                            <hr style="border: none">
                        </div>
                        <div class="col-12">
                            <table class="float-right">
                                <th>Legenda: </th>
                                <td><div class="circle lightblue">  </div></td><td>Em Processamento</td>
                                <td><div class="circle red">        </div></td><td>Reprovada</td>
                                <td><div class="circle blue">       </div></td><td>Aprovada</td>
                                <td><div class="circle orange">     </div></td><td>Em Trânsito</td>
                                <td><div class="circle green">      </div></td><td>Entregue</td>
                                <td><div class="circle yellow">     </div></td><td>Em Troca</td>
                                <td><div class="circle lightgreen"> </div></td><td>Troca Autorizada</td>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_no_content">
                    <div class="row">
                        <div class="col-md-12">
                            <center><figure><img src="images/no_content.png" alt="img" /></figure>
                            <h3>Ops! Parece que o conteúdo saiu voando.</h3></center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script>
    $(".nav-sidebar li a").on('click', function(e){
        $(".nav-sidebar .active").removeClass('active');
        $(this).parent().addClass('active');
    });
</script>
<script src="js/tabela_cliente.js"></script>
<script src="js/tabela_log.js"></script>
<script src="js/tabela_produto.js"></script>
<script src="js/tabela_venda.js"></script>