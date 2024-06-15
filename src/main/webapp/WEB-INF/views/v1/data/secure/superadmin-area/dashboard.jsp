<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>${user.getNom()}|Menu</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/pace.css" rel="stylesheet">
	<link href="css/colorbox/colorbox.css" rel="stylesheet">
	<link href="css/morris.css" rel="stylesheet"/>
	<link href="css/app.min.css" rel="stylesheet">
	<link href="css/app-skin.css" rel="stylesheet">

</head>

<body class="overflow-hidden">
<!-- Overlay Div -->
<div id="overlay" class="transparent"></div>

<a href="" id="theme-setting-icon"><i class="fa fa-cog fa-lg"></i></a>
<div id="theme-setting">
	<div class="title">
		<strong class="no-margin">Votre couleur</strong>
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
					<strong>${user.getNom()}</strong>
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
					<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-money fa-lg"></i> Candidature</a></li>
					<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-newspaper-o fa-lg"></i> Forum</a></li>
					<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-money fa-lg"></i> Compte money</a></li>
					<li><a tabindex="-1" href="#" class="theme-setting"><i class="fa fa-cogs fa-lg"></i> Parametre</a></li>
					<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-university"></i> Spider Infos</a></li>
					<li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-life-ring"></i> Base Connaissance</a></li>
					<li class="divider"></li>
					<li><a tabindex="-1" class="main-link logoutConfirm_open" href="#logoutConfirm"><i class="fa fa-lock fa-lg"></i> Verrouillage</a></li>
					<li><a tabindex="-1" class="main-link logoutConfirm_open" href="#logoutConfirm"><i class="fa fa-lock fa-lg"></i> Deconnexion</a></li>
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
				<a class="btn btn-sm pull-right" href="verrouiller">
					<i class="fa fa-lock"></i>
				</a>
				<a class="btn btn-sm pull-right logoutConfirm_open"  href="#logoutConfirm">
					<i class="fa fa-power-off"></i>
				</a>
			</div><!-- /size-toggle -->
			<div class="user-block clearfix">
				<img src="img/user.jpg" alt="User Avatar">
				<div class="detail">
					<strong>${user.getNom()} ${user.getPrenom()}</strong><span class="badge badge-success m-left-xs bounceIn animation-delay4">Online</span>
					<ul class="list-inline">
						<li><a href="#">Matricule:</a></li>
						<li><a href="#" class="no-margin">${user.getMatricule()}</a></li>
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
						<a href="tb-admin" class="menu-link">
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
						<a href="gestions-utilisateurs" class="menu-link">
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
						<a href="gestions-universites" class="menu-link" data-page="all-colleges">
								<span class="menu-icon">
									<i class="fa fa-building-o fa-lg"></i>
								</span>
							<span class="text">
									Universities
								</span>
							<span class="menu-hover"></span>
						</a>
					</li>
					<li class="active">
						<a href="#" class="menu-link" data-page="all-colleges">
								<span class="menu-icon">
									<i class="fa fa-graduation-cap fa-lg"></i>
								</span>
							<span class="text">
									Admissions
								</span>
							<span class="menu-hover"></span>
						</a>
					</li>
					<li class="active">
						<a href="#" class="menu-link">
								<span class="menu-icon">
									<i class="fa fa-newspaper-o fa-lg"></i>
								</span>
							<span class="text">
									pertes
								</span>
							<span class="menu-hover"></span>
						</a>
					</li>
				</ul>
				<div class="alert alert-info">
					Bienvenue a Spider Diplome. n'oublié pas de nous soutenir afin de rendre la digitalisation accessible pour tous
				</div>
			</div><!-- /main-menu -->
		</div><!-- /sidebar-inner -->
	</aside>

	<div id="main-container">
<div id="breadcrumb">
				<ul class="breadcrumb">
					 <li><i class="fa fa-home"></i><a href="/"> Home</a></li>
					 <li class="active">Dashboard</li>	 
				</ul>
			</div><!-- /breadcrumb-->
			<div class="main-header clearfix">
				<div class="page-title">
					<h3 class="no-margin">Dashboard</h3>
					<span>Welcome ${user.getNom()}! Une revue complete des validations et autentification des documents par les candidats</span>
				</div><!-- /page-title -->
				
				<ul class="page-stats">
					<li>
						<div class="value">
							<span>Faire un</span>
							<h4><a class="btn btn-success"><i class="fa fa-money fa-lg"></i> Depot</a></h4>
						</div>
					</li>
					<li>
						<div class="value">
							<span>Faire un</span>
							<h4><a class="btn btn-success"><i class="fa fa-money fa-lg"></i> Retrait</a></h4>
						</div>
					</li>
			    	<li>
			    		<div class="value">
			    			<span>Staff Internes</span>
			    			<h4 id="currentVisitor">75</h4>
			    		</div>
			    	</li>
			    	<li>
			    		<div class="value">
			    			<span>Balance Actuelle</span>
			    			<h4><strong id="currentBalance">500000</strong> CFA</h4>
			    		</div>
			    	</li>
			    </ul><!-- /page-stats -->
			</div><!-- /main-header -->

			<div class="grey-container shortcut-wrapper">
				<a href="ajout-utilisateur" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-user"></i>
					</span>
					<span class="text">Nouveau Candidat</span>
				</a>
				<a href="gestions-universites" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-building-o"></i>
					</span>
					<span class="text">Université</span>
				</a>
				<a href="#" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-envelope-o"></i>
						<span class="shortcut-alert">
							5
						</span>	
					</span>
					<span class="text">Diplome</span>
				</a>
				<a href="#" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-globe"></i>
						<span class="shortcut-alert">
							7
						</span>	
					</span>
					<span class="text">Notification</span>
				</a>
				<a href="#" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-list"></i>
					</span>
					<span class="text">Activity</span>
				</a>
				<a href="#" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-cog"></i></span>
					<span class="text">Setting</span>
				</a>
			</div><!-- /grey-container -->
			
			<div class="padding-md">
				<div class="row">
					<div class="col-sm-6 col-md-3">
						<a href="gestions-utilisateurs">
						<div class="panel-stat3 bg-primary">
							<h2 class="m-top-none"><span id="serverloadCount1">${fn:length(users)}</span></h2>
							<h5>Utilisateurs Totals</h5>
							<i class="fa fa-check-circle-o"></i> <span class="m-left-xs">Nombres d utilisateurs totals</span>
							<div class="stat-icon">
								<i class="fa fa-group fa-3x"></i>
							</div>
							<div class="refresh-button" id="refreshButton">
								<i class="fa fa-refresh"></i>
							</div>
							<script>
								document.getElementById('refreshButton').addEventListener('click', function () {
									fetch('/tb-admin', {
										method: 'GET',
										headers: {
											'Content-Type': 'application/json',
											// 'Content-Type': 'application/x-www-form-urlencoded',
										},
									})
											.then(response => response.json())
											.then(data => console.log(data))
											.catch((error) => {
												console.error('Error:', error);
											});
								});
							</script>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
						</a>
					</div>
					<a href="">
					<div class="col-sm-6 col-md-3">
						<div class="panel-stat3 bg-primary">
							<h2 class="m-top-none"><span id="serverloadCount2">${fn:length(universite)}</span></h2>
							<h5>Universités / Colleges partenaires Totals</h5>
							<i class="fa fa-building-o fa-lg"></i> <span class="m-left-xs">Universités partenaires</span>
							<div class="stat-icon">
								<i class="fa fa-building-o fa-3x"></i>
							</div>
							<div class="refresh-button">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
					</div>
					</a>
					<div class="col-sm-6 col-md-3">
						<div class="panel-stat3 bg-info">
							<h2 class="m-top-none"><span id="serverloadCount3">${fn:length(autoritessignataire)}</span></h2>
							<h5>Autorités signataires Total</h5>
							<i class="fa fa-arrow-circle-o-up fa-lg"></i><span class="m-left-xs">Nombres d autorités Signataires</span>
							<div class="stat-icon">
								<i class="fa fa-folder-open fa-3x"></i>
							</div>
							<div class="refresh-button">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
					</div><!-- /.col -->
					<div class="col-sm-6 col-md-3">
						<div class="panel-stat3 bg-info">
							<h2 class="m-top-none"><span id="serverloadCount4">85</span></h2>
							<h5>Corrections effectuées</h5>
							<i class="fa fa-edit"></i><span class="m-left-xs">Correction certificate, diplomes, acte de naissance.. etc</span>
							<div class="stat-icon">
								<i class="fa fa-edit fa-3x"></i>
							</div>
							<div class="refresh-button">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
					</div><!-- /.col -->
					<div class="col-sm-6 col-md-3">
						<div class="panel-stat3 bg-info">
							<h2 class="m-top-none"><span id="serverloadCount5">78</span></h2>
							<h5>relevés de notes générés</h5>
							<i class="fa fa-book fa-lg"></i><span class="m-left-xs">Retour des documents important de la plateformes</span>
							<div class="stat-icon">
								<i class="fa fa-book fa-3x"></i>
							</div>
							<div class="refresh-button">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
					</div><!-- /.col -->
					<div class="col-sm-6 col-md-3">
						<div class="panel-stat3 bg-success">
							<h2 class="m-top-none" id="visitorCount6">7214</h2>
							<h5>Montant Recuperation</h5>
							<i class="fa fa-arrow-circle-o-up fa-lg"></i><span class="m-left-xs"> Payement de fond due par la plateformes. 500CFA</span>
							<div class="stat-icon">
								<i class="fa fa-money fa-3x"></i>
							</div>
							<div class="refresh-button">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
					</div><!-- /.col -->
					<div class="col-sm-6 col-md-3">
						<div class="panel-stat3 bg-success">
							<h2 class="m-top-none" id="visitorCount7">720</h2>
							<h5>Candidatures en cours</h5>
							<i class="fa fa-spinner fa-lg"></i><span class="m-left-xs"> Candidatures emis par les candidats de la plateformes</span>
							<div class="stat-icon">
								<i class="fa fa-spinner fa-3x"></i>
							</div>
							<div class="refresh-button">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-3">
						<div class="panel-stat3 bg-info">
							<h2 class="m-top-none"><span id="serverloadCount8">2</span></h2>
							<h5>Forum totales</h5>
							<i class="fa fa-comment-o fa-lg"></i><span class="m-left-xs">Nombre de forums actif sur la plateforme Sppider diplome</span>
							<div class="stat-icon">
								<i class="fa fa-comment-o fa-3x"></i>
							</div>
							<div class="refresh-button">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-8">
						<div class="panel panel-default">
							<div class="panel-heading clearfix">
								<span class="pull-left"><i class="fa fa-rss"></i> <i class="fa fa-bar-chart-o fa-lg"></i> Spider Diplome Traffic d'Utilisateurs</span>
								<ul class="tool-bar">
									<li><a href="#" class="refresh-widget" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Refresh"><i class="fa fa-refresh"></i></a></li>
								</ul>
							</div>
							<div class="panel-body" id="trafficWidget">
								<div id="placeholder" class="graph" style="height:250px"></div>
							</div>
							<div class="panel-footer">
								<div class="row row-merge">
									<div class="col-xs-3 text-center border-right">
										<h4 class="no-margin">1</h4>
										<small class="text-muted">Candidat en ligne</small>
									</div>
									<div class="col-xs-3 text-center border-right">
										<h4 class="no-margin">5</h4>
										<small class="text-muted">Payement</small>
									</div>
									<div class="col-xs-3 text-center border-right">
										<h4 class="no-margin">3</h4>
										<small class="text-muted">Relevés</small>
									</div>
									<div class="col-xs-3 text-center">
										<h4 class="no-margin">7</h4>
										<small class="text-muted">Autorités</small>
									</div>
								</div><!-- ./row -->
							</div>
							<div class="loading-overlay">
								<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
							</div>
						</div><!-- /panel -->
						<div class="row">
							<div class="col-lg-6">
								<div class="panel panel-default">
									<div class="panel-heading clearfix">
										<span class="pull-left">
											Taches Administrateur <span class="text-success m-left-xs"><i class="fa fa-check"></i></span>
										</span>
										<ul class="tool-bar">
											<li><a href="#" class="refresh-widget" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Refresh"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#toDoListWidget" data-toggle="collapse"><i class="fa fa-arrows-v"></i></a></li>
										</ul>
									</div>
									<div class="panel-body no-padding collapse in" id="toDoListWidget">
										<ul class="list-group task-list no-margin collapse in">
											<li class="list-group-item selected">
												<label class="label-checkbox inline">
													 <input type="checkbox" class="task-finish">
													 <span class="custom-checkbox"></span>
												</label>
												Spider create View
												<span class="pull-right">
													<a href="#" class="task-del"><i class="fa fa-trash-o fa-lg text-danger"></i></a>
												</span>
											</li>
											<li class="list-group-item">
												<label class="label-checkbox inline">
													 <input type="checkbox" class="task-finish">
													 <span class="custom-checkbox"></span>
												</label>
												Creation of controller
												<span class="pull-right">
													<a href="#" class="task-del"><i class="fa fa-trash-o fa-lg text-danger"></i></a>
												</span>
											</li>
											<li class="list-group-item">
												<label class="label-checkbox inline">
													 <input type="checkbox" class="task-finish">
													 <span class="custom-checkbox"></span>
												</label>
												Services package app 
												<span class="pull-right">
													<a href="#" class="task-del"><i class="fa fa-trash-o fa-lg text-danger"></i></a>
												</span>
												<span class="badge badge-success m-right-xs">3</span>
											</li>
											<li class="list-group-item">
												<label class="label-checkbox inline">
													 <input type="checkbox" class="task-finish">
													 <span class="custom-checkbox"></span>
												</label>
												Package repository
												<span class="pull-right">
													<a href="#" class="task-del"><i class="fa fa-trash-o fa-lg text-danger"></i></a>
												</span>
											</li>
											<li class="list-group-item">
												<label class="label-checkbox inline">
													 <input type="checkbox" class="task-finish">
													 <span class="custom-checkbox"></span>
												</label>
												New Frontend Layout <span class="label label-warning m-left-xs">PENDING</span>
												<span class="pull-right">
													<a href="#" class="task-del"><i class="fa fa-trash-o fa-lg text-danger"></i></a>
												</span>
											</li>
											<li class="list-group-item">
												<label class="label-checkbox inline">
													 <input type="checkbox" class="task-finish">
													 <span class="custom-checkbox"></span>
												</label>
												Bug Fixes <span class="label label-danger m-left-xs">IMPORTANT</span>
												<span class="pull-right">
													<a href="#" class="task-del"><i class="fa fa-trash-o fa-lg text-danger"></i></a>
												</span>
											</li>
										</ul><!-- /list-group -->
									</div>
									<div class="loading-overlay">
										<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
									</div>
								</div><!-- /panel -->
							</div><!-- /.col -->
							<div class="col-lg-6">
								<div class="panel panel-default">	
									<div class="panel-heading clearfix">
										<span class="pull-left">Payement</span>
										<ul class="tool-bar">
											<li><a href="#" class="refresh-widget" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Refresh"><i class="fa fa-refresh"></i></a></li>
											<li><a href="#feedList" data-toggle="collapse"><i class="fa fa-arrows-v"></i></a></li>
										</ul>
									</div>		
									<ul class="list-group collapse in" id="feedList">
										<li class="list-group-item clearfix">
											<div class="activity-icon small">
												<i class="fa fa-camera"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>NGUENA ZEBS Add a new photo.</span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 2m ago</small>
											</div>
										</li>
										<li class="list-group-item clearfix">
											<div class="activity-icon bg-success small">
												<i class="fa fa-usd"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>2 items sold.</span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 30m ago</small>
											</div>	
										</li>
										<li class="list-group-item clearfix">
											<div class="activity-icon bg-info small">
												<i class="fa fa-comment"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>NGUENA ZEBS commented on <a href="#">This Article</a></span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 1hr ago</small>
											</div>
										</li>
										<li class="list-group-item clearfix">
											<div class="activity-icon bg-success small">
												<i class="fa fa-usd"></i>
											</div>
											<div class="pull-left m-left-sm">
												<span>3 items sold.</span><br/>
												<small class="text-muted"><i class="fa fa-clock-o"></i> 2days ago</small>
											</div>	
										</li>
									</ul><!-- /list-group -->	
									<div class="loading-overlay">
										<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
									</div>
								</div><!-- /panel -->
								
							</div><!-- /.col -->
						</div><!-- ./row -->
						<div class="row">
							<div class="panel panel-default">
								<div class="panel-heading">
									Requetes de validation actuelles
								</div>
								<div class="panel-body">
									<span>Candidat</span><span class="badge m-left-xs">365</span>
									<span>Approved</span><span class="badge badge-success m-left-xs">321</span>
									<span>Pending</span><span class="badge badge-warning m-left-xs">37</span>
									<span>Banned</span><span class="badge badge-danger m-left-xs">7</span>
								</div>
								<table class="table table-bordered table-condensed table-hover table-striped">
									<thead>
										<tr>
											<th>Matricule</th>
											<th>Name</th>
											<th>Date</th>
											<th>Status</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												CM20243242
											</td>
											<td>
												Petter tom
											</td>
											<td>
												Oct 08,2013
											</td>
											<td>
												<span class="label label-warning">Pending</span>
											</td>
										</tr>
										<tr>
											<td>
												CM20243243
											</td>
											<td>
												Atangana gregoir
											</td>
											<td>
												Oct 07,2013
											</td>
											<td>
												<span class="label label-warning">Pending</span>
											</td>
										</tr>
										<tr>
											<td>
												CM20243244
											</td>
											<td>
												Bill Ama
											</td>
											<td>
												29 Sep,2013
											</td>
											<td>
												<span class="label label-success">Approved</span>
											</td>
										</tr>
										<tr>
											<td>
												CM20243245
											</td>
											<td>
												Kate Mait
											</td>
											<td>
												19 July,2013
											</td>
											<td>
												<span class="label label-success">Approved</span>
											</td>
										</tr>
										<tr>
											<td>
												CM20243246
											</td>
											<td>
												Jame ralland
											</td>
											<td>
												18 July,2013
											</td>
											<td>
												<span class="label label-danger">Banned</span>
											</td>
										</tr>
									</tbody>
								</table>
							</div><!-- /panel -->
						</div>
					</div><!-- /.col -->
					<div class="col-lg-4">
						<div class="panel bg-info fadeInDown animation-delay4">
							<div class="panel-body">
								<div id="lineChart" style="height: 150px;"></div>
								<div class="pull-right text-right">
									<strong class="font-14">Balance 300500 CFA</strong><br/>
									<span><i class="fa fa-shopping-cart"></i> Total Payement 867</span>
									<div class="seperator"></div>
								</div>
							</div>
							<div class="panel-footer">
								<div class="row">
									<div class="col-xs-4">
										Sales in Spring
										<strong class="block">6640 CFA</strong>
									</div><!-- /.col -->
									<div class="col-xs-4">
										Sales in Summer
										<strong class="block">7310 CFA</strong>
									</div><!-- /.col -->
									<div class="col-xs-4">
										Sales in Fall
										<strong class="block">9122 CFA</strong>
									</div><!-- /.col -->
								</div><!-- /.row -->
							</div>
						</div><!-- /panel -->
								
						<div class="panel bg-success fadeInDown animation-delay5">
							<div class="panel-body">
								<div id="barChart" style="height: 150px;"></div>
							</div>
							<div class="panel-footer">
								<div class="row">
									<div class="col-xs-6">
										<h4 class="no-margin">Total Earnings</h4>
									</div><!-- /.col -->
									<div class="col-xs-6 text-right">
										<h4 class="no-margin">1258957,531 CFA</h4>
									</div><!-- /.col -->
								</div><!-- /.row -->
							</div>
						</div><!-- /panel -->
						<div class="panel panel-default">
							<div class="panel-body">
								<div id="donutChart" style="height: 250px;"></div>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
													IN-STORE Sales
													<span class="badge badge-success pull-right">75%</span>
												</a>
											</h4>
										</div>
										<div id="collapseOne" class="panel-collapse collapse">
											<div class="panel-body">
												Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. 
											</div>
										</div>
									</div><!-- panel -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
													DOWMLOAD Sales
												</a>
											</h4>
										</div>
										<div id="collapseTwo" class="panel-collapse collapse">
											<div class="panel-body">
												Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. 
											</div>
										</div>
									</div><!-- panel -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
													STUDENT REQUEST-ORDER Sales 
													<span class="badge badge-danger pull-right"><i class="fa fa-arrow-down"></i> 3%</span>
												</a>
											</h4>
										</div>
										<div id="collapseThree" class="panel-collapse collapse">
											<div class="panel-body">
												Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. 
											</div>
										</div>
									</div><!-- panel -->
								</div><!-- panel-group -->
							</div>
						</div><!-- /panel -->
					</div><!-- /.col -->
				</div><!-- /.row -->

			</div><!-- /.padding-md -->
	</div>

</div>

<!-- Footer
================================================== -->
<footer>
	<div class="row">
		<div class="col-sm-6">
					<span class="footer-brand">
						<strong class="text-danger">Spider</strong> Diplome
					</span>
			<p class="no-margin">
				&copy; 2013 <strong>NGcodeX</strong>. ALL Rights Reserved.
			</p>
		</div><!-- /.col -->
	</div><!-- /.row-->
</footer>


<a href="" id="scroll-to-top" class="hidden-print"><i class="fa fa-chevron-up"></i></a>

<!-- Logout confirmation -->
<div class="custom-popup width-100" id="logoutConfirm">
	<div class="padding-md">
		<h4 class="m-top-none"> Vous êtes sur le point de vous déconnecter de l'application. veuillez confirmer cette action</h4>
	</div>

	<div class="text-center">
		<a class="btn btn-success m-right-sm" href="deconnexion">deconnection</a>
		<a class="btn btn-danger logoutConfirm_close">Non rester</a>
	</div>
</div>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<!-- Jquery -->
<script src="js/jquery-1.10.2.min.js"></script>

<!-- Bootstrap -->
<script src="bootstrap/js/bootstrap.js"></script>

<!-- Flot -->
<script src='js/jquery.flot.min.js'></script>

<!-- Morris -->
<script src='js/rapheal.min.js'></script>
<script src='js/morris.min.js'></script>

<!-- Colorbox -->
<script src='js/jquery.colorbox.min.js'></script>

<!-- Sparkline -->
<script src='js/jquery.sparkline.min.js'></script>

<!-- Pace -->
<script src='js/uncompressed/pace.js'></script>

<!-- Popup Overlay -->
<script src='js/jquery.popupoverlay.min.js'></script>

<!-- Slimscroll -->
<script src='js/jquery.slimscroll.min.js'></script>

<!-- Modernizr -->
<script src='js/modernizr.min.js'></script>

<!-- Cookie -->
<script src='js/jquery.cookie.min.js'></script>

<!-- Perfect -->
<script src="js/app/app_dashboard.js"></script>
<script src="js/app/app.js"></script>

</body>
</html>