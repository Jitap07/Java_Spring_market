package proyecto01.market.persistencia.mapeadores;

import org.mapstruct.*;

import proyecto01.market.dominio.mapeadores.Product;
import proyecto01.market.persistencia.entidades.Producto;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper
{
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 1) Convirtiendo "Producto" (Entidad) a "Product" (Dominio): --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // No olvidar hacer los getters and setters a las variables, para que el "mapping" las identifique.
    @Mappings({
        @Mapping(source = "idProducto", target = "productId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "precioVenta", target = "price"),
        @Mapping(source = "cantidadStock", target = "stock"),
        @Mapping(source = "estado", target = "active"),
        @Mapping(source = "relacionCategoria", target = "categoryRelationship"),
    })
    Product toProduct(Producto Prdcto);
    // Ahora para una "Lista de Productos" (toProducts):
    List<Product> toListProducts(List<Producto> lstPrdctos);
    
    
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 2) Revirtiendo "Product" (Dominio) a "Producto" (Entidad) : --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // Si hubieran varios "@Mapping", se debe agregar "@Mappings", sino NO.
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product Prdct);
    
}
