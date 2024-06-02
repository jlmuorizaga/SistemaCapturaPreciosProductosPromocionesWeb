/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('#formLogin').submit(function (e) {
    e.preventDefault(); //Evita el comportamiento por default del submit
    var usuario = $.trim($("#usuario").val());
    var contrasenia = $.trim($("#contrasenia").val());
    var sucursal = $.trim($("#sucursal").val());
    //alert(password.length);
    if (usuario.length == "" || contrasenia == "") {
        Swal.fire({
            type: 'warning',
            title: 'Debes ingresar un usario y una contraseña',
        });
        return false; //con false no hace ningún tipo de envío
    } else {
        $.ajax({
            url: "validaUsuario.do",
            type: "POST",
            datatype: "json",
            data: {usuario: usuario, contrasenia: contrasenia, sucursal: sucursal},
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
                            window.location.href = "menuppal.jsp";
                        }
                    }
                    )

                }
            }
        });

    }
});

