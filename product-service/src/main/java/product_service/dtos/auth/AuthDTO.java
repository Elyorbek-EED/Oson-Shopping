package product_service.dtos.auth;

import lombok.*;
import online_shop_jar.dtos.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthDTO implements Dto {

    @NotBlank(message = "Please enter your phone number")
    @Pattern(regexp = "(\\+998)\\d{9}",message = "Invalid message")
    private String phone;

    @NotBlank(message = "Please enter your password")
    @Size(min = 6, max = 20, message = "password length should not be between 6 and 20 characters")
    private String password;
}
