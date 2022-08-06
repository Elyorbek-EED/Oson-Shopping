package account_service.mapper.authUser;


import account_service.dtos.auth.AuthUserCreateDTO;
import account_service.dtos.auth.AuthUserDTO;
import account_service.dtos.auth.AuthUserUpdateDTO;
import account_service.entity.authUser.AuthUser;
import online_shop_jar.mapper.GenericMapper;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthUserMapper extends GenericMapper<AuthUserCreateDTO, AuthUserUpdateDTO,AuthUserDTO,AuthUser> {

    @Override
    AuthUserDTO toDTO(AuthUser entity);

    @Override
    AuthUser fromUpdateDTO(AuthUserUpdateDTO DTO);

    @Override
    List<AuthUserDTO> toListDTO(List<AuthUser> entity);

    @Override
    @Mappings(
            @Mapping(source = "dto.language", target = "language")
    )
    AuthUser fromCreateDTO(AuthUserCreateDTO dto);

    AuthUser fromUpdateDTO(AuthUserUpdateDTO DTO,@MappingTarget AuthUser authUser);
}
