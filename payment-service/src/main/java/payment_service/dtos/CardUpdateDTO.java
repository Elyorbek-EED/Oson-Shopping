package payment_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CardUpdateDTO extends GenericDTO {
    private String cardNumber;
    private int expirationMonthYear;
    private String name;
}
