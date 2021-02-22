<%@ include file="header.jsp" %>
<div class="brand_color">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Cliente</h2>
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
                <form class="main_form">
                    <div class="row">
                        <h2 class="col-12">Dados Pessoais<strong class="red">*</strong></h2>
                        <div class="col-9">
                            <input class="form-control" placeholder="Nome Completo" type="text" name="cli_nome">
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="cli_tipo">
                                <option value="">Selecione o Tipo</option>
                                <option value="fisica">Pessoa Física</option>
                                <option value="juridica">Pessoa Jurídica</option>
                            </select>
                        </div>
                        
                        <div class="col-12">
                            <h2>Documento 
                                <a href="#" class="add_doc_fields"><img src="icon/plus.png" /></a>
                                <a href="#" class="rem_doc_fields"><img src="icon/minus.png" /></a>
                            </h2>
                        </div>
                        <div class="col-6 doc-1">
                            <input class="form-control" placeholder="Número" type="text" name="doc_numero">
                        </div>
                        <div class="col-3 doc-1">
                            <input class="form-control" placeholder="Validade" type="date" name="doc_valida">
                        </div>
                        <div class="col-3 doc-1">
                            <select class="form-control" name="doc_tipo">
                                <option value="">Selecione o Tipo</option>
                                <option value="cpf">CPF</option>
                                <option value="cnpj">CNPJ</option>
                                <option value="rg">RG</option>
                            </select>
                        </div>
                        
                        <div class="col-12">
                            <h2>Endereço 
                                <a href="#" class="add_end_fields"><img src="icon/plus.png" /></a>
                                <a href="#" class="rem_end_fields"><img src="icon/minus.png" /></a>
                            </h2>
                        </div>
                        <div class="col-3 end-1">
                            <input class="form-control" placeholder="CEP" type="text" name="end_cep">
                        </div>
                        <div class="col-6 end-1">
                            <input class="form-control" placeholder="Cidade" type="text" name="end_cidade">
                        </div>
                        <div class="col-3 end-1">
                            <input class="form-control" placeholder="Estado" type="text" name="end_estado">
                        </div>
                        <div class="col-9 end-1">
                            <input class="form-control" placeholder="Logradouro" type="text" name="end_lograd">
                        </div>
                        <div class="col-3 end-1">
                            <input class="form-control" placeholder="Número" type="text" name="end_numero">
                        </div>
                        <div class="col-9 end-1">
                            <input class="form-control" placeholder="Complemento" type="text" name="end_comple">
                        </div>
                        <div class="col-3 end-1">
                            <select class="form-control" name="end_tipo">
                                <option value="">Selecione o Tipo</option>
                                <option value="cpf">Entrega</option>
                                <option value="cnpj">Cobrança</option>
                                <option value="cnpj">Entrega e Cobrança</option>
                            </select>
                        </div>
                    </div>
                        
                    <div class="col-12">
                        <button class="send">Enviar</button>
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
            if(x < 4){
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
            if(y < 2){
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
