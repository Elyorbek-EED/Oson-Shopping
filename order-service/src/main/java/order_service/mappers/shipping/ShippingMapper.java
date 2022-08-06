package order_service.mappers.shipping;

import online_shop_jar.mapper.GenericMapper;
import order_service.dtos.shipping.ShippingCreateDTO;
import order_service.dtos.shipping.ShippingDTO;
import order_service.dtos.shipping.ShippingUpdateDTO;
import order_service.entity.shipping.Shipping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ShippingMapper extends GenericMapper<ShippingCreateDTO, ShippingUpdateDTO, ShippingDTO, Shipping> {
}
