package product_service.validations.product;

import online_shop_jar.exceptions.ValidException;
import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;
import product_service.dtos.product.ProductCreateDTO;
import product_service.dtos.product.ProductUpdateDTO;

@Component
public class ProductValidator extends AbstractValidator<ProductCreateDTO, ProductUpdateDTO, Long> implements Validator {


    @Override
    public void validateKey(Long id) throws ValidException {

    }

    @Override
    public void validOnCreate(ProductCreateDTO categoryCreateDTO) throws ValidException {

    }

    @Override
    public void validOnUpdate(ProductUpdateDTO cd) throws ValidException {

    }
}
