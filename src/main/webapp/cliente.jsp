<%@ include file="header.jsp" %>
<%
    String temp =           null;
    String cli_usu_id =     request.getParameter("cli_usu_id");
    String cli_id =         request.getParameter("cli_id");
    String nome =           request.getParameter("cli_nome");
    String cpf =            request.getParameter("cli_cpf");
    String id_genero =      request.getParameter("cli_gen_id");
    String id_tel_tipo =    request.getParameter("cli_tel_tte_id");
    String tel_ddd =        request.getParameter("cli_tel_ddd");
    String tel_numero =     request.getParameter("cli_tel_numero");
    String dt_nasc =        request.getParameter("cli_dt_nascimento");
    
    if(cli_usu_id == null)  cli_usu_id = "";
    if(cli_id == null)      cli_id = "";
    if(nome == null)        nome = "";
    if(cpf == null)         cpf = "";
    if(id_genero == null)   id_genero = "";
    if(id_tel_tipo == null) id_tel_tipo = "";
    if(tel_ddd == null)     tel_ddd = "";
    if(tel_numero == null)  tel_numero = "";
    if(dt_nasc == null)     dt_nasc = "";
    if(temp == null)        temp = "";
%>

<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Perfil</h2>
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
                        <li class="col-12"><a href="#tab_alter_pass"    data-toggle="tab">Alterar Senha</a></li>
                        <li class="col-12 active"><a href="#tab_dados"  data-toggle="tab">Cadastro</a></li>
                        <li class="col-12"><a href="carrinho.jsp"                        >Carrinho</a></li>
                        <li class="col-12"><a href="#tab_cartao"        data-toggle="tab">Cartões</a></li>
                        <li class="col-12"><a href="#tab_compra"    data-toggle="tab">Compras</a></li>
                        <li class="col-12"><a href="#tab_endereco"      data-toggle="tab">Endereços</a></li>
                        <li class="col-12"><a href="#tab_no_content"    data-toggle="tab">Ranking</a></li>
                        <li class="col-12"><a href="#tab_vale"          data-toggle="tab">Vale-Troca</a></li>
                        <li class="col-12"><a href="login.jsp">Sair</a></li>
                    </ul>
                </nav>
            </div>
            
            <div class="col-10 tab-content">
                <div class="tab-pane text-style" id="tab_alter_pass">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="#">
                                <div class="row">
                                    <div class="col-6">
                                        <h3>Me conta, para qual senha deseja trocar?</h3>
                                        <input class="form-control" placeholder="Nova Senha" type="password" maxlength="30" name="par_2" value="<%=temp%>" required>
                                    </div>
                                    <div class="col-6">
                                        <h3>Por segurança, informe a senha novamente</h3>
                                        <input class="form-control" placeholder="Confirmar Nova Senha" type="password" maxlength="30" name="gp_1" value="<%=temp%>" required>
                                    </div>
                                    <div class="col-6">
                                        <h3>Hmm, acho que me esqueci...
                                        <p></p>Qual a sua senha atual mesmo?</h3>
                                        <input class="form-control" placeholder="Senha Antiga" type="password" maxlength="30" name="par_1" value="<%=temp%>" required>
                                    </div>
                                    <div class="col-6"></div>
                                    <div class="col-12">
                                        <button class="send" name="operacao" value="ALTERAR">Salvar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane active text-style" id="tab_dados">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="./Cliente">
                                <div class="row">
                                    <div class="col-12">
                                        <input class="form-control" type="hidden" name="cli_id" value="<%=cli_id%>">
                                        <input class="form-control" type="hidden" name="cli_usu_id" value="<%=cli_usu_id%>">
                                    </div>

                                    <div class="col-12">
                                        <h2>Dados Pessoais<strong class="color-red">*</strong></h2>
                                    </div>
                                    <div class="col-9">
                                        <input class="form-control" placeholder="Nome Completo" type="text" maxlength="100" name="cli_nome" value="<%=nome%>" required>
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="cli_gen_id">
                                            <option value="">Selecione seu Gênero</option>
                                            <option value="1" <%= id_genero.equals("1") ? "selected" : "" %>>Feminino</option>
                                            <option value="2" <%= id_genero.equals("2") ? "selected" : "" %>>Masculino</option>
                                        </select>
                                    </div>
                                    <div class="col-6">
                                        <input class="form-control" placeholder="CPF" type="text" maxlength="11" name="cli_cpf" value="<%=cpf%>" required>
                                    </div>
                                    <div class="col-6">
                                        <input class="form-control" placeholder="Data de Nascimento" type="date" name="cli_dt_nascimento"
                                               onfocus="(this.type='date')" onblur="if(this.value=='')this.type='text'" value="<%=dt_nasc%>" required>
                                    </div>

                                    <div class="col-12">
                                        <h2>Telefone<strong class="color-red">*</strong></h2>
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="cli_tel_tte_id">
                                            <option value="">Selecione o Tipo</option>
                                            <option value="1" <%= id_tel_tipo.equals("1") ? "selected" : "" %>>Celular</option>
                                            <option value="2" <%= id_tel_tipo.equals("2") ? "selected" : "" %>>Fixo</option>
                                            <option value="3" <%= id_tel_tipo.equals("3") ? "selected" : "" %>>VoIP</option>
                                        </select>
                                    </div>
                                    <div class="col-2">
                                        <input class="form-control" placeholder="DDD" type="text" maxlength="3" name="cli_tel_ddd" value="<%=tel_ddd%>" required>
                                    </div>
                                    <div class="col-7">
                                        <input class="form-control" placeholder="Número" type="text" maxlength="9" name="cli_tel_numero" value="<%=tel_numero%>" required>
                                    </div>
                                    <div class="col-12">
                                        <button class="send" name="operacao" value="ALTERAR">Salvar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_cartao">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="form_cartao.jsp">
                                <div class="row">
                                    <div class="col-4">
                                        <div class="card">
                                            <div class="card-body">
                                                <h2>4256 9097 4245 5368</h2>
                                                <strong>Julia Rodrigues Souza</strong><br>
                                                <span><strong>Validade: </strong>11/2023</span>
                                                <span class="float-right"><strong>CVV: </strong>755</span>
                                                <hr style="border: none">
                                                <img class='icon' src='icon/mastercard.png' />
                                                <a class='btn btn-default float-right' title='Editar' href='#'><img class='icon' src='icon/pencil.png' /></a>
                                                <a class='btn btn-default float-right' title='Remover' href='#'><img class='icon' src='icon/remove.png' /></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <div class="card">
                                            <!--<img class="card-img-top" src="icon/favicon.png" alt="Title">-->
                                            <div class="card-body">
                                                <h2>4026 6964 6333 4307</h2>
                                                <strong>Nicolas Ferreira da Silva</strong><br>
                                                <span><strong>Validade: </strong>11/2023</span>
                                                <span class="float-right"><strong>CVV: </strong>808</span>
                                                <hr style="border: none">
                                                <img class='icon' src='icon/visa.png' />
                                                <a class='btn btn-default float-right' title='Editar' href='#'><img class='icon' src='icon/pencil.png' /></a>
                                                <a class='btn btn-default float-right' title='Remover' href='#'><img class='icon' src='icon/remove.png' /></a>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-12">
                                        <hr style="border: none">
                                        <button class="send float-right" name="operacao" value="SALVAR" id="novo_cartao">+ Novo</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_compra">
                    <%@ include file="tabela_compra.jsp" %>
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
                
                <div class="tab-pane text-style" id="tab_endereco">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="form_endereco.jsp">
                                <div class="row">
                                    <div class="col-4">
                                        <div class="card">
                                            <div class="card-body">
                                                <h2>Minha Casa</h2>
                                                <strong>Rua da Imprensa, Nº 200</strong><br>
                                                <span>Bloco C, Monte Castelo, Campo Grande/MS</span>
                                                <hr style="border: none">
                                                <div class="circle brown float-left"></div>
                                                <a class='btn btn-default float-right' title='Editar' href='#'><img class='icon' src='icon/pencil.png' /></a>
                                                <a class='btn btn-default float-right' title='Remover' href='#'><img class='icon' src='icon/remove.png' /></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <div class="card">
                                            <!--<img class="card-img-top" src="icon/favicon.png" alt="Title">-->
                                            <div class="card-body">
                                                <h2>Casa da Sogra</h2>
                                                <strong>Avenida Tocantins, Nº 10</strong><br>
                                                <span>Portão Azul, Vila Jardim Rio Claro, Jataí/GO</span>
                                                <hr style="border: none">
                                                <div class="circle brown float-left"></div>
                                                <div class="float-left"><a class="invisible">,</a></div>
                                                <div class="circle lightbrown float-left"></div>
                                                <a class='btn btn-default float-right' title='Editar' href='#'><img class='icon' src='icon/pencil.png' /></a>
                                                <a class='btn btn-default float-right' title='Remover' href='#'><img class='icon' src='icon/remove.png' /></a>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-12">
                                        <hr style="border: none">
                                        <table class="float-left">
                                            <th>Legenda: </th>
                                            <td><div class="circle brown"></div></td><td>Entrega</td>
                                            <td><div class="circle lightbrown"></div></td><td>Cobrança</td>
                                        </table>
                                        <button class="send float-right" name="operacao" value="SALVAR" id="novo_endereco">+ Novo</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_vale">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-12">
                                    <h3>Trocas de itens ou compras geram um vale-troca que dão descontos nas suas próximas compras!</h3>
                                </div>
                                <div class="col-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <h2>VLT3256</h2>
                                            <span><strong>Valor: </strong>R$30,00</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <h2>VLT2794</h2>
                                            <span><strong>Valor: </strong>R$15,00</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <h2>VLT7034</h2>
                                            <span><strong>Valor: </strong>R$5,00</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
<script src="js/tabela_compra.js"></script>