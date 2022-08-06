package product_service.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDTO extends GenericDTO {

    private String name;
    private String code;
}
