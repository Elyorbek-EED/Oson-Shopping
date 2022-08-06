package billing_service.dtos.address;

import lombok.*;
import online_shop_jar.dtos.Dto;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AddressCreateDTO implements Dto {

    private String province;
    private String district;
    private String street;
    private String home;
}
