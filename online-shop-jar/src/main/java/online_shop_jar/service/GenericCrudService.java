package online_shop_jar.service;


import online_shop_jar.criteria.GenericCriteria;
import online_shop_jar.dtos.Dto;
import online_shop_jar.entity.BaseEntity;
import online_shop_jar.response.DataDTO;
import org.springframework.http.ResponseEntity;


import java.io.Serializable;


public interface GenericCrudService <
        E extends BaseEntity,
        D extends Dto,
        CD extends Dto,
        UD extends Dto,
        C extends GenericCriteria,
        K extends Serializable> extends GenericService<D,K,C>{

    ResponseEntity<DataDTO<K>> create(CD createDto);

    ResponseEntity<DataDTO<D>> update(UD updateDto);

    ResponseEntity<DataDTO<Void>> delete(K id);
}
