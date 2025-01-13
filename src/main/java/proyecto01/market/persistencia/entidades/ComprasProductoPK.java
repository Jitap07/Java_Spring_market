package proyecto01.market.persistencia.entidades;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
public class ComprasProductoPK implements Serializable
{
    @Column(name = "id_compra")
    private int idCompra;
    // -- -- -- -- -- -- -- -- --
    @Column(name = "id_producto")
    private int idProducto;
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }
    
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    
}
