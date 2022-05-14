package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings(
            {
                    @Mapping(source = "idCategoria", target =
                    "categoryId"),
                    @Mapping(source = "descripcion", target = "description"),
                    @Mapping(source = "estado", target = "active"),
            }
    )

    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration //esta anotacion hace la conversion inversa
    @Mapping(target = "productos", ignore = true)//como esto le decimos que ignore la lista de productos
    Categoria toCategoria(Category category);
}
