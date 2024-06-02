<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Spider-Oublier</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Spider Diplome Bootstrap core CSS -->
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Spider Diplome Font Awesome -->
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<!-- Spider Diplome Perfect -->
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
						<i class="fa fa-key fa-lg"></i> Renitialisation
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

				<!-- Spider-Diplome mise en contexe de l utilisateur sur les tentatives -->
				<div class="panel-body">
					<h4 class="headline">
						Recherche par Matricule ou numero   <i class="fa fa-database fa-lg"></i>
						<span class="line"></span>
					</h4>
					<div class="form-group">
						<div class="controls">
							Pour réinitialiser votre mot de passe, soumettez votre Matricule Scolaire ci-dessous.un code
							sera envoyé
							sur le téléphone du parent, avec des instructions sur la façon de
							avoir à nouveau accès. ou contacter<a href="#" class="primary-font login-link">
								Minesec Support</a>
						</div>
					</div>
					<!-- /Spider-Diplome -->

					<!-- Spider-Diplome Formulaire de recherche de matricule -->
					<form class="form-login" method="post" action="changement-mot-de-passe">
						<div class="form-group">
							<label><i class="fa fa-dot-circle-o fa-lg"></i> Matricule Candidat</label>
							<input type="text" name="matricule" placeholder="Matricule"
								class="form-control input-sm bounceIn animation-delay2" required>
						</div>
						<div class="form-group" style="text-align: center;">
							<button class="btn btn-success btn-sm bounceIn animation-delay6">
								<i class="fa fa-search"></i> Rechercher
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
	<script src='js/jquery.popupoverlay.min.js'></script>
	<script src='js/jquery.slimscroll.min.js'></script>
	<script src='js/jquery.cookie.min.js'></script>
	<script src="js/app/app.js"></script>
</body>

</html>