package order_service.enums.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum State {
    RECIEVED(""),
    ARRIVED("ARRIVED"),
    SEND("SEND");
    private String code;

    public static State getGender(String var_state){
        Optional<State> first = Arrays.stream(values()).filter(state -> state.code.equals(var_state.toUpperCase(Locale.ROOT))).findFirst();
        return first.get();
    }
}
