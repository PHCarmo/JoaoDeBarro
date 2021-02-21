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
                        <h2 class="col-12">Dados Pessoais</h2>
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
                        
                        <h2 class="col-12">Documento</h2>
                        <div class="col-6">
                            <input class="form-control" placeholder="Número" type="text" name="doc_numero">
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Validade" type="date" name="doc_valida">
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="doc_tipo">
                                <option value="">Selecione o Tipo</option>
                                <option value="cpf">CPF</option>
                                <option value="cnpj">CNPJ</option>
                                <option value="rg">RG</option>
                            </select>
                        </div>
                        
                        <h2 class="col-12">Endereço</h2>
                        <div class="col-3">
                            <input class="form-control" placeholder="CEP" type="text" name="end_cep">
                        </div>
                        <div class="col-6">
                            <input class="form-control" placeholder="Cidade" type="text" name="end_cidade">
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Estado" type="text" name="end_estado">
                        </div>
                        <div class="col-9">
                            <input class="form-control" placeholder="Logradouro" type="text" name="end_lograd">
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Número" type="text" name="end_numero">
                        </div>
                        <div class="col-9">
                            <input class="form-control" placeholder="Complemento" type="text" name="end_comple">
                        </div>
                        <div class="col-3">
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
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end contact -->
<%@ include file="footer.jsp" %>