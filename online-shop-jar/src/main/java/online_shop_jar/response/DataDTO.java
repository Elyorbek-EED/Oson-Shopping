package online_shop_jar.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDTO<T> implements Serializable {
protected T data;
protected AppErrorDTO errorDTO;
protected boolean success;

private Integer totalCount;

    public DataDTO(AppErrorDTO errorDTO) {
        this.errorDTO= errorDTO;
        this.success=false;
    }

    public DataDTO(boolean success) {
        this.success = success;
    }

    public DataDTO(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public DataDTO(T data) {
        this.data = data;
        this.success = true;
    }

}
