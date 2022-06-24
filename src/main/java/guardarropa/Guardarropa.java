package guardarropa;

import Persona.Persona;
import atuendo.Atuendo;
import Prenda.Prenda;
import atuendo.GeneradorDeAtuendo;
import clima.ServicioMeteorologico;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {

  private List<Prenda> prendas = new ArrayList<>();
  private List<Atuendo> sugerenciasDeAtuendo = new ArrayList<>();
  private List<Sugerencia> sugerenciasDePrenda = new ArrayList<>();
  private List<Sugerencia> sugerenciasDePrendaAceptadas = new ArrayList<>();
  private List<Persona> personas = new ArrayList<>();
  private Atuendo sugerenciaDiaria;
  private Persona personaACargo;

  public Guardarropa(List<Prenda> prendas, Persona persona, List<Persona> personas) {
    this.personaACargo = persona;
    personaACargo.agregarGuardarropa(this);
    this.personas = personas;
    personas.forEach(_persona -> _persona.agregarGuardarropa(this));
    this.prendas = prendas;
  }

  public void generarSugerenciaDiaria() {
    sugerenciaDiaria = GeneradorDeAtuendo.getInstance().crearAtuendo(obtenerPrendasSegunClima());
  }

  public void sugerirAtuendo() {
    sugerenciasDeAtuendo.add(GeneradorDeAtuendo.getInstance().crearAtuendo(obtenerPrendasSegunClima()));
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

  public void comartirCon(Persona persona) {
    personas.add(persona);
    persona.agregarGuardarropa(this);
  }

  public void sugerirAgregarPrenda(Prenda prenda) {
    sugerenciasDePrenda.add(new agregarPrenda(prenda, this));
  }

  public void sugerirQuitarPrenda(Prenda prenda) {
    sugerenciasDePrenda.add(new quitarPrenda(prenda, this));
  }

  public void aceptarSugerenica(Sugerencia sugerencia) {
    sugerencia.aceptar();
    sugerenciasDePrendaAceptadas.add(sugerencia);
    sugerenciasDePrenda.remove(sugerencia);
  }

  public void rechazarSugerenica(Sugerencia sugerencia) {
    sugerenciasDePrenda.remove(sugerencia);
  }

  public void deshacerSugerencia(Sugerencia sugerencia) {
    sugerencia.deshacer();
    sugerenciasDePrenda.add(sugerencia);
    sugerenciasDePrendaAceptadas.remove(sugerencia);
  }

}
