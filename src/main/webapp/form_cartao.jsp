<%@ include file="header.jsp" %>
<%
    String operacao =       request.getParameter("operacao");
    String temp =           request.getParameter("cli_id");
    
    if(operacao == null)    operacao = "";
    if(temp == null)        temp = "";
%>

<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Cartão de Crédito</h2>
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
                <form class="main_form" method="POST" action="./cliente.jsp">
                    <div class="row">
                        <div class="col-12">
                            <input class="form-control" type="hidden" name="crt_id" value="<%=temp%>">
                        </div>
                        
                        <div class="col-12">
                            <h2>Dados Próprios<strong class="color-red">*</strong></h2>
                        </div>
                        <div class="col-6">
                            <input class="form-control" placeholder="Número" type="text" maxlength="16" name="crt_numero" value="<%=temp%>" required>
                        </div>
                        <div class="col-6">
                            <input class="form-control" placeholder="Nome do Titular" type="text" maxlength="100" name="crt_nome" value="<%=temp%>" required>
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="crt_mes_validade">
                                <option value="">Mês da Validade</option>
                                <option value="1">01/Janeiro</option>
                                <option value="2">02/Fevereiro</option>
                                <option value="3">03/Março</option>
                                <option value="4">04/Abril</option>
                                <option value="5">05/Maio</option>
                                <option value="6">06/Junho</option>
                                <option value="7">07/Julho</option>
                                <option value="8">08/Agosto</option>
                                <option value="9">09/Setembro</option>
                                <option value="10">10/Outubro</option>
                                <option value="11">11/Novembro</option>
                                <option value="12">12/Dezembro</option>
                            </select>
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="crt_ano_validade">
                                <option value="">Ano da Validade</option>
                                <option value="1">2021</option>
                                <option value="2">2022</option>
                                <option value="3">2023</option>
                                <option value="4">2024</option>
                                <option value="5">2025</option>
                                <option value="6">2026</option>
                                <option value="7">2027</option>
                                <option value="8">2028</option>
                                <option value="9">2029</option>
                                <option value="10">2030</option>
                                <option value="11">2031</option>
                            </select>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="CVV" type="text" maxlength="3" name="crt_cvv" value="<%=temp%>" required>
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="crt_bnd_id">
                                <option value="">Bandeira</option>
                                <option value="1">American Express</option>
                                <option value="2">Diners Club</option>
                                <option value="3">Elo</option>
                                <option value="4">Hipercard</option>
                                <option value="5">MasterCard</option>
                                <option value="6">Visa</option>
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
