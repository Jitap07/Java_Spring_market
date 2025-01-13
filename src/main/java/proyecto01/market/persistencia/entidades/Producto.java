package proyecto01.market.persistencia.entidades;

import jakarta.persistence.*;

// import java.util.List;

@Entity
@Table(name = "productos")
public class Producto
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    // -- -- -- -- -- -- -- -- -- --
    private String nombre;
    // -- -- -- -- -- -- -- -- -- --
    @Column(name = "id_categoria")
    private int idCategoria;
    // -- -- -- -- -- -- -- -- -- --
    @Column(name = "codigo_barras")
    private String codigoBarras;
    // -- -- -- -- -- -- -- -- -- --
    @Column(name = "precio_venta")
    private double precioVenta;
    // -- -- -- -- -- -- -- -- -- --
    @Column(name = "cantidad_stock")
    private int cantidadStock;
    // -- -- -- -- -- -- -- -- -- --
    private boolean estado;
    
    // -----------------------
    // ----- Relaciones: -----
    // -----------------------
    // 1) Relacionado con "Categoria":
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria relacionCategoria;
    
    // 2) Relacionado con "ComprasProducto":
    // @OneToMany(mappedBy = "relacionProducto")
    // private List<ComprasProducto> listarComprasProductos;
    
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    
    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }
    
    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }
    
    public int getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
    
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
    
    // --
    public Categoria getRelacionCategoria() {  return relacionCategoria;  }
    public void setRelacionCategoria(Categoria relacionCategoria) {  this.relacionCategoria = relacionCategoria;  }
    
}
