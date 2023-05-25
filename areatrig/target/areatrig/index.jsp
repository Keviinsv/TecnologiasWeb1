<!DOCTYPE html>
<html>
<head>
    <title>Calculadora de Area de Triangulo</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Calculadora de Area de Triangulo</h1>
    <div>
        <form action="/areatrig/servlets/CalcularServlet" method="get">
            <fieldset>
                <legend>Medidas del Triangulo</legend>
                <label for="base">Base:</label><br>
                <input type="number" name="base" required value="0" min="0" step="1"><br>

                <label for="altura">Altura:</label><br>
                <input type="number" name="altura" required value="1" min="1" step="1"><br>

                <label for="operation">Operacion:</label><br>
                <select name="operation">
                    <option value="AREA">Area</option>
                </select><br>

                <input type="submit" value="Calcular">
            </fieldset>
        </form>           
    </div>
</body>
</html>
