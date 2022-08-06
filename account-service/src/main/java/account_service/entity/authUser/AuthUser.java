package account_service.entity.authUser;

import account_service.enums.Gender;
import account_service.enums.Language;
import account_service.enums.Role;
import account_service.enums.Status;
import lombok.*;
import online_shop_jar.entity.Auditable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
@Where(clause = "is_deleted is false")
public class AuthUser extends Auditable {

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;



    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AuthUser other = (AuthUser) obj;
        return Objects.equals(id, other.getId());
    }

}
