package product_service.mappers.productColor;


import online_shop_jar.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import product_service.dtos.productColor.ProductColorCreateDTO;
import product_service.dtos.productColor.ProductColorDTO;
import product_service.dtos.productColor.ProductColorUpdateDTO;
import product_service.entity.product.ProductColor;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProductColorMapper extends GenericMapper<
        ProductColorCreateDTO,
        ProductColorUpdateDTO,
        ProductColorDTO,
        ProductColor> {


    @Override
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "color", ignore = true)
    ProductColorDTO toDTO(ProductColor entity);

    @Override
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "color", ignore = true)
    ProductColor fromCreateDTO(ProductColorCreateDTO DTO);

    @Override
//    @Mappings({@Mapping(target = "product.setProduct", source = "dto.product"),
//                    @Mapping(target = "color.setColor", source = "dto.color")}
//    )
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "color", ignore = true)
    ProductColor fromUpdateDTO(ProductColorUpdateDTO dto);

    @Override
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "color", ignore = true)
    ProductColor fromDTO(ProductColorDTO DTO);

    @Override
    List<ProductColorDTO> toListDTO(List<ProductColor> entity);
}
