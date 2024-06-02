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
        <title>Captura de Lugar</title>
        <!--link rel="stylesheet" href="css/estilotabla.css"-->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type="text/javascript">
//            function confirmarBorrar(id) {
//                if (confirm("¿Estás seguro de que quieres borrar el registro: " + id + "?")) {
//                    //alert("¡Has confirmado la acción!");
//                    window.location.href = 'lugarController.do?accion=borrar&id=' + id;
//                } else {
//                    //alert("Has cancelado la acción.");
//                }
//            }
            
            function confirmarBorrar(id) {
                Swal.fire({
                    title: '¿Deseas borrar el registro ? ',
                    text: id,
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    cancelButtonText:'Cancelar',
                    confirmButtonText: 'Borrar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = 'lugarController.do?accion=borrar&id=' + id;
                    }
                })

            }            
        </script>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Captura de Lugar</h3>
        <!--form method="POST"-->
        <form>
            <input type=button onclick="window.location.href = 'insertarlugar.jsp';" value="Insertar Lugar" class="btnverde">
        </form>
    </center><br>
    <c:if test="${not empty listaLugar}">
        <center>
            <table width="80%" border="1">
                <thead class="text-center">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="dato" items="${listaLugar}">
                    <tr class="trhover">
                        <td width="40%">${dato.getId()}</td>
                        <td width="40%">${dato.getNombre()}</td>
                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="window.location.href = 'lugarController.do?accion=editar&id=${dato.getId()}&nombre=${dato.getNombre()}';" value="Editar" class="btnazul">
                            </form>
                        </td>
                        <td width="10%" align="center">
                            <form>
                                <!--input type=button onclick="window.location.href = 'insertartamaniopizza.jsp';" value="Borrar"-->
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
