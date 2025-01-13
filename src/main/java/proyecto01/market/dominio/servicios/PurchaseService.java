package proyecto01.market.dominio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto01.market.dominio.mapeadores.Purchase;
import proyecto01.market.dominio.repositorio_mapper.PurchaseMapperRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService
{
    @Autowired
    private PurchaseMapperRepository PurchMR;
    
    // --------------------------------------------------------------------------------------------------
    // -- 1) Métodos que usan los Métodos Predeterminados "findAll", "findById", "save", "deleteById": --
    // --------------------------------------------------------------------------------------------------
    public List<Purchase> ListarComprasService()
    {  return PurchMR.ListarCompras();  }
    
    public Purchase GuardarCompraService(Purchase Prch)
    {  return PurchMR.GuardarCompra(Prch);  }
    
    
    // -----------------------------------------------
    // -- 2) Métodos que usan los "Querys Methods": --
    // -----------------------------------------------
    public Optional<List<Purchase>> ComprasPorClienteService(String clientId)
    {  return PurchMR.ComprasPorCliente(clientId);  }
    
}
