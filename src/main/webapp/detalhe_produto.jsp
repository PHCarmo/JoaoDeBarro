<%@ include file="header.jsp" %>
<%
    String operacao =       request.getParameter("operacao");
    String prd_id =         request.getParameter("cli_id");
    String nome =           request.getParameter("cli_nome");
    String cpf =            request.getParameter("cli_cpf");
    String id_genero =      request.getParameter("cli_gen_id");
    String id_tel_tipo =    request.getParameter("cli_tel_tte_id");
    String tel_ddd =        request.getParameter("cli_tel_ddd");
    String tel_numero =     request.getParameter("cli_tel_numero");
    String dt_nasc =        request.getParameter("cli_dt_nascimento");
    
    if(operacao == null)    operacao = "";
    if(prd_id == null)      prd_id = "";
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
                <form class="main_form" method="POST" action="carrinho.jsp">
                    <div class="row">
                        <div class="col-7" style="align-self: center;">
                            <center><img src="images/produtos/1.png" alt="img" /></center>
                        </div>
                        <div class="col-5">
                            <div class="col-12">
                                <h2>
                                    <span>Porcelanato</span>
                                    <strong class="float-right">Piso</strong>
                                    <hr>
                                </h2>
                            </div>
                            <div class="col-12">
                                <h4>
                                    <strong>Marca: </strong>
                                    <span>Colormix</span>
                                    <a class="invisible">-----</a>
                                    <strong>PEI: </strong>
                                    <span>3</span>
                                </h4>
                                <h4>
                                    <strong>Material: </strong>
                                    <span class="float-right">Porcelanato</span>
                                </h4>
                                <h4>
                                    <strong>Dimensões: </strong>
                                    <span class="float-right">60 X 60 cm</span>
                                </h4>
                                <h4>
                                    <strong>Cor/Tonalidade: </strong>
                                    <span class="float-right">Branco</span>
                                </h4>
                                <h4>
                                    <strong>Preço Unitário: </strong>
                                    <span class="float-right">R$ 99,90</span>
                                </h4>
                                <h4>
                                    <strong>Código de Barras: </strong>
                                    <span class="float-right">568754456745</span>
                                    <hr style="border: none">
                                    <hr style="border: none">
                                </h4>
                            </div>
                            <div class="col-12">
                                <h4>
                                    <strong>Quantidade: </strong>
                                    <input class="form-control-sm float-right" type="number" value="1" min="1" style="width: 100px;">
                                </h4>
                                <h4>
                                    <strong>Preço Total: </strong>
                                    <span class="float-right">R$ 99,90</span>
                                </h4>
                            </div>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                            <button class="send float-right" name="operacao" value="ADICIONAR">Adicionar ao Carrinho!</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end contact -->
<%@ include file="footer.jsp" %>
