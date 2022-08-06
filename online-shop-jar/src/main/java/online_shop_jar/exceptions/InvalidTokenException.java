package online_shop_jar.exceptions;


public class InvalidTokenException  extends RuntimeException{


    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
