<%@ include file="header.jsp" %>
<%
    String temp =           "";
    
    if(temp == null)        temp = "";
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
                <form class="main_form" method="POST" action="./produto">
                    <div class="row">                        
                        <div class="col-12">
                            <h2>Dados Pr�prios<strong class="color-red">*</strong></h2>
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="prd_tpd_id">
                                <option value="">Selecione o Tipo</option>
                                <option value="1" <%= temp.equals("1") ? "selected" : "" %>>Piso</option>
                                <option value="2" <%= temp.equals("2") ? "selected" : "" %>>Resvestimento</option>
                            </select>
                        </div>
                        <div class="col-6">
                            <input class="form-control" placeholder="Descri��o" type="text" maxlength="100" name="prd_descricao" value="<%=temp%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Marca" type="text" maxlength="11" name="prd_marca" value="<%=temp%>" required>
                        </div>
                        
                        <div class="col-12">
                            <h2>Identifica��o<strong class="color-red">*</strong></h2>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Cor/Tonalidade" type="text" maxlength="15" name="prd_cor_tonalidade" value="<%=temp%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Material" type="text" maxlength="11" name="prd_material" value="<%=temp%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Comprimento" type="text" maxlength="100" name="prd_comprimento" value="<%=temp%>" required>
                        </div>
                        <div class="col-3">
                            <input class="form-control" placeholder="Largura" type="text" maxlength="11" name="prd_largura" value="<%=temp%>" required>
                        </div>
                        <div class="col-7">
                            <input class="form-control" placeholder="C�digo de Barras" type="text" maxlength="11" name="prd_codigo_barra" value="<%=temp%>" required>
                        </div>
                        <div class="col-2">
                            <select class="form-control" name="prd_pei">
                                <option value="">PEI</option>
                                <option value="1" <%= temp.equals("1") ? "selected" : "" %>>0</option>
                                <option value="2" <%= temp.equals("2") ? "selected" : "" %>>1</option>
                                <option value="2" <%= temp.equals("3") ? "selected" : "" %>>2</option>
                                <option value="2" <%= temp.equals("4") ? "selected" : "" %>>3</option>
                                <option value="2" <%= temp.equals("5") ? "selected" : "" %>>4</option>
                                <option value="2" <%= temp.equals("6") ? "selected" : "" %>>5</option>
                            </select>
                        </div>
                        <div class="col-3">
                            <select class="form-control" name="prd_gpp_id">
                                <option value="">Grupo de Precifica��o</option>
                                <option value="1" <%= temp.equals("1") ? "selected" : "" %>>Padr�o</option>
                                <option value="2" <%= temp.equals("2") ? "selected" : "" %>>Promo��o</option>
                                <option value="2" <%= temp.equals("3") ? "selected" : "" %>>Grupo X</option>
                            </select>
                        </div>
                                                
                        <div class="col-12">
                            <h2>Categorias<strong class="color-red">*</strong> 
                                <a href="#" class="add_cat_field"><img src="icon/plus.png" /></a>
                                <a href="#" class="rem_cat_field"><img src="icon/minus.png" /></a>
                            </h2>
                        </div>
                        <div class="col-3 cat-1">
                            <select class="form-control" name="ctg_id">
                                <option value="">Selecione uma Categoria</option>
                                <option value="1" <%= temp.equals("1") ? "selected" : "" %>>Porcelanato</option>
                                <option value="2" <%= temp.equals("2") ? "selected" : "" %>>Azulejo</option>
                                <option value="3" <%= temp.equals("3") ? "selected" : "" %>>Revestimento Interno</option>
                                <option value="3" <%= temp.equals("4") ? "selected" : "" %>>Revestimento Externo</option>
                                <option value="3" <%= temp.equals("5") ? "selected" : "" %>>Ladrilho</option>
                                <option value="3" <%= temp.equals("6") ? "selected" : "" %>>Mosaico</option>
                                <option value="3" <%= temp.equals("7") ? "selected" : "" %>>Piso Cer�mico</option>
                                <option value="3" <%= temp.equals("8") ? "selected" : "" %>>Piso Vin�lico</option>
                                <option value="3" <%= temp.equals("9") ? "selected" : "" %>>Piso Laminado</option>
                                <option value="3" <%= temp.equals("10") ? "selected" : "" %>>Pedras Naturais</option>
                                <option value="3" <%= temp.equals("11") ? "selected" : "" %>>Faixas</option>
                                <option value="3" <%= temp.equals("12") ? "selected" : "" %>>Filetes</option>
                                <option value="3" <%= temp.equals("13") ? "selected" : "" %>>Pastilha</option>
                                <option value="3" <%= temp.equals("14") ? "selected" : "" %>>Rodap�</option>
                                <option value="3" <%= temp.equals("15") ? "selected" : "" %>>Soleira</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button class="send" name="operacao" value="SALVAR">Salvar</button>
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
        var wrapper;
        var fields;
        var y = 1;
        $(".add_cat_field").click(function(e){
            e.preventDefault();
            if(true){
                wrapper = $("div.cat-" + y).last();
                fields = $("div.cat-" + y).html(); y++;
                $(wrapper).after('<div class="col-3 cat-' + y + '">' + fields + '</div>');
            }
        });

        $(this).on("click",".rem_cat_field", function(e){
            e.preventDefault();
            if(y > 1){ $('.cat-' + y).remove(); y--; }
        })
    });
</script>
