function updateConversion() {
  const categoria = document.getElementById("categoria").value;
  const entrada = parseFloat(document.getElementById("entrada").value);
  const descripcion = document.getElementById("conversion-descripcion");

  if (isNaN(entrada)) {
    document.getElementById("salida").value = "";
    descripcion.textContent = "";
    return;
  }

  let salida = "";
  let texto = "";

  switch (categoria) {
    case "temperatura":
      salida = (entrada * 9/5 + 32).toFixed(2);
      texto = "Convirtiendo de Celsius a Fahrenheit";
      break;
    case "longitud":
      salida = (entrada / 100).toFixed(3);
      texto = "Convirtiendo de centímetros a metros";
      break;
    case "peso":
      salida = (entrada * 2.20462).toFixed(3);
      texto = "Convirtiendo de kilogramos a libras";
      break;
    case "tiempo":
      salida = (entrada / 60).toFixed(2);
      texto = "Convirtiendo de minutos a horas";
      break;
    case "moneda":
      const tasaUsdEur = 0.9;
      salida = (entrada * tasaUsdEur).toFixed(2);
      texto = "Convirtiendo de USD a EUR";
      break;
  }

  document.getElementById("salida").value = salida;
  descripcion.textContent = texto;
}
