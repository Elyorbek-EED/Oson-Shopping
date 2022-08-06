package order_service.validations.shipping;

import online_shop_jar.validator.AbstractValidator;
import order_service.dtos.shipping.ShippingCreateDTO;
import order_service.dtos.shipping.ShippingUpdateDTO;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class ShippingValidator extends AbstractValidator<ShippingCreateDTO, ShippingUpdateDTO, Integer> {
    @Override
    public void validateKey(Integer id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ShippingCreateDTO shippingCreateDTO) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ShippingUpdateDTO cd) throws ValidationException {

    }
}
