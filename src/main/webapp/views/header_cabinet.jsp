<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header>

    <style>
        .parent {
            margin: 10px;
        }
        body{
        	min-width: 320px;
        	font-size: 18px;
        	font-family: 'Playfair Display', serif;
        	color: #626262;
        }
        img{
        	max-width: 100%;
        	height: auto;
        }
        a{
        	color: #b4ad9e;
        }
        a:hover{
        	color: #898377;
        }

        header .navbar-light{
        	background-color: #fff;
        }
        header .navbar-brand{
        	font-family: 'Inconsolata', monospace;
        	font-size: 30px;
        	color: #000;
        	text-transform: uppercase;
        }
        header .nav-item{
        	text-transform: uppercase;
        	margin-left: 50px;
        }
        header .nav-item a::after{
        	content: '';
        	display: block;
        	width: 100%;
        	background-color: #ccc;
        	height: 1px;
        	transform: scale(0);
        	transition: all .3s;
        }
        header .nav-item a:hover::after{
        	transform: scale(1);
        }
    </style>


    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">User-API</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/registration">Регистрация пользователя</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/validation">Валидация</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet/users">Пользователи</a>
                    </li>
            </ul>
        </div>
    </nav>
 </header>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

