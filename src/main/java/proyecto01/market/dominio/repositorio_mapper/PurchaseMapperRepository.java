package proyecto01.market.dominio.repositorio_mapper;

import proyecto01.market.dominio.mapeadores.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseMapperRepository
{
    // -------------------------------------
    // -- Usando querys Predeterminados : --
    // -------------------------------------
    List<Purchase> ListarCompras();
    Purchase GuardarCompra(Purchase Purch);
    
    // -----------------------------
    // -- Usando "Query Method" : --
    // -----------------------------
    Optional<List<Purchase>> ComprasPorCliente(String clientId);
    
}
