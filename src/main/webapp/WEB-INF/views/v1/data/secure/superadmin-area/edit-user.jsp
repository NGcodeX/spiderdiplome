<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	  <title>${user.getNom()}|Admin/editer utilisateurs</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Font Awesome -->
	<link href="css/font-awesome.min.css" rel="stylesheet">
	
	<!-- Pace -->
	<link href="css/pace.css" rel="stylesheet">
	
	<!-- Chosen -->
	<link href="css/chosen/chosen.min.css" rel="stylesheet"/>

	<!-- Datepicker -->
	<link href="css/datepicker.css" rel="stylesheet"/>
	
	<!-- Timepicker -->
	<link href="css/bootstrap-timepicker.css" rel="stylesheet"/>
	
	<!-- Slider -->
	<link href="css/slider.css" rel="stylesheet"/>
	
	<!-- Tag input -->
	<link href="css/jquery.tagsinput.css" rel="stylesheet"/>

	<!-- WYSIHTML5 -->
	<link href="css/bootstrap-wysihtml5.css" rel="stylesheet"/>
	
	<!-- Dropzone -->
	<link href='css/dropzone/dropzone.css' rel="stylesheet"/>
	
	<!-- Perfect -->
	<link href="css/app.min.css" rel="stylesheet">
	<link href="css/app-skin.css" rel="stylesheet">
	
  </head>

  <body class="overflow-hidden">
	<!-- Overlay Div -->
	<div id="overlay" class="transparent"></div>
	
	<a href="" id="theme-setting-icon"><i class="fa fa-cog fa-lg"></i></a>
	<div id="theme-setting">
		<div class="title">
			<strong class="no-margin">Your school color</strong>
		</div>
		<div class="theme-box">
			<a class="theme-color" style="background:#495B6C" id="skin-6"></a>
			<a class="theme-color" style="background:#323447" id="default"></a>
			<a class="theme-color" style="background:#efefef" id="skin-1"></a>
			<a class="theme-color" style="background:#3e6b96" id="skin-3"></a>
		</div>
	</div><!-- /theme-setting -->

	<div id="wrapper" class="preload">
		<div id="top-nav" class="fixed skin-6">
			<a href="#" class="brand">
				<span>Spider</span>
				<span class="text-toggle"> Diplome</span>
			</a><!-- /brand -->					
			<button type="button" class="navbar-toggle pull-left" id="sidebarToggle">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<button type="button" class="navbar-toggle pull-left hide-menu" id="menuToggle">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<ul class="nav-notification clearfix">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="fa fa-envelope fa-lg"></i>
						<span class="notification-label bounceIn animation-delay4">4</span>
					</a>
					<ul class="dropdown-menu message dropdown-1">
						<li><a>Vous avez 4 messages non lu!</a></li>					  
						<li>
							<a class="clearfix" href="#">
								<img src="img/user.jpg" alt="User Avatar">
								<div class="detail">
									<strong>CodeurZEBS</strong>
									<p class="no-margin">
										Salut! juste pour te dire de...
									</p>
									<small class="text-muted"><i class="fa fa-check text-success"></i> 27m ago</small>
								</div>
							</a>	
						</li>
						<li>
							<a class="clearfix" href="#">
								<img src="img/user2.jpg" alt="User Avatar">
								<div class="detail">
									<strong>Jane camr</strong>
									<p class="no-margin">
										Si tu vois se message, je v...
									</p>
									<small class="text-muted"><i class="fa fa-check text-success"></i> 5hr ago</small>
								</div>
							</a>	
						</li>
						<li>
							<a class="clearfix" href="#">
								<img src="img/user.jpg" alt="User Avatar">
								<div class="detail">
									<strong>Jessoss</strong>
									<p class="no-margin">
										La publication est actuelleme...
									</p>
									<small class="text-muted"><i class="fa fa-reply"></i> Yesterday</small>
								</div>
							</a>	
						</li>
						<li>
							<a class="clearfix" href="#">
								<img src="img/user2.jpg" alt="User Avatar">
								<div class="detail">
									<strong>Babypaul</strong>
									<p class="no-margin">
										Je voudrais m inscrire au event...
									</p>
									<small class="text-muted"><i class="fa fa-reply"></i> 9 Feb 2013</small>
								</div>
							</a>	
						</li>
						<li><a href="#">Voir tous les messages</a></li>					  
					</ul>
				</li>
				<li class="dropdown hidden-xs">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="fa fa-tasks fa-lg"></i>
						<span class="notification-label bounceIn animation-delay5">5</span>
					</a>
					<ul class="dropdown-menu task dropdown-2">
						<li><a href="#">Vous avez 4 taches a completé</a></li>					  
						<li>
							<a href="#">
								<div class="clearfix">
									<span class="pull-left">Completer votre Profile</span>
									<small class="pull-right text-muted">78%</small>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="clearfix">
									<span class="pull-left">Lier votre gitHub</span>
								</div>		
							</a>
						</li>
						<li>
							<a href="#">
								<div class="clearfix">
									<span class="pull-left">Participez a un event</span>
								</div>
							</a>
						</li>
						<li>
							<a href="#">
								<div class="clearfix">
									<span class="pull-left">Integrer le groupe Spider</span>
								</div>
							</a>
						</li>
						<li><a href="#">Voir toute les taches</a></li>					  
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="fa fa-bell fa-lg"></i>
						<span class="notification-label bounceIn animation-delay6">5</span>
					</a>
					<ul class="dropdown-menu notification dropdown-3">
						<li><a href="#">Vous avez 5 notifications de la plateforme</a></li>					  
						<li>
							<a href="#">
								<span class="notification-icon bg-warning">
									<i class="fa fa-warning"></i>
								</span>
								<span class="m-left-xs">Server #2 not responding.</span>
								<span class="time text-muted">Just now</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="notification-icon bg-success">
									<i class="fa fa-plus"></i>
								</span>
								<span class="m-left-xs">New user registration.</span>
								<span class="time text-muted">2m ago</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="notification-icon bg-danger">
									<i class="fa fa-bolt"></i>
								</span>
								<span class="m-left-xs">Application error.</span>
								<span class="time text-muted">5m ago</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="notification-icon bg-success">
									<i class="fa fa-usd"></i>
								</span>
								<span class="m-left-xs">2 items sold.</span>
								<span class="time text-muted">1hr ago</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="notification-icon bg-success">
									<i class="fa fa-plus"></i>
								</span>
								<span class="m-left-xs">New user registration.</span>
								<span class="time text-muted">1hr ago</span>
							</a>
						</li>
						<li><a href="#">View all notifications</a></li>					  
					</ul>
				</li>
				<li class="profile dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
						<strong>${user.getNom()}${user.getPrenom()}</strong>
						<span><i class="fa fa-chevron-down"></i></span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a class="clearfix" href="#">
								<img src="img/user.jpg" alt="User Avatar">
								<div class="detail">
									<strong>${user.getMatricule()}</strong>
									<p class="grey">${user.getPhone()}</p>
								</div>
							</a>
						</li>
						<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-edit fa-lg"></i> profile</a></li>
						<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-file-text-o fa-lg"></i> Grades</a></li>
						<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-newspaper-o fa-lg"></i> Reports</a></li>
						<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-money fa-lg"></i> Wallet</a></li>
						<li><a tabindex="-1" href="#" class="theme-setting"><i class="fa fa-cogs fa-lg"></i> Setting</a></li>
						<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-university"></i> Admission Infos</a></li>
						<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-key fa-lg"></i> Change PassWord</a></li>
						<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-life-ring"></i> basic knowledge</a></li>
						<li><a tabindex="-1" href="gallery.html" class="main-link"><i class="fa fa-picture-o fa-lg"></i> Photo Gallery</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" class="main-link logoutConfirm_open" href="#logoutConfirm"><i class="fa fa-lock fa-lg"></i> Log out</a></li>
					</ul>
				</li>
			</ul>
		</div><!-- /top-nav-->
		
		<aside class="fixed skin-6">
			<div class="sidebar-inner scrollable-sidebar">
				<div class="size-toggle">
					<a class="btn btn-sm" id="sizeToggle">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
					<a class="btn btn-sm pull-right" href="lock_screen.html">
						<i class="fa fa-lock"></i>
					</a>
					<a class="btn btn-sm pull-right logoutConfirm_open"  href="#logoutConfirm">
						<i class="fa fa-power-off"></i>
					</a>
				</div><!-- /size-toggle -->	
				<div class="user-block clearfix">
					<img src="img/user.jpg" alt="User Avatar">
					<div class="detail">
						<strong>${user.getNom()} ${user.getPrenom()}</strong><span
							class="badge badge-success m-left-xs bounceIn animation-delay4">Online</span>
						<ul class="list-inline">
							<li><a href="#">Matricule:</a></li>
							<li><a href="#" class="no-margin">CM-${user.getMatricule()}</a></li>
						</ul>
					</div>
				</div><!-- /user-block -->
				<div class="search-block">
					<div class="input-group">
						<input type="text" class="form-control input-sm" placeholder="search here...">
						<span class="input-group-btn">
							<button class="btn btn-default btn-sm" type="button"><i class="fa fa-search"></i></button>
						</span>
					</div><!-- /input-group -->
				</div><!-- /search-block -->
				<div class="main-menu">
					<ul>
						<li class="active">
							<a href="tableau-de-bord">
								<span class="menu-icon">
									<i class="fa fa-dashboard fa-lg"></i> 
								</span>
								<span class="text">
									Tableau de Bord
								</span>
								<span class="menu-hover"></span>
							</a>
						</li>
						<li class="active">
							<a href="gestions-utilisateurs">
								<span class="menu-icon">
									<i class="fa fa-user fa-lg"></i> 
								</span>
								<span class="text">
									Utilisateurs
								</span>
								<span class="menu-hover"></span>
							</a>
						</li>
						<li class="active">
							<a href="gestions-universites">
								<span class="menu-icon">
									<i class="fa fa-building-o fa-lg"></i>
								</span>
								<span class="text">
									Universities
								</span>
								<span class="menu-hover"></span>
							</a>
						</li>
					</ul>
					<div class="alert alert-info">
						Bienvenue a Spider Diplome. n'oublié pas de nous soutenir afin de rendre la digitalisation accessible pour tous
					</div>
				</div><!-- /sidebar-inner -->
			</div>
		</aside>

		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/"> Home</a></li>
					<li class="active"><a href="gestions-utilisateurs">Utilisateurs</a></li>
					<li class="active">Editer Utilisateur</li>
				</ul>
			</div><!-- /breadcrumb-->
			<div class="padding-md">
				<a href="gestions-utilisateurs" class="btn btn-success"><i class="fa fa-reply"></i> Retour</a>
				<a class="btn btn-default" onclick="printForm()"><i class="fa fa-print"></i> Print User</a>

				<div class="panel panel-default">
					<form action="editer-utilisateur" class="no-margin"
						  method="post">
						<div class="panel-heading">
							User General Information (Add) votre initial est: CM-${user.getMatricule()}
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group has-success">
										<label class="control-label">Status <span
												class="label label-warning">account</span></label>
										<select name="status" class="form-control has-success">
											<c:choose>
												<c:when test="${userToEdit.getStatut() == 1}">
													<option selected>Actif</option>
													<option>Inactif</option>
												</c:when>
												<c:otherwise>
													<option>Actif</option>
													<option selected>Inactif</option>
												</c:otherwise>
											</c:choose>
										</select>
									</div><!-- /form-group -->
								</div><!-- /.col -->
								<div class="col-md-6">
									<div class="form-group has-success">
										<label class="control-label">Role <span
												class="label label-warning">account</span></label>
										<select name="role" class="form-control has-success">
											<option selected>${userToEdit.getRole()}</option>
											<option>candidat</option>
											<option>autoritesignataire</option>
											<option>superadmin</option>
											<option>administrateur</option>
											<option>responsablesecurite</option>
											<option>candidatpotentiel</option>
											<option>serviceadministratifecole</option>
										</select>
									</div>
								</div>
							</div>

							<h4 class="headline">
								USER PERSONAL INFORMATIONS
								<span class="line"></span>
							</h4>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">First Name </label>
										<input type="text" name="firstName" placeholder="First Name"
											   class="form-control input-sm" data-required="true"
											   value="${userToEdit.getNom()}">
									</div><!-- /form-group -->
								</div><!-- /.col -->
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Last Name</label>
										<input type="text" name="lastName" placeholder="Last Name"
											   class="form-control input-sm" data-required="true"
											   value="${userToEdit.getPrenom()}">
									</div><!-- /form-group -->
								</div><!-- /.col -->
							</div><!-- /.row -->

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label">Telephone ou E-mail (Du tuteur Legal)</label>
										<input type="text" id="phone" name="phoneEmail" placeholder="Username"
											   class="form-control input-sm" data-required="true"
											   data-minlength="8" value="${userToEdit.getPhone()}">
									</div>
								</div><!-- /.col -->
								<div class="col-md-6">

								</div><!-- /.col -->
							</div><!-- /.row -->


							<h4 class="headline">
								USER ACCOUNT INFORMATION
								<span class="line"></span>
							</h4>

							<div class="form-group">
								<label class="control-label">Matricule (Optional) </label>
								<input type="text" name="matricule" placeholder="username"
									   class="form-control input-sm" data-required="true"
									   value="${userToEdit.getMatricule()}">
							</div><!-- /form-group -->
							<div class="form-group">
								<label class="control-label">New PassPassword (Optional)</label>
								<input type="password" name="password" placeholder="Password"
									   class="form-control input-sm" id="password"
									   data-required="true" data-minlength="8">
							</div>
							<script>
								// Attacher l'écouteur d'événement après le chargement complet du DOM
								document.addEventListener('DOMContentLoaded', function () {
									// Sélectionner le formulaire par sa classe
									var form = document.querySelector('.form-login');

									form.addEventListener('submit', function (e) {
										// Sélectionner le champ de mot de passe par son nom
										var password = document.querySelector('input[name="password"]');

										// Vérifier si la longueur du mot de passe est inférieure à 8 caractères
										if (password.value.length < 8) {
											// Afficher une alerte si le mot de passe est trop court
											alert('Le mot de passe doit comporter au moins 8 caractères');
											// Empêcher la soumission du formulaire
											e.preventDefault();
										}
									});
								});
							</script>

							<div class="form-group">
								<label class="control-label">User Picture</label>
								<input type="file" name="picture" data-required="true">
									<span class="label label-warning">* Only JPEG and JPG supported, * Max 3 MB Upload</span>
							</div>

						</div>
						<div class="panel-footer text-right">
							<button type="submit" class="btn btn-success"><i class="fa fa-download"></i> Update User
							</button>
							<button type="button" class="btn btn-danger" id="cancelButton">
								<i class="fa fa-times"></i> Cancel
							</button>
						</div>
					</form>
					<script>
						function printForm() {
							var printContents = document.getElementById('formValidate1').innerHTML;
							var originalContents = document.body.innerHTML;

							document.body.innerHTML = "<html><head><title>Ajout d'un nouvel utilisateur</title></head><body>" + printContents + "</body>";
							window.print();

							document.body.innerHTML = originalContents;
						}
					</script>
				</div><!-- /panel -->
			</div><!-- /.padding-md -->
		</div><!-- /main-container -->
	</div><!-- /wrapper -->

	<a href="" id="scroll-to-top" class="hidden-print"><i class="fa fa-chevron-up"></i></a>

	<!-- Logout confirmation -->
	<div class="custom-popup width-100" id="logoutConfirm">
		<div class="padding-md">
			<h4 class="m-top-none"> Voulez vous vous deconncter de Spider Diplome??</h4>
		</div>

		<div class="text-center">
			<a class="btn btn-success m-right-sm" href="deconnexion">deconnexion</a>
			<a class="btn btn-danger logoutConfirm_close">Non Rester</a>
		</div>
	</div>
	
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

	<script src="js/jquery-1.10.2.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<script src='js/modernizr.min.js'></script>
	<script src='js/pace.min.js'></script>
	<script src='js/jquery.popupoverlay.min.js'></script>
	<script src='js/jquery.slimscroll.min.js'></script>
	<script src='js/jquery.cookie.min.js'></script>
	<script src="js/app/app.js"></script>
	<script src='js/jquery.maskedinput.min.js'></script>
	
  </body>
</html>

