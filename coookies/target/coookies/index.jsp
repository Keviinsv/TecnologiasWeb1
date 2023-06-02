<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post">
        <label for="username">Usuario:</label>
        <input type="text" name="username" id="username" required><br>

        <label for="password">Contraseña:</label>
        <input type="password" name="password" id="password" required><br>

        <label for="remember">Recordar datos:</label>
        <input type="checkbox" name="remember" id="remember"><br>

        <input type="submit" value="Iniciar sesión">
    </form>
</body>
</html>