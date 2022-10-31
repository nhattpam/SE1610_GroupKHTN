<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>

        <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
        <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link rel="stylesheet" href="css/enterOTP.css" type="text/css">

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <style>
            body{
                background:url('img/login.jpg') no-repeat center center fixed;
                -webkit-background-size:cover;
                -moz-background-size:cover;
                -o-background-size: cover;
                background-size: cover;
            }
            
            .panel-body{
                background: url('img/login.jpg') no-repeat center center fixed;
            }
            .btn-custe{
                background: #6a0e13 !important;
                color: white;
            }
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" />

        <div class="form-gap"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-center">
                                <h3>
                                    <i class="fa fa-lock fa-4x"></i>
                                </h3>
                                <h2 class="text-center">Nhập mã OTP</h2>
    
                                <c:if test="${ not empty message }">
                                    <h5 class="text-center text-success">${message}</h5>
                                    <c:remove var="message" scope="request"/>
                                </c:if>

                                <div class="panel-body">

                                    <form id="register-form" action="VerifyOTP" role="form" autocomplete="off"
                                          class="form" method="post">

                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i
                                                        class="glyphicon glyphicon-envelope color-blue"></i></span> <input
                                                    id="opt" name="otp" placeholder="Nhập mã OTP"
                                                    class="form-control" type="text" required="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input name="recover-submit"
                                                   class="btn btn-lg btn-custe btn-block"
                                                   value="Gửi" type="submit" style="color:white">
                                        </div>
                                        <input type="hidden" class="hide" name="token" id="token"
                                               value="">
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />

    </body>
</html>