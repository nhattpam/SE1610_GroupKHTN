<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Quên Mật Khẩu</title>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>

        <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
            rel='stylesheet'>
        <link href='' rel='stylesheet'>
        <link rel="stylesheet" href="css/forgotPassword.css" type="text/css">
        <script type='text/javascript'
        src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <style>
            body{
                background:url('img/login.jpg') no-repeat center center fixed;
                -webkit-background-size:cover;
                -moz-background-size:cover;
                -o-background-size: cover;
                background-size: cover;
            }
            
        </style>
    </head>
    <body oncontextmenu='return false' class='snippet-body'>
        <jsp:include page="header.jsp" />
        <div class="container padding-bottom-3x mb-2 mt-5">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10">
                    <div class="forgot">
                        <h2>Bạn quên mật khẩu?</h2>
                        <p>Thay đổi mật khẩu ngay với các bước đơn giản. Điểu này sẽ giúp bản mật 
                            tài khoản của bạn tốt hơn!</p>
                        <ol class="list-unstyled">
                            <li><span class="text-primary text-medium">1. </span>Điền địa chỉ email của bạn.</li>
                            <li><span class="text-primary text-medium">2. </span>Hệ thống sẽ gửi mã OTP
                            tới email của bạn</li>
                            <li><span class="text-primary text-medium">3. </span>Điền mã OTP đã nhận ở trang kế bên</li>
                        </ol>
                    </div>
                    <form class="card mt-4" action="forgotPassword" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="email-for-pass">Điền địa chỉ email</label> <input
                                    class="form-control" type="text" name="email" id="email-for-pass" required=""><small
                                    class="form-text text-muted">Điền địa chỉ email đã đăng kí. Hệ thống sẽ gửi mã tới email đó.</small>
                            </div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-success" type="submit">Lấy mật khẩu mới</button>
                            <button class="btn btn-danger" type="submit">Trở lại trang đăng nhập</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />

        <script type='text/javascript'
        src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
        <script type='text/javascript' src=''></script>
        <script type='text/javascript' src=''></script>
        <script type='text/Javascript'></script>
    </body>
</html>