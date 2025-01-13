package proyecto01.market.dominio.mapeadores;

// Las clases orientadas al dominio, se nombran en inglés y son usados para NO exponer directamente la Base.
// Se basan en las "entidades" creadas y no necesariamente se definen la misma cantidad de atributos.
// Los tipos de datos deben ser los mismos que las definidas en la "entidad".
public class PurchaseItem
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    private int productId;
    private int quantity;
    private double total;
    private boolean active;
    
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getProductId() {  return productId;  }
    public void setProductId(int productId) {  this.productId = productId;  }
    
    public int getQuantity() {  return quantity;  }
    public void setQuantity(int quantity) {  this.quantity = quantity;  }
    
    public double getTotal() {  return total;  }
    public void setTotal(double total) {  this.total = total;  }
    
    public boolean getActive() {  return active;  }
    public void setActive(boolean active) {  this.active = active;  }
    
}
