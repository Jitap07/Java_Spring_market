package proyecto01.market.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import proyecto01.market.dominio.mapeadores.Product;
import proyecto01.market.dominio.servicios.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControlador
{
    @Autowired
    private ProductService PS;
    
    // --------------------------------------------------------------------------------------------------
    // -- 1) Métodos que usan los Métodos Predeterminados "findAll", "findById", "save", "deleteById": --
    // --------------------------------------------------------------------------------------------------
    // ResponseEntity -> Herramienta en "Spring" para las respuesta HTTP, que pueden ser personalizadas
    //                   (Cuerpo de la respuesta, Código de estado y Encabezado HTTP).
    @GetMapping("/ListarProductosControlador")
    @Operation(summary = "Obtiene el listado de todos los productos", description = "Devuelve una lista de todos los productos disponibles.")
    @ApiResponses
    ({
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "404", description = "No se encontraron Productos")
    })
    public ResponseEntity<List<Product>> ListarProductosControlador()
    {  return new ResponseEntity<>(PS.ListarProductosService(), HttpStatus.OK);  }
    
    
    // Usando ".map" para el tratamiento de "Optionals" (evitamos usar "if" y "else"):
    @GetMapping("/ProductoPorCodigoControlador/{ide}")
    @Operation(summary = "Busca un producto por su ID", description = "Devuelve los detalles de un producto específico según su ID.")
    public ResponseEntity<Product> ProductoPorCodigoControlador(@Parameter(description = "ID del producto", required = true, example = "7")
                                                                @PathVariable("ide") int productId)
    {
        return PS.ProductoPorCodigoService(productId).map(ppcs -> new ResponseEntity<>(ppcs, HttpStatus.OK))
                                                     .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/GuardarProductoControlador")
    @Operation(summary = "Guarda un nuevo producto", description = "Registra un nuevo producto en el sistema.")
    public ResponseEntity<Product> GuardarProductoControlador(@RequestBody Product Prdct)
    {  return new ResponseEntity<>(PS.GuardarProductoService(Prdct), HttpStatus.CREATED);  }
    
    
    @DeleteMapping("/EliminarProductoControlador/{idP}")
    @Operation(summary = "Elimina un producto", description = "Elimina un producto específico según su ID.")
    public ResponseEntity<Boolean> EliminarProductoControlador(@Parameter(description = "ID del producto a eliminar", required = true, example = "0") 
                                                               @PathVariable("idP") int productId)
    {
        if (PS.EliminarProductoService(productId))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    
    
    // -----------------------------------------------
    // -- 2) Métodos que usan los "Querys Methods": --
    // -----------------------------------------------
    // Usando ".map" para el tratamiento de "Optionals" (evitamos usar "if" y "else"):
    @GetMapping("/ProductosPorCategoriaControlador/{idC}")
    @Operation(summary = "Obtiene productos por categoría", description = "Devuelve una lista de productos que pertenecen a la categoría especificada.")
    public ResponseEntity<List<Product>> ProductosPorCategoriaControlador(@Parameter(description = "ID de la Categoría", required = false, example = "0")
                                                                          @PathVariable("idC") int categoryId)
    {
        return PS.ProductosPorCategoriaService(categoryId).map(pxcs -> new ResponseEntity<>(pxcs, HttpStatus.OK))
                                                          .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
}
