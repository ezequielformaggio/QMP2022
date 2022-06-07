package guardarropa;

import Prenda.Prenda;

public class quitarPrenda implements Sugerencia {
  private final Prenda prenda;
  private final Guardarropa guardarropa;

  public quitarPrenda(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  public void aceptar() {
    guardarropa.quitarPrenda(prenda);
  }

  public void deshacer() {
    guardarropa.agregarPrenda(prenda);
  }
}
