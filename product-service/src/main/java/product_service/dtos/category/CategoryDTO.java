package product_service.dtos.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import online_shop_jar.dtos.Dto;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@Builder
public class CategoryDTO extends GenericDTO {
    private String code;
    private String name;
}
