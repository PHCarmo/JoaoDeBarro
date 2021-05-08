<%@ include file="header.jsp" %>
<%@ page import="br.com.fatecmc.joaodebarro.model.domain.*"%>
<%@ page import="br.com.fatecmc.joaodebarro.util.Mask"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%
    Cliente clie = (Cliente) request.getAttribute("cliente");
    Carrinho carr = (Carrinho) request.getAttribute("carrinho");
    List<Cupom> cupons = (ArrayList<Cupom>) request.getAttribute("cupons");
    
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
                                <%  
                                    content = new StringBuilder();

                                    if(clie.getEnderecos().isEmpty()){
                                        content.append("<tr role='row'><td><strong>Sem endere�os por aqui.</strong><br></td></tr>");
                                    }else{
                                        for(Endereco end: clie.getEnderecos()){
                                            if(end.getEntrega()){
                                                content.append("<tr role='row'>");
                                                content.append("<td><input type='radio' name='entrega' value='"+end.getId()+"'></td>");
                                                content.append("<td>");
                                                content.append("<strong>"+end.getApelido()+"</strong><br>");
                                                content.append("<span>"+end.getTipo_log().getDescricao()+" "+end.getLogradouro()+", N� "+end.getNumero()+" - "+end.getObservacao()+", "+end.getBairro()+", "+end.getCidade()+"/"+end.getEstado()+"</span>");
                                                content.append("</td>");
                                                content.append("</tr>");
                                            }
                                        }
                                    }

                                    out.println(content.toString());
                                %>
                            </table>
                        </div>

                        <h2 class="col-12">Cobran�a <a data-fancybox class="add-endereco-show" href="javascript:;"><img src="icon/plus.png" /></a></h2>
                        <div class="col-12">
                            <table class="table dataTable">
                                <%  
                                    content = new StringBuilder();

                                    if(clie.getEnderecos().isEmpty()){
                                        content.append("<tr role='row'><td><strong>Sem endere�os por aqui.</strong><br></td></tr>");
                                    }else{
                                        for(Endereco end: clie.getEnderecos()){
                                            if(end.getCobranca()){
                                                content.append("<tr role='row'>");
                                                content.append("<td><input type='radio' name='cobranca' value='"+end.getId()+"'></td>");
                                                content.append("<td>");
                                                content.append("<strong>"+end.getApelido()+"</strong><br>");
                                                content.append("<span>"+end.getTipo_log().getDescricao()+" "+end.getLogradouro()+", N� "+end.getNumero()+" - "+end.getObservacao()+", "+end.getBairro()+", "+end.getCidade()+"/"+end.getEstado()+"</span>");
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
                        <div class="col-12">
                            <select class="form-control" name="cpm_id">
                                <option value="">Cupom</option>
                                <%  
                                    content = new StringBuilder();

                                    if(cupons != null){
                                        for(Cupom cpm: cupons){
                                            content.append("<option value='"+cpm.getId()+"'>"+cpm.getNome()+"</option>");
                                        }
                                    }

                                    out.println(content.toString());
                                %>
                            </select>
                        </div>
                        <h4 class="col-12">Vales-Troca Dispon�veis</h4>
                        <div class="col-12">
                            <%  
                                content = new StringBuilder();

                                if(clie.getVales().isEmpty()){
                                    content.append("<tr role='row'><td><strong>Nenhum vale-troca encontrado.</strong><br></td></tr>");
                                }else{
                                    for(ValeTroca vt: clie.getVales()){
                                        content.append("<p><input type='checkbox' name='vt' value='"+vt.getId()+"'> ");
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
                                <%  
                                    content = new StringBuilder();
                                    
                                    if(clie.getCartoes().isEmpty()){
                                        content.append("<tr role='row'><td><strong>Sem registros de cart�es.</strong><br></td></tr>");
                                    }else{
                                        for(Cartao crt: clie.getCartoes()){
                                            content.append("<tr role='row'>");
                                            content.append("<td>");
                                            content.append("<center><strong>"+crt.getNumero()+"</strong><br></center>");
                                            content.append("<span>"+crt.getNome()+"</span><br>");
                                            content.append("<span><strong>Validade: </strong>"+Mask.toMonthYear(crt.getValidade())+"</span>");
                                            content.append("<span class='float-right'><strong>CVV: </strong>"+crt.getCvv()+"</span>");
                                            content.append("<hr style='border: none'>");
                                            content.append("<input class='form-control' placeholder='Valor a Pagar' type='number' name='crt"+crt.getId()+"' style='margin: 0px 0px 0px 0px;'>");
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
                            <strong>Subtotal: </strong>
                            <span class="float-right"><%= Mask.toMoney(carr.getValor_total()) %></span><br>
                            <strong>+&nbsp;Frete: </strong>
                            <span class="float-right">R$ 10,00</span><br>
                            <strong>-&nbsp;Abatimentos: </strong>
                            <span class="float-right">R$ 0,00</span><br>
                            <hr style="border: none">
                            <strong>Total: </strong>
                            <span class="float-right"><%= Mask.toMoney(carr.getValor_total() + 10.0) %></span><br>
                            <strong>Total Pago: </strong>
                            <span class="float-right">R$ 0,00</span>
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
</script>
<script src="js/tabela_carrinho.js"></script>