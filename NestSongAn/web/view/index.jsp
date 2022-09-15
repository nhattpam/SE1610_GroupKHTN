<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nest Song Ân</title>
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
        <!-- start-smoth-scrolling -->
    </head>

    <body>
        <!-- header -->
        <div class="agileits_header">
            <div class="w3l_offers">
                <a href="products.html">Today's special Offers !</a>
            </div>
            <div class="w3l_search">
                <form action="#" method="post">
                    <input type="text" name="Product" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value === '') {
                                this.value = 'Search a product...';
                            }" required="">
                    <input type="submit" value=" ">
                </form>
            </div>
            <div class="product_list_header">  
                <form action="#" method="post" class="last">
                    <fieldset>
                        <input type="hidden" name="cmd" value="_cart" />
                        <input type="hidden" name="display" value="1" />
                        <input type="submit" name="submit" value="View your cart" class="button" />
                    </fieldset>
                </form>
            </div>
            <div class="w3l_header_right">
                <ul>
                    <li class="dropdown profile_details_drop">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
                        <div class="mega-dropdown-menu">
                            <div class="w3ls_vegetables">
                                <ul class="dropdown-menu drp-mnu">
                                    <li><a href="login.html">Login</a></li> 
                                    <li><a href="login.html">Sign Up</a></li>
                                </ul>
                            </div>                  
                        </div>	
                    </li>
                </ul>
            </div>
            <div class="w3l_header_right1">
                <h2><a href="mail.html">Contact Us</a></h2>
            </div>
            <div class="clearfix"> </div>
        </div>
        <!-- script-for sticky-nav -->
        <script>
            $(document).ready(function () {
                var navoffeset = $(".agileits_header").offset().top;
                $(window).scroll(function () {
                    var scrollpos = $(window).scrollTop();
                    if (scrollpos >= navoffeset) {
                        $(".agileits_header").addClass("fixed");
                    } else {
                        $(".agileits_header").removeClass("fixed");
                    }
                });

            });
        </script>
        <!-- //script-for sticky-nav -->
        <div class="logo_products">
            <div class="container">
                <div class="w3ls_logo_products_left">
                    <h1><a href="index.html"><span>Nest</span> Song Ân</a></h1>
                </div>
                <div class="w3ls_logo_products_left1">
                    <ul class="special_items">
                        <li><a href="events.html">VỀ SONG ÂN</a><i>/</i></li>
                        <li><a href="about.html">SẢN PHẨM TỔ YẾN</a><i>/</i></li>
                        <li><a href="products.html">CẨM NANG YẾN SÀO</a><i>/</i></li>
                        <li><a href="services.html">LIÊN HỆ</a></li>
                    </ul>
                </div>
                <div class="w3ls_logo_products_left1">
                    <ul class="phone_email">
                        <li><i class="fa fa-phone" aria-hidden="true"></i>(+84) 999 888 123</li>
                        <li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="khtnholdings.work@gmail.com">khtnholdings.work@gmail.com</a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //header -->
        <!-- banner -->
        <div class="banner">
            <div class="w3l_banner_nav_left">
                <nav class="navbar nav_bottom">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header nav_2">
                        <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div> 
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                        <ul class="nav navbar-nav nav_1">
                            <li><a href="products.html">Branded Foods</a></li>
                            <li><a href="household.html">Households</a></li>
                            <li class="dropdown mega-dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Veggies & Fruits<span class="caret"></span></a>				
                                <div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
                                    <div class="w3ls_vegetables">
                                        <ul>	
                                            <li><a href="vegetables.html">Vegetables</a></li>
                                            <li><a href="vegetables.html">Fruits</a></li>
                                        </ul>
                                    </div>                  
                                </div>				
                            </li>
                            <li><a href="kitchen.html">Kitchen</a></li>
                            <li><a href="short-codes.html">Short Codes</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Beverages<span class="caret"></span></a>
                                <div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
                                    <div class="w3ls_vegetables">
                                        <ul>
                                            <li><a href="drinks.html">Soft Drinks</a></li>
                                            <li><a href="drinks.html">Juices</a></li>
                                        </ul>
                                    </div>                  
                                </div>	
                            </li>
                            <li><a href="pet.html">Pet Food</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Frozen Foods<span class="caret"></span></a>
                                <div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
                                    <div class="w3ls_vegetables">
                                        <ul>
                                            <li><a href="frozen.html">Frozen Snacks</a></li>
                                            <li><a href="frozen.html">Frozen Nonveg</a></li>
                                        </ul>
                                    </div>                  
                                </div>	
                            </li>
                            <li><a href="bread.html">Bread & Bakery</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
            </div>
            <div class="w3l_banner_nav_right">
                <section class="slider">
                    <div class="flexslider">
                        <ul class="slides">
                            <li>
                                <div class="w3l_banner_nav_right_banner">

                                </div>
                            </li>
                            <li>
                                <div class="w3l_banner_nav_right_banner1">

                                </div>
                            </li>
                            <li>
                                <div class="w3l_banner_nav_right_banner2">

                                </div>
                            </li>
                        </ul>
                    </div>
                </section>
                <!-- flexSlider -->
                <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
                <script defer src="js/jquery.flexslider.js"></script>
                <script type="text/javascript">
            $(window).load(function () {
                $('.flexslider').flexslider({
                    animation: "slide",
                    start: function (slider) {
                        $('body').removeClass('loading');
                    }
                });
            });
                </script>
                <!-- //flexSlider -->
            </div>
            <div class="clearfix"></div>
        </div>
        <!-- banner -->
        <div class="banner_bottom">
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-4 ve-song-an">

                </div>
                <div class="col-md">

                </div>

                <div class="col-md-4">
                    <span style="font-size: 40px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Về</span>&nbsp;&nbsp;
                    <span style="color: #d5a554; font-size: 35px; font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Song Ân</span>
                    <br><br>
                    <p style="text-align: justify; font-family: 'Nunito Sans', sans-serif; font-size: larger; font-weight: bolder">
                        Tính đến 2022, Song Ân đã sở hữu hơn 20 nhà gọi yến 
                        trải dài khắp Việt Nam. Trong đó tập trung nhiều nhất tại 
                        Bình Thuận, Đồng Nai và các tỉnh Tây Nguyên. Đây chính là cơ sở 
                        giúp cho Song Ân tự tin mang
                        đến cho khách hàng những sản phẩm tổ yến CHẤT LƯỢNG THẬT – GIÁ THẬT.
                    </p>
                    <hr class="duongLine">
                    <div class="icon_nha"></div>
                    <br>
                    <h3 style="font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Xây Nhà Gọi Yến</h3>
                    <p style="text-align: justify; font-family: 'Nunito Sans', sans-serif; font-size: larger; font-weight: bolder">Liên tục đầu tư xây dựng nhà gọi yến mới, đảm bảo cung ứng đủ nhu cầu ngày một tăng của khách hàng.</p>
                    <div class="icon_phan-phoi"></div>
                    <br>
                    <h3 style="font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Phân Phối Tổ Yến</h3>
                    <p style="text-align: justify; font-family: 'Nunito Sans', sans-serif; font-size: larger; font-weight: bolder">Sản phẩm đa dạng, chất lượng đảm bảo, nhiều mức giá. Đáp ứng tốt mọi nhu cầu của người dùng.</p>
                    <br>
                    <!--Xem thêm button-->
                    <h4><a href="" style="color: #891319;">Xem thêm  ></a></h4>


                </div>
            </div>
            <div class="col-md-1">

            </div>
        </div>

        <!--Sản phẩm cung cấp-->
        <div class="san-pham-cung-cap">
            <div class="container">
                <div class="row" style="padding-bottom: 50px;">

                    <div class="col-md-12 text-center" style="padding-top: 40px;">

                        <span style="font-size: 40px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Sản Phẩm</span>&nbsp;&nbsp;
                        <span style="color: #d5a554; font-size: 35px; font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Cung Cấp</span>
                        <br>
                        <br>
                        <br>

                    </div>
                    <div class="row">

                        <div class="col-md-3">
                            <div class="service-row">

                                <img style="width: 100%; height:400px;" class="img-responsive" src="images/danh-sach-san-pham-to-yen-01.jpg" />
                                <div class="service-item text-center">
                                    <h3 class="sertice-item-titile">Tổ yến tinh chế</h3>
                                    <a class="button1 text-center" href="https://www.niemvuilaptrinh.com/">
                                        <span class="btn1">Xem thêm</span>
                                    </a>
                                </div>

                            </div>


                        </div>

                        <div class="col-md-3">
                            <div class="service-row"> 
                                <img  style="width: 100%; height:400px;" class="img-responsive" src="images/danh-sach-san-pham-to-yen-0202-600x702.jpg" />
                                <div class="service-item text-center">
                                    <h3 class="sertice-item-titile">Tổ yến thô</h3>
                                    <a class="button1 text-center" href="https://www.niemvuilaptrinh.com/">
                                        <span class="btn1">Xem thêm</span>
                                    </a>
                                </div>

                            </div>

                        </div>

                        <div class="col-md-3">
                            <div class="service-row">

                                <img   style="width: 100%; height:400px;" class="img-responsive" src="images/danh-sach-san-pham-to-yen-03.jpg" />
                                <div  class="service-item text-center">
                                    <h3 class="sertice-item-titile">Yến chưng sẵn</h3>
                                    <a class="button1 text-center" href="https://www.niemvuilaptrinh.com/">
                                        <span class="btn1">Xem thêm</span>
                                    </a>

                                </div>

                            </div>


                        </div>
                        <div class="col-md-3">
                            <div class="service-row">

                                <img   style="width: 100%; height:400px;" class="img-responsive" src="images/danh-sach-san-pham-to-yen-04.jpg" />
                                <div  class="service-item text-center">
                                    <h3 class="sertice-item-titile">Yến tươi</h3>
                                    <a class="button1 text-center" href="https://www.niemvuilaptrinh.com/">
                                        <span class="btn1">Xem thêm</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Sản phẩm cung cấp-->

        <!-- Chất lượng tổ yến -->
        <div class="chat-luong-to-yen">
            <div class="container">
                <div class="row">

                    <div class="col-md-12 text-center">

                        <span style="font-size: 40px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Chất Lượng</span>&nbsp;&nbsp;
                        <span style="color: #d5a554; font-size: 35px; font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Tổ Yến</span>
                        <br>
                        <br>
                        <h4 style="font-family: 'Nunito Sans', sans-serif; font-weight: bold;">Tổ yến được mệnh danh là một trong bát trân của nền văn hóa ẩm thực Việt Nam</h4>
                        <br>
                        <br>
                        
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="item">
                                <p class="item-title" style="font-size: 20px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif;">Trong tổ yến nguyên chất có chứa hơn <strong>18 loại acid amin</strong> cùng nhiều khoáng chất quan trọng cho sức khỏe mà cơ thể con người không tự tổng hợp được.</p>
                                <br>
                                <p style="font-size: 20px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif; font-weight: bolder;">Báo cáo khoa học</p>
                                <p style="font-size: 16px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif;">Viện Hàn lâm Khoa học & Công nghệ Việt Nam</p>

                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="item">
                                <p class="item-title" style="font-size: 20px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif;">Tổ yến <strong>chỉ có giá trị về dinh dưỡng</strong> chứ chưa có một nghiên cứu chính xác nào chứng minh chúng có tác dụng chữa trị ung thư hay HIV/AIDS.</p>
                                <br>
                                <p style="font-size: 20px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif; font-weight: bolder;">Bác sĩ. Nguyễn Xuân Hướng</p>
                                <p style="font-size: 16px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif;">Nguyên chủ tịch Hiệp hội Đông y Việt Nam</p>

                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="item">
                                <p class="item-title" style="font-size: 20px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif;">Ngoài tác dụng bồi bổ sức khỏe thì tổ yến còn hỗ trợ tăng cường chức năng tim mạch, kích thích tiêu hóa, làm đẹp da cũng như hỗ trợ hồi phục vết thương.</p>
                                <br>
                                <p style="font-size: 20px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif; font-weight: bolder;">Báo cáo khoa học</p>
                                <p style="font-size: 16px; color: #4a5d43; font-family: 'Nunito Sans', sans-serif;">Viện Hàn lâm Khoa học & Công nghệ Việt Nam</p>

                            </div>
                        </div>
                    </div>
            </div>
        </div>
        <!-- Chất lượng tổ yến -->


        <!-- top-brands -->
        <div class="top-brands" style="margin-top: 60px;">
            <div class="container">
                <h3>Hot Offers</h3>
                <div class="agile_top_brands_grids">
                    <div class="col-md-3 top_brand_left">
                        <div class="hover14 column">
                            <div class="agile_top_brand_left_grid">
                                <div class="tag"><img src="images/tag.png" alt=" " class="img-responsive" /></div>
                                <div class="agile_top_brand_left_grid1">
                                    <figure>
                                        <div class="snipcart-item block" >
                                            <div class="snipcart-thumb">
                                                <a href="single.html"><img title=" " alt=" " src="images/1.png" /></a>		
                                                <p>fortune sunflower oil</p>
                                                <h4>$7.99 <span>$10.00</span></h4>
                                            </div>
                                            <div class="snipcart-details top_brand_home_details">
                                                <form action="checkout.html" method="post">
                                                    <fieldset>
                                                        <input type="hidden" name="cmd" value="_cart" />
                                                        <input type="hidden" name="add" value="1" />
                                                        <input type="hidden" name="business" value=" " />
                                                        <input type="hidden" name="item_name" value="Fortune Sunflower Oil" />
                                                        <input type="hidden" name="amount" value="7.99" />
                                                        <input type="hidden" name="discount_amount" value="1.00" />
                                                        <input type="hidden" name="currency_code" value="USD" />
                                                        <input type="hidden" name="return" value=" " />
                                                        <input type="hidden" name="cancel_return" value=" " />
                                                        <input type="submit" name="submit" value="Add to cart" class="button" />
                                                    </fieldset>

                                                </form>

                                            </div>
                                        </div>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 top_brand_left">
                        <div class="hover14 column">
                            <div class="agile_top_brand_left_grid">
                                <div class="agile_top_brand_left_grid1">
                                    <figure>
                                        <div class="snipcart-item block" >
                                            <div class="snipcart-thumb">
                                                <a href="single.html"><img title=" " alt=" " src="images/3.png" /></a>		
                                                <p>basmati rise (5 Kg)</p>
                                                <h4>$11.99 <span>$15.00</span></h4>
                                            </div>
                                            <div class="snipcart-details top_brand_home_details">
                                                <form action="#" method="post">
                                                    <fieldset>
                                                        <input type="hidden" name="cmd" value="_cart" />
                                                        <input type="hidden" name="add" value="1" />
                                                        <input type="hidden" name="business" value=" " />
                                                        <input type="hidden" name="item_name" value="basmati rise" />
                                                        <input type="hidden" name="amount" value="11.99" />
                                                        <input type="hidden" name="discount_amount" value="1.00" />
                                                        <input type="hidden" name="currency_code" value="USD" />
                                                        <input type="hidden" name="return" value=" " />
                                                        <input type="hidden" name="cancel_return" value=" " />
                                                        <input type="submit" name="submit" value="Add to cart" class="button" />
                                                    </fieldset>
                                                </form>
                                            </div>
                                        </div>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 top_brand_left">
                        <div class="hover14 column">
                            <div class="agile_top_brand_left_grid">
                                <div class="agile_top_brand_left_grid_pos">
                                    <img src="images/offer.png" alt=" " class="img-responsive" />
                                </div>
                                <div class="agile_top_brand_left_grid1">
                                    <figure>
                                        <div class="snipcart-item block">
                                            <div class="snipcart-thumb">
                                                <a href="single.html"><img src="images/2.png" alt=" " class="img-responsive" /></a>
                                                <p>Pepsi soft drink (2 Ltr)</p>
                                                <h4>$8.00 <span>$10.00</span></h4>
                                            </div>
                                            <div class="snipcart-details top_brand_home_details">
                                                <form action="#" method="post">
                                                    <fieldset>
                                                        <input type="hidden" name="cmd" value="_cart" />
                                                        <input type="hidden" name="add" value="1" />
                                                        <input type="hidden" name="business" value=" " />
                                                        <input type="hidden" name="item_name" value="Pepsi soft drink" />
                                                        <input type="hidden" name="amount" value="8.00" />
                                                        <input type="hidden" name="discount_amount" value="1.00" />
                                                        <input type="hidden" name="currency_code" value="USD" />
                                                        <input type="hidden" name="return" value=" " />
                                                        <input type="hidden" name="cancel_return" value=" " />
                                                        <input type="submit" name="submit" value="Add to cart" class="button" />
                                                    </fieldset>
                                                </form>
                                            </div>
                                        </div>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 top_brand_left">
                        <div class="hover14 column">
                            <div class="agile_top_brand_left_grid">
                                <div class="agile_top_brand_left_grid_pos">
                                    <img src="images/offer.png" alt=" " class="img-responsive" />
                                </div>
                                <div class="agile_top_brand_left_grid1">
                                    <figure>
                                        <div class="snipcart-item block">
                                            <div class="snipcart-thumb">
                                                <a href="single.html"><img src="images/4.png" alt=" " class="img-responsive" /></a>
                                                <p>dogs food (4 Kg)</p>
                                                <h4>$9.00 <span>$11.00</span></h4>
                                            </div>
                                            <div class="snipcart-details top_brand_home_details">
                                                <form action="#" method="post">
                                                    <fieldset>
                                                        <input type="hidden" name="cmd" value="_cart" />
                                                        <input type="hidden" name="add" value="1" />
                                                        <input type="hidden" name="business" value=" " />
                                                        <input type="hidden" name="item_name" value="dogs food" />
                                                        <input type="hidden" name="amount" value="9.00" />
                                                        <input type="hidden" name="discount_amount" value="1.00" />
                                                        <input type="hidden" name="currency_code" value="USD" />
                                                        <input type="hidden" name="return" value=" " />
                                                        <input type="hidden" name="cancel_return" value=" " />
                                                        <input type="submit" name="submit" value="Add to cart" class="button" />
                                                    </fieldset>
                                                </form>
                                            </div>
                                        </div>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //top-brands -->
        <!-- fresh-vegetables -->
        <div class="fresh-vegetables">
            <div class="container">
                <h3>Top Products</h3>
                <div class="w3l_fresh_vegetables_grids">
                    <div class="col-md-3 w3l_fresh_vegetables_grid w3l_fresh_vegetables_grid_left">
                        <div class="w3l_fresh_vegetables_grid2">
                            <ul>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">All Brands</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="vegetables.html">Vegetables</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="vegetables.html">Fruits</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="drinks.html">Juices</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="pet.html">Pet Food</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="bread.html">Bread & Bakery</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="household.html">Cleaning</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">Spices</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">Dry Fruits</a></li>
                                <li><i class="fa fa-check" aria-hidden="true"></i><a href="products.html">Dairy Products</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-9 w3l_fresh_vegetables_grid_right">
                        <div class="col-md-4 w3l_fresh_vegetables_grid">
                            <div class="w3l_fresh_vegetables_grid1">
                                <img src="images/8.jpg" alt=" " class="img-responsive" />
                            </div>
                        </div>
                        <div class="col-md-4 w3l_fresh_vegetables_grid">
                            <div class="w3l_fresh_vegetables_grid1">
                                <div class="w3l_fresh_vegetables_grid1_rel">
                                    <img src="images/7.jpg" alt=" " class="img-responsive" />
                                    <div class="w3l_fresh_vegetables_grid1_rel_pos">
                                        <div class="more m1">
                                            <a href="products.html" class="button--saqui button--round-l button--text-thick" data-text="Shop now">Shop now</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="w3l_fresh_vegetables_grid1_bottom">
                                <img src="images/10.jpg" alt=" " class="img-responsive" />
                                <div class="w3l_fresh_vegetables_grid1_bottom_pos">
                                    <h5>Special Offers</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 w3l_fresh_vegetables_grid">
                            <div class="w3l_fresh_vegetables_grid1">
                                <img src="images/9.jpg" alt=" " class="img-responsive" />
                            </div>
                            <div class="w3l_fresh_vegetables_grid1_bottom">
                                <img src="images/11.jpg" alt=" " class="img-responsive" />
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                        <div class="agileinfo_move_text">
                            <div class="agileinfo_marquee">
                                <h4>get <span class="blink_me">25% off</span> on first order and also get gift voucher</h4>
                            </div>
                            <div class="agileinfo_breaking_news">
                                <span> </span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //fresh-vegetables -->

        <!-- footer -->
        <div class="footer">
            <div class="container">
                <div class="col-md-3 w3_footer_grid">
                    <h3>information</h3>
                    <ul class="w3_footer_grid_list">
                        <li><a href="events.html">Events</a></li>
                        <li><a href="about.html">About Us</a></li>
                        <li><a href="products.html">Best Deals</a></li>
                        <li><a href="services.html">Services</a></li>
                        <li><a href="short-codes.html">Short Codes</a></li>
                    </ul>
                </div>
                <div class="col-md-3 w3_footer_grid">
                    <h3>policy info</h3>
                    <ul class="w3_footer_grid_list">
                        <li><a href="faqs.html">FAQ</a></li>
                        <li><a href="privacy.html">privacy policy</a></li>
                        <li><a href="privacy.html">terms of use</a></li>
                    </ul>
                </div>
                <div class="col-md-3 w3_footer_grid">
                    <h3>what in stores</h3>
                    <ul class="w3_footer_grid_list">
                        <li><a href="pet.html">Pet Food</a></li>
                        <li><a href="frozen.html">Frozen Snacks</a></li>
                        <li><a href="kitchen.html">Kitchen</a></li>
                        <li><a href="products.html">Branded Foods</a></li>
                        <li><a href="household.html">Households</a></li>
                    </ul>
                </div>
                <!--                <div class="col-md-3 w3_footer_grid">
                                    <h3>twitter posts</h3>
                                    <ul class="w3_footer_grid_list1">
                                        <li><label class="fa fa-twitter" aria-hidden="true"></label><i>01 day ago</i><span>Non numquam <a href="#">http://sd.ds/13jklf#</a>
                                                eius modi tempora incidunt ut labore et
                                                <a href="#">http://sd.ds/1389kjklf#</a>quo nulla.</span></li>
                                        <li><label class="fa fa-twitter" aria-hidden="true"></label><i>02 day ago</i><span>Con numquam <a href="#">http://fd.uf/56hfg#</a>
                                                eius modi tempora incidunt ut labore et
                                                <a href="#">http://fd.uf/56hfg#</a>quo nulla.</span></li>
                                    </ul>
                                </div>-->
                <div class="clearfix"> </div>
                <div class="agile_footer_grids">
                    <div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
                        <div class="w3_footer_grid_bottom">
                            <h4>100% secure payments</h4>
                            <img src="images/card.png" alt=" " class="img-responsive" />
                        </div>
                    </div>
                    <div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
                        <div class="w3_footer_grid_bottom">
                            <h5>connect with us</h5>
                            <ul class="agileits_social_icons">
                                <li><a href="https://www.facebook.com/nest.song.an" class="facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="instagram"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="dribbble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="wthree_footer_copy">
                    <p>© 2022 Nest Song An. All rights reserved | Design by KHTN</p>
                </div>
            </div>
        </div>
        <!-- //footer -->
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $(".dropdown").hover(
                        function () {
                            $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                            $(this).toggleClass('open');
                        },
                        function () {
                            $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                            $(this).toggleClass('open');
                        }
                );
            });
        </script>
        <!-- here stars scrolling icon -->
        <script type="text/javascript">
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */

                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <!-- //here ends scrolling icon -->
        <script src="js/minicart.js"></script>
        <script>
            paypal.minicart.render();

            paypal.minicart.cart.on('checkout', function (evt) {
                var items = this.items(),
                        len = items.length,
                        total = 0,
                        i;

                // Count the number of each item in the cart
                for (i = 0; i < len; i++) {
                    total += items[i].get('quantity');
                }

                if (total < 3) {
                    alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
                    evt.preventDefault();
                }
            });

        </script>
    </body>
</html>
