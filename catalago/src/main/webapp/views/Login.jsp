<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="resources/styles.css">
    <script src="resources/md5.min.js"></script>
</head>
<body>
    <h1>Login</h1>
    <form action="loginController" method="POST">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>
