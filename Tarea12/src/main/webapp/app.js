/* global fetch */

document.querySelector('#calculator-form').addEventListener('submit', function(event) {
	event.preventDefault();
	
	let form = event.target;
	let data = new FormData(form);
	
	fetch('CalculatorServlet', {
		method: 'POST',
		body: data
	})
	.then(response => response.text())
	.then(result => {
		document.querySelector('#result').innerHTML = result;
	})
	.catch(error => console.error(error));
});