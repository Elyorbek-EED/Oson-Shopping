package account_service.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserUpdateDTO extends GenericDTO {

    private String userName;
    private String phone;

    private String fullName;

    private String email;

    private String language;
    private String gender;

    public AuthUserUpdateDTO( Integer id, String userName, String phone, String fullName, String email, String language, String gender) {
        super(id);
        this.userName = userName;
        this.phone = phone;
        this.fullName = fullName;
        this.email = email;
        this.language = language;
        this.gender = gender;
    }
}
