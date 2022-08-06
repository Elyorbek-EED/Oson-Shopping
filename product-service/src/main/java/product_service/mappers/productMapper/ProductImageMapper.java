package product_service.mappers.productMapper;

import online_shop_jar.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import product_service.dtos.productImage.ProductImageCreateDTO;
import product_service.dtos.productImage.ProductImageDTO;
import product_service.dtos.productImage.ProductImageUpdateDTO;
import product_service.entity.product.ProductImage;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductImageMapper extends GenericMapper<
        ProductImageCreateDTO,
        ProductImageUpdateDTO,
        ProductImageDTO,
        ProductImage> {
    @Override
    ProductImage fromCreateDTO(ProductImageCreateDTO DTO);

    @Override
    ProductImage fromUpdateDTO(ProductImageUpdateDTO DTO);

    @Override
    ProductImageDTO toDTO(ProductImage entity);

    @Override
    List<ProductImageDTO> toListDTO(List<ProductImage> entity);
}
