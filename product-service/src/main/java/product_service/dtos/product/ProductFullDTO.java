package product_service.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductFullDTO extends GenericDTO {
    private String name;
    private String description;
    private Double price;
    private List<String> images;
    private List<String> colors;
}
