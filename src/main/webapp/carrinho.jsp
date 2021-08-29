<%@ include file="header.jsp" %>
<%@ page import="br.com.fatecmc.joaodebarro.model.domain.*"%>
<%@ page import="br.com.fatecmc.joaodebarro.util.Mask"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
    Cliente clie = (Cliente) request.getAttribute("cliente");
    Carrinho carr = (Carrinho) request.getAttribute("carrinho");
    List<Cupom> cupons = (ArrayList<Cupom>) request.getAttribute("cupons");
    
    String error = (String) request.getAttribute("Error");
    StringBuilder content;
%>

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
                <form class="main_form" action="./pedido" method="POST">
                    <div class="row">
                        <!-- Modal de Alertas -->
                        <div style="display: none;max-width: 650px;" id="modal-error-alert" >
                            <h3 class="col-12">Algo deu errado!</h3>
                            <div class="col-12 text-justify">
                                <span><%= error != null ? error : "" %></span>
                                <hr style="border: none">
                            </div>
                            <div class="col-12">
                                <a data-fancybox-close href="javascript:;"><strong class="ornage_color float-right">OK!</strong></a>
                            </div>
                        </div>
                        <!-- End Modal -->
                        
                        <h2 class="col-12">Checkout</h2>
                        <div class="col-12 text-justify">
                            <strong class="ornage_color">Atenção!</strong>
                            <span>Antes de finalizar a compra revise atentamente os itens à direita.</span>
                            <hr style="border: none">
                        </div>

                        <!-- Modal de Cadastro de Endereço -->
                        <div style="display: none;max-width: 450px;" id="modal-add-endereco" >
                            <h3 class="col-12">Deseja abandonar o Checkout?</h3>
                            <div class="col-12 text-justify">
                                <span>Você será redirecionado para o cadastro de um novo endereço. <strong>Tem certeza?</strong></span>
                                <hr style="border: none">
                            </div>
                            <div class="col-12">
                                <a class="float-left" data-fancybox-close href="javascript:;"><strong>Ficar Aqui</strong></a>
                                <a href="form_endereco.jsp"><strong class="ornage_color float-right">Absoluta!</strong></a>
                            </div>
                        </div>
                        <!-- End Modal -->
                        
                        <h2 class="col-12">Entrega <a data-fancybox class="add-endereco-show" href="javascript:;"><img src="icon/plus.png" /></a></h2>
                        <div class="col-12">
                            <table class="table dataTable">
                                <%  
                                    content = new StringBuilder();

                                    if(clie.getEnderecos().isEmpty()){
                                        content.append("<tr role='row'><td><strong>Sem endereços por aqui.</strong><br></td></tr>");
                                    }else{
                                        for(Endereco end: clie.getEnderecos()){
                                            if(end.getEntrega()){
                                                content.append("<tr role='row'>");
                                                content.append("<td><input type='radio' name='entrega' value='"+end.getId()+"'></td>");
                                                content.append("<td>");
                                                content.append("<strong>"+end.getApelido()+"</strong><br>");
                                                content.append("<span>"+end.getTipo_log().getDescricao()+" "+end.getLogradouro()+", Nº "+end.getNumero()+" - "+end.getObservacao()+", "+end.getBairro()+", "+end.getCidade()+"/"+end.getEstado()+"</span>");
                                                content.append("</td>");
                                                content.append("</tr>");
                                            }
                                        }
                                    }

                                    out.println(content.toString());
                                %>
                            </table>
                        </div>

                        <h2 class="col-12">Cobrança <a data-fancybox class="add-endereco-show" href="javascript:;"><img src="icon/plus.png" /></a></h2>
                        <div class="col-12">
                            <table class="table dataTable">
                                <%  
                                    content = new StringBuilder();

                                    if(clie.getEnderecos().isEmpty()){
                                        content.append("<tr role='row'><td><strong>Sem endereços por aqui.</strong><br></td></tr>");
                                    }else{
                                        for(Endereco end: clie.getEnderecos()){
                                            if(end.getCobranca()){
                                                content.append("<tr role='row'>");
                                                content.append("<td><input type='radio' name='cobranca' value='"+end.getId()+"'></td>");
                                                content.append("<td>");
                                                content.append("<strong>"+end.getApelido()+"</strong><br>");
                                                content.append("<span>"+end.getTipo_log().getDescricao()+" "+end.getLogradouro()+", Nº "+end.getNumero()+" - "+end.getObservacao()+", "+end.getBairro()+", "+end.getCidade()+"/"+end.getEstado()+"</span>");
                                                content.append("</td>");
                                                content.append("</tr>");
                                            }
                                        }
                                    }

                                    out.println(content.toString());
                                %>
                            </table>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                        </div>

                        <h2 class="col-12">Descontos</h2>
                        <div class="col-12 wrapper">
                            <select class="form-control" id="cupom" name="cpm_id">
                                <option value="">Cupom</option>
                                <%  
                                    content = new StringBuilder();

                                    if(cupons != null){
                                        for(Cupom cpm: cupons){
                                            content.append("<option value='"+cpm.getId()+"-"+cpm.getValor()+"'>"+cpm.getNome()+"</option>");
                                        }
                                    }

                                    out.println(content.toString());
                                %>
                            </select>
                        </div>
                        <h4 class="col-12">Vales-Troca Disponíveis</h4>
                        <div class="col-12">
                            <%  
                                content = new StringBuilder();

                                if(clie.getVales().isEmpty()){
                                    content.append("<tr role='row'><td><strong>Nenhum vale-troca encontrado.</strong><br></td></tr>");
                                }else{
                                    for(ValeTroca vt: clie.getVales()){
                                        content.append("<p><input class='valetroca' type='checkbox' name='vt' value='"+vt.getId()+"-"+vt.getValor()+"'> ");
                                        content.append(vt.getCodigo()+" - "+Mask.toMoney(vt.getValor()));
                                        content.append("</p>");
                                    }
                                }

                                out.println(content.toString());
                            %>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                        </div>

                        <!-- Modal de Cadastro de Cartões de Crédito -->
                        <div style="display: none;max-width: 450px;" id="modal-add-cartao" >
                            <h3 class="col-12">Deseja abandonar o Checkout?</h3>
                            <div class="col-12 text-justify">
                                <span>Você será redirecionado para o cadastro de um novo cartão de crédito. <strong>Tem certeza?</strong></span>
                                <hr style="border: none">
                            </div>
                            <div class="col-12">
                                <a class="float-left" data-fancybox-close href="javascript:;"><strong>Ficar Aqui</strong></a>
                                <a href="form_cartao.jsp"><strong class="ornage_color float-right">Absoluta!</strong></a>
                            </div>
                        </div>
                        <!-- End Modal -->
                        
                        <h2 class="col-12">Pagamento <a data-fancybox class="add-cartao-show" href="javascript:;"><img src="icon/plus.png" /></a></h2>
                        <div class="col-12">
                            <table class="table dataTable">
                                <%  
                                    content = new StringBuilder();
                                    
                                    if(clie.getCartoes().isEmpty()){
                                        content.append("<tr role='row'><td><strong>Sem registros de cartões.</strong><br></td></tr>");
                                    }else{
                                        for(Cartao crt: clie.getCartoes()){
                                            content.append("<tr role='row'>");
                                            content.append("<td>");
                                            content.append("<center><strong>"+crt.getNumero()+"</strong><br></center>");
                                            content.append("<span>"+crt.getNome()+"</span><br>");
                                            content.append("<span><strong>Validade: </strong>"+Mask.toMonthYear(crt.getValidade())+"</span>");
                                            content.append("<span class='float-right'><strong>CVV: </strong>"+crt.getCvv()+"</span>");
                                            content.append("<hr style='border: none'>");
                                            content.append("<input class='form-control cartao' placeholder='Valor a Pagar' type='number' name='crt"+crt.getId()+"' step='.01' style='margin: 0px 0px 0px 0px;'>");
                                            content.append("</td>");
                                            content.append("</tr>");
                                        }
                                    }

                                    out.println(content.toString());
                                %>
                            </table>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                        </div>

                        <h2 class="col-12">Resumo</h2>
                        <div class="col-12">
                            <input type="hidden" id="valor_produtos" name="valor_produtos" value="<%= carr.getValor_total() %>">
                            <strong>Subtotal: </strong>
                            <span class="float-right"><%= Mask.toMoney(carr.getValor_total()) %></span><br>
                            
                            <input type="hidden" id="valor_frete" name="valor_frete" value="<%= carr.getItens().size() * 10.0 %>">
                            <strong>+&nbsp;Frete: </strong>
                            <span class="float-right"><%= Mask.toMoney(carr.getItens().size() * 10.0) %></span><br>
                            
                            <input type="hidden" id="valor_desconto" name="valor_desconto" value="0.0">
                            <strong>-&nbsp;Abatimentos: </strong>
                            <span class="float-right" id="lbl_valor_desconto">R$ 0,00</span><br>
                            <hr style="border: none">
                            
                            <input type="hidden" id="valor_total" name="valor_total" value="<%= carr.getValor_total() + (carr.getItens().size() * 10.0) %>">
                            <strong>Total: </strong>
                            <span class="float-right" id="lbl_valor_total"><%= Mask.toMoney(carr.getValor_total() + (carr.getItens().size() * 10.0)) %></span><br>
                            
                            <input type="hidden" id="valor_pago" name="valor_pago" value="0.0">
                            <strong>Total Pago: </strong>
                            <span class="float-right" id="lbl_valor_pago">R$ 0,00</span>
                        </div>

                        <div class="col-12">
                            <hr style="border: none">
                            <%
                                if(clie.getId() != 0)
                                    out.println("<button class='send' name='operacao' value='SALVAR'>Finalizar!</button>");
                            %>
                        </div>
                    </div>
                </form>
            </div>

            <div class="row col align-items-center"></div>

            <div class="col-8">
                <form class="main_form" action="./item" method="POST">
                    <div class="row">
                        <h2 class="col-12">Itens</h2>
                    </div>
                    <%@ include file="tabela_carrinho.jsp" %>
                    <div class="row">
                        <div class="col-12">
                            <hr style="border: none">
                            <button class="send float-right" name="operacao" value="ALTERAR">Salvar Quantidades</button>
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
    
    <%= error != null ? "$.fancybox.open({'src': '#modal-error-alert','touch': false,'modal': true});" : "" %>
        
    $valor_total = document.getElementById("valor_total").value;
    document.querySelectorAll('.valetroca').forEach(item => {
        item.addEventListener("change", function(){
            changeDescontoAndTotal();
        });
    });
    
    $(".wrapper").on('change', 'select', function(){
        changeDescontoAndTotal();
    });
    
    document.querySelectorAll('.cartao').forEach(item => {
        item.addEventListener("input", function(){
            changePago();
        });
    });
    
    function changeDescontoAndTotal(){
        $sum = 0.0;
        document.querySelectorAll('.valetroca').forEach(item => {
            if(item.checked) $sum += parseFloat(item.value.split("-")[1]);
        });
        if(document.getElementById("cupom").value !== "") $sum +=
            parseFloat(document.getElementById("cupom").value.split("-")[1]);
        document.getElementById("valor_desconto").value = $sum;
        document.getElementById("valor_total").value = $valor_total - $sum;
        modifyLabels();
    };
    
    function changePago(){
        $sum = 0.0;
        document.querySelectorAll('.cartao').forEach(item => {
            if(item.value !== "") $sum += parseFloat(item.value);
        });
        document.getElementById("valor_pago").value = $sum;
        modifyLabels();
    };
    
    function modifyLabels(){
        document.getElementById("lbl_valor_desconto").textContent =
            parseFloat(document.getElementById("valor_desconto").value)
            .toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});

        document.getElementById("lbl_valor_total").textContent =
            parseFloat(document.getElementById("valor_total").value)
            .toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});
    
        document.getElementById("lbl_valor_pago").textContent =
            parseFloat(document.getElementById("valor_pago").value)
            .toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});
    };
</script>
<script src="js/tabela_carrinho.js"></script>