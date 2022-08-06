package product_service.dtos.productImage;

import lombok.*;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageUpdateDTO extends GenericDTO {
    private Integer product_id;
    private String image_path;
}
