<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Пользователи</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    <meta name="theme-color" content="#7952b3">
    <sec:authentication var="user" property="principal"/>
     <style>
                     .block {
                         width: 30%;
                         padding: 20px;
                         float: left;
                     }

                     .container {
                         width: 70%;
                         padding: 20px;
                         float: right;
                     }


         </style>

</head>
<body class="text-center">

<%@include file="header_cabinet.jsp" %>

<div class="container">
    <table id="note-table" class="table">
        <thead>
        <tr>
            <th width="20%" class="text-center">Имя пользователя</th>
            <th width="20%" class="text-center">Фамилия пользователя</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

    <div class="block">

        <h1 class="h3 mb-3 fw-normal">Найти пользователя</h1>
    <form action="${pageContext.request.contextPath}/cabinet/users" method="post">
                    <div class="form-floating">
                        <input type="text" class="form-control" id="name" name="name" required>
                        <label for="floatingInput2">name</label>
                    </div>
                    <button class="w-100 btn btn-sm btn-outline-dark" type="submit">поиск</button>
                    </button>
                </form>

    </div>


<div hidden id="nameUser">${name}</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script>




                $(document).ready(function() {

                var name = $('#nameUser').html();
                        $.ajax({
                            url: '${pageContext.request.contextPath}/cabinet/users/'+ name,
                            type: 'get',
                            success: function(response) {
                                var len = response.length;
                                for (var i = 0; i < len; i++) {
                                    console.log(id);
                                    var id = response[i].id;
                                    var firstName = response[i].firstName;
                                    var lastName = response[i].lastName;
                                    var tr_str = "<tr>" +
                                        "<td class='id' hidden align='center'>" + id + "</td>" +
                                        "<td align='center'>" + firstName + "</td>" +
                                        "<td align='center'>" + lastName + "</td>" +
                                        "<td>" +
                                        "<button id = 'delete' type = 'button' " +
                                        "class = 'btn btn-outline-secondary btn-sm'>Удалить</button>" +
                                        "</td>" +
                                        "</tr>";
                                    $("#note-table tbody").append(tr_str);
                                }
                            }
                        });


                });


                $('table').on('click', '#delete', function() {
                    var rowEl = $(this).closest('tr');
                    var id = rowEl.find('.id').text();
                    var url = '${pageContext.request.contextPath}/cabinet/users/' + id;

                    $.ajax({
                        url: url,
                        type: 'delete',
                        statusCode: {
                            200: function() {
                                alert("Успешно удалено");
                                window.location.reload();
                            }
                        }
                    });
                });
</script>
</body>
</html>