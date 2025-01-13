package proyecto01.market.persistencia.mapeadores;

import org.mapstruct.*;

import proyecto01.market.dominio.mapeadores.PurchaseItem;
import proyecto01.market.persistencia.entidades.ComprasProducto;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper
{
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 1) Convirtiendo "ComprasProducto" (Entidad) a "PurchaseItem" (Dominio): --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // No olvidar hacer los getters and setters a las variables, para que sean identificadas por el "mapping".
    @Mappings({
        @Mapping(source = "id.idProducto", target = "productId"),  // El "id" es una llave compuesta por: "idProducto" y "idCompra".
        @Mapping(source = "cantidad", target = "quantity"),
    //  @Mapping(source = "total", target = "total"),   // Ya NO agregar, porque tienen el mismo Nombre
        @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto CompProd);
    
    
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 2) Revirtiendo "PurchaseItem" (Dominio) a "ComprasProducto" (Entidad) : --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // Si hubieran varios "@Mapping", se debe agregar "@Mappings", sino NO.
    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "relacionCompra", ignore = true),
        @Mapping(target = "relacionProducto", ignore = true),
        @Mapping(target = "id.idCompra", ignore = true)     // El "id" es una llave compuesta por: "idProducto" y "idCompra".
    })
    ComprasProducto toComprasProducto(PurchaseItem PurcItm);
    
}
