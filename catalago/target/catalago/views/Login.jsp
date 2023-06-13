<!DOCTYPE html>
<html>
<head>
  <title>Iniciar sesión</title>
  <link rel="stylesheet" href="resources/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <h2>Iniciar sesión</h2>
    <form action="login.php" method="POST">
      <div class="form-group">
        <label for="username">Usuario:</label>
        <input type="text" class="form-control" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="password">Contraseña:</label>
        <input type="password" class="form-control" id="password" name="password" required>
      </div>
      <button type="submit" class="btn btn-primary">Ingresar</button>
    </form>
    <p>No tienes una cuenta? <a href="sign_in.html">Regístrate</a></p>
  </div>
</body>
</html>