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
        <title>Catálogo Sucursales</title>
        <!--link rel="stylesheet" href="css/estilotabla.css"-->
        <script type="text/javascript">
            function confirmarBorrar(id) {
                if (confirm("¿Estás seguro de que quieres borrar el registro: " + id + "?")) {
                    //alert("¡Has confirmado la acción!");
                    window.location.href = 'sucursalController.do?accion=borrar&id=' + id;
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
        <h3>Catálogo Sucursales</h3>      
        <!--form method="POST"-->
        <form>
            <input type=button onclick="window.location.href = 'insertarsucursal.jsp';" value="Insertar Sucursal" class="btnverde">
        </form>
    </center><br>
    <c:if test="${not empty listaSucursal}">
        <center>
            <table width="80%" border="1">
                <thead class="text-center">
                    <tr>
                        <th>ID</th>
                        <th>Clave</th>
                        <th>Nombre Sucursal</th>
                        <th>RFC</th>
                        <th>Domicilio</th>
                        <th>Teléfono</th>
                        <th>Hora Inicio</th>
                        <th>Hora Fin</th>
                        <th>Latitud</th>
                        <th>Longitud</th>
                        <th>Lugar</th>
                        <th>Venta Activa</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="dato" items="${listaSucursal}">
                    <tr class="trhover">
                        <td>${dato.getId()}</td>
                        <td>${dato.getClave()}</td>
                        <td>${dato.getNombreSucursal()}</td>
                        <td>${dato.getRfc()}</td>
                        <td>${dato.getDomicilio()}</td>
                        <td>${dato.getTelefono()}</td>
                        <td>${dato.getHoraInicio()}</td>
                        <td>${dato.getHoraFin()}</td>
                        <td>${dato.getLatitud()}</td>
                        <td>${dato.getLongitud()}</td>
                        <td>${dato.getLugar().getNombre()}</td>
                        <td>${dato.getVentaActiva()}</td>
                        
                        <td>
                            <form>
                                <input type=button onclick="window.location.href = 'sucursalController.do?accion=editar&id=${dato.getId()}&clave=${dato.getClave()}&nombreSucursal=${dato.getNombreSucursal()}&rfc=${dato.getRfc()}&domicilio=${dato.getDomicilio()}&telefono=${dato.getTelefono()}&horaInicio=${dato.getHoraInicio()}&horaFin=${dato.getHoraFin()}&latitud=${dato.getLatitud()}&longitud=${dato.getLongitud()}&idLugar=${dato.getIdLugar()}&ventaActiva=${dato.getVentaActiva()}';" value="Editar" class="btnazul">
                            </form>
                        </td>
                        <td>
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
