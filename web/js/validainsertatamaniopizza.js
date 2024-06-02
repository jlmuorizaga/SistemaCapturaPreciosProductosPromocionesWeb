/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('#formInsertaTamanioPizza').submit(function (e) {
    e.preventDefault(); //Evita el comportamiento por default del submit
    var nombre = $.trim($("#nombre").val());
    if (nombre.length == "") {
        Swal.fire({
            type: 'warning',
            title: 'Tamaño de pizza no puede estar vacío',
            confirmButtonColor: '#a91e1e',
            //confirmButtonText: 'Intenta nuevamente'
        });
        return false; //con false no hace ningún tipo de envío
    } else {
        $.ajax({
            url: "tamanioPizzaController.do",
            type: "POST",
            datatype: "json",
            data: {nombre: nombre, accion: accion},
            success: function (data) {
                if (data == "null") {
                    Swal.fire({
                        type: 'error',
                        title: 'Usuario y/o contraseña incorrectos',
                        confirmButtonColor: '#a91e1e',
                        confirmButtonText: 'Intenta nuevamente'

                    })
                } else {
                    Swal.fire({
                        type: 'success',
                        title: '¡Conexión exitosa!',
                        confirmButtonColor: '#23804f',
                        confirmButtonText: 'Ingresar'
                    }).then((result) => {
                        if (result.value) {
                            window.location.href = "catalogotamaniopizza.jsp";
                        }
                    }
                    )

                }
            }
        });

    }
});
