<%@ include file="header.jsp" %>
<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Carrinho</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="contact">
    <div class="container">
        <div class="row">
            <div class="col-4">
                <form class="main_form" action="#" method="POST">
                    <div class="row">
                        <h2 class="col-12">Checkout</h2>
                        <div class="col-12 text-justify">
                            <strong class="ornage_color">Aten��o!</strong>
                            <span>Antes de finalizar a compra revise atentamente os itens � direita.</span>
                            <hr style="border: none">
                        </div>
                        
                        <!-- Modal de Cadastro de Endere�o -->
                        <div style="display: none;max-width: 450px;" id="modal-add-endereco" >
                            <h3 class="col-12">Deseja abandonar o Checkout?</h3>
                            <div class="col-12 text-justify">
                                <span>Voc� ser� redirecionado para o cadastro de um novo endere�o. <strong>Tem certeza?</strong></span>
                                <hr style="border: none">
                            </div>
                            <div class="col-12">
                                <a class="float-left" data-fancybox-close href="javascript:;"><strong>Ficar Aqui</strong></a>
                                <a href="form_endereco.jsp"><strong class="ornage_color float-right">Absoluta!</strong></a>
                        </div>
                        </div>
                        <!-- ########## -->
                        
                        <h2 class="col-12">Entrega <a data-fancybox class="add-endereco-show" href="javascript:;"><img src="icon/plus.png" /></a></h2>
                        <div class="col-12">
                            <table class="table dataTable">
                                <tr role="row">
                                    <td><input type="radio" name="entrega"></td>
                                    <td>
                                        <strong>Minha Casa</strong><br>
                                        <span>Rua da Imprensa, N� 200 - Bloco C, Monte Castelo, Campo Grande/MS</span>
                                    </td>
                                </tr>
                                <tr role="row">
                                    <td><input type="radio" name="entrega"></td>
                                    <td>
                                        <strong>Casa da Sogra</strong><br>
                                        <span>Avenida Tocantins, N� 10 - Port�o Azul, Vila Jardim Rio Claro, Jata�/GO</span>
                                    </td>
                                </tr>
                            </table>
                        </div>

                        <h2 class="col-12">Cobran�a <a data-fancybox class="add-endereco-show" href="javascript:;"><img src="icon/plus.png" /></a></h2>
                        <div class="col-12">
                            <table class="table dataTable">
                                <tr role="row">
                                    <td><input type="radio" name="cobranca"></td>
                                    <td>
                                        <strong>Casa da Sogra</strong><br>
                                        <span>Avenida Tocantins, N� 10 - Port�o Azul, Vila Jardim Rio Claro, Jata�/GO</span>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                        </div>
                        
                        <h2 class="col-12">Descontos</h2>
                        <div class="col-7">
                            <input class="form-control" placeholder="Cupom" type="text" name="usu_si_email" maxlength="10" style="margin: 0px 0px 15px;">
                        </div>
                        <div class="col-5">
                            <button class="send" name="operacao" value="#">Validar</button>
                        </div>
                        <h4 class="col-12">Vale-Troca Dispon�vel</h4>
                        <div class="col-12">
                            <p><input type="checkbox"> VLT3256 - R$30,00</p>
                            <p><input type="checkbox"> VLT2794 - R$15,00</p>
                            <p><input type="checkbox"> VLT7034 - R$5,00</p>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                        </div>
                        
                        <!-- Modal de Cadastro de Endere�o -->
                        <div style="display: none;max-width: 450px;" id="modal-add-cartao" >
                            <h3 class="col-12">Deseja abandonar o Checkout?</h3>
                            <div class="col-12 text-justify">
                                <span>Voc� ser� redirecionado para o cadastro de um novo cart�o de cr�dito. <strong>Tem certeza?</strong></span>
                                <hr style="border: none">
                            </div>
                            <div class="col-12">
                                <a class="float-left" data-fancybox-close href="javascript:;"><strong>Ficar Aqui</strong></a>
                                <a href="form_cartao.jsp"><strong class="ornage_color float-right">Absoluta!</strong></a>
                            </div>
                        </div>
                        <!-- ########## -->
                        
                        <h2 class="col-12">Pagamento <a data-fancybox class="add-cartao-show" href="javascript:;"><img src="icon/plus.png" /></a></h2>
                        <div class="col-12">
                            <table class="table dataTable">
                                <tr role="row">
                                    <td><input type="radio" name="pagamento"></td>
                                    <td>
                                        <strong>4256 9097 4245 5368</strong><br>
                                        <span>Julia Rodrigues Souza</span><br>
                                        <span><strong>Validade: </strong>11/2023</span>
                                        <span class="float-right"><strong>CVV: </strong>755</span>
                                    </td>
                                </tr>
                                <tr role="row">
                                    <td><input type="radio" name="pagamento"></td>
                                    <td>
                                        <strong>4026 6964 6333 4307</strong><br>
                                        <span>Nicolas Ferreira da Silva</span><br>
                                        <span><strong>Validade: </strong>11/2023</span>
                                        <span class="float-right"><strong>CVV: </strong>808</span>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                        </div>
                        
                        <h2 class="col-12">Resumo</h2>
                        <div class="col-12">
                            <strong>Subtotal: </strong>
                            <span class="float-right">R$11.238,60</span><br>
                            <strong>Frete: </strong>
                            <span class="float-right">+ R$10,00</span><br>
                            <strong>Abatimentos: </strong>
                            <span class="float-right">- R$40,00</span><br>
                            <strong>Total: </strong>
                            <span class="float-right">R$11.208,60</span>
                        </div>
                        
                        <div class="col-12">
                            <hr style="border: none">
                            <button class="send" name="operacao" value="SALVAR">Finalizar!</button>
                        </div>
                    </div>
                </form>
            </div>
            
            <div class="row col align-items-center"></div>
            
            <div class="col-8">
                <form class="main_form" action="#" method="POST">
                    <div class="row">
                        <h2 class="col-12">Itens</h2>
                    </div>
                    <%@ include file="tabela_carrinho.jsp" %>
                    <div class="row">
                        <div class="col-12">
                            <hr style="border: none">
                            <button class="send float-right" name="operacao" value="ALTERAR">Salvar Altera��es</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script>
    $('.add-endereco-show').fancybox({
        "src": "#modal-add-endereco",
        "touch": false,
        "modal": true
        });
    $('.add-cartao-show').fancybox({
        "src": "#modal-add-cartao",
        "touch": false,
        "modal": true
    });
</script>
<script src="js/tabela_carrinho.js"></script>