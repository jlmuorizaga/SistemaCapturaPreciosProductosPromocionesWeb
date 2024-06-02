<%-- 
    Document   : insertarproducto
    Created on : 26/04/2023, 10:16:07 PM
    Author     : LUIS.MU
--%>


<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Producto</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Productos</h3>      
        <form action="productoController.do">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Descripción</label><br>
                        <input type="text" id="descripcion" name="descripcion">
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Tamaño</label><br>
                        <input type="text" id="tamanio" name="tamanio">
                    </td>
                </tr>

                <tr align="center">
                    <td>
                        <label>Usa Sabor</label><br>
                        <input type="text" id="usaSabor" name="usaSabor">
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <label>Tipo de Producto</label><br>
                        <select name="idTipoProducto" id="idTipoProducto">
                            <c:forEach var="dato" items="${listaProductoTipo}">
                                <option value="${dato.getId()}">${dato.getId()} -  ${dato.getDescripcion()}</option>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
            </table><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="submit" value="Insertar" class="btnverde">
        </form>
    </center>
</body>
</html>

