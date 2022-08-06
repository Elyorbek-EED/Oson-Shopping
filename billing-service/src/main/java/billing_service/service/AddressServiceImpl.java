package billing_service.service;

import billing_service.criteria.AddressCriteria;
import billing_service.dtos.address.AddressCreateDTO;
import billing_service.dtos.address.AddressDTO;
import billing_service.dtos.address.AddressUpdateDTO;
import billing_service.entity.address.Address;
import billing_service.mappers.AddressMapper;
import billing_service.repository.AddressRepository;
import billing_service.validations.AddressValidator;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends AbstractService<AddressRepository, AddressMapper, AddressValidator>
        implements AddressService<
        AddressDTO,
        AddressCreateDTO,
        AddressUpdateDTO,
        AddressCriteria,
        Integer>
        ,BaseService {
    public AddressServiceImpl(AddressRepository repository, AddressMapper mapper, AddressValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<DataDTO<AddressDTO>> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> update(AddressUpdateDTO updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(AddressCreateDTO createDto) {
        validator.validOnCreate(createDto);
        Address address = mapper.fromCreateDTO(createDto);


        return null;
    }

    @Override
    public ResponseEntity<DataDTO<List<AddressDTO>>> getAll(AddressCriteria criteria) {
        return null;
    }
}
