package order_service.dtos.shipping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingUpdateDTO extends GenericDTO {

    private Integer product;

    private Integer address;

    private String arrivalDuration;

    private String shippingPrice;
}
