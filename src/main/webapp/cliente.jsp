<%@ include file="header.jsp" %>
<%@ page import="br.com.fatecmc.joaodebarro.model.domain.*"%>
<%@ page import="br.com.fatecmc.joaodebarro.util.Mask"%>
<%
    Cliente clie = (Cliente) request.getAttribute("cliente");
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
                        <li class="col-12 active"><a href="#tab_dados"  data-toggle="tab">Cadastro</a></li>
                        <li class="col-12"><a href="#tab_cartao"        data-toggle="tab">Cartões</a></li>
                        <li class="col-12"><a href="#tab_compra"        data-toggle="tab">Compras</a></li>
                        <li class="col-12"><a href="#tab_endereco"      data-toggle="tab">Endereços</a></li>
                        <li class="col-12"><a href="#tab_no_content"    data-toggle="tab">Ranking</a></li>
                        <li class="col-12"><a href="#tab_vale"          data-toggle="tab">Vale-Troca</a></li>
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
                                        <input class="form-control" placeholder="Nova Senha" type="password" maxlength="30" name="new_pass" required>
                                    </div>
                                    <div class="col-6">
                                        <h3>Por segurança, informe a senha novamente</h3>
                                        <input class="form-control" placeholder="Confirmar Nova Senha" type="password" maxlength="30" name="new_pass_again" required>
                                    </div>
                                    <div class="col-6">
                                        <h3>Hmm, acho que me esqueci...
                                        <p></p>Qual a sua senha atual mesmo?</h3>
                                        <input class="form-control" placeholder="Senha Antiga" type="password" maxlength="30" name="old_pass" required>
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
                
                <div class="tab-pane active text-style" id="tab_dados">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="./cliente">
                                <div class="row">
                                    <div class="col-12">
                                        <h2>Dados Pessoais<strong class="color-red">*</strong></h2>
                                    </div>
                                    <div class="col-9">
                                        <input class="form-control" placeholder="Nome Completo" type="text" maxlength="100" name="cli_nome" value="<%=clie.getNome()%>" required>
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="cli_gen_id">
                                            <option value="">Selecione seu Gênero</option>
                                            <option value="1" <%= clie.getGenero().getId()==1 ? "selected" : "" %>>Feminino</option>
                                            <option value="2" <%= clie.getGenero().getId()==2 ? "selected" : "" %>>Masculino</option>
                                        </select>
                                    </div>
                                    <div class="col-6">
                                        <input class="form-control" placeholder="CPF" type="text" maxlength="11" name="cli_cpf" value="<%=clie.getCpf()%>" required>
                                    </div>
                                    <div class="col-6">
                                        <input class="form-control" placeholder="Data de Nascimento" type="date" name="cli_dt_nascimento"
                                               onfocus="(this.type='date')" onblur="if(this.value=='')this.type='text'" value="<%=clie.getDt_nascimento()%>" required>
                                    </div>

                                    <div class="col-12">
                                        <h2>Telefone<strong class="color-red">*</strong></h2>
                                    </div>
                                    <div class="col-3">
                                        <select class="form-control" name="cli_tel_tte_id">
                                            <option value="">Selecione o Tipo</option>
                                            <option value="1" <%= clie.getTel_tipo().getId()==1 ? "selected" : "" %>>Celular</option>
                                            <option value="2" <%= clie.getTel_tipo().getId()==2 ? "selected" : "" %>>Fixo</option>
                                            <option value="3" <%= clie.getTel_tipo().getId()==3 ? "selected" : "" %>>VoIP</option>
                                        </select>
                                    </div>
                                    <div class="col-2">
                                        <input class="form-control" placeholder="DDD" type="text" maxlength="3" name="cli_tel_ddd" value="<%=clie.getTel_ddd()%>" required>
                                    </div>
                                    <div class="col-7">
                                        <input class="form-control" placeholder="Número" type="text" maxlength="9" name="cli_tel_numero" value="<%=clie.getTel_numero()%>" required>
                                    </div>
                                    <div class="col-12">
                                        <button class="send" name="operacao" value="ALTERAR">Salvar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_cartao">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="form_cartao.jsp">
                                <div class="row">
                                    <%  
                                        StringBuilder content = new StringBuilder();
                                        
                                        if(clie.getCartoes().isEmpty()){
                                            content.append("<div class='col-12'><h3>Os cartões sumiram! Que tal cadastrar um novo?</h3></div>");
                                        }else{
                                            for(Cartao crt: clie.getCartoes()){
                                                content.append("<div class='col-4'>");
                                                content.append("<div class='card'>");
                                                content.append("<div class='card-body'>");
                                                content.append("<h2>"+crt.getNumero()+"</h2>");
                                                content.append("<strong>"+crt.getNome()+"</strong><br>");
                                                content.append("<span><strong>Validade: </strong>11/2011</span>");
                                                content.append("<span class='float-right'><strong>CVV: </strong>"+crt.getCvv()+"</span>");
                                                content.append("<hr style='border: none'>");
                                                content.append("<img class='icon' src='icon/"+crt.getBandeira().getIcon_nome()+"' />");
                                                content.append("<a class='btn btn-default float-right' title='Editar' href='#'><img class='icon' src='icon/pencil.png' /></a>");
                                                content.append("<a class='btn btn-default float-right' title='Remover' href='#'><img class='icon' src='icon/remove.png' /></a>");
                                                content.append("</div>");
                                                content.append("</div>");
                                                content.append("</div>");
                                            }
                                        }
                                        
                                        out.println(content.toString());
                                    %>
                                    
                                    <div class="col-12">
                                        <hr style="border: none">
                                        <button class="send float-right" name="operacao" value="SALVAR" id="novo_cartao">+ Novo</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_compra">
                    <%@ include file="tabela_compra.jsp" %>
                    <div class="row">
                        <div class="col-12">
                            <hr style="border: none">
                        </div>
                        <div class="col-12">
                            <table class="legend float-right">
                                <th>Legenda: </th>
                                <td><div class="circle lightblue">  </div></td><td>Em Processamento</td>
                                <td><div class="circle red">        </div></td><td>Reprovada</td>
                                <td><div class="circle blue">       </div></td><td>Aprovada</td>
                                <td><div class="circle orange">     </div></td><td>Em Trânsito</td>
                                <td><div class="circle green">      </div></td><td>Entregue</td>
                                <td><div class="circle yellow">     </div></td><td>Em Troca</td>
                                <td><div class="circle lightgreen"> </div></td><td>Troca Autorizada</td>
                            </table>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_endereco">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="main_form" action="form_endereco.jsp">
                                <div class="row">
                                    <%  
                                        content = new StringBuilder();
                                        
                                        if(clie.getEnderecos().isEmpty()){
                                            content.append("<div class='col-12'><h3>Os endereços sumiram! Que tal cadastrar um novo?</h3></div>");
                                        }else{
                                            for(Endereco end: clie.getEnderecos()){
                                                content.append("<div class='col-4'>");
                                                content.append("<div class='card'>");
                                                content.append("<div class='card-body'>");
                                                content.append("<h2>"+end.getApelido()+"</h2>");
                                                content.append("<strong>"+end.getTipo_log().getDescricao()+" "+end.getLogradouro()+", Nº "+end.getNumero()+"</strong><br>");
                                                content.append("<span>"+end.getBairro()+", "+end.getCidade()+"/"+end.getEstado()+"</span>");
                                                content.append("<hr style='border: none'>");
                                                if(end.getEntrega())
                                                    content.append("<div class='circle brown float-left'></div><div class='float-left'><a class='invisible'>,</a></div>");
                                                if(end.getCobranca())
                                                    content.append("<div class='circle lightbrown float-left'></div>");
                                                content.append("<a class='btn btn-default float-right' title='Editar' href='#'><img class='icon' src='icon/pencil.png' /></a>");
                                                content.append("<a class='btn btn-default float-right' title='Remover' href='#'><img class='icon' src='icon/remove.png' /></a>");
                                                content.append("</div>");
                                                content.append("</div>");
                                                content.append("</div>");
                                            }
                                        }
                                        
                                        out.println(content.toString());
                                    %>
                                    
                                    <div class="col-12">
                                        <hr style="border: none">
                                        <table class="legend float-left">
                                            <th>Legenda: </th>
                                            <td><div class="circle brown"></div></td><td>Entrega</td>
                                            <td><div class="circle lightbrown"></div></td><td>Cobrança</td>
                                        </table>
                                        <button class="send float-right" name="cli_id" value="<%= clie.getId()%>" id="novo_endereco">+ Novo</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane text-style" id="tab_vale">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-12">
                                    <h3>Trocas de itens ou compras geram um vale-troca que dão descontos nas suas próximas compras!</h3>
                                </div>
                                
                                <%  
                                    content = new StringBuilder();

                                    if(clie.getVales().isEmpty()){
                                        content.append("<div class='col-12'><h4>Que pena! Você não possui vales-troca para usar.</h4></div>");
                                    }else{
                                        for(ValeTroca vt: clie.getVales()){
                                            content.append("<div class='col-4'>");
                                            content.append("<div class='card'>");
                                            content.append("<div class='card-body'>");
                                            content.append("<h2>"+vt.getCodigo()+"</h2>");
                                            content.append("<span><strong>Valor: </strong>"+Mask.toMoney(vt.getValor())+"</span>");
                                            content.append("</div>");
                                            content.append("</div>");
                                            content.append("</div>");
                                        }
                                    }

                                    out.println(content.toString());
                                %>
                            </div>
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
    $(".nav-sidebar li a").on('click', function(e){
        $(".nav-sidebar .active").removeClass('active');
        $(this).parent().addClass('active');
    });
</script>
<script src="js/tabela_compra.js"></script>