package online_shop_jar.exceptions;

import online_shop_jar.response.AppErrorDTO;
import online_shop_jar.response.DataDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<DataDTO<AppErrorDTO>> badRequestException(BadRequestException e, WebRequest request) {
        return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.mainBuilder()
                .message(e.getMessage())
                .request(request)
                .status(HttpStatus.BAD_REQUEST)
                .build()), HttpStatus.OK);
    }

    @ExceptionHandler(value = {ValidException.class})
    public ResponseEntity<DataDTO<AppErrorDTO>> validException(ValidException e, WebRequest request) {
        return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.mainBuilder()
                .message(e.getMessage())
                .request(request)
                .status(HttpStatus.CONFLICT)
                .build()), HttpStatus.OK);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<DataDTO<AppErrorDTO>> notFoundException(NotFoundException e,WebRequest request) {
        return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.mainBuilder()
                .message(e.getMessage())
                .request(request)
                .status(HttpStatus.NOT_FOUND)
                .build()),HttpStatus.OK);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<DataDTO<AppErrorDTO>> exceptionHandler(RuntimeException e,WebRequest request) {
        return new ResponseEntity<>(new DataDTO<>( AppErrorDTO.mainBuilder()
                .message(e.getMessage())
                .request(request)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build()), HttpStatus.OK);
    }

//sql
}
