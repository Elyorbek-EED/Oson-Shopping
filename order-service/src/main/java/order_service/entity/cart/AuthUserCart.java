package order_service.entity.cart;

import lombok.Getter;
import lombok.Setter;
import online_shop_jar.entity.Auditable;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "auth_user_cart")
@Where(clause = "is_deleted is false")
public class AuthUserCart extends Auditable {

    private Integer authUser;
    private Integer product;
    private Integer count;

}
