package account_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Status {
    NOT_ACTIVE("Not active"),
    ACTIVE("Active"),
    BLOCK("Block");
    private final String code;

    public static  Status getStatus(String status){
        for (Status value : values()) {
            if (value.getCode().equalsIgnoreCase(status)){
                return value;
            }
        }
        return null;
    }
}
