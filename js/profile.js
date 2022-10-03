var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {



        getAlquiladas(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-clave_usuario").val(parsedResult.clave_usuario);
                $("#input-nombre_usuario").val(parsedResult.nombre_usuario);
                $("#input-apellidos_usuario").val(parsedResult.apellidos_usuario);
                $("#input-area_usuario").val(parsedResult.area_usuario);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getAlquiladas(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletPruebaListar",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult);

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(areas) {
    let contenido = "";
    
    if (areas.length >= 1) {
        
        $.each(areas, function (index, area) {
            area = JSON.parse(area);

            contenido += '<tr><th scope="row">' + area.id + '</th>' +
                    '<td>' + area.username + '</td>' +
                    '<td>' + area.titulo_prueba + '</td>';

            contenido += '></td><td>' + area.fecha_prueba + '</td>' +
                    '<td>' + area.resultado_prueba + '</td>';
           
        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverPelicula(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletPeliculaDevolver",
        data: $.param({
            username: username,
            id: id,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el Pelicula");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let clave_usuario = $("#input-clave_usuario").val();
    let nombre_usuario = $("#input-nombre_usuario").val();
    let apellidos_usuario = $("#input-apellidos_usuario").val();
    let area_usuario = $("#input-area_usuario").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
            clave_usuario: clave_usuario,
            nombre_usuario: nombre_usuario,
            apellidos_usuario: apellidos_usuario,
            area_usuario: area_usuario,
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}

