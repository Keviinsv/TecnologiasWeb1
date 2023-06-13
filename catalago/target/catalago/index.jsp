<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio</title>
    <link rel="stylesheet" href="resources/styles.css">
</head>
<body>
    <h1>Bienvenido(a) al sistema</h1>
    
    <c:choose>
        <c:when test="${user.type == 0}">
            <h2>Opciones de estudiante</h2>
            <ul>
                <li><a href="#">Consultar catálogo de materias</a></li>
                <li><a href="#">Consultar/Actualizar perfil</a></li>
                <li><a href="#">Inscribirse</a></li>
            </ul>
        </c:when>
        <c:when test="${user.type == 1}">
            <h2>Opciones de profesor</h2>
            <ul>
                <li><a href="#">Consultar catálogo de materias</a></li>
                <li><a href="#">Consultar/Actualizar perfil</a></li>
            </ul>
        </c:when>
        <c:when test="${user.type == 2}">
            <h2>Opciones de administrador</h2>
            <ul>
                <li><a href="#">Crear/Editar/Eliminar carreras</a></li>
                <li><a href="#">Crear/Editar/Eliminar materias</a></li>
                <li><a href="#">Crear/Editar/Eliminar usuarios</a></li>
                <li><a href="#">Consultar/Actualizar perfil</a></li>
            </ul>
        </c:when>
        <c:otherwise>
            <p>No se encontró ningún tipo de usuario válido.</p>
        </c:otherwise>
    </c:choose>
    
    <div class="logout">
        <form action="logout" method="post">
            <input type="submit" value="Cerrar sesión">
        </form>
    </div>
</body>
</html>
