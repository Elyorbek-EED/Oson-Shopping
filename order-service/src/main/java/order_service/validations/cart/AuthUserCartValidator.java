package order_service.validations.cart;

import order_service.dtos.cart.AuthUserCartCreateDTO;
import order_service.dtos.cart.AuthUserCartUpdateDTO;
import online_shop_jar.exceptions.ValidException;
import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;


@Component
public class AuthUserCartValidator extends AbstractValidator<AuthUserCartCreateDTO, AuthUserCartUpdateDTO,Integer> implements Validator {
    @Override
    public void validateKey(Integer id) throws ValidException {

    }

    @Override
    public void validOnCreate(AuthUserCartCreateDTO authUserCreateDTO) throws ValidException {

    }

    @Override
    public void validOnUpdate(AuthUserCartUpdateDTO cd) throws ValidException {

    }
}
