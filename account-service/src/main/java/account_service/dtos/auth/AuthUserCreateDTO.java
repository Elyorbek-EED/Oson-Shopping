package account_service.dtos.auth;

import account_service.enums.Gender;
import account_service.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthUserCreateDTO implements Dto {

    @NotBlank(message = "Please enter your username")
    @Size(min = 3, max = 20, message = "username should be between 3 and 20")
    @Pattern(regexp = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")
    private String userName;

    @NotBlank(message = "Please enter your phone number")
    @Pattern(regexp = "(\\+998)\\d{9}", message = "Invalid phone")
    private String phone;

    @NotBlank(message = "Please enter your password")
    @Size(min = 6, max = 20, message = "password length should not be between 6 and 20 characters")
    private String password;

    @NotBlank(message = "Please enter your FullName")
    @Size(min = 3, max = 20, message = "FullName should be between 3 and 20")
    private String fullName;

    private Language language;


    @NotBlank
    @Size(max = 40, message = "email length should not be grater than 40 characters")
    @Email
    private String email;

    @NotBlank(message = "Please choose your gender")
    private Gender gender;

}
