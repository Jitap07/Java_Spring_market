package proyecto01.market.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import proyecto01.market.dominio.mapeadores.Purchase;
import proyecto01.market.dominio.servicios.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseControlador
{
    @Autowired
    private PurchaseService PurchServ;
    
    // --------------------------------------------------------------------------------------------------
    // -- 1) Métodos que usan los Métodos Predeterminados "findAll", "findById", "save", "deleteById": --
    // --------------------------------------------------------------------------------------------------
    // ResponseEntity -> Herramienta en "Spring" para las respuesta HTTP, que pueden ser personalizadas
    //                   (Cuerpo de la respuesta, Código de estado y Encabezado HTTP).
    @GetMapping("/ListarComprasControlador")
    @Operation(summary = "Obtiene el listado de todas las compras", description = "Devuelve una lista de todas las compras realizadas.")
    @ApiResponses
    ({
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "404", description = "No se encontraron Compras")
    })
    public ResponseEntity<List<Purchase>> ListarComprasControlador()
    {  return new ResponseEntity<>(PurchServ.ListarComprasService(), HttpStatus.OK);  }
    
    
    @PostMapping("/GuardarCompraControlador")
    @Operation(summary = "Guarda nueva compra", description = "Registra una nueva compra en el sistema.")
    public ResponseEntity<Purchase> GuardarCompraControlador(@RequestBody Purchase Prchse)
    {  return new ResponseEntity<>(PurchServ.GuardarCompraService(Prchse), HttpStatus.CREATED);  }
    
    
    // -----------------------------------------------
    // -- 2) Métodos que usan los "Querys Methods": --
    // -----------------------------------------------
    // Usando ".map" para el tratamiento de "Optionals" (evitamos usar "if" y "else"):
    @GetMapping("/ComprasPorClienteControlador/{idCli}")
    @Operation(summary = "Obtiene compras por cliente", description = "Devuelve una lista de compras que pertenecen a un cliente especificado.")
    public ResponseEntity<List<Purchase>> ComprasPorClienteControlador(@Parameter(description = "ID del cliente", required = true, example = "0")
                                                                       @PathVariable("idCli") String clientId)
    {
        return PurchServ.ComprasPorClienteService(clientId).map(lstCmpras -> new ResponseEntity<>(lstCmpras, HttpStatus.OK))
                                                           .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
}
