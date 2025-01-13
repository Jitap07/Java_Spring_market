package proyecto01.market.dominio.mapeadores;

// Las clases orientadas al dominio, se nombran en inglés y son usados para NO exponer directamente la Base.
// Se basan en las "entidades" creadas y no necesariamente se definen la misma cantidad de atributos.
// Los tipos de datos deben ser los mismos que las definidas en la "entidad".
public class Category
{
    // -------------------------------
    // -- Declaracion de Variables: --
    // -------------------------------
    private int categoryId;
    private String category;
    private boolean active;
    
    // -------------------------------
    // ----- Getter and Setters: -----
    // -------------------------------
    public int getCategoryId() {  return categoryId;  }
    public void setCategoryId(int categoryId) {  this.categoryId = categoryId;  }
    
    public String getCategory() {  return category;  }
    public void setCategory(String category) {  this.category = category;  }
    
    public boolean isActive() {  return active;  }
    public void setActive(boolean active) {  this.active = active;  }
    
}
