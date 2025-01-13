package proyecto01.market.persistencia.mapeadores;

import org.mapstruct.*;

import proyecto01.market.dominio.mapeadores.Purchase;
import proyecto01.market.persistencia.entidades.Compra;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper
{
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 1) Convirtiendo "Compras" (Entidad) a "Purchase" (Dominio): --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // No olvidar hacer los getters and setters a las variables, para que el "mapping" las identifique.
    @Mappings({
        @Mapping(source = "idCompra", target = "purchaseId"),
        @Mapping(source = "idCliente", target = "clientId"),
        @Mapping(source = "fecha", target = "date"),
        @Mapping(source = "medioPago", target = "paymentMethod"),
        @Mapping(source = "comentario", target = "comment"),
        @Mapping(source = "estado", target = "state"),
        @Mapping(source = "listaComprasProductos", target = "listPurchaseItem"),
    })
    Purchase toPurchase(Compra cmpra);
    // Ahora para una "Lista de Compras" (toPurchase):
    List<Purchase> toListPurchases(List<Compra> lstCmpras);
    
    
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 2) Revirtiendo "Purchase" (Dominio) a "Compras" (Entidad) : --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // Si hubieran varios "@Mapping", se debe agregar "@Mappings", sino NO.
    @InheritInverseConfiguration
    @Mapping(target = "relacionCliente", ignore = true)
    Compra toCompra(Purchase prchse);
    
}
