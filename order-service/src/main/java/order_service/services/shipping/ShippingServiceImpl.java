package order_service.services.shipping;

import online_shop_jar.criteria.GenericCriteria;
import online_shop_jar.dtos.Dto;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import order_service.criteria.shipping.ShippingCriteria;
import order_service.dtos.shipping.ShippingCreateDTO;
import order_service.dtos.shipping.ShippingDTO;
import order_service.dtos.shipping.ShippingUpdateDTO;
import order_service.mappers.shipping.ShippingMapper;
import order_service.repository.shipping.ShippingRepository;
import order_service.validations.shipping.ShippingValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ShippingServiceImpl extends AbstractService<ShippingRepository, ShippingMapper, ShippingValidator>
        implements ShippingService<
                ShippingDTO,
                ShippingCreateDTO,
                ShippingUpdateDTO,
                ShippingCriteria,
                Integer> {

    public ShippingServiceImpl(ShippingRepository repository, ShippingMapper mapper, ShippingValidator validator) {
        super(repository, mapper, validator);
    }


    @Override
    public ResponseEntity<DataDTO<ShippingDTO>> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> update(ShippingUpdateDTO updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(ShippingCreateDTO createDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<List<ShippingDTO>>> getAll(ShippingCriteria criteria) {
        return null;
    }
}
