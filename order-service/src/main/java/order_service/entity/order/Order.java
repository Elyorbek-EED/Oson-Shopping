package order_service.entity.order;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.entity.Auditable;
import order_service.entity.shipping.Shipping;
import order_service.entity.cart.AuthUserCart;
import order_service.enums.state.State;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "orders")
@Where(clause = "is_deleted is false")
public class Order extends Auditable {

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_user_cart")
    private AuthUserCart cart;

    @Column(name = "accept", columnDefinition = "boolean default false")
    private Boolean accept;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_shipping")
    private Shipping shipping;

    @Enumerated(EnumType.STRING)
    private State state;

}
