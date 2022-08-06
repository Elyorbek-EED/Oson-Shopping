package account_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import online_shop_jar.exceptions.NotFoundException;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;



@Getter
@AllArgsConstructor
public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");


    private final String code;

    public static Gender getGender(String gender){
      return   Arrays.stream(values()).filter(gender1 -> gender1.getCode().equals(gender.toUpperCase(Locale.ROOT))).findFirst().orElseThrow(()->{
            throw new NotFoundException("Gender not found");
        });
    }

}
