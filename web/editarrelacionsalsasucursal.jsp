<%-- 
    Document   : editarrelacionsalsasucursal
    Created on : 4/03/2024, 09:09:14 PM
    Author     : jlmuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Salsa, Sucursal</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Salsa, Sucursal</h3>      
        <form action="relacionSalsaSucursalController.do">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Salsa</label><br>
                        <select name="idSalsa" id="idSalsa">
                            <c:forEach var="dato" items="${listaSalsa}">
                                <c:choose>
                                    <c:when test="${dato.getId()==idSalsa}">
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
                <!--tr align="center">
                    <td>
                        <label>Sucursal</label><br>
                        <select name="idSucursal" id="idSucursal">
                            <!--c:forEach var="dato" items="$!--{listaSucursal}">
                                <!--c:choose>
                                    <!--c:when test="$!--{dato.getId()==idSucursal}">
                                        <option value="$!--{dato.getId()}" selected>$!--{dato.getId()} - $!--{dato.getNombreSucursal()}</option>
                                    <!--/c:when>
                                    <!--c:otherwise>
                                        <option value="$!--{dato.getId()}">$!--{dato.getId()} -  $!--{dato.getNombreSucursal()}</option>
                                    <!--/c:otherwise>                                
                                <!--/c:choose>
                            <!--/c:forEach>  
                        </select>
                    </td>
                </tr-->                                
                <tr align="center">
                    <td>
                        <label>Precio</label><br>
                        <input type="text" id="precioNormal" name="precioNormal" value="${precioNormal}">
                    </td>
                </tr>
            </table><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <input type="submit" value="Editar" class="btnazul">
        </form>
    </center>
</body>
</html>
