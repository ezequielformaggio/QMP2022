package Prenda;

import static java.util.Objects.requireNonNull;

public class Prenda {

  private TipoPrenda tipo;
  private Material material;
  private Color color;
  private Color colorSecundario;
  private Trama trama;
  private double temperaturaMaxima;

  public Prenda( TipoPrenda tipo, Material material, Color color, Color colorSecundario, Trama trama, double temperaturaMaxima) {
    this.tipo = requireNonNull(tipo, "definir el tipo es obligatorio");
    this.material = requireNonNull(material, "definir el material es obligatorio");
    this.color = requireNonNull(color, "definir el color es obligatorio");
    this.colorSecundario = colorSecundario;
    if(trama == null) {
      this.trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
    this.temperaturaMaxima = temperaturaMaxima;
  }

  public Categoria getCategoria() {
    return tipo.getCategoria();
  }

  public boolean validarTemperatura(double temperatura) {
    return temperaturaMaxima > temperatura;
  }
}
