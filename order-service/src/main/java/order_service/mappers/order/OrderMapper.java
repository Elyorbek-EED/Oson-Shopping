package order_service.mappers.order;

import online_shop_jar.mapper.GenericMapper;
import order_service.dtos.order.OrderCreateDTO;
import order_service.dtos.order.OrderDTO;
import order_service.dtos.order.OrderUpdateDTO;
import order_service.entity.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<OrderCreateDTO, OrderUpdateDTO, OrderDTO, Order> {
    @Override
    @Mapping(target = "shipping", ignore = true)
    @Mapping(target = "cart", ignore = true)
    Order fromCreateDTO(OrderCreateDTO DTO);

    @Override
    @Mapping(target = "shipping", ignore = true)
    @Mapping(target = "cart", ignore = true)
    OrderCreateDTO toCreateDTO(Order entity);

    @Override
    @Mapping(target = "shipping", ignore = true)
    @Mapping(target = "cart", ignore = true)
    Order fromUpdateDTO(OrderUpdateDTO DTO);

    @Override
    @Mapping(target = "shipping", ignore = true)
    @Mapping(target = "cart", ignore = true)
    OrderUpdateDTO toUpdateDTO(Order entity);

    @Override
    @Mapping(target = "shipping", ignore = true)
    @Mapping(target = "cart", ignore = true)
    Order fromDTO(OrderDTO DTO);

    @Override
    @Mapping(target = "shipping", ignore = true)
    @Mapping(target = "cart", ignore = true)
    OrderDTO toDTO(Order entity);
}
