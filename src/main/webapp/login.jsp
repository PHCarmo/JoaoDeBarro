<%@ include file="header.jsp" %>
<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Login</h2>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- contact -->
<div class="contact">
    <div class="container">
        <div class="row">
            <div class="col-5">
                <form class="main_form" action="admin.jsp" method="POST">
                    <div class="row">
                        <h2 class="col-12">Já possui cadastro?</h2>
                        <div class="col-12">
                            <input class="form-control" placeholder="E-mail" type="text" name="usu_su_email" required>
                        </div>
                        <div class="col-12">
                            <input class="form-control" placeholder="Senha" type="password" name="usu_su_senha" required>
                        </div>
                        <div class="col-12">
                            <p><a href="#"><strong class="ornage_color">Esqueci minha senha</strong></a></p>
                        </div>
                        <h3 class="col-12"><strong class="red" id="signup_alert"></strong></h3>

                        <div class="col-12">
                            <button class="send">Entrar</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="row col-2 align-items-center">
                <img src="images/sketch.png" alt="#">
            </div>
            <div class="col-5">
                <form class="main_form" action="./Registrar" method="POST">
                    <div class="row">
                        <h2 class="col-12">Ainda não é cadastrado?</h2>
                        <div class="col-12">
                            <input class="form-control" placeholder="E-mail" type="text" name="usu_si_email" required>
                        </div>
                        <div class="col-12">
                            <input class="form-control" placeholder="Senha" type="password" name="usu_si_senha" required>
                        </div>
                        <div class="col-12">
                            <input class="form-control" placeholder="Repita a Senha" type="password" name="usu_si_conf_senha" required>
                        </div>
                        <div class="col-12">
                            <p><ul>
                                <li>Mínimo de 8 (oito) caracteres.</li>
                                <li>Ao menos uma letra maiúscula.</li>
                                <li>Ao menos uma letra minúscula.</li>
                                <li>Ao menos um caracter especial.</li>
                            </ul></p>
                        </div>
                        <h3 class="col-12"><strong class="red" id="signin_alert"></strong></h3>

                        <div class="col-12">
                            <button class="send" name="operacao" value="SALVAR">Registrar-se</button>
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
        $(".fancybox").fancybox({
            openEffect: "none",
            closeEffect: "none"
        });

        $(".zoom").hover(function() {
            $(this).addClass('transition');
        }, function() {
            $(this).removeClass('transition');
        });
        
        var doc_wrapper;
        var x = 1;
        $(".add_doc_fields").click(function(e){
            e.preventDefault();
            if(true){
                doc_wrapper = $("div.doc-" + x).last(); x++;
                $(doc_wrapper).after('<div class="col-6 doc-' + x + '"><input class="form-control" placeholder="Número" type="text" name="doc_numero"></div><div class="col-3 doc-' + x + '"><input class="form-control" placeholder="Validade" type="date" name="doc_valida"></div><div class="col-3 doc-' + x + '"><select class="form-control" name="doc_tipo"><option value="">Selecione o Tipo</option><option value="cpf">CPF</option><option value="cnpj">CNPJ</option><option value="rg">RG</option></select></select><div class="nice-select form-control" tabindex="0"><span class="current">Selecione o Tipo</span><ul class="list"><li class="option selected" data-value="">Selecione o Tipo</li><li class="option " data-value="cpf">CPF</li><li class="option " data-value="cnpj">CNPJ</li><li class="option " data-value="rg">RG</li></ul></div></div>');
            }
        });

        $(this).on("click",".rem_doc_fields", function(e){
            e.preventDefault();
            if(x > 1){ $('div.doc-' + x).remove(); x--; }
        })
        
        var end_wrapper;
        var y = 1;
        $(".add_end_fields").click(function(e){
            e.preventDefault();
            if(true){
                end_wrapper = $("div.end-" + y).last(); y++;                
                $(end_wrapper).after('<div class="col-3 end-' + y + '"><input class="form-control" placeholder="CEP" type="text" name="end_cep"></div><div class="col-6 end-' + y + '"><input class="form-control" placeholder="Cidade" type="text" name="end_cidade"></div><div class="col-3 end-' + y + '"><input class="form-control" placeholder="Estado" type="text" name="end_estado"></div><div class="col-9 end-' + y + '"><input class="form-control" placeholder="Logradouro" type="text" name="end_lograd"></div><div class="col-3 end-' + y + '"><input class="form-control" placeholder="Número" type="text" name="end_numero"></div><div class="col-9 end-' + y + '"><input class="form-control" placeholder="Complemento" type="text" name="end_comple"></div><div class="col-3 end-' + y + '"><select class="form-control" name="end_tipo"><option value="">Selecione o Tipo</option><option value="cpf">Entrega</option><option value="cnpj">Cobrança</option><option value="cnpj">Entrega e Cobrança</option></select><div class="nice-select form-control" tabindex="0"><span class="current">Selecione o Tipo</span><ul class="list"><li class="option selected" data-value="">Selecione o Tipo</li><li class="option " data-value="cpf">Entrega</li><li class="option " data-value="cnpj">Cobrança</li><li class="option " data-value="cnpj">Entrega e Cobrança</li></ul></div></div>');
            }
        });

        $(this).on("click",".rem_end_fields", function(e){
            e.preventDefault();
            if(y > 1){ $('div.end-' + y).remove(); y--; }
        })
    });
</script>
