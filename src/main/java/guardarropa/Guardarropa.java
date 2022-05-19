package guardarropa;

import atuendo.Atuendo;
import Prenda.Prenda;
import atuendo.GeneradorDeAtuendo;
import clima.ServicioMeteorologico;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {

  private List<Prenda> prendas = new ArrayList<>();
  private List<Atuendo> sugerencias;

  public Guardarropa(List<Prenda> prendas) {
    this.prendas = prendas;
  }

  public void sugerirAtuendo() {
    GeneradorDeAtuendo.getInstance().crearAtuendo(obtenerPrendasSegunClima());
  }

  public List<Prenda> obtenerPrendasSegunClima() {
    Double temperatura = ServicioMeteorologico.getInstance().getTemperatura("Buenos Aires, Argentina");
    return this.prendas
        .stream()
        .filter(prenda -> prenda.validarTemperatura(temperatura))
        .collect(Collectors.toList());
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public void agregarSugerencia(Atuendo atuendo) {
    sugerencias.add(atuendo);
  }

}
