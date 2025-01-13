package proyecto01.market.persistencia.repositorio_crud_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto01.market.dominio.mapeadores.Purchase;
import proyecto01.market.dominio.repositorio_mapper.PurchaseMapperRepository;
import proyecto01.market.persistencia.entidades.Compra;
import proyecto01.market.persistencia.mapeadores.PurchaseMapper;
import proyecto01.market.persistencia.repositorio_crud.CompraCrudRepositorio;

import java.util.List;
import java.util.Optional;

// Implementando los métodos de "PurchaseMapperRepository" (Dominio), utilizando los definidos en "CompraCrudRepositorio" (Persistencia / repositorio_crud):
@Repository
public class CompraRepositorio implements PurchaseMapperRepository
{
    // --------------------------------
    // -- Declaración de Variables : --
    // --------------------------------
    @Autowired  //"Spring" crea automáticamente las instancias de una clase, evitando crearla manualmente (new).
    private CompraCrudRepositorio CCR;
    
    @Autowired
    private PurchaseMapper PurchMap;
    
    
    // --------------------------------------------------------------------------------------------------------------------
    // -- 1) Implementacion de Métodos que usan los Métodos Predeterminados "findAll", "findById", "save", "deleteById": --
    // --------------------------------------------------------------------------------------------------------------------
    @Override
    public List<Purchase> ListarCompras()
    {
        // Utilizando los Métodos Predeterminados de "PCR" (ComprasCrudRepositorio):
        List<Compra> lcmprs = (List<Compra>) CCR.findAll();
        
        // Retornando "LISTA DE COMPRAS" Convertidos a "LIST PURCHASES":
        return PurchMap.toListPurchases(lcmprs);
        
        // El resultado de "CCR.findAll()", lo Convierte a "Lista", luego "PurchMap.toListPurchases" lo convierte a "ListPurchases":
        //return PurchMap.toListPurchases((List<Compra>) CCR.findAll());
    }
    
    @Override
    public Purchase GuardarCompra(Purchase Prchse)
    {
        // Convierte "Purchase" a "Compra":
        Compra Cmpra = PurchMap.toCompra(Prchse);
        
        // Para asignar el ID generado de la Nueva Compra ("Cmpra") a cada "CompraProducto":
        // Sin ésta línea, los productos no sabrán a qué compra pertenecen (ID podría estar "null"), lo que indica que no habría una compra asociada.
        Cmpra.getListaComprasProductos().forEach(cmprprd -> cmprprd.setRelacionCompra(Cmpra));
        
        return PurchMap.toPurchase(CCR.save(Cmpra));
    }
    
    
    // ------------------------------------------------------------------
    // -- 2) Implementacion de métodos que usan los "Querys Methods" : --
    // ------------------------------------------------------------------
    // 2.1) Compras Por Cliente:
    @Override
    public Optional<List<Purchase>> ComprasPorCliente(String clientId)
    {
        // El resultado de "CCR.findByIdCliente(clientId)", lo convierte de "Lista" a "ListPurchases" (".map" es para el tratamiento de "Optionals"):
        return CCR.findByIdCliente(clientId).map(lstCmpras -> PurchMap.toListPurchases(lstCmpras));
    }
    
}
