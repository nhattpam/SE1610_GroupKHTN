<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Forgot Password</title>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>

        <link
            href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
            rel='stylesheet'>
        <link href='' rel='stylesheet'>
        <link rel="stylesheet" href="css/forgotPassword.css" type="text/css">
        <script type='text/javascript'
        src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    </head>
    <body oncontextmenu='return false' class='snippet-body'>
        <jsp:include page="header.jsp" />
        <div class="container padding-bottom-3x mb-2 mt-5">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10">
                    <div class="forgot">
                        <h2>Forgot your password?</h2>
                        <p>Change your password in three easy steps. This will help you
                            to secure your password!</p>
                        <ol class="list-unstyled">
                            <li><span class="text-primary text-medium">1. </span>Enter
                                your email address below.</li>
                            <li><span class="text-primary text-medium">2. </span>Our
                                system will send you an OTP to your email</li>
                            <li><span class="text-primary text-medium">3. </span>Enter the OTP on the 
                                next page</li>
                        </ol>
                    </div>
                    <form class="card mt-4" action="forgotPassword" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="email-for-pass">Enter your email address</label> <input
                                    class="form-control" type="text" name="email" id="email-for-pass" required=""><small
                                    class="form-text text-muted">Enter the registered email address . Then we'll
                                    email a OTP to this address.</small>
                            </div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-success" type="submit">Get New
                                Password</button>
                            <button class="btn btn-danger" type="submit">Back to
                                Login</button>
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