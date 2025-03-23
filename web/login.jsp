<%-- 
    Document   : login
    Created on : Mar 6, 2025, 4:00:33 PM
    Author     : Nguyen Duc Anh
--%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
        <link href="img/favicon.ico" rel="icon">
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/login.css"/>
    </head>
    <body>
        <div class="materialContainer">
            <form class="form-login" action="login" method="post">
                <div class="box">
                    <div class="title">LOGIN</div>
                    <p class="text-danger">${mess}</p>
                    <div class="input">
                        <label for="name">Username</label>
                        <input type="text" name="name" id="name">
                        <span class="spin"></span>
                    </div>
                    <div class="input">
                        <label for="pass">Password</label>
                        <input type="password" name="pass" id="pass">
                        <span class="spin"></span>
                    </div>
                    <div class="button login">
                        <button class="fa fa-check" type="submit">GO</button>
                    </div>
                    <a href="" class="pass-forgot">Forgot your password?</a>
                </div>
            </form>
            <form class="form-login" action="register" method="post">        
                <div class="overbox">
                    <div class="material-button alt-2"><span class="shape"></span></div>
                    <div class="title">REGISTER</div>
                    <div class="input">
                        <label for="regname">Username</label>
                        <input type="text" name="regname" id="regname">
                        <span class="spin"></span>
                    </div>                  
                    <div class="input">
                        <label for="regpass">Password</label>
                        <input type="password" name="regpass" id="regpass">
                        <span class="spin"></span>
                    </div>
                    <div class="input">
                        <label for="reregpass">Re-Password</label>
                        <input type="password" name="reregpass" id="reregpass">
                        <span class="spin"></span>
                    </div>
                    <div class="button">
                        <button class="fa fa-check" type="submit">GO</button>
                    </div>
                </div>
            </form>
        </div>

        <script>
            $(function () {

                $(".input input").focus(function () {

                    $(this).parent(".input").each(function () {
                        $("label", this).css({
                            "line-height": "18px",
                            "font-size": "18px",
                            "font-weight": "100",
                            "top": "0px"
                        })
                        $(".spin", this).css({
                            "width": "100%"
                        })
                    });
                }).blur(function () {
                    $(".spin").css({
                        "width": "0px"
                    })
                    if ($(this).val() == "") {
                        $(this).parent(".input").each(function () {
                            $("label", this).css({
                                "line-height": "60px",
                                "font-size": "24px",
                                "font-weight": "300",
                                "top": "10px"
                            })
                        });

                    }
                });

                $(".button").click(function (e) {
                    var pX = e.pageX,
                            pY = e.pageY,
                            oX = parseInt($(this).offset().left),
                            oY = parseInt($(this).offset().top);

                    $(this).append('<span class="click-efect x-' + oX + ' y-' + oY + '" style="margin-left:' + (pX - oX) + 'px;margin-top:' + (pY - oY) + 'px;"></span>')
                    $('.x-' + oX + '.y-' + oY + '').animate({
                        "width": "500px",
                        "height": "500px",
                        "top": "-250px",
                        "left": "-250px",

                    }, 600);
                    $("button", this).addClass('active');
                })

                $(".alt-2").click(function () {
                    if (!$(this).hasClass('material-button')) {
                        $(".shape").css({
                            "width": "100%",
                            "height": "100%",
                            "transform": "rotate(0deg)"
                        })

                        setTimeout(function () {
                            $(".overbox").css({
                                "overflow": "initial"
                            })
                        }, 600)

                        $(this).animate({
                            "width": "140px",
                            "height": "140px"
                        }, 500, function () {
                            $(".box").removeClass("back");

                            $(this).removeClass('active')
                        });

                        $(".overbox .title").fadeOut(300);
                        $(".overbox .input").fadeOut(300);
                        $(".overbox .button").fadeOut(300);

                        $(".alt-2").addClass('material-buton');
                    }

                })

                $(".material-button").click(function () {

                    if ($(this).hasClass('material-button')) {
                        setTimeout(function () {
                            $(".overbox").css({
                                "overflow": "hidden"
                            })
                            $(".box").addClass("back");
                        }, 200)
                        $(this).addClass('active').animate({
                            "width": "700px",
                            "height": "700px"
                        });

                        setTimeout(function () {
                            $(".shape").css({
                                "width": "50%",
                                "height": "50%",
                                "transform": "rotate(45deg)"
                            })

                            $(".overbox .title").fadeIn(300);
                            $(".overbox .input").fadeIn(300);
                            $(".overbox .button").fadeIn(300);
                        }, 700)

                        $(this).removeClass('material-button');

                    }

                    if ($(".alt-2").hasClass('material-buton')) {
                        $(".alt-2").removeClass('material-buton');
                        $(".alt-2").addClass('material-button');
                    }

                });

            });
        </script>

    </body>
</html>
