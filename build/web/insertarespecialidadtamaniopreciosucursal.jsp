<%-- 
    Document   : insertartamaniopizza
    Created on : 7/04/2023, 01:14:35 AM
    Author     : LUIS.MU
--%>

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloboton.css">
        <link rel="stylesheet" href="css/tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Precio, Especialidad y Tamaño</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type="text/javascript">
            function isNumberKey(evt) {
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode != 46 && charCode > 31 &&
                        (charCode < 48 || charCode > 57))
                    return false;
                return true;
            }
            function validaForma() {
                const formulario = document.getElementById('myForm');
                if (formulario.precio.value == '') {
                    Swal.fire({
                        type: 'warning',
                        title: 'Precio no puede estar vacío',
                        confirmButtonColor: '#a91e1e',
                        confirmButtonText: 'Intenta nuevamente'
                    });
//                    return false;
                    //               } else {
                } else {
                    window.location.href = 'relacionEspecialidadTamanioPrecioSucursalController.do?accion=insertar&precio=' + formulario.precio.value + 
                            '&idEspecialidad=' + formulario.idEspecialidad.value + '&idTamanioPizza=' + formulario.idTamanioPizza.value+
                            '&precio='+formulario.precio.value+'&precioP1='+formulario.precioP1.value+'&aplica2x1='+formulario.aplica2x1.value+
                            '&aplicaP1='+formulario.aplicaP1.value+'&aplicaBebidaChicaGratis='+formulario.aplicaBebidaChicaGratis.value;

                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Precio, Especialidad y Tamaño</h3>      
        <!--form action="relacionEspecialidadTamanioPrecioSucursalController.do"-->
        <form id="myForm" method="post">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Especialidad Pizza</label><br>
                        <select name="idEspecialidad" id="idEspecialidad">
                            <c:forEach var="dato" items="${listaEspecialidadPizza}">
                                <option value="${dato.getIdEspecialidad()}">${dato.getIdEspecialidad()} -  ${dato.getNombreEspecialidad()}</option>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Tamaño Pizza</label><br>
                        <select name="idTamanioPizza" id="idTamanioPizza">
                            <c:forEach var="dato" items="${listaTamanioPizza}">
                                <option value="${dato.getId()}">${dato.getId()} -  ${dato.getNombre()}</option>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>

                <!--tr align="center">
                    <td>
                        <label>Sucursal</label><br>
                        <select name="idSucursal" id="idSucursal" multiple size="10" style="width: 100%;">
                <!--c:forEach var="dato" items="$!--{listaSucursal}">
                    <option value="$!--{dato.getId()}">$!--{dato.getId()} -  $!--{dato.getNombreSucursal()}</option>
                <!--/c:forEach>  
            </select>
        </td>
    </tr-->                                
                <tr align="center">
                    <td>
                        <label>Precio</label><br>
                        <!--input type="number" id="precio "ondrop="return false;" onpaste="return false;" onkeypress="return event.charCode>=48 && event.charCode<=57" required/-->
                        <input id="precio" onkeypress="return isNumberKey(event)" type="text" name="precio">
                        <!--input type="number" id="precio" name="precio"-->
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Precio 1 Pizza</label><br>
                        <!--input type="number" id="precio "ondrop="return false;" onpaste="return false;" onkeypress="return event.charCode>=48 && event.charCode<=57" required/-->
                        <input id="precioP1" onkeypress="return isNumberKey(event)" type="text" name="precioP1">
                        <!--input type="number" id="precio" name="precio"-->
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Aplica 2x1:</label><br>
                        <input type="radio" id="aplica2x1" name="aplica2x1" value="S" checked>Si
                        <input type="radio" id="aplica2x1" name="aplica2x1" value="N">No<br><br>
                        <label>Aplica 1 Pizza:</label><br>
                        <input type="radio" id="aplicaP1" name="aplicaP1" value="S" checked>Si
                        <input type="radio" id="aplicaP1" name="aplicaP1" value="N">No<br><br>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Aplica Bebida Chica Gratis:</label><br>
                        <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="S" checked>Si
                        <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="N">No<br><br>
                    </td>
                </tr>                
            </table><br>
            <input type="hidden" id="accion" name="accion" value="insertar">
            <input type="button" value="Insertar" class="btnverde" onclick="validaForma()">
            <!--input type="submit" value="Insertar" class="btnverde"-->
        </form>
    </center>
</body>
</html>
