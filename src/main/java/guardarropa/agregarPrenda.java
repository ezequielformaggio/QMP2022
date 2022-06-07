package guardarropa;

import Prenda.Prenda;

public class agregarPrenda implements Sugerencia {

  private final Prenda prenda;
  private final Guardarropa guardarropa;

  public agregarPrenda(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  public void aceptar() {
    guardarropa.agregarPrenda(prenda);
  }

  public void deshacer() {
    guardarropa.quitarPrenda(prenda);
  }
}
