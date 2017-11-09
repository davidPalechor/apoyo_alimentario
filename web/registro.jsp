<%-- 
    Document   : registro
    Author     : secru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </head>
    <body>
        <!-- Navigation -->
        <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Navegación</span> Menú <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Apoyo Alimentario</a>
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

        <section id="formulario_ingreso">
            <div id="form_ingreso">
                <div class="container">
                    <h1>Registrarse</h1>
                    <form action="S_RegistroUsuario" method="post">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-2">Código:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="cod" placeholder="Ingrese su código">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">Contraseña:</label>
                                <div class="col-sm-4">
                                    <input type="password" class="form-control" name="pass" placeholder="Ingrese su contraseña">
                                </div>
                            </div>
                            <div style="text-align:center;">
                                <input class="boton" align="right" type="submit" id="registrar" value="Registrar" />

                            </div>
                            <% if(!(request.getAttribute("mensaje")==null)){
                                if((request.getAttribute("mensaje").toString().toLowerCase().contains("exception"))){
                                    out.println("<div class='alert alert-warning'>");
                                    out.println(request.getAttribute("mensaje"));
                                    out.println("</div>");
                                }if((request.getAttribute("mensaje").toString().toLowerCase().contains("inactivo"))){
                                    out.println("<div class='alert alert-warning'>");
                                    out.println("Atención: Estudiante " + request.getAttribute("mensaje"));
                                    out.println("</div>");
                                }else{
                                    out.println("<div class='alert alert-success'>");
                                    out.println("¡Registro Exitoso!");
                                    out.println("</div>");
                                }
                                }                                
                            %>
                        </div>
                    </form>
                </div>
            </div>
        </section>
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
