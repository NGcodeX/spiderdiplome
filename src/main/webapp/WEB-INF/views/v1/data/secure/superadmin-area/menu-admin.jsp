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
                        <a href="#" class="menu-link" onclick="loadContent('tableau-de-bord')">
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
                        <a href="#" class="menu-link" data-page="gestions-utilisateurs">
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
                        <a href="#" class="menu-link" data-page="all-colleges">
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
            </div><!-- /main-menu -->
        </div><!-- /sidebar-inner -->
    </aside>

    <div id="main-container">

    </div>

</div>
<script>
    function loadContent(page) {
        $.ajax({
            url: page,
            type: 'GET',
            dataType: 'html',
            success: function(data) {
                $('#main-container').html(data);
            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    }
</script>






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