<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <meta name="theme-color" content="#7952b3">
    <title>Регистрации</title>
    <style>
        .block{
                         width: 30%;
                         padding: 20px;
                         float: left;
        }
    </style>
</head>
<body>
<%@include file="header_cabinet.jsp" %>

<div class="block">
    <c:choose>
        <c:when test="${requestScope.error}">
            <p style="color:black;">${requestScope.message}</p>
        </c:when>
        <c:otherwise>
            <h1 class="h3 mb-3 fw-normal">Зарегистрируйтесь</h1>
        </c:otherwise>
    </c:choose>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" placeholder="имя" name="firstName">
            <label for="floatingInput">Имя</label>
        </div>

        <div class="form-floating">
            <input type="text" class="form-control" id="floatingPassword" placeholder="фамилия" name="lastName" required>
            <label for="floatingPassword">фамилия</label>
        </div>

        <button class="w-100 btn btn-sm btn-outline-dark" type="submit">Регистрация</button>

    </form>
</div>
</body>
</html>
