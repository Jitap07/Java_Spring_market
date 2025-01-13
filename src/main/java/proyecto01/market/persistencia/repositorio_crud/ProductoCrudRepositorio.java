package proyecto01.market.persistencia.repositorio_crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import proyecto01.market.persistencia.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepositorio extends CrudRepository <Producto, Integer> 
{
    // ------------------------------------------------------------------------------------------------
    // -- 1) Los Métodos Predeterminados de "Spring Data JPA" (findAll, findById, save, deleteById), --
    // --    ya no se vuelven a definir aquí porque extienden de la clase "CrudRepositor" :          --
    // ------------------------------------------------------------------------------------------------
    
    
    // -------------------------------------------------------------------------------------------------------------------
    // -- 2) Definiendo los "Querys Methods", son consultas basadas en el nombre que le asignas al Método (en inglés),  --
    // --    "Spring Data JPA" analiza el nombre y genera la consulta SQL (siguiendo el patrón definido).               --
    // -------------------------------------------------------------------------------------------------------------------
    // 2.1) Productos Por Categoria :
    // "findByIdCategoriaOrderByNombreAsc", genera → SELECT * FROM Producto WHERE id_Categoria = ? ORDER BY nombre ASC;
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    
    // 2.2) Productos con Bajo en Stock :
    // "findByCantidadStockLessThanAndEstado", genera → SELECT * FROM Producto WHERE cantidad_stock < ? AND estado = ?;
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    
    
    // -------------------------------------------------
    // -- 3) Definiendo los "Querys Personalizados" : --
    // -------------------------------------------------
    // 3.1) Productos Comprados, por Código de Compra:
    @Query (value = " SELECT P.id_producto, P.nombre, P.id_categoria, P.codigo_barras, P.precio_venta, P.cantidad_stock, P.estado " +
                    " FROM compras_productos CP, productos P " +
                    " WHERE CP.id_producto = P.id_producto " + 
                    " AND CP.id_compra = :idCompra " + 
                    " ORDER BY CP.id_compra ASC, P.codigo_barras ASC; ", nativeQuery = true)
    Optional<List<Producto>> ProductosPorCompra (@Param("idCompra") int idCompra);
    
}
