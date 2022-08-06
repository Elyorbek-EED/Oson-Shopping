package order_service.dtos.shipping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.Dto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingCreateDTO implements Dto {

    private Integer product;

    private Integer address;

    private String arrivalDuration;

    private String shippingPrice;
}
