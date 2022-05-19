package Prenda;

public class TipoPrenda {
  final Categoria categoria;

  public TipoPrenda( Categoria categoria ) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }
}

