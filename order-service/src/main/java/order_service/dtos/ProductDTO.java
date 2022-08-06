package order_service.dtos;

import lombok.*;
import online_shop_jar.dtos.GenericDTO;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO extends GenericDTO {
    private Integer category;
    private String name;
    private String description;
    private Double price;
    private String status;



}
