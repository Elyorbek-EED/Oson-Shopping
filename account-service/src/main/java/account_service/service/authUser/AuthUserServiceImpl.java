package account_service.service.authUser;

import account_service.criteria.authUser.AuthUserCriteria;
import account_service.dtos.auth.AuthUserCreateDTO;
import account_service.dtos.auth.AuthUserDTO;
import account_service.dtos.auth.AuthUserUpdateDTO;
import account_service.entity.authUser.AuthUser;
import account_service.enums.Gender;
import account_service.enums.Language;
import account_service.enums.Role;
import account_service.enums.Status;
import account_service.mapper.authUser.AuthUserMapper;
import account_service.repository.authUser.AuthUserRepository;
import account_service.validation.authUser.AuthUserValidation;
import online_shop_jar.exceptions.NotFoundException;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidation>
        implements AuthUserService<
        AuthUserDTO,
        AuthUserCreateDTO,
        AuthUserUpdateDTO,
        AuthUserCriteria,
        Integer>, BaseService {


    public AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, AuthUserValidation validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<DataDTO<AuthUserDTO>> get(Integer id) {
        AuthUser user = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("AuthUser was not found by id %s".formatted(id));
        });
        return new ResponseEntity<>(new DataDTO<>(mapper.toDTO(user), true), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(AuthUserCreateDTO dto) {
        validator.validOnCreate(dto);
        AuthUser user = mapper.fromCreateDTO(dto);
        if (dto.getLanguage() == null || dto.getLanguage().getCode().isBlank()) {
            user.setLanguage(Language.UZBEK);
        } else {
            user.setLanguage(Language.getLanguage(dto.getLanguage().getCode()));
        }
        user.setStatus(Status.NOT_ACTIVE);
        user.setRole(Role.USER);
        user.setGender(Gender.getGender(dto.getGender().getCode()));
//        user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity<>(new DataDTO<>(user.getId(), true), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DataDTO<Void>> update(AuthUserUpdateDTO dto) {
        validator.validOnUpdate(dto);
        AuthUser user = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new NotFoundException("AuthUser was not found by id %s".formatted(dto.getId()));
        });
        user = mapper.fromUpdateDTO(dto, user);
        if (!dto.getLanguage().isEmpty()) {
            user.setLanguage(Language.getLanguage(dto.getLanguage()));
        }
        if (!dto.getGender().isEmpty()) {
            user.setGender(Gender.getGender(dto.getGender()));
        }
        repository.save(user);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("AuthUser was not found by id %s".formatted(id));
        });

        repository.deleteById(id);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<List<AuthUserDTO>>> getAll(AuthUserCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        Page<AuthUser> all = repository.findAll(pageable);
        List<AuthUserDTO> authUserDTOS = mapper.toListDTO(all.stream().toList());
        return new ResponseEntity<>(new DataDTO<>(authUserDTOS,true), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<DataDTO<Void>> block(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> unblock(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<DataDTO<List<AuthUserDTO>>> blockList(AuthUserCriteria criteria) {
        return null;
    }

}
