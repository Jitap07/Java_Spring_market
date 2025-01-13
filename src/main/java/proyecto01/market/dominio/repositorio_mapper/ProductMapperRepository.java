package proyecto01.market.dominio.repositorio_mapper;

import proyecto01.market.dominio.mapeadores.Product;

import java.util.List;
import java.util.Optional;

public interface ProductMapperRepository
{
    // --------------------------------------------------------------------------------------------------
    // -- 1) Métodos que usan los Métodos Predeterminados "findAll", "findById", "save", "deleteById": --
    // --------------------------------------------------------------------------------------------------
    List<Product> ListarProductos();
    Optional<Product> ProductoPorCodigo(int productId);
    Product GuardarProducto (Product Prdct);
    void  EliminarProducto  (int productId);
    
    // -----------------------------------------------
    // -- 2) Métodos que usan los "Querys Methods": --
    // -----------------------------------------------
    Optional<List<Product>> ProductosPorCategoria(int categoryId);
    Optional<List<Product>> ProductosConBajoStock(int quantity); 
    
    // -------------------------------------------------------
    // -- 3) Métodos que usan los "Querys Personalizados" : --
    // -------------------------------------------------------
    Optional <List<Product>> ProductosCompradosPorId(int purchaseId);
}
