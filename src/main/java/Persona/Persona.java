package Persona;

import guardarropa.Guardarropa;

import java.util.List;

public class Persona {

  private List<Guardarropa> guardarropas;

  public void agregarGuardarropa(Guardarropa guardarropa) {
    guardarropas.add(guardarropa);
  }

}
