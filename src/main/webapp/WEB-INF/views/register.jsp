<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<!-- Spider-Diplome head -->
<head>
    <meta charset="utf-8">
    <title>Spider-S'inscrire</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="spider diplome" content="Application de digitalisation des releves de note au cameroun">
    <meta name="ZEBS HAUPUR" content="Developpeur java EE">

    <!-- Spider-DIPLOME Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Spider-DIPLOME Font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Spider-DIPLOME Perfect -->
    <link href="css/app.min.css" rel="stylesheet">
    <link href="css/app-skin.css" rel="stylesheet">

</head>
<!-- /Spider-Diplome head -->

<!-- Spider-Diplome body -->
<body>

<!-- Spider-DIPLOME Navbar -->
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
<!-- /Spider-DIPLOME -->


<div class="login-wrapper">
    <!-- Spider-Diplome Logo & titre -->
    <div class="text-center">
        <h2 class="fadeInUp animation-delay8" style="font-weight:bold">
            <span class="text-success">Spider</span> <span style="color:#ccc; text-shadow:0 1px #fff">Diplome</span>
        </h2>
    </div>
    <!-- /Spider-Diplome -->

    <!-- Spider-Diplome desc et button d' inscription -->
    <div class="login-widget animation-delay1">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <div class="pull-left">
                    <i class="fa fa-lock fa-lg"></i> Inscription-Utilisateur
                </div>

                <div class="pull-right">
                    <a class="btn btn-default btn-xs login-link" href="connexion" style="margin-top:-2px;"><i
                            class="fa fa-sign-in"></i> Se connecter</a>
                    <a class="btn btn-default btn-xs login-link" href="section-support" style="margin-top:-2px;"><i
                            class="fa fa-phone"></i> Assistant</a>
                </div>
            </div>
            <!-- /Spider-Diplome -->

            <!-- Spider-Diplome etape de creation de compte section -->
            <div class="panel-body">
                ${errorMessage}
                ${successMessage}
                <h5 class="headline">
                    AVOIR UN COMPTE
                    <span class="line"></span>
                </h5>

                <div class="panel panel-default">
                    <div class="panel-heading">
                        Suiver ces etapes pour avoir un compte d'utilisateur.
                    </div>
                    <div class="panel-tab">
                        <ul class="wizard-steps" id="wizardTab">
                            <li class="active">
                                <a href="#wizardContent1" data-toggle="tab">Etape 1</a>
                            </li>
                            <li>
                                <a href="#wizardContent2" data-toggle="tab">Etape 2</a>
                            </li>
                            <li>
                                <a href="#wizardContent3" data-toggle="tab">Etape 3</a>
                            </li>
                        </ul>
                    </div>
                    <div class="panel-body">
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="wizardContent1">
                                <p>Soumission du dossier de candidature <br>
                                    Objectif : Collecter les documents nécessaires et les informations de base pour
                                    créer le compte du candidat. <br>

                                </p>
                            </div>
                            <div class="tab-pane fade" id="wizardContent2">
                                <p>Vérification et validation du dossier <br>
                                    Objectif : Vérifier l'authenticité et la complétude du dossier soumis par le
                                    candidat.</p>
                            </div>
                            <div class="tab-pane fade dark" id="wizardContent3">
                                <p>Création du compte et génération des identifiants</p>

                                <!-- Spider-Diplome Formulaire d'inscription -->
                                <form method="post" action="inscription" class="no-margin">
                                    <div class="panel-heading">
                                        Informations confidentielles
                                    </div>
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label class="control-label">Nom (Comme sur l'acte)</label>
                                            <input type="text" id="firstname" name="firstname" required
                                                   placeholder="Username" class="form-control input-sm"
                                                   data-required="true" data-minlength="8">
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">Prenom (Comme sur l'acte)</label>
                                            <input type="text" id="lastname" name="lastname" required
                                                   placeholder="Username" class="form-control input-sm"
                                                   data-required="true" data-minlength="8">
                                        </div>

                                        <script>
                                            document.getElementById('firstname').addEventListener('input', function (e) {
                                                // Convertir en majuscules
                                                e.target.value = e.target.value.toUpperCase();
                                                // Supprimer tout caractère non alphabétique, non apostrophe, non tiret et non espace
                                                e.target.value = e.target.value.replace(/[^A-Z' -]/g, '');
                                            });

                                            document.getElementById('lastname').addEventListener('input', function (e) {
                                                // Convertir en majuscules
                                                e.target.value = e.target.value.toUpperCase();
                                                // Supprimer tout caractère non alphabétique, non apostrophe, non tiret et non espace
                                                e.target.value = e.target.value.replace(/[^A-Z' -]/g, '');
                                            });
                                        </script>

                                        <div class="form-group">
                                            <label class="control-label">Telephone ou E-mail (Du tuteur Legal)</label>
                                            <input type="text" id="phone" name="phoneEmail" required placeholder="Username"
                                                   class="form-control input-sm" data-required="true"
                                                   data-minlength="8">
                                        </div>

                                        <script>
                                            document.getElementById('phone').addEventListener('input', function (e) {
                                                // Supprimer tout caractère non numérique, non lettre, non point, non tiret et non @
                                                e.target.value = e.target.value.replace(/[^0-9a-zA-Z.@-]/g, '');
                                            });
                                        </script>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Password</label>
                                                    <input type="password" name="password" placeholder="Password"
                                                           class="form-control input-sm" id="password"
                                                           data-required="true" data-minlength="8">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label">Confirm Password</label>
                                                    <input type="password" name="confpassword" required
                                                           placeholder="Confirm Password" class="form-control input-sm"
                                                           data-equalto="#password" data-required="true">
                                                </div>
                                            </div>
                                        </div>

                                        <script>
                                            document.querySelector('form').addEventListener('submit', function (e) {
                                                var password = document.querySelector('input[name="password"]');
                                                var confirmPassword = document.querySelector('input[name="confpassword"]');

                                                if (password.value.length < 8) {
                                                    alert('Le mot de passe doit comporter au moins 8 caractères');
                                                    e.preventDefault(); // Empêche la soumission du formulaire
                                                } else if (password.value !== confirmPassword.value) {
                                                    alert('Les mots de passe ne correspondent pas');
                                                    e.preventDefault(); // Empêche la soumission du formulaire
                                                }
                                            });
                                        </script>

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
                                    </div>

                                    <div class="form-group">
                                        <div class="g-recaptcha" data-sitekey="6LfSq58pAAAAAObMVWDelR-tYw-U5ImOmKRM51Ou"></div>
                                    </div>

                                    <div class="form-group" style="text-align: center;">
                                        <button class="btn btn-success btn-sm bounceIn animation-delay5">
                                            <i class="fa fa-plus"></i> S'inscrire
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-success btn-sm disabled" id="prevStep" disabled>Précédent</button>
                        <button type="submit" class="btn btn-sm btn-success" id="nextStep">Suivant</button>

                        <div class="pull-right" style="width:30%">
                            <div class="progress progress-striped active m-top-sm m-bottom-none">
                                <div class="progress-bar progress-bar-success" id="wizardProgress"
                                     style="width:33%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Spider-Diplome -->

            </div>
        </div>
    </div>
</div>


<!-- Le javascript Spider diplome
================================================== -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src='js/modernizr.min.js'></script>
<script src='js/pace.min.js'></script>
<script src='js/jquery.popupoverlay.min.js'></script>
<script src='js/jquery.slimscroll.min.js'></script>
<script src='js/jquery.cookie.min.js'></script>
<script src="js/app/app.js"></script>
<script src='js/jquery.maskedinput.min.js'></script>

<!-- Spider-Diplome Fonction de navigation next, preview -->
<script>
    $(function () {
        var currentStep = 1;

        $('#wizardTab li a').click(function () {
            return false;
        });

        $('#nextStep').click(function () {

            currentStep++;

            if (currentStep == 2) {
                $('#wizardTab li:eq(1) a').tab('show');
                $('#wizardProgress').css("width", "66%");

                $('#prevStep').attr('disabled', false);
                $('#prevStep').removeClass('disabled');
            } else if (currentStep == 3) {
                $('#wizardTab li:eq(2) a').tab('show');
                $('#wizardProgress').css("width", "100%");

                $('#nextStep').attr('disabled', true);
                $('#nextStep').addClass('disabled');
            }

            return false;
        });

        $('#prevStep').click(function () {

            currentStep--;

            if (currentStep == 1) {

                $('#wizardTab li:eq(0) a').tab('show');
                $('#wizardProgress').css("width", "66%");

                $('#prevStep').attr('disabled', true);
                $('#prevStep').addClass('disabled');

                $('#wizardProgress').css("width", "33%");
            } else if (currentStep == 2) {

                $('#wizardTab li:eq(1) a').tab('show');
                $('#wizardProgress').css("width", "66%");

                $('#nextStep').attr('disabled', false);
                $('#nextStep').removeClass('disabled');

                $('#wizardProgress').css("width", "66%");
            }

            return false;
        });
    });
</script>
<!-- /Spider-Diplome -->

</body>

</html>