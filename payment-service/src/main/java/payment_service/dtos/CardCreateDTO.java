package payment_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.Dto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardCreateDTO implements Dto {
    private String cardNumber;
    private int expirationMonthYear;
    private String name;
}
