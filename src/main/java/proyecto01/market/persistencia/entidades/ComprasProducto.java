package proyecto01.market.persistencia.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    //-- Para un "id" compuesto :
    @EmbeddedId
    private ComprasProductoPK id;
    // -- -- -- -- -- -- -- -- --
    private int cantidad;
    private double total;
    private boolean estado;
    
    // -----------------------
    // ----  Relaciones:  ----
    // -----------------------
    // 1) Relacionado con "Compra":
    @ManyToOne
    // "@MapsId" toma parte de la Clave Compuesta "ComprasProducto" (como "relacionCompra") y la vincula con la clave primaria de Compra (variable "idCompra"), asegurando que ambos IDs sean el mismo.
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra relacionCompra;
    
    // 2) Relacionado con "Producto":
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto relacionProducto;
    
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public ComprasProductoPK getId() { return id; }
    public void setId(ComprasProductoPK id) { this.id = id; }
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
    
    // --
    public Compra getRelacionCompra() {  return relacionCompra;  }
    public void setRelacionCompra(Compra relacionCompra) {  this.relacionCompra = relacionCompra;  }
    
    public Producto getRelacionProducto() {  return relacionProducto;  }
    public void setRelacionProducto(Producto relacionProducto) {  this.relacionProducto = relacionProducto;  }    
    
}
