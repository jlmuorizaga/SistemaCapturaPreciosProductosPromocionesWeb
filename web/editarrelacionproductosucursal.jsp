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
        <title>Editar Producto, Precio, Sucursal</title>
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
                                <c:choose>
                                    <c:when test="${dato.getId()==idProducto}">
                                        <option value="${dato.getId()}" selected>${dato.getId()} - ${dato.getDescripcion()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dato.getId()}">${dato.getId()} -  ${dato.getDescripcion()}</option>
                                    </c:otherwise>                                
                                </c:choose>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Precio</label><br>
                        <input id="precioNormal" value="${precioNormal}" onkeypress="return isNumberKey(event)" type="text" name="precioNormal">
                    </td>
                </tr>
                
                <tr align="center">
                    <td colspan="2">
                        <label>Aplica Bebida Chica Gratis</label><br>
                        <c:choose>
                            <c:when test="${aplicaBebidaChicaGratis=='S'}">
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="S" checked>Si
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="N">No
                            </c:when>
                            <c:otherwise>
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="S">Si
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="N" checked>No
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>                   
            </table><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <input type="submit" value="Editar" class="btnazul">
        </form>
    </center>
</body>
</html>
