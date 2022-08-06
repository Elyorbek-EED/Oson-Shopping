package payment_service.mappers;

import online_shop_jar.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import payment_service.dtos.CardCreateDTO;
import payment_service.dtos.CardDTO;
import payment_service.dtos.CardUpdateDTO;
import payment_service.entity.Card;

@Component
@Mapper(componentModel = "spring")
public interface CardMapper extends GenericMapper<
        CardCreateDTO,
        CardUpdateDTO,
        CardDTO,
        Card> {
}
