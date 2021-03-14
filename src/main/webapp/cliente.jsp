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
                        <li class="col-12 active"><a href="#tab1"       data-toggle="tab">Cadastro</a></li>
                        <li class="col-12"><a href="carrinho.jsp"                        >Carrinho</a></li>
                        <li class="col-12"><a href="#tab_no_content"    data-toggle="tab">Cartões</a></li>
                        <li class="col-12"><a href="#tab_no_content"    data-toggle="tab">Compras</a></li>
                        <li class="col-12"><a href="#tab2"              data-toggle="tab">Endereços</a></li>
                        <li class="col-12"><a href="#tab_no_content"    data-toggle="tab">Transações</a></li>
                        <li class="col-12"><a href="#tab_no_content"    data-toggle="tab">Ranking</a></li>
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
                
                <div class="tab-pane active text-style" id="tab1">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="./Cliente">
                                <div class="row">
                                    <div class="col-12">
                                        <input class="form-control" type="hidden" name="cli_id" value="<%=cli_id%>">
                                        <input class="form-control" type="hidden" name="cli_usu_id" value="<%=cli_usu_id%>">
                                    </div>

                                    <div class="col-12">
                                        <h2>Dados Pessoais<strong class="red">*</strong></h2>
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
                                        <h2>Telefone<strong class="red">*</strong></h2>
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
                <div class="tab-pane text-style" id="tab2">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="#">
                                <div class="row">
                                    <div class="col-12">
                                        <input class="form-control" type="hidden" name="cli_id">
                                    </div>
                                    <div class="col-12">
                                        <h2>Endereço 
                                            <a href="#" class="add_end_fields"><img src="icon/plus.png" /></a>
                                            <a href="#" class="rem_end_fields"><img src="icon/minus.png" /></a>
                                        </h2>
                                    </div>
                                </div>
                                <div class="row end end-1">
                                    <div class="col-5">
                                        <input class="form-control" placeholder="Apelido" type="text" maxlength="20" name="end_nome">
                                    </div>
                                    <div class="col-2">
                                        <input class="form-control" placeholder="CEP" type="text" maxlength="8" name="end_cep">
                                    </div>
                                    <div class="col-5">
                                        <input class="form-control" placeholder="Bairro" type="text" maxlength="30" name="end_bairro">
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="end_tlo_id">
                                            <option value="">Tipo de Logradouro</option>
                                            <option value="1">Alameda</option>
                                            <option value="2">Avenida</option>
                                            <option value="3">Estrada</option>
                                            <option value="4">Rodovia</option>
                                            <option value="5">Rua</option>
                                            <option value="6">Travessa</option>
                                            <option value="7">Via</option>
                                            <option value="8">Viaduto</option>
                                        </select>
                                    </div>
                                    <div class="col-4">
                                        <input class="form-control" placeholder="Logradouro" type="text" maxlength="40" name="end_logradouro">
                                    </div>
                                    <div class="col-2">
                                        <input class="form-control" placeholder="Número" type="text" maxlength="10" name="end_numero">
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="end_tre_id">
                                            <option value="">Tipo de Residência</option>
                                            <option value="1">Apartamento</option>
                                            <option value="2">Casa</option>
                                            <option value="3">Condomínio</option>
                                            <option value="4">Sobrado</option>
                                        </select>
                                    </div>
                                    <div class="col-4">
                                        <input class="form-control" placeholder="Cidade" type="text" maxlength="30" name="end_cidade">
                                    </div>
                                    <div class="col-3">
                                        <input class="form-control" placeholder="Estado" type="text" maxlength="30" name="end_estado">
                                    </div>
                                    <div class="col-2">
                                        <input class="form-control" placeholder="País" type="text" maxlength="30" name="end_pais">
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="end_ten_id">
                                            <option value="">Selecione o Tipo</option>
                                            <option value="1">Referência</option>
                                            <option value="2">Residencial</option>
                                        </select>
                                    </div>
                                    <div class="col-9">
                                        <input class="form-control" placeholder="Observação" type="text" maxlength="50" name="end_observacao"></textarea>
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="end_proposito">
                                            <option value="">Selecione o Propósito</option>
                                            <option value="1">Entrega</option>
                                            <option value="2">Cobrança</option>
                                            <option value="3">Entrega e Cobrança</option>
                                        </select>
                                    </div>
                                </div>
                            </form>
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
    $(document).ready(function() {
        $('.end input').prop('disabled', true); $('.end select').addClass('disabled');
        
        $(".fancybox").fancybox({
            openEffect: "none",
            closeEffect: "none"
        });

        $(".zoom").hover(function() {
            $(this).addClass('transition');
        }, function() {
            $(this).removeClass('transition');
        });
        
        var wrapper;
        var fields;
        var y = 1;
        $(".add_end_fields").click(function(e){
            e.preventDefault();
            if(true){
                wrapper = $("div.end-" + y).last();
                fields = $("div.end-" + y).html(); y++;
                $(wrapper).after('<hr class="col-12 end-' + y + '"><div class="row end end-' + y + '">' + fields + '</div>');
            }
        });

        $(this).on("click",".rem_end_fields", function(e){
            e.preventDefault();
            if(y > 1){ $('.end-' + y).remove(); y--; }
        })
    });
    
    $(".nav-sidebar li a").on('click', function(e){
        $(".nav-sidebar .active").removeClass('active');
        $(this).parent().addClass('active');
    });
</script>
