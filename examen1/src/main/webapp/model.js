const model = {
    solveEquation: function(a, b, c) {
      let discriminant = b ** 2 - 4 * a * c;
      let result = {};
  
      if (a === 0) {
        result.message = "El coeficiente a debe ser distinto de cero";
      } else if (discriminant < 0) {
        result.message = "La ecuación no tiene soluciones reales";
      } else {
        let x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        let x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        result.x1 = x1.toFixed(2);
        result.x2 = x2.toFixed(2);
      }
  
      return result;
    }
  };
  