package proyecto01.market.persistencia.mapeadores;

import org.mapstruct.*;

import proyecto01.market.dominio.mapeadores.Category;
import proyecto01.market.persistencia.entidades.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper
{
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 1) Convirtiendo "Categoria" (Entidad) a "Category" (Dominio) : --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // No olvidar hacer los getters and setters a las variables, para que el "mapping" las identifique.
    @Mappings({
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "descripcion", target = "category"),
        @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria Ctgra);
    
    
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // -- 2) Revitiendo "Category" (Dominio) a "Categoria" (Entidad): --
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    // Si hubieran varios "@Mapping", se debe agregar "@Mappings", sino NO.
    @InheritInverseConfiguration
    @Mapping(target = "listaDeProductos", ignore = true)
    Categoria toCategoria(Category Ctgry);
    
}
