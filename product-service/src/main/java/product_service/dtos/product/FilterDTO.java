package product_service.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.Dto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTO implements Dto {

    private Integer category;
    private Double maxPrice;
    private Double minPrice;
    private Integer color;
}

