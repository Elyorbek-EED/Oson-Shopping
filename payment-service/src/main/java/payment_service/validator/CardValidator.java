package payment_service.validator;

import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;
import payment_service.dtos.CardCreateDTO;
import payment_service.dtos.CardUpdateDTO;

import javax.xml.bind.ValidationException;

@Component
public class CardValidator extends AbstractValidator<CardCreateDTO, CardUpdateDTO,Integer>implements Validator {
    @Override
    public void validateKey(Integer id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CardCreateDTO cardCreateDTO) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CardUpdateDTO cd) throws ValidationException {

    }
}
