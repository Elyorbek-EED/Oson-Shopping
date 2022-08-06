package order_service.validations.order;

import online_shop_jar.validator.AbstractValidator;
import order_service.dtos.order.OrderCreateDTO;
import order_service.dtos.order.OrderUpdateDTO;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class OrderValidator extends AbstractValidator<OrderCreateDTO, OrderUpdateDTO,Integer> {
    @Override
    public void validateKey(Integer id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrderCreateDTO orderCreateDTO) throws ValidationException {

    }

    @Override
    public void validOnUpdate(OrderUpdateDTO cd) throws ValidationException {

    }
}
