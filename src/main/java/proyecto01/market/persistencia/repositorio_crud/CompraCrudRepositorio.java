package proyecto01.market.persistencia.repositorio_crud;

import org.springframework.data.repository.CrudRepository;

import proyecto01.market.persistencia.entidades.Compra;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepositorio extends CrudRepository <Compra, Integer>
{
    // ------------------------------------------------------------------------------------------------
    // -- 1) Los Métodos Predeterminados de "Spring Data JPA" (findAll, findById, save, deleteById), --
    // --    ya no se vuelven a definir aquí porque extienden de la clase "CrudRepositor" :          --
    // ------------------------------------------------------------------------------------------------
    
    
    // -------------------------------------------------------------------------------------------------------------------
    // -- 2) Definiendo los "Querys Methods", son consultas basadas en el nombre que le asignas al Método (en inglés),  --
    // --    "Spring Data JPA" analiza el nombre y genera la consulta SQL (siguiendo el patrón definido).               --
    // -------------------------------------------------------------------------------------------------------------------
    // 2.1) Compras Por Cliente :
    // "findByIdCliente", genera → SELECT * FROM Compra WHERE id_cliente = ?;
    Optional<List<Compra>> findByIdCliente(String idCliente);
    
}
