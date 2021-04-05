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
                        <h3 class="col-12"><strong class="color-red" id="signup_alert"></strong></h3>

                        <div class="col-12">
                            <button class="send" id="entrar">Entrar</button>
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
                        <h3 class="col-12"><strong class="color-red" id="signin_alert"></strong></h3>

                        <div class="col-12">
                            <button class="send" name="operacao" value="SALVAR" id="registrar">Registrar-se</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end contact -->
<%@ include file="footer.jsp" %>