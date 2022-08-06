package order_service.mappers.cart;


import order_service.dtos.cart.AuthUserCartCreateDTO;
import order_service.dtos.cart.AuthUserCartDTO;
import order_service.dtos.cart.AuthUserCartUpdateDTO;
import online_shop_jar.mapper.GenericMapper;
import order_service.entity.cart.AuthUserCart;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserCartMapper extends GenericMapper<AuthUserCartCreateDTO, AuthUserCartUpdateDTO, AuthUserCartDTO, AuthUserCart> {
    @Override
    AuthUserCart fromCreateDTO(AuthUserCartCreateDTO DTO);

    @Override
    AuthUserCart fromUpdateDTO(AuthUserCartUpdateDTO DTO);

    @Override
    AuthUserCartDTO toDTO(AuthUserCart entity);

    @Override
    List<AuthUserCartDTO> toListDTO(List<AuthUserCart> entity);
}