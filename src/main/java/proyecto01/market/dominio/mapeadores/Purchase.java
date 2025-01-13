package proyecto01.market.dominio.mapeadores;

import java.time.LocalDateTime;
import java.util.List;

// Las clases orientadas al dominio, se nombran en inglés y son usados para NO exponer directamente la Base.
// Se basan en las "entidades" creadas y no necesariamente se definen la misma cantidad de atributos.
// Los tipos de datos deben ser los mismos que las definidas en la "entidad".
public class Purchase
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    
    // --------------------------
    // ----- Relationships: -----
    // --------------------------
    // 1) Related to "PurchasesItem" ("ComprasProducto"):
    private List<PurchaseItem> listPurchaseItem;
    
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getPurchaseId() {  return purchaseId;  }
    public void setPurchaseId(int purchaseId) {  this.purchaseId = purchaseId;  }
    
    public String getClientId() {  return clientId;  }
    public void setClientId(String clientId) {  this.clientId = clientId;  }
    
    public LocalDateTime getDate() {  return date;  }
    public void setDate(LocalDateTime date) {  this.date = date;  }
    
    public String getPaymentMethod() {  return paymentMethod;  }
    public void setPaymentMethod(String paymentMethod) {  this.paymentMethod = paymentMethod;  }
    
    public String getComment() {  return comment;  }
    public void setComment(String comment) {  this.comment = comment;  }
    
    public String getState() {  return state;  }
    public void setState(String state) {  this.state = state;  }
    
    // --
    public List<PurchaseItem> getListPurchaseItem() {  return listPurchaseItem;  }
    public void setListPurchaseItem(List<PurchaseItem> listPurchaseItem) {  this.listPurchaseItem = listPurchaseItem;  }
    
}
