package product_service.mappers.product;

import online_shop_jar.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import product_service.dtos.product.ProductCreateDTO;
import product_service.dtos.product.ProductDTO;
import product_service.dtos.product.ProductUpdateDTO;
import product_service.entity.product.Product;

import java.util.List;


@Component
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper extends GenericMapper<
        ProductCreateDTO,
        ProductUpdateDTO,
        ProductDTO,
        Product> {


    @Override
    @Mapping(target = "category",ignore = true)
    Product fromCreateDTO(ProductCreateDTO DTO);

    @Override
    @Mapping(target = "category",ignore = true)
    Product fromUpdateDTO(ProductUpdateDTO DTO);

    @Override
    @Mapping(target = "category",ignore = true)
    ProductDTO toDTO(Product entity);

    @Override
    List<ProductDTO> toListDTO(List<Product> entity);

    @Override
//   @Mappings({
//           @Mapping(target = "category",source = "category")
//   })
    @Mapping(target = "category",ignore = true)
    Product fromDTO(ProductDTO dto);
}
