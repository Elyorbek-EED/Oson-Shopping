package product_service.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductCreateDTO implements Dto {

    private Integer category;

    @NotBlank(message = "Please enter your product name")
    @Size(min = 3, max = 20, message = "product name should be between 3 and 20")
    private String name;

    @NotBlank(message = "Please enter your product description")
    @Size(min = 3, max = 50, message = "product description should be between 3 and 50")
    private String description;

    @NotBlank(message = "Please enter your product price")
    private Double price;

}
