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
        <title>Editar Promoción, Sucursal</title>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Editar Promoción, Sucursal</h3>      
        <form action="relacionPromocionEspecialSucursalController.do">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Promoción</label><br>
                        <select name="idPromocion" id="idPromocion" style="width:1000px" size="15">
                            <c:forEach var="dato" items="${listaPromocion}">
                                <c:choose>
                                    <c:when test="${dato.getId()==idPromocion}">
                                        <option value="${dato.getId()}" selected>${dato.getId()} - ${dato.getDefinicion()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dato.getId()}">${dato.getId()} -  ${dato.getDefinicion()}</option>
                                    </c:otherwise>                                
                                </c:choose>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Activa</label><br>
                        <input type="text" id="activa" name="activa" value="${activa}">                        
                    </td>
                </tr>
            </table><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <input type="submit" value="Editar" class="btnazul">
        </form>
    </center>
</body>
</html>
