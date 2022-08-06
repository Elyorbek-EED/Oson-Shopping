package order_service.entity.shipping;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.entity.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "shippings")
@Where(clause = "is_deleted is false")
public class Shipping extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer product;

    private Integer address;

    @Column(name = "arrival_duration")
    private LocalDateTime arrivalDuration;

    @Column(name = "shipping_price")
    private BigInteger shippingPrice;

}
