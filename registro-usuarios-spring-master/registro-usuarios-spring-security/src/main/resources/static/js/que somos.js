let animado = document.querySelectorAll(".animado");
let animado2 = document.querySelectorAll(".animado2");

function mostrarScroll() {
  let scrollTop = document.documentElement.scrollTop;
  for (var i = 0; i < animado.length; i++) {
    let alturaAnimado = animado[i].offsetTop;
    if (alturaAnimado - 500 < scrollTop) {
      animado[i].style.opacity = 1;
      animado[i].classList.add("mostrarIzquierda");
         }
     }
}

window.addEventListener("scroll", mostrarScroll);

function mostrarScroll2() {
    let scrollTop = document.documentElement.scrollTop;
    for (var i = 0; i < animado2.length; i++) {
      let alturaAnimado = animado2[i].offsetTop;
      if (alturaAnimado - 500 < scrollTop) {
        animado2[i].style.opacity = 1;
        animado2[i].classList.add("mostrarDerecha");
        }
    }
}
window.addEventListener("scroll", mostrarScroll2);