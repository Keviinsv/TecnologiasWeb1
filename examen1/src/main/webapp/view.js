const view = {
    equationForm: document.getElementById("equation-form"),
    resultContainer: document.getElementById("result-container"),
  
    init: function() {
      this.equationForm.addEventListener("submit", function(e) {
        e.preventDefault();
        controller.solveEquation();
      });
    },
  
    displayResult: function(result) {
      let html = "";
      if (result.message) {
        html = `<p>${result.message}</p>`;
      } else {
        html = `<p>x1 = <span>${result.x1}</span>, x2 = <span>${result.x2}</span></p>`;
      }
      this.resultContainer.innerHTML = html;
    }
  };
  
  view.init();
  