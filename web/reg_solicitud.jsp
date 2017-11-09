<%-- 
    Document   : reg_solicitud
    Created on : 25-mar-2017, 22:39:42
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 6px 6px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input.boton{
            background: #B0E0E6;
        }
    </style>
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

        <header></header>
        <section id="formulario">
            <% if(!(request.getAttribute("mensaje")==null)){
                    if((request.getAttribute("mensaje").toString().toLowerCase().contains("exception"))){
                    out.println("<div class='alert alert-warning'>");
                    out.println(request.getAttribute("mensaje"));
                    out.println("</div>");
                    }else{
                        
                    out.println("<div class='alert alert-success'>");
                    out.println("¡Registro Exitoso!");
                    out.println("</div>");
                }
              }else{
                out.println("<div class='alert alert-danger'>");
                out.println("Ya existe solicitud");
                out.println("</div>");
            }
            %>
            <div id="form_reg">
                <div class="container">
                    <h1>Solicitud de Apoyo</h1>
                    <form action='RegistroSolicitud' method='post' >
                        <div class="form-horizontal">
                               
                            <div class="form-group">
                                <label class="control-label col-sm-2">Documento de identificación:</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" name="identificacion" placeholder="Ingrese número de documento">
                                </div>
                            </div>
                           
                            <div class="form-group">
                                <div class="row">
                                    <label class="control-label col-sm-2">Año lectivo</label>
                                    <div class="col-sm-2">
                                        <input type="number" min="1975" max="2017" name="anio">
                                    </div>
                                    <label class="control-label col-sm-2">Periodo</label>
                                    <div class="col-sm-2">
                                        <select name="periodo"> 
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="con"
                        </div>
                        <h3>Condiciones Socio-económicas</h3>
                        Para los siguientes campos debe adjuntar un documento que respalde su respuesta.<br>
                        Estos documentos serán revisados por el personal de Bienestar Institucional.
                        <div class="form-group">
                            <label class="control-label col-sm-2">Ingresos familiares:</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="ingresos" placeholder="Digite los ingresos familiares">
                                <input type="file" name="archivo_ingresos" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Sostiene el hogar en donde vive</label>
                            <div class="col-sm-3">
                                <select id="sostiene_hogar" name="sostiene_hogar" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_sostiene_hogar" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Se sostiene a si mismo</label>
                            <div class="col-sm-3">
                                <select id="sostiene_si_mismo" name="sostiene_si_mismo" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_sostiene_si_mismo" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Vive fuera de su nucleo familiar</label>
                            <div class="col-sm-3">
                                <select id="vive_fuera" name="vive_fuera" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_vive_fuera" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Tiene cónyuge, hijos y/u otras personas a cargo</label>
                            <div class="col-sm-3">
                                <select id="personas_a_cargo" name="personas_a_cargo" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_personas_a_cargo" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Vive en casa de empleador</label>
                            <div class="col-sm-3">
                                <select id="vive_casa_empleador" name="vive_casa_empleador" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_vive_casa_empleador" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Se encuentra en condición de desplazamiento forzado</label>
                            <div class="col-sm-3">
                                <select id="desplazado" name="desplazado" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_desplazado" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Proviene de municipios distintos a Bogotá</label>
                            <div class="col-sm-3">
                                <select id="municipio" name="municipio" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_municipio" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Reside en zonas de alto grado de vulnerabilidad social y económica</label>
                            <div class="col-sm-3">
                                <select id="vulnerabilidad" name="vulnerabilidad" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_vulnerabilidad" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Presenta algún tipo de discapacidad física o mental</label>
                            <div class="col-sm-3">
                                <select id="discapacidad" name="discapacidad" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_discapacidad" accept=".pdf">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Presenta alguna patología o sintomatología asociada con problemas de alimentación </label>
                            <div class="col-sm-3">
                                <select id="patologia" name="patologia" class="col-sm-4">
                                    <option value="si">Sí</option>
                                    <option value="no">No</option>
                                </select>
                                <input type="file" name="archivo_patologia" accept=".pdf">
                            </div>
                        </div>
                        <div style="text-align:center;">
                            <input class="boton" align="right" type="submit" id="enviar" value="Enviar solicitud"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>

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
                        <p>Laura Murcia (CEO)</p>
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
