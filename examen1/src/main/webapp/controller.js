const controller = {
    solveEquation: function() {
      const a = parseFloat(document.getElementById("coef-a").value);
      const b = parseFloat(document.getElementById("coef-b").value);
      const c = parseFloat(document.getElementById("coef-c").value);
  
      if (!isNaN(a) && !isNaN(b) && !isNaN(c)) {
        const result = model.solveEquation(a, b, c);
        view.displayResult(result);
      }
    }
  };
  