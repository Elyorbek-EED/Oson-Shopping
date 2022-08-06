package account_service.service.authUser;

import account_service.criteria.authUser.AuthUserCriteria;
import online_shop_jar.response.DataDTO;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface AuthUserService <D,
        CD,
        UD,
        C extends AuthUserCriteria,
        K extends Serializable> {

    ResponseEntity<DataDTO<D>> get(K id);

    ResponseEntity<DataDTO<Void>> block(K id);

    ResponseEntity<DataDTO<Void>> delete(K id);

    ResponseEntity<DataDTO<Void>> unblock(K id);

    ResponseEntity<DataDTO<Void>> update(UD updateDto);

    ResponseEntity<DataDTO<K>> create(CD createDto);

    ResponseEntity<DataDTO<List<D>>> getAll(C criteria);

    ResponseEntity<DataDTO<List<D>>> blockList(C criteria);
}
