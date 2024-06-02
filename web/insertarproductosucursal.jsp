<%-- 
    Document   : insertarproductosucursal
    Created on : 7/04/2023, 01:14:35 AM
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
        <title>Insertar Producto, Precio, Sucursal</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Producto, Precio, Sucursal</h3>      
        <form action="relacionProductoSucursalController.do">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Producto</label><br>
                        <select name="idProducto" id="idProducto">
                            <c:forEach var="dato" items="${listaProducto}">
                                <!--option value="${dato.getId()}">${dato.getId()} -  ${dato.getDescripcion()} - ${dato.getTamanio()}</option-->
                                <option value="${dato.getId()}">${dato.getDescripcion()} - ${dato.getTamanio()}</option>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
                              
                <tr align="center">
                    <td>
                        <label>Precio</label><br>
                        <input type="text" id="precioNormal" name="precioNormal">
                    </td>
                </tr>
                
                <tr align="center">
                    <td>
                        <label>Aplica Bebida Chica Gratis:</label><br>
                        <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="S" checked>Si
                        <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="N">No<br><br>
                    </td>
                </tr>                     
            </table><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="submit" value="Insertar" class="btnverde">
        </form>
    </center>
</body>
</html>
