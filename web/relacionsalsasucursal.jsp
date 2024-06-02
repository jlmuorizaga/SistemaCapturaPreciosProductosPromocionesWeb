<%-- 
    Document   : relacionsalsasucursal
    Created on : 4/03/2024, 09:08:24 PM
    Author     : jlmuo
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <link rel="stylesheet" href="css/estiloboton.css">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo Salsa, Sucursal</title>
        <script type="text/javascript">
            function confirmarBorrar(idSalsa, idSucursal) {
                if (confirm("¿Estás seguro de que quieres borrar el registro: " + idSalsa + "-" + idSucursal + "?")) {
                    //alert("¡Has confirmado la acción!");
                    window.location.href = 'relacionSalsaSucursalController.do?accion=borrar&idSalsa=' + idSalsa + '&idSucursal=' + idSucursal;
                } else {
                    //alert("Has cancelado la acción.");
                }
            }
        </script>        
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>
    <center>
        <h3>Catálogo Salsa,Sucursal</h3>      
        <form>
            <input type=button onclick="window.location.href = 'insertarsalsasucursal.jsp';" value="Insertar Registro Salsa, Sucursal" class="btnverde">
        </form>
    </center><br>
    <c:if test="${not empty listaRelacionSalsaSucursal}">
        <center>
            <table width="80%" border="1">
                <thead class="text-center">
                    <tr>
                        <th>Salsa</th>
                        <th>Sucursal</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="dato" items="${listaRelacionSalsaSucursal}">
                    <tr class="trhover">
                        <td width="25%">${dato.getSalsa().getDescripcion()}</td>
                        <td width="25%">${dato.getSucursal().getClave()} - ${dato.getSucursal().getNombreSucursal()}</td>

                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="window.location.href = 'relacionSalsaSucursalController.do?accion=editar&idSalsa=${dato.getIdSalsa()}&idSucursal=${dato.getIdSucursal()}';" value="Editar" class="btnazul">
                            </form>
                        </td>
                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="javascript:confirmarBorrar('${dato.getIdSalsa()}', '${dato.getIdSucursal()}');" value="Borrar" class="btnrojo">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </c:if>        
    </body>
</html>
