package product_service.dtos.category;

import lombok.*;
import online_shop_jar.dtos.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDTO implements Dto {

    @NotBlank(message = "Please enter your category name")
    @Size(min = 3, max = 20, message = "category name should be between 3 and 20")
    private String name;

    @NotBlank(message = "Please enter your unique category code")
    @Size(min = 3, max = 20, message = "category name should be between 3 and 20")
    private String code;
}

