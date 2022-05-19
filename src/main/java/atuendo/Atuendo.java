package atuendo;

import Prenda.Prenda;

import static java.util.Objects.requireNonNull;

public class Atuendo {

  private final Prenda parteSuperior;
  private final Prenda parteInferior;
  private final Prenda calzado;
  private final Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio) {
    this.parteSuperior = requireNonNull(parteSuperior, "parte superior es obligatorio");
    this.parteInferior = requireNonNull(parteInferior, "parte inferior es obligatorio");
    this.calzado = requireNonNull(calzado, "calzado es obligatorio");
    this.accesorio = accesorio;
  }

}
