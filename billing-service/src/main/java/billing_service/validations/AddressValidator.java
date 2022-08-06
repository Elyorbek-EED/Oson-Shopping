package billing_service.validations;

import billing_service.dtos.address.AddressCreateDTO;
import billing_service.dtos.address.AddressUpdateDTO;
import online_shop_jar.exceptions.ValidException;
import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class AddressValidator extends AbstractValidator<AddressCreateDTO, AddressUpdateDTO,Integer>implements Validator {
    @Override
    public void validateKey(Integer id) throws ValidException {

    }

    @Override
    public void validOnCreate(AddressCreateDTO addressCreateDTO) throws ValidException {

    }

    @Override
    public void validOnUpdate(AddressUpdateDTO cd) throws ValidException {

    }
}
