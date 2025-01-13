package proyecto01.market.dominio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto01.market.dominio.mapeadores.Product;
import proyecto01.market.dominio.repositorio_mapper.ProductMapperRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    @Autowired
    private ProductMapperRepository ProdMP;
    
    // --------------------------------------------------------------------------------------------------
    // -- 1) Métodos que usan los Métodos Predeterminados "findAll", "findById", "save", "deleteById": --
    // --------------------------------------------------------------------------------------------------
    public List<Product> ListarProductosService()
    {  return ProdMP.ListarProductos();  }
    
    public Optional<Product> ProductoPorCodigoService(int productId)
    {  return ProdMP.ProductoPorCodigo(productId);  }
    
    public Product GuardarProductoService(Product Prdct)
    {  return ProdMP.GuardarProducto(Prdct);  }
    
    public boolean EliminarProductoService(int productId)
    {
        // -- Opcion:01 : --
        return ProductoPorCodigoService(productId).map(pdct -> {
                                                            ProdMP.EliminarProducto(productId);
                                                            return true;
                                                      })
                                                  .orElse(false);
        // -- Opcion_02 : --
    /*  if (ProductoPorCodigoService(productId).isPresent())
        {
            ProdMP.EliminarProducto(productId);
            return true;
        }
        else
        {  return false;  }  */
    }
    
    
    // -----------------------------------------------
    // -- 2) Métodos que usan los "Querys Methods": --
    // -----------------------------------------------
    public Optional<List<Product>> ProductosPorCategoriaService(int categoryId)
    {  return ProdMP.ProductosPorCategoria(categoryId);  }
    
}
