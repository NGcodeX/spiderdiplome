<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Spider Diplome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">

    <!-- Pace -->
    <link href="css/pace.css" rel="stylesheet">

    <!-- Perfect -->
    <link href="css/app.min.css" rel="stylesheet">
    <link href="css/app-landing.min.css" rel="stylesheet">

</head>

<body class="overflow-hidden">
<!-- Overlay Div -->
<div id="overlay" class="transparent"></div>

<div id="wrapper" class="preload">
    <header class="navbar navbar-fixed-top bg-white">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand"><span class="text-danger">Spider</span> Diplome</a>
            </div>
            <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#landing-content" class="top-link">Home</a>
                    </li>
                    <li>
                        <a href="#" class="top-link">Commentaires</a>
                    </li>
                    <li>
                        <a href="#" class="top-link">Section-Support</a>
                    </li>
                    <li>
                        <a href="connexion" class="top-link">Mon Compte</a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>

    <div id="landing-content">
        <div id="main-slider" class="carousel slide bg-dark" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
                <li data-target="#main-slider" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="img/gallery1.jpg" alt="" class="img-background">
                    <div class="row">
                        <div class="col-md-6 text-right">
                            <h2 class="m-top-lg m-right-md text-white fadeInDownLarge animation-delay3">Plateforme
                                flexible pour les étudiants du secondaire</h2>
                            <p class="text-white fadeInUpLarge animation-delay6 m-right-md hidden-xs">
                                Ce projet fait partie de l'examen final sous la supervision de <br>
                                l'Université Eng Tekoh ICT. conçu par 5 étudiants en JAVA Corporate <br>
                                Edition. approche agile avec Scrum. Semestre de printemps 2024
                            </p>
                            <a href="connexion"
                               class="btn btn-default btn-lg fadeInLeftLarge animation-delay8 m-bottom-lg m-right-md">Se
                                Connecter</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#main-slider" data-slide="prev">
            <span class="fa fa-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#main-slider" data-slide="next">
            <span class="fa fa-chevron-right"></span>
        </a>
    </div>

    <!-- ecrit une session pour le comming soon... -->
    <h1>OOA PROJECT GROUPE 9</h1>


    <footer>
        <div class="container">
            <div class="row">
                <div class="col-sm-3 padding-md">
                    <p class="font-lg">About School Registration</p>
                    <p><small>Ce projet permet aux lycéens de pouvoir postuler dans les collèges, sans avoir à
                        s'inquiéter. où qu'il soit, grâce au téléphone de son tuteur. par besoin de connaître
                        l'e-mail. juste avec un numéro de téléphone, le compte est créé et prêt pour un nouveau
                        départ à l’université.</small></p>
                </div><!-- /.col -->
                <div class="col-sm-3 padding-md">
                    <p class="font-lg">Useful Links</p>
                    <ul class="list-unstyled useful-link">
                        <li>
                            <a href="#">
                                <small><i class="fa fa-chevron-right"></i> Our Profile</small>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <small><i class="fa fa-chevron-right"></i> New School</small>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <small><i class="fa fa-chevron-right"></i> Support Portal</small>
                            </a>
                        </li>
                    </ul>
                </div><!-- /.col -->
                <div class="col-sm-3 padding-md">
                    <p class="font-lg">Stay Connect</p>
                    <a href="#" class="social-connect tooltip-test facebook-hover pull-left m-right-xs"
                       data-toggle="tooltip" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                    <a href="#" class="social-connect tooltip-test twitter-hover pull-left m-right-xs"
                       data-toggle="tooltip" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                    <a href="#" class="social-connect tooltip-test google-plus-hover pull-left m-right-xs"
                       data-toggle="tooltip" data-original-title="Google Plus"><i class="fa fa-google-plus"></i></a>
                    <a href="#" class="social-connect tooltip-test rss-hover pull-left m-right-xs"
                       data-toggle="tooltip" data-original-title="Rss feed"><i class="fa fa-rss"></i></a>
                    <a href="#" class="social-connect tooltip-test tumblr-hover pull-left m-right-xs"
                       data-toggle="tooltip" data-original-title="Tumblr"><i class="fa fa-tumblr"></i></a>
                    <a href="#" class="social-connect tooltip-test dribbble-hover pull-left m-right-xs"
                       data-toggle="tooltip" data-original-title="Dribbble"><i class="fa fa-dribbble"></i></a>
                    <a href="#" class="social-connect tooltip-test linkedin-hover pull-left m-right-xs"
                       data-toggle="tooltip" data-original-title="Linkedin"><i class="fa fa-linkedin"></i></a>
                    <a href="#" class="social-connect tooltip-test pinterest-hover pull-left" data-toggle="tooltip"
                       data-original-title="Pinterest"><i class="fa fa-pinterest"></i></a>
                </div><!-- /.col -->
                <div class="col-sm-3 padding-md">
                    <p class="font-lg">Contact Us</p>
                    Email :
                    <div class="seperator"></div>
                    <a class="btn btn-info"><i class="fa fa-envelope"></i> Contact support</a>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div>
    </footer>
</div><!-- /wrapper -->

<a href="" id="scroll-to-top" class="hidden-print"><i class="fa fa-chevron-up"></i></a>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<!-- Jquery -->
<script src="js/jquery-1.10.2.min.js"></script>

<!-- Bootstrap -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<!-- Waypoint -->
<script src='js/waypoints.min.js'></script>

<!-- LocalScroll -->
<script src='js/jquery.localscroll.min.js'></script>

<!-- ScrollTo -->
<script src='js/jquery.scrollTo.min.js'></script>

<!-- Modernizr -->
<script src='js/modernizr.min.js'></script>

<!-- Pace -->
<script src='js/pace.min.js'></script>

<!-- Popup Overlay -->
<script src='js/jquery.popupoverlay.min.js'></script>

<!-- Slimscroll -->
<script src='js/jquery.slimscroll.min.js'></script>

<!-- Cookie -->
<script src='js/jquery.cookie.min.js'></script>

<!-- Perfect -->
<script src="js/app/app.js"></script>

<script>
    $(function () {
        $('.animated-element').waypoint(function () {

            $(this).removeClass('no-animation');

        }, {offset: '70%'});

        $('.nav').localScroll({duration: 800});
    });
</script>
</div>
</body>
</html>
