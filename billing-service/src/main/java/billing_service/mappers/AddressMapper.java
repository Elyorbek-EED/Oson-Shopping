package billing_service.mappers;

import billing_service.dtos.address.AddressCreateDTO;
import billing_service.dtos.address.AddressDTO;
import billing_service.dtos.address.AddressUpdateDTO;
import billing_service.entity.address.Address;
import online_shop_jar.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AddressMapper extends GenericMapper<AddressCreateDTO, AddressUpdateDTO, AddressDTO, Address> {


    @Override
    @Mapping(ignore = true, target = "province")
     @Mapping(ignore = true, target = "district")
    @Mapping(ignore = true, target = "street")
    Address fromCreateDTO(AddressCreateDTO DTO);

    @Override
    @Mapping(ignore = true, target = "province")
     @Mapping(ignore = true, target = "district")
    @Mapping(ignore = true, target = "street")
    Address fromUpdateDTO(AddressUpdateDTO DTO);

    @Override
    @Mapping(ignore = true, target = "province")
     @Mapping(ignore = true, target = "district")
    @Mapping(ignore = true, target = "street")
    Address fromDTO(AddressDTO DTO);

    @Override
    @Mapping(ignore = true, target = "province")
     @Mapping(ignore = true, target = "district")
    @Mapping(ignore = true, target = "street")
    AddressDTO toDTO(Address entity);


}
