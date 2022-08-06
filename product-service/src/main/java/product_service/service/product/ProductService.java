package product_service.service.product;

import online_shop_jar.criteria.GenericCriteria;
import online_shop_jar.dtos.Dto;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.BaseService;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;



public interface ProductService<D extends Dto,
        CD extends Dto,
        UD extends Dto,
        C extends GenericCriteria,
        K extends Serializable> extends BaseService {


    ResponseEntity<DataDTO<D>> get(K id);

    ResponseEntity<DataDTO<Void>> block(K id);

    ResponseEntity<DataDTO<Void>> delete(K id);

    ResponseEntity<DataDTO<Void>> unblock(K id);

    ResponseEntity<DataDTO<Void>> update(UD updateDto);

    ResponseEntity<DataDTO<K>> create(CD createDto);

    ResponseEntity<DataDTO<List<D>>> getAll(C criteria);

    ResponseEntity<DataDTO<List<D>>> blockList(C criteria);


}