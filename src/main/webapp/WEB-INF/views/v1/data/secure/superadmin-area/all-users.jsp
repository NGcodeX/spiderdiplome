<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${user.getNom()}|Admin/Utilisateur</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome-->
    <link href="css/font-awesome.min.css" rel="stylesheet">

    <!-- Pace -->
    <link href="css/pace.css" rel="stylesheet">

    <!-- Datatable -->
    <link href="css/jquery.dataTables_themeroller.css" rel="stylesheet">

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
            <span class="text-toggle"> SChool</span>
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
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-edit fa-lg"></i> profile</a>
                    </li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-file-text-o fa-lg"></i>
                        Grades</a></li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-newspaper-o fa-lg"></i>
                        Reports</a></li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-money fa-lg"></i> Wallet</a>
                    </li>
                    <li><a tabindex="-1" href="#" class="theme-setting"><i class="fa fa-cogs fa-lg"></i> Setting</a>
                    </li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-university"></i>
                        Admission Infos</a></li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-key fa-lg"></i> Change
                        PassWord</a></li>
                    <li><a tabindex="-1" href="profile.html" class="main-link"><i class="fa fa-life-ring"></i> basic
                        knowledge</a></li>
                    <li><a tabindex="-1" href="gallery.html" class="main-link"><i class="fa fa-picture-o fa-lg"></i>
                        Photo Gallery</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" class="main-link logoutConfirm_open" href="#logoutConfirm"><i
                            class="fa fa-lock fa-lg"></i> Log out</a></li>
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
            </div>
            <div class="main-menu">
                <ul>
                    <li class="active">
                        <a href="tb-admin">
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
                <li><i class="fa fa-home"></i><a href=""> Home</a></li>
                <li class="active">Utilisateurs</li>
            </ul>
        </div><!-- /breadcrumb-->
        <div class="main-header clearfix">
            <a href="ajout-utilisateur" class="btn btn-success"><i class="fa fa-plus"></i> Ajouter Utilisateur</a>
            <a class="btn btn-default" onclick="printTable()"><i class="fa fa-print"></i> Print</a>
            <script>
                function printTable() {
                    var printWindow = window.open('', '', 'height=600,width=800');
                    printWindow.document.write('<html><head><title>UTILISATEUR D APPLICATION SPIDER</title>');
                    printWindow.document.write('</head><body>');
                    printWindow.document.write('<h1>UTILISATEUR D APPLICATION SPIDER</h1>');
                    printWindow.document.write(document.getElementById('dataTable').outerHTML);
                    printWindow.document.write('</body></html>');
                    printWindow.document.close();
                    printWindow.print();
                }
            </script>
            <a class="btn btn-danger"><i class="fa fa-download"></i> Export</a>
            <a class="btn btn-primary"><i class="fa fa-upload"></i> Import</a>
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
                        <span>Balance Actuelle</span>
                        <h4><strong id="currentBalance">500000</strong> CFA</h4>
                    </div>
                </li>
            </ul><!-- /page-stats -->
        </div><!-- /main-header -->
        <div class="padding-md">
            <div class="row">
                <div class="col-md-3 col-sm-4">
                    ${errorAdd}
                    ${successAdd}
                </div>
            </div>
        </div>
        <div class="padding-md">
            <div class="panel panel-default table-responsive">
                <div class="panel-heading">
                    Tous les utilisateurs
                    <span class="label label-info pull-right">Tous les utilisateurs de Spider Diplome. vous pouvez ajouter, afficher, mettre à jour, supprimer des utilisateurs</span>
                </div>
                <div class="padding-md clearfix">
                    <table class="table table-striped" id="dataTable">
                        <thead>
                        <tr>
                            <th>Matricule</th>
                            <th>Full Name</th>
                            <th>Role</th>
                            <th>Mobile</th>
                            <th>E-mail</th>
                            <th>Join-Date</th>
                            <th>Wallet</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="users" items="${users}">
                            <tr>
                                <th>${users.matricule}</th>
                                <th>${users.nom} ${users.prenom}</th>
                                <td>${users.role}</td>
                                <th>${users.phone}</th>
                                <td>${users.email}</td>
                                <td><fmt:formatDate value="${users.dateInscription}" pattern="yyyy-MM-dd"/></td>
                                <td>500</td>
                                <c:choose>
                                    <c:when test="${users.statut == 1}">
                                        <th><span class="label label-success">Actif</span></th>
                                    </c:when>
                                    <c:otherwise>
                                        <th><span class="label label-danger">Inactif</span></th>
                                    </c:otherwise>
                                </c:choose>
                                <td style="font-size: 20px;">
                                    <a href="#" onclick="viewUser('${users.matricule}')"><i
                                            class="fa fa-info-circle"></i></a>
                                    <a href="#" onclick="editUser('${users.matricule}')"><i class="fa fa-edit"></i></a>
                                    <a href="#" onclick="pauseUser('${users.matricule}')"><i
                                            class="fa fa-pause"></i></a>
                                    <a href="#" onclick="signInUser('${users.matricule}')"><i class="fa fa-sign-in"></i></a>
                                    <i class="fa fa-trash-o" onclick="deleteUser('${users.matricule}')"></i>
                                </td>
                            </tr>
                        </c:forEach>
                        <script>
                            function viewUser(matricule) {
                                window.location.href = 'voir-utilisateur?matricule=' + encodeURIComponent(matricule);
                            }

                            function editUser(matricule) {
                                window.location.href = 'editer-utilisateur?matricule=' + encodeURIComponent(matricule);
                            }

                            function pauseUser(matricule) {
                                // Implement your logic here
                                // For example, you might want to make a fetch request to a server-side route that handles the "pause" action
                                fetch('pause-utilisateur', {
                                    method: 'POST',
                                    headers: {
                                        'Content-Type': 'application/x-www-form-urlencoded',
                                    },
                                    body: 'matricule=' + encodeURIComponent(matricule),
                                })
                                    .then(response => {
                                        if (!response.ok) {
                                            throw new Error('Network response was not ok');
                                        }
                                        location.reload();
                                    })
                                    .catch(error => {
                                        console.error('There has been a problem with your fetch operation:', error);
                                    });
                            }

                            function signInUser(matricule) {
                                // Implement your logic here
                                // For example, you might want to make a fetch request to a server-side route that handles the "sign in" action
                                fetch('sign-in-utilisateur', {
                                    method: 'POST',
                                    headers: {
                                        'Content-Type': 'application/x-www-form-urlencoded',
                                    },
                                    body: 'matricule=' + encodeURIComponent(matricule),
                                })
                                    .then(response => {
                                        if (!response.ok) {
                                            throw new Error('Network response was not ok');
                                        }
                                        location.reload();
                                    })
                                    .catch(error => {
                                        console.error('There has been a problem with your fetch operation:', error);
                                    });
                            }

                            function deleteUser(matricule) {
                                fetch('supprimer-utilisateur', {
                                    method: 'POST',
                                    headers: {
                                        'Content-Type': 'application/x-www-form-urlencoded',
                                    },
                                    body: 'matricule=' + encodeURIComponent(matricule),
                                })
                                    .then(response => {
                                        if (!response.ok) {
                                            throw new Error('Network response was not ok');
                                        }
                                        location.reload();
                                    })
                                    .catch(error => {
                                        console.error('There has been a problem with your fetch operation:', error);
                                    });
                            }
                        </script>
                        </tbody>
                    </table>
                </div><!-- /.padding-md -->
            </div><!-- /panel -->
        </div><!-- /.padding-md -->
    </div><!-- /main-container -->
</div><!-- /wrapper -->

<a href="" id="scroll-to-top" class="hidden-print"><i class="fa fa-chevron-up"></i></a>

<!-- Logout confirmation -->
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
