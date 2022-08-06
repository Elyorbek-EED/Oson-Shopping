package order_service.dtos.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.Dto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthUserCartCreateDTO implements Dto {
    private Integer user;
    private Integer product;
    private Integer count;
}
