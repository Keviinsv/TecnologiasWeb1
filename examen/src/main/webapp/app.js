// MODELO
let sueldoTotal = 0;

// VISTA
const nombreInput = document.getElementById('nombre');
const sueldoInput = document.getElementById('sueldo');
const diasInput = document.getElementById('dias');
const resultadoDiv = document.getElementById('resultado');

// CONTROLADOR
class Controlador {
  constructor(modelo, vista) {
    this.modelo = modelo;
    this.vista = vista;
  }

  calcularSueldo() {
    const sueldo = parseFloat(sueldoInput.value);
    const dias = parseInt(diasInput.value);

    if (dias < 1 || dias > 15) {
      this.vista.mostrarError('La cantidad de días trabajados debe estar entre 1 y 15.');
    } else {
      this.modelo.calcularSueldoTotal(sueldo, dias);
      this.vista.mostrarSueldoTotal(nombreInput.value, this.modelo.sueldoTotal);
    }
  }
}

// VISTA
class Vista {
  constructor() {
    this.resultadoDiv = resultadoDiv;
  }

  mostrarSueldoTotal(nombre, sueldoTotal) {
    this.resultadoDiv.innerHTML = `El sueldo total de ${nombre} es: $${sueldoTotal.toFixed(2)}`;
  }

  mostrarError(mensaje) {
    this.resultadoDiv.innerHTML = `<span class="error">${mensaje}</span>`;
  }
}

// MODELO
class Modelo {
  constructor() {
    this.sueldoTotal = 0;
  }

  calcularSueldoTotal(sueldo, dias) {
    this.sueldoTotal = sueldo * dias;
  }
}

// INICIALIZACIÓN
const modelo = new Modelo();
const vista = new Vista();
const controlador = new Controlador(modelo, vista);

// EVENTOS
document.getElementById('calcular').addEventListener('click', () => {
  controlador.calcularSueldo();
});
