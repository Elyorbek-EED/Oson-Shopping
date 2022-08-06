package billing_service.dtos.address;

import lombok.*;
import online_shop_jar.dtos.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AddressDTO extends GenericDTO {

    private String province;
    private String district;
    private String street;
    private String home;
    private boolean deleted;
}
