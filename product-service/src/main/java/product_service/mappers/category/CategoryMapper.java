package product_service.mappers.category;

import online_shop_jar.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import product_service.dtos.category.CategoryCreateDTO;
import product_service.dtos.category.CategoryDTO;
import product_service.dtos.category.CategoryUpdateDTO;
import product_service.entity.category.Category;

import java.util.List;


@Component
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper extends GenericMapper<  CategoryCreateDTO, CategoryUpdateDTO,CategoryDTO,Category> {

    @Override
    Category fromCreateDTO(CategoryCreateDTO DTO);

    @Override
    Category fromUpdateDTO(CategoryUpdateDTO DTO);
    Category fromUpdateDTO(CategoryUpdateDTO DTO,@MappingTarget Category category);

    @Override
    CategoryDTO toDTO(Category entity);

    @Override
    List<CategoryDTO> toListDTO(List<Category> entity);
}
