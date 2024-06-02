<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Perfect Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0 ,maximum-scale=1">
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
	<link href="css/app-skin.css" rel="stylesheet">

  </head>

  <body style="overflow:hidden;">


	<!-- Overlay Div -->
	<div id="overlay" class="transparent"></div>

	<div id="wrapper" class="preload">
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
							<a href="connexion" class="top-link">Connexion</a>
						</li>
						<li>
							<a href="inscription" class="top-link">S'inscrire</a>
						</li>
					</ul>
				</nav>
			</div>
		</header>
		<!-- /Spider-Diplome header -->

		<aside class="fixed skin-6">
			<div class="sidebar-inner scrollable-sidebar">
				<div class="size-toggle">
					<a class="btn btn-sm" id="sizeToggle">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
				</div><!-- /size-toggle -->
				<div class="user-block clearfix">
					<img src="img/user.jpg" alt="User Avatar">
					<div class="detail">
						<strong>ChatBot</strong><span class="badge badge-success m-left-xs bounceIn animation-delay4">Online</span>
						<ul class="list-inline">
							<li><a href="profile.html">CODE</a></li>
							<li><a href="inbox.html" class="no-margin">Horaire</a></li>
						</ul>
					</div>
				</div><!-- /user-block -->
				<div class="main-menu">
					<ul>
						<li>
							<a href="section-support">
								<span class="menu-icon">
									<i class="fa fa-desktop fa-lg"></i>
								</span>
								<span class="text">
									Chat-Center
								</span>
								<span class="menu-hover"></span>
							</a>
						</li>
					</ul>

					<div class="alert alert-info">
						Avez vous des questions discutez avec notre bot en ligne ou contacter nous suivant les heure d ouverture
					</div>
				</div><!-- /main-menu -->
			</div><!-- /sidebar-inner scrollable-sidebar -->
		</aside>

		<div id="main-container">
			<div class="chat-wrapper">
				<div class="chat-sidebar border-right bg-white">
					<div class="border-bottom padding-sm" style="height: 40px;">
						discussion candidat
					</div>
					<ul class="friend-list">
						<li class="active bounceInDown">
							<a href="#" class="clearfix">
								<img src="img/user.jpg" alt="" class="img-circle">
								<div class="friend-name">
									<strong>Vous</strong>
								</div>
								<div class="last-message text-muted">Comment recuperer mon matricule</div>
								<small class="time text-muted">Just now</small>
								<small class="chat-alert badge badge-danger">1</small>
							</a>
						</li>
					</ul>
				</div>

				<div class="chat-inner scrollable-div">
					<div class="chat-header bg-white">
						<button type="button" class="navbar-toggle" id="friendListToggle">
							<i class="fa fa-comment fa-lg"></i>
							<span class="notification-label bounceIn animation-delay4">7</span>
						</button>
						<div class="pull-right">
							<a class="btn btn-xs btn-default">Contact Mobile</a>
							<a class="btn btn-xs btn-default">Nouvelle discussion</a>
						</div>
					</div>

					<div class="chat-message">
						<ul class="chat">
							<li class="left clearfix">
								<span class="chat-img pull-left">
									<img src="img/user.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">John Doe</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 12 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									</p>
								</div>
							</li>
							<li class="right clearfix">
								<span class="chat-img pull-right">
									<img src="img/user3.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Sarah</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 13 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at.
									</p>
								</div>
							</li>
							<li class="left clearfix">
								<span class="chat-img pull-left">
									<img src="img/user4.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Angelina</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 20 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									</p>
								</div>
							</li>
							<li class="right clearfix">
								<span class="chat-img pull-right">
									<img src="img/user2.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Jane Doe</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 25 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at.
									</p>
								</div>
							</li>
							<li class="left clearfix">
								<span class="chat-img pull-left">
									<img src="img/user5.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Kate</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 12 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									</p>
								</div>
							</li>
							<li class="right clearfix">
								<span class="chat-img pull-right">
									<img src="img/user3.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Sarah</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 13 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at.
									</p>
								</div>
							</li>
							<li class="left clearfix">
								<span class="chat-img pull-left">
									<img src="img/user.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">John Doe</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 20 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									</p>
								</div>
							</li>
							<li class="right clearfix">
								<span class="chat-img pull-right">
									<img src="img/user2.jpg" alt="User Avatar">
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">Jane Doe</strong>
										<small class="pull-right text-muted"><i class="fa fa-clock-o"></i> 25 mins ago</small>
									</div>
									<p>
										Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at.
									</p>
								</div>
							</li>
						</ul>
					</div>
					<div class="chat-box bg-white">
						<div class="input-group">
							<input class="form-control border no-shadow no-rounded" placeholder="Type your message here">
							<span class="input-group-btn">
								<button class="btn btn-success no-rounded" type="button">Send</button>
							</span>
						</div><!-- /input-group -->
					</div>
				</div>

			</div><!-- /chat-wrapper -->
		</div><!-- /main-container -->
	</div><!-- /wrapper -->

	<a href="" id="scroll-to-top" class="hidden-print"><i class="fa fa-chevron-up"></i></a>

	<!-- Logout confirmation -->
	<div class="custom-popup width-100" id="logoutConfirm">
		<div class="padding-md">
			<h4 class="m-top-none"> Do you want to logout?</h4>
		</div>

		<div class="text-center">
			<a class="btn btn-success m-right-sm" href="login.html">Logout</a>
			<a class="btn btn-danger logoutConfirm_close">Cancel</a>
		</div>
	</div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

	<!-- Jquery -->
	<script src="js/jquery-1.10.2.min.js"></script>

	<!-- Bootstrap -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

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
		$(function()	{
			$('#friendListToggle').click(function()	{
				$('.chat-wrapper').toggleClass('sidebar-display');
			});

			$('.scrollable-div').slimScroll({
				height: '100%',
				size: '3px'
			});

			document.ontouchmove = function(e){
			   if(disableScroll){
				 e.preventDefault();
			   }
			}
		});
	</script>

  </body>
</html>
