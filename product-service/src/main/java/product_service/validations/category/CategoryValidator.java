package product_service.validations.category;


import online_shop_jar.validator.AbstractValidator;
import online_shop_jar.validator.Validator;
import org.springframework.stereotype.Component;
import product_service.dtos.category.CategoryCreateDTO;
import product_service.dtos.category.CategoryUpdateDTO;
import online_shop_jar.exceptions.ValidException;

@Component
public class CategoryValidator extends AbstractValidator<CategoryCreateDTO, CategoryUpdateDTO, Long> implements Validator {


    @Override
    public void validateKey(Long id) throws ValidException {

    }

    @Override
    public void validOnCreate(CategoryCreateDTO categoryCreateDTO) throws ValidException {

    }

    @Override
    public void validOnUpdate(CategoryUpdateDTO cd) throws ValidException {

    }
}
