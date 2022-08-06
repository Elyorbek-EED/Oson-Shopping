package product_service.dtos.productImage;

import lombok.*;
import online_shop_jar.dtos.Dto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductImageCreateDTO implements Dto {
    private Integer product_id;
    private String image_path;
}
