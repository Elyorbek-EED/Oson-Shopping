package payment_service.service;

import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import payment_service.criteria.CardCriteria;
import payment_service.dtos.CardCreateDTO;
import payment_service.dtos.CardDTO;
import payment_service.dtos.CardUpdateDTO;
import payment_service.mappers.CardMapper;
import payment_service.repository.CardRepository;
import payment_service.validator.CardValidator;

import java.util.List;

@Service
public class CardServiceImpl extends AbstractService<CardRepository, CardMapper, CardValidator>
implements CardService<
        CardDTO,
        CardCreateDTO,
        CardUpdateDTO,
        CardCriteria,
        Integer>{
    public CardServiceImpl(CardRepository repository, CardMapper mapper, CardValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<DataDTO<CardDTO>> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> block(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> unblock(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> update(CardUpdateDTO updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(CardCreateDTO createDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<List<CardDTO>>> getAll(CardCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<List<CardDTO>>> blockList(CardCriteria criteria) {
        return null;
    }
}
