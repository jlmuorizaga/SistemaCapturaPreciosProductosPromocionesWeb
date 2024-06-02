<%-- 
    Document   : catalogotamaniopizza
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
        <title>Catálogo Productos</title>
        <!--link rel="stylesheet" href="css/estilotabla.css"-->
        <script type="text/javascript">
            function confirmarBorrar(id) {
                if (confirm("¿Estás seguro de que quieres borrar el registro: " + id + "?")) {
                    //alert("¡Has confirmado la acción!");
                    window.location.href = 'productoController.do?accion=borrar&id=' + id;
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
        <h3>Catálogo Productos</h3>      
        <!--form method="POST"-->
        <form>
            <input type=button onclick="window.location.href = 'insertarproducto.jsp';" value="Insertar Producto" class="btnverde">
        </form>
    </center><br>
    <c:if test="${not empty listaProducto}">
        <center>
            <table width="80%" border="1">
                <thead class="text-center">
                    <tr>
                        <th>ID</th>
                        <th>Descripción</th>
                        <th>Tamaño</th>
                        <th>Usa Salsa</th>
                        <th>Producto Tipo</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="dato" items="${listaProducto}">
                    <tr class="trhover">
                        <td width="15%">${dato.getId()}</td>
                        <td width="15%">${dato.getDescripcion()}</td>
                        <td width="15%">${dato.getTamanio()}</td>
                        <td width="15%">${dato.getUsaSalsa()}</td>
                        <td width="15%">${dato.getProductoTipo().getDescripcion()}</td>
                        
                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="window.location.href = 'productoController.do?accion=editar&id=${dato.getId()}&descripcion=${dato.getDescripcion()}&tamanio=${dato.getTamanio()}&usaSabor=${dato.getUsaSalsa()}&idTipoProducto=${dato.getIdTipoProducto()}';" value="Editar" class="btnazul">
                            </form>
                        </td>
                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="javascript:confirmarBorrar('${dato.getId()}');" value="Borrar" class="btnrojo">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </c:if>
</body>
</html>
