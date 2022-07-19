let baseURI = 'http://localhost:8080/';

$(document).ready(function () {

    $("#permissionTemplate").hide();
    $("#permissionList").hide();

    $('#btnLogin').click(function (e) {
        e.preventDefault();

        $.get(baseURI + "users/name/" + $('#txtName').val(),
            function (user, textStatus, jqXHR) {

                $("#permissionList").empty();

                user.permissions.forEach(permission => {
                    
                    let permissionTemplate = $("#permissionTemplate").clone();

                    permissionTemplate.show();

                    permissionTemplate.find(".header")[0].innerText = permission.department.name;
                    permissionTemplate.find(".description")[0].innerText = permission.accessLevel;

                    permissionTemplate.appendTo("#permissionList");

                });

                $("#permissionList").transition('fade');
            },
            "json"
        );

    });

});