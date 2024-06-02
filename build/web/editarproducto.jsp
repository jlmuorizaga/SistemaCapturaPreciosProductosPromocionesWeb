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
        <title>Editar Producto</title>
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
                        <input type="text" id="descripcion" name="descripcion" value="${descripcion}">
                    </td>
                </tr>
               <tr align="center">
                    <td>
                        <label>Tamaño</label><br>
                        <input type="text" id="tamanio" name="tamanio" value="${tamanio}">
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Usa Sabor</label><br>
                        <input type="text" id="usaSabor" name="usaSabor" value="${usaSabor}">
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <label>Tipo de Producto</label><br>
                        <select name="idTipoProducto" id="idTipoProducto">
                            <c:forEach var="dato" items="${listaProductoTipo}">
                                <c:choose>
                                    <c:when test="${dato.getId()==idTipoProducto}">
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



            </table>
            <input type="hidden" id="id" name="id" value="${id}"><br><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <input type="submit" value="Editar" class="btnazul">            

        </form>
    </center>
</body>
</html>
