package online_shop_jar.validator;

import javax.xml.bind.ValidationException;

public abstract class AbstractValidator<CD,UD,K> implements Validator{

    public abstract void validateKey(K id) throws ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException;

    public abstract void validOnUpdate(UD cd) throws ValidationException;
}
