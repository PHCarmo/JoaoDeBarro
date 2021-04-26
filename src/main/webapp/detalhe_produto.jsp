<%@ include file="header.jsp" %>
<%@ page import="br.com.fatecmc.joaodebarro.model.domain.*"%>
<%@ page import="br.com.fatecmc.joaodebarro.util.Mask"%>
<%
    Produto prod = (Produto) request.getAttribute("produto");
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
                <form class="main_form" method="POST" action="./item">
                    <div class="row">
                        <div class="col-12">
                            <input class="form-control" type="hidden" name="prd_id" value="<%=prod.getId()%>">
                        </div>
                        
                        <div class="col-7" style="align-self: center;">
                            <center><img src="images/produtos/<%=prod.getImg_nome()%>" alt="img" /></center>
                        </div>
                        <div class="col-5">
                            <div class="col-12">
                                <h2>
                                    <span><%=prod.getDescricao()%></span>
                                    <strong class="float-right"><%=prod.getTipo().getDescricao()%></strong>
                                    <hr>
                                </h2>
                            </div>
                            <div class="col-12">
                                <h4>
                                    <strong>Marca: </strong>
                                    <span><%=prod.getMarca()%></span>
                                    <a class="invisible">-----</a>
                                    <strong>PEI: </strong>
                                    <span><%=prod.getPei()%></span>
                                </h4>
                                <h4>
                                    <strong>Material: </strong>
                                    <span class="float-right"><%=prod.getMaterial()%></span>
                                </h4>
                                <h4>
                                    <strong>Dimensões: </strong>
                                    <span class="float-right"><%=prod.getComprimento()%> X <%=prod.getLargura()%> cm</span>
                                </h4>
                                <h4>
                                    <strong>Cor/Tonalidade: </strong>
                                    <span class="float-right"><%=prod.getCor_tonalidade()%></span>
                                </h4>
                                <h4>
                                    <strong>Preço Unitário: </strong>
                                    <span class="float-right"><%=Mask.toMoney(prod.getValor_venda())%></span>
                                </h4>
                                <h4>
                                    <strong>Código de Barras: </strong>
                                    <span class="float-right"><%=prod.getCodigo_barra()%></span>
                                    <hr style="border: none">
                                    <hr style="border: none">
                                </h4>
                            </div>
                            <div class="col-12">
                                <h4>
                                    <strong>Quantidade: </strong>
                                    <input class="form-control-sm float-right" type="number" name="pcr_qtd" value="1" min="1" style="width: 100px;">
                                </h4>
                                <h4>
                                    <strong>Preço Total: </strong>
                                    <span class="float-right">R$ 99,90</span>
                                </h4>
                            </div>
                        </div>
                        <div class="col-12">
                            <hr style="border: none">
                            <button class="send float-right" name="operacao" value="SALVAR">Adicionar ao Carrinho!</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end contact -->
<%@ include file="footer.jsp" %>
