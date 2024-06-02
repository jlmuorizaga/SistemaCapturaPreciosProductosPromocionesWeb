<%-- 
    Document   : menuppal
    Created on : 6/04/2023, 11:05:31 PM
    Author     : LUIS.MU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"-->
        <link rel="shortcut icon" href="#" />
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <style>
            body {
                font-family:Arial;
                /*background-image: url('fondo/elsaborqueimaginaste.png');*/
            }
            .opacidad{
                opacity:0;
            }
        </style>
        <title>Menú Principal</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>        
    </body>
</html>
