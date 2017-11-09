<%-- 
    Document   : consultaConv
    Created on : 02-abr-2017, 1:48:05
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                            <a href="index.jsp"></a>
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

        <section id="listado">
            <div class="form-reg">
                <div class="container">
                    <h1>Consulta Fechas</h1>
                    <form action="S_Convocatoria" method="get">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <div class="row">
                                    <label class="control-label col-sm-3">Año lectivo</label>
                                    <div class="col-sm-2">
                                        <input type="number" min="1975" max="2017" name="anio">
                                    </div>
                                    <label class="control-label col-sm-3">Periodo</label>
                                    <div class="col-sm-2">
                                        <select name="periodo"> 
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <button class="btn btn-success">Enviar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <% if(!(request.getAttribute("conv")==null)){
                       if(((String)request.getAttribute("conv")).contains(",")){
                       String [] fechas = ((String) request.getAttribute("conv")).split(",");
                       out.println("<div class='col-sm-12'>");
                       out.println("<table class='table'>");
                       out.println("<thead>");
                        out.println("<tr>");
                            out.println("<th> Fecha Inicio </th>");
                            out.println("<th> Fecha Fin </th>");
                        out.println("</tr>");
                        out.println("</thead>");
                        
                        out.println("<tr class='success'>");
                            out.println("<td>" + fechas[0] + "</td>");
                            out.println("<td>" + fechas[1] + "</td>");
                        out.println("</tr>");
                       out.println("</table>");
                       out.println("</div>");
                        }
                       else{
                           out.println("<div class='col-sm-6'>");
                           out.println(request.getAttribute("conv"));
                           out.println("</div>");
                       }
                    }%>
                    <form action="RegistroSolicitud" method="get">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <div class="row">
                                    <label class="control-label col-sm-4">Número de identificación</label>
                                    <div class="col-sm-4">
                                        <input type="number"  name="identificacion">
                                    </div>
                                    <div class="col-sm-4">
                                        <button class="btn btn-success">Enviar</button>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </form>
                    <% if(!(request.getAttribute("mensaje")==null)){
                        if(((String)request.getAttribute("mensaje")).contains(",")){
                        String [] res = ((String) request.getAttribute("mensaje")).split(",");
                        out.println("<div class='col-sm-12'>");
                        out.println("<table class='table'>");
                        out.println("<thead>");
                         out.println("<tr>");
                             out.println("<th> No. Identificación </th>");
                             out.println("<th> Estado </th>");
                             out.println("<th> Fecha Radicación </th>");
                             out.println("<th> Año </th>");
                         out.println("</tr>");
                         out.println("</thead>");
                        
                         out.println("<tr class='success'>");
                         for(int i=0;i<res.length;i++){
                             out.println("<td>" + res[i] + "</td>");
                         }
                         out.println("</tr>");
                        out.println("</table>");
                        out.println("</div>");
                         }
                        else{
                            out.println("<div class='col-sm-12 alert alert-danger'>");
                            out.println(request.getAttribute("mensaje"));
                            out.println("</div>");
                        }
                     }%>
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
