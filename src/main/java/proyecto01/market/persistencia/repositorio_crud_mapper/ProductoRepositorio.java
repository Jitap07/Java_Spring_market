package proyecto01.market.persistencia.repositorio_crud_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto01.market.dominio.mapeadores.Product;
import proyecto01.market.dominio.repositorio_mapper.ProductMapperRepository;
import proyecto01.market.persistencia.entidades.Producto;
import proyecto01.market.persistencia.mapeadores.ProductMapper;
import proyecto01.market.persistencia.repositorio_crud.ProductoCrudRepositorio;

import java.util.List;
import java.util.Optional;

// Implementando los métodos de "ProductMapperRepository" (Dominio), utilizando los definidos en "ProductoCrudRepositorio" (Persistencia / repositorio_crud):
@Repository
public class ProductoRepositorio implements ProductMapperRepository
{
    // --------------------------------
    // -- Declaración de Variables : --
    // --------------------------------
    @Autowired  //"Spring" crea automáticamente las instancias de una clase, evitando crearla manualmente (new).
    private ProductoCrudRepositorio PCR;
    
    @Autowired
    private ProductMapper PM;
    
    
    // --------------------------------------------------------------------------------------------------------------------
    // -- 1) Implementacion de Métodos que usan los Métodos Predeterminados "findAll", "findById", "save", "deleteById": --
    // --------------------------------------------------------------------------------------------------------------------
    @Override
    public List<Product> ListarProductos()
    {
        // Utilizando los Métodos Predeterminados de "PCR" (ProductoCrudRepositorio):
        List<Producto> lprds = (List<Producto>) PCR.findAll();
        
        // Retornando "LISTA DE PRODUCTOS" Convertidos a "LIST PRODUCTS":
        return PM.toListProducts(lprds);
    }
    
    @Override
    public Optional <Product> ProductoPorCodigo (int productId)
    {
        // Utilizando los Métodos Predeterminados de "PCR" (ProductoCrudRepositorio),
        // El método ".map", se usa para el tratamiento de los "Optional < List<??> > ",
        // Convirtiendo una "LISTA DE PRODUCTOS" a "LIST PRODUCTS",
        // Retornando OPTIONAL "LISTA DE PRODUCTOS" Convertidos a OPTIONAL "LIST PRODUCTS":
        return PCR.findById(productId).map(pdt -> PM.toProduct(pdt));
    }
    
    @Override
    public Product GuardarProducto(Product Prdct)
    {
        // Convirtiendo "PRODUCT" (Prdct) a "PRODUCTO" (prdto):
        Producto prdto = PM.toProducto(Prdct);
        
        // Retornando "PRODUCTO" Convertido a "PRODUCT":
        return PM.toProduct(PCR.save(prdto));
    }
    
    @Override
    public void EliminarProducto(int ProductId)
    {   PCR.deleteById(ProductId);   }
    
    
    // ------------------------------------------------------------------
    // -- 2) Implementacion de métodos que usan los "Querys Methods" : --
    // ------------------------------------------------------------------
    // 2.1) Productos Por Categoria:
    @Override
    public Optional <List<Product>> ProductosPorCategoria(int categoryId)
    {
        // Utilizando "Querys Methods" definidos en "ProductoCrudRepositorio":
        List<Producto> lprds = PCR.findByIdCategoriaOrderByNombreAsc(categoryId);
        
        // El método "Optional.of", indica que será OPTIONAL,
        // Convirtiendo una "LISTA DE PRODUCTOS" a "LIST PRODUCTS",
        // Retornando "LISTA DE PRODUCTOS" Convertidos a OPTIONAL "LIST PRODUCTS":
        return Optional.of(PM.toListProducts(lprds));
    }
    
    // 2.2) Productos con Bajo Stock:
    @Override
    public Optional <List<Product>> ProductosConBajoStock (int quantity)
    {
        // Utilizando "Querys Methods" definidos en "ProductoCrudRepositorio":
        Optional<List<Producto>> lprds = PCR.findByCantidadStockLessThanAndEstado(quantity, true);
        
        // El método ".map", se usa para el tratamiento de los "Optional < List<??> > ",
        // Convirtiendo una "LISTA DE PRODUCTOS" a "LIST PRODUCTS",
        // Retornando OPTIONAL "LISTA DE PRODUCTOS" Convertidos a OPTIONAL "LIST PRODUCTS":
        return lprds.map(lpdts -> PM.toListProducts(lpdts));
    }
    
    
    // -------------------------------------------------------------------------
    // -- 3) Implementacion de métodos que usan los "Querys Personalizados" : --
    // -------------------------------------------------------------------------
    // 3.1) Productos adquiridos, por Núumero de Compra:
    @Override
    public Optional <List<Product>> ProductosCompradosPorId(int purchaseId)
    {
        // Utilizando "Querys Personalizados" definidos en "ProductoCrudRepositorio":
        Optional<List<Producto>> lprds = PCR.ProductosPorCompra(purchaseId);
        
        // El método ".map", se usa para el tratamiento de los "Optional < List<??> > ",
        // Convirtiendo una "LISTA DE PRODUCTOS" a "LIST PRODUCTS",
        // Retornando OPTIONAL "LISTA DE PRODUCTOS" Convertidos a OPTIONAL "LIST PRODUCTS":
        return lprds.map(lpdts -> PM.toListProducts(lpdts));
    }
    
}
