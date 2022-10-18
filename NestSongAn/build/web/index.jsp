<%-- 
    Document   : index
    Created on : Sep 17, 2022, 8:27:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Nest Song Ân</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body>
        <div class="modal hide fade" id="myModal">
            <div class="modal-header text-center" style="color:white">
                
            </div>
            <div class="modal-body text-center ">
                <h3 class="text-center" style="color:white">BẠN GẦN NESTSONGAN</h3>
                <p class="text-center" style="color:white">Hãy chọn tỉnh thành của bạn</p>
                <a href="trang-chu?bid=1" class="btn btn-danger ml-10">Miền Bắc</a>
                <a href="trang-chu?bid=2" class="btn btn-primary ml-10">Miền Trung</a>
                <a href="trang-chu?bid=3" class="btn btn-warning ml-10">Miền Nam</a>
            </div>
            <div class="modal-footer">
                
            </div>
        </div>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>
        <jsp:include page="header.jsp" />
        <!-- Hero Section Begin -->
        <section class="hero">
            <div class="container">
                <div class="row">
                    <jsp:include page="/left-category" />
                    <div class="col-lg-9">
                        <jsp:include page="banner_1.jsp" />
                        <div class="hero__item set-bg" data-setbg="img/bn1.png">
                            <div class="hero__text">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="horizontal_category.jsp" />
        <jsp:include page="feature_product.jsp" />
        
        <jsp:include page="banner_2.jsp" />
        
        <jsp:include page="cam-nang-song-an.jsp" />


        <jsp:include page="footer.jsp" />
        <script type="text/javascript">
    $(window).on('load', function() {
        $('#myModal').modal('show');
    });
        </script>
        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>