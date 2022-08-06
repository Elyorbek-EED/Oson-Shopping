package product_service.validations.productImage;

import online_shop_jar.exceptions.ValidException;
import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;
import product_service.dtos.productImage.ProductImageCreateDTO;
import product_service.dtos.productImage.ProductImageUpdateDTO;

@Component
public class ProductImageValidator extends AbstractValidator<ProductImageCreateDTO, ProductImageUpdateDTO, Long> implements Validator {


@Override
public void validateKey(Long id) throws ValidException {

        }

@Override
public void validOnCreate(ProductImageCreateDTO categoryCreateDTO) throws ValidException {

        }

@Override
public void validOnUpdate(ProductImageUpdateDTO cd) throws ValidException {

        }
        }
