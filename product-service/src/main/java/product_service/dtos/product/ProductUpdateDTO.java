package product_service.dtos.product;

import lombok.*;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductUpdateDTO extends GenericDTO {

    private Integer category;
    private String name;
    private String description;
    private Double price;

    @Builder(builderMethodName = "forUnitTest")
    public ProductUpdateDTO( Integer id, Integer category, String name, String description, Double price) {
        super(id);
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
