package clima;

import atuendo.GeneradorDeAtuendo;

import java.util.List;
import java.util.Map;

public class ServicioMeteorologico {

  AccuWeatherApi apiClima = new AccuWeatherApi();

  private static final ServicioMeteorologico servicioMeteorologico = new ServicioMeteorologico();

  public static ServicioMeteorologico getInstance() {
    return servicioMeteorologico;
  }


  public Double getTemperatura(String ciudad) {
    List<Map<String, Object>> temperatura = apiClima.getWeather(ciudad);
    Double temperaturaFarenheit = (Double) temperatura.get(0).get("Value");
    return conversionACelcius(temperaturaFarenheit);
  }

  public Double conversionACelcius(Double temperaturaFarenheit) {
    return (temperaturaFarenheit - 32) * 5 / 9;
  }

  public List<String> getAlerta(String ciudad) {
    Map<String, Object> alertas = apiClima.getAlertas(ciudad);
    return (List<String>) alertas.get("CurrentAlerts");
  }


}