package product_service.validations.productColor;


import online_shop_jar.exceptions.ValidException;
import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;
import product_service.dtos.productColor.ProductColorCreateDTO;
import product_service.dtos.productColor.ProductColorUpdateDTO;

@Component
public class ProductColorValidator extends AbstractValidator<ProductColorCreateDTO, ProductColorUpdateDTO, Long> implements Validator {


    @Override
    public void validateKey(Long id) throws ValidException {

    }

    @Override
    public void validOnCreate(ProductColorCreateDTO categoryCreateDTO) throws ValidException {

    }

    @Override
    public void validOnUpdate(ProductColorUpdateDTO cd) throws ValidException {

    }
}
