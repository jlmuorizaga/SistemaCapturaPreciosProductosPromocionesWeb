<%-- 
    Document   : login
    Created on : 6/04/2023, 10:51:10 PM
    Author     : LUIS.MU
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" href="css/sweetalert2.min.css">
        <link rel="stylesheet" href="css/fondo.css">
        <!--script src="js/jquery-3.3.1.min.js"></script-->
        <script src="js/jquery-3.7.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>       
        <script src="js/popper.min.js"></script>
        <script src="js/sweetalert2.all.min.js"></script>
        <!--script src="js/codigo.js"></script-->        
    </head>
    <body>
        <!--div class="container-xxl mt-2"-->    
        <
    <center>
        <h2>Sistema de Captura de precios, productos y promociones Cheese Pizza</h2>
        <!--h6>v.202306050823</h6-->
        <h6>v.202405262058</h6>
    </center>
    <!--/div-->
    <div id="login"><br>
        <h2 class="text-center text-white display-4">Acceso al Sistema</h2>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <!--div id="login-box" class="col-md-12 bg-light text-dark" -->
                    <div id="login-box" class="px-4 bg-light text-dark" > <!-- px-4 es la propiedad que le da un padding de 24px en x a todos los elementos-->
                        <form id="formLogin" class="form" action="">
                            <div class="form-group text-center pt-4">
                                <h3 class="text-center text-dark">Iniciar Sesión</h3>
                            </div>
                            <div class="form-group">
                                <label for="sucursal" class="text-dark">Sucursal:</label>
                                <select name="sucursal" class="form-control" id="sucursal">
                                    <c:forEach var="dato" items="${listaSucursales}">
                                        <option value="${dato.getClave()}">${dato.getClave()} -  ${dato.getNombreSucursal()}</option>
                                    </c:forEach>  
                                </select><br>                            
                            </div>
                            <div class="form-group">
                                <label for="usuario" class="text-dark">Usuario</label>
                                <input type="text" name="usuario" id="usuario" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-dark">Contraseña</label>
                                <input type="password" name="contrasenia" id="contrasenia" class="form-control">
                            </div><br><br><br>
                            <div class="form-group text-center pb-4">
                                <input type="submit" name="submit" class="btn btn-dark btn-lg btn-block" value="Enviar">
                            </div>
                        </form>                        
                    </div>
                </div>
            </div>            
        </div>
    </div>
    <script src="js/codigo.js"></script>
</body>
</html>
