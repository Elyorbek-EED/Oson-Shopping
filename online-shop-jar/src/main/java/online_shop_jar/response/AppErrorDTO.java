package online_shop_jar.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppErrorDTO {
    private Timestamp timestamp;
    private Integer status;
    private String code;
    private String message;
    private String path;

    private WebRequest request;

    private int servletResponse;

    @Builder(builderMethodName = "mainBuilder")
    public AppErrorDTO(String message, WebRequest request,HttpStatus status){
        this(message,((ServletWebRequest)request).getRequest().getRequestURI(),status);
    }

    @Builder(builderMethodName = "thirdBuilder")
    public AppErrorDTO(String message, String path,HttpStatus status) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status.value();
        this.code = status.getReasonPhrase();
        this.message = message;
        this.path = path;
    }

    @Builder(builderMethodName = "firstBuilder")
    public AppErrorDTO(HttpStatus status, String message, String path, WebRequest request, int servletResponse) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status.value();
        this.code = status.getReasonPhrase();
        this.message = message;
        this.path = path;
        this.request = request;
        this.servletResponse = servletResponse;
    }

    @Builder(builderMethodName = "secondBuilder")
    public AppErrorDTO(HttpStatus status, String message, WebRequest request) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status.value();
        this.code = status.getReasonPhrase();
        this.message = message;
        this.path = ((ServletWebRequest) request).getRequest().getRequestURI();
    }



}
