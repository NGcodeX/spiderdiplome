<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${user.getNom()}|Admission</title>
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
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-edit fa-lg"></i> profile</a>
                    </li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-money fa-lg"></i>
                        Candidature</a></li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-newspaper-o fa-lg"></i>
                        Forum</a></li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-money fa-lg"></i> Compte
                        money</a></li>
                    <li><a tabindex="-1" href="#" class="theme-setting"><i class="fa fa-cogs fa-lg"></i> Parametre</a>
                    </li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-university"></i> Spider
                        Infos</a></li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-life-ring"></i> Base
                        Connaissance</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" class="main-link logoutConfirm_open" href="#logoutConfirm"><i
                            class="fa fa-lock fa-lg"></i> Verrouillage</a></li>
                    <li><a tabindex="-1" class="main-link logoutConfirm_open" href="#logoutConfirm"><i
                            class="fa fa-lock fa-lg"></i> Deconnexion</a></li>
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
                <a class="btn btn-sm pull-right logoutConfirm_open" href="#logoutConfirm">
                    <i class="fa fa-power-off"></i>
                </a>
            </div><!-- /size-toggle -->
            <div class="user-block clearfix">
                <img src="img/user.jpg" alt="User Avatar">
                <div class="detail">
                    <strong>${user.getNom()} ${user.getPrenom()}</strong><span
                        class="badge badge-success m-left-xs bounceIn animation-delay4">Online</span>
                    <ul class="list-inline">
                        <li><a href="#">tempMat:</a></li>
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
                        <a href="tb-candidatpotentiel" class="menu-link">
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
                        <a href="adm-candidatpotentiel" class="menu-link">
								<span class="menu-icon">
									<i class="fa fa-certificate fa-lg"></i>
								</span>
                            <span class="text">
									Admission
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
									Perte-Diplome
								</span>
                            <span class="menu-hover"></span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="#" class="menu-link">
								<span class="menu-icon">
									<i class="fa fa-picture-o fa-lg"></i>
								</span>
                            <span class="text">
									Carte d'Identité
								</span>
                            <span class="menu-hover"></span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="#" class="menu-link">
								<span class="menu-icon">
									<i class="fa fa-briefcase fa-lg"></i>
								</span>
                            <span class="text">
									FNE Travail
								</span>
                            <span class="menu-hover"></span>
                        </a>
                    </li>
                </ul>
                <div class="alert alert-info">
                    Bienvenue a Spider Diplome. n'oublié pas de nous soutenir afin de rendre la digitalisation
                    accessible pour tous
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
                        <span>compte</span>
                        <h4><strong id="currentBalance">500</strong> CFA</h4>
                    </div>
                </li>
            </ul><!-- /page-stats -->
        </div><!-- /main-header -->

        <div class="grey-container shortcut-wrapper">
            <a href="candidature" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-user"></i>
					</span>
                <span class="text">Nouvelle Candidature</span>
            </a>
            <a href="universites" class="shortcut-link">
					<span class="shortcut-icon">
						<i class="fa fa-building-o"></i>
					</span>
                <span class="text">Université</span>
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
                <span class="text">Parametre profile</span>
            </a>
        </div><!-- /grey-container -->

        <div class="padding-md">
            <div class="row">
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-default panel-stat1 bg-success">
                        <div class="panel-body">
                            <div class="value">${fn:length(candidature)}</div>
                            <div class="title">
                                <i class="fa fa-graduation-cap"></i>
                                <span class="m-left-xs">Candidature en cours</span>
                            </div>
                        </div>
                    </div><!-- /panel -->
                </div><!-- /.col -->
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-default panel-stat2 bg-warning">
                        <div class="panel-body">
										<span class="stat-icon">
											<i class="fa fa-building-o"></i>
										</span>
                            <div class="pull-right text-right">
                                <div class="value">${fn:length(universite)}</div>
                                <div class="title">Université disponible</div>
                            </div>
                        </div>
                    </div><!-- /panel -->
                </div><!-- /.col -->
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-default panel-stat2 bg-info">
                        <div class="panel-body">
										<span class="stat-icon">
											<i class="fa fa-envelope"></i>
										</span>
                            <div class="pull-right text-right">
                                <div class="value">0</div>
                                <div class="title">Verification encours</div>
                            </div>
                        </div>
                    </div><!-- /panel -->
                </div><!-- /.col -->
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <div class="row">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Etat de votre candidature
                            </div>
                            <table class="table table-bordered table-condensed table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Université</th>
                                    <th>Departement</th>
                                    <th>Faculte</th>
                                    <th>Date</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        ICTU
                                    </td>
                                    <td>
                                        ICTDEPT
                                    </td>
                                    <td>Software eng</td>
                                    <td>
                                        Oct 08,2013
                                    </td>
                                    <td>
                                        <span class="label label-warning">Pending</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Yde 1
                                    </td>
                                    <td>
                                        Info
                                    </td>
                                    <td>Bachlor</td>
                                    <td>
                                        29 Sep,2013
                                    </td>
                                    <td>
                                        <span class="label label-success">Approved</span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div><!-- /panel -->
                    </div>
                </div><!-- /.col -->
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Vous avez des questions?
                        </div>
                        <div class="panel-tab clearfix">
                            <ul class="tab-bar">
                                <li class="active"><a href="#home1" data-toggle="tab"><i class="fa fa-question"></i> Admission</a></li>
                                <li><a href="#profile1" data-toggle="tab"><i class="fa fa-question"></i> Diplome</a></li>
                                <li><a href="#message1" data-toggle="tab"><i class="fa fa-question"></i> Candidature</a></li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="home1">
                                    <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
                                </div>
                                <div class="tab-pane fade" id="profile1">
                                    <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
                                </div>
                                <div class="tab-pane fade" id="message1">
                                    <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
                                </div>
                            </div>
                        </div>
                    </div><!-- /panel -->
                </div>
            </div><!-- /.row -->

        </div><!-- /.padding-md -->
    </div>

</div>

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
<div class="custom-popup width-100" id="deleteConfirm">
    <div class="padding-md">
        <h4 class="m-top-none"> Voulez Vous vraiment supprimer cette utilisateur???</h4>
    </div>

    <div class="text-center">
        <a class="btn btn-success m-right-sm" href="deconnexion">Oui je suis conscient</a>
        <a class="btn btn-danger logoutConfirm_close">Non c est une erreur</a>
    </div>
</div>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<!-- Jquery -->
<script src="js/jquery-1.10.2.min.js"></script>

<!-- Bootstrap -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<!-- Datatable -->
<script src='js/jquery.dataTables.min.js'></script>

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
        $('#dataTable').dataTable({
            "bJQueryUI": true,
            "sPaginationType": "full_numbers"
        });

        $('#chk-all').click(function () {
            if ($(this).is(':checked')) {
                $('#responsiveTable').find('.chk-row').each(function () {
                    $(this).prop('checked', true);
                    $(this).parent().parent().parent().addClass('selected');
                });
            } else {
                $('#responsiveTable').find('.chk-row').each(function () {
                    $(this).prop('checked', false);
                    $(this).parent().parent().parent().removeClass('selected');
                });
            }
        });
    });
</script>

</body>
</html>
