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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
        <title>Catálogo Precio, Especialidad y Tamaño</title>
        <!--link rel="stylesheet" href="css/estilotabla.css"-->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type="text/javascript">
//            function confirmarBorrar(idEspecialidad,idTamanioPizza,idSucursal) {
//                if (confirm("¿Estás seguro de que quieres borrar el registro: " + idEspecialidad +"-"+ idTamanioPizza+"-"+idSucursal+"?")) {
//                    //alert("¡Has confirmado la acción!");
//                    window.location.href = 'relacionEspecialidadTamanioPrecioSucursalController.do?accion=borrar&idEspecialidad='+idEspecialidad+'&idTamanioPizza='+idTamanioPizza+'&idSucursal='+idSucursal;
//                } else {
//                    //alert("Has cancelado la acción.");
//                }
//            }
            
            function confirmarBorrar(idEspecialidad,idTamanioPizza,idSucursal) {
                Swal.fire({
                    title: '¿Deseas borrar el registro ? ',
                    text: idEspecialidad +'-'+idTamanioPizza+'-'+idSucursal,
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    cancelButtonText:'Cancelar',
                    confirmButtonText: 'Borrar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = 'relacionEspecialidadTamanioPrecioSucursalController.do?accion=borrar&idEspecialidad='+idEspecialidad+'&idTamanioPizza='+idTamanioPizza+'&idSucursal='+idSucursal;
                    }
                })
            }
        </script>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Precio, Especialidad y Tamaño</h3>      
        <!--form method="POST"-->
        <form>
            <input type=button onclick="window.location.href = 'insertarespecialidadtamaniopreciosucursal.jsp';" value="Insertar Registro Precio, Especialidad, Tamaño" class="btnverde">
        </form>
    </center><br>
    <c:if test="${not empty listaRelacionEspecialidadTamanioPrecioSucursal}">
        <center>
            <table width="80%" border="1">
                <thead class="text-center">
                    <tr>
                        <th>Especialidad Pizza</th>
                        <th>Tamaño Pizza</th>
                        <th>Sucursal</th>
                        <th>Precio</th>
                        <th>Precio 1 Pizza:</th>
                        <th>Aplica 2 x 1</th>
                        <th>Aplica Precio Especial</th>
                        <th>Aplica Bebida Chica Gratis</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <c:forEach var="dato" items="${listaRelacionEspecialidadTamanioPrecioSucursal}">
                    <tr class="trhover">
                        <td width="10%">${dato.getEspecialidadPizza().getNombreEspecialidad()}</td>
                        <td width="10%">${dato.getTamanioPizza().getNombre()}</td>
                        <td width="10%">${dato.getSucursal().getClave()} - ${dato.getSucursal().getNombreSucursal()}</td>
                        <td width="10%">${dato.getPrecio()}</td>
                        <td width="10%">${dato.getPrecioP1()}</td>
                        <td width="10%">${dato.getAplica2x1()}</td>
                        <td width="10%">${dato.getAplicaP1()}</td>
                        <td width="10%">${dato.getAplicaBebidaChicaGratis()}</td>
                        
                        
                        
                        
                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="window.location.href = 'relacionEspecialidadTamanioPrecioSucursalController.do?accion=editar&idEspecialidad=${dato.getIdEspecialidad()}&idTamanioPizza=${dato.getIdTamanioPizza()}&idSucursal=${dato.getIdSucursal()}&precio=${dato.getPrecio()}&precioP1=${dato.getPrecioP1()}&aplica2x1=${dato.getAplica2x1()}&aplicaP1=${dato.getAplicaP1()}&aplicaBebidaChicaGratis=${dato.getAplicaBebidaChicaGratis()}';" value="Editar" class="btnazul">
                            </form>
                        </td>
                        <td width="10%" align="center">
                            <form>
                                <input type=button onclick="javascript:confirmarBorrar('${dato.getIdEspecialidad()}','${dato.getIdTamanioPizza()}','${dato.getIdSucursal()}');" value="Borrar" class="btnrojo">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </c:if>
</body>
</html>
