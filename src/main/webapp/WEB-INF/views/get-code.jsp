<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Spider-code</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/app.min.css" rel="stylesheet">
</head>

<!-- Spider-Diplome logo & titre -->
<body>

<header class="navbar navbar-fixed-top bg-white">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand"><span class="text-success">Spider</span> Diplome</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#" class="top-link">Commentaires</a>
                </li>
                <li>
                    <a href="#" class="top-link">Section-Support</a>
                </li>
            </ul>
        </nav>
    </div>
</header>
    <div class="login-wrapper">
        <div class="text-center">
            <h2 class="fadeInUp animation-delay8" style="font-weight:bold">
                <span class="text-success">Spider</span> <span style="color:#ccc; text-shadow:0 1px #fff">Diplome</span>
            </h2>
        </div>
        <!-- /Spider-Diplome -->

        <!-- Spider-Diplome desc et boutton d inscription, connexion et support -->
        <div class="login-widget animation-delay1">
            <div class="panel panel-default">
                <div class="panel-heading clearfix">
                    <div class="pull-left">
                        <i class="fa fa-key fa-lg"></i> Verification code <i class="fa fa-user fa-lg"></i>
                    </div>

                    <div class="pull-right">
                        <a class="btn btn-default btn-xs login-link" href="connexion" style="margin-top:-2px;"><i
                                class="fa fa-sign-in"></i> Se connecter</a>
                        <a class="btn btn-default btn-xs login-link" href="inscription" style="margin-top:-2px;"><i
                                class="fa fa-plus-circle"></i> S'inscrire</a>
                        <a class="btn btn-default btn-xs login-link" href="section-support" style="margin-top:-2px;"><i
                                class="fa fa-phone"></i> Assistant</a>
                    </div>
                </div>
                <!-- /Spider-Diplome -->

                <!-- Spider-Diplome mise en contexe de l utilisateur sur l'envoie du code -->
                <div class="panel-body">
                    <div class="form-group">
                        <div class="controls">
                            Entrer le code que nous avons envoyer au telephone de votre tuteur.
                            ou contacter<a href="#" class="primary-font login-link">
                                Minesec Support</a>
                        </div>
                    </div>
                    <h5 class="headline">
                       Entrer le code Ici
                        <span class="line"></span>
                    </h5>
                    <div class="form-group">
                        <div class="controls">
                            si le code n'est pas encore arrivé après 1 min, cliquez ici pour <a href="#"
                                class="primary-font login-link"> <i class="fa fa-info-circle"></i> renvoyer le code.</a>
                        </div>
                    </div>
                    <h5>
                        <div class="form-group">
                            <span class="label label-danger">

                            </span>
                        </div>
                    </h5>

                    <!-- Spider-Diplome Formulaire d'entrer  du code -->
                    <form class="form-login" method="post" action="verification-code">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label><i class="fa fa-key fa-lg"></i> Code</label>
                                    <input name="verificationcode" required type="text" placeholder="XXX-XXX-XXX"
                                        class="form-control input-sm bounceIn animation-delay4">
                                </div>
                            </div>
                            <div class="col-md-6">

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="g-recaptcha" data-sitekey="6LfSq58pAAAAAObMVWDelR-tYw-U5ImOmKRM51Ou"></div>
                        </div>
                        <div class="panel-footer" style="text-align: center;">
                            <button type="submit" class="btn btn-success"><i class="fa fa-sign-in"></i> Envoyer</button>
                        </div>
                    </form>
                    <!-- /Spider-Diplome -->

                </div>
            </div>
        </div>
    </div>

    <!-- Le javascript Spider-Diplome
    ================================================== -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src='js/modernizr.min.js'></script>
    <script src='js/pace.min.js'></script>
    <script src='js/jquery.popupoverlay.min.js'></script>
    <script src='js/jquery.slimscroll.min.js'></script>
    <script src='js/jquery.cookie.min.js'></script>
    <script src="js/app/app.js"></script>
</body>

</html>