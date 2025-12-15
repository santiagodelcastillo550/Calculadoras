function updateFromDecimal() {
  const dec = document.getElementById("decimal").value;
  if (!/^[0-9]*$/.test(dec)) return;
  const num = parseInt(dec, 10);
  if (isNaN(num)) return;
  document.getElementById("binario").value = num.toString(2);
  document.getElementById("hexadecimal").value = num.toString(16).toUpperCase();
  document.getElementById("octal").value = num.toString(8);
}

function updateFromBinario() {
  const bin = document.getElementById("binario").value;
  if (!/^[01]*$/.test(bin)) return;
  const num = parseInt(bin, 2);
  if (isNaN(num)) return;
  document.getElementById("decimal").value = num;
  document.getElementById("hexadecimal").value = num.toString(16).toUpperCase();
  document.getElementById("octal").value = num.toString(8);
}

function updateFromHexadecimal() {
  const hex = document.getElementById("hexadecimal").value;
  if (!/^[0-9A-Fa-f]*$/.test(hex)) return;
  const num = parseInt(hex, 16);
  if (isNaN(num)) return;
  document.getElementById("decimal").value = num;
  document.getElementById("binario").value = num.toString(2);
  document.getElementById("octal").value = num.toString(8);
}

function updateFromOctal() {
  const oct = document.getElementById("octal").value;
  if (!/^[0-7]*$/.test(oct)) return;
  const num = parseInt(oct, 8);
  if (isNaN(num)) return;
  document.getElementById("decimal").value = num;
  document.getElementById("binario").value = num.toString(2);
  document.getElementById("hexadecimal").value = num.toString(16).toUpperCase();
}

function copiar(id) {
  const valor = document.getElementById(id).value;
  navigator.clipboard.writeText(valor);
  alert("Valor copiado: " + valor);
}
