package order_service.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;
import order_service.enums.state.State;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTO extends GenericDTO {
    private Integer cart;
    private Boolean accept;
    private Integer shipping;
    private State state;
}
