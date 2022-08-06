package product_service.dtos.productColor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductColorUpdateDTO extends GenericDTO {
    private Integer color;
    private Integer product;
}