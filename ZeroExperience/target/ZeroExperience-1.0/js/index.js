$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });


});

function autenticarUsuario() {

    let username = $("#username").val();
    let clave_usuario= $("#clave_usuario").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            clave_usuario: clave_usuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario() {

    let username = $("#input-username").val();
    let clave_usuario = $("#input-clave_usuario").val();   
    let nombre_usuario = $("#input-nombre_usuario").val();
    let apellidos_usuario = $("#input-apellidos_usuario").val();
    let area_usuario = $("#input-area_usuario").val();


    if (clave_usuario == clave_usuario) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username: username,
                clave_usuario: clave_usuario,
                nombre_usuario: nombre_usuario,
                apellidos_usuario: apellidos_usuario,
                area_usuario: area_usuario
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}