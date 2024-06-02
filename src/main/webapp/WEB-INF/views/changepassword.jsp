<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Spider-Changer mot de Passe</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/datepicker.css" rel="stylesheet" />
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
                        <i class="fa fa-lock fa-lg"></i> changement <i class="fa fa-user fa-lg"></i>
                    </div>
                    <div class="pull-right">
                        <a class="btn btn-default btn-xs login-link" href="connexion" style="margin-top:-2px;"><i
                                class="fa fa-sign-in"></i> Se connecter</a>
                        <a class="btn btn-default btn-xs login-link" href="inscription" style="margin-top:-2px;"><i
                                class="fa fa-plus-circle"></i> S'inscrire</a>
                        <a class="btn btn-default btn-xs login-link" href="#" style="margin-top:-2px;"><i
                                class="fa fa-phone"></i> Assistant</a>
                    </div>
                </div>
                <!-- /Spider-Diplome -->

                <!-- Spider-Diplome mise en contexe de l utilisateur sur la memorisation du nouveau mot de passe -->
                <div class="panel-body">
                    <h4 class="headline">
                        NOUVEAU MOT DE PASSE <i class="fa fa-database fa-lg"></i>
                        <span class="line"></span>
                    </h4>
                    <div class="form-group">
                        <div class="controls">
                            Veuillez vous assurer que vous connaissez et mémorisez <i class="fa fa-info-circle"></i> le
                            mot de passe.
                            si vous avez besoin d'aide, contactez password.
                            <a href="login" class="primary-font login-link"> Minesec Support</a>
                        </div>
                    </div>
                    <h5>
                        <div class="form-group">
                            <span class="label label-danger">
                                <c:out value="${errorpasss}" />
                            </span>
                        </div>
                    </h5>

                    <!-- Spider-Diplome Formulaire de modification du mot de passe ( nouveau mot de passe) -->
                    <form class="form-login" method="post" action="change-password">
                        <div class="form-group">
                            <label><i class="fa fa-graduation-cap fa-lg"></i> Votre matricule est:</label>
                            <input disabled type="text" name="matricule" placeholder="CM-XXX-XXX-XXX"
                                class="form-control input-sm bounceIn animation-delay2">
                        </div>
                        <div class="form-group">
                            <label><i class="fa fa-graduation-cap fa-lg"></i> Nom d'utilisateur du compte</label>
                            <input disabled type="text" name="username" placeholder="NGUENA ZEBS"
                                class="form-control input-sm bounceIn animation-delay4">
                        </div>
                        <div class="form-group">
                            <label><i class="fa fa-key fa-lg"></i>New Password <span class="label label-danger">
                                </span></label>
                            <input type="password" name="newpassword" placeholder="Nouveau mot de passe"
                                class="form-control input-sm bounceIn animation-delay6" required>
                        </div>
                        <div class="form-group">
                            <label><i class="fa fa-key fa-lg"></i>Confirm Password <span class="label label-danger">
                                </span></label>
                            <input type="password" name="confpassword" placeholder="************"
                                class="form-control input-sm bounceIn animation-delay8" required>
                        </div>
                        <div class="g-recaptcha" data-sitekey="6LfSq58pAAAAAObMVWDelR-tYw-U5ImOmKRM51Ou"></div>
                        <br>
                        <div class="panel-footer" style="text-align: center;">
                            <button type="submit" class="btn btn-success input-sm bounceIn animation-delay10"><i class="fa fa-sign-in"></i> Reset Pass Word
                            </button>
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
    <script src='js/bootstrap-datepicker.min.js'></script>
    <script src='js/jquery.popupoverlay.min.js'></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script src='js/jquery.slimscroll.min.js'></script>
    <script src='js/jquery.cookie.min.js'></script>
    <script src="js/app/app.js"></script>
</body>

</html>