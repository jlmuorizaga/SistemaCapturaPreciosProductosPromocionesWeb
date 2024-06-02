<%-- 
    Document   : Catálogo Precio, Especialidad y Tamaño
    Created on : 7/04/2023, 12:06:56 AM
    Author     : LUIS.MU
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
        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
        <title>Catálogo Precio, Especialidad y Tamaño</title>
        <!--link rel="stylesheet" href="css/estilotabla.css"-->
        <script type="text/javascript">
            function confirmarBorrar(idProducto, idSucursal) {
                if (confirm("¿Estás seguro de que quieres borrar el registro: " + idProducto + "-" + idSucursal + "?")) {
                    //alert("¡Has confirmado la acción!");
                    window.location.href = 'relacionProductoSucursalController.do?accion=borrar&idProducto=' + idProducto + '&idSucursal=' + idSucursal;
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
        <h3>Catálogo Producto, Precio, Sucursal</h3>      
        <!--form method="POST"-->
        <form>
            <input type=button onclick="window.location.href = 'insertarproductosucursal.jsp';" value="Insertar Registro Producto, Precio Sucursal" class="btnverde">
        </form>
    </center><br>
    <c:if test="${not empty listaRelacionProductoSucursal}">
        <center>
            <table width="80%" border="1">
                <thead class="text-center">
                    <tr>
                        <th>Producto</th>
                        <th>Sucursal</th>
                        <th>Precio</th>
                        <th>Aplica Bebida Chica Gratis</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="dato" items="${listaRelacionProductoSucursal}">
                    <tr class="trhover">
                        <td width="25%">${dato.getProducto().getDescripcion()} - ${dato.getProducto().getTamanio()}</td>
                        <td width="25%">${dato.getSucursal().getClave()} - ${dato.getSucursal().getNombreSucursal()}</td>
                        <td width="10%">${dato.getPrecioNormal()}</td>
                        <td width="10%">${dato.getAplicaBebidaChicaGratis()}</td>

                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="window.location.href = 'relacionProductoSucursalController.do?accion=editar&idProducto=${dato.getIdProducto()}&idSucursal=${dato.getIdSucursal()}&precioNormal=${dato.getPrecioNormal()}&aplicaBebidaChicaGratis=${dato.getAplicaBebidaChicaGratis()}';" value="Editar" class="btnazul">
                            </form>
                        </td>
                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="javascript:confirmarBorrar('${dato.getIdProducto()}', '${dato.getIdSucursal()}');" value="Borrar" class="btnrojo">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </c:if>
</body>
</html>
