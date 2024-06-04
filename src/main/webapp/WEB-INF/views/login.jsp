<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<!-- Spider-Diplome head -->
<head>
    <meta charset="utf-8">
    <title>Spider-connexion</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="spider diplome" content="Application de digitalisation des releves de note au cameroun">
    <meta name="ZEBS HAUPUR" content="Developpeur java EE">

    <!-- Spider-DIPLOME Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--  Spider-DIPLOME Font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Spider-DIPLOME Perfect -->
    <link href="css/app.min.css" rel="stylesheet">

</head>
<!-- /Spider-Diplome head -->

<!-- Spider-Diplome body -->
<body>

<!-- Spider-Diplome header -->
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
<!-- /Spider-Diplome header -->

<div class="login-wrapper">

    <!-- Spider-Diplome Logo & titre -->
    <div class="text-center">
        <h2 class="fadeInUp animation-delay8" style="font-weight:bold">
            <span class="text-success">Spider</span> <span style="color:#ccc; text-shadow:0 1px #fff">Diplomes</span>
        </h2>
    </div>
    <!-- /Spider-Diplome -->

    <!-- Spider-Diplome desc et button d' inscription -->
    <div class="login-widget animation-delay1">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <div class="pull-left">
                    <i class="fa fa-lock fa-lg"></i> Connexion-Utilisateur
                </div>

                <div class="pull-right">
                    <a class="btn btn-default btn-xs login-link" href="inscription" style="margin-top:-2px;"><i
                            class="fa fa-plus-circle"></i> S'inscrire</a>
                    <a class="btn btn-default btn-xs login-link" href="section-support" style="margin-top:-2px;"><i
                            class="fa fa-phone"></i> Assistant</a>
                </div>
            </div>
            <div class="panel-body">
                <!-- /Spider-Diplome  -->

                ${errorMessage}

                <!-- Spider-Diplome formulaire de connexion -->
                <form class="form-login" method="post" action="connexion">

                    <!-- Matricule -->
                    <div class="form-group">
                        <label><i class="fa fa-graduation-cap fa-lg"></i> Matricule ${errorIdentifiant}</label>
                        <input type="text" id="matricule" name="matricule" placeholder="Matricule ou E-mail"
                               class="form-control input-sm bounceIn animation-delay2" maxlength="14" required>
                    </div>
                    <script>
                        document.getElementById('matricule').addEventListener('input', function (e) {
                            // Regex pour les caractères de A à Z (majuscules et minuscules) et les chiffres de 0 à 9
                            var regex = /^[A-Za-z0-9]+$/;

                            // Si la valeur de l'entrée ne correspond pas à la regex ou contient un espace, supprimez le dernier caractère
                            if (!regex.test(e.target.value) || e.target.value.includes(' ')) {
                                e.target.value = e.target.value.slice(0, -1);
                            }
                        });
                    </script>
                    <!-- /Matricule -->

                    <!-- Mot de passe -->
                    <div class="form-group">
                        <label><i class="fa fa-key fa-lg"></i> Mot de passe ${errorIdentifiant}</label>
                        <input type="password" name="password" placeholder="Password"
                               class="form-control input-sm bounceIn animation-delay4" required>
                    </div>
                    <script>
                        document.querySelector('.form-login').addEventListener('submit', function (e) {
                            var password = document.querySelector('input[name="password"]');

                            if (password.value.length < 8) {
                                alert('Le mot de passe doit comporter au moins 8 caractères');
                                e.preventDefault(); // Empêche la soumission du formulaire
                            }
                        });
                    </script>

                    <!-- /Mot de passe -->

                    <!-- afficher le mot de passe -->
                    <div class="form-group">
                        <label class="label-checkbox inline">
                            <input type="checkbox" class="regular-checkbox chk-delete"/>
                            <span class="custom-checkbox info bounceIn animation-delay4"></span>
                        </label>
                        Afficher le mot de passe (confidentiel)
                    </div>
                    <script>
                        document.querySelector('.chk-delete').addEventListener('change', function () {
                            var passwordInput = document.querySelector('input[name="password"]');
                            passwordInput.type = this.checked ? 'text' : 'password';
                        });
                    </script>
                    <!-- /afficher le mot de passe -->

                    <!-- Captcha -->
                    <div class="form-group">
                        <div class="g-recaptcha" data-sitekey="6LfSq58pAAAAAObMVWDelR-tYw-U5ImOmKRM51Ou"></div>
                    </div>
                    <!-- /Captcha -->

                    <!-- bouton de connexion -->
                    <div class="form-group" style="text-align: center;">
                        <button class="btn btn-success btn-sm bounceIn animation-delay5">
                            <i class="fa fa-sign-in"></i> Se connecter
                        </button>
                    </div>
                    <!-- /bouton de connexion -->

                    <hr>

                    <!-- reinitialiser le mot de passe -->
                    <div class="form-group">
                        <a href="mot-de-passe-oublie">Cliquez ici pour réinitialiser votre mot de passe <i
                                class="fa fa-eraser fa-lg"></i></a>
                    </div>
                    <!-- /reinitialiser le mot de passe -->
                </form>
                <!-- /Spider-Diplome  -->

            </div>
        </div>
    </div>
</div>


<!-- Le javascript Spider diplome
================================================== -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<script src='js/jquery.slimscroll.min.js'></script>
<script src='js/jquery.cookie.min.js'></script>
<script src="js/app/app.js"></script>
<script>
    $(function () {
        $('.animated-element').waypoint(function () {

            $(this).removeClass('no-animation');

        }, {offset: '70%'});

        $('.nav').localScroll({duration: 800});
    });
</script>
</body>
<!-- /Spider-Diplome body -->

</html>