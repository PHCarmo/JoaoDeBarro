<%@ include file="header.jsp" %>
<section class="slider_section">
    <div id="myCarousel" class="carousel slide banner-main" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="first-slide" src="images/banner1.jpg" alt="First slide">
                <div class="container">
                    <div class="carousel-caption relative">
                        <h1>Pisos e</h1>
                        <span>Revestimentos</span>
                        <p>Tudo à  pronta-entrega e
                            <br>com o menor preço da região!</p>
                        <a class="buynow" href="loja.jsp">Conhecer</a>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="second-slide" src="images/banner2.jpg" alt="Second slide">
                <div class="container">
                    <div class="carousel-caption relative">
                        <h1>Áreas Internas</h1>
                        <span>e Externas</span>
                        <p>O produto certo para a casa toda.</p>
                        <a class="buynow" href="loja.jsp">Explorar</a>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="third-slide" src="images/banner3.jpg" alt="Third slide">
                <div class="container">
                    <div class="carousel-caption relative">
                        <h1>Não perca tempo!</h1>
                        <span>Redecore sua casa já</span>
                        <p>Uma variedade diferente para cada tipo de gosto.</p>
                        <a class="buynow" href="loja.jsp">Começar</a>
                    </div>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <i class='fa fa-angle-left'></i>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <i class='fa fa-angle-right'></i>
        </a>
    </div>
</section>

<!-- about -->
<div class="about">
    <div class="container">
        <div class="row">
            <div class="col-xl-5 col-lg-5 col-md-5 co-sm-l2">
                <div class="about_img">
                    <figure><img src="images/about.png" alt="img" /></figure>
                </div>
            </div>
            <div class="col-xl-7 col-lg-7 col-md-7 co-sm-l2">
                <div class="about_box">
                    <h3>Sobre Nós</h3>
                    <span>João de Barro</span>
                    <p>O joão-de-barro é uma ave passeriforme da família Furnariidae, conhecido por seu característico ninho de barro em forma de forno e tido como passarinho trabalhador e inteligente. Seu canto parece uma gargalhada e também dizem que ele faz o ninho na direção contrária da chuva, e é amigo de todos, lutando para salvar seu ninho.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end about -->

<!-- clients -->
<div class="brand">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="titlepage">
                    <h2>Clientes satisfeitos!</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clients_red">
    <div class="container">
        <div id="testimonial_slider" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#testimonial_slider" data-slide-to="0" class=""></li>
                <li data-target="#testimonial_slider" data-slide-to="1" class="active"></li>
                <li data-target="#testimonial_slider" data-slide-to="2" class=""></li>
            </ul>
            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item">
                    <div class="testomonial_section">
                        <div class="full center">
                        </div>
                        <div class="full testimonial_cont text_align_center cross_layout">
                            <div class="cross_inner">
                                <h3>Leila Goncalves Pereira<br><strong class="ornage_color">Arujá, SP</strong></h3>
                                <p>Fiz uma compra porém quando eu fui utilizar vi que era a cor errada e gostaria de trocar. Está tudo embalado e a NF tem 30 dias, porém não querem receber e dizem que não estão mais vendendo o produto. Estive na loja e o item estava exposto à venda. Independente disso, não é meu direito devolver?
                                </p>
                                <div class="full text_align_center margin_top_30">
                                    <img src="icon/testimonial_qoute.png">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="carousel-item active">

                    <div class="testomonial_section">
                        <div class="full center">
                        </div>
                        <div class="full testimonial_cont text_align_center cross_layout">
                            <div class="cross_inner">
                                <h3>Nicolas Ferreira da Silva<br><strong class="ornage_color">Poá, SP</strong></h3>
                                <p>Recebi uma fatura que desconheço a compra. Tentei entrar em contato conforme telefone disponível no site, mas não atendem. A cobrança foi para o endereço do meu serviço (estou de home office há um ano) e para minha surpresa ao ter que ir presencialmente na empresa me deparei com essa falsa cobrança.
                                </p>
                                <div class="full text_align_center margin_top_30">
                                    <img src="icon/testimonial_qoute.png">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="carousel-item">

                    <div class="testomonial_section">
                        <div class="full center">
                        </div>
                        <div class="full testimonial_cont text_align_center cross_layout">
                            <div class="cross_inner">
                                <h3>Julia Rodrigues Souza<br><strong class="ornage_color">Feira de Santana, BA</strong></h3>
                                <p>Comprei 11 caixas de um porcelanato e o entregador quebrou 5 caixas deste revestimento. Solicitei a substituição e no dia seguinte tentaram entregar somente 3 caixas. É um absurdo, além do atraso na obra só receberei o dinheiro de volta em 10 dias úteis, ou seja, descaso total com o consumidor!
                                </p>
                                <div class="full text_align_center margin_top_30">
                                    <img src="icon/testimonial_qoute.png">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
</div>
<!-- end clients -->
<%@ include file="footer.jsp" %>