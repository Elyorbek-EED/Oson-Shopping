package product_service.dtos.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.Dto;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO implements Dto {
    private String name;
    private String path;
}