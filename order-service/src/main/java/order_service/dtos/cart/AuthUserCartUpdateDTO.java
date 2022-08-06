package order_service.dtos.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthUserCartUpdateDTO extends GenericDTO {

    private Integer user;
    private Integer product;
    private Integer count;

}
