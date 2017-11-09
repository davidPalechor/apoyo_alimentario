<%-- 
    Document   : index
    Created on : 25-mar-2017, 21:14:25
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="shortcut icon" href="img/favicon.png">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Portal Apoyo Alimentario</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="css/freelancer.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body id="page-top" class="index">
        <div id="skipnav"></div>

        <!-- Navigation -->
        <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Navegación</span> Menú <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="#page-top">Apoyo Alimentario</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menú <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="page-scroll">
                                    <a class="link" href="crearConvocatoria.jsp">Crear Convocataria</a>
                                </li>
                                <li class="page-scroll">
                                    <a class="link" href="reg_solicitud.jsp">Registrar Solicitud</a>
                                </li>
                                <li class="page-scroll">
                                    <a class="link" href="validarSolicitudes.jsp">Validar </a>
                                </li>
                                <li class="page-scroll">
                                    <a class="link" href="consultaConv.jsp">Consultar</a>
                                </li>
                                <li class="page-scroll">
                                    <a class="link" href="S_Listado">Generar Listado</a>
                                </li>
                                <li class="page-scroll">
                                    <a class="link" href="ingreso.jsp">Ingresar</a>
                                </li>
                            </ul>
                        </li>


                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>

        <!-- Header -->
        <header>
            <div class="container" id="maincontent" tabindex="-1">
                <div class="row">
                    <div class="col-lg-12">
                        <img class="img-responsive" src="img/UDFJC.png" draggable ="false" alt="">
                        <div class="intro-text">
                            <h1 class="name">Bienvenido 
                                <% if(session.getAttribute("usuario") != null){
                                    out.print(session.getAttribute("usuario"));
                                }else{
                                     out.print("Invitado");}%></h1>
                            <hr class="star-light">
                            <span class="skills">Apoyo Alimentario Periodo 2017-1</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Footer -->
        <footer class="text-center">
            <div class="footer-above">
                <div class="container">
                    <div class="row">
                        <div class="footer-col col-md-6">
                            <h3>Ubicación</h3>
                            <p>Carrera 8 #40 - 62
                                <br>Bogotá, Colombia</p>
                        </div>

                        <div class="footer-col col-md-6">
                            <h3>Equipo</h3>
                            <p>Sebastián Cruz</p>
                            <p>Sergio Palechor</p>
                            <p>Laura Murcia</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer-below">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            Copyright &copy; Bases de Datos II 2017
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
        <div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
            <a class="btn btn-primary" href="#page-top">
                <i class="fa fa-chevron-up"></i>
            </a>
        </div>

        <!-- jQuery -->
        <script src="vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="js/jqBootstrapValidation.js"></script>
        <script src="js/contact_me.js"></script>

        <!-- Theme JavaScript -->
        <script src="js/freelancer.min.js"></script>

    </body>

</html>
