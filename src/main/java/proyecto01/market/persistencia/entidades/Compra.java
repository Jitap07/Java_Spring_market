package proyecto01.market.persistencia.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int idCompra;
    // -- -- -- -- -- -- -- -- --
    @Column(name = "id_cliente")
    private String  idCliente;
    // -- -- -- -- -- -- -- -- --
    private LocalDateTime fecha;
    // -- -- -- -- -- -- -- -- --
    @Column(name = "medio_pago")
    private String  medioPago;
    // -- -- -- -- -- -- -- -- --
    private String  comentario;
    private String  estado;
    
    // -----------------------
    // ----- Relaciones: -----
    // -----------------------
    // 1) Relacionado con "Cliente":
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente relacionCliente;
    
    // 2) Relacionado con "ComprasProducto",
    //    "cascade" permite guardar, eliminar ó actualizar la "Compra" y sus "Productos" a la vez:
    @OneToMany(mappedBy = "relacionCompra", cascade = {CascadeType.ALL})
    private List<ComprasProducto> listaComprasProductos;
    
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }
    
    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }
    
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    
    public String getMedioPago() { return medioPago; }
    public void setMedioPago(String medioPago) { this.medioPago = medioPago; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public String getEstado() {  return estado;  }
    public void setEstado(String estado) {  this.estado = estado;  }
    
    // --
    public Cliente getRelacionCliente() {  return relacionCliente;  }
    public void setRelacionCliente(Cliente relacionCliente) {  this.relacionCliente = relacionCliente;  }
    
    public List<ComprasProducto> getListaComprasProductos() {  return listaComprasProductos;  }
    public void setListaComprasProductos(List<ComprasProducto> listaComprasProductos) {  this.listaComprasProductos = listaComprasProductos;  }
    
}
