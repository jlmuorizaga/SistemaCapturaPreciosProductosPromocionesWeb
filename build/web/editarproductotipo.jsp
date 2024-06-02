<%-- 
    Document   : editartamaniopizza
    Created on : 7/04/2023, 11:40:22 AM
    Author     : LUIS.MU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tipo de Producto</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Producto Tipo</h3>      
        <form action="productoTipoController.do">
            <label>Descripción:</label><br>
            <input type="text" id="descripcion" name="descripcion" value="${descripcion}"><br><br>
            <input type="hidden" id="id" name="id" value="${id}"><br><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <input type="submit" value="Editar" class="btnazul">
        </form>
    </center>
</body>
</html>
