package online_shop_jar.service;



import online_shop_jar.criteria.GenericCriteria;
import online_shop_jar.dtos.Dto;
import online_shop_jar.response.DataDTO;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericService <
        D extends Dto,
        K extends Serializable,
        C extends GenericCriteria> {

    ResponseEntity<DataDTO<List <D>>> getAll(C criteria);
    ResponseEntity<DataDTO<D>> get (K id);
}
