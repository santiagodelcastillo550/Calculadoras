// Unidades por categoría
const unidadesPorCategoria = {
  temperatura: ["celsius", "fahrenheit", "kelvin"],
  longitud: ["mm", "cm", "m", "km"],
  peso: ["g", "kg", "lb"],
  tiempo: ["min", "h", "d"],
  moneda: ["usd", "eur"]
};

// Nombres visibles
const nombresUnidad = {
  celsius: "Celsius",
  fahrenheit: "Fahrenheit",
  kelvin: "Kelvin",
  mm: "Milímetros",
  cm: "Centímetros",
  m: "Metros",
  km: "Kilómetros",
  g: "Gramos",
  kg: "Kilogramos",
  lb: "Libras",
  min: "Minutos",
  h: "Horas",
  d: "Días",
  usd: "USD",
  eur: "EUR"
};

// Tasa fija de ejemplo
const TASA_USD_EUR = 0.9;

// Poblado de unidades según categoría (con selección por defecto)
function actualizarUnidades() {
  const categoria = document.getElementById("categoria").value;
  const entradaSelect = document.getElementById("unidadEntrada");
  const salidaSelect = document.getElementById("unidadSalida");

  const unidades = unidadesPorCategoria[categoria] || [];

  // Vaciar y rellenar
  entradaSelect.innerHTML = "";
  salidaSelect.innerHTML = "";

  unidades.forEach(unidad => {
    const o1 = document.createElement("option");
    o1.value = unidad;
    o1.textContent = nombresUnidad[unidad];
    entradaSelect.appendChild(o1);

    const o2 = document.createElement("option");
    o2.value = unidad;
    o2.textContent = nombresUnidad[unidad];
    salidaSelect.appendChild(o2);
  });

  // Selecciones por defecto
  if (unidades.length > 0) {
    entradaSelect.value = unidades[0];
    salidaSelect.value = unidades.length > 1 ? unidades[1] : unidades[0];
  }
}

// Conversión y frase
function updateConversion() {
  const categoria = document.getElementById("categoria").value;
  const entradaStr = document.getElementById("entrada").value;
  const entrada = parseFloat(entradaStr);
  const unidadEntrada = document.getElementById("unidadEntrada").value;
  const unidadSalida = document.getElementById("unidadSalida").value;
  const salidaEl = document.getElementById("salida");
  const descripcion = document.getElementById("conversion-descripcion");

  // Guardas
  if (entradaStr === "" || isNaN(entrada) || !unidadEntrada || !unidadSalida) {
    salidaEl.value = "";
    descripcion.textContent = "";
    return;
  }

  let salidaNum = null;

  if (categoria === "longitud") {
    const factores = { mm: 1, cm: 10, m: 1000, km: 1000000 };
    if (!factores[unidadEntrada] || !factores[unidadSalida]) {
      salidaEl.value = "";
      descripcion.textContent = "";
      return;
    }
    const valorEnMm = entrada * factores[unidadEntrada];
    salidaNum = valorEnMm / factores[unidadSalida];
  } else if (categoria === "temperatura") {
    let valorC;
    if (unidadEntrada === "celsius") valorC = entrada;
    else if (unidadEntrada === "fahrenheit") valorC = (entrada - 32) * 5 / 9;
    else if (unidadEntrada === "kelvin") valorC = entrada - 273.15;
    else return limpiar();

    if (unidadSalida === "celsius") salidaNum = valorC;
    else if (unidadSalida === "fahrenheit") salidaNum = valorC * 9 / 5 + 32;
    else if (unidadSalida === "kelvin") salidaNum = valorC + 273.15;
    else return limpiar();
  } else if (categoria === "peso") {
    const factores = { g: 1, kg: 1000, lb: 453.59237 };
    if (!factores[unidadEntrada] || !factores[unidadSalida]) return limpiar();
    const valorEnG = entrada * factores[unidadEntrada];
    salidaNum = valorEnG / factores[unidadSalida];
  } else if (categoria === "tiempo") {
    const factores = { min: 1, h: 60, d: 1440 };
    if (!factores[unidadEntrada] || !factores[unidadSalida]) return limpiar();
    const valorEnMin = entrada * factores[unidadEntrada];
    salidaNum = valorEnMin / factores[unidadSalida];
  } else if (categoria === "moneda") {
    let valorUSD;
    if (unidadEntrada === "usd") valorUSD = entrada;
    else if (unidadEntrada === "eur") valorUSD = entrada / TASA_USD_EUR;
    else return limpiar();

    if (unidadSalida === "usd") salidaNum = valorUSD;
    else if (unidadSalida === "eur") salidaNum = valorUSD * TASA_USD_EUR;
    else return limpiar();
  } else {
    return limpiar();
  }

  if (salidaNum === null || Number.isNaN(salidaNum)) return limpiar();

  // Decimales por tipo
  let decimales = 3;
  if (categoria === "temperatura" || categoria === "moneda" || categoria === "tiempo") decimales = 2;

  salidaEl.value = salidaNum.toFixed(decimales);
  descripcion.textContent = `Convirtiendo de ${nombresUnidad[unidadEntrada]} a ${nombresUnidad[unidadSalida]}`;

  function limpiar() {
    salidaEl.value = "";
    descripcion.textContent = "";
  }
}

// Cambio de categoría desde HTML (onchange)
function onCategoryChange() {
  actualizarUnidades();
  updateConversion();
}

// Inicialización segura
window.addEventListener("DOMContentLoaded", () => {
  actualizarUnidades();
  updateConversion();

  document.getElementById("unidadEntrada").addEventListener("change", updateConversion);
  document.getElementById("unidadSalida").addEventListener("change", updateConversion);
  document.getElementById("entrada").addEventListener("input", updateConversion);
});
