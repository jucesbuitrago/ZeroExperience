var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {

        $("#mi-perfil-btn").attr("href", "profile.html?username=" + username);

        getAreas(false, "ASC");

        $("#ordenar-area").click(ordenarAreas);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getAreas(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAreaListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarAreas(parsedResult);
            } else {
                console.log("Error recuperando los datos de las areas");
            }
        }
    });
}
function mostrarAreas(areas) {

    let contenido = "";

    $.each(areas, function (index, area) {

        area = JSON.parse(area);

        contenido += '<tr><th scope="row">' + area.id + '</th>' +
                '<td>' + area.nombre_area + '</td>' +
                '<td>' + area.sueldo_area + '</td>';
        
        contenido += '>Reservar</button></td></tr>'

    }
    );
    $("#areas-tbody").html(contenido);
}

function ordenarAreas() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getAreas(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getAreas(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getAreas(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}

//function alquilarPelicula(id, precio) {
//
//    $.ajax({
//        type: "GET",
//        dataType: "html",
//        url: "./ServletPeliculaAlquilar",
//        data: $.param({
//            id: id,
//            username: username
//
//        }),
//        success: function (result) {
//            let parsedResult = JSON.parse(result);
//
//            if (parsedResult != false) {
//                restarDinero(precio).then(function () {
//                    location.reload();
//                })
//            } else {
//                console.log("Error en la reserva de la película");
//            }
//        }
//    });
//}


//async function restarDinero(precio) {
//
//    await $.ajax({
//        type: "GET",
//        dataType: "html",
//        url: "./ServletUsuarioRestarDinero",
//        data: $.param({
//            username: username,
//            saldo: parseFloat(user.saldo - precio)
//
//        }),
//        success: function (result) {
//            let parsedResult = JSON.parse(result);
//
//            if (parsedResult != false) {
//                console.log("Saldo actualizado");
//            } else {
//                console.log("Error en el proceso de pago");
//            }
//        }
//    });
//}