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
        <title>Editar Precio, Especialidad y Tamaño</title>
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
                    window.location.href = 'relacionEspecialidadTamanioPrecioSucursalController.do?accion=guardaedicion&precio='
                            + formulario.precio.value + '&idEspecialidad=' + formulario.idEspecialidad.value + '&idTamanioPizza='
                            + formulario.idTamanioPizza.value + '&precioP1=' + formulario.precioP1.value
                            + '&aplica2x1=' + formulario.aplica2x1.value
                            + '&aplicaP1=' + formulario.aplicaP1.value
                            + '&aplicaBebidaChicaGratis='+formulario.aplicaBebidaChicaGratis.value;

                }
            }
        </script>

    </head>
    <body>
        <jsp:include page="encabezado.jsp"/>   
        <jsp:include page="menu.jsp"/>  
    <center>
        <h3>Catálogo Precio, Especialidad y Tamaño</h3>      
        <form id="myForm" method="post">
            <table border="0">
                <tr align="center">
                    <td>
                        <label>Especialidad Pizza</label><br>
                        <select name="idEspecialidad" id="idEspecialidad">
                            <c:forEach var="dato" items="${listaEspecialidadPizza}">
                                <c:choose>
                                    <c:when test="${dato.getIdEspecialidad()==idEspecialidad}">
                                        <option value="${dato.getIdEspecialidad()}" selected>${dato.getIdEspecialidad()} - ${dato.getNombreEspecialidad()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dato.getIdEspecialidad()}">${dato.getIdEspecialidad()} -  ${dato.getNombreEspecialidad()}</option>
                                    </c:otherwise>                                
                                </c:choose>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <label>Tamaño Pizza</label><br>
                        <select name="idTamanioPizza" id="idTamanioPizza">
                            <c:forEach var="dato" items="${listaTamanioPizza}">
                                <c:choose>
                                    <c:when test="${dato.getId()==idTamanioPizza}">
                                        <option value="${dato.getId()}" selected>${dato.getId()} - ${dato.getNombre()}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dato.getId()}">${dato.getId()} -  ${dato.getNombre()}</option>
                                    </c:otherwise>                                
                                </c:choose>
                            </c:forEach>  
                        </select>
                    </td>
                </tr>

                <tr align="center">
                    <td>
                        <label>Precio</label><br>
                        <input id="precio" value="${precio}" onkeypress="return isNumberKey(event)" type="text" name="precio">
                    </td>
                </tr>

                <tr align="center">
                    <td>
                        <label>Precio 1 Pizza</label><br>
                        <input id="precioP1" value="${precioP1}" onkeypress="return isNumberKey(event)" type="text" name="precioP1">
                    </td>
                </tr>



                <tr align="center">
                    <td colspan="2">
                        <label>Aplica 2 x 1</label><br>
                        <c:choose>
                            <c:when test="${aplica2x1=='S'}">
                                <input type="radio" id="aplica2x1" name="aplica2x1" value="S" checked>Si
                                <input type="radio" id="aplica2x1" name="aplica2x1" value="N">No
                            </c:when>
                            <c:otherwise>
                                <input type="radio" id="aplica2x1" name="aplica2x1" value="S">Si
                                <input type="radio" id="aplica2x1" name="aplica2x1" value="N" checked>No
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <label>Aplica Precio Especial</label><br>
                        <c:choose>
                            <c:when test="${aplicaP1=='S'}">
                                <input type="radio" id="aplicaP1" name="aplicaP1" value="S" checked>Si
                                <input type="radio" id="aplicaP1" name="aplicaP1" value="N">No
                            </c:when>
                            <c:otherwise>
                                <input type="radio" id="aplicaP1" name="aplicaP1" value="S">Si
                                <input type="radio" id="aplicaP1" name="aplicaP1" value="N" checked>No
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>    

                <tr align="center">
                    <td colspan="2">
                        <label>Aplica Bebida Chica Gratis</label><br>
                        <c:choose>
                            <c:when test="${aplicaBebidaChicaGratis=='S'}">
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="S" checked>Si
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="N">No
                            </c:when>
                            <c:otherwise>
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="S">Si
                                <input type="radio" id="aplicaBebidaChicaGratis" name="aplicaBebidaChicaGratis" value="N" checked>No
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>                    



            </table><br>
            <input type="hidden" id="accion" name="accion" value="guardaedicion">
            <!--input type="submit" value="Editar" class="btnazul"-->
            <input type="button" value="Editar" class="btnazul" onclick="validaForma()">
        </form>
    </center>
</body>
</html>
