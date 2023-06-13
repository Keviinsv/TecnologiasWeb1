<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="resources/styles.css">
    <script src="resources/md5.min.js"></script>
    <script>
        function encryptPassword() {
            var passwordInput = document.getElementById("password");
            var encryptedPasswordInput = document.getElementById("encryptedPassword");
            encryptedPasswordInput.value = md5(passwordInput.value);
        }
    </script>
</head>
<body>
    <h1>Sign In</h1>
    <form action="registrationController" method="POST">
        <input type="text" name="username" placeholder="Username" required><br>
        <input type="password" name="password" id="password" placeholder="Password" required><br>
        <input type="hidden" name="encryptedPassword" id="encryptedPassword">
        <button type="submit" onclick="encryptPassword()">Sign In</button>
    </form>
</body>
</html>
