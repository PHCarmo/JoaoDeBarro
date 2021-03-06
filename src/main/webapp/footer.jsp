<!-- footer -->
    <footer>
        <div id="contact" class="footer">
            <div class="container">
                <div class="row pdn-top-30">
                    <div class="col-md-12 ">
                        <div class="footer-box">
                            <div class="headinga">
                                <h3>Visite Nossa Loja</h3>
                                <span><img src="icon/local.png" /> Rua Carlos Barattino, 908 - Vila Nova Mogilar</span>
                                <p>Mogi das Cruzes, SP - Brasil, 08773-600
                                <br><img src="icon/phone.png" /> (+11) 8981-8117
                                <br><img src="icon/email.png" /> sac@joaodebarro.com.br</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <div class="container">
                    <p>� 2021 Paulo Henrique</p>
                </div>
            </div>
        </div>
    </footer>
    <a href="#" class="back-to-top" style="display: none;">
        <i class="fa fa-chevron-up"></i>    
    </a>
    <!-- end footer -->
    <!-- Javascript files-->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/plugin.js"></script>
    <!-- sidebar -->
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
    <!-- javascript -->
    <script src="js/owl.carousel.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".zoom").hover(function() {
                $(this).addClass('transition');
            }, function() {
                $(this).removeClass('transition');
            });
            
            // Back to top button
            $(window).scroll(function () {
                if ($(this).scrollTop() > 100) {
                    $('.back-to-top').fadeIn('slow');
                } else {
                    $('.back-to-top').fadeOut('slow');
                }
            });
            $('.back-to-top').click(function () {
                $('html, body').animate({scrollTop: 0}, 200, 'easeInOutExpo');
                return false;
            });
        });
    </script>
</body>

</html>