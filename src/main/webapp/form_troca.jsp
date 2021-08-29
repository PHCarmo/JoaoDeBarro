<%@ include file="header.jsp" %>
<%@ page import="br.com.fatecmc.joaodebarro.model.domain.*"%>
<%@ page import="br.com.fatecmc.joaodebarro.util.Mask"%>
<%    
    String ped_id = request.getParameter("ped_id");
    String car_id = request.getParameter("car_id");
    Carrinho carr = (Carrinho) request.getAttribute("itens");
    
    if(ped_id == null)         ped_id = "";
    if(car_id == null)         car_id = "";
%>

<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Troca</h2>
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
                <form class="main_form" method="POST" action="./trocar">
                    <div class="row">
                        <div class="col-12">
                            <h2>Itens do Pedido</h2>
                            <input class="form-control" type="hidden" name="ped_id" value="<%=ped_id%>">
                            <input class="form-control" type="hidden" name="car_id" value="<%=car_id%>">
                        </div>
                        
                        <div class="col-12">
                            <table class="table hover stripe dataTable no-footer" role="grid">
                                <thead class="">
                                    <tr role="row">
                                        <th class="dt-center" style="width: 150px;">Produto</th>
                                        <th class="dt-center">Descrição</th>
                                        <th class="dt-center">$ Unitário</th>
                                        <th class="dt-center">Quantidade</th>
                                        <th class="dt-center">$ Total</th>
                                        <th class="dt-center" style="width: 100px;">Seleção</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        StringBuilder content = new StringBuilder();
                                        
                                        for(Item item: carr.getItens()){
                                            content.append("<tr role='row' class='odd'>");
                                            content.append("<td class='dt-center'><img src='images/produtos/"+item.getProduto().getImg_nome()+"' alt='img'></td>");
                                            content.append("<td class='dt-center'>"+item.getProduto().getDescricao()+"</td>");
                                            content.append("<td class='dt-center'>"+Mask.toMoney(item.getProduto().getValor_venda())+"</td>");
                                            content.append("<td class='dt-center'>"+item.getQtd()+"</td>");
                                            content.append("<td class='dt-center'>"+Mask.toMoney(item.getProduto().getValor_venda() * item.getQtd())+"</td>");
                                            if(item.getTroca())
                                                content.append("<td class='dt-center'><input disabled checked type='checkbox' name='item' value='"+item.getId()+"-"+item.getQtd()+"'></td>");
                                            else
                                                content.append("<td class='dt-center'><input type='checkbox' name='item' value='"+item.getId()+"-"+item.getQtd()+"'></td>");
                                            content.append("</tr>");
                                        }
                                        
                                        out.println(content.toString());
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <hr style="border: none">
                            <button class="send" name="operacao" value="ALTERAR">Confirmar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end contact -->
<%@ include file="footer.jsp" %>
