    <%@ include file="header.jsp" %>
<%
    String operacao =       request.getParameter("operacao");
    String cli_id =         request.getSession(false).getAttribute("cli_id").toString();
    String nome =           request.getParameter("cli_nome");
    String cpf =            request.getParameter("cli_cpf");
    String id_genero =      request.getParameter("cli_gen_id");
    String id_tel_tipo =    request.getParameter("cli_tel_tte_id");
    String tel_ddd =        request.getParameter("cli_tel_ddd");
    String tel_numero =     request.getParameter("cli_tel_numero");
    String dt_nasc =        request.getParameter("cli_dt_nascimento");
    
    if(operacao == null)    operacao = "";
    if(cli_id == null)      cli_id = "";
    if(nome == null)        nome = "";
    if(cpf == null)         cpf = "";
    if(id_genero == null)   id_genero = "";
    if(id_tel_tipo == null) id_tel_tipo = "";
    if(tel_ddd == null)     tel_ddd = "";
    if(tel_numero == null)  tel_numero = "";
    if(dt_nasc == null)     dt_nasc = "";
%>

<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Endereço</h2>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- contact -->
<div class="contact">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <form class="main_form" method="POST" action="./endereco">
                    <div class="row">
                        <div class="col-12">
                            <input class="form-control" type="hidden" name="cli_id" value="<%=cli_id%>">
                        </div>
                        
                        <div class="col-12">
                            <h2>Dados Próprios<strong class="color-red">*</strong></h2>
                        </div>
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
                            <select class="form-control" name="end_proposito" readonly>
                                <option value="">Selecione o Propósito</option>
                                <option value="1">Entrega e Cobrança</option>
                                <option value="2">Somente Entrega</option>
                                <option value="3">Somente Cobrança</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button class="send" name="operacao" value=<%= operacao.equals("VISUALIZAR") ? "'VISUALIZAR' onclick='history.back();'>Voltar" : "'SALVAR'>Salvar" %></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end contact -->
<%@ include file="footer.jsp" %>
<script>
    $(document).ready(function() {
        <%= operacao.equals("VISUALIZAR") ? "$('input').prop('disabled', true); $('select').addClass('disabled');" : "" %>
    });
</script>
