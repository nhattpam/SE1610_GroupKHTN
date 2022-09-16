<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Nest Song Ân - Mobile " />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- font-awesome icons -->
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
        <!-- //font-awesome icons -->
        <!-- js -->
        <script src="js/jquery-1.11.1.min.js"></script>
        <!-- //js -->
        <link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="w3_login">
            <h3 style="color: #4a5d43; font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Đăng nhập</h3>
            <div class="w3_login_module">
                <div class="module form-module">
                    <div class="toggle"><i class="fa fa-times fa-pencil"></i>
                    </div>
                    <div class="form">
                        <h2 style="color: #4a5d43; font-family: 'Nunito Sans', sans-serif">Đăng nhập tài khoản của bạn</h2>
                        <form action="#" method="post">
                            <input type="text" name="Username" placeholder="Username" required=" ">
                            <input type="password" name="Password" placeholder="Password" required=" ">
                            <input type="submit" value="Đăng nhập">
                        </form>
                    </div>
                    <div style="margin-bottom: 30px;">
                        <a href="register.jsp">Tạo tài khoản</a>
                    </div>
                    <div class="cta"><a href="#">Quên mật khẩu?</a></div>
                </div>
            </div>
            <script>
                $('.toggle').click(function () {
                    // Switches the Icon
                    $(this).children('i').toggleClass('fa-pencil');
                    // Switches the forms  
                    $('.form').animate({
                        height: "toggle",
                        'padding-top': 'toggle',
                        'padding-bottom': 'toggle',
                        opacity: "toggle"
                    }, "slow");
                });
            </script>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
