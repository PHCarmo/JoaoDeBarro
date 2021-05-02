<%@ include file="header.jsp" %>
<%
    String operacao =       request.getParameter("operacao");
    String nome =           request.getParameter("cli_nome");
    String cpf =            request.getParameter("cli_cpf");
    String id_genero =      request.getParameter("cli_gen_id");
    String id_tel_tipo =    request.getParameter("cli_tel_tte_id");
    String tel_ddd =        request.getParameter("cli_tel_ddd");
    String tel_numero =     request.getParameter("cli_tel_numero");
    String dt_nasc =        request.getParameter("cli_dt_nascimento");
    
    if(operacao == null)    operacao = "";
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
                    <h2>Produto</h2>
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
                <form class="main_form" method="POST" action="#">
                    <div class="row">                        
                        <div class="col-12">
                            <h2>Dados Próprios<strong class="color-red">*</strong></h2>
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="cli_gen_id">
                                <option value="">Selecione o Tipo</option>
                                <option value="1" <%= id_genero.equals("1") ? "selected" : "" %>>Piso</option>
                                <option value="2" <%= id_genero.equals("2") ? "selected" : "" %>>Resvestimento</option>
                            </select>
                        </div>
                        <div class="col-6">
                            <input class="form-control" placeholder="Descrição" type="text" maxlength="100" name="cli_nome" value="<%=nome%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Marca" type="text" maxlength="11" name="cli_cpf" value="<%=cpf%>" required>
                        </div>
                        
                        <div class="col-12">
                            <h2>Identificação<strong class="color-red">*</strong></h2>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Cor/Tonalidade" type="text" maxlength="15" name="cli_cpf" value="<%=cpf%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Material" type="text" maxlength="11" name="cli_cpf" value="<%=cpf%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Comprimento" type="text" maxlength="100" name="cli_nome" value="<%=nome%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Largura" type="text" maxlength="11" name="cli_cpf" value="<%=cpf%>" required>
                        </div>
                        <div class="col-7">
                            <input class="form-control" placeholder="Código de Barras" type="text" maxlength="11" name="cli_cpf" value="<%=cpf%>" required>
                        </div>
                        <div class="col-2">
                            <select class="form-control" name="cli_gen_id">
                                <option value="">PEI</option>
                                <option value="1" <%= id_genero.equals("1") ? "selected" : "" %>>0</option>
                                <option value="2" <%= id_genero.equals("2") ? "selected" : "" %>>1</option>
                                <option value="2" <%= id_genero.equals("3") ? "selected" : "" %>>2</option>
                                <option value="2" <%= id_genero.equals("4") ? "selected" : "" %>>3</option>
                                <option value="2" <%= id_genero.equals("5") ? "selected" : "" %>>4</option>
                                <option value="2" <%= id_genero.equals("6") ? "selected" : "" %>>5</option>
                            </select>
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="cli_gen_id">
                                <option value="">Grupo de Precificação</option>
                                <option value="1" <%= id_genero.equals("1") ? "selected" : "" %>>Padrão</option>
                                <option value="2" <%= id_genero.equals("2") ? "selected" : "" %>>Promoção</option>
                                <option value="2" <%= id_genero.equals("3") ? "selected" : "" %>>Grupo X</option>
                            </select>
                        </div>
                                                
                        <div class="col-12">
                            <h2>Categorias<strong class="color-red">*</strong> 
                                <a href="#" class="add_end_fields"><img src="icon/plus.png" /></a>
                                <a href="#" class="rem_end_fields"><img src="icon/minus.png" /></a>
                            </h2>
                        </div>
                        <div class="col-3 end-1">
                            <select class="form-control" name="cli_tel_tte_id">
                                <option value="">Selecione uma Categoria</option>
                                <option value="1" <%= id_tel_tipo.equals("1") ? "selected" : "" %>>Porcelanato</option>
                                <option value="2" <%= id_tel_tipo.equals("2") ? "selected" : "" %>>Azulejo</option>
                                <option value="3" <%= id_tel_tipo.equals("3") ? "selected" : "" %>>Revestimento Interno</option>
                                <option value="3" <%= id_tel_tipo.equals("4") ? "selected" : "" %>>Revestimento Externo</option>
                                <option value="3" <%= id_tel_tipo.equals("5") ? "selected" : "" %>>Ladrilho</option>
                                <option value="3" <%= id_tel_tipo.equals("6") ? "selected" : "" %>>Mosaico</option>
                                <option value="3" <%= id_tel_tipo.equals("7") ? "selected" : "" %>>Piso Cerâmico</option>
                                <option value="3" <%= id_tel_tipo.equals("8") ? "selected" : "" %>>Piso Vinílico</option>
                                <option value="3" <%= id_tel_tipo.equals("9") ? "selected" : "" %>>Piso Laminado</option>
                                <option value="3" <%= id_tel_tipo.equals("10") ? "selected" : "" %>>Pedras Naturais</option>
                                <option value="3" <%= id_tel_tipo.equals("11") ? "selected" : "" %>>Faixas</option>
                                <option value="3" <%= id_tel_tipo.equals("12") ? "selected" : "" %>>Filetes</option>
                                <option value="3" <%= id_tel_tipo.equals("13") ? "selected" : "" %>>Pastilha</option>
                                <option value="3" <%= id_tel_tipo.equals("14") ? "selected" : "" %>>Rodapé</option>
                                <option value="3" <%= id_tel_tipo.equals("15") ? "selected" : "" %>>Soleira</option>
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
        
        var wrapper;
        var fields;
        var y = 1;
        $(".add_end_fields").click(function(e){
            e.preventDefault();
            if(true){
                wrapper = $("div.end-" + y).last();
                fields = $("div.end-" + y).html(); y++;
                $(wrapper).after('<div class="col-3 end-' + y + '">' + fields + '</div>');
            }
        });

        $(this).on("click",".rem_end_fields", function(e){
            e.preventDefault();
            if(y > 1){ $('.end-' + y).remove(); y--; }
        })
    });
</script>
