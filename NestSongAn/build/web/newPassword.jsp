        <%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Thay Đổi Mật Khẩu</title>
        <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
            rel='stylesheet'>
        <link
            href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css'
            rel='stylesheet'>
        <script type='text/javascript'
        src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <link rel="stylesheet" href="css/newPassword.css" type="text/css">
        <style>
                    body{
                        background:url('img/login.jpg') no-repeat center center fixed;
                        -webkit-background-size:cover;
                        -moz-background-size:cover;
                        -o-background-size: cover;
                        background-size: cover;
                    }
                    .hello{
                         background: url('img/login.jpg') no-repeat center center fixed;
                    }
                    .bg-custom{
                        background: url('img/login.jpg') no-repeat center center fixed;
                    }
                    #button{
                        background: #6a0e13;
                        color: white;
                        border: none;
                    }
                    #lo{
                        border: #6a0e13;
                    }
            
        </style>
    </head>
    <body oncontextmenu='return false' class='snippet-body bg-info'>
                <jsp:include page="header.jsp" />

        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-social/5.1.1/bootstrap-social.css">
        <div>
            <!-- Container containing all contents -->
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5">
                        <!-- White Container -->
                        <div class="container bg-white rounded mt-2 mb-2 px-0 hello">
                            <!-- Main Heading -->
                            <div class="row justify-content-center align-items-center pt-3">
                                <h1>
                                    <h3 style="font-weight: bold;">Thay Mật Khẩu</h3>
                                </h1>
                            </div>
                            <div class="pt-3 pb-3">
                                <form class="form-horizontal" action="resetPassword" method="POST">
                                    <!-- User Name Input -->
                                    <div class="form-group row justify-content-center px-3">
                                        <div class="col-9 px-0">
                                            <input type="password" name="password" placeholder="&#xf084; &nbsp; Mật khẩu mới"
                                                   class="form-control border-info placeicon" id="lo">
                                        </div>
                                    </div>
                                    <!-- Password Input -->
                                    <div class="form-group row justify-content-center px-3">
                                        <div class="col-9 px-0">
                                            <input type="password" name="confPassword"
                                                   placeholder="&#xf084; &nbsp; Nhập lại mật khẩu"
                                                   class="form-control border-info placeicon" id="lo">
                                        </div>
                                    </div>
                                    <!-- Log in Button -->
                                    <div class="form-group row justify-content-center">
                                        <div class="col-3 px-3 mt-3">
                                            <input type="submit" value="Đặt lại"
                                                   class="btn btn-block btn-info" id="button">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- Alternative Login -->
<!--                            <div class="mx-0 px-0 bg-custom">

                                 Horizontal Line 
                                <div class="px-4 pt-5">
                                    <hr>
                                </div>
                                 Register Now 
                                <div class="pt-2">
                                    <div class="row justify-content-center">
                                        <h5>
                                            Don't have an Account?<span><a href="#"
                                                                           class="text-danger"> Register Now!</a></span>
                                        </h5>
                                    </div>
                                    <div
                                        class="row justify-content-center align-items-center pt-4 pb-5">
                                        <div class="col-4">

                                        </div>
                                    </div>
                                </div>
                            </div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
                <jsp:include page="footer.jsp" />

        <script type='text/javascript'
        src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>

    </body>
</html>