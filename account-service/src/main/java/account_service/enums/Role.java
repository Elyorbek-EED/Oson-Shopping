package account_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public enum Role {
    SUPER_ADMIN("super_admin"),
    ADMIN("admin"),
    USER("user");

    private final String name;
}
