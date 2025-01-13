package proyecto01.market.persistencia.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int idCategoria;
    // -------------------------
    private String  descripcion;
    private boolean estado;
    
    // -----------------------
    // ----- Relaciones: -----
    // -----------------------
    // 1) Relacionado con "Producto":
    @OneToMany(mappedBy = "relacionCategoria")
    private List<Producto> listaDeProductos;
    
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
    
    // --
    public List<Producto> getListaDeProductos() {  return listaDeProductos;  }
    public void setListaDeProductos(List<Producto> listaDeProductos) {  this.listaDeProductos = listaDeProductos;  }
    
}
