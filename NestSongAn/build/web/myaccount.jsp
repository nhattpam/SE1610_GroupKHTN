<%-- 
    Document   : myaccount
    Created on : Sep 27, 2022, 2:13:11 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style1.css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    </head>
    <body>
        <div class="main-content">
            <div class="container mt-7">
                <!-- Table -->
                <a href="#" class="mb-5">My Account Card</a>
                <div class="row">
                    <div class="col-xl-8 m-auto order-xl-1">
                        <div class="card bg-secondary shadow">
                            <div class="card-header bg-white border-0">
                                <div class="row align-items-center">
                                    <div class="col-8">
                                        <h3 class="mb-0">My account</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <form action="EditProfile">
                                    <h6 class="heading-small text-muted mb-4">User information</h6>
                                    <div class="pl-lg-4">
                                        <div class="row">
                                            <input type="hidden" name="uid" value="${inform.user_id}">
                                            <div class="col-lg-6">
                                                <div class="form-group focused">
                                                    <label class="form-control-label">Full Name</label>
                                                    <input type="text" name="fullname" class="form-control form-control-alternative" placeholder="Full Name" value="${inform.full_name}">
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label class="form-control-label">Username</label>
                                                    <input type="text" name="username" class="form-control form-control-alternative" placeholder="User Name" value="${inform.user_name}">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group focused">
                                                    <label class="form-control-label">Phone Number</label>
                                                    <input type="text" name="phone" class="form-control form-control-alternative" placeholder="Phone Number" value="${inform.phone}">
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group focused">
                                                    <label class="form-control-label">Password</label>
                                                    <input type="password" name="password" class="form-control form-control-alternative" placeholder="Password" value="${inform.password}">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="my-4">
                                    <!-- Address -->
                                    <h6 class="heading-small text-muted mb-4">Contact information</h6>
                                    <div class="pl-lg-4">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group focused">
                                                    <label class="form-control-label" for="input-address">Email Address</label>
                                                    <input name="email" class="form-control form-control-alternative" placeholder="Email Address" value="${inform.email}" type="email">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr class="my-4">
                                    <div class="col-12 text-center">
                                        <input type="submit" class="btn btn-sm btn-primary" value="Save">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="row align-items-center justify-content-xl-between">
                <div class="col-xl-6 m-auto text-center">
                    <div class="copyright">
                        <p>Made with <a href="https://www.creative-tim.com/product/argon-dashboard" target="_blank">Argon Dashboard</a> by Creative Tim</p>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
