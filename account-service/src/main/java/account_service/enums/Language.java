package account_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import online_shop_jar.exceptions.NotFoundException;

import java.util.Arrays;
import java.util.Locale;



@Getter
@RequiredArgsConstructor

public enum Language {
    UZBEK("UZBEK"),
    ENGLISH("ENGLISH"),
    RUSSIAN("RUSSIAN");

    private final String code;


    public static Language getLanguage(String language){
        return Arrays.stream(values()).filter(lang -> lang.getCode().equals(language.toUpperCase(Locale.ROOT))).findFirst().orElseThrow(()->{
            throw new NotFoundException("Language not found");
        });
    }

}