package order_service.services.cart;



import order_service.criteria.cart.AuthUserCartCriteria;
import order_service.dtos.AuthUserDTO;
import order_service.dtos.cart.AuthUserCartCreateDTO;
import order_service.dtos.cart.AuthUserCartDTO;
import order_service.dtos.cart.AuthUserCartUpdateDTO;

import order_service.entity.cart.AuthUserCart;
import order_service.mappers.cart.AuthUserCartMapper;
import order_service.repository.cart.AuthUserCartRepository;
import order_service.services.authUser.AuthUserService;
import order_service.services.product.ProductService;

import online_shop_jar.exceptions.NotFoundException;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import order_service.validations.cart.AuthUserCartValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthUserCartServiceImpl extends AbstractService<AuthUserCartRepository,
        AuthUserCartMapper,
        AuthUserCartValidator>
        implements AuthUserCartService<
        AuthUserCartDTO,
        AuthUserCartCreateDTO,
        AuthUserCartUpdateDTO,
        AuthUserCartCriteria,
        Integer>, BaseService {



    final ProductService service;
    final AuthUserService authUserService;

    @Autowired
    protected AuthUserCartServiceImpl(AuthUserCartRepository repository,
                                      AuthUserCartMapper mapper, AuthUserCartValidator validator, ProductService service, AuthUserService authUserService) {
        super(repository, mapper, validator);
        this.service = service;
        this.authUserService = authUserService;
    }

    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("AuthUserCart was not found by id %s".formatted(id));
        });

        repository.deleteById(id);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Integer>> create(AuthUserCartCreateDTO authUserCartCreateDto) {
        validator.validOnCreate(authUserCartCreateDto);
        AuthUserCart authUserCart = new AuthUserCart();
        authUserCart.setProduct(getProduct(authUserCartCreateDto.getProduct()));
        authUserCart.setCount(authUserCartCreateDto.getCount());
        authUserCart.setAuthUser(getAuthUser(authUserCartCreateDto.getUser()).getId());
        authUserCart.setProduct(getProduct(authUserCartCreateDto.getProduct()));
        AuthUserCart save = repository.save(authUserCart);
        return new ResponseEntity<>(new DataDTO<>(save.getId(), true), HttpStatus.OK);
    }


    private Integer getProduct(Integer product) {
      return   service.getProduct(product).getBody().getData().getId();
    }

    private AuthUserDTO getAuthUser(Integer authUser) {
        return authUserService.getAUthUser(authUser).getBody().getData();
    }

    @Override
    public ResponseEntity<DataDTO<List<AuthUserCartDTO>>> getAll(AuthUserCartCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        Page<AuthUserCart> all = repository.findAll(pageable);
        List<AuthUserCartDTO> authUserCartDTOS = mapper.toListDTO(all.stream().toList());

        return new ResponseEntity<>(new DataDTO<>(authUserCartDTOS, true), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<DataDTO<Void>> update(AuthUserCartUpdateDTO authUserCartUpdateDto) {
        AuthUserCart authUserCart = repository.findById(authUserCartUpdateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("AuthUserCart was not found by id %s".formatted(authUserCartUpdateDto.getId()));
        });
        if (authUserCartUpdateDto.getCount() != 0) {
            authUserCart.setCount(authUserCartUpdateDto.getCount());
        }
        authUserCart.setAuthUser(getAuthUser(authUserCartUpdateDto.getUser()).getId());
        authUserCart.setProduct(getProduct(authUserCartUpdateDto.getProduct()));
        repository.save(authUserCart);
        return new ResponseEntity<>(new DataDTO<>(true), HttpStatus.OK);
    }


    public ResponseEntity<DataDTO<AuthUserCartDTO>> get(Integer id) {
        AuthUserCart authUserCart = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("AuthUserCart was not found by id %s".formatted(id));
        });
        AuthUserCartDTO authUserCartDTO = mapper.toDTO(authUserCart);
        authUserCartDTO.setProduct(authUserCart.getProduct());
        authUserCartDTO.setUser(authUserCart.getAuthUser());
        return new ResponseEntity<>(new DataDTO<>(authUserCartDTO, true), HttpStatus.OK);
    }


}