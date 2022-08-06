package account_service.validation.authUser;

import account_service.dtos.auth.AuthUserCreateDTO;
import account_service.dtos.auth.AuthUserUpdateDTO;

import online_shop_jar.exceptions.ValidException;
import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;

@Component
public class AuthUserValidation extends AbstractValidator<AuthUserCreateDTO, AuthUserUpdateDTO, Integer> implements Validator {
    @Override
    public void validateKey(Integer id) throws ValidException {

    }

    @Override
    public void validOnCreate(AuthUserCreateDTO authUserCreateDTO) throws ValidException {

    }

    @Override
    public void validOnUpdate(AuthUserUpdateDTO cd) throws ValidException {

    }
}
