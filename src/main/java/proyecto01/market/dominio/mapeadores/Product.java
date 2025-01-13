package proyecto01.market.dominio.mapeadores;

// Las clases orientadas al dominio, se nombran en inglés y son usados para NO exponer directamente la Base.
// Se basan en las "entidades" creadas y no necesariamente se definen la misma cantidad de atributos.
// Los tipos de datos deben ser los mismos que las definidas en la "entidad".
// La variable "codigoBarras" no se incluye porque no es necesario para éste proyecto.
public class Product
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    
    // --------------------------
    // ----- Relationships: -----
    // --------------------------
    // 1) Related to "Category":
    private Category categoryRelationship;
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getProductId() {  return productId;  }
    public void setProductId(int productId) {  this.productId = productId;  }
    
    public String getName() {  return name;  }
    public void setName(String name) {  this.name = name;  }
    
    public int getCategoryId() {  return categoryId;  }
    public void setCategoryId(int categoryId) {  this.categoryId = categoryId;  }
    
    public double getPrice() {  return price;  }
    public void setPrice(double price) {  this.price = price;  }
    
    public int getStock() {  return stock;  }
    public void setStock(int stock) {  this.stock = stock;  }
    
    public boolean isActive() {  return active;  }
    public void setActive(boolean active) {  this.active = active;  }
    
    // --
    public Category getCategoryRelationship() {  return categoryRelationship;  }
    public void setCategoryRelationship(Category categoryRelationship) {  this.categoryRelationship = categoryRelationship;  }
    
}
