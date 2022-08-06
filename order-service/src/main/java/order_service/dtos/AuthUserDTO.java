package order_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online_shop_jar.dtos.GenericDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthUserDTO extends GenericDTO {

    private String userName;
    private String phone;
    private String password;
    private String fullName;
    private String email;
    private String language;
    private String status;
    private String gender;
    private String role;

    public AuthUserDTO(Integer id, String userName, String phone, String password,
                       String fullName, String email, String language, String status, String gender, String role) {
        super(id);
        this.userName = userName;
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.language = language;
        this.status = status;
        this.gender = gender;
        this.role = role;
    }
}
