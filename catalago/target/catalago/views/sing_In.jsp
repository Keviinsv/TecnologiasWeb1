<!DOCTYPE html>
<html>
<head>
  <title>Registro</title>
  <link rel="stylesheet" href="resources/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <h2>Registro</h2>
    <form action="register.php" method="POST">
      <div class="form-group">
        <label for="username">Nombre de usuario:</label>
        <input type="text" class="form-control" id="username" name="username" pattern="[A-Za-z]+" required>
      </div>
      <div class="form-group">
        <label for="type">Tipo de usuario:</label>
        <select class="form-control" id="type" name="type" required>
          <option value="0">Estudiante</option>
          <option value="1">Profesor</option>
        </select>
      </div>
      <div class="form-group">
        <label for="identifier">Identificador:</label>
        <input type="number" class="form-control" id="identifier" name="identifier" required>
      </div>
      <div class="form-group">
        <label for="password">Contraseña:</label>
        <input type="password" class="form-control" id="password" name="password" minlength="6" maxlength="12" pattern="(?=.*\d)(?=.*[@¡#$.:])[A-Za-z\d@¡#$.:]{6,12}" required>
      </div>
      <div class="form-group">
        <label for="career">Carrera:</label>
        <select class="form-control" id="career" name="career" required>
          <!-- Opciones de carreras desde la base de datos -->
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Registrar</button>
    </form>
  </div>
</body>
</html>