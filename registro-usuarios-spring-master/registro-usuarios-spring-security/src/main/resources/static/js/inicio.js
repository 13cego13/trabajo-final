let animado = document.querySelectorAll(".animado");
let animado2 = document.querySelectorAll(".animado2");
let animado3 = document.querySelectorAll(".animado3");

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

function mostrarScroll3() {
    let scrollTop = document.documentElement.scrollTop;
    for (var i = 0; i < animado3.length; i++) {
      let alturaAnimado = animado3[i].offsetTop;
      if (alturaAnimado - 500 < scrollTop) {
        animado3[i].style.opacity = 1;
      }
    }
  }
window.addEventListener("scroll", mostrarScroll3);