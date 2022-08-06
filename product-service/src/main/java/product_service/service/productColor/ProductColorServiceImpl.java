package product_service.service.productColor;

import online_shop_jar.criteria.BaseCriteria;
import online_shop_jar.exceptions.NotFoundException;
import online_shop_jar.response.DataDTO;
import online_shop_jar.service.AbstractService;
import online_shop_jar.service.BaseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product_service.dtos.productColor.ProductColorCreateDTO;
import product_service.dtos.productColor.ProductColorDTO;
import product_service.dtos.productColor.ProductColorUpdateDTO;
import product_service.entity.color.Color;
import product_service.entity.product.Product;
import product_service.entity.product.ProductColor;
import product_service.mappers.productColor.ProductColorMapper;
import product_service.repository.productColor.ProductColorRepository;
import product_service.validations.productColor.ProductColorValidator;

import java.util.List;
import java.util.Objects;

@Service
public class ProductColorServiceImpl extends AbstractService<ProductColorRepository,
        ProductColorMapper,
        ProductColorValidator>
        implements BaseService, ProductColorService<
        ProductColorDTO,
        ProductColorCreateDTO,
        ProductColorUpdateDTO,
        BaseCriteria,
        Integer> {

    public ProductColorServiceImpl(ProductColorRepository repository, ProductColorMapper mapper, ProductColorValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public ResponseEntity<DataDTO<ProductColorDTO>> get(Integer id) {
        ProductColor productColor = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(id));
        });
        ProductColorDTO productColorDTO = mapper.toDTO(productColor);
        productColorDTO.setProduct(productColor.getProduct().getId());
        productColorDTO.setColor(productColor.getColor().getId());
        return new ResponseEntity<>(new DataDTO<>(productColorDTO, true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Void>> delete(Integer id) {
        ProductColor productColor = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(id));
        });
        repository.delete(productColor);
        return new ResponseEntity<>(new DataDTO<>( true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<Void>> update(ProductColorUpdateDTO updateDto) {
        ProductColor productColor = repository.findById(updateDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(updateDto.getId()));
        });
        if (Objects.nonNull(updateDto.getColor())){
            productColor.setColor(getColor(updateDto.getColor()));
        }
        if (Objects.nonNull(updateDto.getProduct())){
            productColor.setProduct(getProduct(updateDto.getProduct()));
        }
        repository.save(productColor);
        return new ResponseEntity<>(new DataDTO<>( true), HttpStatus.OK);
    }

    private Product getProduct(Integer product) {
       return repository.getProduct(product).orElseThrow(() -> {
            throw new NotFoundException("Product   was not found by id %s".formatted(product));
        });
    }

    private Color getColor(Integer color) {
       return repository.getColor(color).orElseThrow(() -> {
            throw new NotFoundException("Color   was not found by id %s".formatted(color));
        });
    }
    @Override
    public ResponseEntity<DataDTO<Integer>> create(ProductColorCreateDTO createDto) {
        validator.validOnCreate(createDto);
        ProductColor productColor = new ProductColor();
        productColor.setProduct(getProduct(createDto.getProduct()));
        productColor.setColor(getColor(createDto.getColor()));
        ProductColor save = repository.save(productColor);
        return new ResponseEntity<>(new DataDTO<>( save.getId(),true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataDTO<List<ProductColorDTO>>> getAll(BaseCriteria criteria) {
        Pageable pageable = PageRequest.of(criteria.getPage(), criteria.getSize());
        List<ProductColor> productColors = repository.findAll(pageable).toList();
        List<ProductColorDTO> productColorDTOS = mapper.toListDTO((productColors));
        return new ResponseEntity<>(new DataDTO<>(productColorDTOS, true), HttpStatus.OK);
    }
}
